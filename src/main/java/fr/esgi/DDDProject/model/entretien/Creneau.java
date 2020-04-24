package fr.esgi.DDDProject.model.entretien;


import fr.esgi.DDDProject.infrastructure.entretien.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.*;
public class Creneau {
    private final LocalDate date;
    private final LocalDateTime heureDebut;
    private final LocalDateTime heureFin;
    private final Integer duree;
    private final List<String> DAYS_AUTORIZED = Arrays.asList("SATURDAY", "FRIDAY");

    public Creneau(final LocalDateTime heureDebut, final Integer duree) throws DateEnWeekendException, HeureEntretientHorsCrenauException, DureeNegativeException, DureeMaximaleDepasseException, ParametreNullException {
        if (heureDebut == null || duree == null) {
            throw new ParametreNullException("La date et la durée sont obligatoires");
        }
        if (duree <= 0) {
            throw new DureeNegativeException("La durée ne peut pas être négative");
        }
        if (duree > 3) {
            throw new DureeMaximaleDepasseException("La durée ne peut pas être supérieur 3 heures.");
        }
        final String name = heureDebut.getDayOfWeek().name().toUpperCase();
        if (DAYS_AUTORIZED.contains(name)) {
            throw new DateEnWeekendException("La date doit être dans la semaine");
        }
        this.date = LocalDate.now();
        this.heureDebut = heureDebut;
        this.duree = duree;
        this.heureFin = heureDebut.plusHours(duree);

        if (heureDebut.getHour() < 18 || this.heureFin.getHour() > 21) {
            throw new HeureEntretientHorsCrenauException("Le créneau doit être entre 18h et 21h.");
        }
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

    public Integer getDuree() {
        return duree;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Creneau creneau = (Creneau) o;

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
