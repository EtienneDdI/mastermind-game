public class Color{

    // Paramètres privés de la class
    private String color;

    // Constructeur de la class
    public Color(String color){
        this.color = color;
    }

    // =================
    // =====GETTER======
    // =================

    public String getColor(){
        return this.color;
    }

    // =================
    // =====SETTER======
    // =================

    public void newColor(String new_color){
        this.color = new_color;
    }

    /**
     * @return Retourne une représentation string de la couleur
     */
    @Override
    public String toString(){
        return this.color;
    }

    /**
     * Méthode main pour tester la classe Color
     */
    public static void main(String[] args) {
        System.out.println("=== Test de la classe Color ===\n");

        // Test 1
        Color Red = new Color("Red");
        System.out.println(Red.getColor());
        Red.newColor("Blue");
        System.out.println(Red.getColor());
    }
}