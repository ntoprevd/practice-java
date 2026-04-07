package com.socketnet.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveMessageDemo {

    static void main(String[] args) throws IOException {

        // 1. 创建DatagramSocket对象，快递公司
        DatagramSocket ds = new DatagramSocket(10086);

        // 2. 接收数据，包裹接收数据

        // 创建字节数组接收
        byte[] bytes = new byte[1024];

        // para: byte[] length
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        // 3. 解析数据
        while (true) {

            ds.receive(dp);
            String ip = dp.getAddress().getHostAddress();      // 发送端IP地址
            String name = dp.getAddress().getHostName();       // 发送端设备名
            int port = dp.getPort();                           // 发送端端口
            byte[] data = dp.getData();                        // 数据
            int len = dp.getLength();                          // 数据长度

            // 打印
            System.out.println("IP为" + ip + "的设备" + name + "经端口" + port + "发送: " + new String(data, 0, len));
        }

        // 4. 释放资源
    }
}
