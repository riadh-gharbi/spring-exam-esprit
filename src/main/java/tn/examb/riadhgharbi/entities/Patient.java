package tn.examb.riadhgharbi.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    private String nomPatient;

    private int telephone;
    private Date dateNaissance;

    @OneToMany(mappedBy = "patient", orphanRemoval = true)
    private Set<RendezVous> rendezVouses = new LinkedHashSet<>();

    public Set<RendezVous> getRendezVouses() {
        return rendezVouses;
    }

    public void setRendezVouses(Set<RendezVous> rendezVouses) {
        this.rendezVouses = rendezVouses;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
