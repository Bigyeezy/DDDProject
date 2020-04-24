package fr.esgi.DDDProject.model.salle;

import fr.esgi.DDDProject.infrastructure.salle.EtageNegatifException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Salle {

    private final SalleId salleId;
    private String nom;
    private Integer etage;
    private Integer capacite;
    private List<LocalDate> disponibilites;

    public Salle(String nom, Integer etage, Integer capacite, List<LocalDate> disponibilites) throws EtageNegatifException {
        this.salleId = new SalleId();
        this.nom = nom;

        if(etage < 0 ) {
            throw new EtageNegatifException("Le numéro de l'étage n'est pas valide");
        }

        this.etage = etage;


        if(capacite < 0 ) {
            throw new EtageNegatifException("La capacité de la salle n'est pas valide");
        }

        this.capacite = capacite;
        this.disponibilites = disponibilites;

    }

    public boolean reserver(LocalDateTime date) {
        int index = this.disponibilites.indexOf(date);

        if (index == -1)
        {
            return false;
        }

        this.disponibilites.remove(index);
        return true;
    }

    public boolean liberer(LocalDate date) {
        int index = this.disponibilites.indexOf(date);

        if (index == -1)
        {
            this.disponibilites.add(date);
            return true;
        }

        return false;
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

    public List<LocalDate> getDisponibilites() {
        return disponibilites;
    }

    public SalleId getSalleId() {
        return salleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salle salle = (Salle) o;
        return salleId != null ? !salleId.equals(salle.salleId) : salle.salleId != null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salleId);
    }
}
