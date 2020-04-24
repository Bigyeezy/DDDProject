package fr.esgi.DDDProject.model.salle;

import fr.esgi.DDDProject.infrastructure.ExceptionManager;

import java.util.List;

public interface Salles {
    List<Salle> getAll();
    Salle getById(SalleId salleId);
    Salle save(Salle salle) throws ExceptionManager;
    Salle update(Salle salle) throws ExceptionManager;
}
