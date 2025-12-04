public class Resultat {

    // Attributs privés
    private Color couleur_pin;
    private int nb_pin;

    // Constructeur de la Combinaison
    public Resultat(Color couleur_pin, int nb_pin){
        this.couleur_pin = couleur_pin;
        this.nb_pin = nb_pin;
    }

    // =================
    // =====SETTER======
    // =================

    public void addNB(){
        this.nb_pin += 1;
    }
    public int getNB() {
        return nb_pin;
    }
}