package fr.esgi.DDDProject.infrastructure.salle;

public class SalleNExistePasException extends Exception {
    public SalleNExistePasException(String errorMessage) {
        super(errorMessage);
    }
}
