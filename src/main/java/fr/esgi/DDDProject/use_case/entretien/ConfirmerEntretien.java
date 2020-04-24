package fr.esgi.DDDProject.use_case.entretien;

import fr.esgi.DDDProject.infrastructure.ExceptionManager;
import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.entretien.Entretiens;
import fr.esgi.DDDProject.model.salle.Salles;

public class ConfirmerEntretien {

    Entretiens fauxEntretienBD;
    Salles fauxSalleBD;

    public ConfirmerEntretien(Entretiens fauxEntretienBD, Salles fauxSalleBD) throws ExceptionManager {
        this.fauxEntretienBD = fauxEntretienBD;
        this.fauxSalleBD = fauxSalleBD;
    }

    public Entretien confirmerEntretien(Entretien entretien) throws ExceptionManager {
        entretien.confirmer();
        fauxEntretienBD.update(entretien);

        return entretien;
    }
}
