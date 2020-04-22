package fr.esgi.DDDProject.entity;

import fr.esgi.DDDProject.valueobject.Creneau;

import java.util.Objects;

public class Entretien {
    final Integer entretienId;
    private String statut;
    private Creneau creneau;
    private String recruteur;
    private String candidat;


    public Entretien(Integer entretienId, String statut, Creneau creneau, String recruteur, String candidat) {
        this.entretienId = entretienId;
        this.statut = statut;
        this.creneau = creneau;
        this.recruteur = recruteur;
        this.candidat = candidat;
    }




    public Integer getEntretienId() {
        return entretienId;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    public String getRecruteur() {
        return recruteur;
    }

    public void setRecruteur(String recruteur) {
        this.recruteur = recruteur;
    }

    public String getCandidat() {
        return candidat;
    }

    public void setCandidat(String candidat) {
        this.candidat = candidat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entretien entretien = (Entretien) o;
        return Objects.equals(entretienId, entretien.entretienId) &&
                Objects.equals(statut, entretien.statut) &&
                Objects.equals(creneau, entretien.creneau) &&
                Objects.equals(recruteur, entretien.recruteur) &&
                Objects.equals(candidat, entretien.candidat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entretienId, statut, creneau, recruteur, candidat);
    }
}
