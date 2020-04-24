package fr.esgi.DDDProject.infrastructure.entretien;

public class EntretienExisteDejaExecption extends  Exception {
    public EntretienExisteDejaExecption(String errorMessage) {
        super(errorMessage);
    }
}
