package GUI;

import w1867122.Consultation;
import w1867122.Doctor;
import w1867122.Patient;
import w1867122.WestminsterSkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ConsultationForm {
    private JLabel header;
    JTextField doctorInput;
    JFormattedTextField dateTimeInput;
    private JLabel checkResult;

    JTextField nameInput;
    JTextField surnameInput;
    JTextField dateOfBirthInput;
    JTextField mobileNumberInput;
    JTextField patientIdInput;
    JTextField costInput;
    JTextField notes;
    JLabel saveResult;

    static ArrayList <Consultation> CONSULTATIONS = new ArrayList<>();
    ArrayList<String> INPUT_FIELDS_1 = new ArrayList<>();
    ArrayList<String> INPUT_FIELDS_2 = new ArrayList<>();
    ArrayList<Doctor> DOCTOR_DETAILS = WestminsterSkinConsultationManager.getArrayList();

    public ConsultationForm(){

        JFrame frame = new JFrame("Westminster Skin Consultation Manager");
        header = new JLabel("Consultation");

        /*----------------------------------------------------------------------------*/

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 2));

        doctorInput = new JTextField();

        dateTimeInput = new JFormattedTextField();

        JButton check = new JButton("Check");

        checkResult = new JLabel(" ");

        panel1.add(new JLabel("Doctor's license Number: "));
        panel1.add(doctorInput);

        panel1.add(new JLabel("Consultation date and time: "));
        panel1.add(dateTimeInput);

        INPUT_FIELDS_1.add(doctorInput.getText());
        INPUT_FIELDS_1.add(dateTimeInput.getText());

        panel1.add(check);
        panel1.add(checkResult);

        /*-----------------------------------------------------------------------------*/

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(8,2));

        nameInput = new JTextField();

        surnameInput = new JTextField();

        dateOfBirthInput = new JTextField();

        mobileNumberInput = new JTextField();

        patientIdInput = new JTextField();

        costInput = new JTextField();

        notes = new JTextField();

        JButton create = new JButton("Save");

        saveResult = new JLabel(" ");

        //panel2.add(name);
        panel2.add(new JLabel("Name: "));
        panel2.add(nameInput);

        panel2.add(new JLabel("Surname: "));
        panel2.add(surnameInput);

        panel2.add(new JLabel("Date of Birth: "));
        panel2.add(dateOfBirthInput);

        panel2.add(new JLabel("Mobile Number: "));
        panel2.add(mobileNumberInput);

        panel2.add(new JLabel("Patient ID: "));
        panel2.add(patientIdInput);

        panel2.add(new JLabel("Cost: "));
        panel2.add(costInput);

        panel2.add(new JLabel("Notes: "));
        panel2.add(notes);

        INPUT_FIELDS_2.add(nameInput.getText());
        INPUT_FIELDS_2.add(surnameInput.getText());
        INPUT_FIELDS_2.add(dateOfBirthInput.getText());
        INPUT_FIELDS_2.add(mobileNumberInput.getText());
        INPUT_FIELDS_2.add(patientIdInput.getText());
        INPUT_FIELDS_2.add(costInput.getText());
        INPUT_FIELDS_2.add(notes.getText());

        panel2.add(create, BorderLayout.SOUTH);
        panel2.add(saveResult);

        /*-----------------------------------------------------------------------------*/

        MyListener handler = new MyListener();
        check.addActionListener(handler);

        frame.add(header, BorderLayout.NORTH);
        frame.add(panel1);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.setSize(600,500);
        frame.setVisible(true);
    }

    private boolean checkInputs(ArrayList<String> list){
        for(String field : list){
            if(!field.isEmpty()){ //returns true if the fields are not empty
                return true;
            }
        }
        return false;
    }

    private boolean checkAvailability(int licenseNum, LocalDateTime dateTime){
        for (Consultation currentConsultation: CONSULTATIONS){
            if(!(currentConsultation.getLicenseNum() ==licenseNum && currentConsultation.getDateTime()==dateTime)){
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

    private class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String btnLabel = e.getActionCommand();

            if(btnLabel.equals("Check"))
            {
                if(checkInputs(INPUT_FIELDS_1))
                {
                    if(checkAvailability(Integer.parseInt(doctorInput.getText()), LocalDateTime.parse(dateTimeInput.getText())))
                    {
                        checkResult.setText("Doctor Available");
                    }else{
                        checkResult.setText("Doctor not available. Random doctor selected");

                        doctorInput.setText(String.valueOf(randomDoctor(LocalDateTime.parse(dateTimeInput.getText()))));
                    }
                }else{
                    checkResult.setText("Please complete all the fields");
                }
            }
            else if(btnLabel.equals("Save"))
            {
                if(checkInputs(INPUT_FIELDS_2))
                {
                    CONSULTATIONS.add(
                            new Consultation(
                                    Integer.parseInt(doctorInput.getText()),
                                    new Patient(nameInput.getText(),
                                            surnameInput.getText(),
                                            LocalDate.parse(dateOfBirthInput.getText()),
                                            Integer.parseInt(mobileNumberInput.getText()), patientIdInput.getText()),
                                    LocalDateTime.parse(dateTimeInput.getText()),
                                    Integer.parseInt(costInput.getText()),
                                    notes.getText()
                            )
                    );

                }
                else{
                    saveResult.setText("Please complete all fields");
                }
            }
        }
    }

    public static void main(String[] args) {
        new ConsultationForm();
    }
}
