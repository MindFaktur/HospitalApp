package com.bl.hms;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRepo {

    List appointmentList = new ArrayList();

    void addAppointment(Appointment apt)
    {
        appointmentList.add(apt);
    }

    List getAppointmentList()
    {
        return appointmentList;
    }
}
