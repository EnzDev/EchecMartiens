package jeu;

public class Case {
    private Pion pion;
    private Joueur joueur;

    public Case(Pion p, Joueur j) {
        this.pion = p;
        this.joueur = j;
    }

    public Case(Joueur j) {
        this.pion = null;
        this.joueur = j;
    }

    public boolean estVide(){ return this.pion==null; }



}
