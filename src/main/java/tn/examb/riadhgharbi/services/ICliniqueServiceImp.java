package tn.examb.riadhgharbi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.examb.riadhgharbi.entities.Clinique;
import tn.examb.riadhgharbi.repositories.CliniqueRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ICliniqueServiceImp implements ICliniqueService{

    private final CliniqueRepository cliniqueRepository;
    @Override
    public void add(Clinique c) {
        cliniqueRepository.save(c);
    }

    @Override
    public Clinique update(Clinique c) {
        return cliniqueRepository.save(c);
    }

    @Override
    public Set<Clinique> getAll() {
        return cliniqueRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Clinique getById(Long id) {
        return cliniqueRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        cliniqueRepository.deleteById(id);
    }
}
