
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Clavier {
    private Clavier() {
    }

    public static boolean readBoolean() {
        return Boolean.getBoolean(readLine());
    }

    public static char readChar() {
        return readLine().charAt(0);
    }

    public static int readInt() {
        int var0;
        try {
            var0 = (new Integer(readLine())).intValue();
        } catch (NumberFormatException var2) {
            System.err.println("Rentrez un int");
            var0 = readInt();
        }

        return var0;
    }

    public static double readDouble() {
        double var0;
        try {
            var0 = (new Double(readLine())).doubleValue();
        } catch (NumberFormatException var3) {
            System.err.println("Rentrez un double");
            var0 = readDouble();
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
