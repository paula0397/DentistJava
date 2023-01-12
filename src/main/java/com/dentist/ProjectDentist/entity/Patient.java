package com.dentist.ProjectDentist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;


    @Column
    private String dni;

    @Column
    private Date dataOfAdmission;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


    @JsonIgnore
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Turn> turns = new HashSet<>();

    public Patient() {
    }

    public Patient(String firstName, String lastName, String dni, Date dataOfAdmission, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.dataOfAdmission = dataOfAdmission;
        this.address = address;
    }

    public Patient(Integer id, String firstName, String lastName, String dni, Date dataOfAdmission, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.dataOfAdmission = dataOfAdmission;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getDataOfAdmission() {
        return dataOfAdmission;
    }

    public void setDataOfAdmission(Date dataOfAdmission) {
        this.dataOfAdmission = dataOfAdmission;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", dataOfAdmission=" + dataOfAdmission +
                ", address=" + address +
                '}';
    }
}
