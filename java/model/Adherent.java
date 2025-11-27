package model;

import java.util.ArrayList;
import java.util.List;

public class Adherent  extends Personne{
	private Boolean bloque;
	private List<Emprunte> emprunts;
	
	Adherent(){
		super();
		this.bloque = false;	
		this.emprunts = new ArrayList<>();
	}
	Adherent(int id,String nom,String email,Boolean bloque,String login,String passwordHache,Boolean actif){
		
		super(id, email, nom,login,passwordHache,actif);
		this.bloque = false;	
		this.emprunts = new ArrayList<>();
	}
	public Boolean isBloque() {
		return bloque;
	}
	public void setBloque(Boolean bloque) {
		this.bloque = bloque;
	}
	public List<Emprunte> getEmprunts(){
		return emprunts;
	}
	public void setEmprunts(List<Emprunte> emprunts) {
		this.emprunts = emprunts;
		
	}
	public void Emprunter(Emprunte emprunt) {
		
	}
	public void RetourneEmprunte(Emprunte emprunt) {
		
	}
	public void ConsulterEmprunte() {
		
	}
	@Override
	public Boolean Authentification() {
		return null;
	}
		// TODO Auto-generated method stub
		
	

	

}
