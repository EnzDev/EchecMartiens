import clavier.Clavier;
import jeu.Jeu;
import jeu.Joueur;


public class testJeu {
    public static void main(String[] args) {
        System.out.print("Joueur 1 : ");
        Joueur joueur1 = new Joueur(Clavier.readString());
        System.out.print("Joueur 2 : ");
        Joueur joueur2 = new Joueur(Clavier.readString());
        Joueur[] joueur = new Joueur[2];
        joueur[0] = joueur1;
        joueur[1] = joueur2;

        //Game initiallization
        Jeu jeu = new Jeu(joueur[0], joueur[1]);
        jeu.initialiserPlateau();
        System.out.println(jeu.toString());
        //tour is of value 1 or 0 dependending on which player turn it is.
        int tour = 0;
        //gameplay
        while (!jeu.arretPartie()) {
            System.out.println("C'est au tour de " + joueur[tour].getPseudo());
            jeu.jouer(joueur[tour]);
            System.out.println(jeu.toString());
            if (tour == 0) {
                tour = 1;
            } else tour = 0;

        }

        System.out.println("Vainqueur" + jeu.joueurVainqueur());
    }
}

