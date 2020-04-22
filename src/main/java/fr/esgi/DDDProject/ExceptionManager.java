package fr.esgi.DDDProject;

public class ExceptionManager extends Exception {

    private final String message;

    public ExceptionManager(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
