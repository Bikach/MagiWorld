package fr.bikach.magiworld.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import fr.bikach.magiworld.personnage.Mage;
import fr.bikach.magiworld.personnage.Personnage;
import fr.bikach.magiworld.personnage.Rodeur;

class RodeurTest {
	
	// niveau = 50 ,  force = 20, agilité = 10, intéligence = 20.
	Personnage rodeur = new Rodeur(50, 20, 10, 20);
	
	@Test
	public void GIVEN_agiliteRodeurEgale10_WHEN_rodeurAttaqueBassique_THEN_adversaireVieMoin10() {
		Personnage adversaire = new Mage();
		adversaire.setVie(100);
		rodeur.attaqueBassique(adversaire);
		assertEquals(90, adversaire.getVie());
	}
	
	@Test
	public void GIVEN_niveauRodeurEgale50_WHEN_rodeurAttaqueSpeciale_THEN_rodeurAgilitePlus25() {
		rodeur.attaqueSpeciale(rodeur);
		assertEquals(35, rodeur.getAgilite());
	}
}
