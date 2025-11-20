public class Ping{

    // Paramètres privés de la class
    private Color color;
    private int index;
    private boolean colorInCode;
    private boolean sameIndex;

    // Constructeur du Ping 
    public Ping(Color color, int index){
        this.color = color;
        this.index = index;
        this.colorInCode = false;
        this.sameIndex = false;
    }

    // =================
    // =====GETTER======
    // =================

    /**
     * @return Retourne la couleur du ping
     */

    public Color getColor(){
        return this.color;
    }

    /**
     * @return Retourne l'indice
     */

    public int getIndex(){
        return this.index;
    }

    /**
     * @return Retourne un bool si la couleur est dans le code
     */

    public boolean getColorInCode(){
        return this.colorInCode;
    }

    /**
     * @return Retourne un bool si la couleur est dans le code et au même index 
     */

    public boolean getSameIndex(){
        return this.sameIndex;
    }

    // =================
    // =====SETTER======
    // =================

     /**
     * @param new_index Set le nouvel indice que l'on attribue
     */

    public void setIndex(int new_index){
        this.index = new_index;
    }

    /**
     * @param new_colorInCode Set le nouvel état de colorInCode
     */

    public void setColorInCode(boolean new_colorInCode){
        this.colorInCode = new_colorInCode;
    }

    /**
     * @param new_sameIndex Set le nouvel état de sameIndex 
     */

    public void setSameIndex(boolean new_sameIndex){
        this.sameIndex = new_sameIndex;
    }

    /**
     * Méthode main pour tester la classe Ping
     */
    public static void main(String[] args) {
        System.out.println("=== Test de la classe Ping ===\n");

        // Création d'une couleur pour le test
        Color testColor = new Color("Rouge");

        // Test du constructeur
        System.out.println("--- Test du constructeur ---");
        Ping ping1 = new Ping(testColor, 0);
        System.out.println("Ping créé avec index: " + ping1.getIndex());
        System.out.println("Ping créé avec la couleur: " + ping1.color.getColor()); // Méthode héritée de la class Color
        System.out.println("colorInCode initial: " + ping1.getColorInCode());
        System.out.println("sameIndex initial: " + ping1.getSameIndex());
        System.out.println();

        // Test des setters
        System.out.println("--- Test des setters ---");

        // Test setIndex
        System.out.println("Changement de l'index de 0 à 3");
        ping1.setIndex(3);
        System.out.println("Nouvel index: " + ping1.getIndex());
        System.out.println();

        // Test setColorInCode
        System.out.println("Changement de colorInCode à true");
        ping1.setColorInCode(true);
        System.out.println("Nouveau colorInCode: " + ping1.getColorInCode());
        System.out.println();

        // Test setSameIndex
        System.out.println("Changement de sameIndex à true");
        ping1.setSameIndex(true);
        System.out.println("Nouveau sameIndex: " + ping1.getSameIndex());
        System.out.println();

        // Test complet avec un deuxième objet
        System.out.println("--- Test avec un deuxième Ping ---");
        Color testColor2 = new Color("Bleu");
        Ping ping2 = new Ping(testColor2, 2);
        System.out.println("Ping2 index: " + ping2.getIndex());

        ping2.setColorInCode(true);
        ping2.setSameIndex(false);
        System.out.println("Ping2 colorInCode: " + ping2.getColorInCode());
        System.out.println("Ping2 sameIndex: " + ping2.getSameIndex());
        System.out.println();

        System.out.println("=== Tous les tests sont terminés ===");
    }
}