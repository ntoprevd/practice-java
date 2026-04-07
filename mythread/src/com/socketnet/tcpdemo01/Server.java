package com.socketnet.tcpdemo01;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static void main(String[] args) throws IOException {

        // 1. 创建serverSocket对象，绑定端口
        ServerSocket ss = new ServerSocket(10086);

        // 2. 监听连接
        Socket socket = ss.accept();

        // 3. 从连接通道中获取输入流并转换成字符输入流
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());


        // 打印
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        // 4. 释放资源
        socket.close();
        ss.close();
    }
}
