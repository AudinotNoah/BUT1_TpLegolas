/**
 * Classe de test (main) pour simuler un combat entre differents guerriers et arcs.
 */
public class ProgCombat {
    public static void main(String[] args) {
        // Creation de deux guerriers
        Guerrier legolas = new Guerrier("Legolas", 4);
        Guerrier orc = new Guerrier("Ugluk", 3);

        // Affichage des guerriers
        System.out.println(legolas);
        System.out.println(orc);

        // Legolas attaque Ugluk
        legolas.attaquer(orc);
        System.out.println(legolas);
        System.out.println(orc);

        // Creation d'un arc elfique avec 2 points de degats et 1 fleche
        // Et Legolas recupere l'arc
        Arc arcElfique = new Arc(2, 1);
        legolas.prendreArc(arcElfique);
        System.out.println(legolas);

        // Legolas attaque Ugluk avec l'arc elfique 
        legolas.attaquer(orc);
        System.out.println(orc);
        System.out.println(legolas);

        // Ugluk est attaque une fois de plus
        legolas.attaquer(orc);
        System.out.println(orc);

        // Creation d'un arc orc avec 5 points de degats et 3 fleches, et Ugluk prend l'arc
        Arc orcArc = new Arc(5, 3);
        orc.prendreArc(orcArc);
        System.out.println(orc);

        // Ugluk attaque Legolas
        orc.attaquer(legolas);
        System.out.println(legolas);
        System.out.println(orc);

        // Creation d'un nouveau guerrier Arwen avec 10 points de vie
        Guerrier arwen = new Guerrier("Arwen", 10);
        System.out.println(arwen);

        // Arwen prend l'arc elfique
        arwen.prendreArc(arcElfique);
        System.out.println(arwen);

        // Rechargement de l'arc d'Arwen avec 1 fleche
        arwen.getArc().recharger(1);
        System.out.println(arwen);

        // Arwen attaque Ugluk
        arwen.attaquer(orc);
        System.out.println(orc);
        System.out.println(arwen);

        // Arwen attaque encore Ugluk
        arwen.attaquer(orc);
        System.out.println(orc);
        System.out.println(arwen);
    }
}
