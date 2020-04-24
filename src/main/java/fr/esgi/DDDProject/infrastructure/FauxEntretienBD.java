package fr.esgi.DDDProject.infrastructure;

import fr.esgi.DDDProject.infrastructure.candidat.InvalideNomreAnneeExperienceException;
import fr.esgi.DDDProject.infrastructure.entretien.*;
import fr.esgi.DDDProject.model.candidat.Candidat;
import fr.esgi.DDDProject.model.entretien.Creneau;
import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.entretien.Entretiens;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import fr.esgi.DDDProject.model.salle.SalleId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class FauxEntretienBD implements Entretiens {

    List<Entretien> entretiens = new ArrayList<>();

    @Override
    public List<Entretien> getAll() throws DureeNegativeException, HeureEntretientHorsCrenauException, DureeMaximaleDepasseException, ParametreNullException, DateEnWeekendException, InvalideNomreAnneeExperienceException, CreneauException, ExperienceCandidatSuperieurRecruteurException {
        Creneau creneau = new Creneau( LocalDateTime.of(2020, Month.JANUARY,6,18,00), 1);
        List<LocalDate> dispo = new ArrayList<>();

        dispo.add(LocalDate.of(2020, Month.JANUARY,6));

        List<String> typeProfil = new ArrayList<>();
        typeProfil.add("Java");
        typeProfil.add(".NET");

        Recruteur recruteur = new Recruteur("Dujardin", "Jean", "jdujardin@sojax.fr", 10, dispo);
        Candidat candidat = new Candidat("TAKO", "Guillaume", "gTako@gmail.com", "cv_tako.pdf", 7, typeProfil);
        SalleId salleId = new SalleId();
        Entretien entretien = new Entretien(creneau, recruteur, candidat, salleId);

        this.entretiens.add(entretien);

        return entretiens;
    }

    @Override
    public Entretien save(final Entretien entretien) throws EntretienExisteDejaExecption {
        if (entretiens.contains(entretien)) {
            throw new EntretienExisteDejaExecption("Un entretien existe déjà.");
        }
        entretiens.add(entretien);

        return entretien;
    }

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
