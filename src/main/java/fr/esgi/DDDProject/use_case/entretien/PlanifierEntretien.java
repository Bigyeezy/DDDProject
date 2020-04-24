package fr.esgi.DDDProject.use_case.entretien;

import fr.esgi.DDDProject.infrastructure.candidat.InvalideNomreAnneeExperienceException;
import fr.esgi.DDDProject.infrastructure.entretien.*;
import fr.esgi.DDDProject.infrastructure.recruteur.RecruteurNExistePas;
import fr.esgi.DDDProject.infrastructure.salle.CapaciteNegatifException;
import fr.esgi.DDDProject.infrastructure.salle.EtageNegatifException;
import fr.esgi.DDDProject.infrastructure.salle.SalleNExistePasException;
import fr.esgi.DDDProject.model.candidat.Candidat;
import fr.esgi.DDDProject.model.entretien.Creneau;
import fr.esgi.DDDProject.model.entretien.Entretien;
import fr.esgi.DDDProject.model.entretien.Entretiens;
import fr.esgi.DDDProject.model.recruteur.Recruteur;
import fr.esgi.DDDProject.model.recruteur.Recruteurs;
import fr.esgi.DDDProject.model.salle.Salle;
import fr.esgi.DDDProject.model.salle.Salles;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The Class PlanifierEntretien.
 */
public class PlanifierEntretien {

    private final Entretiens fauxEntretienBD;
    
    private final Salles fauxSalleBD;
    
    private final Recruteurs fauxRecruteurBD;

    /**
     * Instantiates a new planifier entretien.
     *
     * @param fauxEntretienBD the faux entretien BD
     * @param fauxSalleBD the faux salle BD
     * @param fauxRecruteurBD the faux recruteur BD
     */
    public PlanifierEntretien(final Entretiens fauxEntretienBD, final Salles fauxSalleBD, final Recruteurs fauxRecruteurBD) {
        this.fauxEntretienBD = fauxEntretienBD;
        this.fauxSalleBD = fauxSalleBD;
        this.fauxRecruteurBD = fauxRecruteurBD;
    }

    /**
     * Planifier un entretien.
     *
     * @param candidat the candidat
     * @param date the date
     * @param duree the duree
     * @return the entretien
     * @throws DureeNegativeException the duree negative exception
     * @throws HeureEntretientHorsCrenauException the heure entretient hors crenau exception
     * @throws DureeMaximaleDepasseException the duree maximale depasse exception
     * @throws ParametreNullException the parametre null exception
     * @throws DateEnWeekendException the date en weekend exception
     * @throws CreneauException the creneau exception
     * @throws ExperienceCandidatSuperieurRecruteurException the experience candidat superieur recruteur exception
     * @throws InvalideNomreAnneeExperienceException the invalide nomre annee experience exception
     * @throws EtageNegatifException the etage negatif exception
     * @throws SalleNExistePasException the salle N existe pas exception
     * @throws RecruteurNExistePas the recruteur N existe pas
     * @throws EntretienExisteDejaExecption the entretien existe deja execption
     * @throws CapaciteNegatifException the capacite negatif exception
     */
    public Entretien planifierUnEntretien(final Candidat candidat, final LocalDateTime date, final Integer duree) throws DureeNegativeException, HeureEntretientHorsCrenauException, DureeMaximaleDepasseException, ParametreNullException, DateEnWeekendException, CreneauException, ExperienceCandidatSuperieurRecruteurException, InvalideNomreAnneeExperienceException, EtageNegatifException, SalleNExistePasException, RecruteurNExistePas, EntretienExisteDejaExecption, CapaciteNegatifException {
        final Creneau creneau = new Creneau(date, duree);

        final List<Salle> salles = fauxSalleBD.getAll();
        final Salle salle = salles.stream()
                .filter(uneSalle -> uneSalle.getDisponibilites().contains(date)).findFirst()
                .orElseGet(null);
        salle.reserver(date);
        fauxSalleBD.update(salle);

        final List<Recruteur> recruteurs = fauxRecruteurBD.getAll();
        final Recruteur recruteur = recruteurs.stream().filter(unRecruteur -> unRecruteur.getDisponibilites().contains(date)).findFirst().orElseGet(null);
        recruteur.reserver(date);
        fauxRecruteurBD.update(recruteur);

        final Entretien entretien = new Entretien(creneau, recruteur, candidat, salle.getSalleId());
        fauxEntretienBD.save(entretien);

        return entretien;
    }

}
