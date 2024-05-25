package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "TIME", nullable = false)
	private LocalDateTime time;

	// relacja dwukierunkowa
	@ManyToOne()
	@JoinColumn(name = "DOCTOR_ID")
	private DoctorEntity doctorEntity;

	//relacja dwukierunkowa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID")
	private PatientEntity patientEntity;

	// relacja jednokierunkowa po stronie rodzica (VisitEntity)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private MedicalTreatmentEntity medicalTreatmentEntity;

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

	public DoctorEntity getDoctorEntity() {
		return doctorEntity;
	}

	public void setDoctorEntity(DoctorEntity doctorEntity) {
		this.doctorEntity = doctorEntity;
	}

	public PatientEntity getPatientEntity() {
		return patientEntity;
	}

	public void setPatientEntity(PatientEntity patientEntity) {
		this.patientEntity = patientEntity;
	}

	public MedicalTreatmentEntity getMedicalTreatmentEntity() {
		return medicalTreatmentEntity;
	}

	public void setMedicalTreatmentEntity(MedicalTreatmentEntity medicalTreatmentEntity) {
		this.medicalTreatmentEntity = medicalTreatmentEntity;
	}
}
