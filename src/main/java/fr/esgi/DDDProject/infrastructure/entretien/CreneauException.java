package fr.esgi.DDDProject.infrastructure.entretien;

public class CreneauException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
    public CreneauException(final String errorMessage) {
        super(errorMessage);
    }
}
