package com.capgemini.wsb.service.impl;


import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.PatientRepository;
import com.capgemini.wsb.persistence.dao.VisitRepository;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private VisitMapper visitMapper;

    @Override
    public List<PatientTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patientMapper::toTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PatientTO> getPatientById(Long id) {
        return patientRepository.findById(id)
                .map(patientMapper::toTO);
    }

    @Override
    public PatientTO savePatient(PatientTO patientTO) {
        PatientEntity entity = patientMapper.toEntity(patientTO);
        return patientMapper.toTO(patientRepository.save(entity));
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
    @Override
    public List<VisitTO> getAllVisitsByPatientId(Long patientId) {
        List<VisitEntity> visits = visitRepository.findAllByPatientId(patientId);
        return visits.stream()
                .map(visitMapper::toTO)
                .collect(Collectors.toList());
    }
}