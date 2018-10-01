package fr.bikach.magiworld.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.bikach.magiworld.deroulement.IPlateau;
import fr.bikach.magiworld.deroulement.PlateauImplementation;
import fr.bikach.magiworld.personnage.Guerrier;
import fr.bikach.magiworld.personnage.Mage;
import fr.bikach.magiworld.personnage.Personnage;

class PlateauImpTest {

	IPlateau plateau = new PlateauImplementation();
	Personnage adversaire = new Mage();	
	Personnage guerrier = new Guerrier(50, 20, 20, 10);
	Personnage mage = new Mage(50, 20, 20, 10);

	@Test
	public void GIVEN_joueurInstanceGuerrier_WHEN_joueurChoixAttaque1_THEN_adversaireVieMoin20() {
		adversaire.setVie(100);
		plateau.choixAttaque("Joueur 1", 1, guerrier, adversaire);
		assertEquals(80, adversaire.getVie());
		// Test l'affichage en console
	}
	
	@Test
	public void GIVEN_joueurInstanceGuerrier_WHEN_joueurChoixAttaque2_THEN_adversaireVieMoin40_AND_guerrierVieMoin10() {
		adversaire.setVie(100); 
		plateau.choixAttaque("Joueur 1", 2, guerrier, adversaire);
		assertEquals(60, adversaire.getVie());
		assertEquals(240, guerrier.getVie());
		//Test aussi l'affichage en console
	}
	 
	@Test
	public void GIVEN_joueurInstanceMage_WHEN_joueurChoixAttaque1_THEN_adversaireVieMoin10() {
		adversaire.setVie(100); 
		plateau.choixAttaque("Joueur 1", 1, mage, adversaire);
		assertEquals(90, adversaire.getVie());
		//Test aussi l'affichage en console
	}
}
