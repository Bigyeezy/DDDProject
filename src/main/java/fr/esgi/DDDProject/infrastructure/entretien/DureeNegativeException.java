package fr.esgi.DDDProject.infrastructure.entretien;

public class DureeNegativeException extends Exception {
    public DureeNegativeException(String errorMessage) {
        super(errorMessage);
    }
}
