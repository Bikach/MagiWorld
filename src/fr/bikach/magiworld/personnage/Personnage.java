package fr.bikach.magiworld.personnage;

public abstract class Personnage {

	private int niveau, vie, force, agilite, inteligence;

	/**
	 * Default constructor
	 */
	public Personnage() {
	}

	/**
	 * Constructp with parameters
	 * 
	 * @param niveau
	 * @param vie
	 * @param force
	 * @param agilite
	 * @param inteligence
	 */
	public Personnage(int niveau, int force, int agilite, int inteligence) {
		this.niveau = niveau;
		this.vie = niveau * 5;
		this.force = force;
		this.agilite = agilite;
		this.inteligence = inteligence;
	}

	// Méthodes abstraites
	
	public abstract void attaqueBassique(Personnage perso);

	public abstract void attaqueSpeciale(Personnage perso);

	
	// Getter/Setter 

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getAgilite() {
		return agilite;
	}

	public void setAgilite(int agilite) {
		this.agilite = agilite;
	}

	public int getInteligence() {
		return inteligence;
	}

	public void setInteligence(int inteligence) {
		this.inteligence = inteligence;
	}

}
