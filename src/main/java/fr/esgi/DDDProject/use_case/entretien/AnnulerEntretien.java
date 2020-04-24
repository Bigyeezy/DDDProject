package fr.esgi.DDDProject.use_case.entretien;

import fr.esgi.DDDProject.infrastructure.ExceptionManager;
import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.entretien.Entretiens;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import fr.esgi.DDDProject.model.recruteur.Recruteurs;
import fr.esgi.DDDProject.model.salle.Salle;
import fr.esgi.DDDProject.model.salle.Salles;

public class AnnulerEntretien {

    Entretiens fauxEntretienBD;
    Salles fauxSalleBD;
    Recruteurs fauxRecruteursBD;

    public AnnulerEntretien(Entretiens fauxEntretienBD, Salles fauxSalleBD, Recruteurs fauxRecruteursBD) throws ExceptionManager {
        this.fauxEntretienBD = fauxEntretienBD;
        this.fauxSalleBD = fauxSalleBD;
        this.fauxRecruteursBD = fauxRecruteursBD;
    }

    public Entretien annulerEntretien(Entretien entretien, String raison) throws ExceptionManager {
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
