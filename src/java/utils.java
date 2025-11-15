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

    // JavaDoc -- generateSecretCode
    /**
     * Génère le code secret
     * @param nbPins Nombre de couleur dans le code, par default 4.
     * @param difficulty Une des trois difficultés : "EASY", "MEDIUM", "HARD".
     * @param allowDup Si true, autorise les doublons de couleur dans le code secret.
     * @return retourne une liste de string (le code secret).
     * @throws IllegalArgumentException Exception si les paramètres d'entrés ne sont pas respéctés.
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

        // Création et retour du code secret généré.
        if ( !allowDup ){
            System.out.printf("Les doublons de couleur ne sont pas autorisés par le joueur\n");
            return generateCodeWithoutDuplicates(nbPins, colors);
        } else {
            System.out.printf("Les doublons de couleur sont autorisés par le joueur\n");
            return generateCodeWithDuplicates(nbPins, colors);
        }
    }

    // JavaDoc -- generateCodeWithDuplicates
    /**
     * Génère le code secret
     * @param nbPins Nombre de couleur dans le code, par default 4.
     * @param colors Les couleurs possibles pour la création du code secret
     * @return retourne une liste de string (le code secret avec doublons de couleurs).
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

    // JavaDoc -- generateCodeWithoutDuplicates
    /**
     * Génère le code secret
     * @param nbPins Nombre de couleur dans le code, par default 4.
     * @param colors Les couleurs possibles pour la création du code secret
     * @return retourne une liste de string (le code secret sans doublons de couleurs).
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
     * Mérhode main pour tester les méthodes de la classe Utils
     * Similaire à if __name__ == "__main__" en python
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