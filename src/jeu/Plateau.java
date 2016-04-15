package jeu;


public class Plateau {
    private int tailleHorizontale;

    private Case[][] grille;

    /**
      * Constructeur
     * @param size taille horizontale du tableau
     */
    public Plateau(int size) {
        this.tailleHorizontale = size;
        int tailleVerticale = 2 * this.tailleHorizontale;

        grille = new Case[this.tailleHorizontale][tailleVerticale];

        // !! Use Plateau.initialiser() after, otherwise it'll be unusable!!
    }
    /**
    *urcharge du constructeur pour un plateau de 4 case par défaut
    */
    public Plateau() {
        this(4);
    }
    /**
    *Renvoie la taille horizontale du plateau
    *@return la taille du plateau
    */
    public int getTailleHorizontale() {
        return tailleHorizontale;
    }
    /**
    *crée une case a un endroit donné du plateau
    *@param x Coordonnee verticale
    *@param y Coordonnee horizontale
    *@param c une case
    */
    public void setGrille(int x, int y, Case c) {
        this.grille[x][y] = c;
    }

    /**
    *Renvoie la case située au coordonnées données
    *@param x Coordonnee verticale
    *@param y Coordonnee horizontale
    *@return La case corespondante
    */
    public Case getGrille(int x, int y) {
        return this.grille[x][y];
    }
    /*
    *Initialise le plateau pour commencer le jeu
    */
    public void initialiser() {

        boolean debug = false; // Test an played game
        if (debug) {
            this.grille[0][1].setPion(new GrandPion());
            this.grille[3][2].setPion(new GrandPion());
            this.grille[3][6].setPion(new GrandPion());
            this.grille[2][7].setPion(new GrandPion());
            this.grille[3][7].setPion(new GrandPion());

            this.grille[0][2].setPion(new MoyenPion());
            this.grille[3][5].setPion(new MoyenPion());
            this.grille[2][6].setPion(new MoyenPion());

            this.grille[2][1].setPion(new PetitPion());
            this.grille[2][2].setPion(new PetitPion());
            this.grille[1][5].setPion(new PetitPion());
            this.grille[1][6].setPion(new PetitPion());
        } else {
            /** Joueur 1
             */
            this.grille[0][0].setPion(new GrandPion());
            this.grille[0][1].setPion(new GrandPion());
            this.grille[1][0].setPion(new GrandPion());

            this.grille[0][2].setPion(new MoyenPion());
            this.grille[1][1].setPion(new MoyenPion());
            this.grille[2][0].setPion(new MoyenPion());

            this.grille[1][2].setPion(new PetitPion());
            this.grille[2][2].setPion(new PetitPion());
            this.grille[2][1].setPion(new PetitPion());

            /** Joueur 2
             */
            this.grille[2][7].setPion(new GrandPion());
            this.grille[3][6].setPion(new GrandPion());
            this.grille[3][7].setPion(new GrandPion());

            this.grille[3][5].setPion(new MoyenPion());
            this.grille[2][6].setPion(new MoyenPion());
            this.grille[1][7].setPion(new MoyenPion());

            this.grille[1][5].setPion(new PetitPion());
            this.grille[2][5].setPion(new PetitPion());
            this.grille[1][6].setPion(new PetitPion());
        }
    }

    /**
    *redéfinition de la méthode String toString(): affiche le plateau
    */
    public String toString() {
        String output = "    0   1   2   3\n" + "  ┌───┬───┬───┬───┐\n";

        for (int y = 0; y < 3; y++) {
            output += y + " │ " + this.grille[0][y] + " │ " + this.grille[1][y] + " │ " + this.grille[2][y] + " │ " + this.grille[3][y] + " │\n";
            output += "  ├───┼───┼───┼───┤\n";
        }
        output += 3 + " │ " + this.grille[0][3] + " │ " + this.grille[1][3] + " │ " + this.grille[2][3] + " │ " + this.grille[3][3] + " │\n";
        output += "  ╞═══╪═══╪═══╪═══╡\n";

        for (int y = 4; y < 7; y++) {
            output += y + " │ " + this.grille[0][y] + " │ " + this.grille[1][y] + " │ " + this.grille[2][y] + " │ " + this.grille[3][y] + " │\n";
            output += "  ├───┼───┼───┼───┤\n";
        }
        output += "7 │ " + this.grille[0][7] + " │ " + this.grille[1][7] + " │ " + this.grille[2][7] + " │ " + this.grille[3][7] + " │\n";
        output += "  └───┴───┴───┴───┘\n";

        return output;
    }
}
