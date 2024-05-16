package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class PatientMapper {

    public PatientTO toTO(PatientEntity entity) {
        if (entity == null) {
            return null;
        }

        PatientTO to = new PatientTO();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setTelephoneNumber(entity.getTelephoneNumber());
        to.setEmail(entity.getEmail());
        to.setPatientNumber(entity.getPatientNumber());
        to.setDateOfBirth(entity.getDateOfBirth());
        to.setVisits(entity.getVisits().stream().map(this::toVisitTO).collect(Collectors.toList()));
        return to;
    }

    public PatientEntity toEntity(PatientTO to) {
        if (to == null) {
            return null;
        }

        PatientEntity entity = new PatientEntity();
        entity.setId(to.getId());
        entity.setFirstName(to.getFirstName());
        entity.setLastName(to.getLastName());
        entity.setTelephoneNumber(to.getTelephoneNumber());
        entity.setEmail(to.getEmail());
        entity.setPatientNumber(to.getPatientNumber());
        entity.setDateOfBirth(to.getDateOfBirth());
        entity.setVisits(to.getVisits().stream().map(this::toVisitEntity).collect(Collectors.toList()));
        return entity;
    }

    private VisitTO toVisitTO(VisitEntity entity) {
        if (entity == null) {
            return null;
        }

        VisitTO to = new VisitTO();
        to.setId(entity.getId());
        to.setDescription(entity.getDescription());
        to.setTime(entity.getTime());
        to.setDoctor(toDoctorTO(entity.getDoctor()));
        to.setPatient(toTO(entity.getPatient()));
        return to;
    }

    private VisitEntity toVisitEntity(VisitTO to) {
        if (to == null) {
            return null;
        }

        VisitEntity entity = new VisitEntity();
        entity.setId(to.getId());
        entity.setDescription(to.getDescription());
        entity.setTime(to.getTime());
        entity.setDoctor(toDoctorEntity(to.getDoctor()));
        entity.setPatient(toEntity(to.getPatient()));
        return entity;
    }

    private DoctorTO toDoctorTO(DoctorEntity entity) {
        if (entity == null) {
            return null;
        }

        DoctorTO to = new DoctorTO();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setTelephoneNumber(entity.getTelephoneNumber());
        to.setEmail(entity.getEmail());
        to.setDoctorNumber(entity.getDoctorNumber());
        to.setSpecialization(entity.getSpecialization().toString());
        return to;
    }

    private DoctorEntity toDoctorEntity(DoctorTO to) {
        if (to == null) {
            return null;
        }

        DoctorEntity entity = new DoctorEntity();
        entity.setId(to.getId());
        entity.setFirstName(to.getFirstName());
        entity.setLastName(to.getLastName());
        entity.setTelephoneNumber(to.getTelephoneNumber());
        entity.setEmail(to.getEmail());
        entity.setDoctorNumber(to.getDoctorNumber());
        entity.setSpecialization(Specialization.valueOf(to.getSpecialization()));
        return entity;
    }
}