package com.socketnet.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    static void main(String[] args) throws IOException {

        // TCP协议，发送数据

        // 1. 创建 Socket对象
        // 创建对象的同时会连接服务端，连接不上会报错
        // 此处有TCP三次握手协议保证连接建立
        Socket socket = new Socket("127.0.0.1", 10086);

        // 2. 从连接通道中获取输出流
        OutputStream os = socket.getOutputStream();

        // 写出数据
        String str = "这是一条中文数据";
        os.write(str.getBytes());

        // 3. 释放资源
        os.close();

        // 此处四次挥手协议
        // 利用此协议断开连接，并保证连接通道里的数据已经处理完毕了
        socket.close();

    }
}
