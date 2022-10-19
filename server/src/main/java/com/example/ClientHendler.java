package com.example;

import java.net.Socket;
import java.time.LocalDateTime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ClientHendler extends Thread {
    private Socket s;
    private static int numUtente = 0;
    private String nomeServer;

    public ClientHendler(Socket s, String nomeServer) {
        this.s = s;
        this.nomeServer = nomeServer;
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
            int id = numUtente;
            pr.println("Benvenuto: " + nome + " sei l'utente numero " + id);
            Boolean ciclo = true;
            String menu = "--Menu selezione-- @Digita 1 per vedere la data e ora  @Digita 2 per vedere in nome del server @Digita 3 per vedere il tuo id @Digita 0 per chiudere la connessione con il server";
            pr.println(menu);
            while (ciclo) {
                String riceve = br.readLine();
                int scelta = Integer.parseInt(riceve);
                switch (scelta) {
                    case 1:
                        LocalDateTime tempo = LocalDateTime.now();
                        pr.println("Data : " + tempo.getDayOfMonth() + "/" + tempo.getMonth() + "/" + tempo.getYear()
                                + " Ora: " + tempo.getHour() + ":" + tempo.getMinute() + ":" + tempo.getSecond());
                        break;
                    case 2:
                        pr.println(nomeServer);
                        break;
                    case 3:
                        pr.println(id);
                        break;
                    case 0:
                        pr.println("Arrivederci " + nome);
                        ciclo = false;
                        break;
                }
            }
            s.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
