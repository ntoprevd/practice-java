package com.socketnet.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {

    static void main(String[] args) throws UnknownHostException {

        InetAddress address = InetAddress.getByName("utopian");
        String hostAddress = address.getHostAddress();
        String hostName = address.getHostName();
        System.out.println(hostName);
    }
}
