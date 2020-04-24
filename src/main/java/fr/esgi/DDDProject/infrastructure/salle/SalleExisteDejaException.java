package fr.esgi.DDDProject.infrastructure.salle;

public class SalleExisteDejaException extends Exception {
    public SalleExisteDejaException(String errorMessage) {
        super(errorMessage);
    }
}
