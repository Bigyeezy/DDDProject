package fr.esgi.DDDProject.infrastructure.salle;

public class SalleNExistePasException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public SalleNExistePasException(final String errorMessage) {
        super(errorMessage);
    }
}
