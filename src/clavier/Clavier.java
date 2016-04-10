package clavier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public final class Clavier {
    private Clavier() {
    }


    public static int readInt() {
        int var0;
        try {
            var0 = new Integer(readLine());
        } catch (NumberFormatException var2) {
            System.err.println("Rentrez un int");
            var0 = readInt();
        }

        return var0;
    }

    public static String readString() {
        return readLine();
    }

    private static String readLine() {
        String var0 = "";

        try {
            BufferedReader var1 = new BufferedReader(new InputStreamReader(System.in));
            var0 = var1.readLine();
        } catch (IOException var2) {
            System.err.println("Erreur entree/sortie");
            System.exit(0);
        }

        return var0;
    }
}
