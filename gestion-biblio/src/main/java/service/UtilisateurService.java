package ma.est.meknes.bibliotheque.service;

import ma.est.meknes.bibliotheque.model.Utilisateur;
import ma.est.meknes.bibliotheque.dao.UtilisateurDAO;
import at.favre.lib.crypto.bcrypt.BCrypt;
import java.util.List;

public class UtilisateurService {
    
    private UtilisateurDAO utilisateurDAO;
    private JournalService journalService;

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    public UtilisateurService() {
        this.utilisateurDAO = new UtilisateurDAO();
        this.journalService = new JournalService();
    }
    

    public Utilisateur authentifier(String login, String motDePasse) {
        try {
            Utilisateur utilisateur = utilisateurDAO.findByLogin(login);
            
            if (utilisateur == null) {
                System.out.println("Utilisateur non trouvé : " + login);
                journalService.log("AUTHENTIFICATION_ECHEC", 
                    "Tentative d'authentification échouée pour : " + login);
                return null;
            }
            
            // Vérifier si l'utilisateur est actif
            if (!utilisateur.isActif()) {
                System.out.println("Compte désactivé");
                journalService.log("AUTHENTIFICATION_ECHEC", 
                    "Tentative d'authentification avec compte désactivé : " + login);
                return null;
            }
            
            // Vérifier le mot de passe avec BCrypt
            if (BCrypt.verifyer().verify(
                motDePasse.toCharArray(), 
                utilisateur.getMotDePasse().toCharArray()).verified) {
                
                journalService.log("AUTHENTIFICATION_SUCCES", 
                    "Utilisateur authentifié : " + login + " (" + utilisateur.getRole() + ")");
                return utilisateur;
            } else {
                System.out.println("Mot de passe incorrect");
                journalService.log("AUTHENTIFICATION_ECHEC", 
                    "Mot de passe incorrect pour : " + login);
                return null;
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'authentification : " + e.getMessage());
            return null;
        }
    }
    

    public boolean creerUtilisateur(Utilisateur utilisateur, String motDePasseEnClair) {
        try {
            
            if (utilisateurDAO.existeParLogin(utilisateur.getLogin())) {
                System.err.println("Login déjà utilisé");
                return false;
            }

            if (!ROLE_ADMIN.equals(utilisateur.getRole()) && 
                !ROLE_USER.equals(utilisateur.getRole())) {
                System.err.println("Rôle invalide");
                return false;
            }
            

            String motDePasseHash = BCrypt.withDefaults()
                .hashToString(12, motDePasseEnClair.toCharArray());
            utilisateur.setMotDePasse(motDePasseHash);
            utilisateur.setActif(true);
            
            utilisateurDAO.save(utilisateur);
            journalService.log("CREATION_UTILISATEUR", 
                "Utilisateur créé : " + utilisateur.getLogin() + " (" + utilisateur.getRole() + ")");
            
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors de la création : " + e.getMessage());
            return false;
        }
    }
    

    public Utilisateur obtenirUtilisateurParId(int id) {
        return utilisateurDAO.findById(id);
    }
    
  
    public Utilisateur obtenirUtilisateurParLogin(String login) {
        return utilisateurDAO.findByLogin(login);
    }

    public List<Utilisateur> obtenirTousLesUtilisateurs() {
        return utilisateurDAO.findAll();
    }
    

    public boolean modifierUtilisateur(Utilisateur utilisateur) {
        try {
            Utilisateur existant = utilisateurDAO.findById(utilisateur.getId());
            if (existant == null) {
                System.err.println("Utilisateur non trouvé");
                return false;
            }
            
            utilisateurDAO.update(utilisateur);
            journalService.log("MODIFICATION_UTILISATEUR", 
                "Utilisateur modifié : " + utilisateur.getLogin());
            
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors de la modification : " + e.getMessage());
            return false;
        }
    }
    

    public boolean changerMotDePasse(int userId, String ancienMotDePasse, String nouveauMotDePasse) {
        try {
            Utilisateur utilisateur = utilisateurDAO.findById(userId);
            if (utilisateur == null) {
                System.err.println("Utilisateur non trouvé");
                return false;
            }

            if (!BCrypt.verifyer().verify(
                ancienMotDePasse.toCharArray(), 
                utilisateur.getMotDePasse().toCharArray()).verified) {
                System.err.println("Ancien mot de passe incorrect");
                return false;
            }

            String motDePasseHash = BCrypt.withDefaults()
                .hashToString(12, nouveauMotDePasse.toCharArray());
            utilisateur.setMotDePasse(motDePasseHash);
            
            utilisateurDAO.update(utilisateur);
            journalService.log("CHANGEMENT_PASSWORD", 
                "Mot de passe changé pour : " + utilisateur.getLogin());
            
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors du changement de mot de passe : " + e.getMessage());
            return false;
        }
    }
    

    public boolean desactiverUtilisateur(int id) {
        try {
            Utilisateur utilisateur = utilisateurDAO.findById(id);
            if (utilisateur == null) {
                System.err.println("Utilisateur non trouvé");
                return false;
            }
            
            utilisateur.setActif(false);
            utilisateurDAO.update(utilisateur);
            journalService.log("DESACTIVATION_UTILISATEUR", 
                "Utilisateur désactivé : " + utilisateur.getLogin());
            
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors de la désactivation : " + e.getMessage());
            return false;
        }
    }
    
 
    public boolean activerUtilisateur(int id) {
        try {
            Utilisateur utilisateur = utilisateurDAO.findById(id);
            if (utilisateur == null) {
                System.err.println("Utilisateur non trouvé");
                return false;
            }
            
            utilisateur.setActif(true);
            utilisateurDAO.update(utilisateur);
            journalService.log("ACTIVATION_UTILISATEUR", 
                "Utilisateur activé : " + utilisateur.getLogin());
            
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors de l'activation : " + e.getMessage());
            return false;
        }
    }
    
    public boolean estAdmin(Utilisateur utilisateur) {
        return utilisateur != null && ROLE_ADMIN.equals(utilisateur.getRole());
    }
}
