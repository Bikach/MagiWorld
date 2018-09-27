package fr.bikach.magiworld.personnage;

public class Guerrier extends Personnage {

	private String strCoupEpee = "Coup d'épée";
	private String strCoupRage = "Coup de Rage";

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
	public Guerrier(int niveau, int vie, int force, int agilite, int inteligence) {
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
	
	public String getStrCoupEpee() {
		return strCoupEpee;
	}
	
	public String getStrCoupRage() {
		return strCoupRage;
	}
	
}
