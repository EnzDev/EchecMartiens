/**
 * @author Mallard-Le Bert
 */
package jeu;

import liste.Liste;

public class MoyenPion extends Pion {
    /**
     @return score qui donne le nombre de point associé au pion
     */
    public int getScore() {
        return 2;
    }

    /**
     methode qui liste les déplacements autorisés
     @param coordDepardX qui représente l'abscisse de dépard
     @param coordArriveeX qui représente l'ordonée d'arrivé
     @param coordDepardY qui représente l'abscisse de dépard
     @param coordArriveeY qui représente l'ordonée d'arrivé
     @return deplacement qui donne les cases parcourues au cours du déplacement
     */
    public Liste getDeplacement(int coordDepardX, int coordArriveeX, int coordDepardY, int coordArriveeY) {
        Liste deplacement = new Liste();


        // Horizontal
        if(coordDepardX == coordArriveeX && Math.abs(coordDepardY - coordArriveeY) <= 2 ) {
            for (int y = coordDepardY; coordArriveeY!=y ; y += Integer.signum(coordArriveeY - coordDepardY)) {
                Coordonnee etape = new Coordonnee(coordDepardX, y);
                deplacement.add(etape);
            }
        }
        // Vertical
        else if(coordDepardY == coordArriveeY  && Math.abs(coordDepardX - coordArriveeX) <= 2 ) {
            for (int x = coordDepardX; coordArriveeX!=x ; x += Integer.signum(coordArriveeX - coordDepardX)) {
                Coordonnee etape = new Coordonnee(x, coordDepardY);
                deplacement.add(etape);
            }
        }
        // Diagonal (On ne vérifie qu'une seule des coordonnées)
        else if(Math.abs(coordDepardX-coordArriveeX) == Math.abs(coordDepardY-coordArriveeY) && Math.abs(coordDepardX - coordArriveeX) <= 2){
            int movX = 0, movY = 0;
            while((coordDepardX + movX) != coordArriveeX && (coordDepardY + movY) != coordArriveeY) {
                movX += Integer.signum(coordArriveeX - (coordDepardX + movX));
                movY += Integer.signum(coordArriveeY - (coordDepardY + movY));
                Coordonnee etape = new Coordonnee(coordDepardX + movX, coordDepardY + movY);
                deplacement.add(etape);
            }
        }
        // Unauthorized move
        else return null;

        // Ajoute la dernière position
        deplacement.add(new Coordonnee(coordArriveeX, coordArriveeY));
        return deplacement;
    }

    public String toString() {
        return "⚫";
    }


}
