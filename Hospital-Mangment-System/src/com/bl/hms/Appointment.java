package com.bl.hms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Appointment {

    String patientId, appointmentId, appointmentDate, doctorId;
    long roomNumber;

    @Override
    public boolean equals(Object o){
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass()) return false;
        Appointment appointment = (Appointment) o;
        return Objects.equals(appointmentId, appointment.appointmentId);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode( appointmentId );
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patientId='" + patientId + '\'' +
                ", appointmentId='" + appointmentId + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", roomNumber=" + roomNumber +
                '}';
    }
}

