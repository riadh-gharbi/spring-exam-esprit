package tn.examb.riadhgharbi.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Clinique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClinique;

    private String nomClinique;

    private String adresse;

    private int telephone;

    @ManyToMany
    @JoinTable(name = "clinique_medecins",
            joinColumns = @JoinColumn(name = "clinique_id_clinique"),
            inverseJoinColumns = @JoinColumn(name = "medecins_id"))
    private Set<Medecin> medecins = new LinkedHashSet<>();

    public Set<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(Set<Medecin> medecins) {
        this.medecins = medecins;
    }

    public Long getIdClinique() {
        return idClinique;
    }

    public void setIdClinique(Long idClinique) {
        this.idClinique = idClinique;
    }

    public String getNomClinique() {
        return nomClinique;
    }

    public void setNomClinique(String nomClinique) {
        this.nomClinique = nomClinique;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
