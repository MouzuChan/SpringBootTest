package com.imooc.multithreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	 public static void main(String[] args) throws Exception {
	        Socket client = new Socket("localhost", 6789);
	        Scanner sc = new Scanner(System.in);
	        System.out.print("请输入内容: ");
	        String msg = sc.nextLine();
	        sc.close();
	        PrintWriter pw = new PrintWriter(client.getOutputStream());
	        System.out.println("將字符"+msg+"寫入到輸出流中");
	        pw.println(msg);
	        try {
	        	System.out.println("线程 "+ Thread.currentThread().getName()+"準備休眠5s");
	        	Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        pw.flush();
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
	        System.out.println(br.readLine());
	        client.close();
	    }
}
