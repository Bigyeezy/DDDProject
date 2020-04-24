package fr.esgi.DDDProject.model.recruteur;

import fr.esgi.DDDProject.infrastructure.candidat.InvalideNomreAnneeExperienceException;
import fr.esgi.DDDProject.infrastructure.recruteur.RecretueurExisteDejaException;
import fr.esgi.DDDProject.infrastructure.recruteur.RecruteurNExistePas;

import java.util.List;

public interface Recruteurs {
    List<Recruteur> getAll() throws  InvalideNomreAnneeExperienceException;
    Recruteur getById(RecruteurId id);
    Recruteur save(Recruteur recruteur) throws RecretueurExisteDejaException;
    Recruteur update(Recruteur recruteur) throws RecruteurNExistePas;
}
