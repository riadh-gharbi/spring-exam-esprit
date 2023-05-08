package tn.examb.riadhgharbi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.examb.riadhgharbi.entities.RendezVous;
import tn.examb.riadhgharbi.entities.Specialite;
import tn.examb.riadhgharbi.services.IRendezVousService;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/RendezVous")
@RequiredArgsConstructor
public class RendezVousController {

    private final IRendezVousService RendezVousService;

    @PostMapping
    public RendezVous add(@RequestBody RendezVous c)
    {
        RendezVousService.add(c);
        return c;
    }

    @GetMapping
    public Set<RendezVous> findAll()
    {
        return RendezVousService.getAll();
    }

    @GetMapping("/{id}")
    public RendezVous findById(@PathVariable("id") Long id)
    {
        return RendezVousService.getById(id);
    }

    @PutMapping
    public RendezVous update(@RequestBody RendezVous c)
    {
        return RendezVousService.update(c);
    }

    @DeleteMapping
    public void delete(@RequestBody RendezVous c)
    {
        RendezVousService.delete(c.getIdRDV());
    }

    @PostMapping("/{idMed}/{idPat}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv, @PathVariable("idMed") Long idMedecin,
                                             @PathVariable("idPat") Long idPatient)
    {
        RendezVousService.addRDVAndAssignMedAndPatient(rdv,idMedecin,idPatient);
    }

    @GetMapping("/byspec/{id}/{spec}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable("id") Long idClinique,
                                                                 @PathVariable("spec") String specialite)
    {
        return RendezVousService.getRendezVousByCliniqueAndSpecialite(idClinique,Specialite.valueOf(specialite));
    }

    @GetMapping("/med/{id}")
    public int getNbrRendezVousMedecin(@PathVariable("id") Long idMedecin){
        return  RendezVousService.getNbrRendezVousMedecin(idMedecin);
    }




}
