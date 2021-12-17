package com.bl.hms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorRepo {

    private List<Doctor> doctorList = new ArrayList();

    void addMethod(Doctor dt)
    {
        doctorList.add(dt);
    }
    

    List getDoctorList()
    {
        return doctorList;
    }

    public boolean isDoctorAvailable(String userEnteredId) {

        for ( Doctor doctor : doctorList ){
            if ( doctor.id.equals(userEnteredId) ){
                return true;
            }
        }
        return false;
    }
}
