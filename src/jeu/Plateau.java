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
        this.grille[8][8].setPion(new GrandPion());
        this.grille[8][7].setPion(new GrandPion());
        this.grille[7][8].setPion(new GrandPion());

        this.grille[8][6].setPion(new MoyenPion());
        this.grille[7][7].setPion(new MoyenPion());
        this.grille[6][8].setPion(new MoyenPion());

        this.grille[7][6].setPion(new PetitPion());
        this.grille[6][6].setPion(new PetitPion());
        this.grille[6][7].setPion(new PetitPion());

    }


    public String toString() {
        String output = "";
        



        





        return output;
    }
}
