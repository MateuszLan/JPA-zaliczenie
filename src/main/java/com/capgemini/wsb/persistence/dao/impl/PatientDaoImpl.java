package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    @Override
    public List<PatientEntity> findByLastName(String lastName){
        return entityManager.createQuery("select patient from PatientEntity patient where patient.lastName like :lastName", PatientEntity.class )
                            .setParameter("lastName", lastName)
                            .getResultList();
    }

    public List<PatientEntity> findAllPatientsWithMoreVisitsThan(int nVisits){
        return entityManager.createQuery("select patient from PatientEntity patient where size(patient.visitEntities) > :numVisits", PatientEntity.class)
                            .setParameter("numVisits", nVisits)
                            .getResultList();
    }

    public List<PatientEntity> findPatientsWithActiveTreatmentStatus(boolean status){
        return entityManager.createQuery("select patient from PatientEntity patient where patient.treatmentStatus = :status", PatientEntity.class)
                .setParameter("status", status)
                .getResultList();
    }
}
