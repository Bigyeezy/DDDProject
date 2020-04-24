package fr.esgi.DDDProject.infrastructure.entretien;

public class EntretienExisteDejaExecption extends  Exception {
	
	private static final long serialVersionUID = 1L;
	
    public EntretienExisteDejaExecption(final String errorMessage) {
        super(errorMessage);
    }
}
