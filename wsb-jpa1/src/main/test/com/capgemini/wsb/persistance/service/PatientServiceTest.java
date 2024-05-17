package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.PatientRepository;
import com.capgemini.wsb.persistence.dao.VisitRepository;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private VisitRepository visitRepository;

    @Mock
    private PatientMapper patientMapper;

    @Mock
    private VisitMapper visitMapper;

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

    @Test
    void testGetAllVisitsByPatientId() {
        VisitEntity visit1 = new VisitEntity();
        visit1.setId(1L);
        VisitEntity visit2 = new VisitEntity();
        visit2.setId(2L);
        List<VisitEntity> visits = Arrays.asList(visit1, visit2);

        when(visitRepository.findAllByPatientId(1L)).thenReturn(visits);
        when(visitMapper.toTO(visit1)).thenReturn(new VisitTO());
        when(visitMapper.toTO(visit2)).thenReturn(new VisitTO());

        List<VisitTO> result = patientService.getAllVisitsByPatientId(1L);
        assertEquals(2, result.size());
    }
}
