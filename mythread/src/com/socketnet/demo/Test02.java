package com.socketnet.demo;

import java.io.IOException;
import java.net.*;

public class Test02 {

    static void main(String[] args) throws IOException {

        // 1. 创建 DatagramSocket 对象(快递公司)

        /*
        * port 端口
        * 有参：绑定此端口，从此端口发送数据
        * 无参：从可使用端口中任选一来发送
        * */
        DatagramSocket ds = new DatagramSocket();

        // 要发送的数据
        String str = "啊啊啊啊我被以UDP协议发送了";

        // 转换成二进制
        byte[] bytes = str.getBytes();

        // 目标地址以及端口
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10086;

        // 2. 打包数据(快递打包)
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

        // 3. 发送数据
        ds.send(dp);

        // 4. 释放资源
        ds.close();
    }
}
