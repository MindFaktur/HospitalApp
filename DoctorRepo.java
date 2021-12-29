package com.bl.hms;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepo {
    public static DoctorRepo instance;
    private List <Doctor>doctorList = new ArrayList();
    DoctorRepo(){

    }

    public static DoctorRepo getinstance(){
        if(instance == null){
            instance = new DoctorRepo();
        }
        return instance;
    }

    void addMethod(Doctor dt)
    {
        doctorList.add(dt);
    }

    List getDoctorList()
    {
        return doctorList;
    }

    public boolean isDoctorAvailable(String id) {
        for (int i = 0; i <= doctorList.size(); i++) {
            if (doctorList.get(i).id.equals(id)) {
                return true;
            }
        }
        return false;
    }
    public Doctor getDoctor(String id){
        for (int i = 0; i <= doctorList.size(); i++) {
            if (doctorList.get(i).id.equals(id)) {
             return doctorList.get(i);
            }

        }
        return null;
    }
    public void remove(Doctor doctor){
        doctorList.remove(doctor);
    }



}

