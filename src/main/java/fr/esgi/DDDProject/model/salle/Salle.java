package fr.esgi.DDDProject.model.salle;

import java.time.LocalDateTime;
import java.util.Map;

public class Salle {

    private final String nom;
    private final Integer etage;
    private final Integer capacite;
    private final Map<LocalDateTime, Boolean> disponibilites;

    public Salle(String nom, Integer etage, Integer capacite, Map<LocalDateTime, Boolean> disponibilites) {
        this.nom = nom;
        this.etage = etage;
        this.capacite = capacite;
        this.disponibilites = disponibilites;
    }

    public String getNom() {
        return nom;
    }

    public Integer getEtage() {
        return etage;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public Map<LocalDateTime, Boolean> getDisponibilites() {
        return disponibilites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salle salle = (Salle) o;

        if (nom != null ? !nom.equals(salle.nom) : salle.nom != null) return false;
        if (etage != null ? !etage.equals(salle.etage) : salle.etage != null) return false;
        if (capacite != null ? !capacite.equals(salle.capacite) : salle.capacite != null) return false;
        return disponibilites != null ? disponibilites.equals(salle.disponibilites) : salle.disponibilites == null;
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (etage != null ? etage.hashCode() : 0);
        result = 31 * result + (capacite != null ? capacite.hashCode() : 0);
        result = 31 * result + (disponibilites != null ? disponibilites.hashCode() : 0);
        return result;
    }
}
