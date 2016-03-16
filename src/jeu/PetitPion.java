package jeu;

import liste.*;

public class PetitPion extends Pion {
    /**
     * @return score qui donne le nombre de point associé au pion
     */
    public int getScore() {
        return 1;
    }

    /**
     * methode qui liste les déplacements autorisés
     *
     * @param coordDepardX  qui représente l'abscisse de dépard
     * @param coordArriveeX qui représente l'ordonée d'arrivé
     * @param coordDepardY  qui représente l'abscisse de dépard
     * @param coordArriveeY qui représente l'ordonée d'arrivé
     * @return deplacement qui donne les cases parcourues au cours du déplacement
     */
    public Liste getDeplacement(int coordDepardX, int coordArriveeX, int coordDepardY, int coordArriveeY) {
        Liste deplacement = new Liste();
        //move is less of one and move is made diagonally
        if ((Math.abs(coordDepardX - coordArriveeX)) == 1 && (Math.abs(coordDepardY - coordArriveeY) == 1) && (Math.abs(coordDepardY - coordArriveeY) == (Math.abs(coordDepardX - coordArriveeX)))) {
            Coordonnee arrivee = new Coordonnee(coordArriveeX, coordArriveeY);
            deplacement.add(arrivee);
        } else {
            deplacement.add(null);
        }
        return deplacement;
    }

    public String toString() {
        return "valeur: " + this.getScore();
    }

}
