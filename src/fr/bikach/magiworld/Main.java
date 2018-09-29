package fr.bikach.magiworld;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.bikach.magiworld.deroulement.IPlateau;
import fr.bikach.magiworld.deroulement.PlateauImplementation;
import fr.bikach.magiworld.personnage.Personnage;

public class Main {

	public static void main(String[] args) {	
		
		Scanner lectureClavier = new Scanner(System.in);
		IPlateau plateau = new PlateauImplementation();
		
		// Menu
		System.out.println("\n---------------------------------------------------------------------------------------"
										+ "\n---------------------------------MAGI WORLD ---------------------------------"
										+ "\n---------------------------------------------------------------------------------------");
		boolean start = false;
		do {
			System.out.println("\n		MENU");
			System.out.println("\n1 : Commencer la partie"
					+ "\n2 : Règle du jeu"
					+ "\n3 : Infos personnages");
			System.out.print("Faite votre choix : ");
			int choix = lectureClavier.nextInt();
			start = plateau.choixMenu(choix);
		}while(!start);
		
		// Choix Classe et caractéristiques joueur 1
		System.out.println("\n--------------------------------- Joueur 1 ---------------------------------\n");
		int classe = plateau.pointsCaracteristiques("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
		int niveau = plateau.pointsCaracteristiques("Niveau du personnage ?");
		int force = plateau.pointsCaracteristiques("Force du personnage ?");
		int agilite = plateau.pointsCaracteristiques("Agilité du personnage ?");
		int inteligence = plateau.pointsCaracteristiques("Intéligence du personnage ?");
		Personnage joueur1 = plateau.choixPersonnage("Joueur 1", classe, niveau, force, agilite, inteligence);

		// Choix Classe et caractéristiques joueur 2
		System.out.println("\n--------------------------------- Joueur 2 ---------------------------------\n");
		classe = plateau.pointsCaracteristiques("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
		niveau = plateau.pointsCaracteristiques("Niveau du personnage ?");
		force = plateau.pointsCaracteristiques("Force du personnage ?");
		agilite = plateau.pointsCaracteristiques("Agilité du personnage ?");
		inteligence = plateau.pointsCaracteristiques("Intéligence du personnage ?");
		Personnage joueur2 = plateau.choixPersonnage("Joueur 2", classe, niveau, force, agilite, inteligence);

		// Début du combat
		System.out.println("\n---------------------------------------------------------------------------------------"
										+ "\n-------------------------------------- FIGHT --------------------------------------"
										+ "\n---------------------------------------------------------------------------------------");

		do {
			
			
			
			
			
		} while (joueur1.getVie() <= 0 || joueur2.getVie() <= 0);
		
		if (joueur1.getVie() > joueur2.getVie()) 
			System.out.println("Victoire du joueur 1");
		else 
			System.out.println("Victoire du joueur 2");
		

	}

}
