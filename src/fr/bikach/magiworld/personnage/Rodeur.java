package fr.bikach.magiworld.personnage;

public class Rodeur extends Personnage {

	private String strTirArc = "Tir à l'arc";
	private String strConcentration = "Concentration";

	/**
	 * Default constructor
	 */
	public Rodeur() {
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
	public Rodeur(int niveau, int force, int agilite, int inteligence) {
		super(niveau, force, agilite, inteligence);
	}

	/**
	 * Effectue des dommages égaux à l’agilité du joueur sur l’adversaire.
	 * 
	 * @param perso : le Personnage sur lequelle l'action sera réalisé
	 */
	@Override
	public void attaqueBassique(Personnage perso) {
		perso.setVie(perso.getVie() - super.getAgilite());
	}

	/**
	 * Le joueur gagne son niveau divisé par 2 en agilité.
	 * 
	 * @param perso : le Personnage sur lequelle l'action sera réalisé
	 */
	@Override
	public void attaqueSpeciale(Personnage perso) {
		int ptsAgilite = perso.getNiveau() / 2;
		perso.setAgilite(perso.getAgilite() + ptsAgilite);
	}

	// Getter/Setter

	public String getStrTirArc() {
		return strTirArc;
	}

	public String getStrConcentration() {
		return strConcentration;
	}
}
