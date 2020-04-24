package fr.esgi.DDDProject.infrastructure.recruteur;

public class RecretueurExisteDejaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public RecretueurExisteDejaException(final String errorMessage) {
        super(errorMessage);
    }

}
