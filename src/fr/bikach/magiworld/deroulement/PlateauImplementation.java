package fr.bikach.magiworld.deroulement;

import fr.bikach.magiworld.personnage.Guerrier;
import fr.bikach.magiworld.personnage.Mage;
import fr.bikach.magiworld.personnage.Personnage;
import fr.bikach.magiworld.personnage.Rodeur;

public class PlateauImplementation implements IPlateau {

	@Override
	public Personnage choixPersonnage(Personnage joueur, int choix, int niveau, int force, int agilite, int inteligence) {
		switch (choix) {
		case 1:
			joueur = new Guerrier(niveau, force, agilite, inteligence);
			break;
		case 2:
			joueur = new Rodeur(niveau, force, agilite, inteligence);
			break;
		case 3:
			joueur = new Mage(niveau, force, agilite, inteligence);
			break;
		}
		return joueur;
	}

	@Override
	public void choixAttaque(int choix, Personnage joueur, Personnage adversaire) {
		switch (choix) {
		case 1:
			joueur.attaqueBassique(adversaire);
			break;
		case 2:
			joueur.attaqueSpeciale(adversaire);
			break;
		}
	}

//	
//	public int controleSaisieEntier() {
//		Scanner lectureClavier = new Scanner(System.in);
//		int choix;
//		try {	
//			choix = lectureClavier.nextInt();
//			lectureClavier.close();
//			return choix;
//		}catch(Exception e) {
//			System.out.println("Veuilez saisir un entier");
//			choix = 0;
//			return choix;
//		}
//	}
	
}
