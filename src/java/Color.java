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
     * Compare deux objets Color pour vérifier s'ils représentent la même couleur
     * @param obj L'objet à comparer
     * @return true si les couleurs sont identiques, false sinon
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Color other = (Color) obj;
        return this.color.equals(other.color);
    }

    /**
     * Génère un hashCode basé sur la couleur
     * @return Le hashCode de la couleur
     */
    @Override
    public int hashCode(){
        return color.hashCode();
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