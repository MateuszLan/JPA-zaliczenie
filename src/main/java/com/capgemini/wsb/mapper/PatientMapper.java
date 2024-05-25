package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import java.util.stream.Collectors;

public final class PatientMapper
{

    public static PatientTO mapToTO(final PatientEntity patientEntity)
    {
        if (patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setAddressTO( AddressMapper.mapToTO(patientEntity.getAddressEntity()) );
        patientTO.setVisitTOs(patientEntity.getVisitEntities().stream().map(VisitMapper::mapToTO).collect(Collectors.toList()));
        patientTO.setTreatmentStatus(patientEntity.isTreatmentStatus());

        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO)
    {
        if(patientTO == null)
        {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setAddressEntity( AddressMapper.mapToEntity(patientTO.getAddressTO()) );
        patientEntity.setVisitEntities(patientTO.getVisitTOs().stream().map(VisitMapper::mapToEntity).collect(Collectors.toList()));
        patientEntity.setTreatmentStatus(patientTO.isTreatmentStatus());

        return patientEntity;
    }
}
