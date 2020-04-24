package fr.esgi.DDDProject.infrastructure.recruteur;

public class RecruteurNExistePas extends Exception {
    public RecruteurNExistePas(String errorMessage) {
        super(errorMessage);
    }

}
