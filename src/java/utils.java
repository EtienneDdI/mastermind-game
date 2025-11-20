import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class utils {

    // Initialisation des couleurs
    private final Color red = new Color("red");
    private final Color blue = new Color("blue");
    private final Color green = new Color("green");
    private final Color yellow = new Color("yellow");
    private final Color purple = new Color("purple");
    private final Color orange = new Color("orange");
    private final Color brown = new Color("brown");
    private final Color pink = new Color("pink");

    // Initialisation des listes de couleurs
    private final Color[] EASY_COLORS = {red, blue, green, yellow};
    private final Color[] MEDIUM_COLORS = {red, blue, green, yellow, purple, orange};
    private final Color[] HARD_COLORS = {red, blue, green, yellow, purple, orange, brown, pink};

    // Initialisation de la classe Random (static pour les méthodes static)
    private static final Random random = new Random();

    /**
     * Génère le code secret
     * @param nbPins Nombre de couleur dans le code, par default 4.
     * @param difficulty Une des trois difficultés : "EASY", "MEDIUM", "HARD".
     * @param allowDup Si true, autorise les doublons de couleur dans le code secret.
     * @return retourne une liste de string (le code secret).
     * @throws IllegalArgumentException Exception si les paramètres d'entrées ne sont pas respéctés.
     */

    public Combinaison generateSecretCode(int nbPins, String difficulty, boolean allowDup){

        // En premier on vérifie le nb de Pins pour le code, ne doit pas être inf à 3 (peut être modifié à l'avenir).
        if(nbPins < 3){
            throw new IllegalArgumentException("Le nombre de Pins est trop bas\n");
        } else {
            System.out.printf("Le nombre de Pins(" + nbPins + ") est valide\n");
        }

        // Sélection de la liste de couleur du jeux en fonction de la difficulté selectionnée.
        Color[] colors;
        switch (difficulty) {
            case "EASY":
                System.out.printf("=== Difficulté choisie ===\n");
                System.out.printf("========== EASY ==========\n");
                colors = EASY_COLORS;
                System.out.printf("Les couleurs possibles sont " + Arrays.toString(colors) + "\n");
                break;

            case "MEDIUM":
                System.out.printf("=== Difficulté choisie ===\n");
                System.out.printf("========= MEDIUM =========\n");
                colors = MEDIUM_COLORS;
                System.out.printf("Les couleurs possibles sont " + Arrays.toString(colors) + "\n");
                break;

            case "HARD":
                System.out.printf("=== Difficulté choisie ===\n");
                System.out.printf("========== HARD ==========\n");
                colors = HARD_COLORS;
                System.out.printf("Les couleurs possibles sont " + Arrays.toString(colors) + "\n");
                break;

            default:
                throw new IllegalArgumentException("Difficulté invalide : " + difficulty + "\n");
        }

        // Création du code secret
        if (!allowDup) {
            System.out.printf("Les doublons de couleur ne sont pas autorisés par le joueur\n");
            return generateCodeWithoutDuplicates(nbPins, colors);
        } else {
            System.out.printf("Les doublons de couleur sont autorisés par le joueur\n");
            return generateCodeWithDuplicates(nbPins, colors);
        }
    }

    /**
     * Génère un code secret avec doublons possibles
     */

    public static Combinaison generateCodeWithDuplicates(int nbPins, Color[] colors){
        // La fonction est appelée dans generateSecretCode donc nbPins forcément bon, pas besoin de verifier
        // Initialisation du tableau de pings avec la longueur du nombre de pins en param
        Ping[] pings = new Ping[nbPins];

        // Choix des couleurs aléatoire
        System.out.printf("Création de la combinaison de couleur aléatoire\n");
        int i; // Compteur non initialisé
        int longueur = colors.length;
        for ( i = 0 ; i < nbPins ; i++ ){
            int randomIndex = random.nextInt(longueur);
            Color selectedColor = colors[randomIndex];
            pings[i] = new Ping(selectedColor, i);
        }

        // Création de la combinaison avec les pings
        Combinaison combinaison = new Combinaison(pings);
        System.out.printf("Création de la combinaison de couleur aléatoire terminée ==> " + combinaison.toString() + "\n");

        return combinaison;
    }

    /**
     * Génère un code secret sans doublons
     */
    public static Combinaison generateCodeWithoutDuplicates(int nbPins, Color[] colors){
        // Un ArrayList est plus simple pour les actions de modifications.
        List<Color> new_colors = new ArrayList<>();

        // Donc on attribue les couleurs à une nouvelle matrice
        int i;
        int longueur = colors.length;
        for( i = 0 ; i < longueur ; i ++ ){
            new_colors.add(colors[i]);
        }

        // Création de la combinaison secrète sans doublons de couleurs
        System.out.printf("Début de la création de la combinaison secrète sans doublons de couleurs \n");
        Ping[] pings = new Ping[nbPins];
        for( i = 0 ; i < nbPins ; i++ ){
            int randomIndex = random.nextInt(new_colors.size());
            Color selectedColor = new_colors.get(randomIndex);
            pings[i] = new Ping(selectedColor, i);
            new_colors.remove(randomIndex);
        }

        // Création de la combinaison avec les pings
        Combinaison combinaison = new Combinaison(pings);
        System.out.printf("Fin de la création de la combinaison secrète sans doublons de couleurs ==> " + combinaison.toString() + "\n");

        return combinaison;
    }

    /**
     * Compare une combinaison secrète avec celle du joueur (étape 1 : pins blancs / noirs)
     */
    public static void verifyCombiSecrete(String[] args) {
    String[] secret = generateSecretCode(4, "MEDIUM", false);
    String[] essai = {"blue", "red", "yellow", "green"};

    List<String> resultats = new ArrayList<>();

    // Tableaux pour savoir quelles positions sont déjà utilisées
    boolean[] secretUsed = new boolean[secret.length];
    boolean[] essaiUsed = new boolean[essai.length];

    // === Étape 1 : les pins rouges (bonne couleur, bonne position)
    for (int i = 0; i < essai.length; i++) {
        if (essai[i].equalsIgnoreCase(secret[i])) {
            resultats.add("pin rouge");
            secretUsed[i] = true;
            essaiUsed[i] = true;
        } else {
            resultats.add(""); // on remplit temporairement
        }
    }

    // === Étape 2 : les pins blancs (bonne couleur, mauvaise position)
    for (int i = 0; i < essai.length; i++) {
        if (essaiUsed[i]) continue; // déjà un pin rouge

        boolean found = false;
        for (int j = 0; j < secret.length; j++) {
            if (!secretUsed[j] && essai[i].equalsIgnoreCase(secret[j])) {
                found = true;
                secretUsed[j] = true;
                break;
            }
        }

        if (found) {
            resultats.set(i, "pin blanc");
        } else if (resultats.get(i).equals("")) {
            resultats.set(i, "pin noir");
        }
    }

    // === Affichage final
    System.out.println("Combinaison secrète : " + Arrays.toString(secret));
    System.out.println("Essai du joueur     : " + Arrays.toString(essai));
    System.out.println("Résultat final      : " + resultats);
    }

    /**
     * Méthode main pour tester les méthodes de la classe Utils
     */
    public static void main(String[] args) {
        System.out.println("=== Test de Utils ===\n");

        // Création d'une instance de utils pour accéder aux constantes non-static
        utils utilsInstance = new utils();

        // Test 1 : Génération avec doublons
        Combinaison code1 = utilsInstance.generateSecretCode(4, "HARD", true);
        System.out.println("Code Easy avec doublons : " + code1.toString() + "\n");

        // Test 2 : Génération sans doublons
        Combinaison code2 = utilsInstance.generateSecretCode(4, "HARD", false);
        System.out.println("Code Easy sans doublons : " + code2.toString() + "\n");
    }
} 
