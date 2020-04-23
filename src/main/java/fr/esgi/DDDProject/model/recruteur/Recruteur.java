package fr.esgi.DDDProject.model.recruteur;

import fr.esgi.DDDProject.infrastructure.ExceptionManager;

import java.util.Objects;

public class Recruteur {

    private final String nom;
    private final String prenom;
    private final String email;
    private final Integer nombreAnneeExperience;

    public Recruteur(String nom, String prenom, String email, Integer nombreAnneeExperience) throws ExceptionManager {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        if(nombreAnneeExperience < 0 ) {
            throw new ExceptionManager("Votre nombre d'année d'expérience n'est pas valide");
        }
        this.nombreAnneeExperience = nombreAnneeExperience;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruteur recruteur = (Recruteur) o;
        return Objects.equals(nom, recruteur.nom) &&
                Objects.equals(prenom, recruteur.prenom) &&
                Objects.equals(email, recruteur.email) &&
                Objects.equals(nombreAnneeExperience, recruteur.nombreAnneeExperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, email, nombreAnneeExperience);
    }
}
