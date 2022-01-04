package com.bl.hms;

import javax.print.Doc;
import java.util.*;

public class DoctorRepo {
    public static DoctorRepo instance;
    private Set<Doctor> doctorSet = new HashSet<>();
    DoctorRepo(){

    }

    public static synchronized DoctorRepo getinstance(){
        if(instance == null){
            instance = new DoctorRepo();
        }
        return instance;
    }


    void addMethod(Doctor dt)
    {
        doctorSet.add(dt);
    }

    Set<Doctor> getDoctorSet()
    {
        return doctorSet;
    }

    public boolean isDoctorAvailable(String id) {

        /*for (int i = 0; i <= doctorSet.size(); i++) {
            if (doctorSet.get(i).id.equals(id)) {
                return true;
            }
        }*/

        for ( Doctor doctor : doctorSet ) {
            if ( doctor.id.equals(id) ){
                return true;
            }
        }
        return false;
    }

    public Doctor getDoctor(String id){

        /*for (int i = 0; i <= doctorSet.size(); i++) {
            if (doctorSet.get(i).id.equals(id)) {
             return doctorSet.get(i);
            }

        }*/

        for ( Doctor doctor : doctorSet ) {
            if ( doctor.id.equals(id) ){
                return doctor;
            }
        }

        return null;
    }

    public void remove(Doctor doctor){
        doctorSet.remove(doctor);
    }



}

