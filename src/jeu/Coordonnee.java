/**
 * @author Mallard-Le Bert
 */
package jeu;

public class Coordonnee {
    private int x;
    private int y;

    /**constructeur de la classe Coordonnee
     *@param abscisse qui represente l'abscisse de la Coordonnee
     *@param ordonnee qui represente l'ordonnee de la Coordonnee
     */
    public Coordonnee(int abscisse, int ordonnee) {
        this.x = abscisse;
        this.y = ordonnee;
    }

    public void setCo(int abscisse, int ordonnee) {
        this.x = abscisse;
        this.y = ordonnee;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /** methode qui permet d'afficher les coordonées
     */
    public String toString() {
        return "x : " + x + "\t y : " + y;
    }

}
