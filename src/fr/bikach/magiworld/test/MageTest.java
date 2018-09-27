package fr.bikach.magiworld.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import fr.bikach.magiworld.personnage.Mage;
import fr.bikach.magiworld.personnage.Personnage;
import fr.bikach.magiworld.personnage.Rodeur;

class MageTest {

	// niveau = 50 , vie = 250, force = 20, agilité = 10, intéligence = 20.
	Personnage mage = new Mage(50, 250, 20, 10, 20);
	
	@Test
	void GIVEN_inteligenceMageEgale20_WHEN_mageAttaqueBassique_THEN_adversaireVieMoin20() {
		Personnage adversaire = new Rodeur();
		adversaire.setVie(60);
		mage.attaqueBassique(adversaire);
		assertEquals(40, adversaire.getVie());
	}
	 
	@Test
	void GIVEN_inteligenceMageEgale20_WHEN_mageAttaqueSpeciale_THEN_mageViePlus40() {
		mage.setVie(100);
		mage.attaqueSpeciale(mage);
		assertEquals(140, mage.getVie());
	}
	
	@Test
	void GIVEN_mageVie240_WHEN_mageAttaqueSpeciale_THEN_mageViePlus10() {
		mage.setVie(240);
		mage.attaqueSpeciale(mage);
		assertEquals(250, mage.getVie());
	}

}
