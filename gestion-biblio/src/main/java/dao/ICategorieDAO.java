package dao;
import java.util.List;

import model.Categorie;
public interface ICategorieDAO {
	void ajouter(Categorie categorie);
	List<Categorie> AfficherTous();
	List<Categorie> chercherParNom(String nom);
	void modifier(Categorie categorie);
	void supprimer();
	int nbrLivre(int idCategorie);

}
