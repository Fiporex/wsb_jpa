package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientRepository;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import java.util.Optional;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    private PatientEntity patient;

    @BeforeEach
    void setUp() {
        patient = new PatientEntity();
        patient.setId(1L);
        patient.setFirstName("Michael");
        patient.setLastName("Brown");
        patient.setTelephoneNumber("123456789");
        patient.setEmail("michael.brown@example.com");
        patient.setPatientNumber("P001");
        patient.setDateOfBirth(LocalDate.of(1980, 5, 20));
    }

    @Test
    void testDeletePatient() {
        patientService.deletePatient(1L);
        verify(patientRepository, times(1)).deleteById(1L);
        // Additional assertions for cascading delete and doctors not being deleted can be added
    }

    @Test
    void testGetPatientById() {
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        Optional<PatientTO> retrievedPatient = patientService.getPatientById(1L);
        assertTrue(retrievedPatient.isPresent());
        assertEquals(1L, retrievedPatient.get().getId());
        assertEquals("Michael", retrievedPatient.get().getFirstName());

        verify(patientRepository, times(1)).findById(1L);
    }
}