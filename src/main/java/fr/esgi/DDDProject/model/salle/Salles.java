package fr.esgi.DDDProject.model.salle;

import java.util.List;

import fr.esgi.DDDProject.infrastructure.salle.EtageNegatifException;
import fr.esgi.DDDProject.infrastructure.salle.SalleExisteDejaException;
import fr.esgi.DDDProject.infrastructure.salle.SalleNExistePasException;

/**
 * The Interface Salles.
 */
public interface Salles {
    
    /**
     * Gets the all.
     *
     * @return the all
     * @throws EtageNegatifException the etage negatif exception
     */
    List<Salle> getAll() throws EtageNegatifException;
    
    /**
     * Gets the by id.
     *
     * @param salleId the salle id
     * @return the by id
     */
    Salle getById(SalleId salleId);
    
    /**
     * Save.
     *
     * @param salle the salle
     * @return the salle
     * @throws SalleExisteDejaException the salle existe deja exception
     */
    Salle save(Salle salle) throws SalleExisteDejaException;
    
    /**
     * Update.
     *
     * @param salle the salle
     * @return the salle
     * @throws SalleNExistePasException the salle N existe pas exception
     */
    Salle update(Salle salle) throws SalleNExistePasException;
}
