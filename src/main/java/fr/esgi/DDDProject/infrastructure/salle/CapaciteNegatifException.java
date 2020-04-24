package fr.esgi.DDDProject.infrastructure.salle;

public class CapaciteNegatifException extends Exception {
    public CapaciteNegatifException(String errorMessage) {
        super(errorMessage);
    }

}
