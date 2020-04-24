package fr.esgi.DDDProject.model.candidat;

import fr.esgi.DDDProject.infrastructure.candidat.InvalideNomreAnneeExperienceException;

import java.util.List;
import java.util.Objects;

public class Candidat {

    private final String nom;
    private final String prenom;
    private final String email;
    private final String CV;
    private final Integer nombreAnneeExperience;
    private final List<String> typeProfil;

    public Candidat(
            final String nom,
            final String prenom,
            final String email,
            final String CV,
            final Integer nombreAnneeExperience,
            final List<String> typeProfil) throws InvalideNomreAnneeExperienceException {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.CV = CV;

        if (nombreAnneeExperience < 0) {
            throw new InvalideNomreAnneeExperienceException("Votre nombre d'année d'expérience n'est pas valide");
        }
        this.nombreAnneeExperience = nombreAnneeExperience;
        this.typeProfil = typeProfil;
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

    public String getCV() {
        return CV;
    }

    public Integer getNombreAnneeExperience() {
        return nombreAnneeExperience;
    }

    public List<String> getTypeProfil() {
        return typeProfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidat candidat = (Candidat) o;
        return Objects.equals(nom, candidat.nom) &&
                Objects.equals(prenom, candidat.prenom) &&
                Objects.equals(email, candidat.email) &&
                Objects.equals(CV, candidat.CV) &&
                Objects.equals(nombreAnneeExperience, candidat.nombreAnneeExperience) &&
                Objects.equals(typeProfil, candidat.typeProfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, email, CV, nombreAnneeExperience, typeProfil);
    }
}