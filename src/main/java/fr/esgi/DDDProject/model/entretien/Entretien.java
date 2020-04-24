package fr.esgi.DDDProject.model.entretien;

import fr.esgi.DDDProject.infrastructure.ExceptionManager;
import fr.esgi.DDDProject.model.candidat.Candidat;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import fr.esgi.DDDProject.model.salle.SalleId;

import java.util.Objects;

public class Entretien {
    private EntretienId entretienId;
    private SalleId salleId;
    private StatutEntretienEnum statut;
    private Creneau creneau;
    private Recruteur recruteur;
    private Candidat candidat;

    public Entretien(Creneau creneau, Recruteur recruteur, Candidat candidat, SalleId salleId) throws ExceptionManager {
        this.entretienId = new EntretienId();
        this.salleId = salleId;
        this.statut = StatutEntretienEnum.EN_ATTENTE;
        this.creneau = creneau;

        if (candidat.getNombreAnneeExperience() >= recruteur.getNombreAnneeExperience()) {
            throw new ExceptionManager("Le nombre d'année d'expérience du recruteur doit être supérieur au candidat.");
        }

        this.recruteur = recruteur;
        this.candidat = candidat;
    }

    public void  confirmer(){
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
