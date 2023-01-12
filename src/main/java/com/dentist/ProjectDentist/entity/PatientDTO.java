package com.dentist.ProjectDentist.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class PatientDTO {

    private Integer id;
    private String firsName;
    private String lastName;
    private String dni;
    private Date dataOfAdmission;
    private Address address;

    private Set<Turn> turns = new HashSet<>();
}
