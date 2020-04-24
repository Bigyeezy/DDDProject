package fr.esgi.DDDProject.infrastructure;

import fr.esgi.DDDProject.infrastructure.candidat.InvalideNomreAnneeExperienceException;
import fr.esgi.DDDProject.infrastructure.recruteur.RecretueurExisteDejaException;
import fr.esgi.DDDProject.infrastructure.recruteur.RecruteurNExistePas;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import fr.esgi.DDDProject.model.recruteur.RecruteurId;
import fr.esgi.DDDProject.model.recruteur.Recruteurs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Class FauxRecruteurBD.
 */
public class FauxRecruteurBD implements Recruteurs {

    private final List<Recruteur> recruteurs = new ArrayList<>();

    /**
     * Gets the all.
     *
     * @return the all
     * @throws InvalideNomreAnneeExperienceException the invalide nomre annee experience exception
     */
    @Override
    public List<Recruteur> getAll() throws InvalideNomreAnneeExperienceException {
        final List<LocalDate> disponibilites = new ArrayList<>();
        disponibilites.add(LocalDate.of(2020, 4, 23));
        disponibilites.add(LocalDate.of(2020, 4, 24));
        disponibilites.add(LocalDate.of(2020, 4, 25));

        recruteurs.add(new Recruteur("Jackob", "Loic", "loic@monadresse.com", 5, disponibilites));
        recruteurs.add(new Recruteur("Dupont", "Paulben", "paulben@esgi.com", 6, disponibilites));
        return recruteurs;
    }

    /**
     * Gets the by id.
     *
     * @param id the id
     * @return the by id
     */
    @Override
    public Recruteur getById(final RecruteurId id) {
        return recruteurs.stream().filter(recruteur -> recruteur.getRecruteurId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Save.
     *
     * @param recruteur the recruteur
     * @return the recruteur
     * @throws RecretueurExisteDejaException the recretueur existe deja exception
     */
    @Override
    public Recruteur save(final Recruteur recruteur) throws RecretueurExisteDejaException {
        if (recruteurs.contains(recruteur)) {
            throw new RecretueurExisteDejaException("Un recruteur existe déjà.");
        }
        recruteurs.add(recruteur);

        return recruteur;
    }

    /**
     * Update.
     *
     * @param recruteur the recruteur
     * @return the recruteur
     * @throws RecruteurNExistePas the recruteur N existe pas
     */
    @Override
    public Recruteur update(final Recruteur recruteur) throws RecruteurNExistePas {
        final int index = recruteurs.indexOf(recruteur);

        if (index == -1) {
            throw new RecruteurNExistePas("Ce recruteur n'existe pas.");
        }
        recruteurs.set(index, recruteur);

        return recruteur;
    }

}