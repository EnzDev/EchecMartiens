package jeu;

import liste.Liste;


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
    public void initialiserPlateau(){

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

    public boolean deplacementPossible(int coordDepardX, int coordArriveeX, int coordDepardY, int coordArriveeY, Joueur joueur){
        Case c = this.plateau.getGrille(coordDepardX, coordDepardY);
        Liste depl = (c.getPion()).getDeplacement(coordDepardX, coordArriveeX, coordDepardY, coordArriveeY);

        if(depl==null){return false;}

        if (c.getJoueur().equals(joueur)){
            if (c.getPion()==this.pionArriveDeZone && !this.plateau.getGrille(coordDepardX, coordDepardY).getJoueur().equals(joueur)){return false;}{
                for (int i = 0; i < depl.size()-1; i++) {
                    Coordonnee cord = (Coordonnee)depl.get(i);
                    if(this.plateau.getGrille(cord.getX(),cord.getY())!=null){return false;};
                }
            }
        }else{return false;}

        return true;
    }

    /** The programmer should verify deplacementPossible()
     * @param coordDepardX
     * @param coordArriveeX
     * @param coordDepardY
     * @param coordArriveeY
     * @param joueur
     */
    public void deplacer(int coordDepardX, int coordArriveeX, int coordDepardY, int coordArriveeY, Joueur joueur){
        Case oldC = this.plateau.getGrille(coordDepardX,  coordDepardY);
        Case newC = this.plateau.getGrille(coordArriveeX, coordArriveeY);
        newC.setPion(oldC.getPion());
        oldC.setPion(null);
    }

    private jouer(Joueur joueur){
        int coordAX;
        int coordAY;
        coordAX = clavier.readInt();
        coordAY = clavier.readInt();
        deplacementPossible(dx,dy,coordAX,coordAY,joueur)

    }


    public boolean arretPartie(){

        return true;
    }

}
