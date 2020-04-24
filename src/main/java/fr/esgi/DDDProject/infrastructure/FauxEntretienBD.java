package fr.esgi.DDDProject.infrastructure;

import fr.esgi.DDDProject.model.candidat.Candidat;
import fr.esgi.DDDProject.model.entretien.Creneau;
import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.entretien.IEntretiens;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import fr.esgi.DDDProject.model.salle.SalleId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FauxEntretienBD implements IEntretiens {

    List<Entretien> entretiens = new ArrayList<>();

    public FauxEntretienBD() throws ExceptionManager {
        Creneau creneau = new Creneau( LocalDateTime.of(2020, Month.JANUARY,6,18,00), 1);
        Map<LocalDateTime, Boolean> dispo = new HashMap<>();
        dispo.put(LocalDateTime.of(2020, Month.JANUARY,6,18,00),true);

        List<String> typeProfil = new ArrayList<>();
        typeProfil.add("Java");

        Recruteur recruteur = new Recruteur("Dujardin", "Jean", "jdujardin@sojax.fr", 10, dispo);
        Candidat candidat = new Candidat("TAKO", "Guillaume", "gTako@gmail.com", "cv_tako.pdf", 7, typeProfil);
        SalleId salleId = new SalleId();
        Entretien entretien = new Entretien(creneau, recruteur, candidat, salleId);

        this.entretiens.add(entretien);
    }

    @Override
    public List<Entretien> getAll() {
        return entretiens;
    }

    @Override
    public Entretien save(final Entretien entretien) throws ExceptionManager {
        if (entretiens.contains(entretien)) {
            throw new ExceptionManager("Un entretien existe déjà.");
        }
        entretiens.add(entretien);

        return entretien;
    }

    @Override
    public Entretien update(final Entretien entretien) throws ExceptionManager {
        final int index = entretiens.indexOf(entretien);

        if (index == -1) {
            throw new ExceptionManager("Cet entretien n'existe pas.");
        }
        entretiens.set(index, entretien);

        return entretien;
    }


}