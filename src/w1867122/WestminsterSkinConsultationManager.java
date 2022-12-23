package w1867122;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    static int count; //Number of doctors

    static ArrayList<Doctor> DOCTOR_ARRAY_LIST = new ArrayList<>();

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
            System.out.println(msg);
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

    public void add() throws ParseException {
        if (DOCTOR_ARRAY_LIST.size()<10) {
            String name = inputStr("Enter the name: ");
            String surname = inputStr("Enter the surname: ");
            LocalDate DateOfBirth = inputDate("Enter the Date of Birth: ");
            int mobileNumber = inputInt("Enter the mobile number: ");
            int medLicenseNumber = inputInt("Enter the medical license number: ");
            String specialisation = inputStr("Enter the specialisation: ");

            DOCTOR_ARRAY_LIST.add(new Doctor(name,surname,DateOfBirth,mobileNumber,medLicenseNumber,specialisation));
            count++;

            System.out.println(DOCTOR_ARRAY_LIST.toString());

            System.out.println("Doctor added successfully");
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
        try {
            FileWriter fileWriter = new FileWriter("src/w1867122/DoctorDetails.txt", true);
            fileWriter.write(DOCTOR_ARRAY_LIST.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader("src/w1867122/DoctorDetails.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while(line != null){
                line= bufferedReader.readLine();
            }
            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("saved successfully!");
    }

    public static ArrayList<Doctor> getArrayList(){
        return DOCTOR_ARRAY_LIST;
    }




}
