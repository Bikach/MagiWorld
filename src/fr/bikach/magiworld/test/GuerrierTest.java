package fr.bikach.magiworld.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import fr.bikach.magiworld.personnage.Guerrier;
import fr.bikach.magiworld.personnage.Personnage;
import fr.bikach.magiworld.personnage.Rodeur;

class GuerrierTest {
	
	// niveau = 50 ,  force = 20, agilité = 20, intéligence = 10.
	Personnage guerrier = new Guerrier(50, 20, 20, 10);
	Personnage adversaire = new Rodeur();
	
	@Test
	public void GIVEN_forceGuerrierEgale20_WHEN_guerrierAttaqueBassique_THEN_adversaireVieMoin20() {
		adversaire.setVie(100);
		guerrier.attaqueBassique(adversaire);
		assertEquals(80, adversaire.getVie());
	}
	
	
	@Test
	public void GIVEN_forceGuerrierEgale20_WHEN_guerrierAttaqueSpeciale_THEN_adversaireVieMoin40_AND_guerrierVieMoin10() {
		adversaire.setVie(80);
		guerrier.attaqueSpeciale(adversaire);
		assertEquals(40, adversaire.getVie());
		assertEquals(240, guerrier.getVie());
	}

}
