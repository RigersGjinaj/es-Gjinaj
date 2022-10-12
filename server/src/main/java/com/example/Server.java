package com.example;

import java.net.ServerSocket;
import java.net.Socket;

public final class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3000);
            System.out.println("Server in ascolto sulla porta 3000");
            for (;;) {
                Socket s = ss.accept();
                System.out.println("Client connesso");
                ClientHendler c = new ClientHendler(s);
                c.start();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
