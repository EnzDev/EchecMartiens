package jeu;


import java.util.Arrays;

public class Plateau {
    int tailleHorizontale;
    int tailleVerticale;

    Case[][] grille;

    /**
     * @param size taille horizontale du tableau
     */
    public Plateau(int size){
        this.tailleHorizontale = size;
        this.tailleVerticale = 2 * this.tailleHorizontale;

        grille = new Case[this.tailleHorizontale][this.tailleVerticale];

        // !! Use Plateau.init() after, otherwise it'll be unusable
    }

    public Plateau(){ this(4);}

    public void init(Joueur j1, Joueur j2){
        for (int a = 0; a < this.tailleHorizontale ; a++) {
            for (int b = 0; b < this.tailleHorizontale ; b++) {
                this.grille[a][b] = new Case(j1);
            }
        }

        for (int a = 0; a < this.tailleHorizontale ; a++) {
            for (int b = 0; b < this.tailleHorizontale ; b++) {
                this.grille[a][b+this.tailleHorizontale] = new Case(j2);
            }
        }

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


    public String toString() {
        String output = "┌───┬───┬───┬───┐\n";

        for (int y = 0; y < 3 ; y++) {
            output += "│ "+ this.grille[0][y] +" │ "+ this.grille[1][y] +" │ "+ this.grille[2][y] +" │ "+ this.grille[3][y] +" │\n";
            output += "├───┼───┼───┼───┤\n";
        }
        output += "│ "+ this.grille[0][3] +" │ "+ this.grille[1][3] +" │ "+ this.grille[2][3] +" │ "+ this.grille[3][3] +" │\n";
        output += "╞═══╪═══╪═══╪═══╡\n";

        for (int y = 4; y < 7 ; y++) {
            output += "│ "+ this.grille[0][y] +" │ "+ this.grille[1][y] +" │ "+ this.grille[2][y] +" │ "+ this.grille[3][y] +" │\n";
            output += "├───┼───┼───┼───┤\n";
        }
        output += "│ "+ this.grille[0][7] +" │ "+ this.grille[1][7] +" │ "+ this.grille[2][7] +" │ "+ this.grille[3][7] +" │\n";
        output += "└───┴───┴───┴───┘\n";

        return output;
    }
}
