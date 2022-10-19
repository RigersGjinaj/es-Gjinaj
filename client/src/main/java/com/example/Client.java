package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public final class Client {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 3000);

        // per parlare
        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);

        // per ascoltare
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        // per la tastiera
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(br.readLine());
        pr.println(tastiera.readLine());
        System.out.println(br.readLine());
        s.close();
    }
}
