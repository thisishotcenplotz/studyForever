package com.iamhotcenplotz.chapter19.outputstream_;

import java.io.*;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * binary file demo
 */
public class BufferedCopy02_ {
    public static void main(String[] args) throws IOException {
        String src = "./javaStudy.md";
        String dest = "./javaStudy2.txt";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try{
            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(dest));

            byte[] buf = new byte[1024];

            int readLen = 0;

            // 当返回-1时，表示文件读取完毕
            while((readLen = bis.read(buf)) != -1){
                bos.write(buf,0,readLen);
            }


        } catch (Exception e ){
            System.out.println(e.getMessage());
        } finally {
            if(bis != null) bis.close();
            if(bos != null) bos.close();
        }
    }
}
