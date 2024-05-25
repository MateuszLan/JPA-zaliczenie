package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PatientDaoTest{

    @Autowired
    private PatientDao patientDao;

    @Test
    public void testFindPatientsByLastName() {
        int testPatientsListSize = patientDao.findByLastName("Nowak").size();
        assertEquals(testPatientsListSize, 2);
    }

    @Test
    public void testFindPatientsWithMoreVisitsThan() {
        int Visits = 1;
        // 1 pacjent
        List<PatientEntity> testListOfPatientsWithEnoughVisits = patientDao.findAllPatientsWithMoreVisitsThan(Visits);
        assertNotNull(testListOfPatientsWithEnoughVisits);
        assertTrue(testListOfPatientsWithEnoughVisits.get(0).getVisitEntities().size() > Visits);
    }

    @Test
    public void testFindPatientsWithActiveTreatmentStatus() {
        boolean bool1 = true;
        boolean bool2 = false;
        // 2 pacjentów
        int testListOfActiveTreatmentPatients = patientDao.findPatientsWithActiveTreatmentStatus(bool1).size();
        // 1 pacjent
        int testListOfNotActiveTreatmentPatients = patientDao.findPatientsWithActiveTreatmentStatus(bool2).size();
        assertEquals(testListOfActiveTreatmentPatients, 2);
        assertEquals(testListOfNotActiveTreatmentPatients, 1);

    }

}