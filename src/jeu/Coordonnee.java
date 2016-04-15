/**
 * @author Mallard-Le Bert
 */
package jeu;

public class Coordonnee {
    private int x;
    private int y;

    /**
     * constructeur de la classe Coordonnee
     *
     * @param abscisse qui represente l'abscisse de la Coordonnee
     * @param ordonnee qui represente l'ordonnee de la Coordonnee
     */
    public Coordonnee(int abscisse, int ordonnee) {
        this.x = abscisse;
        this.y = ordonnee;
    }
    /**
     * accesseur qui permet de récupérer la coordonnée en colone
     *@return le numéro de colone
    */
    public int getX() {
        return x;
    }
    /**
     * accesseur qui permet de récupérer la coordonnée en ligne
     *@return le numéro de ligne
     */
    public int getY() {
        return y;
    }

    /**
     * redéfinition de la méthode public String toString(): permet d'afficher les coordonées
     */
    public String toString() {
        return "x : " + x + "\t y : " + y;
    }

}
