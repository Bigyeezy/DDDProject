package fr.esgi.DDDProject;

import java.util.Objects;

public class Entretien {
    private final Integer entretienId;
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

    public void  confirmer(){

       // return false;
    }

    public void annuler(String raison){
        //
    }



    public Integer getEntretienId() {
        return entretienId;
    }

    public String getStatut() {
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
