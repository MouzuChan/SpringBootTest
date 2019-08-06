package com.imooc.multithreading;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class EchoServerNIO {
	
	private static final int ECHO_SERVER_PORT = 6789;
    private static final int ECHO_SERVER_TIMEOUT = 5000;
    private static final int BUFFER_SIZE = 1024;
 
    private static ServerSocketChannel serverChannel = null;
    private static Selector selector = null;    // 多路复用选择器
    private static ByteBuffer buffer = null;    // 缓冲区
 
    public static void main(String[] args) {
        init();
        listen();
    }
 
    private static void init() {
        try {
            serverChannel = ServerSocketChannel.open();
            buffer = ByteBuffer.allocate(BUFFER_SIZE);
            serverChannel.socket().bind(new InetSocketAddress(ECHO_SERVER_PORT));
            serverChannel.configureBlocking(false);
            selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("向serverChannel註冊了端口號為："+ECHO_SERVER_PORT+"多路複用器,并該多路複用器是可接受請求的");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
 
    private static void listen() {
        while (true) {
        	System.out.println("一直輪詢中。。。。。。。。。");
            try {
            	System.out.println("當前selector.select()的值："+(selector.select(ECHO_SERVER_TIMEOUT) != 0));
                if (selector.select(ECHO_SERVER_TIMEOUT) != 0) {
                	System.out.println("當前多路複用器註冊的數目為："+selector.selectedKeys().size());
                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        it.remove();
                        handleKey(key);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
 
    private static void handleKey(SelectionKey key) throws IOException {
        SocketChannel channel = null;
 
        try {
            if (key.isAcceptable()) {
                ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                channel = serverChannel.accept();
                channel.configureBlocking(false);
                channel.register(selector, SelectionKey.OP_READ);
                System.out.println("重新向serverChannel註冊了端口號為："+ECHO_SERVER_PORT+"多路複用器,并該多路複用器是可讀狀態的");
            } else if (key.isReadable()) {
                channel = (SocketChannel) key.channel();
                buffer.clear();
                if (channel.read(buffer) > 0) {
                    buffer.flip();
                    CharBuffer charBuffer = CharsetHelper.decode(buffer);
                    String msg = charBuffer.toString();
                    System.out.println("收到" + channel.getRemoteAddress() + "的消息：" + msg);
                    channel.write(CharsetHelper.encode(CharBuffer.wrap(msg)));
                } else {
                    channel.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (channel != null) {
                channel.close();
            }
        }
    }
}
