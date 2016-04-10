package jeu;

import liste.Liste;

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
        // If diag (1)
        if ((Math.abs(coordDepardX - coordArriveeX)) == 1 && (Math.abs(coordDepardY - coordArriveeY) == 1)) {
            Liste deplacement = new Liste();

            deplacement.add(new Coordonnee(coordDepardX, coordDepardY));
            deplacement.add(new Coordonnee(coordArriveeX, coordArriveeY));

            return deplacement;
        } else return null;

    }

    public String toString() {
        return "P"; // ⭑
    }

}
