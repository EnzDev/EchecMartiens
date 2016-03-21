package jeu;

import liste.Liste;

public abstract class Pion {

    public abstract int getScore();

    public abstract static Liste getDeplacement(int coordDepardX, int coordArriveeX, int coordDepardY, int coordArriveeY);
}
