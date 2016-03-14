package liste;

import java.util.ArrayList;

public class Liste {
    private ArrayList<Object> liste = new ArrayList();

    public Liste() {
    }

    public void add(Object var1) {
        this.liste.add(var1);
    }

    public Object get(int var1) {
        try {
            return this.liste.get(var1);
        } catch (IndexOutOfBoundsException var3) {
            return null;
        }
    }

    public boolean remove(Object var1) {
        return this.liste.remove(var1);
    }

    public int size() {
        return this.liste.size();
    }

    public String toString() {
        return this.liste.toString();
    }
}
