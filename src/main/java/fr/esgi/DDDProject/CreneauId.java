package fr.esgi.DDDProject;

import java.util.UUID;

public class CreneauId extends ValueObject {

    private final UUID id;

    public CreneauId(){
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
