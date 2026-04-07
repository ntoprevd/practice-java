package com.socketnet.demo;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SendMessageDemo {

    static void main(String[] args) throws IOException {

        // 1. 创建 Datagram对象，快递公司
        DatagramSocket ds = new DatagramSocket();

        // 2. 打包数据

        // 要发送的数据
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("请输入信息：");
            String str = sc.nextLine();

            if(str.equals("886")){
                break;
            }

            // 数据转换成二进制,
            byte[] bytes = str.getBytes();
            // 发送目标地址
            InetAddress address = InetAddress.getByName("127.0.0.1");
            // 发送目标端口
            int port = 10086;

            // para: byte[] (offset) length address port
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

            // 3. 发送数据
            ds.send(dp);
        }

        // 4. 释放资源
        ds.close();
    }
}
