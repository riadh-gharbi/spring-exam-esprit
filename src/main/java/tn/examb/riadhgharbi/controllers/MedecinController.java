package tn.examb.riadhgharbi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.examb.riadhgharbi.entities.Medecin;
import tn.examb.riadhgharbi.services.IMedecinService;

import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/Medecin")
@RequiredArgsConstructor
public class MedecinController {

    private final IMedecinService MedecinService;

    @PostMapping
    public Medecin add(@RequestBody Medecin c)
    {
        MedecinService.add(c);
        return c;
    }

    @GetMapping
    public Set<Medecin> findAll()
    {
        return MedecinService.getAll();
    }

    @GetMapping("/{id}")
    public Medecin findById(@PathVariable("id") Long id)
    {
        return MedecinService.getById(id);
    }

    @PutMapping
    public Medecin update(@RequestBody Medecin c)
    {
        return MedecinService.update(c);
    }

    @DeleteMapping
    public void delete(@RequestBody Medecin c)
    {
        MedecinService.delete(c.getIdMedecin());
    }

    @PostMapping("/{id}")
    public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin, @PathVariable("id") Long cliniqueId)
    {
        return MedecinService.addMedecinAndAssignToClinique(medecin,cliniqueId);
    }
    @GetMapping("/{idMedecin}/{startDate}/{endDate}")
    public int getRevenuMedecin(@PathVariable("idMedecin") Long idMedecin,
                                @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate)
    {
        return MedecinService.getRevenuMedecin(idMedecin,startDate,endDate);
    }
}

