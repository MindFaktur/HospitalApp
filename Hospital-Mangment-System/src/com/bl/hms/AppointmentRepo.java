package com.bl.hms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppointmentRepo {
    private static AppointmentRepo instance;
    Set<Appointment> appointmentSet = new HashSet<>();
    UserInterface userInterface = UserInterface.getInstance();

    AppointmentRepo(){
    }
    public static synchronized AppointmentRepo getInstance(){
        if ( instance == null){
            instance = new AppointmentRepo();
        }
        return instance;
    }

    void addAppointment() {
        Appointment appointment = userInterface.getAppointment();
        appointmentSet.add(appointment);
    }

    Set<Appointment> getAppointmentSet() {
        return appointmentSet;
    }
    public Appointment getAppointmentById(String id) {

        /*for (int i = 0; i < appointmentSet.size(); i++) {
            if(appointmentSet.get(i).appointmentId.equals(id)){
                return appointmentSet.get(i);
            }
        }*/
        for ( Appointment appointment : appointmentSet ) {
            if ( appointment.appointmentId.equals(id) ){
                return appointment;
            }
        }

        return null;
    }

    public void remove(Appointment appointment) {
        appointmentSet.remove(appointment);
    }
}