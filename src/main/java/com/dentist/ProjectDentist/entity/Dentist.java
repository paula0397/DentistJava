package com.dentist.ProjectDentist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dentist")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String registration;

    @JsonIgnore
    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY) //relacion de dentista a turnos
    private Set<Turn> turns = new HashSet<>();

    public Dentist() {
    }

    public Dentist(String firstName, String lastName, String registration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
    }

    public Dentist(Integer id, String firstName, String lastName, String registration) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getRegistration() {return registration;}

    public void setRegistration(String registration) {this.registration = registration;}

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registration='" + registration + '\'' +
                '}';
    }
}
