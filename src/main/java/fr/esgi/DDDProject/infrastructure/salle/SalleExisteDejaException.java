package fr.esgi.DDDProject.infrastructure.salle;

public class SalleExisteDejaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public SalleExisteDejaException(final String errorMessage) {
        super(errorMessage);
    }
}
