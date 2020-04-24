package fr.esgi.DDDProject.model.salle;

import fr.esgi.DDDProject.model.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class SalleId extends ValueObject {

    private final UUID id;

    public SalleId(){
        this.id = this.genererUUID();
    }

    public UUID getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalleId salle = (SalleId) o;
        return Objects.equals(id, salle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
