package jeu;

public class Case {
    private Pion pion;
    private Joueur joueur;

    /**
     * @param p La case contient ce pion à son instantiation.
     * @param j Un instance d'un joueur
     */
    public Case(Pion p, Joueur j) {
        this.pion = p;
        this.joueur = j;
    }

    /**
     * @param j une instance d'un joueur
     */
    public Case(Joueur j) {
        this(null, j);
    }

    /**
     * @return vrai si la case est vide
     */
    public boolean estLibre() {
        return this.pion == null;
    }

    /**
     * Enlève le pion de la case
     */
    public void delPion() {
        this.pion = null;
    }

    /**
     * @return le pion actuellement sur la case
     */
    public Pion getPion() {
        return pion;
    }

    /**
     * @param pion est le nouveau pion de la case
     */
    public void setPion(Pion pion) {
        this.pion = pion;
    }

    /**
     * @return le joueur possesseur de la case
     */
    public Joueur getJoueur() {
        return joueur;
    }

    public String toString() {
        return (this.pion == null) ? " " : this.pion.toString();
    } // Whaaaa la jolie condition ternaire
}
