package fr.esgi.DDDProject.model.entretien;

import fr.esgi.DDDProject.infrastructure.FauxSalleBD;
import fr.esgi.DDDProject.infrastructure.entretien.CreneauException;
import fr.esgi.DDDProject.infrastructure.entretien.ExperienceCandidatSuperieurRecruteurException;
import fr.esgi.DDDProject.model.candidat.Candidat;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import fr.esgi.DDDProject.model.salle.Salle;
import fr.esgi.DDDProject.model.salle.SalleId;

import java.time.LocalDate;
import java.util.Objects;

public class Entretien {
    private EntretienId entretienId;
    private SalleId salleId;
    private StatutEntretienEnum statut;
    private Creneau creneau;
    private Recruteur recruteur;
    private Candidat candidat;

    public Entretien(Creneau creneau, Recruteur recruteur, Candidat candidat, SalleId salleId) throws ExperienceCandidatSuperieurRecruteurException, CreneauException {
        this.entretienId = new EntretienId();
        this.salleId = salleId;
        this.statut = StatutEntretienEnum.EN_ATTENTE;
        this.creneau = creneau;

        if (candidat.getNombreAnneeExperience() >= recruteur.getNombreAnneeExperience()) {
            throw new ExperienceCandidatSuperieurRecruteurException("Le nombre d'année d'expérience du recruteur doit être supérieur au candidat.");
        }

        this.recruteur = recruteur;
        this.candidat = candidat;

        if(!estPossible(creneau.getDate(), salleId)) {
            throw new CreneauException("La salle ou le recruteur n'est pas disponnible");
        }
    }

    public boolean estPossible(LocalDate date, SalleId salleId) {
        FauxSalleBD fauxSalleBD = new FauxSalleBD();
        Salle salle = fauxSalleBD.getById(salleId);

        return recruteur.getDisponibilites().contains(date)
                && salle.getDisponibilites().contains(date);
    }

    public void confirmer(){
        this.statut = StatutEntretienEnum.VALIDER;
    }

    public void annuler(String raison){
        this.statut = StatutEntretienEnum.ANNULER;
    }

    public EntretienId getEntretienId() {
        return entretienId;
    }

    public SalleId getSalleId() {
        return salleId;
    }

    public StatutEntretienEnum getStatut() {
        return statut;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public Recruteur getRecruteur() {
        return recruteur;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entretien entretien = (Entretien) o;
        return Objects.equals(entretienId, entretien.entretienId) && Objects.equals(salleId, entretien.salleId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(entretienId, salleId, statut, creneau, recruteur, candidat);
    }
}
