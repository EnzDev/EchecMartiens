import jeu.*;
import clavier.Clavier;

public class testJeu {
    public static void main(String[] args){
        Joueur joueur1 = new Joueur("joueur1");
        Joueur joueur2 = new Joueur("joueur2");
        Joueur[] joueur = new Joueur[2];
        joueur[0] = joueur1;
        joueur[1] = joueur2;

        //Game initiallization
        Jeu jeu = new Jeu(joueur[0],joueur[1]);
        jeu.initialiserPlateau();
        System.out.println(jeu.toString());
        //tour is of value 1 or 0 dependending on which player turn it is.
        int tour = 0;
        //gameplay
        while (jeu.arretPartie() == false){
          System.out.println("C'est au tour de " +joueur[tour].getPseudo());
          jeu.jouer(joueur[tour]);
          System.out.println(jeu.toString());
          if  (tour == 0) { tour = 1 ;} else {tour = 0;}
          }

        System.out.println("Vainceur" + jeu.joueurVainqueur());
    }
}
