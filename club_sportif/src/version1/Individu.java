package version1;

import java.util.Objects;

public class Individu {
	
	private String nom ;
	private String prenom ;
	private boolean[] sportsPratiques ;
	
	public Individu(String nom, String prenom) {
		setNom(nom);
		setPrenom(prenom);
		this.sportsPratiques = new boolean [8] ;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public boolean[] getSportsPratiques() {
		return sportsPratiques;
	}
	public void setSportsPratiques(boolean[] sportsPratiques) {
		this.sportsPratiques = sportsPratiques;
	}
	
	public String toString() {
		// ne chaîne avec le nom et le prénom
		String str = getNom() + " " + getPrenom() + "\n" ;
		str += "Liste des sports pratiqués :\n" ;
		if (sportsPratiques().length == 0) {
			str += "AUCUN\n" ;
		}
		else {
			str += strSportPratiques() + "\n";
		}

		return str ;
	}
	
	public boolean pratique(int sport) {
		return getSportsPratiques()[sport];
	}
	
	public void ajouterSport(int sport) {
		getSportsPratiques()[sport] = true ;
	}
	
	public void enleverSport(int sport) {
		getSportsPratiques()[sport] = false ;
	}
	
	public int[] sportsPratiques() {

		int compteur = 0 ;
		boolean [] pratiques = this.getSportsPratiques();
		for (boolean p : pratiques) {
			if (p) {
				compteur ++ ;
			}
		}
		int j = 0 ;
		int [] sportsPratiques = new int [compteur];
		for (int i = 0 ; i < this.getSportsPratiques().length ; i++) {
			if (getSportsPratiques()[i]) {
				sportsPratiques[j] = i ;
				j ++ ;
			}
		}
		return sportsPratiques ;
	}
	
	public boolean equals(Individu m) {
		if (this.getNom().equals(m.nom)  && this.getPrenom().equals(m.prenom)) {
			return true ;
		}
		return false ;
	}
	
	public String strSportPratiques () {
		int[] sports = sportsPratiques() ;
		String descriptionSp = "" ;
		for (int numSport : sports) {
			descriptionSp += Sports.nom(numSport) + "\n";
		}
		return descriptionSp ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Individu other = (Individu) obj;
		return Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}
	
	
	
}
