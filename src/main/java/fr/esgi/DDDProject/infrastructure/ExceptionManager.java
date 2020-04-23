package fr.esgi.DDDProject.infrastructure;

public class ExceptionManager extends Exception {

    private final String message;

    public ExceptionManager(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
