package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window3 implements ActionListener {
    JFrame f;

    JButton b1;
    JButton b2;
    JButton b3;

    window3()
    {


        b1 = new JButton();
        b1.addActionListener(this);
        b1.setText("TEXT ENCRYPTION");
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.BLACK);
        b1.setFocusable(false);
        b1.setLayout(new BorderLayout());
        b1.setBounds(330,200,160,50);


        b2 = new JButton();
        b2.addActionListener(this);
        b2.setText("IMAGE ENCRYPTION");
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.BLACK);
        b2.setFocusable(false);
        b2.setBounds(330,350,160,50);


        b3 = new JButton();
        b3.addActionListener(this);
        b3.setText("BACK");
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.BLACK);
        b3.setFocusable(false);
        b3.setBounds(330,500,160,50);





        f = new JFrame("DATA SECURITY USING CRYPTOGRAPHY");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 800);
        f.setLayout(null);

        f.add(b1);
        f.add(b2);
        f.add(b3);


        f.setResizable(false);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            new textE();
        }
        if(e.getSource()==b2)
        {
            new imageE();
        }
        if(e.getSource()==b3)
        {
            f.dispose();
        }

    }
}
