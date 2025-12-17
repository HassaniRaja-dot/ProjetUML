package dao;
import java.util.List;

import model.*;
public interface IUtilisateurDAO {
	void CreerCompte(Personne personne,String login,String passwordHache);
	Personne authentifier(String login, String password);
	List<Personne> trouverTous();
	List<Administrateur> TrouverAdmin();
	List<Adherent> TrouverAdherent();
	void activerCompte(String login);
	void desactiverCompte(String login);
	void supprimerCompte(String login);
}
