package com.dentist.ProjectDentist.repository;

import com.dentist.ProjectDentist.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Integer> {

    @Query("from Dentist k where k.lastName like %:lastName%")
    Dentist dentistByLastName(String lastName);
}
