package com.bl.hms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PatientRepo {
    public static PatientRepo instance;
    Set<Patient> patientSet = new HashSet<>();

    public static synchronized PatientRepo getInstance(){
        if( instance == null ){
            instance = new PatientRepo();
        }
        return instance;
    }
    void addPatient(Patient p)
    {
        patientSet.add(p);
    }

    Set<Patient> getPatientSet()
    {
        return patientSet;
    }

    public boolean isPatientAvailable(String patientId){

        /*for (int i = 0; i < patientSet.size(); i++ ){
            if( patientSet.get(i).patientId.equals(doctorId)){
                return true;
            }
        }*/

        for ( Patient patient : patientSet ) {
            if( patient.patientId.equals(patientId)){
                return true;
            }
        }

        return false;
    }
    public Patient getPatient(String id){

        /*for (int i = 0; i <= getPatientSet().size(); i++) {
            if ( patientSet.get(i).patientId.equals(id) ) {
                return patientSet.get(i);
            }

        }*/

        for ( Patient patient : patientSet ) {
            if( patient.patientId.equals(id)){
                return patient;
            }
        }

        return null;
    }
    public void remove(Patient patient){
        patientSet.remove(patient);
    }

}

