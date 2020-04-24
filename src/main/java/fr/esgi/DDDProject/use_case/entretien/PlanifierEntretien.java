package fr.esgi.DDDProject.use_case.entretien;

import fr.esgi.DDDProject.model.candidat.Candidat;
import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import fr.esgi.DDDProject.model.salle.Salle;

import java.time.LocalDateTime;

public class PlanifierEntretien {

    Entretien entretien;
    Salle salle;

    public void planifierUnEntretien(Candidat candidat, Recruteur recruteur, LocalDateTime date) {
        if (candidat.getNombreAnneeExperience() >= recruteur.getNombreAnneeExperience())
            return;

        if (entretien.getCreneau().getHeureDebut().getHour() < 18 || entretien.getCreneau().getHeureFin().getHour() > 21) {
            return;
        }

        if (entretien.getCreneau().getDuree() > 3) {
            return;
        }

        if (recruteur.getDisponibilites().get(date) != null && salle.getDisponibilites().get(date) != null &&
                !recruteur.getDisponibilites().get(date) && !salle.getDisponibilites().get(date)) {
            // TODO : Save
        }
    }

}
