package fr.bikach.magiworld;

import java.util.Scanner;

import fr.bikach.magiworld.deroulement.IPlateau;
import fr.bikach.magiworld.deroulement.PlateauImplementation;
import fr.bikach.magiworld.personnage.Personnage;

public class Main {

	public static void main(String[] args) {	
		
		Scanner lectureClavier = new Scanner(System.in);
		IPlateau plateau = new PlateauImplementation();
		
		int choixMenu = 0,  choixJoueur = 0, classe = 0, niveau = 0, force =0, agilite =0, inteligence = 0;
		boolean isPtsCaracteristique = true;
		
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
			choixMenu = lectureClavier.nextInt();
			start = plateau.choixMenu(choixMenu);
		}while(!start);
		
		// Choix Classe et caractéristiques joueur 1
		System.out.println("\n--------------------------------- Joueur 1 ---------------------------------\n");
		 classe = plateau.pointsCaracteristiques("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
		 niveau = plateau.pointsCaracteristiques("Niveau du personnage ?");
		do {
			 force = plateau.pointsCaracteristiques("Force du personnage ?");
			 agilite = plateau.pointsCaracteristiques("Agilité du personnage ?");
			 inteligence = plateau.pointsCaracteristiques("Intéligence du personnage ?");		
			 isPtsCaracteristique = plateau.controleCaracteristique(niveau, force, agilite, inteligence);
		}while(!isPtsCaracteristique);
		Personnage joueur1 = plateau.choixPersonnage("Joueur 1", classe, niveau, force, agilite, inteligence);

		// Choix Classe et caractéristiques joueur 2
		System.out.println("\n--------------------------------- Joueur 2 ---------------------------------\n");
		classe = plateau.pointsCaracteristiques("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
		niveau = plateau.pointsCaracteristiques("Niveau du personnage ?");
		do {
			force = plateau.pointsCaracteristiques("Force du personnage ?");
			agilite = plateau.pointsCaracteristiques("Agilité du personnage ?");
			inteligence = plateau.pointsCaracteristiques("Intéligence du personnage ?");	
			 isPtsCaracteristique = plateau.controleCaracteristique(niveau, force, agilite, inteligence);
		}while(!isPtsCaracteristique);
		Personnage joueur2 = plateau.choixPersonnage("Joueur 2", classe, niveau, force, agilite, inteligence);

		// Début du combat
		System.out.println("\n---------------------------------------------------------------------------------------"
										+ "\n-------------------------------------- FIGHT --------------------------------------"
										+ "\n---------------------------------------------------------------------------------------");

		do {
			
			do {
				System.out.println("\nJoueur 1 (" +joueur1.getVie()+ " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
				choixJoueur = lectureClavier.nextInt();
				plateau.choixAttaque("Joueur 1", choixJoueur, joueur1, joueur2);
			}while(choixJoueur <1 || choixJoueur > 2);
			
			if(joueur2.getVie() > 0) {
				do {
					System.out.println("\nJoueur 2 (" +joueur2.getVie()+ " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
					choixJoueur = lectureClavier.nextInt();
					plateau.choixAttaque("Joueur 2", choixJoueur, joueur2, joueur1);
				}while(choixJoueur <1 || choixJoueur > 2);				
			}
			
		} while (joueur1.getVie() > 0 && joueur2.getVie() > 0);
		
		if (joueur1.getVie() > joueur2.getVie()) 
			System.out.println("Victoire du joueur 1");
		else 
			System.out.println("Victoire du joueur 2");
		
		lectureClavier.close();

	}

}
