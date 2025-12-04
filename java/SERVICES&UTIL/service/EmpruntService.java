package ma.estm.bibliotheque.service;

import ma.estm.bibliotheque.dao.AdherentDao;
import ma.estm.bibliotheque.dao.EmpruntDao;
import ma.estm.bibliotheque.dao.LivreDao;
import ma.estm.bibliotheque.model.Emprunt;
import ma.estm.bibliotheque.util.LogUtil;
import java.util.List;

public class EmpruntService {
    private EmpruntDao empruntDao;
    private LivreDao livreDao;
    private AdherentDao adherentDao;
    private LogUtil logUtil;
    
    private static final int MAX_EMPRUNTS_SIMULTANES = 3;
    private static final int DUREE_EMPRUNT_JOURS = 14;
    private static final int SEUIL_BLOCAGE_JOURS = 10;
    
    public EmpruntService() { }
    public EmpruntService(EmpruntDao empruntDao, LivreDao livreDao, AdherentDao adherentDao) { }
    
    public void emprunter(int idAdherent, String isbn) throws Exception { }
    public void retourner(int idEmprunt) throws Exception { }
    public void prolonger(int idEmprunt, int joursSupplementaires) throws Exception { }
    public List<Emprunt> getEmpruntsActifs(int idAdherent) { return null; }
    public List<Emprunt> getEmpruntsEnRetard() { return null; }
    public List<Emprunt> getHistoriqueEmprunts(int idAdherent) { return null; }
    public List<Emprunt> getAll() { return null; }
    public Emprunt getById(int idEmprunt) throws Exception { return null; }
    public void verifierEtBloquerAdherentsEnRetard() { }
    public int getNombreTotalEmprunts() { return 0; }
    public int getNombreEmpruntsActifs() { return 0; }
    public int getNombreEmpruntsEnRetard() { return 0; }
}