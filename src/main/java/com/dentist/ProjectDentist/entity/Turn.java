package com.dentist.ProjectDentist.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "turns")
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "dentist_id")
    @JsonIgnoreProperties(value = {"hibernateInitializer", "handler"})
    private Dentist dentist;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    @JsonIgnoreProperties(value = {"hibernateInitializer", "handler"})
    private Patient patient;

    @Column
    private Date date;

    public Turn() {
    }

    public Turn(Dentist dentist, Date date, Patient patient) {
        this.dentist = dentist;
        this.date = date;
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dentist getDentist() {
        return dentist;
    }

    @Override
    public String toString() {
        return "Turn{" +
                "id=" + id +
                ", dentist=" + dentist +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }


}
