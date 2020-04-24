package fr.esgi.DDDProject.model.entretien;

import java.util.List;

import fr.esgi.DDDProject.infrastructure.candidat.InvalideNomreAnneeExperienceException;
import fr.esgi.DDDProject.infrastructure.entretien.CreneauException;
import fr.esgi.DDDProject.infrastructure.entretien.DateEnWeekendException;
import fr.esgi.DDDProject.infrastructure.entretien.DureeMaximaleDepasseException;
import fr.esgi.DDDProject.infrastructure.entretien.DureeNegativeException;
import fr.esgi.DDDProject.infrastructure.entretien.EntretienExisteDejaExecption;
import fr.esgi.DDDProject.infrastructure.entretien.ExperienceCandidatSuperieurRecruteurException;
import fr.esgi.DDDProject.infrastructure.entretien.ExtretienNExistePas;
import fr.esgi.DDDProject.infrastructure.entretien.HeureEntretientHorsCrenauException;
import fr.esgi.DDDProject.infrastructure.entretien.ParametreNullException;
import fr.esgi.DDDProject.infrastructure.salle.CapaciteNegatifException;
import fr.esgi.DDDProject.infrastructure.salle.EtageNegatifException;

/**
 * The Interface Entretiens.
 */
public interface Entretiens {

    /**
     * Gets the all.
     *
     * @return the all
     * @throws DureeNegativeException the duree negative exception
     * @throws HeureEntretientHorsCrenauException the heure entretient hors crenau exception
     * @throws DureeMaximaleDepasseException the duree maximale depasse exception
     * @throws ParametreNullException the parametre null exception
     * @throws DateEnWeekendException the date en weekend exception
     * @throws InvalideNomreAnneeExperienceException the invalide nomre annee experience exception
     * @throws CreneauException the creneau exception
     * @throws ExperienceCandidatSuperieurRecruteurException the experience candidat superieur recruteur exception
     * @throws EtageNegatifException the etage negatif exception
     * @throws CapaciteNegatifException the capacite negatif exception
     */
    List<Entretien> getAll() throws DureeNegativeException, HeureEntretientHorsCrenauException, DureeMaximaleDepasseException, ParametreNullException, DateEnWeekendException, InvalideNomreAnneeExperienceException, CreneauException, ExperienceCandidatSuperieurRecruteurException, EtageNegatifException, CapaciteNegatifException;
    
    /**
     * Save.
     *
     * @param entretien the entretien
     * @return the entretien
     * @throws EntretienExisteDejaExecption the entretien existe deja execption
     */
    Entretien save(Entretien entretien) throws  EntretienExisteDejaExecption;
    
    /**
     * Update.
     *
     * @param entretien the entretien
     * @return the entretien
     * @throws ExtretienNExistePas the extretien N existe pas
     */
    Entretien update(Entretien entretien) throws  ExtretienNExistePas;
}
