//import libtest.Test;

import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;


/**
 * classe de test qui permet de verifier que la classe Arc
 * fonctionne correctement
 */
public class TestGuerrier {

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestGuerrier(), args);
	}

	/**
	 * test des methodes de guerrier
	 */
	// @Test
	public void test_guerrier_methodes() {
		Guerrier guerrier = new Guerrier("Toto",10);
		int pv = guerrier.getPv();
		Arc arc = guerrier.getArc();
		String nom = guerrier.getNom();

		boolean b = guerrier.etreBlesse();
		guerrier.subirDegat(1);

		Arc arcN =new Arc();
		boolean resPrendre = guerrier.prendreArc(arcN);
		Arc resPoser =guerrier.poserArc();

		Guerrier victime = new Guerrier("vict");
		boolean resAttaque = guerrier.attaquer(victime);

		String guerrierS = guerrier.toString();
	}

	/**
	 * quand le guerrier est creer par defaut 
	 */
	public void test_constructeur_ParDefaut(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom");

		// verifications
		assertEquals("Nom incorrect","TestNom",guerrier.getNom());
		assertEquals("pv incorrect",10,guerrier.getPv());
		assertEquals("Arc est sense etre null",null,guerrier.getArc());

	}

	/**
	 * quand le guerrier est creer correctement
	 */
	public void test_constructeur_OK(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom",8);

		// verifications
		assertEquals("Nom incorrect","TestNom",guerrier.getNom());
		assertEquals("pv incorrect",8,guerrier.getPv());
		assertEquals("Arc est sense etre null",null,guerrier.getArc());

	}

	/**
	 * quand le guerrier est creer avec des pv negatif
	 */
	public void test_constructeur_PvNegatif(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom",-5);

		// verifications
		assertEquals("pv incorrect",1,guerrier.getPv());

	}

	/**
	 * quand le guerrier est blesse
	 */
	public void test_etreBlesse_OK(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom",10);

		// methode testee
		guerrier.subirDegat(15);

		// verifications
		assertEquals("etreBlesse aurait du renvoyer true",true,guerrier.etreBlesse());
	}

	/**
	 * quand le guerrier subit des degats corrcetement
	 */
	public void test_subirDegats_OK(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom",10);

		// methode testee
		guerrier.subirDegat(5);

		// verifications
		assertEquals("pv incorrect",5,guerrier.getPv());
	}

	/**
	 * quand le guerrier subit des degats negatif
	 */
	public void test_subirDegats_DegatsNegatif(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom",10);

		// methode testee
		guerrier.subirDegat(-5);

		// verifications
		assertEquals("pv incorrect",10,guerrier.getPv());
	}

	/**
	 * quand le guerrier subit des degats plus grands que ses pv
	 */
	public void test_subirDegats_SuperieurPv(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom",10);

		// methode testee
		guerrier.subirDegat(15);

		// verifications
		assertEquals("pv incorrect",10,guerrier.getPv());
	}

	/**
	 * quand le guerrier subit des degats sans avoir de la vie
	 */
	public void test_subirDegats_GuerrierVieNegative(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom",1);
		Guerrier guerrier2 = new Guerrier("TestNom",1);

		// methode testee
		guerrier.subirDegat(1);
		guerrier.subirDegat(5);
		guerrier2.subirDegat(4000);

		// verifications
		assertEquals("pv incorrect",0,guerrier.getPv());
		assertEquals("pv incorrect",0,guerrier.getPv());
	}

	/**
	 * quand le guerrier prend un arc correctement
	 */
	public void test_prendreArc_OK(){
		// preparation des donnees
		Arc arc = new Arc();
		Guerrier guerrier = new Guerrier("TestNom");
		
		// methode testee
		Boolean rep = guerrier.prendreArc(arc);

		// verifications
		assertEquals("le guerrier ne possede par l'arc",arc,guerrier.getArc());
		assertEquals("prendreArc n'a pas renvoye la valeur true",true,rep);

	}

	/**
	 * quand le guerrier prend un arc en etant blesse
	 */
	public void test_prendreArc_GuerrierBlesse(){
		// preparation des donnees
		Arc arc = new Arc();
		Guerrier guerrier = new Guerrier("TestNom");
		
		// methode testee
		guerrier.subirDegat(1000);
		Boolean rep = guerrier.prendreArc(arc);

		// verifications
		assertEquals("le guerrier ne devrait par avoir d'arc",null,guerrier.getArc());
		assertEquals("prendreArc n'a pas renvoye la valeur false",false,rep);
		
	}

	/**
	 * quand le guerrier prend un arc en ayant deja un arc
	 */
	public void test_prendreArc_GuerrierPossedeArc(){
		// preparation des donnees
		Arc arc = new Arc();
		Arc arc2 = new Arc();
		Guerrier guerrier = new Guerrier("TestNom");
		
		// methode testee
		guerrier.prendreArc(arc);
		guerrier.prendreArc(arc2);

		// verifications
		assertEquals("le guerrier ne devrait par avoir un nouvelle arc",arc,guerrier.getArc());
		
	}

	/**
	 * quand le guerrier pose son arc correctement
	 */
	public void test_poserArc_OK(){
		// preparation des donnees
		Arc arc = new Arc();
		Guerrier guerrier = new Guerrier("TestNom");
		
		// methode testee
		guerrier.prendreArc(arc);
		Arc arc2 = guerrier.poserArc();

		// verifications
		assertEquals("le guerrier possede toujours l'arc",null,guerrier.getArc());
		assertEquals("l'arc renvoye n'est pas le bon",arc,arc2);

	}

	/**
	 * quand le guerrier pose son arc en etant blesse
	 */
	public void test_poserArc_GuerrierBlesse(){
		// preparation des donnees
		Arc arc = new Arc();
		Guerrier guerrier = new Guerrier("TestNom");
		
		// methode testee
		guerrier.prendreArc(arc);
		guerrier.subirDegat(3000);
		guerrier.poserArc();

		// verifications
		assertEquals("le guerrier ne devrait avoir poser l'arc",arc,guerrier.getArc());
		
	}

	/**
	 * quand le guerrier essaye pose un arc sans en avoir un 
	 */
	public void test_poserArc_GuerrierPasArc(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom");
		
		// methode testee
		Arc arc = guerrier.poserArc();

		// verifications
		assertEquals("La methode aurait du renvoye null",null,arc);
		
	}

	/**
	 * quand le guerrier attaque correctement
	 */
	public void test_attaquer_OK(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom");
		Guerrier guerrier2 = new Guerrier("TestNom2");
		Arc arc = new Arc();

		// methode testee
		guerrier.prendreArc(arc);
		boolean rep = guerrier.attaquer(guerrier2);

		// verifications
		assertEquals("Le guerrier n'a pas reçu le nombre attendu de degats", 5, guerrier2.getPv());
		assertEquals("attaquer n'a pas renvoye la valeur true",true,rep);
		assertEquals("Arc du guerrier n'a pas le nombre de fleches attendu", 2, guerrier.getArc().getFleches());

	}

	/**
	 * quand le guerrier attaque sans avoir de pv
	 */
	public void test_attaquer_GuerrierPvNul(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom");
		Guerrier guerrier2 = new Guerrier("TestNom2");
		Arc arc = new Arc();

		// methode testee
		guerrier.prendreArc(arc);
		guerrier.subirDegat(1000);
		boolean rep = guerrier.attaquer(guerrier2);

		// verifications
		assertEquals("Le guerrier n'aurait pas du recevoir des degats", 10, guerrier2.getPv());
		assertEquals("attaquer n'a pas renvoye la valeur false",false,rep);
		assertEquals("Arc du guerrier n'a pas le nombre de fleches attendu", 3, guerrier.getArc().getFleches());
		
	}

	/**
	 * quand le guerrier attaque sans avoir d'arc
	 */
	public void test_attaquer_GuerrierSansArc(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom");
		Guerrier guerrier2 = new Guerrier("TestNom2");

		// methode testee
		boolean rep = guerrier.attaquer(guerrier2);

		// verifications
		assertEquals("Le guerrier n'aurait pas du recevoir des degats", 10, guerrier2.getPv());
		assertEquals("attaquer n'a pas renvoye la valeur false",false,rep);

	}

	/**
	 * quand le guerrier attaque sans avoir de fleche
	 */
	public void test_attaquer_ArcSansFleches(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom");
		Guerrier guerrier2 = new Guerrier("TestNom2");
		Arc arc = new Arc(3,0);

		// methode testee
		guerrier.prendreArc(arc);
		guerrier.attaquer(guerrier2);

		// verifications
		assertEquals("Le guerrier n'aurait pas du recevoir des degats", 10, guerrier2.getPv());	}

	/**
	 * quand guerrier est affiche sans arc
	 */
	public void test_toString_SansArc(){
		// preparation des donnees
		Guerrier guerrier = new Guerrier("TestNom",15);


		// methode testee
		String val = guerrier.toString();

		// verifications
		assertEquals("Reponse toString incorrecte", "TestNom(15)", val);

	}

	/**
	 * quand guerrier est affiche sans arc avec arc
	 */
	public void test_toString_AvecArc(){
		// preparation des donnees
		Arc arc = new Arc(7,8);
		Guerrier guerrier = new Guerrier("TestNom",15);

		// methode testee
		guerrier.prendreArc(arc);
		String val = guerrier.toString();

		// verifications
		assertEquals("Reponse toString incorrecte", "TestNom(15)-arc(d:7,f:8)", val);

	}

}
