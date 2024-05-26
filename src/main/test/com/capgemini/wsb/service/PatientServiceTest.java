package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.*;
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
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private VisitService visitService;



    @Test
    public void testDeletePatientAndCheckVisitsAndDoctors() {
        // Given
        Long patientId = 1L;
        PatientTO patientTO = patientService.findById(patientId);
        assertNotNull(patientTO);
        patientService.removePatient(patientId);
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            patientService.findById(patientId);
        });
        assertEquals("Patient not found", thrown.getMessage());
    }

    @Test
    public void testFindPatientById() {
        // Given
        Long patientId = 3L;

        // When
        PatientTO patientTO = patientService.findById(patientId);

        // Then
        assertNotNull(patientTO);
        assertTrue(patientTO.isTreatmentStatus());
        assertNotNull(patientTO.getVisitTOs());
        //dwie wizyty
        assertEquals(2, patientTO.getVisitTOs().size());
    }





    @Test
    public void testGetAllPatientVisitsByID(){
        PatientTO patientTO = patientService.findById(3L);
        List<VisitTO> visitTOs = patientService.getAllVisitsForPatient(3L);
        //2 wizyty
        assertFalse(patientTO.getVisitTOs().isEmpty());
        assertEquals(2, visitTOs.size());

    }

}