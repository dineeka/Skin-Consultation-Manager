import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    static int count; //Number of doctors

    ArrayList<Doctor> DOCTOR_ARRAY_LIST = new ArrayList<>();

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

    public void add() {
        if (DOCTOR_ARRAY_LIST.size()<10) {
            String name = inputStr("Enter the name: ");
            String surname = inputStr("Enter the surname: ");
            String DateOfBirth = inputStr("Enter the Date of Birth: ");
            String mobileNumber = inputStr("Enter the mobile number: ");
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
        String surnameI, surnameII;

        SORT_LIST.sort(Comparator.comparing(Doctor::getSurname, String.CASE_INSENSITIVE_ORDER));
        //reference -> https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Comparator.html

        System.out.println(SORT_LIST.toString());
    }

    public void save() {
        try {
            FileWriter fileWriter = new FileWriter("src/DoctorDetails.txt", true);
            fileWriter.write(DOCTOR_ARRAY_LIST.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader("src/DoctorDetails.txt");
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

}
