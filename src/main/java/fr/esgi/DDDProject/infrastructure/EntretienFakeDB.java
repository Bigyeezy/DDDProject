package fr.esgi.DDDProject.infrastructure;

import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.entretien.IEntretiens;

import java.util.ArrayList;
import java.util.List;

public class EntretienFakeDB implements IEntretiens {

    List<Entretien> entretiens = new ArrayList<>();

    public EntretienFakeDB(List<Entretien> entretiens) {
        this.entretiens = entretiens;
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
