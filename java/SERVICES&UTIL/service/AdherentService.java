package ma.estm.bibliotheque.service;

import ma.estm.bibliotheque.dao.AdherentDao;
import ma.estm.bibliotheque.dao.EmpruntDao;
import ma.estm.bibliotheque.model.Adherent;
import ma.estm.bibliotheque.util.ValidationUtil;
import ma.estm.bibliotheque.util.LogUtil;
import java.util.List;

public class AdherentService {
    private AdherentDao adherentDao;
    private EmpruntDao empruntDao;
    private LogUtil logUtil;
    
    public AdherentService() { }
    public AdherentService(AdherentDao adherentDao, EmpruntDao empruntDao) { }
    
    public void ajouterAdherent(Adherent adherent) throws Exception { }
    public void modifierAdherent(Adherent adherent) throws Exception { }
    public void supprimerAdherent(int id) throws Exception { }
    public Adherent getById(int id) throws Exception { return null; }
    public Adherent getByEmail(String email) { return null; }
    public Adherent getByNumero(String numero) { return null; }
    public List<Adherent> getAll() { return null; }
    public List<Adherent> rechercher(String motCle) { return null; }
    public boolean peutEmprunter(int id, int maxEmprunts) { return false; }
    public int getNombreEmpruntsActifs(int id) { return 0; }
    public void bloquerAdherent(int id, String motif) throws Exception { }
    public void debloquerAdherent(int id) throws Exception { }
    public List<Adherent> getAdherentsBloques() { return null; }
}