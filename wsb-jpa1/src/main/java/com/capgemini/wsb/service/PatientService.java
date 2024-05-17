package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import java.util.List;
import java.util.Optional;
import com.capgemini.wsb.dto.VisitTO;

public interface PatientService {
    List<PatientTO> getAllPatients();
    Optional<PatientTO> getPatientById(Long id);
    PatientTO savePatient(PatientTO patientTO);
    void deletePatient(Long id);
    // New method to get all visits by patient ID
    List<VisitTO> getAllVisitsByPatientId(Long patientId);
}
