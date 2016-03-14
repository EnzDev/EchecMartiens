import Liste.*
public class Joueur{
    String pseudo;
    Liste pionsCaptures;

    public Joueur(String j){
        this.pseudo = j;
        this.pionsCaptures = new Liste();
    }

    public void ajouterPionCapture(Pion pionCapture) {
        this.pionsCaptures.add() = pionCapture;
    }

    public int getNbPionsCaptures(){
        return this.pionsCaptures.size();
    }

    public boolean equals(Object object) {
        { if (object instanceof joueur) {
            if ( ((Joueur)object).pseudo.equals(this.pseudo) ){
                return true;
            }
        }
            return false;
    }


    public int calculerScore(){
        score = 0;
        for (int i=0; i<this.pionsCaptures.size(); i++){
            score += this.pionsCaptures.get(i).getScore();
        }
        return score;
    }
}