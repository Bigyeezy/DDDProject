package fr.esgi.DDDProject.infrastructure.entretien;

public class DateEnWeekendException extends Exception {
    public DateEnWeekendException(String errorMessage) {
        super(errorMessage);
    }
}
