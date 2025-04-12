package com.iamhotcenplotz.chapter21.exercises_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 文件下载客户端
 */
public class Exercise03Client {


    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;

        while ((length = is.read(buffer)) != -1) {
            bos.write(buffer, 0, length);
        }

        byte[] array = bos.toByteArray();

        bos.close();
        return array;
    }

    public static void main(String[] args) throws IOException {
        // TODO:
        //  1. 接收用户指定下载文件名
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要下载的文件名");
        String userInput = scanner.nextLine();

        //TODO:
        // 2. 创建客户端并发送文件名
        Socket socket = new Socket(InetAddress.getByName("localhost"), 8888);
        OutputStream os = socket.getOutputStream();
        os.write(userInput.getBytes());
        socket.shutdownOutput(); // 设置结束标志。

        // TODO
        //  3. 接收返回字节数组
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] receiveBuffered = streamToByteArray(bis);

        // TODO
        //  4. 将收到的字节信息罗盘
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./receive" + userInput));
        bos.write(receiveBuffered);

        // TODO: release resource
        bos.close();
        bis.close();
        os.close();
        socket.close();


    }
}
