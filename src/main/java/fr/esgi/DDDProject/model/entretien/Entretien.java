package fr.esgi.DDDProject.model.entretien;

import java.util.Objects;

public class Entretien {
    private EntretienId entretienId;
    private StatutEnum statut;
    private Creneau creneau;
    private String recruteur;
    private String candidat;


    public Entretien( Creneau creneau, String recruteur, String candidat) {
        this.entretienId = new EntretienId();
        this.statut = StatutEnum.EN_ATTENTE;
        this.creneau = creneau;
        this.recruteur = recruteur;
        this.candidat = candidat;
    }

    public void  confirmer(){
        this.statut = StatutEnum.VALIDER;
    }

    public void annuler(String raison){
        this.statut = StatutEnum.ANNULER;
    }



    public EntretienId getEntretienId() {
        return entretienId;
    }

    public StatutEnum getStatut() {
        return statut;
    }

     public Creneau getCreneau() {
        return creneau;
    }

    public String getRecruteur() {
        return recruteur;
    }

    public String getCandidat() {
        return candidat;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entretien entretien = (Entretien) o;
        return Objects.equals(entretienId, entretien.entretienId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(entretienId, statut, creneau, recruteur, candidat);
    }
}
