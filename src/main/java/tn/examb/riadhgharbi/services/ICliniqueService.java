package tn.examb.riadhgharbi.services;

import tn.examb.riadhgharbi.entities.Clinique;

import java.util.Set;

public interface ICliniqueService {

    void add(Clinique c);
    Clinique update(Clinique c);
    Set<Clinique> getAll();

    Clinique getById(Long id);

    void delete(Long id);
}
