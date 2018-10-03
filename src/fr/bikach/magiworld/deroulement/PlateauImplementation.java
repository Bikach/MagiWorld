package fr.bikach.magiworld.deroulement;

import java.util.Scanner;

import fr.bikach.magiworld.personnage.Guerrier;
import fr.bikach.magiworld.personnage.Mage;
import fr.bikach.magiworld.personnage.Personnage;
import fr.bikach.magiworld.personnage.Rodeur;

public class PlateauImplementation implements IPlateau {
	Scanner lectureClavier = new Scanner(System.in);

	@Override
	public boolean choixMenu(int choix) {
		switch (choix) {
		case 1:
			// Commence la partie
			return true;
		case 2:
			this.relgleDuJeu();
			return false;
		case 3:
			this.infosJoueurs();
			return false;
		default:
			System.out.println("Veuillez saisir un nombre en 1, 2 ou 3 !");
			return false;
		}
	}

	@Override
	public int pointsCaracteristiques(String indication) {
		int indice1 = 0, indice2 = 0;
		switch (indication.charAt(0)) {
		case 'V':
			indice1 = 1;
			indice2 = 3;
			break;
		case 'N':
			indice1 = 1;
			indice2 = 100;
			break;
		default:
			indice1 = 0;
			indice2 = 100;
			break;
		}
		int nbPts = this.controleSaisie(indication, indice1, indice2);
		return nbPts;
	}

	@Override
	public Personnage choixPersonnage(String indicationJoueur, int classe, int niveau, int force, int agilite,
			int inteligence) {
		Personnage joueur;
		switch (classe) {
		case 1:
			System.out.println(
					"Haaaaaa je suis le Guerrier " + indicationJoueur + " je possède " + (niveau * 5) + " de vitalité, "
							+ force + " de force, " + agilite + " d'agilité et " + inteligence + " d'intéligence !");
			joueur = new Guerrier(niveau, force, agilite, inteligence);
			return joueur;
		case 2:
			System.out.println(
					"Héhé je suis le Rôdeur " + indicationJoueur + " je possède " + (niveau * 5) + " de vitalité, "
							+ force + " de force, " + agilite + " d'agilité et " + inteligence + " d'intéligence !");
			joueur = new Rodeur(niveau, force, agilite, inteligence);
			return joueur;
		case 3:
			System.out.println(
					"Abracadabra je suis le Mage " + indicationJoueur + " je possède " + (niveau * 5) + " de vitalité, "
							+ force + " de force, " + agilite + " d'agilité et " + inteligence + " d'intéligence !");
			joueur = new Mage(niveau, force, agilite, inteligence);
			return joueur;
		default:
			joueur = new Mage();
			return joueur;
		}
	}

	@Override
	public void choixAttaque(String indicationJoueur, int choix, Personnage joueur, Personnage adversaire) {

		switch (choix) {
		case 1:
			this.controleAttaqueBasique(joueur, adversaire, indicationJoueur);
			break;
		case 2:
			this.controleAttaqueSpeciale(joueur, adversaire, indicationJoueur);
			break;
		}
	}

	@Override
	public boolean controleCaracteristique(int niveau, int force, int agilite, int inteligence) {
		int sommeCaracteristique = force + agilite + inteligence;
		if (sommeCaracteristique > niveau) {
			System.out.println(
					"\nLa somme de force, agilite et inteligence ne doit pas être supérieur au niveau du joueur !\n");
			return false;
		} else {
			return true;
		}
	}

	private void relgleDuJeu() {
		System.out.println(
				"\n-----------------------------------------------------------------------------------------------------");
		System.out.println("Comment se déroule le jeu :"
				+ "\n1.Le jeu commence par proposer au joueur 1 de choisir entre Guerrier, Rôdeur ou Mage."
				+ "\n2.Il doit ensuite choisir le niveau, la force, l’agilité et enfin l’intelligence de son personnage."
				+ "\n3.C’est ensuite au tour du second joueur de choisir la classe et les caractéristiques de son personnage."
				+ "\n4.La partie démarre ensuite, le joueur 1 commence."
				+ "\n5.Chaque joueur joue tour à tour et choisit entre son Attaque Basique ou son Attaque spéciale."
				+ "\n6.Quand un joueur n’a plus de point de vie, la partie est terminée et l’autre joueur l’emporte.");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------");
		System.out.println("Les caractéristiques :" + "\nChaque personnage possède 5 caractéristiques :"
				+ "\n	- Niveau -> choisi par le joueur (min 1, max 100)"
				+ "\n	- Vie -> égale au niveau du joueur * 5"
				+ "\n	- Force -> choisie par le joueur (min 0, max 100)"
				+ "\n	- Agilité -> choisie par le joueur (min 0, max 100)"
				+ "\n	- Intelligence -> choisie par le joueur (min 0, max 100)"
				+ "\nAttention le total force + agilité + intelligence doit être égal au niveau du joueur.");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------");
	}

