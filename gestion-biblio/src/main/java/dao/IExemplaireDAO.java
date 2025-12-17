package dao;
import model.Exemplaire;
import java.util.List;
public interface IExemplaireDAO {
	void ajouter(Exemplaire exemplaire, String isbnLivre);
    Exemplaire trouverParId(int id);
    List<Exemplaire> trouverTous();
    List<Exemplaire> trouverParLivre(String ISBN);
    List<Exemplaire> trouverDisponiblesParLivre(String ISBN);
    void modifier(Exemplaire exemplaire);
    int NbrExemplaireDispo(String ISBN);

}
