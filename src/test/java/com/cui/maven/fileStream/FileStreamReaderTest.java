package com.cui.maven.fileStream;

import org.junit.Test;

import java.io.*;

public class FileStreamReaderTest {
    /**
     * 读入 I*/
    @Test
    public void test() throws IOException {

        FileReader  fileReader = null;
        try {
            File file = new File("hello.txt");

            if (!file.exists()){
                file.createNewFile();
            }

            fileReader = new FileReader(file);

//            int data;
//            while ((data = fileReader.read()) != -1) {
//                System.out.print((char) data);
//            }
            char[] chars = new char[16];//效率更高
            int len;
            while ((len = fileReader.read(chars)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i]);
                    fileReader.read(chars);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null){
                fileReader.close();
            }
        }
    }

    /**
     * 写出 O*/
    @Test
    public void test2(){

        FileWriter fw = null;

        try {
            File file = new File("hello1.txt");

            if (!file.exists()){
                file.createNewFile();
            }

            fw = new FileWriter(file,true);//true 表示不覆盖，追加内容
            fw.write("123");
            fw.append("adsd");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fw != null)
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**复制文件
     *
     */
    @Test
    public void test3(){

        FileReader fr = null;
        FileWriter fw = null;

        try {
            File file = new File("hello1.txt");
            File file1 = new File("D:\\hello.txt");

            fr = new FileReader(file);
            fw = new FileWriter(file1,true);

            int len;
            char[] chars = new char[16];
            while ((len = fr.read(chars)) != -1) {
                fw.write(chars,0,len);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        }

    }

    /**复制图片
     *
     */

    @Test
    public void test4(){

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File file = new File("1302546.jpg");
            File file1 = new File("1302546_copy.jpg");

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            int len;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes,0,len);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
