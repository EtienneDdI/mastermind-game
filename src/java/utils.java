import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class utils {

    // Initialisation des couleurs
    private static final Color red = new Color("red");
    private static final Color blue = new Color("blue");
    private static final Color green = new Color("green");
    private static final Color yellow = new Color("yellow");
    private static final Color purple = new Color("purple");
    private static final Color orange = new Color("orange");
    private static final Color brown = new Color("brown");
    private static final Color pink = new Color("pink");

    // Initialisation des listes de couleurs
    private static final Color[] EASY_COLORS = {red, blue, green, yellow};
    private static final Color[] MEDIUM_COLORS = {red, blue, green, yellow, purple, orange};
    private static final Color[] HARD_COLORS = {red, blue, green, yellow, purple, orange, brown, pink};

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

    public static Combinaison generateSecretCode(int nbPins, String difficulty, boolean allowDup){

        // En premier on vérifie le nb de Pins pour le code, ne doit pas être inf à 3 (peut être modifié à l'avenir).
        if(nbPins < 3){
            throw new IllegalArgumentException("Le nombre de Pins est trop bas\n");
        } else {
            System.out.printf("Le nombre de Pins(" + nbPins + ") est valide\n");
        }

        // Sélection de la liste de couleur du jeux en fonction de la difficulté selectionnée.
        Color[] colors;
        switch (difficulty) {
            case "EASY" -> {
                System.out.printf("=== Difficulté choisie ===\n");
                System.out.printf("========== EASY ==========\n");
                colors = EASY_COLORS;
                System.out.printf("Les couleurs possibles sont " + Arrays.toString(colors) + "\n");
            }

            case "MEDIUM" -> {
                System.out.printf("=== Difficulté choisie ===\n");
                System.out.printf("========= MEDIUM =========\n");
                colors = MEDIUM_COLORS;
                System.out.printf("Les couleurs possibles sont " + Arrays.toString(colors) + "\n");
            }

            case "HARD" -> {
                System.out.printf("=== Difficulté choisie ===\n");
                System.out.printf("========== HARD ==========\n");
                colors = HARD_COLORS;
                System.out.printf("Les couleurs possibles sont " + Arrays.toString(colors) + "\n");
            }

            default -> throw new IllegalArgumentException("Difficulté invalide : " + difficulty + "\n");
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
    public static Resultats verifyCombiSecrete(Combinaison secret, Combinaison essai, int nb_essais) {

        Resultats resultats = new Resultats();

        boolean[] secretUsed = new boolean[secret.size()];
        boolean[] essaiUsed = new boolean[essai.size()];

        // === Étape 1 : pins rouges (bonne couleur à la bonne position)
        for (int i = 0; i < essai.size(); i++) {
            if (essai.getPing(i).getColor().equals(secret.getPing(i).getColor())) {
                resultats.getPinRouge().addNB();
                secretUsed[i] = true;
                essaiUsed[i] = true;
            }
        }

        // === Étape 2 : pins blancs (bonne couleur mais mauvaise position)
        for (int i = 0; i < essai.size(); i++) {

            if (essaiUsed[i]) continue;

            boolean found = false;
            for (int j = 0; j < secret.size(); j++) {
                if (!secretUsed[j]
                    && essai.getPing(i).getColor().equals(secret.getPing(j).getColor())) {

                    found = true;
                    secretUsed[j] = true;
                    break;
                }
            }

            if (found) {
                resultats.getPinBlanc().addNB();
            } else {
                // === Étape 3 : pins noirs (couleur absente de la combinaison)
                resultats.getPinNoir().addNB();
            }
        }

        resultats.setNbEssai(nb_essais);
        resultats.setEssai(essai);

        System.out.println("Combinaison secrète : " + secret.toString());
        System.out.println("Essai du joueur     : " + essai.toString());
        System.out.println("Résultat final      : " + resultats.getPinBlanc().getNB() + " pin blancs, " + resultats.getPinRouge().getNB() + " pin rouges, " + resultats.getPinNoir().getNB() + " pin noirs");
        System.out.println("Nombre d'essais     : " + resultats.getNbEssai());

        return resultats;
    }


    /**
     * Méthode main pour tester les méthodes de la classe Utils
     */
    public static void main(String[] args) {
        System.out.println("=== Test de Utils ===\n");

        // Création d'une instance de utils pour accéder aux constantes non-static
            
        Combinaison secret = generateSecretCode(4, "EASY", false);
        Combinaison essai = generateSecretCode(4, "EASY", false);

        verifyCombiSecrete(secret , essai, 1);

    //     // Test 1 : Génération avec doublons
    //     Combinaison code1 = generateSecretCode(4, "HARD", true);
    //     System.out.println("Code Easy avec doublons : " + code1.toString() + "\n");

    //     // Test 2 : Génération sans doublons
    //     Combinaison code2 = generateSecretCode(4, "HARD", false);
    //     System.out.println("Code Easy sans doublons : " + code2.toString() + "\n");
    }
} 
