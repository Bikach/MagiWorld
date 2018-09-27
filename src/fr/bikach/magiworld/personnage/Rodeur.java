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
	public Rodeur(int niveau, int vie, int force, int agilite, int inteligence) {
		super(niveau, vie, force, agilite, inteligence);
	}

	
	@Override
	public void attaqueBassique(Personnage perso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attaqueSpeciale(Personnage perso) {
		// TODO Auto-generated method stub
		
	}

	
	// Getter/Setter
	
	public String getStrTirArc() {
		return strTirArc;
	}
	
	public String getStrConcentration() {
		return strConcentration;
	}
}
