package fr.bikach.magiworld.deroulement;

import fr.bikach.magiworld.personnage.Personnage;

public interface IPlateau {

	public Personnage choixPersonnage(Personnage joueur, int choix, int niveau, int force, int agilite, int inteligence );
	public void choixAttaque(int choix, Personnage joueur,  Personnage adversaire);
	
	
}
