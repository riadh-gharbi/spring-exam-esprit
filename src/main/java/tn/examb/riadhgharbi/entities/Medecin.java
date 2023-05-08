package tn.examb.riadhgharbi.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;

    private String nomMedecin;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private int telephone;
    private int prixConsultation;

    @ManyToMany(mappedBy = "medecins")
    private Set<Clinique> cliniques = new LinkedHashSet<>();

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "medecin_id_medecin")
    private Set<RendezVous> rendezVouses = new LinkedHashSet<>();

    public Set<RendezVous> getRendezVouses() {
        return rendezVouses;
    }

    public void setRendezVouses(Set<RendezVous> rendezVouses) {
        this.rendezVouses = rendezVouses;
    }

    public Set<Clinique> getCliniques() {
        return cliniques;
    }

    public void setCliniques(Set<Clinique> cliniques) {
        this.cliniques = cliniques;
    }

    public Long getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Long idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getPrixConsultation() {
        return prixConsultation;
    }

    public void setPrixConsultation(int prixConsultation) {
        this.prixConsultation = prixConsultation;
    }
}
