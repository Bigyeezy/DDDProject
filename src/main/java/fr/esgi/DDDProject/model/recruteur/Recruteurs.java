package fr.esgi.DDDProject.model.recruteur;

import java.util.List;

import fr.esgi.DDDProject.infrastructure.candidat.InvalideNomreAnneeExperienceException;
import fr.esgi.DDDProject.infrastructure.recruteur.RecretueurExisteDejaException;
import fr.esgi.DDDProject.infrastructure.recruteur.RecruteurNExistePas;

/**
 * The Interface Recruteurs.
 */
public interface Recruteurs {
    
    /**
     * Gets the all.
     *
     * @return the all
     * @throws InvalideNomreAnneeExperienceException the invalide nomre annee experience exception
     */
    List<Recruteur> getAll() throws  InvalideNomreAnneeExperienceException;
    
    /**
     * Gets the by id.
     *
     * @param id the id
     * @return the by id
     */
    Recruteur getById(RecruteurId id);
    
    /**
     * Save.
     *
     * @param recruteur the recruteur
     * @return the recruteur
     * @throws RecretueurExisteDejaException the recretueur existe deja exception
     */
    Recruteur save(Recruteur recruteur) throws RecretueurExisteDejaException;
    
    /**
     * Update.
     *
     * @param recruteur the recruteur
     * @return the recruteur
     * @throws RecruteurNExistePas the recruteur N existe pas
     */
    Recruteur update(Recruteur recruteur) throws RecruteurNExistePas;
}
