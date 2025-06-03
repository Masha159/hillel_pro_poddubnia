package org.lessons.lesson33;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8081;

        try (Socket socket = new Socket(host, port)) {

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            output.println("Hello, Server!");
            output.println("string");
            output.println("exit");
            String response = input.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
