package fr.bikach.magiworld.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import fr.bikach.magiworld.deroulement.IPlateau;
import fr.bikach.magiworld.deroulement.PlateauImplementation;
import fr.bikach.magiworld.personnage.Guerrier;
import fr.bikach.magiworld.personnage.Mage;
import fr.bikach.magiworld.personnage.Personnage;
import fr.bikach.magiworld.personnage.Rodeur;

class PlateauImpTest {
	
	IPlateau plateau = new PlateauImplementation();
	Personnage adversaire = new Mage();	
	Personnage guerrier = new Guerrier(50, 20, 20, 10);
	Personnage mage = new Mage(50, 20, 20, 10);
	Personnage rodeur = new Rodeur(50, 20, 20, 10);

	@Test
	public void GIVEN_joueurInstanceGuerrier_WHEN_joueurChoixAttaque1_THEN_adversaireVieMoin20() {
		adversaire.setVie(100);
		plateau.choixAttaque("Joueur 1", 1, guerrier, adversaire);
		assertEquals(80, adversaire.getVie());
	}
	
//
	@Test
	public void GIVEN_joueurInstanceGuerrier_WHEN_joueurChoixAttaque2_THEN_adversaireVieMoin40_AND_guerrierVieMoin10() {
		adversaire.setVie(100); 
		plateau.choixAttaque("Joueur 1", 2, guerrier, adversaire);
		assertEquals(60, adversaire.getVie());
		assertEquals(240, guerrier.getVie());
	}
	 
	@Test
	public void GIVEN_joueurInstanceMage_WHEN_joueurChoixAttaque1_THEN_adversaireVieMoin10() {
		adversaire.setVie(100); 
		plateau.choixAttaque("Joueur 1", 1, mage, adversaire);
		assertEquals(90, adversaire.getVie());
		//Test aussi l'affichage en console
	}

	@Test
	public void GIVEN_joueurInstanceMage_WHEN_joueurChoixAttaque2_THEN_mageViePlus10() {
		mage.setVie(100);
		plateau.choixAttaque("Joueur 1", 2, mage, adversaire);
		assertEquals(120, mage.getVie());
		//Test aussi l'affichage en console
	}
	
	@Test
	public void GIVEN_joueurInstanceRodeur_WHEN_joueurChoixAttaque1_THEN_adversaireVieMoin20() {
		adversaire.setVie(100); 
		plateau.choixAttaque("Joueur 1", 1, rodeur, adversaire);
		assertEquals(80, adversaire.getVie());
		//Test aussi l'affichage en console
	}
	
	@Test
	public void GIVEN_joueurInstanceRodeur_WHEN_joueurChoixAttaque2_THEN_rodeurAgilitePlus10() {
		rodeur.setAgilite(10);
		plateau.choixAttaque("Joueur 1", 2, rodeur, adversaire);
		assertEquals(35, rodeur.getAgilite());
		//Test aussi l'affichage en console
	}
}
