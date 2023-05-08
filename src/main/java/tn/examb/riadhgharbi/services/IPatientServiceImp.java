package tn.examb.riadhgharbi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.examb.riadhgharbi.entities.Patient;
import tn.examb.riadhgharbi.repositories.PatientRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IPatientServiceImp implements IPatientService{

    private final PatientRepository patientRepository;

    @Override
    public void add(Patient c) {
        patientRepository.save(c);
    }

    @Override
    public Patient update(Patient c) {
        return patientRepository.save(c);
    }

    @Override
    public Set<Patient> getAll() {
        return patientRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Patient getById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
