package org.lessons.java.geometria;

public class Rettangolo {
    double base;
    double altezza;

    Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    double calcolaArea() {
        return base * altezza;
    }

    double calcolaPerimetro() {
        return 2 * (base + altezza);
    }

    void disegna() {
        System.out.println("Base: " + base);
        System.out.println("Altezza: " + altezza);
        System.out.println("Perimetro: " + calcolaPerimetro());
        System.out.println("Area: " + calcolaArea());

        String disegno = "";
        /*
        // PARTE SUPERIORE
        for (int i = 0; i < base; i++) {
            disegno += "* ";
        }
        disegno += "\n";

        // PARTE CENTRALE
        for (int i = 0; i < altezza - 2; i++) {
            for (int j = 0; j < base; j++) {
                if (j == 0 || j == base - 1) {
                    disegno += "* ";
                } else {
                    disegno += "  ";
                }
            }
            disegno += "\n";
        }
        // PARTE INFERIORE
        if (altezza > 1) {
            for (int i = 0; i < base; i++) {
                disegno += "* ";
            }
            disegno += "\n";
        }

        System.out.println("Disegno del Rettangolo: \n" + disegno);
        */

        for (int i = 0; i < altezza; i++) {
            for (int j = 0; j < base; j++) {
                if (i == 0 || i == altezza - 1 || j == 0 || j == base - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println("Perimetro: " + disegno);

    }
}
