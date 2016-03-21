package jeu;

public class Jeu {
    Pion pionArriveDeZone;
    Joueur[] joueurs;
    Plateau plateau;

    public Jeu(Joueur j1, Joueur j2){
        this.joueurs = new Joueur[2];
        this.joueurs[0] = j1;
        this.joueurs[1] = j2;

        this.plateau = new Plateau();
    }


    /** initialise les cases du plateau avec leurs joueurs respectif puis lance initialiser de plateau pour créer les pions
     *
     */
    public void initaliserPlateau(){

        for (int a = 0; a < this.plateau.getTailleHorizontale() ; a++) {
            for (int b = 0; b < this.plateau.getTailleHorizontale() ; b++) {
                this.plateau.setGrille(a,b,(new Case(this.joueurs[0])));
            }
        }

        for (int a = 0; a < this.plateau.getTailleHorizontale() ; a++) {
            for (int b = 0; b < this.plateau.getTailleHorizontale() ; b++) {
                this.plateau.setGrille(a,b+this.plateau.getTailleHorizontale(), (new Case(this.joueurs[1])));
            }
        }

        plateau.initialiser();
    }



}
