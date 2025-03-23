package com.iamhotcenplotz.chapter19.outputstream_;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 *
 * 文件拷贝: 图片/音频/文本...
 */
public class FileCopy_ {
    public static void main(String[] args) throws IOException {
        // 1. 创建文件输入流，将文件读入到程序
        // 2. 创建文件的输出流，将读取到的文件数据写入到指定的位置

        String filePath = "./pom.xml";
        String outPath = "./xxx.txt";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            fileOutputStream = new FileOutputStream(outPath);

            // 定义一个字节数组，提高读取效率
            byte[] buffer = new byte[1024];
            int readLength = 0;

            // 边读边写
            while ((readLength = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, readLength);
            }



        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Done~~~");

            if(fileInputStream != null){
                fileInputStream.close();
            }

            if(fileOutputStream != null){
                fileOutputStream.close();
            }
        }


    }
}
