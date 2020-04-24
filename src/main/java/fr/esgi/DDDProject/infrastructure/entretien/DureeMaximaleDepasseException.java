package fr.esgi.DDDProject.infrastructure.entretien;

public class DureeMaximaleDepasseException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public DureeMaximaleDepasseException(final String errorMessage) {
        super(errorMessage);
    }
}
