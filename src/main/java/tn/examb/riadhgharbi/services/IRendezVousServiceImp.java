package tn.examb.riadhgharbi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.examb.riadhgharbi.entities.*;
import tn.examb.riadhgharbi.repositories.CliniqueRepository;
import tn.examb.riadhgharbi.repositories.MedecinRepository;
import tn.examb.riadhgharbi.repositories.PatientRepository;
import tn.examb.riadhgharbi.repositories.RendezVousRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IRendezVousServiceImp implements IRendezVousService{

    private final RendezVousRepository rendezVousRepository;
    private final MedecinRepository medecinRepository;
    private final PatientRepository patientRepository;
    private final CliniqueRepository cliniqueRepository;

    @Override
    public void add(RendezVous c) {
        rendezVousRepository.save(c);
    }

    @Override
    public RendezVous update(RendezVous c) {
        return rendezVousRepository.save(c);
    }

    @Override
    public Set<RendezVous> getAll() {
        return rendezVousRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public RendezVous getById(Long id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        rendezVousRepository.deleteById(id);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Medecin m = medecinRepository.findById(idMedecin).orElse(null);
        Patient p = patientRepository.findById(idPatient).orElse(null);
        Assert.notNull(m,"pas medecin trouvé");
        Assert.notNull(p,"pas patient trouvé");
        rdv.setPatient(p);
        rdv.setMedecin(m);
        rendezVousRepository.save(rdv);

    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        Clinique c = cliniqueRepository.findById(idClinique).orElse(null);
        Assert.notNull(c,"clinique not found");
        return rendezVousRepository.findAll().stream().filter(rendezVous -> rendezVous.getMedecin().getSpecialite().equals(specialite)
        && rendezVous.getMedecin().getCliniques().contains(c)).collect(Collectors.toList());
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        Medecin m =medecinRepository.findById(idMedecin).orElse(null);
        Assert.notNull(m,"medecin not found");
        return (int)rendezVousRepository.findAll().stream().filter(rendezVous -> rendezVous.getMedecin().getIdMedecin().equals(m.getIdMedecin()))
                .count();
    }

    @Scheduled(fixedRate = 30000)
    public void retrieveRendezVous()
    {
        rendezVousRepository.findAll().stream().filter(
                rendezVous -> rendezVous.getDateRDV().isAfter(LocalDate.of(2021,01,01))
        ).forEach(rendezVous ->
                        System.out.println("La liste des RendezVous :" + rendezVous.getDateRDV() +
                                " Medecin:" + rendezVous.getMedecin().getNomMedecin() +
                                " Patient:" + rendezVous.getPatient().getNomPatient())
                );

    }
}
