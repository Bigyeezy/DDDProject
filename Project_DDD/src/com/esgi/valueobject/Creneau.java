package com.esgi.valueobject;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Creneau {
    private final LocalDate date;
    private final LocalDateTime heureDebut;
    private LocalDateTime heureFin;

    public Creneau(final LocalDateTime heureDebut, final Long duree) {
        this.date = LocalDate.now();
        this.heureDebut = heureDebut;
        this.heureFin = heureDebut.plusMinutes(duree);
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDateTime getHeureDebut() {
        return heureDebut;
    }

    public LocalDateTime getHeureFin() {
        return heureFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Creneau creneau = (Creneau) o;

        if (date != null ? !date.equals(creneau.date) : creneau.date != null) return false;
        if (heureDebut != null ? !heureDebut.equals(creneau.heureDebut) : creneau.heureDebut != null) return false;
        return heureFin != null ? heureFin.equals(creneau.heureFin) : creneau.heureFin == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (heureDebut != null ? heureDebut.hashCode() : 0);
        result = 31 * result + (heureFin != null ? heureFin.hashCode() : 0);
        return result;
    }
}
