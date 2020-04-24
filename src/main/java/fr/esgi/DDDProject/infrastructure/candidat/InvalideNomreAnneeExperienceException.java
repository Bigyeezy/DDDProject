package fr.esgi.DDDProject.infrastructure.candidat;

public class InvalideNomreAnneeExperienceException extends Exception {
    public InvalideNomreAnneeExperienceException(String errorMessage) {
        super(errorMessage);
    }
}