package fr.esgi.DDDProject.infrastructure.entretien;

public class ExperienceCandidatSuperieurRecruteurException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public ExperienceCandidatSuperieurRecruteurException(final String errorMessage) {
        super(errorMessage);
    }
}
