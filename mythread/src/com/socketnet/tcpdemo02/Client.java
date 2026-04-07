package com.socketnet.tcpdemo02;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    static void main(String[] args) throws IOException {

        // 1. Socket
        Socket socket = new Socket("127.0.0.1", 10086);

        // 2. OutputStream
        OutputStream os = socket.getOutputStream();

        // 3. write
        String str = "见到你很开心！";

        os.write(str.getBytes());

        // (1)半关闭连接，TCP PIN包
        socket.shutdownOutput();

        // (2) 从连接通道中获取输入流
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        // 4. close
        socket.close();
    }
}
