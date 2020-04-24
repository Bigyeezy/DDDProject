package fr.esgi.DDDProject.infrastructure.recruteur;

import fr.esgi.DDDProject.infrastructure.FauxRecruteurBD;
import fr.esgi.DDDProject.infrastructure.candidat.InvalideNomreAnneeExperienceException;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import fr.esgi.DDDProject.model.recruteur.RecruteurId;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FauxEntretienBDTest {

    private FauxRecruteurBD fauxRecruteurBD = new FauxRecruteurBD();

    @Test
    public void shouldGetAllWhenEntretienWhenIsOk() throws InvalideNomreAnneeExperienceException {
        // Then
        assertThat(fauxRecruteurBD.getAll()).isNotEmpty();
    }

    @Test
    public void shouldGetByIdWhenIsOk() throws InvalideNomreAnneeExperienceException {
        // Given
        final Recruteur recruteur = fauxRecruteurBD.getAll().get(0);

        // Then
        assertThat(fauxRecruteurBD.getById(recruteur.getRecruteurId())).isNotNull();
    }

    @Test
    public void shouldGetNullWhenRecruteurIdIsNotFound() {
        // Given
        final RecruteurId recruteurId = new RecruteurId();

        // Then
        assertThat(fauxRecruteurBD.getById(recruteurId)).isNull();
    }

    @Test
    public void shouldSaveRecruteurWhenIsOk() throws RecretueurExisteDejaException, InvalideNomreAnneeExperienceException {
        // Given
        final List<LocalDate> disponibilites = Arrays.asList(
                LocalDate.of(2020, 4, 23),
                LocalDate.of(2020, 4, 24),
                LocalDate.of(2020, 4, 25));

        final Recruteur recruteur = new Recruteur("Billy", "Jean", "test@gmail.fr", 3, disponibilites);

        // Then
        assertThat(fauxRecruteurBD.save(recruteur)).isNotNull();
    }

    @Test
    public void shouldThrowForSaveWhenRecruteurExist() throws InvalideNomreAnneeExperienceException {
        final Recruteur recruteur = fauxRecruteurBD.getAll().get(0);

        // Then
        assertThatThrownBy(() ->  fauxRecruteurBD.save(recruteur))
                .isInstanceOf(RecretueurExisteDejaException.class);
    }


    @Test
    public void shouldUpdateRecruteurWhenIsOk() throws RecruteurNExistePas , InvalideNomreAnneeExperienceException {
        // Given
        final Recruteur recruteur = fauxRecruteurBD.getAll().get(0);

        // Then
        assertThat(fauxRecruteurBD.update(recruteur)).isNotNull();
    }
    @Test
    public void shouldThrowForUpdateRecruteurWhenNotExist() throws InvalideNomreAnneeExperienceException {
        // Given
        final List<LocalDate> disponibilites = Arrays.asList(
                LocalDate.of(2020, 4, 23),
                LocalDate.of(2020, 4, 24),
                LocalDate.of(2020, 4, 25));

        final Recruteur recruteur = new Recruteur("Billy", "Jean", "test@gmail.fr", 3, disponibilites);


        // Then
        assertThatThrownBy(() ->  fauxRecruteurBD.update(recruteur))
                .isInstanceOf(RecruteurNExistePas.class);
    }
    
}
