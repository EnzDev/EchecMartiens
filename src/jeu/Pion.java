package jeu;

import liste.Liste;

public abstract class Pion {
    /**
    * récupére la valeur du score d'un pion
    * @return valeur du pion
    */
    public abstract int getScore();
    /**
    *donne le chemin de coordonnées que constitue le déplacement du point de départ vers le point d'arrivée
    *@return une liste de coordonnées qui constitue le déplacement du point de départ vers le point d'arrivée si le déplacement est possible (en prenant en compte les spécificités de chaque pion), null sinon
    */
    public abstract Liste getDeplacement(int coordDepardX, int coordArriveeX, int coordDepardY, int coordArriveeY);
}
