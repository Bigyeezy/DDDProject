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

public class AnnulerEntretien {

    private final Entretiens fauxEntretienBD;
    private final Salles fauxSalleBD;
    private final Recruteurs fauxRecruteursBD;

    public AnnulerEntretien(final Entretiens fauxEntretienBD, final Salles fauxSalleBD, final Recruteurs fauxRecruteursBD) {
        this.fauxEntretienBD = fauxEntretienBD;
        this.fauxSalleBD = fauxSalleBD;
        this.fauxRecruteursBD = fauxRecruteursBD;
    }

    public Entretien annulerEntretien(final Entretien entretien, final String raison) throws ExtretienNExistePas, SalleNExistePasException, RecruteurNExistePas {
        entretien.annuler(raison);
        fauxEntretienBD.update(entretien);

        Salle salle = fauxSalleBD.getById(entretien.getSalleId());
        salle.liberer(entretien.getCreneau().getDate());
        fauxSalleBD.update(salle);

        Recruteur recruteur = fauxRecruteursBD.getById(entretien.getRecruteur().getRecruteurId());
        recruteur.liberer(entretien.getCreneau().getDate());
        fauxRecruteursBD.update(recruteur);

        return entretien;
    }

}
