package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame{
    private JFrame frame;

    private JPanel p1;

    private JLabel lblHeading;

    private JButton btnDoctors;

    private JButton btnConsultation;

    public HomePage(){
        frame=new JFrame("Westminster Skin Consultation Manager");
        frame.setSize(600,300);


        p1 = new JPanel();
        p1.setLayout(new GridLayout(2,1,2,2));

        lblHeading = new JLabel("Westminster Skin Consultation Centre");

        btnDoctors = new JButton("Doctors");
        p1.add(btnDoctors);

        btnConsultation = new JButton("Consultation");
        p1.add(btnConsultation);

        this.add(lblHeading, BorderLayout.NORTH);
        this.add(p1, BorderLayout.CENTER);

        MyListener handler = new MyListener();
        btnDoctors.addActionListener(handler);
        btnConsultation.addActionListener(handler);

        frame.add(p1);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class MyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String btnLabel = e.getActionCommand();

            if (btnLabel.equals("Doctors")){
                new DoctorTable();
            }else if(btnLabel.equals("Consultation")){

            }
        }
    }

}
