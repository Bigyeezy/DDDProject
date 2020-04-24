package fr.esgi.DDDProject.infrastructure;

import fr.esgi.DDDProject.infrastructure.salle.EtageNegatifException;
import fr.esgi.DDDProject.infrastructure.salle.SalleExisteDejaException;
import fr.esgi.DDDProject.infrastructure.salle.SalleNExistePasException;
import fr.esgi.DDDProject.model.salle.Salle;
import fr.esgi.DDDProject.model.salle.SalleId;
import fr.esgi.DDDProject.model.salle.Salles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FauxSalleBD implements Salles {

    List<Salle> salles = new ArrayList<>();

    @Override
    public List<Salle> getAll() throws EtageNegatifException {
        List<LocalDate> disponibilites = new ArrayList<>();
        disponibilites.add(LocalDate.of(2020, 4, 23));
        disponibilites.add(LocalDate.of(2020, 4, 24));
        disponibilites.add(LocalDate.of(2020, 4, 25));

        salles.add(new Salle("Salle 1", 1, 10, disponibilites));
        salles.add(new Salle("Salle 2", 2, 12, disponibilites));
        salles.add(new Salle("Salle 3", 3, 15, disponibilites));

        return salles;
    }

    @Override
    public Salle getById(SalleId salleId) {
        return salles.stream().filter(salle -> salle.getSalleId() == salleId).findFirst().orElse(null);
    }

    @Override
    public Salle save(Salle salle) throws SalleExisteDejaException {
        if (salles.contains(salle)) {
            throw new SalleExisteDejaException("Une salle existe déjà.");
        }
        salles.add(salle);

        return salle;
    }

    @Override
    public Salle update(Salle salle) throws SalleNExistePasException {
        final int index = salles.indexOf(salle);

        if (index == -1) {
            throw new SalleNExistePasException("Cette salle n'existe pas.");
        }
        salles.set(index, salle);

        return salle;
    }
}
