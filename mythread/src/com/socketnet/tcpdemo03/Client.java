package com.socketnet.tcpdemo03;

import java.io.*;
import java.net.Socket;

public class Client {

    static void main(String[] args) throws IOException {

        // 1. Socket对象，连接服务端
        Socket socket = new Socket("127.0.0.1", 10086);

        // 2. 获取本地文件数据
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src\\com\\socketnet\\tcpdemo03\\clientPhoto.png"));
        // 从连接通道中获取输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[1024];

        int len;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }

        // 输出流结束标记
        socket.shutdownOutput();
        
        // 接收服务器回写数据
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String str = br.readLine();
        System.out.println(str);

        br.close();
        socket.close();
    }
}
