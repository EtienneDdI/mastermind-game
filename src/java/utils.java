import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class utils {

    // Initialisation des listes de couleurs
    private static final String[] EASY_COLORS = {"red", "blue", "green", "yellow"};
    private static final String[] MEDIUM_COLORS = {"red", "blue", "green", "yellow", "purple", "orange"};
    private static final String[] HARD_COLORS = {"red", "blue", "green", "yellow", "purple", "orange", "brown", "pink"};

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
    public static String[] generateSecretCode(int nbPins, String difficulty, boolean allowDup) {

        // Vérification du nombre de pins
        if (nbPins < 3) {
            throw new IllegalArgumentException("Le nombre de Pins est trop bas\n");
        } else {
            System.out.printf("Le nombre de Pins(" + nbPins + ") est valide\n");
        }

        // Sélection des couleurs selon la difficulté
        String[] colors;
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
    public static String[] generateCodeWithDuplicates(int nbPins, String[] colors) {
        String[] code = new String[nbPins];
        System.out.printf("Création de la combinaison de couleur aléatoire\n");

        for (int i = 0; i < nbPins; i++) {
            int randomIndex = random.nextInt(colors.length);
            code[i] = colors[randomIndex];
        }

        System.out.printf("Création terminée ==> " + Arrays.toString(code) + "\n");
        return code;
    }

    /**
     * Génère un code secret sans doublons
     */
    public static String[] generateCodeWithoutDuplicates(int nbPins, String[] colors) {
        List<String> new_colors = new ArrayList<>(Arrays.asList(colors));

        System.out.printf("Début de la création de la combinaison secrète sans doublons\n");
        String[] code = new String[nbPins];
        for (int i = 0; i < nbPins; i++) {
            int randomIndex = random.nextInt(new_colors.size());
            code[i] = new_colors.remove(randomIndex);
        }

        System.out.printf("Fin de la création ==> " + Arrays.toString(code) + "\n");
        return code;
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

        // Test 1 : Génération avec doublons
        String[] code1 = generateSecretCode(4, "EASY", true);
        System.out.println("Code Easy avec doublons : " + Arrays.toString(code1) + "\n");

        // Test 2 : Génération sans doublons
        String[] code2 = generateSecretCode(4, "EASY", false);
        System.out.println("Code Easy sans doublons : " + Arrays.toString(code2) + "\n");

        // Test 3 : Vérification d'une combinaison
        verifyCombiSecrete(null);
    }
}
