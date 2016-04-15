/**
 * @author Mallard-Le Bert
 */
package jeu;

import liste.Liste;

public class MoyenPion extends Pion {
    /**
    * récupére la valeur du score d'un pion
     * @return valeur du pion
     */
    public int getScore() {
        return 2;
    }

    /**
     * donne le chemin de coordonnées que constitue le déplacement du point de départ vers le point d'arrivée. Les déplacements autorisés sont horizontaux, verticaux, diagonaux mais de longueur maximale 2.
     *
     * @param coordDepardX  qui représente l'abscisse de dépard
     * @param coordArriveeX qui représente l'ordonée d'arrivé
     * @param coordDepardY  qui représente l'abscisse de dépard
     * @param coordArriveeY qui représente l'ordonée d'arrivé
     * @return une liste de coordonnées qui constitue le déplacement du point de départ vers le point d'arrivée si le déplacement est possible, null sinon
     */
    public Liste getDeplacement(int coordDepardX, int coordArriveeX, int coordDepardY, int coordArriveeY) {
        Liste deplacement = new Liste();


        // Horizontal
        if (coordDepardX == coordArriveeX && Math.abs(coordDepardY - coordArriveeY) <= 2) {
            for (int y = coordDepardY; coordArriveeY != y; y += Integer.signum(coordArriveeY - coordDepardY)) {
                Coordonnee etape = new Coordonnee(coordDepardX, y);
                deplacement.add(etape);
            }
            // Ajoute la dernière position
            deplacement.add(new Coordonnee(coordArriveeX, coordArriveeY));
        }
        // Vertical
        else if (coordDepardY == coordArriveeY && Math.abs(coordDepardX - coordArriveeX) <= 2) {
            for (int x = coordDepardX; coordArriveeX != x; x += Integer.signum(coordArriveeX - coordDepardX)) {
                Coordonnee etape = new Coordonnee(x, coordDepardY);
                deplacement.add(etape);
            }
            // Ajoute la dernière position
            deplacement.add(new Coordonnee(coordArriveeX, coordArriveeY));
        }
        // Diagonal (On ne vérifie qu'une seule des coordonnées)
        else if (Math.abs(coordDepardX - coordArriveeX) == Math.abs(coordDepardY - coordArriveeY) && Math.abs(coordDepardX - coordArriveeX) <= 2) {
            int movX = 0, movY = 0;
            while ((coordDepardX + movX) != coordArriveeX && (coordDepardY + movY) != coordArriveeY) {
                movX += Integer.signum(coordArriveeX - (coordDepardX + movX));
                movY += Integer.signum(coordArriveeY - (coordDepardY + movY));
                Coordonnee etape = new Coordonnee(coordDepardX + movX, coordDepardY + movY);
                deplacement.add(etape);
            }
        }
        // Unauthorized move
        else return null;

        return deplacement;
    }
    /**
    *redéfinition de la méthode public String toString(): symbol qui représentera le pion sur le plateau
    */
    public String toString() {
        if (System.getProperty("os.name").contains("dows")) return "M"; //Handle CMD console
        return "⚫"; // M
    }

}
