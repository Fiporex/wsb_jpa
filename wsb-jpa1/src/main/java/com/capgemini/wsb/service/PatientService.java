package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<PatientTO> getAllPatients();
    Optional<PatientTO> getPatientById(Long id);
    PatientTO savePatient(PatientTO patientTO);
    void deletePatient(Long id);
}
