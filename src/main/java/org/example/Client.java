package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws java.io.IOException {
        try (Socket clientSocket = new Socket("localhost", 8000);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println("Enter your name");
            String name = new Scanner(System.in).nextLine();
            out.println(name);
            String response = in.readLine();
            System.out.println(response);
        }
    }
}
