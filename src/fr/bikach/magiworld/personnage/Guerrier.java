package fr.bikach.magiworld.personnage;

public class Guerrier extends Personnage {

	/**
	 * Defaul Constructor
	 */
	public Guerrier() {
		super();
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param niveau
	 * @param vie
	 * @param force
	 * @param agilite
	 * @param inteligence
	 */
	public Guerrier(int niveau, int force, int agilite, int inteligence) {
		super(niveau, force, agilite, inteligence);
		super.nmAttaqueBasique = "Coup d'Épée";
		super.nmAttaqueSpeciale = "Coup de Rage";
	}

	/**
	 * Effectue des dommages égaux à la force du joueur sur l’adversaire.
	 * 
	 * @param perso : le Personnage sur lequelle l'action sera réalisé
	 */
	@Override
	public void attaqueBassique(Personnage perso) {
		int ptsVie = super.getForce();
		perso.setVie(perso.getVie() - ptsVie);
	}

	/**
	 * Effectue des dommages égaux à la force du guerrier fois deux sur l’adversaire.
	 * Le guerrier lançant l'attaque perd de la vitalité : la valeur de sa force
	 * divisée par 2.
	 * 
	 * @param perso : le Personnage sur lequelle l'action sera réalisé
	 */
	@Override
	public void attaqueSpeciale(Personnage perso) {
		int ptsVieAdversaire = super.getForce() * 2;
		perso.setVie(perso.getVie() - ptsVieAdversaire);
		int ptsVieGuerrier = super.getForce() / 2;
		super.setVie(super.getVie() - ptsVieGuerrier);
	}
	
}
