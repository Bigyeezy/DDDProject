package fr.esgi.DDDProject.use_case.entretien;

import fr.esgi.DDDProject.infrastructure.entretien.ExtretienNExistePas;
import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.entretien.Entretiens;
import fr.esgi.DDDProject.model.salle.Salles;

public class ConfirmerEntretien {

    Entretiens fauxEntretienBD;
    Salles fauxSalleBD;

    public ConfirmerEntretien(Entretiens fauxEntretienBD, Salles fauxSalleBD) {
        this.fauxEntretienBD = fauxEntretienBD;
        this.fauxSalleBD = fauxSalleBD;
    }

    public Entretien confirmerEntretien(Entretien entretien) throws ExtretienNExistePas {
        entretien.confirmer();
        fauxEntretienBD.update(entretien);

        return entretien;
    }
}
