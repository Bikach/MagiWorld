package fr.bikach.magiworld.deroulement;

import fr.bikach.magiworld.personnage.Personnage;

public interface IPlateau {

	public boolean choixMenu(int choix);
	public int pointsCaracteristiques(String indication);
	public Personnage choixPersonnage(String indicationJoueur, int classe, int niveau, int force, int agilite, int inteligence);
	public void choixAttaque(String indicationJoueur, int choix, Personnage joueur,  Personnage adversaire);
	
	
}
