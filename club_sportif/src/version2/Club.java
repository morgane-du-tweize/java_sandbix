package version2;

import java.util.Vector;

public class Club {
	
	private String nom ;
	private Vector<Individu> membres ;
	
	public Club(String nom) {
		setNom(nom);
		this.membres = new Vector <Individu>() ;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Vector <Individu> getMembres() {
		return membres;
	}

	public void setMembres(Vector membres) {
		this.membres = membres;
	}
	
	public String toString() {
		return getNom();
	}
	
	public Individu trouverMembre(String nom, String prenom) {
		Individu cible = new Individu(nom, prenom) ;
		for (Individu membre : getMembres()) {
			if (membre.equals(cible)) {
				return membre ;
			}
		}
		return null ;
	}
	
	public Individu ajouterMembre(String nom, String prenom) {
		if (trouverMembre(nom, prenom) != null) {
			return null ;
		}
		Individu nouveau = new Individu(nom, prenom) ;
		this.membres.add(nouveau);
		return nouveau ;
	}
	
	public void lister() {
		System.out.println(this.getNom() + "\nListe des membres :\n");
		for (Individu membre : getMembres()) {
			System.out.println(membre);
		}
	}
	
}
