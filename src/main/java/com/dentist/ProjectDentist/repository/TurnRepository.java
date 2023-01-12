package com.dentist.ProjectDentist.repository;

import com.dentist.ProjectDentist.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Integer> {
}
