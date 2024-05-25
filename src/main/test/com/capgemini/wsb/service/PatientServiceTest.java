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
    public void testGetAllPatientVisitsByID(){
        PatientTO patientTO = patientService.findById(3L);
        List<VisitTO> visitTOs = patientService.getAllVisitsForPatient(3L);
        //2 wizyty
        assertFalse(patientTO.getVisitTOs().isEmpty());
        assertEquals(2, visitTOs.size());

    }

}