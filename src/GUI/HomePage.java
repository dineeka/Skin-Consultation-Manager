package GUI;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame{
    private JLabel lblHeading;

    private JButton btnDoctors;

    private JButton btnConsultation;

    public HomePage(){
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2,1,2,2));

        lblHeading = new JLabel("Westminster Skin Consultation Centre");

        btnDoctors = new JButton("Doctors");
        p1.add(btnDoctors);

        btnConsultation = new JButton("Consultation");
        p1.add(btnConsultation);

        this.add(lblHeading, BorderLayout.NORTH);
        this.add(p1, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.setVisible(true);
        homePage.setSize(600,300);
        homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
