package w1867122;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    static int count; //Number of doctors

    static ArrayList<Doctor> DOCTOR_ARRAY_LIST = new ArrayList<>();
    static ArrayList<Consultation> CONSULTATIONS = new ArrayList<>();

    public String inputStr(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) { //if the input is empty
                System.out.println("Error - This Field Cannot be Empty");
            }
            else {
                break;
            }
        }
        return input;
    }

    public int inputInt(String msg){
        Scanner sc = new Scanner(System.in);
        String input;
        while (true){
            System.out.print(msg);
            input = sc.nextLine().toLowerCase(Locale.ROOT);
            try {
                Integer.parseInt(input);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Error - Enter an Integer Value"); // If someone entered characters other than integers
            }
        }
        return Integer.parseInt(input);
    }

    public LocalDate inputDate(String msg) throws DateTimeException {
        Scanner sc = new Scanner(System.in);
        String input;
        LocalDate date;
        while (true) {
            System.out.println(msg + " Format: [YYYY-MM-DD]");
            input = sc.next();
            if (input.isEmpty()) { //if the input is empty
                System.out.println("Error - This Field Cannot be Empty");
            } else {
                try {
                    date = LocalDate.parse(input);
                    break;
                }
                catch(DateTimeException e){
                    System.out.println("This cannot be parsed to a date");
                }
            }
        }
        return date;
    }

    public int checkDoctor(int licenseNumber){ //checks if the doctor is in the system and returns the index
        int index=-1;
        int count =0;

        for(Doctor doctor : DOCTOR_ARRAY_LIST){
            if(doctor.getMedLicenceNumber() == licenseNumber){
                index = count;
                return index;
            }
            count++;
        }
        return index;
    }

    public int licenseNumberCheck(int medNo){

        if(checkDoctor(medNo) != -1){
            System.out.println("A doctor with this medical license number is already registered");
        }else {
            return medNo;
        }
        return 0;
    }

    public void add() {
        if (DOCTOR_ARRAY_LIST.size()<10) {
            while (true){
                String name = inputStr("Enter the name: ");
                String surname = inputStr("Enter the surname: ");
                LocalDate DateOfBirth = inputDate("Enter the Date of Birth: ");
                int mobileNumber = inputInt("Enter the mobile number: ");
                int medLicenseNumber = licenseNumberCheck(inputInt("Enter the medical license number: "));
                if (medLicenseNumber == 0) {
                    break;
                }
                String specialisation = inputStr("Enter the specialisation: ");

                DOCTOR_ARRAY_LIST.add(new Doctor(name, surname, DateOfBirth, mobileNumber, medLicenseNumber, specialisation));
                count++;

                System.out.println(DOCTOR_ARRAY_LIST.toString());

                System.out.println("Doctor added successfully");
                break;
            }
        }else{
            System.out.println("Adding unsuccessful! Maximum number of doctors reached");
        }
    }

    public void delete() {
        int lnum = inputInt("Enter the license number of the doctor : ");

        if(checkDoctor(lnum) != -1){
            DOCTOR_ARRAY_LIST.remove(checkDoctor(lnum));
            System.out.println(DOCTOR_ARRAY_LIST);
        }else{
            System.out.println("Doctor does not exist in the system");
        }
    }

    public void print(){
        ArrayList<Doctor> SORT_LIST = DOCTOR_ARRAY_LIST;

        SORT_LIST.sort(Comparator.comparing(Doctor::getSurname, String.CASE_INSENSITIVE_ORDER));
        //reference -> https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Comparator.html

        System.out.println(SORT_LIST);
    }

    public void save() {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("src/w1867122/DoctorDetails.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(DOCTOR_ARRAY_LIST);

            objectOutputStream.close();

        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("saved successfully!");
    }

    public void read(){
        try{
            FileInputStream fileInputStream = new FileInputStream("src/w1867122/DoctorDetails.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ArrayList<Doctor> docList = (ArrayList<Doctor>) objectInputStream.readObject();

            objectInputStream.close();
            DOCTOR_ARRAY_LIST = docList;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void display(){
        read();
        System.out.println(DOCTOR_ARRAY_LIST);
    }

    public static ArrayList<Doctor> getArrayList(){
        return DOCTOR_ARRAY_LIST;
    }


}
