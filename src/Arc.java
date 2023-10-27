/**
 * La classe Arc represente un arc utilise comme arme.
 * Chaque arc a des degats et un certain nombre de fleches disponibles.
 */
public class Arc {
    private int degats;  // Les degats infliges par l'arc
    private int fleches; // Le nombre de fleches restantes dans l'arc

    /**
     * Constructeur par defaut de la classe Arc.
     * Cree un arc avec des degats de 5 et 3 fleches.
     */
    public Arc(){
        this.degats = 5;
        this.fleches = 3;
    }

    /**
     * Cree un arc avec des degats et un nombre de fleches specifies.
     * Les degats et le nombre de fleches doivent etre superieurs ou egaux à 0.
     *
     * @param dg Les degats de l'arc.
     * @param fl Le nombre de fleches dans l'arc.
     */
    public Arc(int dg, int fl){
        if (dg < 0) {
            dg = 0; // Si les degâts specifies sont negatifs, les degâts sont definis à 0.
        }
        if (fl < 0){
            fl = 0; // Si le nombre de fleches specifie est negatif, le nombre de fleches est defini à 0.
        }
        this.degats = dg;
        this.fleches = fl;
    }

    /**
     * Obtient les degats de l'arc.
     *
     * @return Les degats de l'arc.
     */
    public int getDegats(){
        return this.degats;
    }

    /**
     * Obtient le nombre de fleches restantes dans l'arc.
     *
     * @return Le nombre de fleches restantes dans l'arc.
     */
    public int getFleches(){
        return this.fleches;
    }

    /**
     * Recharge l'arc avec un nombre donne de fleches.
     *
     * @param nFleches Le nombre de fleches à ajouter à l'arc (doit etre superieur à 0).
     */
    public void recharger(int nFleches){
        if (nFleches > 0) {
            this.fleches += nFleches; // Seulement si nFleches est superieur à 0, les fleches sont ajoutees.
        }
    }

    /**
     * Utilise une fleche de l'arc, reduisant le nombre de fleches et renvoyant les degats infliges.
     *
     * @return Les degats infliges par l'arc (0 si aucune fleche n'est disponible).
     */
    public int utiliser(){
        if (this.fleches > 0) { // si l'arc possede des fleches
            this.fleches--; // Une fleche est utilisee reduisant le nombre de fleches de 1.
            return this.degats;
        }
        return 0;
    }

    /**
     * Renvoie une representation sous forme de chaîne de caracteres de l'arc.
     *
     * @return Une chaîne de caracteres representant l'arc au format : "-arc(d:degats,f:n_fleches)".
     */
    public String toString(){
        return "-arc(d:" + this.degats + ",f:" + this.fleches + ")";
    }
}
