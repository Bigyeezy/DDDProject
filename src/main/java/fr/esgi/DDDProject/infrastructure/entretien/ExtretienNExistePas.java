package fr.esgi.DDDProject.infrastructure.entretien;

public class ExtretienNExistePas extends Exception{
	
	private static final long serialVersionUID = 1L;
	
    public ExtretienNExistePas(final String errorMessage) {
        super(errorMessage);
    }

}
