package model;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	private int idCategorie;
	private String nom;
	private List<Livre> livres; // relation d'agrégation entre categorie et livre
	
	Categorie(){
		
	}
	Categorie(int idCategorie,String nom){
		this.idCategorie = idCategorie;
		this.nom = nom;
		this.livres = new ArrayList<>(); // on creer une liste de livre 
	}
	
	public int getIdCategorie() {
        return idCategorie;
    }
    
    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<Livre> getLivre(){
    	return livres;
    }
    public void setLivre(List<Livre> livres) {
    	this.livres = livres;
    }
	public void AjouterLivre(Livre livre) {
		livres.add(livre);
		
	}
	public void Modifier() {
		
	}


}
