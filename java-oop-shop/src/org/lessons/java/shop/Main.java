package org.lessons.java.shop;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // CATEGORIE
        Categoria categoria1 = new Categoria("Smartphone", "Smartphone");
        Categoria categoria2 = new Categoria("Elettronica", "Elettronica");

        // ARRAYLIST
        ArrayList<Categoria> categorie = new ArrayList<>();
        categorie.add(categoria1);
        categorie.add(categoria2);

        // PRODOTTO
        Prodotto iPhone = new Prodotto( "iPhone 13", "Apple iPhone 13, 64GB, Space Gray", 799.99, 22, categorie);

        System.out.println(iPhone.prezzoNetto());
        System.out.println(iPhone.prezzoLordo());
        System.out.println(iPhone.nomeCompleto());
        System.out.println(iPhone);
        //

    }
}
