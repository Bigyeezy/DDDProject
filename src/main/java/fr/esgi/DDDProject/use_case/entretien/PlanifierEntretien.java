package fr.esgi.DDDProject.use_case.entretien;

import fr.esgi.DDDProject.infrastructure.ExceptionManager;
import fr.esgi.DDDProject.model.candidat.Candidat;
import fr.esgi.DDDProject.model.entretien.Creneau;
import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.entretien.Entretiens;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import fr.esgi.DDDProject.model.recruteur.Recruteurs;
import fr.esgi.DDDProject.model.salle.Salle;
import fr.esgi.DDDProject.model.salle.Salles;

import java.time.LocalDateTime;
import java.util.List;

public class PlanifierEntretien {

    Entretiens fauxEntretienBD;
    Salles fauxSalleBD;
    Recruteurs fauxRecruteurBD;

    public PlanifierEntretien(Entretiens fauxEntretienBD, Salles fauxSalleBD, Recruteurs fauxRecruteurBD) throws ExceptionManager {
        this.fauxEntretienBD = fauxEntretienBD;
        this.fauxSalleBD = fauxSalleBD;
        this.fauxRecruteurBD = fauxRecruteurBD;
    }

    public Entretien planifierUnEntretien(Candidat candidat, LocalDateTime date, Integer duree) throws ExceptionManager {
        Creneau creneau = new Creneau(date, duree);

        List<Salle> salles = fauxSalleBD.getAll();
        Salle salle = salles.stream().filter(uneSalle -> uneSalle.getDisponibilites().contains(date)).findFirst().orElseGet(null);
        salle.reserver(date);
        fauxSalleBD.update(salle);

        List<Recruteur> recruteurs = fauxRecruteurBD.getAll();
        Recruteur recruteur = recruteurs.stream().filter(unRecruteur -> unRecruteur.getDisponibilites().contains(date)).findFirst().orElseGet(null);
        recruteur.reserver(date);
        fauxRecruteurBD.update(recruteur);

        Entretien entretien = new Entretien(creneau, recruteur, candidat, salle.getSalleId());
        fauxEntretienBD.save(entretien);

        return entretien;
    }

}
