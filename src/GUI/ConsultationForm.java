package GUI;


import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DateTimePicker;
import w1867122.Consultation;
import w1867122.Doctor;
import w1867122.Patient;
import w1867122.WestminsterSkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDateTime;
import java.util.*;
import java.util.Timer;


public class ConsultationForm {
    private JLabel header;
    JTextField doctorInput;
    DateTimePicker dateTime;
    private JLabel checkResult;

    JTextField nameInput;
    JTextField surnameInput;
    DatePicker dobCalendar;
    JTextField mobileNumberInput;
    JTextField patientIdInput;
    JTextField hours;
    JTextField costInput;
    JTextField notes;
    JTextField saveResult;


    static ArrayList <Consultation> CONSULTATIONS = new ArrayList<>();
    ArrayList<String> INPUT_FIELDS_1 = new ArrayList<>();
    ArrayList<String> INPUT_FIELDS_2 = new ArrayList<>();
    ArrayList<Doctor> DOCTOR_DETAILS = WestminsterSkinConsultationManager.getArrayList();
    ArrayList<Consultation> lastConsultation =new ArrayList<>();

    public ConsultationForm(){

        JFrame frame = new JFrame("Westminster Skin Consultation Manager");
        header = new JLabel("Consultation");

        /*----------------------------------------------------------------------------*/

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(12, 2));

        doctorInput = new JTextField();

        dateTime = new DateTimePicker();

        JButton check = new JButton("Check");

        checkResult = new JLabel(" ");

        panel1.add(new JLabel("Doctor's license Number: "));
        panel1.add(doctorInput);

        panel1.add(new JLabel("Consultation date and time"));
        panel1.add(dateTime);

        panel1.add(check);
        panel1.add(checkResult);

        /*-----------------------------------------------------------------------------*/

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        nameInput = new JTextField();

        surnameInput = new JTextField();

        dobCalendar = new DatePicker();

        mobileNumberInput = new JTextField();

        patientIdInput = new JTextField();

        hours = new JTextField();

        costInput = new JTextField();

        notes = new JTextField();

        JButton create = new JButton("Save");

        JButton view = new JButton("View Consultation");

        panel1.add(new JLabel("Name: "));
        panel1.add(nameInput);

        panel1.add(new JLabel("Surname: "));
        panel1.add(surnameInput);

        panel1.add(new JLabel("Date of Birth"));
        panel1.add(dobCalendar);

        panel1.add(new JLabel("Mobile Number: "));
        panel1.add(mobileNumberInput);

        panel1.add(new JLabel("Patient ID: "));
        panel1.add(patientIdInput);

        panel1.add(new JLabel("Number of hours: "));
        panel1.add(hours);

        panel1.add(new JLabel("Cost: "));
        panel1.add(costInput);

        panel1.add(new JLabel("Notes: "));
        panel1.add(notes);

        panel1.add(create);
        panel1.add(view);

        saveResult = new JTextField("\t\t\t\t\t\t");
        panel2.add(saveResult);

        /*-----------------------------------------------------------------------------*/

        MyListener handler = new MyListener();
        doctorInput.addActionListener(handler);
        check.addActionListener(handler);

        nameInput.addActionListener(handler);
        surnameInput.addActionListener(handler);
        mobileNumberInput.addActionListener(handler);
        patientIdInput.addActionListener(handler);
        hours.addActionListener(handler);
        costInput.addActionListener(handler);
        notes.addActionListener(handler);
        create.addActionListener(handler);
        view.addActionListener(handler);

        /*---------------------------------------------------------------------------*/


