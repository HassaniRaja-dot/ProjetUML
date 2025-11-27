package model;

public abstract class Personne {
	
	protected int id;
	protected String nom;
	protected String email;
	protected String login;
	protected String passwordHache;
	protected Boolean actif;
	
	public Personne(){
		
	}
	
	public Personne(int id, String nom,String email,String login,String passwordHache,Boolean actif){
		this.nom = nom;
		this.id = id;
		this.email = email;
		this.login = login;
		this.passwordHache = passwordHache;
		this.actif = true;
	}
	public int getId() {
		return id;
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public String gtNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswordHache() {
		return passwordHache;
	}
	public void setPasswordHache(String passwordHache) {
		this.passwordHache = passwordHache;
	}
	public Boolean getActif() {
		return actif;
	}
	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	public abstract Boolean Authentification();
	

	

}
