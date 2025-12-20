package ma.est.meknes.bibliotheque.service;

import ma.est.meknes.bibliotheque.model.Livre;
import ma.est.meknes.bibliotheque.model.Categorie;
import ma.est.meknes.bibliotheque.dao.LivreDAO;
import ma.est.meknes.bibliotheque.dao.EmpruntDAO;
import java.util.List;


public class LivreService {
    
    private LivreDAO livreDAO;
    private EmpruntDAO empruntDAO;
    private JournalService journalService;
    

    public LivreService() {
        this.livreDAO = new LivreDAO();
        this.empruntDAO = new EmpruntDAO();
        this.journalService = new JournalService();
    }

    public boolean ajouterLivre(Livre livre) {
        try {

            if (livreDAO.existeParISBN(livre.getIsbn())) {
                System.err.println("ISBN déjà enregistré");
                return false;
            }
            
            // Vérifier qu'une catégorie est assignée
            if (livre.getCategorie() == null) {
                System.err.println("Une catégorie doit être assignée");
                return false;
            }
            
            livreDAO.save(livre);
            journalService.log("AJOUT_LIVRE", 
                "Livre ajouté : " + livre.getTitre() + " (ISBN: " + livre.getIsbn() + ")");
            
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout : " + e.getMessage());
            return false;
        }
    }

    public Livre obtenirLivreParId(int id) {
        return livreDAO.findById(id);
    }

    public Livre obtenirLivreParISBN(String isbn) {
        return livreDAO.findByISBN(isbn);
    }
    

    public List<Livre> obtenirTousLesLivres() {
        return livreDAO.findAll();
    }
    

    public List<Livre> rechercherParTitre(String titre) {
        return livreDAO.findByTitre(titre);
    }
    
    public List<Livre> rechercherParAuteur(String auteur) {
        return livreDAO.findByAuteur(auteur);
    }
    

    public List<Livre> obtenirLivresParCategorie(int categorieId) {
        return livreDAO.findByCategorie(categorieId);
    }
    

    public boolean modifierLivre(Livre livre) {
        try {
            Livre livreExistant = livreDAO.findById(livre.getId());
            if (livreExistant == null) {
                System.err.println("Livre non trouvé");
                return false;
            }
            
            livreDAO.update(livre);
            journalService.log("MODIFICATION_LIVRE", 
                "Livre modifié : " + livre.getTitre());
            
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors de la modification : " + e.getMessage());
            return false;
        }
    }

    public boolean supprimerLivre(int id) {
        try {
            Livre livre = livreDAO.findById(id);
            if (livre == null) {
                System.err.println("Livre non trouvé");
                return false;
            }

            int nbExempairesEnPret = livre.getExempairesTotal() - livre.getExempairesDisponibles();
            if (nbExempairesEnPret > 0) {
                System.err.println("Impossible de supprimer : " + nbExempairesEnPret + 
                    " exemplaire(s) en prêt");
                return false;
            }
            
            livreDAO.delete(id);
            journalService.log("SUPPRESSION_LIVRE", 
                "Livre supprimé : " + livre.getTitre() + " (ISBN: " + livre.getIsbn() + ")");
            
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression : " + e.getMessage());
            return false;
        }
    }
    

    public boolean ajouterExemplaires(int livreId, int nombreExemplaires) {
        try {
            Livre livre = livreDAO.findById(livreId);
            if (livre == null) {
                System.err.println("Livre non trouvé");
                return false;
            }
            
            livre.setExempairesTotal(livre.getExempairesTotal() + nombreExemplaires);
            livre.setExempairesDisponibles(livre.getExempairesDisponibles() + nombreExemplaires);
            
            livreDAO.update(livre);
            journalService.log("AJOUT_EXEMPLAIRES", 
                nombreExemplaires + " exemplaire(s) ajouté(s) : " + livre.getTitre());
            
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout d'exemplaires : " + e.getMessage());
            return false;
        }
    }

    public List<Livre> obtenirLivresDisponibles() {
        return livreDAO.findLivresDisponibles();
    }

    public boolean estDisponible(int livreId) {
        Livre livre = livreDAO.findById(livreId);
        return livre != null && livre.getExempairesDisponibles() > 0;
    }
}
