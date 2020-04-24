package fr.esgi.DDDProject.infrastructure.recruteur;

public class InvalideNomreAnneeExperienceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public InvalideNomreAnneeExperienceException(final String errorMessage) {
        super(errorMessage);
    }
}