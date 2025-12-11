import java.util.Arrays;

public class Game {

    // Constantes du jeu
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 12;

    // Variables d'état
    private Combinaison code_secret;
    private int nb_essais_restants;
    private boolean jeu_termine;
    private boolean victoire;
    private Resultats[] historique;

    // Configuration du jeu
    private String difficulte;
    private boolean allow_duplicates;

    // Constructeur avec configuration
    public Game(String difficulte, boolean allow_duplicates){
        this.difficulte = difficulte;
        this.allow_duplicates = allow_duplicates;
        this.historique = new Resultats[MAX_ATTEMPTS];
        this.nb_essais_restants = 0;
        this.jeu_termine = false;
        this.victoire = false;
    }

    // Constructeur par défaut (difficulté EASY, pas de doublons)
    public Game(){
        this.difficulte = "EASY";
        this.allow_duplicates = false;
        this.historique = new Resultats[MAX_ATTEMPTS];
        this.nb_essais_restants = 0;
        this.jeu_termine = false;
        this.victoire = false;
    }

    /**
     * Démarre une nouvelle partie
     */
    public void startNewGame(){
        this.code_secret = utils.generateSecretCode(CODE_LENGTH, difficulte, allow_duplicates);
        this.nb_essais_restants = MAX_ATTEMPTS;
        this.historique = new Resultats[MAX_ATTEMPTS];
        this.jeu_termine = false;
        this.victoire = false;
    }

    /**
     * Soumet une proposition du joueur
     */
    public Resultats submitGuess(Combinaison essai){
        if(jeu_termine){
            throw new IllegalStateException("Le jeu est terminé !");
        }

        int nb_essai_actuel = MAX_ATTEMPTS - nb_essais_restants + 1;
        Resultats resultats = utils.verifyCombiSecrete(code_secret, essai, nb_essai_actuel);

        int index_essai = MAX_ATTEMPTS - nb_essais_restants;
        historique[index_essai] = resultats;
        nb_essais_restants--;

        if(resultats.getPinRouge().getNB() == CODE_LENGTH){
            victoire = true;
            jeu_termine = true;
        } else if(nb_essais_restants <= 0){
            jeu_termine = true;
        }

        return resultats;
    }

    // =================
    // =====GETTER======
    // =================

    /**
     * @return Retourne si le jeu est terminé
     */
    public boolean isGameOver(){
        return jeu_termine;
    }

    /**
     * @return Retourne si le joueur a gagné
     */
    public boolean hasWon(){
        return victoire;
    }

    /**
     * @return Retourne l'historique des résultats
     */
    public Resultats[] getHistorique(){
        return historique;
    }

    /**
     * @return Retourne le nombre d'essais restants
     */
    public int getAttemptsLeft(){
        return nb_essais_restants;
    }

    /**
     * @return Retourne le code secret
     */
    public Combinaison getSecretCode(){
        return code_secret;
    }

    /**
     * @return Retourne la difficulté
     */
    public String getDifficulte(){
        return difficulte;
    }

    /**
     * @return Retourne si les doublons sont autorisés
     */
    public boolean getAllowDuplicates(){
        return allow_duplicates;
    }

    // =================
    // =====SETTER======
    // =================

    /**
     * @param difficulte Set la difficulté
     */
    public void setDifficulte(String difficulte){
        this.difficulte = difficulte;
    }

    /**
     * @param allow_duplicates Set si les doublons sont autorisés
     */
    public void setAllowDuplicates(boolean allow_duplicates){
        this.allow_duplicates = allow_duplicates;
    }

    /**
     * @param nb_essais_restants Set le nombre d'essais restants
     */
    public void setAttemptsLeft(int nb_essais_restants){
        this.nb_essais_restants = nb_essais_restants;
    }

    /**
     * Méthode main pour tester
     */
    public static void main(String[] args){
        System.out.println("=== Test de game ===\n");

        Color red = new Color("red");
        Color blue = new Color("blue"); 
        Color green = new Color("green");
        Color yellow = new Color("yellow");

        // Création d'un jeu en difficulté EASY sans doublons
        Game partie = new Game("EASY", false);
        partie.startNewGame();

        System.out.println("Tentatives restantes : " + partie.getAttemptsLeft());
        System.out.println("Jeu terminé ? " + partie.isGameOver());
        System.out.println("Code secret : " + partie.getSecretCode());

        Combinaison essai1 = new Combinaison(new Ping[] {new Ping(red, 0), new Ping(blue, 1), new Ping(green, 2), new Ping(yellow, 3)});
        Resultats resultats1 = partie.submitGuess(essai1);
        System.out.println("Résultat de l'essai 1 : " + resultats1.toString());

        Combinaison essai2 = new Combinaison(new Ping[] {new Ping(red, 0), new Ping(blue, 1), new Ping(green, 2), new Ping(yellow, 3)});
        Resultats resultats2 = partie.submitGuess(essai2);
        System.out.println("Résultat de l'essai 2 : " + resultats2.toString());

        System.out.println("Tentatives restantes : " + partie.getAttemptsLeft());
        System.out.println("Jeu terminé ? " + partie.isGameOver());
        System.out.println("Code secret : " + partie.getSecretCode());

        System.out.println("Résultat de l'essai 1 : " + resultats1.toString());
        System.out.println("Résultat de l'essai 2 : " + resultats2.toString());
        
    }
}
