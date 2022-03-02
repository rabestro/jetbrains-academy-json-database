package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Client started!");
        var address = "127.0.0.1";
        var port = 23456;
        try (var socket = new Socket(InetAddress.getByName(address), port)) {
            var input = new DataInputStream(socket.getInputStream());
            var output = new DataOutputStream(socket.getOutputStream());

            var stringText = "Give me a record # 12";
            output.writeUTF(stringText);
            System.out.println("Sent: " + stringText);

            stringText = input.readUTF();
            System.out.println("Received: " + stringText);
        }
    }
}
