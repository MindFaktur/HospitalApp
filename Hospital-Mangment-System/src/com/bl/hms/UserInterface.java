package com.bl.hms;

import javax.print.Doc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserInterface {
    private static UserInterface instance;
    UserInterface(){
    }

    public static UserInterface getInstance(){
        if( instance == null ){
            instance = new UserInterface();
        }
        return instance;
    }

    public int ShowMainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hospital Management System");
        System.out.println("1.Add Doctor \n2.Update Doctor \n3.Delete Doctor" +
                "\n4.Show All Doctors List \n5.Add Patient \n6.Update Patient \n" +
                "7.Delete Patient \n8.Show All Patient list \n9.Add Appointment\n" +
                "10.Update Appointment\n11.Delete Appointment\n" +
                "12.Show All Appointment list\n" + Constants.EXIT + ".Exit");

        System.out.println("Select Your Option :");
        return scanner.nextInt();
    }

    public void printAllDoctor(Set<Doctor> doctorSet) {
        for ( Doctor doctor : doctorSet ) {
            System.out.println(doctor);
        }
    }

    public void printAllPatient(Set<Patient> patientSet) {
        for ( Patient patient : patientSet ) {
            System.out.println(patient);
        }
    }

    public void printAllAppointment(Set<Appointment> appointmentSet) {

        /*for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println(appointmentList.get(i));
        }*/

        for ( Appointment appointment : appointmentSet ) {
            System.out.println(appointment);
        }
    }

    public Appointment getAppointment(){

        DoctorRepo doctorRepo = DoctorRepo.getinstance();
        PatientRepo patientRepo = PatientRepo.getInstance();
        Scanner scanner = new Scanner(System.in);
        Appointment appointment = new Appointment();

        System.out.println("Enter doctor id");
        appointment.doctorId = scanner.nextLine();

        if (doctorRepo.isDoctorAvailable(appointment.doctorId)) {
            System.out.println("Enter the PatientId :");
            appointment.patientId = scanner.nextLine();

            if(patientRepo.isPatientAvailable(appointment.patientId)) {
                System.out.println("Enter the RoomNumber :");
                appointment.roomNumber = scanner.nextLong();

                System.out.println("Enter the appointment ID :");
                appointment.appointmentId = scanner.next();

                System.out.println("Enter the Appointment Date like dd-MMM-yyyy");
                Scanner scanner2 = new Scanner(System.in);
                appointment.appointmentDate = scanner2.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                try {
                    Date date = formatter.parse(appointment.appointmentDate);
                } catch (ParseException e) {
                    e.printStackTrace(); //Print Exception in Details
                }
            }
            else {
                System.out.println("Patient id is not available");
            }
        }
        else {
            System.out.println("Doctor id not available ");
        }

        return appointment;
    }

    public Doctor getDoctorDetails(){

        Scanner scanner = new Scanner(System.in);
        Doctor doctor = new Doctor();

        System.out.println("Enter Doctor Name :");
        doctor.docName = scanner.nextLine();

        System.out.println("Enter Doctor Specialization :");
        doctor.specialization = scanner.nextLine();

        System.out.println("Enter Doctor Email ID :");
        doctor.emailID = scanner.nextLine();

        System.out.println("Enter Doctor ID :");
        doctor.id = scanner.nextLine();

        System.out.println("Enter Doctor Mobile Name :");
        doctor.mobNo = scanner.nextLong();

        doctor.availability = new HashMap<>();;
        doctor.availability.put(Doctor.WeekDays.SUNDAY,"10 AM to 12 PM");
        doctor.availability.put(Doctor.WeekDays.MONDAY,"12 PM to 2 PM");
        doctor.availability.put(Doctor.WeekDays.TUESDAY,"2 PM to 4 PM");
        doctor.availability.put(Doctor.WeekDays.WEDNESDAY,"4 PM to 6 PM");
        doctor.availability.put(Doctor.WeekDays.THURSDAY,"6 PM to 8 PM");
        doctor.availability.put(Doctor.WeekDays.FRIDAY,"8 PM to 10 PM");
        doctor.availability.put(Doctor.WeekDays.SATURDAY,"10 PM to 12 AM");

        return doctor;
    }

    void doctorDetailToUpdate(Doctor val){
        int newDetail = 0;
        while ( newDetail != Constants.DOCTOREXIT) {
            System.out.println("Press " +
                    "\n 1) Update doctor name" +
                    "\n 2) Update doctor specialization" +
                    "\n 3) Update doctor mobile number" +
                    "\n 4) Update doctor email-id" +
                    "\n" + Constants.DOCTOREXIT + "Exit"
            );
            newDetail = Application.scanner.nextInt();
            switch (newDetail) {
                case 1:
                    System.out.println("Pleas enter new name");
                    val.docName = Application.scanner.next();
                    break;
                case 2:
                    System.out.println("Pleas enter new specialization");
                    val.specialization = Application.scanner.next();
                    break;
                case 3:
                    System.out.println("Pleas enter new mobile number");
                    val.mobNo = Application.scanner.nextLong();
                    break;
                case 4:
                    System.out.println("Pleas enter new email-Id");
                    val.emailID = Application.scanner.next();
                    break;
                case (Constants.DOCTOREXIT):
                    break;
                default:
                    System.out.println("Please choose from above");
            }
        }
    }

    public Patient getPatientDetails(){

        Scanner scanner = new Scanner(System.in);
        Patient patient = new Patient();

        System.out.println("Enter Patient Name :");
        patient.name = scanner.nextLine();

        System.out.println("Enter Patient Email ID :");
        patient.emailID = scanner.nextLine();

        System.out.println("Enter Patient Disease :");
        patient.disease = scanner.nextLine();

        System.out.println("Enter the Patient Address :");
        patient.address = scanner.nextLine();

        System.out.println("Enter the Patient ID :");
        patient.patientId = scanner.nextLine();

        System.out.println("Enter Patient Age :");
        patient.age = scanner.nextLong();

        System.out.println("Enter Patient Mobile Name :");
        patient.mobNo = scanner.nextLong();

        setGender(patient);

        return patient;
    }

    public void updatePatientDetail(Patient val){
        int newDetail = 0;
        while( newDetail != Constants.PATIENTEXIT ){
            System.out.println("Press " +
                    "\n 1) Update patient name" +
                    "\n 2) Update patient address" +
                    "\n 3) Update patient email-id" +
                    "\n 4) Update patient disease" +
                    "\n 5) Update patient mobile number" +
                    "\n 6) Update patient age" +
                    "\n 7) Update patient gender" +
                    "\n" + Constants.PATIENTEXIT + " Quit"
            );
            newDetail = Application.scanner.nextInt();
            switch (newDetail){
                case 1:
                    System.out.println("Please enter new name");
                    val.name = Application.scanner.next();
                    break;
                case 2:
                    System.out.println("Please enter new address");
                    val.address = Application.scanner.next();
                    break;
                case 3:
                    System.out.println("Please enter new email-id");
                    val.emailID = Application.scanner.next();
                    break;
                case 4:
                    System.out.println("Please enter new disease");
                    val.disease = Application.scanner.next();
                    break;
                case 5:
                    System.out.println("Please enter new mobile number");
                    val.mobNo = Application.scanner.nextLong();
                    break;
                case 6:
                    System.out.println("Please enter new age");
                    val.age = Application.scanner.nextLong();
                    break;
                case 7:
                    setGender(val);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Please choose from above");
            }
        }

    }

    void setGender(Patient patient){

        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Male \n2.Female \n3.Others :");
        int option = scanner.nextInt();

        switch (option)
        {
            case 1:
                patient.gender = Patient.Gender.MALE;
                break;

            case 2:
                patient.gender = Patient.Gender.FEMALE;
                break;
            case 3:
                patient.gender = Patient.Gender.OTHERS;
                break;
            default:
                System.out.println("Wrong Option..!");
                break;
        }
    }

    public void updateAppointmentDetails(Appointment updateAppointment) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter where u want to update \n1.patientId\n2.doctorId\n3.appointmentDate\n4.roomNumber\n5.Exit");
            int numSelected = scanner.nextInt();
            switch (numSelected) {
                case 1:
                    System.out.println("Enter patientId");
                    updateAppointment.patientId = scanner.next();
                    break;
                case 2:
                    System.out.println("Enter doctorId");
                    updateAppointment.doctorId = scanner.next();
                    break;
                case 3:
                    System.out.println("Enter the Appointment Date like dd-MMM-yyyy");
                    Scanner scanner2 = new Scanner(System.in);
                    updateAppointment.appointmentDate = scanner2.next();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                    try {
                        Date date = formatter.parse(updateAppointment.appointmentDate);
                    } catch (ParseException e) {
                        e.printStackTrace(); //Print Exception in Details
                    }
                    break;
                case 4:
                    System.out.println("Enter roomNumber");
                    updateAppointment.doctorId = scanner.next();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Enter correct option plz..");
                    break;
            }
        }
    }
}

