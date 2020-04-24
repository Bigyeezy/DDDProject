package fr.esgi.DDDProject.model.recruteur;

import fr.esgi.DDDProject.infrastructure.ExceptionManager;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class Recruteur {

    private final String nom;
    private final String prenom;
    private final String email;
    private final Integer nombreAnneeExperience;
    private final Map<LocalDateTime, Boolean> disponibilites;

    public Recruteur(String nom, String prenom, String email, Integer nombreAnneeExperience, Map<LocalDateTime, Boolean> disponibilites) throws ExceptionManager {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        if(nombreAnneeExperience < 0 ) {
            throw new ExceptionManager("Votre nombre d'année d'expérience n'est pas valide");
        }
        this.nombreAnneeExperience = nombreAnneeExperience;
        this.disponibilites = disponibilites;
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

    public Map<LocalDateTime, Boolean> getDisponibilites() {
        return disponibilites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recruteur recruteur = (Recruteur) o;

        if (nom != null ? !nom.equals(recruteur.nom) : recruteur.nom != null) return false;
        if (prenom != null ? !prenom.equals(recruteur.prenom) : recruteur.prenom != null) return false;
        if (email != null ? !email.equals(recruteur.email) : recruteur.email != null) return false;
        if (nombreAnneeExperience != null ? !nombreAnneeExperience.equals(recruteur.nombreAnneeExperience) : recruteur.nombreAnneeExperience != null)
            return false;
        return disponibilites != null ? disponibilites.equals(recruteur.disponibilites) : recruteur.disponibilites == null;
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nombreAnneeExperience != null ? nombreAnneeExperience.hashCode() : 0);
        result = 31 * result + (disponibilites != null ? disponibilites.hashCode() : 0);
        return result;
    }
}
