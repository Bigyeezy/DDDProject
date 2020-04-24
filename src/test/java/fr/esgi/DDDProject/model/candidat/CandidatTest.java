package fr.esgi.DDDProject.model.candidat;

import fr.esgi.DDDProject.infrastructure.candidat.InvalideNomreAnneeExperienceException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CandidatTest {


    @Test
    public void shouldThrowWhenNombreAnneeExperienceIsNegatif() {
        // Given
        List<String> typeProfil = new ArrayList<>();

        // Then
        assertThatThrownBy(() -> new Candidat("Billy", "Jean", "test@gmail.fr","",  -1, typeProfil))
                .isInstanceOf(InvalideNomreAnneeExperienceException.class);
    }

    @Test
    public void shouldCreateCandidatIsOk() throws InvalideNomreAnneeExperienceException {
        // Given
        List<String> typeProfil = new ArrayList<>();
        Candidat candidat = new Candidat("Billy", "Jean", "test@gmail.fr", "", 10, typeProfil);

        // Then
        assertThat(candidat).isNotNull();
    }

}
