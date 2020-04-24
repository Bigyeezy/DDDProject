package fr.esgi.DDDProject.infrastructure;

import fr.esgi.DDDProject.model.candidat.Candidat;
import fr.esgi.DDDProject.model.entretien.Creneau;
import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.entretien.IEntretiens;
import fr.esgi.DDDProject.model.recruteur.Recruteur;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntretienFakeDB implements IEntretiens {

    List<Entretien> entretiens = new ArrayList<>();

    public EntretienFakeDB() throws ExceptionManager {
        Creneau creneau = new Creneau( LocalDateTime.of(2020, Month.JANUARY,6,18,00), 1);
        Map<LocalDateTime, Boolean> dispo = new HashMap<>();
        dispo.put(LocalDateTime.of(2020, Month.JANUARY,6,18,00),true);

        Recruteur recruteur = new Recruteur("Dujardin", "Jean", "jdujardin@sojax.fr", 10, dispo);
        //Candidat candidat = new

       // this.entretiens.add();
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
