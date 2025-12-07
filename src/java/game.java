import java.util.List;
import java.util.ArrayList;

public class Game {
    // Constantes du jeu
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 10;
    
    // Variables d'état
    private Combinaison secretCode;
    private int attemptsLeft;
    private boolean gameOver;
    private boolean hasWon;
    private List<Attempt> history;
    
    // Configuration du jeu
    private String difficulty;
    private boolean allowDuplicates;
    
    // Instance de utils pour générer les codes
    private utils utilsInstance;
    
    /**
     * Constructeur avec configuration
     */
    public Game(String difficulty, boolean allowDuplicates) {
        this.difficulty = difficulty;
        this.allowDuplicates = allowDuplicates;
        this.utilsInstance = new utils();
    }
    
    /**
     * Constructeur par défaut (difficulté MEDIUM, doublons autorisés)
     */
    public Game() {
        this("MEDIUM", true);
    }
    
    /**
     * Démarre une nouvelle partie
     */
    public void startNewGame() {
        // Utilise utils.generateSecretCode() exactement comme fourni
        this.secretCode = utilsInstance.generateSecretCode(
            CODE_LENGTH, 
            difficulty, 
            allowDuplicates
        );
        this.attemptsLeft = MAX_ATTEMPTS;
        this.history = new ArrayList<>();
        this.gameOver = false;
        this.hasWon = false;
    }
    
    /**
     * Soumet une proposition du joueur
     */
    public Result submitGuess(Combinaison guess) {
        if (gameOver) {
            throw new IllegalStateException("Le jeu est terminé !");
        }
        
        Result result = evaluateGuess(guess);
        history.add(new Attempt(guess, result));
        attemptsLeft--;
        
        if (result.getBlackPegs() == CODE_LENGTH) {
            hasWon = true;
            gameOver = true;
        } else if (attemptsLeft <= 0) {
            gameOver = true;
        }
        
        return result;
    }
    
    /**
     * Évalue la proposition du joueur
     * Compare deux Combinaisons (proposition vs code secret)
     */
    private Result evaluateGuess(Combinaison guess) {
        int black = 0;
        int white = 0;
        
        Ping[] secretPings = secretCode.getPings();
        Ping[] guessPings = guess.getPings();
        
        // Copies pour marquer les pings déjà utilisés
        boolean[] secretUsed = new boolean[CODE_LENGTH];
        boolean[] guessUsed = new boolean[CODE_LENGTH];
        
        // Première passe : pions noirs (bonne couleur + bonne position)
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (guessPings[i].getColor().equals(secretPings[i].getColor())) {
                black++;
                secretUsed[i] = true;
                guessUsed[i] = true;
            }
        }
        
        // Deuxième passe : pions blancs (bonne couleur, mauvaise position)
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (!guessUsed[i]) {
                for (int j = 0; j < CODE_LENGTH; j++) {
                    if (!secretUsed[j] && 
                        guessPings[i].getColor().equals(secretPings[j].getColor())) {
                        white++;
                        secretUsed[j] = true;
                        break;
                    }
                }
            }
        }
        
        return new Result(black, white);
    }
    
    // Getters
    public boolean isGameOver() {
        return gameOver;
    }
    
    public boolean hasWon() {
        return hasWon;
    }
    
    public List<Attempt> getHistory() {
        return new ArrayList<>(history);
    }
    
    public int getAttemptsLeft() {
        return attemptsLeft;
    }
    
    public Combinaison getSecretCode() {
        return secretCode;
    }
    
    /**
     * Classe interne Result
     */
    public static class Result {
        private final int blackPegs;
        private final int whitePegs;
        
        public Result(int blackPegs, int whitePegs) {
            this.blackPegs = blackPegs;
            this.whitePegs = whitePegs;
        }
        
        public int getBlackPegs() {
            return blackPegs;
        }
        
        public int getWhitePegs() {
            return whitePegs;
        }
        
        @Override
        public String toString() {
            return "Noirs: " + blackPegs + ", Blancs: " + whitePegs;
        }
    }
    
    /**
     * Classe interne Attempt
     */
    public static class Attempt {
        private final Combinaison guess;
        private final Result result;
        
        public Attempt(Combinaison guess, Result result) {
            this.guess = guess;
            this.result = result;
        }
        
        public Combinaison getGuess() {
            return guess;
        }
        
        public Result getResult() {
            return result;
        }
    }
    
    /**
     * Méthode main pour tester
     */
    public static void main(String[] args) {
        System.out.println("=== Test de Game ===\n");
        
        // Création d'un jeu en difficulté EASY sans doublons
        Game game = new Game("EASY", false);
        game.startNewGame();
        
        System.out.println("Tentatives restantes : " + game.getAttemptsLeft());
        System.out.println("Jeu terminé ? " + game.isGameOver());
        System.out.println("Code secret : " + game.getSecretCode());
    }
}