package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window1 implements ActionListener {

    JFrame f;
    JButton b1;
    JButton b2;
    JLabel l1;

    window1() {



        b1 = new JButton();
        b1.addActionListener(this);
        b1.setText("ENTER");
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.BLACK);
        b1.setFocusable(false);
        b1.setBounds(330,300,150,50);



        b2 = new JButton();
        b2.addActionListener(this);
        b2.setText("EXIT");
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.BLACK);
        b2.setFocusable(false);
        b2.setBounds(330,420,150,50);



        l1= new JLabel();
        l1.setText("WELCOME TO SECURITY SYSTEM");
        l1.setForeground(Color.BLACK);
        l1.setBounds(70, 100, 700, 50);
        l1.setFont(new Font("abc", Font.BOLD, 40));



        f = new JFrame("DATA SECURITY USING CRYPTOGRAPHY");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 800);
        f.setLayout(null);
        f.setResizable(false);


        f.add(l1);
        f.add(b1);
        f.add(b2);

        f.setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b2)
        {
            System.exit(0);

        }
        if(e.getSource()==b1)
        {

            new window2();
        }
    }
}

