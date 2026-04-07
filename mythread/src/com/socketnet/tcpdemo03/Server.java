package com.socketnet.tcpdemo03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static void main(String[] args) throws IOException {

        // 1. ServerSocket
        ServerSocket ss = new ServerSocket(10086);

        Socket socket = ss.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\com\\socketnet\\tcpdemo03\\serverPhoto.png"));

        byte[] bytes = new byte[1024];

        int len;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }
        bos.close();

        // 回写
        String str = "上传成功";
        OutputStream os = socket.getOutputStream();
        os.write(str.getBytes());

        socket.close();
        ss.close();

    }
}
