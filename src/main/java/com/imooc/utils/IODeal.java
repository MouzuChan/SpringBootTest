package com.imooc.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IODeal {

	//工具类中的方法都是静态方式访问的因此将构造器私有不允许创建对象
	private IODeal() {
		throw new AssertionError();
	}
	
	//使用jaca7 TWR特性对于实现了Closeable接口的对象不需要关闭手动关闭资源
	public static void fileCopy(String source,String target) throws IOException{
		try(InputStream in = new FileInputStream(source)){
			try(OutputStream out = new FileOutputStream(target)){
				byte[] buffer  = new byte[4096];
				int byteToReads;
				while((byteToReads = in.read(buffer))!= -1) {
					out.write(buffer, 0, byteToReads);
				}
			}
		}
	}
	
	public static void fileCopyNIO(String source,String target) throws IOException{
		try(FileInputStream in = new FileInputStream(source)){
			try(FileOutputStream out = new FileOutputStream(target)){
				FileChannel inChannel = in.getChannel();
				FileChannel outChannel = out.getChannel();
				ByteBuffer buffer = ByteBuffer.allocate(4096);//申请4096字节缓冲
				while(inChannel.read(buffer)!=-1) {
					buffer.flip();//反转此缓冲区，设置当前位置指针为0，read读文件后文件指针在缓冲区末尾，需要使用flip重置
					outChannel.write(buffer);
					buffer.clear();//清空缓冲区
				}
			}
		}
	}
	
	private static int countWordInFile(String fileName, String word) {
		File someFile = new File(fileName);
		int counter = 0;
		try(InputStream fis = new FileInputStream(someFile);){
			try(InputStreamReader isr = new InputStreamReader(fis,"GBK")){
				try(BufferedReader br = new BufferedReader(isr)){
					String line = null;
					while((line = br.readLine())!=null) {
						System.out.println("字符串："+line);
						int index = -1;
						while(line.length()>=word.length() && (index=line.indexOf(word))>=0) {
							counter++;
							line = line.substring(index+word.length());
						}
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return counter;
	}
	
	public static void main(String[] args) throws IOException{
		long start = System.currentTimeMillis();
		/*IODeal.fileCopyNIO("D:\\学习资料\\spring boot\\workspace\\springBootTest\\test\\source.txt", 
				"D:\\学习资料\\spring boot\\workspace\\springBootTest\\test\\target.txt");*/
		int countWordInFile = IODeal.countWordInFile("D:\\学习资料\\spring boot\\workspace\\springBootTest\\test\\source.txt", "六");
		System.out.println("计数："+countWordInFile);
		long end = System.currentTimeMillis();
		System.out.println("耗时："+(end-start));
		
	}

}
