package com.bl.hms;

import java.util.ArrayList;
import java.util.List;

public class PatientRepo {

    List<Patient> patientList = new ArrayList();

    void addPatient(Patient p)
    {
        patientList.add(p);
    }

    List getPatientList()
    {
        return  patientList;
    }

    public boolean isPatientAvailable(String userEnteredId) {

        for ( Patient patient : patientList ){
            if ( patient.patientId.equals(userEnteredId) ){
                return true;
            }
        }
        return false;
    }
}
