package com.iamhotcenplotz.chapter21.upload;

import java.io.*;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class StreamUtils {

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
}
