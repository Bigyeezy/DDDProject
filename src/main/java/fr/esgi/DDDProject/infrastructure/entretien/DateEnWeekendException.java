package fr.esgi.DDDProject.infrastructure.entretien;

public class DateEnWeekendException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public DateEnWeekendException(final String errorMessage) {
        super(errorMessage);
    }
}
