package dao;

import model.Adherent;
import java.util.List;
public interface IAdherentDAO {
	void ajouter(Adherent adherent);
	List<Adherent> voirTous() ;
	Adherent chercherParId(int id);
	Adherent chercherParEmail(String email);
	void bloquer();

}
