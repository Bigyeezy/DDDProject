package fr.esgi.DDDProject.use_case.entretien;

import fr.esgi.DDDProject.infrastructure.entretien.ExtretienNExistePas;
import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.entretien.Entretiens;
import fr.esgi.DDDProject.model.salle.Salles;

/**
 * The Class ConfirmerEntretien.
 */
public class ConfirmerEntretien {

    private final Entretiens fauxEntretienBD;

    private final Salles fauxSalleBD;

    public ConfirmerEntretien(final Entretiens fauxEntretienBD, final Salles fauxSalleBD) {
        this.fauxEntretienBD = fauxEntretienBD;
        this.fauxSalleBD = fauxSalleBD;
    }

    /**
     * Confirmer entretien.
     *
     * @param entretien the entretien
     * @return the entretien
     * @throws ExtretienNExistePas the extretien N existe pas
     */
    public Entretien confirmerEntretien(final Entretien entretien) throws ExtretienNExistePas {
        entretien.confirmer();
        fauxEntretienBD.update(entretien);

        return entretien;
    }
}
