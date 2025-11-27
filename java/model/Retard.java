package model;

public class Retard {
	
	private int idRetard;
	private int jours;
	
	Retard(){
		
	}
	Retard(int idRetard,int jours){
		this.idRetard = idRetard;
		this.jours = jours;
	}
	
	public int getIdretard() {
		return idRetard;
	}
	public void setIdretard(int idRetard) {
		this.idRetard = idRetard;
		
	}
	public int getJours() {
		return jours;
	}
	public void setJours(int jours) {
		this.jours = jours;
	}
	

}
