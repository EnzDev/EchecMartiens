/**
@author Mallard-Le Bert
*/
package jeu;

public class Coordonnee{
  private int x;
  private int y;

  /**constructeur de la classe Coordonnee
  *@param x qui represente l'abscisse de la Coordonnee
  *@param x qui represente l'ordonnee de la Coordonnee
  */
public Coordonnee(int abscisse, int ordonnee){
  this.x = abscisse;
  this.y = ordonnee;
}
public void setCo(int abscisse, int ordonnee){
  this.x = abscisse;
  this.y = ordonnee;
}

/** methode qui permet d'afficher les coordonées
*/
public String toString(){
  return "x : " + x + "\t y : " + y;
}

}
