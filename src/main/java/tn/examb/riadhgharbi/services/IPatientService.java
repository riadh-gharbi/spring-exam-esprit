package tn.examb.riadhgharbi.services;

import tn.examb.riadhgharbi.entities.Patient;

import java.util.Set;

public interface IPatientService {
    void add(Patient c);
    Patient update(Patient c);
    Set<Patient> getAll();

    Patient getById(Long id);

    void delete(Long id);
}
