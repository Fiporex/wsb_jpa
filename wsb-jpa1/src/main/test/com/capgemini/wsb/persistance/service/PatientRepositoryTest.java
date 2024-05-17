package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testFindPatientsByLastName() {
        List<PatientEntity> patients = patientRepository.findPatientsByLastName("Brown");
        assertEquals(1, patients.size());
        assertEquals("Michael", patients.get(0).getFirstName());
    }
    @Test
    public void testFindPatientsWithMoreThanXVisits() {
        List<PatientEntity> patients = patientRepository.findPatientsWithMoreThanXVisits(1);
        assertTrue(patients.size() > 0);
    }

    @Test
    public void testFindPatientsBornBefore() {
        List<PatientEntity> patients = patientRepository.findPatientsBornBefore(LocalDate.of(1990, 1, 1));
        assertTrue(patients.size() > 0);
    }
}
