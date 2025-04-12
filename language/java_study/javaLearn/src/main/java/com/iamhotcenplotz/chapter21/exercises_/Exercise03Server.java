package com.iamhotcenplotz.chapter21.exercises_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 文件下载服务端
 */

@SuppressWarnings({"all"})
public class Exercise03Server {


    // read string from a inputStream
    public static String readGivenInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        String msg = "";

        while((len = inputStream.read(buffer)) != -1){
            msg += new String(buffer, 0, len);
        }

        return msg;
    }

    public static boolean isFileExist(String filename) {
        File file = new File(filename);
        return file.exists();
    }

    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;

        while ((length = is.read(buffer)) != -1){
            bos.write(buffer,0,length);
        }

        byte[] array = bos.toByteArray();

        bos.close();
        return array;
    }

    public static String streamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line).append(System.lineSeparator());
        }
        return builder.toString();
    }


    public static void main(String[] args) throws IOException {
        // 1. 创建socket 监听 并 监听
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        // 2. 获取要下载的文件名并打印
        InputStream inputStream = socket.getInputStream();
        String fileName = readGivenInputStream(inputStream);
        System.out.println(fileName);

        // 3. 判断返回文件名并读取文件
        String responseName = "";
        if(isFileExist(fileName)){
            responseName = fileName;
        } else {
            responseName = "hface.webp";
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        byte[] responseBuffered = streamToByteArray(bis);

        // 4. 返回文件
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(responseBuffered);
        socket.shutdownOutput(); // 标记传输写入结束

        // end
        bos.close();
        bis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
