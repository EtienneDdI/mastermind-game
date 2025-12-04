public class Resultats {

    // Attributs privés
    private static final Color blanc = new Color("blanc");
    private Resultat pin_blanc = Resultat(blanc, 0);
    
    private static final Color rouge = new Color("rouge");
    private Resultat pin_rouge = Resultat(rouge, 0); 
    
    private static final Color noir = new Color("noir");
    private Resultat pin_noir = Resultat(noir, 0); 

    // Constructeur de la Combinaison
    public Resultats(Resultat pin_blanc, Resultat pin_rouge, Resultat pin_noir){
        this.pin_blanc = pin_blanc;
        this.pin_rouge = pin_rouge;
        this.pin_noir = pin_noir;
    }
}