package w1867122;

import GUI.HomePage;


public class Main {
    public static void main(String[] args){
        boolean run=true;

        int option;

        WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();

        System.out.println("-------Westminster Skin Consultation Manager-------");
        System.out.println("----Menu----\n");

        westminsterSkinConsultationManager.read();

        while(run){
            System.out.println("1 - Add a new Doctor");
            System.out.println("2 - Delete a Doctor");
            System.out.println("3 - Print the list of Doctors");
            System.out.println("4 - Save");
            System.out.println("5 - Display File Details");
            System.out.println("6 - Open GUI");
            System.out.println("7 - Exit");

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
                    westminsterSkinConsultationManager.display();
                    continue;
                case 6:
                    new HomePage();
                    continue;
                case 7:
                    run = false;
            }
            System.out.println(WestminsterSkinConsultationManager.DOCTOR_ARRAY_LIST);
        }
    }
}
