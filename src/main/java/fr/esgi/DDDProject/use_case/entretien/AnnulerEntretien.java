package fr.esgi.DDDProject.use_case.entretien;

import fr.esgi.DDDProject.infrastructure.entretien.ExtretienNExistePas;
import fr.esgi.DDDProject.infrastructure.recruteur.RecruteurNExistePas;
import fr.esgi.DDDProject.infrastructure.salle.SalleNExistePasException;
import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.entretien.Entretiens;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import fr.esgi.DDDProject.model.recruteur.Recruteurs;
import fr.esgi.DDDProject.model.salle.Salle;
import fr.esgi.DDDProject.model.salle.Salles;

/**
 * The Class AnnulerEntretien.
 */
public class AnnulerEntretien {

    private final Entretiens fauxEntretienBD;
    private final Salles fauxSalleBD;
    private final Recruteurs fauxRecruteursBD;

    public AnnulerEntretien(final Entretiens fauxEntretienBD, final Salles fauxSalleBD, final Recruteurs fauxRecruteursBD) {
        this.fauxEntretienBD = fauxEntretienBD;
        this.fauxSalleBD = fauxSalleBD;
        this.fauxRecruteursBD = fauxRecruteursBD;
    }

    /**
     * Annuler entretien.
     *
     * @param entretien the entretien
     * @param raison the raison
     * @return the entretien
     * @throws ExtretienNExistePas the extretien N existe pas
     * @throws SalleNExistePasException the salle N existe pas exception
     * @throws RecruteurNExistePas the recruteur N existe pas
     */
    public Entretien annulerEntretien(final Entretien entretien, final String raison) throws ExtretienNExistePas, SalleNExistePasException, RecruteurNExistePas {
        entretien.annuler(raison);
        fauxEntretienBD.update(entretien);

        final Salle salle = fauxSalleBD.getById(entretien.getSalleId());
        salle.liberer(entretien.getCreneau().getDate());
        fauxSalleBD.update(salle);

        final Recruteur recruteur = fauxRecruteursBD.getById(entretien.getRecruteur().getRecruteurId());
        recruteur.liberer(entretien.getCreneau().getDate());
        fauxRecruteursBD.update(recruteur);

        return entretien;
    }

}
