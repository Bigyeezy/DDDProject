package fr.esgi.DDDProject;

import static org.assertj.core.api.Assertions.assertThat;
import fr.esgi.DDDProject.valueobject.Creneau;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import fr.esgi.DDDProject.valueobject.exception.ExceptionManager;
import org.junit.Test;

import java.time.LocalDateTime;

public class CreneauTest {


    @Test
    public void shouldCreateCreneauWhenIsOk() throws ExceptionManager {
        // Given
        Creneau creneau = new Creneau(LocalDateTime.now(), 5L);

        // Then
       assertThat(creneau.getHeureFin()).isAfter(creneau.getHeureDebut());
    }

    @Test
    public void shouldCreateCreneauWhenIsNull() {
        // Given

        // Then
        assertThatThrownBy(() -> new Creneau(null, 5L))
                .isInstanceOf(NullPointerException.class);
    }

}
