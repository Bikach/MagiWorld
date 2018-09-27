package fr.bikach.magiworld.personnage;

public class Mage extends Personnage {

	private String strBouleDeFeu = "Boule de feu";
	private String strSoin = "soin";

	private final int PTS_VIE_DEPART = super.getVie();

	/**
	 * Default constructor
	 */
	public Mage() {
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
	public Mage(int niveau, int vie, int force, int agilite, int inteligence) {
		super(niveau, vie, force, agilite, inteligence);
	}

	/**
	 * Effectue des dommages égaux à l’intelligence du Mage sur l’adversaire.
	 * 
	 * @param perso : le Personnage sur lequelle l'action sera réalisé
	 */
	@Override
	public void attaqueBassique(Personnage perso) {
		perso.setVie(perso.getVie() - super.getInteligence());
	}

	/**
	 * Regagne sa quantité d’intelligence fois 2 en points de vie 
	 * 
	 * @param perso : le Personnage sur lequelle l'action sera réalisé
	 */
	@Override
	public void attaqueSpeciale(Personnage perso) {
		int nbrPtsVie = super.getVie() + controleAugmenteVie(super.getInteligence());
		perso.setVie(nbrPtsVie);
	}

	/**
	 * Méthode pour contrôler le nbr de point de vie augmenté
	 * 
	 * @param ptsVie : points de vie à ajouter
	 */
	private int controleAugmenteVie(int ptsInteligence) {
		int ptsVieAugmentePossible = ptsInteligence * 2;
		int ptsVieTotal = super.getVie() + ptsVieAugmentePossible;

		if (ptsVieTotal >= PTS_VIE_DEPART) {
			int differencePts = ptsVieTotal - PTS_VIE_DEPART;
			ptsVieAugmentePossible -= differencePts;
		}

		return ptsVieAugmentePossible;
	}

	// Getter/Setter

	public String getStrBouleDeFeu() {
		return strBouleDeFeu;
	}

	public String getStrSoin() {
		return strSoin;
	}

	public int getPTS_VIE_DEPART() {
		return PTS_VIE_DEPART;
	}

}
