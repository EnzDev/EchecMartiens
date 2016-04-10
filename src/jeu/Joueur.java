package jeu;

import liste.*;

public class Joueur {
    private String pseudo;
    private Liste pionsCaptures;

    /**
     * @param j le pseudo du joueur
     */
    public Joueur(String j) {
        this.pseudo = j;
        this.pionsCaptures = new Liste();
    }
    /**
    @return pseudo
    */
    public String getPseudo(){
      return this.pseudo;
    }

    /**
     * @param pionCapture sera ajouté aux pions du joueur
     */
    public void ajouterPionCapture(Pion pionCapture) {
        this.pionsCaptures.add(pionCapture);
    }

    /**
     * @return le nombre de pions capturés
     */
    public int getNbPionsCaptures() {
        return this.pionsCaptures.size();
    }

    /**
     * @param object est une instance de Joueur
     * @return la comparaison des pseudo des deux instances
     */
    public boolean equals(Object object) {
        if (object instanceof Joueur) {
            if (((Joueur) object).pseudo.equals(this.pseudo)) {
                return true;
            }
        }
        return false;
    }


    /**
     * @return le score total du joueur
     */
    public int calculerScore() {
        int score = 0;
        for (int i = 0; i < this.pionsCaptures.size(); i++) {
            score += ((Pion) this.pionsCaptures.get(i)).getScore();
        }
        return score;
    }
}
