package fr.esgi.DDDProject.model.entretien;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import fr.esgi.DDDProject.infrastructure.ExceptionManager;
import fr.esgi.DDDProject.model.entretien.Creneau;
import org.junit.Test;

import java.time.LocalDateTime;

public class CreneauTest {


    @Test
    public void shouldCreateCreneauWhenIsOk() throws ExceptionManager {
        // Given
        Creneau creneau = new Creneau(LocalDateTime.of(2020, 4, 23, 18, 56), 1);

        // Then
        assertThat(creneau.getHeureFin()).isAfter(creneau.getHeureDebut());
    }

    @Test
    public void shouldThrowExceptionWhenDateIsNull() {
        assertThatThrownBy(() -> new Creneau(null, 1))
                .isInstanceOf(ExceptionManager.class);
    }

    @Test
    public void shouldThrowExceptionWhenDureeIsMoreThan3Hours() {
        assertThatThrownBy(() -> new Creneau(LocalDateTime.of(2020, 4, 23, 15, 56), 5))
                .isInstanceOf(ExceptionManager.class);
    }

    @Test
    public void shouldThrowExceptionWhenDureeIsLessThan1Hour() {
        assertThatThrownBy(() -> new Creneau(LocalDateTime.of(2020, 4, 23, 15, 56), 0))
                .isInstanceOf(ExceptionManager.class);
    }

    @Test
    public void shouldThrowExceptionWhenHeureDebutIsInTheWeekEnd() {
        assertThatThrownBy(() -> new Creneau(LocalDateTime.of(2020, 4, 25, 15, 56), 2))
                .isInstanceOf(ExceptionManager.class);
    }

}
