package tn.examb.riadhgharbi.services;

import tn.examb.riadhgharbi.entities.Medecin;

import java.util.Date;
import java.util.Set;

public interface IMedecinService {
    void add(Medecin c);
    Medecin update(Medecin c);
    Set<Medecin> getAll();

    Medecin getById(Long id);

    void delete(Long id);

    Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId);

    int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate);
}
