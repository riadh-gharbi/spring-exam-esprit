package tn.examb.riadhgharbi.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRDV;

    private LocalDate dateRDV;

    private String remarque;

    public Long getIdRDV() {
        return idRDV;
    }

    public void setIdRDV(Long idRDV) {
        this.idRDV = idRDV;
    }

    public LocalDate getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(LocalDate dateRDV) {
        this.dateRDV = dateRDV;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id_patient")
    private Patient patient;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "medecin_id_medecin")
    private Medecin medecin;

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
