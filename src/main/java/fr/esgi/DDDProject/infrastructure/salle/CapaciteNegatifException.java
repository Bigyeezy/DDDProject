package fr.esgi.DDDProject.infrastructure.salle;

public class CapaciteNegatifException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CapaciteNegatifException(final String errorMessage) {
        super(errorMessage);
    }

}
