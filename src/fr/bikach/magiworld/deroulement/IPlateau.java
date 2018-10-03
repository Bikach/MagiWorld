package fr.bikach.magiworld.deroulement;

import fr.bikach.magiworld.personnage.Personnage;

public interface IPlateau {

	/**
	 * Affiche à l'écran le contenu du menu ou démarre la partie
	 * 
	 * @param choix du menu
	 * @return true si le joueur veut démarer la partie
	 */
	public boolean choixMenu(int choix);
	
	/**
	 * Controle la saisie du joueur et enregistre le nombr de points saisie
	 * 
	 * @param indication de la caractéristique
	 * @return nombres de points saisie  après controle
	 */
	public int pointsCaracteristiques(String indication);
	
	/**
	 * Crée l'instance d'un Personnage etr affiche à lécran les infos le concernant
	 * 
	 * @param indicationJoueur joueur 1 ou 2
	 * @param classe Guerrier, Rôdeu ou Mage
	 * @param niveau saisie par le joueur
	 * @param force saisie par le joueur
	 * @param agilite saisie par le joueur
	 * @return l'instance de Personnage cré
	 */
	public Personnage choixPersonnage(String indicationJoueur, int classe, int niveau, int force, int agilite, int inteligence);
	
	/**
	 * Choisie l'attaque suivant l'instance du joueur
	 * 
	 * @param indicationJoueur joueur 1 ou 2
	 * @param choix de l'attaque
	 * @param joueur instance du joueur
	 * @param adversaire instance du joueur adverse
	 */
	public void choixAttaque(String indicationJoueur, int choix, Personnage joueur,  Personnage adversaire);
	

	/**
	 * Controle la somme des differents caractèristiques saisie par le joueur
	 * 
	 * @param niveau saisie par le joueur
	 * @param force saisie par le joueur
	 * @param agilité saisie par le joueur
	 * @param intéligence saisie par le joueur
	 * @return true si la somme de force, agilité et intelignece ne dépasse pas le niveau du joueur
	 */
	public boolean controleCaracteristique(int niveau, int force, int agilite, int inteligence);
	
	
}
