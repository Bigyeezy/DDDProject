package fr.esgi.DDDProject.infrastructure.entretien;

public class DureeNegativeException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public DureeNegativeException(final String errorMessage) {
        super(errorMessage);
    }
}
