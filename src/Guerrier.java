/**
 * La classe Guerrier represente un personnage de type guerrier avec un nom, des points de vie,
 * et la possibilite de posseder un arc pour attaquer.
 */
public class Guerrier {
    private String nom;  // Le nom du guerrier
    private int pv;      // Les points de vie du guerrier
    private Arc arc;     // L'arc que le guerrier peut posseder

    /**
     * Constructeur de la classe Guerrier.
     * Cree un guerrier avec un nom donne et initialise ses points de vie à 10.
     *
     * @param pNom Le nom du guerrier.
     */
    public Guerrier(String pNom) {
        this.nom = pNom;
        this.pv = 10;
        this.arc = null;
    }

    /**
     * Constructeur de la classe Guerrier avec la possibilite de specifier les points de vie.
     * Cree un guerrier avec un nom donne et initialise ses points de vie à une valeur donnee.
     * Si la valeur donnee est inferieure à 1, les points de vie sont fixes à 1.
     *
     * @param pNom Le nom du guerrier.
     * @param p Les points de vie du guerrier.
     */
    public Guerrier(String pNom, int p) {
        this.nom = pNom;
        this.arc = null;
        if (p < 1) { // Si les points de vie specifies sont inferieurs à 1, les points de vie sont fixes à 1 sinon ils sont fixes à p 
            this.pv = 1;
        } else {
            this.pv = p;
        }
    }

    /**
     * Recupere les points de vie actuels du guerrier.
     *
     * @return Les points de vie du guerrier.
     */
    public int getPv() {
        return this.pv;
    }

    /**
     * Recupere l'arc possede par le guerrier, s'il en a un.
     *
     * @return L'arc du guerrier, ou null s'il n'en possede pas.
     */
    public Arc getArc() {
        return this.arc;
    }

    /**
     * Recupere le nom du guerrier.
     *
     * @return Le nom du guerrier.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Verifie si le guerrier a ete blesse (a 0 points de vie).
     *
     * @return Vrai si le guerrier a ete blesse, sinon faux.
     */
    public boolean etreBlesse() {
        return this.pv == 0; // Vrai si les points de vie du guerrier sont egaux à 0, sinon faux.
    }

    /**
     * Fait subir des degats au guerrier. Les degats doivent être superieurs à 0.
     * Les points de vie du guerrier sont reduits en consequence, avec un minimum de 0 points de vie.
     *
     * @param degat Les degats à infliger au guerrier.
     */
    public void subirDegat(int degat) {
        if (degat > 0) {
            this.pv -= degat;
            if (this.pv < 0) { // Si les degâts specifies sont superieurs à 0, les points de vie sont reduits, avec un minimum de 0 points de vie.
                this.pv = 0; 
            }
        }
    }

    /**
     * Fait en sorte que le guerrier prenne un arc s'il n'en a pas dejà un et s'il a des points de vie.
     *
     * @param arc L'arc à prendre.
     * @return Vrai si le guerrier a pris l'arc, sinon faux.
     */
    public boolean prendreArc(Arc arc) {
        if (this.arc == null && this.pv > 0) { // Si le guerrier n'a pas d'arc et a des points de vie, il prend l'arc specifie.
            this.arc = arc; 
            return true;
        }
        return false;
    }

    /**
     * Fait en sorte que le guerrier pose son arc s'il en possede un et s'il a des points de vie.
     *
     * @return L'arc qui a ete pose, ou null s'il n'y avait pas d'arc à poser.
     */
    public Arc poserArc() {
        if (this.arc != null && this.pv > 0) { // Si le guerrier possede un arc et a des points de vie, il pose l'arc.
            Arc arc_temp = this.arc;
            this.arc = null; 
            return arc_temp;
        }
        return null;
    }

    /**
     * Permet au guerrier d'attaquer un autre guerrier s'il a des points de vie.
     * Les degats infliges dependent de l'arc du guerrier s'il en possede un.
     *
     * @param victime Le guerrier à attaquer.
     * @return Vrai si l'attaque a reussi (la victime a perdu des points de vie), sinon faux.
     */
    public boolean attaquer(Guerrier victime) {
        if (this.pv > 0) { // Si le guerrier a des pvs
            int vieDepart = victime.getPv();
            int degat = 0;
            if (this.arc != null) { // Si le guerrier a un arc, il utilise l'arc pour infliger des degâts.
                degat = this.arc.utiliser(); 
            }
            victime.subirDegat(degat); // La victime subit les degâts infliges par l'attaque.
            int vieFin = victime.getPv();
            return vieFin < vieDepart;
        }
        return false;
    }

    /**
     * Fournit une representation sous forme de chaîne de caracteres du guerrier,
     * y compris son nom, ses points de vie et les informations sur son arc s'il en possede un.
     *
     * @return Une chaîne de caracteres representant le guerrier.
     */
    public String toString() {
        String NomPv = this.nom + "(" + this.pv + ")";
        String InfosArc = "";
        if (this.arc != null) { // si le guerrier a un arc on affiche aussi son arc
            InfosArc = "-arc(d:" + this.arc.getDegats() + ",f:" + this.arc.getFleches() + ")";
        }
        return NomPv + InfosArc;
    }
}
