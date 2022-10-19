package com.example;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ClientHendler extends Thread {
    private Socket s;
    private static int numUtente = 0;

    public ClientHendler(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            // per parlare
            PrintWriter pr = new PrintWriter(s.getOutputStream(), true);

            // per ascoltare
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            pr.println("Ciao dimmi il tuo nome?");
            String nome = br.readLine();
            nome.toUpperCase();
            numUtente++;
            pr.println("Benvenuto: " + nome + "sei l'utente numero " + numUtente);
            s.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
