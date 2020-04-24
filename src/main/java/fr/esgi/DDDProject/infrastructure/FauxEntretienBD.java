package fr.esgi.DDDProject.infrastructure;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
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
import fr.esgi.DDDProject.model.candidat.Candidat;
import fr.esgi.DDDProject.model.entretien.Creneau;
import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.entretien.Entretiens;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import fr.esgi.DDDProject.model.salle.SalleId;

/**
 * The Class FauxEntretienBD.
 */
public class FauxEntretienBD implements Entretiens {

    private final List<Entretien> entretiens = new ArrayList<>();

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
    @Override
    public List<Entretien> getAll() throws DureeNegativeException, HeureEntretientHorsCrenauException, DureeMaximaleDepasseException, ParametreNullException, DateEnWeekendException, InvalideNomreAnneeExperienceException, CreneauException, ExperienceCandidatSuperieurRecruteurException, EtageNegatifException, CapaciteNegatifException {
        final Creneau creneau = new Creneau( LocalDateTime.of(2020, Month.JANUARY,6,18,0), 1);
        final List<LocalDate> disponibilites = Arrays.asList(LocalDate.of(2020, Month.JANUARY,6));

        final List<String> typeProfil = Arrays.asList("Java", ".NET");

        final Recruteur recruteur = new Recruteur("Dujardin", "Jean", "jdujardin@sojax.fr", 10, disponibilites);
        final Candidat candidat = new Candidat("TAKO", "Guillaume", "gTako@gmail.com", "cv_tako.pdf", 7, typeProfil);
        final SalleId salleId = new SalleId();
        final Entretien entretien = new Entretien(creneau, recruteur, candidat, salleId);

        this.entretiens.add(entretien);

        return entretiens;
    }

    /**
     * Save.
     *
     * @param entretien the entretien
     * @return the entretien
     * @throws EntretienExisteDejaExecption the entretien existe deja execption
     */
    @Override
    public Entretien save(final Entretien entretien) throws EntretienExisteDejaExecption {
        if (entretiens.contains(entretien)) {
            throw new EntretienExisteDejaExecption("Un entretien existe déjà.");
        }
        entretiens.add(entretien);

        return entretien;
    }

    /**
     * Update.
     *
     * @param entretien the entretien
     * @return the entretien
     * @throws ExtretienNExistePas the extretien N existe pas
     */
    @Override
    public Entretien update(final Entretien entretien) throws ExtretienNExistePas {
        final int index = entretiens.indexOf(entretien);

        if (index == -1) {
            throw new ExtretienNExistePas("Cet entretien n'existe pas.");
        }
        entretiens.set(index, entretien);

        return entretien;
    }


}
