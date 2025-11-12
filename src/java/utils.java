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

    // JavaDoc -- generateSecretCode
    /**
     * Génère le code secret
     * @param nbPins Nombre de couleur dans le code, par default 4.
     * @param difficulty Une des trois difficultés : "EASY", "MEDIUM", "HARD".
     * @param allowDup Si true, autorise les doublons de couleur dans le code secret.
     * @return retourne une liste de string (le code secret).
     * @throws IllegalArgumentException Exception si les paramètres d'entrés ne sont pas respéctés.
     */

    public static String[] generateSecretCode(int nbPins, String difficulty, boolean allowDup){

        // En premier on vérifie le nb de Pins pour le code, ne doit pas être inf à 3 (peut être modifié à l'avenir).
        if( nbPins < 3){
            throw new IllegalArgumentException("Le nombre de Pins est trop bas\n");
        } else {
            System.out.printf("Le nombre de Pins(" + nbPins + ") est valide\n");
        }

        // Sélection de la liste de couleur du jeux en fonction de la difficulté selectionnée.
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

    public static String[] generateCodeWithDuplicates(int nbPins, String[] colors){
        // La fonction est appelée dans generateSecretCode donc nbPins forcément bon, pas besoin de verifier
        // Initialisation du code avec la longeur du nombre de pins en param
        String[] code = new String[nbPins];

        // Choix des couleurs aléatoire
        System.out.printf("Création de la combinaison de couleur aléatoire\n");
        int i; // Compteur non initialisé
        int longueur = colors.length;
        for ( i = 0 ; i < nbPins ; i++ ){
            int randomIndex = random.nextInt(longueur);
            code[i] = colors[randomIndex];
        }
        System.out.printf("Création de la combinaison de couleur aléatoire terminée ==> " + Arrays.toString(code) + "\n");

        return code;
    }

    // JavaDoc -- generateCodeWithoutDuplicates
    /**
     * Génère le code secret
     * @param nbPins Nombre de couleur dans le code, par default 4.
     * @param colors Les couleurs possibles pour la création du code secret
     * @return retourne une liste de string (le code secret sans doublons de couleurs).
     */

    public static String[] generateCodeWithoutDuplicates(int nbPins, String[] colors){
        // Un ArrayList est plus simple pour les actions de modifications. 
        List<String> new_colors = new ArrayList<>();

        // Donc on attribue les couleurs à une nouvelle matrice
        int i;
        int longueur = colors.length;
        for( i = 0 ; i < longueur ; i ++ ){
            new_colors.add(colors[i]);
        }

        // Création de la combinaison secrète sans doublons de couleurs
        System.out.printf("Début de la création de la combinaison secrète sans doublons de couleurs \n");
        String[] code = new String[nbPins];
        for( i = 0 ; i < nbPins ; i++ ){
            int randomIndex = random.nextInt(new_colors.size());
            code[i] = new_colors.get(randomIndex);
            new_colors.remove(randomIndex);
        }
        System.out.printf("Fin de la création de la combinaison secrète sans doublons de couleurs ==> " + Arrays.toString(code) + "\n");

        return code;
    }

    /**
     * Mérhode main pour tester les méthodes de la classe Utils
     * Similaire à if __name__ == "__main__" en python
     */

    public static void main(String[] args) {
        System.out.println("=== Test de Utils ===\n");
        
        // Test 1 : Génération avec doublons
        String[] code1 = generateSecretCode(4, "EASY", true);
        System.out.println("Code Easy avec doublons : " + Arrays.toString(code1) + "\n");

        // Test 2 : Génération avec doublons
        String[] code2 = generateSecretCode(4, "EASY", false);
        System.out.println("Code Easy sans doublons : " + Arrays.toString(code2) + "\n");
    }

} 