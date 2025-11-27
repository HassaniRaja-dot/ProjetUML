package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprunte {
	
	private int idEmprunt;
	private LocalDate dateEmprunt;
	private LocalDate dateRetourPrevu;
	private LocalDate dateRetourReel;
	private Boolean enRetard;
	private List<Retard> retards; // la relation de composition entre la classe retard et emprunt
	private Exemplaire exemplaire;
	private Adherent adherent;
	
	Emprunte(){
		
	}
	Emprunte(int idEmprunt,Adherent adherent, Exemplaire exemplaire){
		this.idEmprunt = idEmprunt;
		this.dateEmprunt = LocalDate.now();
		this.dateRetourPrevu = this.dateEmprunt.plusDays(14);
		this.enRetard = false;
		this.retards = new ArrayList<>();
		this.retards.add(new Retard(1,4)); // creer nouvelle instance de retard
		this.exemplaire = exemplaire;
	}
	public int getIdEmprunt() {
		return idEmprunt;
	}
	public void setIdEmprunt(int idEmprunt) {
		this.idEmprunt = idEmprunt;
	}
	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public LocalDate getDateRetourPrevu() {
		return dateRetourPrevu;
	}
	public void setDateRetourPrevu(LocalDate dateRetourPrevu) {
		this.dateRetourPrevu = dateRetourPrevu;
	}
	public LocalDate getdateRetourReel() {
		return dateRetourReel;
	}
	public void setdateRetourReel(LocalDate dateRetourReel) {
		this.dateRetourReel = dateRetourReel;
	}
	public Boolean getEnretard() {
		return enRetard;
	}
	public void setEnretard(Boolean enRetard) {
		this.enRetard = enRetard;
	}
	public List<Retard> getRetard() {
		return retards;
	}
	public void setRetard(List<Retard> retards) {
		this.retards = retards;
	}
	public Exemplaire getExemplaire() {
		return exemplaire;
	}
	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}
	public Adherent getAdherent() {
		return adherent;
	}
	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	public void Creer() {
		
	}
	public void Retourner() {
		
	}
	public void CalculRetard() {
		
	}
	



}
