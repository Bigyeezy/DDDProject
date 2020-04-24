package fr.esgi.DDDProject.infrastructure.entretien;

public class DureeMaximaleDepasseException extends Exception {
    public DureeMaximaleDepasseException(String errorMessage) {
        super(errorMessage);
    }
}
