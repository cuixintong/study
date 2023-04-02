package com.cui.maven.net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetTest {

    @Test
    public void test(){
        InetAddress inet = null;
        try {
            inet = InetAddress.getByName("www.baidu.com");
            System.out.println(inet);


            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
            System.out.println(localHost.getHostName());
            System.out.println(localHost.getHostAddress());

            System.out.println(inet.getHostName());
            System.out.println(inet.getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
