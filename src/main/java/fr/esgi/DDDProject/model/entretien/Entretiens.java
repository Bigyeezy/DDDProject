package fr.esgi.DDDProject.model.entretien;

import fr.esgi.DDDProject.infrastructure.candidat.InvalideNomreAnneeExperienceException;
import fr.esgi.DDDProject.infrastructure.entretien.*;

import java.util.List;

public interface Entretiens {

    List<Entretien> getAll() throws  DureeNegativeException, HeureEntretientHorsCrenauException, DureeMaximaleDepasseException, ParametreNullException, DateEnWeekendException, InvalideNomreAnneeExperienceException, CreneauException, ExperienceCandidatSuperieurRecruteurException;
    Entretien save(Entretien entretien) throws  EntretienExisteDejaExecption;
    Entretien update(Entretien entretien) throws  ExtretienNExistePas;
}
