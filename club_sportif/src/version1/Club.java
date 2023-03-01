package version1;

public class Club {
	
	private String nom ;
	private Individu[] membres ;
	private int nombreMembres ;
	private int maxMembres ;
	
	public Club(String nom) {
		setNom(nom);
		this.maxMembres = 50 ;		
		this.membres  = new Individu [maxMembres] ;
		this.nombreMembres = 0 ;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Individu[] getMembres() {
		return membres;
	}

	public void setMembres(Individu[] membres) {
		this.membres = membres;
	}

	public int getNombreMembres() {
		return nombreMembres;
	}

	public void setNombreMembres(int nombreMembres) {
		this.nombreMembres = nombreMembres;
	}

	public int getMaxMembres() {
		return maxMembres;
	}

	public void setMaxMembres(int maxMembres) {
		this.maxMembres = maxMembres;
	}
	
	public String toString() {
		return getNom();
	}
	
	public Individu trouverMembre(String nom, String prenom) {
		Individu cible = new Individu(nom, prenom) ;
		for (int i = 0 ; i < nombreMembres ; i++) {
			if (membres[i].equals(cible)) {
				return cible ;
			}
		}
		return null ;
	}
	
	public Individu ajouterMembre(String nom, String prenom) {
		if (trouverMembre(nom, prenom) != null) {
			return null ;
		}
		if (isSizeMax()) {
			copie();
		}
		Individu nouveau = new Individu(nom, prenom) ;
		this.membres[nombreMembres] = nouveau ;
		this.nombreMembres += 1 ;
		return nouveau ;
	}
	
	public void lister() {
		System.out.println(this.getNom() + "\nListe des membres :\n");
		for (int i = 0 ; i < this.getNombreMembres() ; i++) {
			System.out.println(this.getMembres()[i]);
		}
	}
	
	public boolean isSizeMax() {
		if (this.getNombreMembres() == this.maxMembres) {
			return true ;
		}
		return false ;
	}
	
	public void copie() {
		this.maxMembres += 10 ;
		this.maxMembres += 10 ;
		Individu [] nouveauTableau = new Individu [maxMembres] ;
		for (int i = 0 ; i < this.membres.length ; i++) {
			nouveauTableau[i] = this.getMembres()[i] ;
		}
		this.membres = nouveauTableau ;
	}
	
	
	
}
