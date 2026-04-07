package com.socketnet.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Test03 {

    static void main(String[] args) throws IOException {

        // 快递公司
        // 接收数据端一定要写端口，而且是发送端指定的接收端口
        DatagramSocket ds = new DatagramSocket(10086);

        // 收快递包裹
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        ds.receive(dp);

        // 解析数据
        InetAddress address = dp.getAddress();
        int len = dp.getLength();
        byte[] data = dp.getData();
        int port = dp.getPort();

        System.out.println("IP为" + address + "的设备从端口" + port + "发送信息：" + new String(data, 0, len));

        // 释放资源
        ds.close();
    }
}
