package com.dentist.ProjectDentist.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class DentistDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer registration;
    private Set<Turn> turns = new HashSet<>();

}
