package com.bl.hms;

import java.util.*;

public class Application {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        int option;
        UserInterface UI = UserInterface.getInstance();
        Application application = new Application();
        do{
            option = UI.mainMenu();
            application.handleUserSelection( option );
        }while ( option != Constants.MAINEXIT );
    }

    /*void handleUserSelection(int option)
    {
        UserInterface userInterface = new UserInterface();
        DoctorRepo doctorRepo = DoctorRepo.getinstance();
        PatientRepo patientRepo = PatientRepo.getInstance();
        AppointmentRepo appointmentRepo = AppointmentRepo.getInstance();
        switch (option)
        {
            case 1:
                addDoctor();
                break;
            case 2:
                System.out.println("Enter doctor Id to update the details of that doctor");
                String docId = scanner.nextLine();
                Doctor doctorExist = doctorRepo.getDoctor(docId);
                if ( doctorExist != null ){
                    userInterface.doctorDetailToUpdate(doctorExist);
                }else{
                    System.out.println("The entered doctor id does not exist");
                }
                break;
            case 3:
                System.out.println("Enter Doctor Id ");
                String id = scanner.nextLine();
                Doctor doctorRemove = doctorRepo.getDoctor(id);
                doctorRepo.remove(doctorRemove);
                break;
            case 4:
                Set<Doctor> setDoc = doctorRepo.getDoctorSet();
                userInterface.printAllDoctor(setDoc);
                break;
            case 5:
                addPatient();
                break;
            case 6:
                System.out.println("Enter patient Id to update the details of that patient");
                String patientId = scanner.nextLine();
                Patient patientExist = patientRepo.getPatient(patientId);
                if ( patientExist != null ){
                    userInterface.updatePatientDetail(patientExist);
                }else {
                    System.out.println("The entered patient id does not exist");
                }
                break;
            case 7:
                System.out.println("Enter Patient Id ");
                String patientid = scanner.nextLine();
                Patient patientRemove = patientRepo.getPatient(patientid);
                patientRepo.remove(patientRemove);
                break;
            case 8:
                Set<Patient> lstPatient = patientRepo.getPatientSet();
                userInterface.printAllPatient(lstPatient);
                break;
            case 9:
                addAppointment();
                break;
            case 10:
                System.out.println("Enter appointment id");
                String appointmentId = scanner.next();
                Appointment updateAppointment = appointmentRepo.getAppointmentById(appointmentId);
                if ( updateAppointment != null ){
                    userInterface.updateAppointmentDetails(updateAppointment);
                } else {
                    System.out.println("Enter correct id");
                }

                break;
            case 11:
                System.out.println("Enter Appointment Id ");
                String appId = scanner.nextLine();
                Appointment appointmentRemove = appointmentRepo.getAppointmentById(appId);
                appointmentRepo.remove(appointmentRemove);
                break;
            case 12:
                Set<Appointment> setAppointment = appointmentRepo.getAppointmentSet();
                userInterface.printAllAppointment(setAppointment);
                break;
            case (Constants.EXIT):
                break;
            default:
                System.out.println("Wrong Option..!");
                break;
        }
    }*/

    void handleUserSelection( int option ){
        UserInterface UI = UserInterface.getInstance();
        switch ( option ){
            case 1:
                int doctorOption = 0;
                while( doctorOption != Constants.SUBMENUEXIT ){
                    doctorOption = UI.doctorMenu();
                    handleDoctor(doctorOption);
                }
                break;
            case 2:
                int patientOption = 0;
                while( patientOption != Constants.SUBMENUEXIT ) {
                    patientOption = UI.patientMenu();
                    handlePatient(patientOption);
                }
                break;
            case 3:
                int appointmentOption = 0;
                while( appointmentOption != Constants.SUBMENUEXIT ) {
                    appointmentOption = UI.appointmentMenu();
                    handleAppointment(appointmentOption);
                }
                break;
            case 4:
                break;
            default:
                System.out.println("Please choose above from above");
        }
    }

    void handleDoctor(int option){

        UserInterface UI = UserInterface.getInstance();
        DoctorRepo doctorRepo = DoctorRepo.getinstance();

        switch ( option ){
            case 1:
                addDoctor();
                break;
            case 2:
                System.out.println("Enter doctor Id to update the details of that doctor");
                String docId = scanner.nextLine();
                Doctor doctorExist = doctorRepo.getDoctor(docId);
                if ( doctorExist != null ){
                    UI.doctorDetailToUpdate(doctorExist);
                }else{
                    System.out.println("The entered doctor id does not exist");
                }
                break;
            case 3:
                System.out.println("Enter Doctor Id ");
                String id = scanner.nextLine();
                Doctor doctorRemove = doctorRepo.getDoctor(id);
                doctorRepo.remove(doctorRemove);
                break;
            case 4:
                Set<Doctor> setDoc = doctorRepo.getDoctorSet();
                UI.printAllDoctor(setDoc);
                break;
            case 5:
                break;
            default:
                System.out.println("Please choose above from above");
        }
    }

    void handlePatient(int option){

        UserInterface UI = UserInterface.getInstance();
        PatientRepo patientRepo = PatientRepo.getInstance();

        switch ( option ){
            case 1:
                addPatient();
                break;
            case 2:
                System.out.println("Enter patient Id to update the details of that patient");
                String patientId = scanner.nextLine();
                Patient patientExist = patientRepo.getPatient(patientId);
                if ( patientExist != null ){
                    UI.updatePatientDetail(patientExist);
                }else {
                    System.out.println("The entered patient id does not exist");
                }
                break;
            case 3:
                System.out.println("Enter Patient Id ");
                String patientid = scanner.nextLine();
                Patient patientRemove = patientRepo.getPatient(patientid);
                patientRepo.remove(patientRemove);
                break;
            case 4:
                Set<Patient> lstPatient = patientRepo.getPatientSet();
                UI.printAllPatient(lstPatient);
                break;
            case 5:
                break;
            default:
                System.out.println("Please choose above from above");
        }
    }

    void handleAppointment(int option){
        UserInterface UI = UserInterface.getInstance();
        AppointmentRepo appointmentRepo = AppointmentRepo.getInstance();

        switch ( option ){
            case 1:
                addAppointment();
                break;
            case 2:
                System.out.println("Enter appointment id");
                String appointmentId = scanner.next();
                Appointment updateAppointment = appointmentRepo.getAppointmentById(appointmentId);
                if ( updateAppointment != null ){
                    UI.updateAppointmentDetails(updateAppointment);
                } else {
                    System.out.println("Enter correct id");
                }

                break;
            case 3:
                System.out.println("Enter Appointment Id ");
                String appId = scanner.nextLine();
                Appointment appointmentRemove = appointmentRepo.getAppointmentById(appId);
                appointmentRepo.remove(appointmentRemove);
                break;
            case 4:
                Set<Appointment> setAppointment = appointmentRepo.getAppointmentSet();
                UI.printAllAppointment(setAppointment);
                break;
            case 5:
                break;
            default:
                System.out.println("Please choose above from above");
        }
    }

    void addDoctor() {

        DoctorRepo doctorRepo = DoctorRepo.getinstance();
        UserInterface userInterface = new UserInterface();

        doctorRepo.addMethod(userInterface.getDoctorDetails());
    }

    void addPatient() {

        PatientRepo patientRepo = PatientRepo.getInstance();
        UserInterface userInterface = new UserInterface();

        patientRepo.addPatient(userInterface.getPatientDetails());
    }

    void addAppointment() {

        AppointmentRepo appointmentRepo = AppointmentRepo.getInstance();

        appointmentRepo.addAppointment();
    }

}

