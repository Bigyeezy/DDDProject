package fr.esgi.DDDProject.infrastructure.entretien;

public class ParametreNullException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public ParametreNullException(final String errorMessage) {
        super(errorMessage);
    }
}