	private void infosJoueurs() {
		System.out.println(
				"\n-----------------------------------------------------------------------------------------------------");
		System.out.println("Guerrier : "
				+ "\n- Coup d'Epée -> Effectue des dommages égaux à la force du joueur sur l’adversaire."
				+ "\n- Coup de Rage ->  Effectue des dommages égaux à la force du joueur fois deux sur l’adversaire. "
				+ "\n  Le joueur lançant l'attaque perd de la vitalité : la valeur de sa force divisée par 2.");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------");
		System.out.println(
				"Rôdeur : " + "\n- Tir à l'Arc -> Effectue des dommages égaux à l’agilité du joueur sur l’adversaire."
						+ "\n- Concentration -> Le joueur gagne son niveau divisé par 2 en agilité.");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------");
		System.out.println("Mage : "
				+ "\n- Boule de Feu -> Effectue des dommages égaux à l’intelligence du joueur sur l’adversaire."
				+ "\n- Soin -> Le joueur soigne sa vie et regagne sa quantité d’intelligence fois 2 en points de vie.");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------\n");
	}

	private int controleSaisie(String indication, int indiceA, int indiceB) {
		int nbPts = 0;
		do {
			System.out.println(indication);
			nbPts = lectureClavier.nextInt();
		} while (nbPts < indiceA || nbPts > indiceB);
		return nbPts;
	}

	private void controleAttaqueBasique(Personnage joueur, Personnage adversaire, String indicationJoueur) {
		int ptsAttaque = 0;
		if (joueur instanceof Guerrier) {
			joueur.attaqueBassique(adversaire);
			ptsAttaque = joueur.getForce();
		} else if (joueur instanceof Mage) {
			joueur.attaqueBassique(adversaire);
			ptsAttaque = joueur.getInteligence();
		} else {
			joueur.attaqueBassique(adversaire);
			ptsAttaque = joueur.getAgilite();
		}
		System.out.println(indicationJoueur + " utilise " + joueur.getNmAttaqueBasique() + " et inflige " + ptsAttaque
				+ " dommages.\n" + (indicationJoueur.equals("Joueur 1") ? "Joueur 2 perd " : "Joueur 1 perd ")
				+ ptsAttaque + " points de vie\n");

	}

	private void controleAttaqueSpeciale(Personnage joueur, Personnage adversaire, String indicationJoueur) {
		int ptsAttaque = 0;
		if (joueur instanceof Guerrier) {
			joueur.attaqueSpeciale(adversaire);
			ptsAttaque = joueur.getForce();
			System.out.println(indicationJoueur + " utilise " + joueur.getNmAttaqueSpeciale() + " et inflige "
					+ ptsAttaque * 2 + " dommages.");
			System.out.println((indicationJoueur.equals("Joueur 1") ? "Joueur 2 perd " : "Joueur 1 perd ")
					+ ptsAttaque * 2 + " points de vie");
			System.out.println(indicationJoueur + " " + ptsAttaque / 2 + " points de vie\n");
		} else if (joueur instanceof Mage) {
			joueur.attaqueSpeciale(joueur);
			ptsAttaque = joueur.getInteligence();
			System.out.println(indicationJoueur + " utilise " + joueur.getNmAttaqueSpeciale() + " et gagne "
					+ ptsAttaque * 2 + " en vitalité.");
			System.out.println(indicationJoueur + " (" + joueur.getVie() + " Vitalité) \n");
		} else {
			joueur.attaqueSpeciale(joueur);
			ptsAttaque = joueur.getNiveau();
			System.out.println(indicationJoueur + " utilise " + joueur.getNmAttaqueSpeciale() + " et gagne "
					+ ptsAttaque / 2 + " en agilité.");
			System.out.println(indicationJoueur + " (" + joueur.getAgilite() + " Agilité) \n");
		}
	}

}
