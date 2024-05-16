package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(nullable = false)
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalTreatmentEntity> treatments;

    public VisitEntity() {
        treatments = new ArrayList<>();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    // Relationship: Many-to-One, Bidirectional from child (Visit) to parent (Doctor)
    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public List<MedicalTreatmentEntity> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<MedicalTreatmentEntity> treatments) {
        this.treatments = treatments;
    }

    public void addTreatment(MedicalTreatmentEntity treatment) {
        if (this.treatments == null) {
            this.treatments = new ArrayList<>();
        }
        this.treatments.add(treatment);
        treatment.setVisit(this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}