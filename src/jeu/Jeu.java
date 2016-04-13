package jeu;

import clavier.Clavier;
import liste.Liste;


public class Jeu {
    private Pion pionArriveDeZone;
    private Joueur[] joueurs;
    private Plateau plateau;

    public Jeu(Joueur j1, Joueur j2) {
        this.joueurs = new Joueur[2];
        this.joueurs[0] = j1;
        this.joueurs[1] = j2;

        this.plateau = new Plateau();
    }


    /**
     * initialise les cases du plateau avec leurs joueurs respectif puis lance initialiser de plateau pour créer les pions
     */
    public void initialiserPlateau() {

        for (int a = 0; a < this.plateau.getTailleHorizontale(); a++) {
            for (int b = 0; b < this.plateau.getTailleHorizontale(); b++) {
                this.plateau.setGrille(a, b, (new Case(this.joueurs[0])));
            }
        }

        for (int a = 0; a < this.plateau.getTailleHorizontale(); a++) {
            for (int b = 0; b < this.plateau.getTailleHorizontale(); b++) {
                this.plateau.setGrille(a, b + this.plateau.getTailleHorizontale(), (new Case(this.joueurs[1])));
            }
        }

        plateau.initialiser();
    }

    public boolean deplacementPossible(int coordDepardX, int coordArriveeX, int coordDepardY, int coordArriveeY, Joueur joueur) {
        Case c = this.plateau.getGrille(coordDepardX, coordDepardY);
        Case g = this.plateau.getGrille(coordArriveeX, coordArriveeY);
        Liste depl = (c.getPion()).getDeplacement(coordDepardX, coordArriveeX, coordDepardY, coordArriveeY);

        if (depl == null) return false; // Si pas de deplacement possible
        if (g.getPion() != null && g.getJoueur().equals(joueur)) return false;


        if (c.getJoueur().equals(joueur)) {
            if (((c.getPion() == this.pionArriveDeZone) && !g.getJoueur().equals(joueur)) || !c.getJoueur().equals(joueur)) {
                return false;
            }
            {
                for (int i = 1; i <= depl.size() - 2; i++) {
                    Coordonnee cord = (Coordonnee) depl.get(i);
                    if (this.plateau.getGrille(cord.getX(), cord.getY()).getPion() != null) return false;
                }
                Case fin = this.plateau.getGrille(coordArriveeX, coordArriveeY);
                if (fin != null && !fin.getJoueur().equals(joueur)) return true;
            }
        } else {
            return false;
        }

        return true;
    }

    /**
     * The programmer should verify deplacementPossible()
     *
     * @param coordDepardX
     * @param coordArriveeX
     * @param coordDepardY
     * @param coordArriveeY
     */
    public void deplacer(int coordDepardX, int coordArriveeX, int coordDepardY, int coordArriveeY) {
        Case oldC = this.plateau.getGrille(coordDepardX, coordDepardY);
        Case newC = this.plateau.getGrille(coordArriveeX, coordArriveeY);
        newC.setPion(oldC.getPion());
        oldC.setPion(null);
    }

    /**
     * Lance un tour de jeu
     *
     * @param joueur
     */
    public void jouer(Joueur joueur) {
        int coordDX;
        int coordDY;
        int coordAX = -1; //PreInit cuz the while loop
        int coordAY = -1; //PreInit cuz the while loop
        boolean error;

        do {
            do {
                error = false;
                System.out.print("Colone de dépard: ");
                coordDX = Clavier.readInt();
                System.out.print("Ligne de dépard: ");
                coordDY = Clavier.readInt();
                // Si la case n'est pas vide et appartient au joueur
                // Check if the values are in the correct range
                if (!(0 <= coordDX && coordDX < 4 && 0 <= coordDY && coordDY < 8)) {
                    error = true;
                }

                if (!error && !this.plateau.getGrille(coordDX, coordDY).estLibre() && this.plateau.getGrille(coordDX, coordDY).getJoueur().equals(joueur)) { // Used
                    System.out.print("Colone d'arrivée: ");
                    coordAX = Clavier.readInt();
                    System.out.print("Ligne d'arrivée: ");
                    coordAY = Clavier.readInt();
                    if (!(0 <= coordAX && coordAX < 4 && 0 <= coordAY && coordAY < 8)) {
                        error = true;
                    }
                } else {
                    if (error) System.out.println("Erreur de coordonnées");
                    else System.out.println("Case vide ou n'appartenant pas au joueur");
                }
                // On check toutes les possibilités
            }
            while (error || (this.plateau.getGrille(coordDX, coordDY).estLibre() || !this.plateau.getGrille(coordDX, coordDY).getJoueur().equals(joueur)));

            if (!this.deplacementPossible(coordDX, coordAX, coordDY, coordAY, joueur)) {
                System.out.println("Deplacement impossible");
            }


        } while (!this.deplacementPossible(coordDX, coordAX, coordDY, coordAY, joueur));
        Pion pionBout = this.plateau.getGrille(coordAX, coordAY).getPion();
        if (pionBout != null) { // pion capturé
            joueur.ajouterPionCapture(pionBout);
        }

        this.deplacer(coordDX, coordAX, coordDY, coordAY); // Override la case
        this.pionArriveDeZone = this.plateau.getGrille(coordAX, coordAY).getPion();
    }

    /**
     * @return true si la partie est finie
     */
    public boolean arretPartie() {
        boolean arret = false;
        //if there is only one piece left in the game
        if (this.joueurs[0].getNbPionsCaptures() + this.joueurs[1].getNbPionsCaptures() > 17) {
            arret = true;
        }
        //if one player's got no pieces left or if he's got only one and it was the one moved previously
          //player 1
          int x = 0;
          int y = 0;
          int possible = 0;// number of pions in a zone
          for( x = 0 ; x <= 3; x++) {
              for (y = 0; y <= 3; y++) {
                if ((!(this.plateau.getGrille(x,y).estLibre()))&& (this.plateau.getGrille(x,y).getPion()!=this.pionArriveDeZone)){
                  possible ++;//if the case is not empty nor it is occupided by the last piece that has been move the case can be played
                }
             }
          }
          if (possible==0){
            arret = true;
          }
          //player 2
          possible = 0;
          for(x = 0 ; x <= 3; x++) {
              for (y = 4  ; y <= 7; y++) {
                if ((!(this.plateau.getGrille(x,y).estLibre()))&& (this.plateau.getGrille(x,y).getPion()!=this.pionArriveDeZone)){
                  possible++;
                }
             }
          }
          if (possible==0){
            arret = true;
          }
        return arret;
    }

    /**
     * @return le joueur gagnant
     */
    public String joueurVainqueur() {
        if (this.joueurs[0].calculerScore() > this.joueurs[1].calculerScore())
            return this.joueurs[0].getPseudo();
            if (this.joueurs[1].calculerScore() > this.joueurs[0].calculerScore())
              return this.joueurs[1].getPseudo();
            else
              return "egalitée";
    }

    public String toString() {
        return this.plateau.toString() + "\n score " + this.joueurs[0].getPseudo() + ":" + this.joueurs[0].calculerScore() + "\n score " + this.joueurs[1].getPseudo() + ":" + this.joueurs[1].calculerScore() + "\n";
    }
}
