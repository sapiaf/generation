package org.java.inheritance.shop;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;


public class Carrello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Prodotto> carrello = new ArrayList<>();


        while (true) {
            System.out.println("Seleziona il tipo di prodotto:");
            System.out.println("1 - Prodotto generico");
            System.out.println("2 - Smartphone");
            System.out.println("3 - Televisori");
            System.out.println("4 - Cuffie");
            System.out.println("0 - Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            if (scelta == 0) {
                break;
            }

            System.out.println("Inserisci il nome del prodotto:");
            String nome = scanner.nextLine();

            System.out.println("Inserisci il brand del prodotto:");
            String brand = scanner.nextLine();

            System.out.println("Inserisci il prezzo del prodotto:");
            String priceStringInput = scanner.nextLine();
            BigDecimal prezzo = new BigDecimal(priceStringInput);

            System.out.println("Inserisci l'IVA (es. 0.22 per 22%):");
            String vatStringInput = scanner.nextLine();
            BigDecimal iva = new BigDecimal(vatStringInput);

            switch (scelta) {
                case 1: // Prodotto generico
                    Prodotto prodottoGenerico = new Prodotto(nome, brand, prezzo, iva);
                    carrello.add(prodottoGenerico);
                    break;
                case 2: // Smartphone
                    System.out.println("Inserisci l'IMEI:");
                    String imei = scanner.nextLine();

                    System.out.println("Inserisci la memoria:");
                    int memoria = scanner.nextInt();

                    Smartphone smartphone = new Smartphone(nome, brand, prezzo, iva, imei, memoria);
                    carrello.add(smartphone);
                    break;
                case 3: // Televisori
                    System.out.println("Inserisci la dimensione:");
                    int dimensione = scanner.nextInt();

                    System.out.println("Il televisore è smart? (true/false):");
                    boolean isSmart = scanner.nextBoolean();


                    Televisori televisori = new Televisori(nome, brand, prezzo, iva, dimensione, isSmart);
                    carrello.add(televisori);
                    break;
                case 4: // Cuffie
                    System.out.println("Inserisci il colore:");
                    String colore = scanner.nextLine();

                    System.out.println("Le cuffie sono wireless? (true/false):");
                    boolean isWireless = scanner.nextBoolean();

                    Cuffie cuffie = new Cuffie(nome, brand, prezzo, iva, colore, isWireless);
                    carrello.add(cuffie);
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }

        System.out.println("Hai una tessera fedeltà? (true/false):");
        boolean hasTesseraFedelta = scanner.nextBoolean();

        System.out.println("Totale carrello:");

        BigDecimal totaleCarrello = BigDecimal.ZERO;

        for (Prodotto prodotto : carrello) {
            BigDecimal prezzoScontato = prodotto.calcolaPrezzoScontato(hasTesseraFedelta);
            totaleCarrello = totaleCarrello.add(prezzoScontato);
            System.out.println(prodotto.getNome() + " - Prezzo scontato: " + prezzoScontato);
        }

        System.out.println("Totale: " + totaleCarrello);

        scanner.close();
    }
}
