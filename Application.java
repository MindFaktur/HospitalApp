package com.bl.hms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Application {
    public static Scanner scanner = new Scanner(System.in);
    AppointmentRepo appointmentRepo = new AppointmentRepo();
    public static void main(String[] args)
    {
        int exit = 13;
        int option;
        UserInterface userInterface = new UserInterface();
        Application application = new Application();
        do{
            option = userInterface.ShowMainMenu();
            application.handleUserSelection(option);
        }while (option != exit);
    }

    void handleUserSelection(int option)
    {
        UserInterface userInterface = new UserInterface();
        DoctorRepo doctorRepo = DoctorRepo.getinstance();
        PatientRepo patientRepo = PatientRepo.getInstance();
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
                List lstDoc = doctorRepo.getDoctorList();
                userInterface.printAllDoctor(lstDoc);
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
                break;
            case 8:
                List lstPatient = patientRepo.getPatientList();
                userInterface.printAllPatient(lstPatient);
                break;
            case 9:
                addAppointment();
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                List listAppointment = appointmentRepo.getAppointmentList();
                userInterface.printAllAppointment(listAppointment);
                break;
            case 13:
                break;
            default:
                System.out.println("Wrong Option..!");
                break;
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

        UserInterface userInterface = new UserInterface();

        appointmentRepo.addAppointment(userInterface.getAppointment());
    }

}

