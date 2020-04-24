package fr.esgi.DDDProject.infrastructure;

import fr.esgi.DDDProject.infrastructure.salle.CapaciteNegatifException;
import fr.esgi.DDDProject.infrastructure.salle.EtageNegatifException;
import fr.esgi.DDDProject.infrastructure.salle.SalleExisteDejaException;
import fr.esgi.DDDProject.infrastructure.salle.SalleNExistePasException;
import fr.esgi.DDDProject.model.salle.Salle;
import fr.esgi.DDDProject.model.salle.SalleId;
import fr.esgi.DDDProject.model.salle.Salles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class FauxSalleBD.
 */
public class FauxSalleBD implements Salles {

    private List<Salle> salles = new ArrayList<>();

    public FauxSalleBD() throws EtageNegatifException, CapaciteNegatifException {
        this.init();
    }

    /**
     * Gets the all.
     *
     * @return the all
     * @throws EtageNegatifException the etage negatif exception
     */
    @Override
    public List<Salle> getAll() throws EtageNegatifException {
        return salles;
    }

    private void init() throws EtageNegatifException, CapaciteNegatifException {
        final List<LocalDate> disponibilites = new ArrayList<>();
        disponibilites.add(LocalDate.of(2020, 4, 23));
        disponibilites.add(LocalDate.of(2020, 4, 24));
        disponibilites.add(LocalDate.of(2020, 4, 25));

        salles.add(new Salle("Salle 1", 1, 10, disponibilites));
        salles.add(new Salle("Salle 2", 2, 12, disponibilites));
        salles.add(new Salle("Salle 3", 3, 15, disponibilites));
    }

    /**
     * Gets the by id.
     *
     * @param salleId the salle id
     * @return the by id
     */
    @Override
    public Salle getById(final SalleId salleId) {
        return salles.stream()
                .filter(salle -> salle.getSalleId() == salleId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Save.
     *
     * @param salle the salle
     * @return the salle
     * @throws SalleExisteDejaException the salle existe deja exception
     */
    @Override
    public Salle save(final Salle salle) throws SalleExisteDejaException {
        if (salles.contains(salle)) {
            throw new SalleExisteDejaException("Une salle existe déjà.");
        }
        salles.add(salle);

        return salle;
    }

    /**
     * Update.
     *
     * @param salle the salle
     * @return the salle
     * @throws SalleNExistePasException the salle N existe pas exception
     */
    @Override
    public Salle update(final Salle salle) throws SalleNExistePasException {
        final int index = salles.indexOf(salle);

        if (index == -1) {
            throw new SalleNExistePasException("Cette salle n'existe pas.");
        }
        salles.set(index, salle);

        return salle;
    }
}
