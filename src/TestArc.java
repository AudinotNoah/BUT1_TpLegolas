import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/******************
 * test classe Arc
 *******************/
public class TestArc {

	/**
	 * methode de lancement des tests
	 */
	public static void main(String[] args) {
		lancer(new TestArc(), args);
	}

	/**
	 * verifie que les methodes sont bien appelee
	 */
	public void test_arc_methodes() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// verifications
		assertEquals("ordre parametres est mauvais",3,arc.getDegats());
		assertEquals("ordre parametres est mauvais",5,arc.getFleches());

		// methode testee
		arc.recharger(5);
		int dg = arc.utiliser();
		String s = arc.toString();
	}
	/**
	 * quand l'arc est creer par defaut
	 */
	public void test_constructeur_ParDefaut(){
		// preparation des donnees
		Arc arc = new Arc();

		// verifications
		assertEquals("degats arc incorrect",5,arc.getDegats());
		assertEquals("nombre de fleches incorrect",3,arc.getFleches());
	}
	/**
	 * quand l'arc est creer correctement
	 */
	public void test_constructeur_OK(){
		// preparation des donnees
		Arc arc = new Arc(7,8);

		// verifications
		assertEquals("degats arc incorrect",7,arc.getDegats());
		assertEquals("nombre de fleches incorrect",8,arc.getFleches());
	}

	/**
	 * quand l'arc est creer avec des valeurs negatives
	 */
	public void test_constructeur_ValeursNegatives(){
		// preparation des donnees
		Arc arc = new Arc(-4,-3);

		// verifications
		assertEquals("degats arc negatif au lieu de 0",0,arc.getDegats());
		assertEquals("nombre de fleches negatif au lieu de 0",0,arc.getFleches());
	}

	/**
	 * quand l'arc est recharge correctement
	 */
	public void test_recharger_OK() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.recharger(2);

		// verifications
		assertEquals("arc doit avoir 7 fleches", 7, arc.getFleches());
	}

	/**
	 * quand l'arc est recharge avec un nombre de fleches negatif
	 */
	public void test_recharger_NombreFlechesNegative() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.recharger(-2);

		// verifications
		assertEquals("arc doit toujours avoir 5 fleches", 5, arc.getFleches());
	}

	/**
	 * quand l'arc est utilise corretement
	 */
	public void test_utiliser_OK() {
		// preparation des donnees
		Arc arc = new Arc(7,8);

		// methode testee
		int degats = arc.utiliser();

		// verifications
		assertEquals("arc doit faire 7 degats", 7, degats);
		assertEquals("arc doit avoir 7 fleches", 7, arc.getFleches());
	}

	/**
	 * quand l'arc est utilise sans avoir de fleches
	 */
	public void test_utiliser_SansAvoirFleches() {
		// preparation des donnees
		Arc arc = new Arc(7,0);

		// methode testee
		int degats = arc.utiliser();

		// verifications
		assertEquals("arc ne doit pas faire de degats", 0, degats);
	}

	/**
	 * quand arc est affiche
	 */
	public void test_toString_OK(){
		// preparation des donnees
		Arc arc = new Arc(7,8);

		// methode testee
		String val = arc.toString();

		// verifications
		assertEquals("Reponse toString incorrecte", "-arc(d:7,f:8)", val);
	}
}