        frame.add(header, BorderLayout.NORTH);
        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.setSize(600,500);
        frame.setVisible(true);
    }

    private void fillFirstList(){
        INPUT_FIELDS_1.add(doctorInput.getText());
        INPUT_FIELDS_2.add(String.valueOf(dateTime.getDateTimeStrict()));
    }

    private void fillSecondList(){
        INPUT_FIELDS_2.add(nameInput.getText());
        INPUT_FIELDS_2.add(surnameInput.getText());
        INPUT_FIELDS_2.add(String.valueOf(dobCalendar.getDate()));
        INPUT_FIELDS_2.add(mobileNumberInput.getText());
        INPUT_FIELDS_2.add(patientIdInput.getText());
        INPUT_FIELDS_2.add(hours.getText());
        INPUT_FIELDS_2.add(costInput.getText());
        INPUT_FIELDS_2.add(notes.getText());
    }

    private void clearFields(){
        doctorInput.setText("");
        nameInput.setText("");
        surnameInput.setText("");
        mobileNumberInput.setText("");
        patientIdInput.setText("");
        hours.setText("");
        costInput.setText("");
        notes.setText("");
    }

    private boolean checkInputs(ArrayList<String> list){

        System.out.println(list.toString());

        for(String field : list){
            if(!field.isEmpty()){ //returns true if the fields are not empty
                return true;
            }
        }
        return false;
    }

    private boolean checkAvailability(int licenseNum, LocalDateTime dateTime){ //returns true if the doctor is not occupied

        if(CONSULTATIONS.isEmpty()){
            return true;
        }

        for (Consultation currentConsultation: CONSULTATIONS){
            if(!(currentConsultation.getLicenseNum() ==licenseNum &&
                    currentConsultation.getDateTime().compareTo(dateTime) == 0)){
                return true;
            }
        }
        return false;
    }

    private int randomDoctor(LocalDateTime dateTime){
        ArrayList<Integer> OCCUPIED_DOCTORS = new ArrayList<>();
        ArrayList<Integer> ALL_DOCTORS = new ArrayList<>();
        for(Consultation currentConsultation: CONSULTATIONS){
            if(currentConsultation.getDateTime() == dateTime){
                OCCUPIED_DOCTORS.add(currentConsultation.getLicenseNum());
            }
        }

        for(Doctor doctor: DOCTOR_DETAILS){
            ALL_DOCTORS.add(doctor.getMedLicenceNumber());
        }

        ALL_DOCTORS.removeAll(OCCUPIED_DOCTORS);
        int docIndex = (int) (Math.random()*DOCTOR_DETAILS.size() + 0);

        return ALL_DOCTORS.get(docIndex);
    }

    private boolean checkPatient(String id){ //returns true if the patient already had a consultation
        for(Consultation thisConsultation: CONSULTATIONS){
            if(id.equals(thisConsultation.getPatient().getPatientId())){
                return true;
            }
        }
        return false;
    }

    private void generateCost(){
        int hrs;
        int cost;
        try {
            hrs = Integer.parseInt(hours.getText());
            if(hrs>5){
                hours.setText("Cannot book consultations longer than 5 hours");
            }else{
                if(checkPatient(patientIdInput.getText())){
                    cost = hrs*25;
                    patientIdInput.setText(String.valueOf(cost));
                }
                else{
                    cost = hrs*15;
                    patientIdInput.setText(String.valueOf(cost));
                }
            }
        }catch (NumberFormatException e){
            hours.setText("Enter an integer value");
        }

    }

    private class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String btnLabel = e.getActionCommand();

            if(btnLabel.equals("Check"))
            {
                fillFirstList();
                if(checkInputs(INPUT_FIELDS_1))
                {
                    if(checkAvailability(Integer.parseInt(doctorInput.getText()), dateTime.getDateTimeStrict()))
                    {
                        checkResult.setText("Doctor is available");
                    }else{
                        checkResult.setText("Doctor not available. Random doctor selected");

                        doctorInput.setText(String.valueOf(randomDoctor(dateTime.getDateTimeStrict())));
                    }
                }else{
                    checkResult.setText("Please complete all the fields");
                }
                INPUT_FIELDS_1.clear();
            }
            else if(btnLabel.equals("Save"))
            {
                fillSecondList();
                if(checkInputs(INPUT_FIELDS_2))
                {
                    //add consultation
                    lastConsultation.clear();
                    generateCost();
                    Consultation consultation = new Consultation(Integer.parseInt(doctorInput.getText()),
                            new Patient(nameInput.getText(),
                                    surnameInput.getText(),
                                    dobCalendar.getDate(),
                                    Integer.parseInt(mobileNumberInput.getText()), patientIdInput.getText()),
                           dateTime.getDateTimeStrict(),
                            Integer.parseInt(hours.getText()),
                            Integer.parseInt(costInput.getText()),
                            notes.getText());

                    CONSULTATIONS.add(consultation);

                    lastConsultation.add(consultation);
                    checkResult.setText(" ");
                    saveResult.setText("Consultation saved successfully!");
                    clearFields();
                }
                else{
                    saveResult.setText("Please complete all fields");
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            saveResult.setText("\t\t\t\t\t");
                        }
                    };
                    Timer timer = new Timer();
                    long delay = 3000L;

                    timer.schedule(task,delay);
                }
                INPUT_FIELDS_2.clear();
            }
            else if(btnLabel.equals("View Consultation")){
                saveResult.setText(lastConsultation.toString());
            }
        }
    }

    public static void main(String[] args) {
        new ConsultationForm();
    }
}
