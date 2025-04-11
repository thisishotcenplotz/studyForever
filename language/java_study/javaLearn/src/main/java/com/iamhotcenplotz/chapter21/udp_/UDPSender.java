package com.iamhotcenplotz.chapter21.udp_;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class UDPSender {
    public static void main(String[] args) throws IOException {

        // create DatagramSocket
        // the port should not be equal to the receiver since using localhost
        // Since DatagramSocket could be either sender or receiver, so that using another port will be good.
        DatagramSocket socket = new DatagramSocket(8888);

        // message preperation
        String rawMessage = "Hi, World ! Hotpot tomorrow?";
        byte[] packetMessage = rawMessage.getBytes(StandardCharsets.UTF_8);

        // send message
        DatagramPacket packet = new DatagramPacket(
            packetMessage,
            packetMessage.length,
            InetAddress.getByName("localhost"),
            9999
        );

        socket.send(packet);

        // get repley
        byte[] buffer = new byte[1024];
        DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(receivedPacket);

        // parse repley
        int length = receivedPacket.getLength();
        byte[] data = receivedPacket.getData();
        String s = new String(data, 0, length, StandardCharsets.UTF_8);
        System.out.println(s);

        // release resource
        socket.close();



    }
}
