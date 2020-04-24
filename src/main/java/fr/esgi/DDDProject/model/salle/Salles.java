package fr.esgi.DDDProject.model.salle;

import fr.esgi.DDDProject.infrastructure.salle.EtageNegatifException;
import fr.esgi.DDDProject.infrastructure.salle.SalleExisteDejaException;
import fr.esgi.DDDProject.infrastructure.salle.SalleNExistePasException;

import java.util.List;

public interface Salles {
    List<Salle> getAll() throws EtageNegatifException;
    Salle getById(SalleId salleId);
    Salle save(Salle salle) throws SalleExisteDejaException;
    Salle update(Salle salle) throws SalleNExistePasException;
}
