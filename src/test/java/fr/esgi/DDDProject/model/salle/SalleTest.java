package fr.esgi.DDDProject.model.salle;

import fr.esgi.DDDProject.infrastructure.candidat.InvalideNomreAnneeExperienceException;
import fr.esgi.DDDProject.infrastructure.salle.CapaciteNegatifException;
import fr.esgi.DDDProject.infrastructure.salle.EtageNegatifException;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SalleTest {

    @Test
    public void shouldThrowWhenEtageIsNegatif() throws EtageNegatifException {
        // Given
        final List<LocalDate> disponibilites = Arrays.asList(
                LocalDate.of(2020, 4, 23),
                LocalDate.of(2020, 4, 24),
                LocalDate.of(2020, 4, 25));

        // Then
        assertThatThrownBy(() -> new Salle("1", -1, 1, disponibilites))
                .isInstanceOf(EtageNegatifException.class);
    }

    @Test
    public void shouldCreateSalleWhenIsOk() throws EtageNegatifException, CapaciteNegatifException {
        // Given
        final List<LocalDate> disponibilites = Arrays.asList(
                LocalDate.of(2020, 4, 23),
                LocalDate.of(2020, 4, 24),
                LocalDate.of(2020, 4, 25));

        // Then
        assertThat(new Salle("1", 1, 1, disponibilites)).isNotNull();
    }

}
