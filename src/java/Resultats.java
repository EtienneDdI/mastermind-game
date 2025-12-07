public class Resultats {

    // Attributs privés
    private static final Color blanc = new Color("blanc");
    private Resultat pin_blanc = new Resultat(blanc, 0);
    
    private static final Color rouge = new Color("rouge");
    private Resultat pin_rouge = new Resultat(rouge, 0); 
    
    private static final Color noir = new Color("noir");
    private Resultat pin_noir = new Resultat(noir, 0); 

    private int nb_essais;

    // Constructeur de la Resultats avec paramètres
    public Resultats(Resultat pin_blanc, Resultat pin_rouge, Resultat pin_noir){
        this.pin_blanc = pin_blanc;
        this.pin_rouge = pin_rouge;
        this.pin_noir = pin_noir;
        this.nb_essais = 0;
    }

    // Constructeur sans paramètres (utilise les valeurs par défaut)
    public Resultats(){
        this.nb_essais = 0;
    }

    // =================
    // =====GETTER======
    // =================

    /**
     * @return Retourne le resultat du pin blanc
     */
    public Resultat getPinBlanc(){
        return this.pin_blanc;
    }
    
    /**
     * @return Retourne le resultat du pin rouge
     */
    public Resultat getPinRouge(){
        return this.pin_rouge;
    }
    
    /**
     * @return Retourne le resultat du pin noir
     */
    public Resultat getPinNoir(){
        return this.pin_noir;
    }

    /**
     * @return Retourne le nombre d'essais
     */
    public int getNbEssai(){
        return this.nb_essais;
    }

    // =================
    // =====SETTER======
    // =================

    /**
     * @param nb_essais Set le nombre d'essais
     */
    public void setNbEssai(int nb_essais){
        this.nb_essais = nb_essais;
    }
}