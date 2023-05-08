package tn.examb.riadhgharbi.services;

import tn.examb.riadhgharbi.entities.RendezVous;
import tn.examb.riadhgharbi.entities.Specialite;

import java.util.List;
import java.util.Set;

public interface IRendezVousService {
    void add(RendezVous c);
    RendezVous update(RendezVous c);
    Set<RendezVous> getAll();

    RendezVous getById(Long id);

    void delete(Long id);

    void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient);

    List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);

    int getNbrRendezVousMedecin(Long idMedecin);
}
