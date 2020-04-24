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

public class FauxRecruteurBD implements Recruteurs {

    private final List<Recruteur> recruteurs = new ArrayList<>();

    @Override
    public List<Recruteur> getAll() throws InvalideNomreAnneeExperienceException {
        List<LocalDate> disponibilites = new ArrayList<>();
        disponibilites.add(LocalDate.of(2020, 4, 23));
        disponibilites.add(LocalDate.of(2020, 4, 24));
        disponibilites.add(LocalDate.of(2020, 4, 25));

        recruteurs.add(new Recruteur("Jackob", "Loic", "loic@monadresse.com", 5, disponibilites));
        recruteurs.add(new Recruteur("Dupont", "Paulben", "paulben@esgi.com", 6, disponibilites));
        return recruteurs;
    }

    @Override
    public Recruteur getById(RecruteurId id) {
        return recruteurs.stream().filter(recruteur -> recruteur.getRecruteurId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Recruteur save(Recruteur recruteur) throws RecretueurExisteDejaException {
        if (recruteurs.contains(recruteur)) {
            throw new RecretueurExisteDejaException("Un recruteur existe déjà.");
        }
        recruteurs.add(recruteur);

        return recruteur;
    }

    @Override
    public Recruteur update(Recruteur recruteur) throws RecruteurNExistePas {
        final int index = recruteurs.indexOf(recruteur);

        if (index == -1) {
            throw new RecruteurNExistePas("Ce recruteur n'existe pas.");
        }
        recruteurs.set(index, recruteur);

        return recruteur;
    }

}