/**
 * @author Mallard-Le Bert
 */
package jeu;

import liste.Liste;

public class GrandPion extends Pion {
    /**
     * @return score qui donne le nombre de point associé au pion
     */
    public int getScore() {
        return 3;
    }

    /**
     * donne le chemin de coordonnées que constitue le déplacement du point de départ vers le point d'arrivée.
     *
     * @param coordDepardX  coordonnée horizontale du point de départ
     * @param coordArriveeXcoordonnée verticale du point de départ
     * @param coordDepardY  coordonnée horizontale du point d'arrivée
     * @param coordArriveeY coordonnée verticale du point d'arrivée
     * @return une liste de coordonnées qui constitue le déplacement du point de départ vers le point d'arrivée si le déplacement est vertical, null sinon
     */
    public Liste getDeplacement(int coordDepardX, int coordArriveeX, int coordDepardY, int coordArriveeY) {
        Liste deplacement = new Liste();


        // Horizontal
        if (coordDepardX == coordArriveeX) {
            for (int y = coordDepardY; coordArriveeY != y; y += Integer.signum(coordArriveeY - coordDepardY)) {
                Coordonnee etape = new Coordonnee(coordDepardX, y);
                deplacement.add(etape);
            }
            // Ajoute la dernière position
            deplacement.add(new Coordonnee(coordArriveeX, coordArriveeY));
        }
        // Vertical
        else if (coordDepardY == coordArriveeY) {
            for (int x = coordDepardX; coordArriveeX != x; x += Integer.signum(coordArriveeX - coordDepardX)) {
                Coordonnee etape = new Coordonnee(x, coordDepardY);
                deplacement.add(etape);
            }
            // Ajoute la dernière position
            deplacement.add(new Coordonnee(coordArriveeX, coordArriveeY));
        }
        // Diagonal
        else if (Math.abs(coordDepardX - coordArriveeX) == Math.abs(coordDepardY - coordArriveeY)) {
            int movX = 0, movY = 0;
            while ((coordDepardX + movX) != coordArriveeX && (coordDepardY + movY) != coordArriveeY) {
                movX += Integer.signum(coordArriveeX - (coordDepardX + movX));
                movY += Integer.signum(coordArriveeY - (coordDepardY + movY));
                Coordonnee etape = new Coordonnee(coordDepardX + movX, coordDepardY + movY);
                deplacement.add(etape);
            }
        }
        // Nothing allowed
        else return null;

        return deplacement;
    }
    /**
    *redéfinition de la méthode public String toString()
    */
    public String toString() {
        if (System.getProperty("os.name").contains("dows")) return "G"; //Handle CMD console
        return "⬤";// G
    }


}
