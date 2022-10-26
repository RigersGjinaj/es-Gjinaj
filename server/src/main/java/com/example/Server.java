package com.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public final class Server {
    private static String nomeServer = "serverGjinaj";
    private static ArrayList<ClientHendler> collegati = new ArrayList<ClientHendler>();

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3000);
            System.out.println("Server in ascolto sulla porta 3000");
            for (;;) {
                Socket s = ss.accept();
                System.out.println("Client connesso");
                ClientHendler c = new ClientHendler(s, nomeServer, collegati);
                collegati.add(c);
                c.start();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
