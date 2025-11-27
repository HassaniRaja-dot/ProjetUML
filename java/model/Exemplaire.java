package model;

public class Exemplaire {
	private int idExemplaire;
	private String etat;
	private Boolean disponible;
	
	public Exemplaire(){
		this.disponible = true;
		
	}
	public Exemplaire(int idExemplaire,String etat,Boolean disponible){
		this.idExemplaire = idExemplaire;
		this.etat = etat;
		this.disponible = disponible;
	}
	public int getIdExemplaire() {
        return idExemplaire;
    }
    
    public void setIdExemplaire(int idExemplaire) {
        this.idExemplaire = idExemplaire;
    }
    
    public String getEtat() {
        return etat;
    }
    
    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    public boolean Disponible() {
        return disponible;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
	public Boolean MarquerDisponibiliter() {
		return null;
	}

	

}
