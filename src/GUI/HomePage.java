package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage{
    private JFrame frame;

    private JPanel p1;

    private JPanel p2;

    private JLabel lblHeading;

    private JButton btnDoctors;

    private JButton btnConsultation;


    public HomePage(){
        frame=new JFrame("Westminster Skin Consultation Manager");
        frame.setSize(1000,650);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(2,1,50,50));
        p1.setBounds(700,200,300,200);
        p1.setBackground(new Color(0,128,128));

        lblHeading = new JLabel("Westminster Skin Consultation Centre", SwingConstants.CENTER);
        lblHeading.setForeground(new Color(25,25,112));
        lblHeading.setBackground(Color.WHITE);
        Font headingFont = new Font("SansSerif", Font.BOLD, 32);
        lblHeading.setFont(headingFont);

        Font btnFont = new Font("SansSerif", Font.BOLD, 24);
        Color btnFontColor = new Color(0,0,128);
        Color btnColor = new Color(102,205,170);

        btnDoctors = new JButton("Doctors");
        btnDoctors.setBounds(700, 50, 100,40);
        btnDoctors.setBackground(btnColor);
        btnDoctors.setForeground(btnFontColor);
        btnDoctors.setFont(btnFont);
        p1.add(btnDoctors);

        btnConsultation = new JButton("Consultation");
        btnConsultation.setFont(btnFont);
        btnConsultation.setBackground(btnColor);
        btnConsultation.setForeground(btnFontColor);
        p1.add(btnConsultation);

        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(new ImageIcon("src/GUI/11zon_resized.jpg"));
        Dimension size = iconLabel.getPreferredSize();
        iconLabel.setBounds(30,30, size.width,size.height);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,2));
        p2.setBounds(50,30,size.width,size.height);
        p2.add(iconLabel);
        p2.add(p1);

        MyListener handler = new MyListener();
        btnDoctors.addActionListener(handler);
        btnConsultation.addActionListener(handler);

        frame.add(lblHeading, BorderLayout.NORTH);
        frame.add(p1);
        frame.add(p2);
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
                new ConsultationForm();
            }
        }
    }

    public static void main(String[] args) {
        new HomePage();
    }

}
