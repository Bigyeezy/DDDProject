package fr.esgi.DDDProject.model.recruteur;

import fr.esgi.DDDProject.model.ValueObject;

import java.util.Objects;
import java.util.UUID;

public class RecruteurId extends ValueObject {

    private final UUID id;

    public RecruteurId(){
        this.id = this.genererUUID();
    }

    public UUID getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecruteurId recruteur = (RecruteurId) o;
        return Objects.equals(id, recruteur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
