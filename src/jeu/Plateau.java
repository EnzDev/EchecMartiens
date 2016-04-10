package jeu;


import java.util.Arrays;

public class Plateau {
    int tailleHorizontale;
    int tailleVerticale;

    Case[][] grille;

    public int getTailleHorizontale() {
        return tailleHorizontale;
    }

    public void setGrille(int x, int y, Case c) {
        this.grille[x][y] = c;
    }

    public Case getGrille(int x, int y) {
        return this.grille[x][y];
    }

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

    public void initialiser(){

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
        String output = "    0   1   2   3\n" ;
//                + "  ┌───┬───┬───┬───┐\n";

        for (int y = 0; y < 3 ; y++) {
            output += y+" │ "+ this.grille[0][y] +" │ "+ this.grille[1][y] +" │ "+ this.grille[2][y] +" │ "+ this.grille[3][y] +" │\n";
//            output += "  ├───┼───┼───┼───┤\n";
        }
        output += 3+" │ "+ this.grille[0][3] +" │ "+ this.grille[1][3] +" │ "+ this.grille[2][3] +" │ "+ this.grille[3][3] +" │\n";
//        output += "  ╞═══╪═══╪═══╪═══╡\n";

        for (int y = 4; y < 7 ; y++) {
            output += y+" │ "+ this.grille[0][y] +" │ "+ this.grille[1][y] +" │ "+ this.grille[2][y] +" │ "+ this.grille[3][y] +" │\n";
//            output += "  ├───┼───┼───┼───┤\n";
        }
        output += "7 │ "+ this.grille[0][7] +" │ "+ this.grille[1][7] +" │ "+ this.grille[2][7] +" │ "+ this.grille[3][7] +" │\n";
//        output += "  └───┴───┴───┴───┘\n";

        return output;
    }
}
