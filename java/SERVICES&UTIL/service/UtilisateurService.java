package ma.estm.bibliotheque.service;

import ma.estm.bibliotheque.dao.UtilisateurDao;
import ma.estm.bibliotheque.model.Utilisateur;
import ma.estm.bibliotheque.util.PasswordUtil;
import ma.estm.bibliotheque.util.ValidationUtil;
import ma.estm.bibliotheque.util.LogUtil;
import java.util.List;

public class UtilisateurService {
    private UtilisateurDao utilisateurDao;
    private LogUtil logUtil;
    
    public UtilisateurService() { }
    public UtilisateurService(UtilisateurDao utilisateurDao) { }
    
    public void creerUtilisateur(Utilisateur utilisateur, String motDePasse) throws Exception { }
    public void modifierUtilisateur(Utilisateur utilisateur) throws Exception { }
    public void changerMotDePasse(int userId, String ancienPassword, String nouveauPassword) throws Exception { }
    public void reinitialiserMotDePasse(int userId, String nouveauPassword) throws Exception { }
    public void changerStatutCompte(int userId, boolean actif) throws Exception { }
    public void supprimerUtilisateur(int userId) throws Exception { }
    public List<Utilisateur> getAll() { return null; }
    public Utilisateur getById(int userId) throws Exception { return null; }
    public void debloquerUtilisateur(int userId) throws Exception { }
}