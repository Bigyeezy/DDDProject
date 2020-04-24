package fr.esgi.DDDProject.infrastructure.recruteur;

public class RecruteurNExistePas extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public RecruteurNExistePas(final String errorMessage) {
        super(errorMessage);
    }

}
