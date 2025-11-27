package model;

public class Administrateur extends Personne{
	
	private String role;
	
	Administrateur(){
		super();
		this.role = "ADMIN";
	}
	Administrateur(int id,String nom,String email,String role,String login,String passwordHache,Boolean actif){
		super(id,nom,email,login,passwordHache,actif);
		this.role = "ADMIN";
		
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void AjouterLivre(Livre livre) {
		
	}
	public void ModifierLivre(Livre livre) {
		
	}
	public void SupprimerLivre(Livre livre) {
		
	}
	public void CreerUtilisateur(Personne personne) {
		
	}
	public void DesactiverUtilisateur(Personne personne) {
		
	}
	public void GererMembre(Adherent adherent) {
		
	}
	@Override
	public Boolean Authentification() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
