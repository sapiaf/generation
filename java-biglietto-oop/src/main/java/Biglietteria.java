import java.util.ArrayList;
import java.util.Scanner;

public class Biglietteria {
    private ArrayList<Tratta> tratte;
    private GestoreDatabase gestoreDatabase;
    private static final Scanner scanner = new Scanner(System.in);

    public Biglietteria() {
        this.gestoreDatabase = new GestoreDatabase();
        this.tratte = gestoreDatabase.getTratteDatabase();
    }

    public ArrayList<Tratta> getTratte() {
        return tratte;
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.start();
        scanner.close();
    }

}
