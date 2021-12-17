package com.bl.hms;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public int ShowMainMenu() {
        System.out.println("Hospital Management System");
        System.out.println("1.Add Doctor \n2.Update Doctor \n3.Delete Doctor" +
                "\n4.Print All Doctor \n5.Add Patient" +
                "\n6.Update Patient \n7.Delete Patient \n8.Print All Patient");

        System.out.println("9.Add Appointment\n 10.Update Appointment\n 11.Delete Appointment\n " +
                        "12.Print All Appointment \n13.Exit");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Your Option :");
        int option = scanner.nextInt();

        return option;
    }

    public void printAllDoctor(List doctorList) {
        for (int i = 0; i < doctorList.size(); i++) {
            System.out.println(doctorList.get(i));
        }
    }

    public void printAllPatient(List patientlist) {
        for (int i = 0; i < patientlist.size(); i++) {
            System.out.println(patientlist.get(i));
        }
    }
    public void printAllAppointment(List appointmentlist) {
        for (int i = 0; i < appointmentlist.size(); i++) {
            System.out.println(appointmentlist.get(i));
        }
    }
}
