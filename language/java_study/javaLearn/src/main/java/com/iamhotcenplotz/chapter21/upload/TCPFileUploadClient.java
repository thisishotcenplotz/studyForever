package com.iamhotcenplotz.chapter21.upload;

import java.io.*;
import java.net.Socket;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class TCPFileUploadClient {
    public static void main(String[] args) throws IOException {

        // Client to 8888
        Socket socket = new Socket("localhost", 8888);

        //read image file from local to a byte[] using inputStream
        String filePath = "./hface.webp";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));

        // byte数组形式的文件内容
        byte[] imageBytes = StreamUtils.streamToByteArray(bufferedInputStream);

        // 发送图片的字节数组
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        // 发送并设置结束标志
        bufferedOutputStream.write(imageBytes);
        socket.shutdownOutput();

        // 获取图片回执
        InputStream inputStream = socket.getInputStream();
        String receipt = StreamUtils.streamToString(inputStream);
        System.out.println("Server response: " + receipt);

        // 释放资源
        inputStream.close();


        // 关闭
        bufferedInputStream.close();
        bufferedOutputStream.close();
        socket.close();





    }
}
