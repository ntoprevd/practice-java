package com.socketnet.tcpdemo02;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static void main(String[] args) throws IOException {

        // 1. ServerSocket
        ServerSocket ss = new ServerSocket(10086);

        // 2. 监听客户端
        Socket socket = ss.accept();

        // 3. InputStream
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());

        // print
        int b;
        while((b = isr.read()) != -1){
            System.out.print((char)b);
        }

        // (1) 回写数据
        // 从连接通道中获取输出流
        OutputStream os = socket.getOutputStream();
        String str = "有多开心？";
        os.write(str.getBytes());

        // 4. close
        socket.close();
        ss.close();
    }
}
