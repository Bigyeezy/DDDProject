package fr.esgi.DDDProject.model.entretien;

import fr.esgi.DDDProject.model.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class EntretienId extends ValueObject {

    private final UUID id;

    public EntretienId(){
        this.id = this.genererUUID();
    }

    public UUID getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntretienId that = (EntretienId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
