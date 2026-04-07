package com.socketnet.tcpdemo01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static void main(String[] args) throws IOException {

        // 1. 创建 Socket对象，尝试连接服务器
        // para: 目标IP地址，目标端口
        Socket socket = new Socket("127.0.0.1", 10086);

        // 2. 获取输出流对象
        OutputStream os = socket.getOutputStream(); // os: 咋这么难这么多

        // 键盘录入
        Scanner sc = new Scanner(System.in);
        // 多次发送
        while (true) {

            System.out.println("请输入信息：");
            String str = sc.nextLine();

            if("886".equals(str)){
                break;
            }

            os.write(str.getBytes());
        }

        // 3. 释放资源
        socket.close();
    }
}
