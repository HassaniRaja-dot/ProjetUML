package dao;
import java.util.List;

import model.Emprunte;
public interface IEmpruntDAO {
	void faire(Emprunte emprunt);
	List<Emprunte> chercherActif();
	List<Emprunte> chercherTous();
	List<Emprunte> chercherParAdherent(int id);
	List<Emprunte> trouverenRetard();
	List<Emprunte> ActifParAdherent(int id);

}
