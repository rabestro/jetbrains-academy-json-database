package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Server started!");

        String address = "127.0.0.1";
        int port = 23456;
        ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(address));
        try (Socket socket = server.accept()) {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            var text = input.readUTF();
            System.out.println("Received: " + text);

            text = "A record # 12 was sent!";
            output.writeUTF(text);
            System.out.println("Sent: " + text);
        }

    }
}
