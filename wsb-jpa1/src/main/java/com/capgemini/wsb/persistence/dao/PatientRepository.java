package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    @Query("SELECT p FROM PatientEntity p WHERE p.dateOfBirth < :date")
    List<PatientEntity> findPatientsBornBefore(@Param("date") LocalDate date);
}
