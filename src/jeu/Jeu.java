package jeu;

import liste.Liste;
import clavier.Clavier;


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
        Case g = this.plateau.getGrille(coordArriveeX, coordArriveeY);
        Liste depl = (c.getPion()).getDeplacement(coordDepardX, coordArriveeX, coordDepardY, coordArriveeY);

        if(depl==null) return false; // Si pas de deplacement possible
        if(g.getPion() != null && g.getJoueur().equals(joueur)) return false;


        if (c.getJoueur().equals(joueur)){
            if (c.getPion()==this.pionArriveDeZone || !this.plateau.getGrille(coordDepardX, coordDepardY).getJoueur().equals(joueur)){return false;}{
                for (int i = 1; i < depl.size()-2; i++) {
                    Coordonnee cord = (Coordonnee)depl.get(i);
                    if(this.plateau.getGrille(cord.getX(),cord.getY())!=null) return false;
                }
                Case fin = this.plateau.getGrille(coordArriveeX,coordArriveeY);
                if (fin != null && !fin.getJoueur().equals(joueur)) return true;
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

    /** Lance un tour de jeu
    *@param joueur
    */
    public void jouer(Joueur joueur){
        int coordDX;
        int coordDY;
        int coordAX = -1; //PreInit cuz the while loop
        int coordAY = -1; //PreInit cuz the while loop
        do{
            do {
                System.out.println("Abcisse de dépard:");
                coordDX =Clavier.readInt();
                System.out.println("Ordonée de dépard:");
                coordDY = Clavier.readInt();
                // Si la case n'est pas vide et appartient au joueur
                if (!this.plateau.getGrille(coordDX, coordDY).estLibre() && this.plateau.getGrille(coordDX, coordDY).getJoueur().equals(joueur)) { // Used
                    System.out.println(" Abcisse d'arrivée:");
                    coordAX = Clavier.readInt();
                    System.out.println(" Ordonée d'arrivée:");
                    coordAY = Clavier.readInt();
                }else{
                    System.out.println("Case vide ou n'appartenant pas au joueur");
                }
                // On check toutes les possibilités
            }while(this.plateau.getGrille(coordDX, coordDY).estLibre() || !this.plateau.getGrille(coordDX, coordDY).getJoueur().equals(joueur));

            if (!this.deplacementPossible(coordDX,coordAX,coordDY,coordAY,joueur)){
                System.out.println("Deplacement impossible");
            }

        }while(!this.deplacementPossible(coordDX,coordAX,coordDY,coordAY,joueur));
        Pion pionBout = this.plateau.getGrille(coordAX,coordAY).getPion();
        if (pionBout != null){ // pion capturé
            joueur.ajouterPionCapture(pionBout);
        }

        this.deplacer(coordDX,coordAX,coordDY,coordAY,joueur); // Override la case
        this.pionArriveDeZone = this.plateau.getGrille(coordAX,coordAY).getPion();
    }

    /**
    *@return true si la partie est finie
    */
    public boolean arretPartie(){
        boolean arret= false;
        //if there is only one piece left in the game
        if (this.joueurs[0].getNbPionsCaptures()+this.joueurs[1].getNbPionsCaptures()> 17){ arret = true;}
        //if none of the pice can be moved in the next turn
        
        return arret;
    }
    /**
    *@return le joueur gagnant
    */
    public Joueur joueurVainqueur(){
      if(this.joueurs[0].calculerScore()>this.joueurs[1].calculerScore())
          return this.joueurs[0];
      else
          return this.joueurs[1];
    }

    public String toString(){
      return this.plateau.toString() +"\n score joueur1:"+ this.joueurs[0].calculerScore() +"\n score joueur2:"+ this.joueurs[1].calculerScore()+ "\n";
    }
}
