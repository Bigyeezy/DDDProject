package fr.esgi.DDDProject.model;

import java.util.UUID;

public abstract class ValueObject {

    protected UUID genererUUID() {
        return UUID.randomUUID();
    }
}
