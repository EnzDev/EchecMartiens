/**
@author Mallard-Le Bert
*/
package jeu;

import liste.Liste;
public abstract class MoyenPion{
/**
@return score qui donne le nombre de point associé au pion
*/
public int getScore(){
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
public Liste getDeplacement(int coordDepardX,int coordArriveeX, int coordDepardY, int coordArriveeY){
  Liste deplacement = new Liste();
  //test d'autorisation de deplacement: inferieur a 2 cas, deplacement vertical, deplacement honrizontal ou deplacement diagonal
  if ((Math.abs(coordDepardX-coordArriveeX))<=2 && (Math.abs(coordDepardY-coordArriveeY)<=2) && ((coordDepardX==coordArriveeX)||(coordDepardY==coordArriveeY)||Math.abs(coordArriveeX-coordDepardX)==Math.abs(coordArriveeY-coordDepardY))){
    //deplacement vertical
    if (coordDepardX==coordArriveeX){
      Coordonnee etape = new Coordonnee(coordArriveeX,coordArriveeY);
      //pour i de 1 a la taille du déplacement
        for (int i = 1; i<= Math.abs(coordDepardY-coordArriveeY); i++){
          etape.setCo(coordArriveeX,coordArriveeY+ i);
          deplacement.add(etape);
        }
      }
    else{
      //deplacement honrizontal
      if(coordDepardY==coordArriveeY){
        Coordonnee etape = new Coordonnee(coordArriveeX,coordArriveeY);
        //pour i de 1 a la taille du déplacement
          for (int i = 1; i<= Math.abs(coordDepardX-coordArriveeX); i++){
            etape.setCo(coordArriveeX +i ,coordArriveeY);
            deplacement.add(etape);
          }
        }
      //deplacement diagonal
      else{
        Coordonnee etape = new Coordonnee(coordArriveeX,coordArriveeY);
        //pour i de 1 a la taille du déplacement
          for (int i = 1; i<= Math.abs(coordDepardX-coordArriveeX); i++){
            etape.setCo(coordArriveeX +i ,coordArriveeY);
            deplacement.add(etape);
          }
        }
      }
    }
  // unauthorized move
  else {
    deplacement.add(null);
    }
  return deplacement;
}

public String toString() {
  return "valeur: " + this.getScore();
}


}
