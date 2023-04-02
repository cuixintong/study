package com.cui.maven.net.tcpudp;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {

    @Test
    public void client() {

        Socket socket = null;
        OutputStream ops = null;

        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8989);

            ops = socket.getOutputStream();
            ops.write("你好".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (ops != null) {
                    ops.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void server(){

        ServerSocket ss = null;
        InputStream ips = null;

        try {
            ss = new ServerSocket(8989);
            Socket accept = ss.accept();//阻塞式的方法
            ips = accept.getInputStream();

            int len;
            byte[] bytes = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();//内存中会有一个byte[]
            while ((len = ips.read(bytes)) != -1){
//                String s = new String(bytes, 0, len);
//                System.out.println(s); //容易出现乱码
                baos.write(bytes,0,len);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (ss != null){
                    ss.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (ips != null){
                    ips.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
