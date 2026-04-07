package com.socketnet.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static void main(String[] args) throws IOException {

        // TCP协议 接收数据

        // 1. 创建 ServerSocket对象
        // 与10086端口进行绑定
        ServerSocket ss = new ServerSocket(10086);

        // 2. 监听客户端的连接
        Socket socket = ss.accept();

        // 3. 从连接通道中获取输入流
        InputStream is = socket.getInputStream();

        // 字节输入流转换成字符输入流
        InputStreamReader isr = new InputStreamReader(is);
        // 字符输入流转换成字符缓冲流，利用readLine方法
        BufferedReader br = new BufferedReader(isr);

        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

        // 4. 释放资源
        is.close();
        ss.close();
    }
}
