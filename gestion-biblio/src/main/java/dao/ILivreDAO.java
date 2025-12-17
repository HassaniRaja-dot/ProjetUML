package dao;
import java.util.List;
import model.Livre;
public interface ILivreDAO {
	    void ajouter(Livre livre);
	    Livre trouverParISBN(String isbn);
	    List<Livre> trouverTous();
	    void modifier(Livre livre);
	    boolean supprimer(String isbn);
}
