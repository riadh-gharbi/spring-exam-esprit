package tn.examb.riadhgharbi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.examb.riadhgharbi.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
