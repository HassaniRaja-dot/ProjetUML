package dao;
import java.util.List;

import model.Logs;
public interface IlogDAO {
	void enregistrer(String description,String action,int idUtilisateur);
	List<Logs> trouverTous();
	List<Logs> trouverParUtilisateur(int idUtilisateur);
	List<Logs> trouverParAction(String action);
	List<Logs> trouverAujourdhui();
}
