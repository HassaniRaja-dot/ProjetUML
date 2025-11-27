package model;

import java.util.ArrayList;
import java.util.List;

public class Livre {
	private String ISBN;
	private String titre;
	private String auteur;
	private int annee;
	private int nbrExemplaireDispo;
	private List<Exemplaire> exemplaires;  // montre la relation de composition entre Livre et exemplaire
	
	Livre(){
		this.exemplaires = new ArrayList<>();
	}
	Livre(String ISBN,String titre,String auteur,int annee,int nbrExemplaireDispo){
		this.ISBN = ISBN;
		this.titre = titre;
		this.auteur = auteur;
		this.annee = annee;
		this.nbrExemplaireDispo = 3;
		this.exemplaires = new ArrayList<>();
		// créer les exemplaire a l'interrieure de la classe Livre
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getAnnee() {
        return annee;
    }
    
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    
    public int getNbRxmlaireDispo() {
        return nbrExemplaireDispo;
    }
    
    public void setNbRxmlaireDispo(int nbrExemplaireDispo) {
        this.nbrExemplaireDispo = nbrExemplaireDispo;
    }
    public List<Exemplaire> getExemplaires() {
        return exemplaires;
    }
    
    public void setExemplaires(List<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }
	public void Ajouter() {
		
	}
	public void Modifier() {
		
	}
	public void Supprimer() {
		
	}
	public Boolean EstSupprimable() {
		return null;
		
	}
	
}
