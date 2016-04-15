package jeu;

public class Case {
    private Pion pion;
    private Joueur joueur;

    /**
     *constructeur de la classe Coordonnee
     * @param p La case contient ce pion à son initialisation.
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
     *teste si une case contient un pion ou non
     * @return true si la case ne contient pas un pion, false sinon.
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
      *récupére le pion d'une case
     * @return le pion qui vient d'être supprimé
     */
    public Pion getPion() {
        return pion;
    }

    /**
     *accesseur qui permet de valuer la valeur d'un pion
     * @param pion est le nouveau pion de la case
     */
    public void setPion(Pion pion) {
        this.pion = pion;
    }

    /**
    * récupére le joueur à qui appartient la case
     * @return  le joueur à qui appartient la case
     */
    public Joueur getJoueur() {
        return joueur;
    }
    /**
    * redéfinition de la méthode public String toString()
    */
    public String toString() {
        return (this.pion == null) ? " " : this.pion.toString();
    } // Whaaaa la jolie condition ternaire
}
