package fr.esgi.DDDProject.model.entretien;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import fr.esgi.DDDProject.infrastructure.entretien.*;
import org.junit.Test;

import java.time.LocalDateTime;

public class CreneauTest {


    @Test
    public void shouldCreateCreneauWhenIsOk() throws DureeNegativeException, HeureEntretientHorsCrenauException, DureeMaximaleDepasseException, ParametreNullException, DateEnWeekendException {
        // Given
        Creneau creneau = new Creneau(LocalDateTime.of(2020, 4, 23, 18, 56), 1);

        // Then
        assertThat(creneau.getHeureFin()).isAfter(creneau.getHeureDebut());
    }

    @Test
    public void shouldThrowExceptionWhenDateIsNull() {
        assertThatThrownBy(() -> new Creneau(null, 1))
                .isInstanceOf(ParametreNullException.class);
    }

    @Test
    public void shouldThrowExceptionWhenDureeIsMoreThan3Hours() {
        assertThatThrownBy(() -> new Creneau(LocalDateTime.of(2020, 4, 23, 15, 56), 5))
                .isInstanceOf(DureeMaximaleDepasseException.class);
    }

    @Test
    public void shouldThrowExceptionWhenDureeIsLessThan1Hour() {
        assertThatThrownBy(() -> new Creneau(LocalDateTime.of(2020, 4, 23, 15, 56), 0))
                .isInstanceOf(DureeNegativeException.class);
    }

    @Test
    public void shouldThrowExceptionWhenHeureDebutIsInTheWeekEnd() {
        assertThatThrownBy(() -> new Creneau(LocalDateTime.of(2020, 4, 25, 15, 56), 2))
                .isInstanceOf(DateEnWeekendException.class);
    }

}
