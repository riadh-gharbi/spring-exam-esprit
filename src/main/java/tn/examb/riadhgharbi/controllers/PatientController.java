package tn.examb.riadhgharbi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.examb.riadhgharbi.entities.Patient;
import tn.examb.riadhgharbi.services.IPatientService;

import java.util.Set;

@RestController
@RequestMapping("/Patient")
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService PatientService;

    @PostMapping
    public Patient add(@RequestBody Patient c)
    {
        PatientService.add(c);
        return c;
    }

    @GetMapping
    public Set<Patient> findAll()
    {
        return PatientService.getAll();
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable("id") Long id)
    {
        return PatientService.getById(id);
    }

    @PutMapping
    public Patient update(@RequestBody Patient c)
    {
        return PatientService.update(c);
    }

    @DeleteMapping
    public void delete(@RequestBody Patient c)
    {
        PatientService.delete(c.getIdPatient());
    }
}

