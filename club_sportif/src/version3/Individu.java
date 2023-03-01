package version3;

import java.util.Objects;
import java.util.TreeSet;

public class Individu {
	
	private String nom ;
	private String prenom ;
	private TreeSet<Integer> sportsPratiques ;
	
	public Individu(String nom, String prenom) {
		setNom(nom);
		setPrenom(prenom);
		this.sportsPratiques = new TreeSet<Integer>() ;
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
	public TreeSet<Integer> getSportsPratiques() {
		return sportsPratiques;
	}

	public TreeSet sportPratiques () {
		return getSportsPratiques();		
	}
	
	public String toString() {
		// ne chaîne avec le nom et le prénom
		String str = getNom() + " " + getPrenom() + "\n" ;
		str += "Liste des sports pratiqués :\n" ;
		if (this.getSportsPratiques().size() == 0) {
			str += "AUCUN\n" ;
		}
		else {
			str += strSportPratiques() + "\n";
		}
		return str ;
	}
	
	public boolean pratique(int sport) {
		return getSportsPratiques().contains(sport);
	}
	
	public void ajouterSport(int sport) {
		getSportsPratiques().add(sport) ;
	}
	
	public void enleverSport(int sport) {
		getSportsPratiques().remove(sport) ;
	}
	
	public boolean equals(Individu m) {
		if (this.getNom().equals(m.nom)  && this.getPrenom().equals(m.prenom)) {
			return true ;
		}
		return false ;
	}
	
	public String strSportPratiques () {
		String descriptionSp = "" ;
		for (int numSport : this.getSportsPratiques()) {
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
