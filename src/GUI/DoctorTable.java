package GUI;

import w1867122.Doctor;
import w1867122.WestminsterSkinConsultationManager;

import javax.swing.*;
import java.util.ArrayList;

public class DoctorTable{
    private JButton btnSort;

    private JButton btnBack;

    private JTable docTable;

    ArrayList<Doctor> DOCTOR_DETAILS;

    public DoctorTable(){

        DOCTOR_DETAILS = WestminsterSkinConsultationManager.getArrayList();

        JFrame frame =new JFrame();

        JScrollPane scrollPane = new JScrollPane();
        JTable doctorTable = new JTable();

        doctorTable.setModel(new TableModel(DOCTOR_DETAILS));
        scrollPane.setViewportView(doctorTable);


        frame.add(scrollPane);
        frame.setSize(1000,500);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new DoctorTable();
    }
}
