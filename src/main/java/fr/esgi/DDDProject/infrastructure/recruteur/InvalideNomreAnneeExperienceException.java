package fr.esgi.DDDProject.infrastructure.recruteur;

public class InvalideNomreAnneeExperienceException extends Exception {
    public InvalideNomreAnneeExperienceException(String errorMessage) {
        super(errorMessage);
    }
}