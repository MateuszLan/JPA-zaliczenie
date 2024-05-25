package com.capgemini.wsb.dto;


import java.io.Serializable;
import java.time.LocalDateTime;

public class VisitTO implements Serializable {
    private Long id;
    private String description;
    private LocalDateTime time;
    private MedicalTreatmentTO medicalTreatmentTO;
    private BasicDoctorTO basicDoctorTO;
    private BasicPatientTO basicPatientTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public MedicalTreatmentTO getMedicalTreatmentTO() {
        return medicalTreatmentTO;
    }

    public void setMedicalTreatmentTO(MedicalTreatmentTO medicalTreatmentTO) {
        this.medicalTreatmentTO = medicalTreatmentTO;
    }

    public BasicDoctorTO getBasicDoctorTO() {
        return basicDoctorTO;
    }

    public void setBasicDoctorTO(BasicDoctorTO basicDoctorTO) {
        this.basicDoctorTO = basicDoctorTO;
    }

    public BasicPatientTO getBasicPatientTO() {
        return basicPatientTO;
    }

    public void setBasicPatientTO(BasicPatientTO basicPatientTO) {
        this.basicPatientTO = basicPatientTO;
    }
}
