package GUI;

import w1867122.Doctor;
import w1867122.WestminsterSkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DoctorTable{
    private JLabel header;

    private JButton btnBack;

    ArrayList<Doctor> DOCTOR_DETAILS;

    public DoctorTable(){

        DOCTOR_DETAILS = WestminsterSkinConsultationManager.getArrayList();

        JFrame frame =new JFrame();

        header =new JLabel("Doctor Details", SwingConstants.CENTER);
        Font headerFont = new Font("SansSerif", Font.BOLD, 24);
        header.setFont(headerFont);
        frame.getContentPane().add(header, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        JTable doctorTable = new JTable();

        doctorTable.setModel(new TableModel(DOCTOR_DETAILS));
        scrollPane.setViewportView(doctorTable);
        doctorTable.setAutoCreateRowSorter(true);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setSize(1000,500);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new DoctorTable();
    }
}
