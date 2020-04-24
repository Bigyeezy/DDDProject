package fr.esgi.DDDProject.model.entretien;

import fr.esgi.DDDProject.infrastructure.ExceptionManager;

import java.util.List;

public interface Entretiens {

    List<Entretien> getAll() throws ExceptionManager;
    Entretien save(Entretien entretien) throws ExceptionManager;
    Entretien update(Entretien entretien) throws ExceptionManager;
}
