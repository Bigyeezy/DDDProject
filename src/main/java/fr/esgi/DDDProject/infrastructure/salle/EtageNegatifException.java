package fr.esgi.DDDProject.infrastructure.salle;

public class EtageNegatifException extends Exception {
    public EtageNegatifException(String errorMessage) {
        super(errorMessage);
    }

}
