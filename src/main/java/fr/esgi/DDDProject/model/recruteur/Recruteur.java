package fr.esgi.DDDProject.model.recruteur;

import fr.esgi.DDDProject.infrastructure.ExceptionManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Recruteur extends RecruteurId {

    private final RecruteurId recruteurId;
    private String nom;
    private String prenom;
    private String email;
    private Integer nombreAnneeExperience;
    private List<LocalDate> disponibilites;

    public Recruteur(String nom, String prenom, String email, Integer nombreAnneeExperience, List<LocalDate> disponibilites) throws ExceptionManager {
        this.recruteurId = new RecruteurId();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        if(nombreAnneeExperience < 0 ) {
            throw new ExceptionManager("Votre nombre d'année d'expérience n'est pas valide");
        }
        this.nombreAnneeExperience = nombreAnneeExperience;
        this.disponibilites = disponibilites;
    }

    public boolean reserver(LocalDateTime date) {
        int index = this.disponibilites.indexOf(date);

        if (index == -1)
        {
            return false;
        }

        this.disponibilites.remove(index);
        return true;
    }

    public boolean liberer(LocalDate date) {
        int index = this.disponibilites.indexOf(date);

        if (index == -1)
        {
            this.disponibilites.add(date);
            return true;
        }

        return false;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public Integer getNombreAnneeExperience() {
        return nombreAnneeExperience;
    }

    public List<LocalDate> getDisponibilites() {
        return disponibilites;
    }

    public RecruteurId getRecruteurId() {
        return recruteurId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Recruteur recruteur = (Recruteur) o;

        if (recruteurId != null ? !recruteurId.equals(recruteur.recruteurId) : recruteur.recruteurId != null)
            return false;
        if (nom != null ? !nom.equals(recruteur.nom) : recruteur.nom != null) return false;
        if (prenom != null ? !prenom.equals(recruteur.prenom) : recruteur.prenom != null) return false;
        if (email != null ? !email.equals(recruteur.email) : recruteur.email != null) return false;
        if (nombreAnneeExperience != null ? !nombreAnneeExperience.equals(recruteur.nombreAnneeExperience) : recruteur.nombreAnneeExperience != null)
            return false;
        return disponibilites != null ? disponibilites.equals(recruteur.disponibilites) : recruteur.disponibilites == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (recruteurId != null ? recruteurId.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nombreAnneeExperience != null ? nombreAnneeExperience.hashCode() : 0);
        result = 31 * result + (disponibilites != null ? disponibilites.hashCode() : 0);
        return result;
    }
}
