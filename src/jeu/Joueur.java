package jeu;

import liste.*;

public class Joueur {
    private String pseudo;
    private Liste pionsCaptures;

    public Joueur(String j) {
        this.pseudo = j;
        this.pionsCaptures = new Liste();
    }

    public void ajouterPionCapture(Pion pionCapture) {
        this.pionsCaptures.add(pionCapture);
    }

    public int getNbPionsCaptures() {
        return this.pionsCaptures.size();
    }

    public boolean equals(Object object) {
        if (object instanceof Joueur) {
            if (((Joueur) object).pseudo.equals(this.pseudo)) {
                return true;
            }
        }
        return false;
    }


    public int calculerScore() {
        int score = 0;
        for (int i = 0; i < this.pionsCaptures.size(); i++) {
            score += ((Pion) this.pionsCaptures.get(i)).getScore();
        }
        return score;
    }
}