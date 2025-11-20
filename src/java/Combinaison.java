public class Combinaison {

    // Attributs privés
    private Ping[] pings;

    // Constructeur de la Combinaison
    public Combinaison(Ping[] pings){
        this.pings = pings;
    }

    // =================
    // =====GETTER======
    // =================

    /**
     * @return Retourne le tableau de pings
     */
    public Ping[] getPings(){
        return this.pings;
    }

    /**
     * @param index L'index du ping à récupérer
     * @return Retourne le ping à l'index spécifié
     */
    public Ping getPing(int index){
        if(index >= 0 && index < pings.length){
            return this.pings[index];
        }
        throw new IndexOutOfBoundsException("Index " + index + " hors limites pour la combinaison de taille " + pings.length);
    }

    /**
     * @return Retourne le nombre de pings dans la combinaison
     */
    public int size(){
        return this.pings.length;
    }

    // =================
    // =====SETTER======
    // =================

    /**
     * @param index L'index du ping à modifier
     * @param ping Le nouveau ping
     */
    public void setPing(int index, Ping ping){
        if(index >= 0 && index < pings.length){
            this.pings[index] = ping;
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " hors limites pour la combinaison de taille " + pings.length);
        }
    }

    /** Fait par l'IA
     * @return Retourne une représentation string de la combinaison
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < pings.length; i++){
            sb.append(pings[i].getColor().getColor());
            if(i < pings.length - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}