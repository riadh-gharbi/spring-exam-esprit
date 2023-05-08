package tn.examb.riadhgharbi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tn.examb.riadhgharbi.entities.Clinique;
import tn.examb.riadhgharbi.entities.Medecin;
import tn.examb.riadhgharbi.repositories.CliniqueRepository;
import tn.examb.riadhgharbi.repositories.MedecinRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IMedecinServiceImp implements IMedecinService{

    private final MedecinRepository medecinRepository;
    private final CliniqueRepository cliniqueRepository;
    @Override
    public void add(Medecin c) {
        medecinRepository.save(c);
    }

    @Override
    public Medecin update(Medecin c) {
        return medecinRepository.save(c);
    }

    @Override
    public Set<Medecin> getAll() {
        return medecinRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Medecin getById(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        medecinRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique c = cliniqueRepository.findById(cliniqueId).orElse(null);
        Assert.notNull(c,"Clinique not found");
        medecin.getCliniques().add(c);
        c.getMedecins().add(medecin);
        return medecinRepository.saveAndFlush(medecin);

    }

    @Override
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
        Medecin m = medecinRepository.findById(idMedecin).orElse(null);
        Assert.notNull(m,"medecin not found");
        return (int) m.getRendezVouses().stream().filter(rendezVous ->

                rendezVous.getDateRDV().isAfter(LocalDate.of(startDate.getYear()+1900,startDate.getMonth()+1,startDate.getDate())) &&
                        rendezVous.getDateRDV().isBefore(LocalDate.of(endDate.getYear()+1900,endDate.getMonth()+1,endDate.getDate()))
        ).count() * m.getPrixConsultation();
    }


}
