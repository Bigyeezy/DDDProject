package fr.esgi.DDDProject.infrastructure.salle;

public class EtageNegatifException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public EtageNegatifException(final String errorMessage) {
        super(errorMessage);
    }

}
