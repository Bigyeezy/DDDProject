package fr.esgi.DDDProject.model.entretien;

import fr.esgi.DDDProject.model.ValueObject;

import java.util.UUID;

public class CreneauId extends ValueObject {

    private final UUID id;

    public CreneauId(){
        this.id = this.genererUUID();
    }

    public UUID getId() {
        return id;
    }
}
