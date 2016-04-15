package jeu;

import liste.Liste;

public class Joueur {
    private String pseudo;
    private Liste pionsCaptures;

    /**
     *Constructeur
     * @param j le pseudo du joueur
     */
    public Joueur(String j) {
        this.pseudo = j;
        this.pionsCaptures = new Liste();
    }
    /**
    * Retourne le Pseudo du joueur
    @return le pseudo
    */
    public String getPseudo(){
      return this.pseudo;
    }

    /**
     * ajout à la liste d'un pion qui a été capturés
     * @param pion capturé
     */
    public void ajouterPionCapture(Pion pionCapture) {
        this.pionsCaptures.add(pionCapture);
    }

    /**
     * permet de connaître le nombre de pions capturés
     * @return le nombre de pions capturés
     */
    public int getNbPionsCaptures() {
        return this.pionsCaptures.size();
    }

    /**
     *redéfinition de la méthode public boolean equals(Object o)
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
     *calcule le score du joueur
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
