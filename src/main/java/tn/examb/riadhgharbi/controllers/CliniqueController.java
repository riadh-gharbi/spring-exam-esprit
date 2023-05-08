package tn.examb.riadhgharbi.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.examb.riadhgharbi.entities.Clinique;
import tn.examb.riadhgharbi.services.ICliniqueService;

import java.util.Set;

@RestController
@RequestMapping("/clinique")
@RequiredArgsConstructor
public class CliniqueController {

private final ICliniqueService cliniqueService;

    @PostMapping
    public Clinique addClinique(@RequestBody Clinique clinique)
    {
        cliniqueService.add(clinique);
        return clinique;
    }

    @GetMapping
    public Set<Clinique> findAll()
    {
        return cliniqueService.getAll();
    }

    @GetMapping("/{id}")
    public Clinique findById(@PathVariable("id") Long id)
    {
        return cliniqueService.getById(id);
    }

    @PutMapping
    public Clinique update(@RequestBody Clinique c)
    {
        return cliniqueService.update(c);
    }

    @DeleteMapping
    public void delete(@RequestBody Clinique c)
    {
        cliniqueService.delete(c.getIdClinique());
    }
}
