package w1867122;

import GUI.HomePage;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        boolean run=true;

        int option;

        WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();

        System.out.println("-------Westminster Skin Consultation Manager-------");
        System.out.println("----Menu----\n");

        while(run){
            System.out.println("1 - Add a new Doctor");
            System.out.println("2 - Delete a Doctor");
            System.out.println("3 - Print the list of Doctors");
            System.out.println("4 - Save");
            System.out.println("5 - Open GUI");
            System.out.println("6 - Exit");

            option = westminsterSkinConsultationManager.inputInt("Enter your selection: ");

            switch (option){
                case 1:
                    westminsterSkinConsultationManager.add();
                    continue;
                case 2:
                    westminsterSkinConsultationManager.delete();
                    continue;
                case 3:
                    westminsterSkinConsultationManager.print();
                    continue;
                case 4:
                    westminsterSkinConsultationManager.save();
                    continue;
                case 5:
                    new HomePage();
                    continue;
                case 6:
                    run = false;
            }
            System.out.println(WestminsterSkinConsultationManager.DOCTOR_ARRAY_LIST);
        }
    }
}
