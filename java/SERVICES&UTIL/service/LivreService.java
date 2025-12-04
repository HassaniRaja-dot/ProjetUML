package ma.estm.bibliotheque.service;

package ma.estm.bibliotheque.service;

import ma.estm.bibliotheque.dao.LivreDao;
import ma.estm.bibliotheque.model.Livre;
import ma.estm.bibliotheque.util.LogUtil;
import java.util.List;

public class LivreService {
    private LivreDao livreDao;
    private LogUtil logUtil;
    
    public LivreService() { }
    public LivreService(LivreDao livreDao) { }
    
    public void ajouterLivre(Livre livre) throws Exception { }
    public void modifierLivre(Livre livre) throws Exception { }
    public void supprimerLivre(String isbn) throws Exception { }
    public List<Livre> rechercher(String motCle) { return null; }
    public List<Livre> getAll() { return null; }
    public Livre getByISBN(String isbn) throws Exception { return null; }
    public List<Livre> getByCateg