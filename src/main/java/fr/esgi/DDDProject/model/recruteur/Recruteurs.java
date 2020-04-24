package fr.esgi.DDDProject.model.recruteur;

import fr.esgi.DDDProject.infrastructure.ExceptionManager;

import java.util.List;

public interface Recruteurs {
    List<Recruteur> getAll() throws ExceptionManager;
    Recruteur getById(RecruteurId id);
    Recruteur save(Recruteur recruteur) throws ExceptionManager;
    Recruteur update(Recruteur recruteur) throws ExceptionManager;
}
