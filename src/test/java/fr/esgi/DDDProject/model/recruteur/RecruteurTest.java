package fr.esgi.DDDProject.model.recruteur;

import fr.esgi.DDDProject.infrastructure.candidat.InvalideNomreAnneeExperienceException;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RecruteurTest {

    @Test
    public void shouldThrowWhenNombreAnneeExperienceIsNegatif() {
        // Given
        final List<LocalDate> disponibilites = Arrays.asList(
                LocalDate.of(2020, 4, 23),
                LocalDate.of(2020, 4, 24),
                LocalDate.of(2020, 4, 25));

        // Then
        assertThatThrownBy(() ->  new Recruteur("Billy", "Jean", "test@gmail.fr", -1, disponibilites))
                .isInstanceOf(InvalideNomreAnneeExperienceException.class);
    }

    @Test
    public void shouldCreateCandidatIsOk() throws InvalideNomreAnneeExperienceException {
        // Given
        final List<LocalDate> disponibilites = Arrays.asList(
                LocalDate.of(2020, 4, 23),
                LocalDate.of(2020, 4, 24),
                LocalDate.of(2020, 4, 25));
        Recruteur recruteur = new Recruteur("Billy", "Jean", "test@gmail.fr", 1, disponibilites);

        // Then
        assertThat(recruteur).isNotNull();
    }

}
