package jeu;

import liste.Liste;

public class PetitPion extends Pion {
  /**
  * récupére la valeur du score d'un pion
   * @return valeur du pion
   */
    public int getScore() {
        return 1;
    }

    /**
     * donne le chemin de coordonnées que constitue le déplacement du point de départ vers le point d'arrivée. Les déplacements autorisés sont diagonaux mais que d'une case.
     *
     * @param coordDepardX  qui représente l'abscisse de dépard
     * @param coordArriveeX qui représente l'ordonée d'arrivé
     * @param coordDepardY  qui représente l'abscisse de dépard
     * @param coordArriveeY qui représente l'ordonée d'arrivé
     * @return une liste de coordonnées qui constitue le déplacement du point de départ vers le point d'arrivée si le déplacement est possible, null sinon
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
    /**
    *redéfinition de la méthode public String toString(): symbol qui représentera le pion sur le plateau
    */
    public String toString() {
        if (System.getProperty("os.name").contains("dows")) return "P"; //Handle CMD console

        return "⭑"; // P
    }

}
