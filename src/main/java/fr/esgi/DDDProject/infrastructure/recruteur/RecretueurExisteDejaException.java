package fr.esgi.DDDProject.infrastructure.recruteur;

public class RecretueurExisteDejaException extends Exception {
    public RecretueurExisteDejaException(String errorMessage) {
        super(errorMessage);
    }

}
