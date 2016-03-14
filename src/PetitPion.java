import Liste.*;
public abstract class PetitPion{
/**
@return score qui donne le nombre de point associé au pion
*/
public int getScore(){
  return 1;
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
  if ((Math.abs(coordDepardX-coordArriveeX))==1 && (Math.abs(coordDepardY-coordArriveeY)== 1){
    Coordonnee depard = new Coordonnee (coordDepardX,coordDepardY);
    Coordonnee arrivee = new Coordonnee (coordArriveeX,coordArriveeY);
    deplacement.add(depard);
    deplacement.add(arrivee);
    return deplacement;
  } else {
    deplacement.add(null);
    }
}
public String toString() {
  return "valeur: " + this.getScore();
}

}
