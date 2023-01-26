package swing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class imageD implements ActionListener {


    private static int key;
    public static void decryption(int key,String str1,String str2)
    {
        try {
            FileInputStream fis = new FileInputStream(str1);
            byte data[] = new byte[fis.available()];


            fis.read(data);
            int i = 0;
            key = Integer.parseInt(str2);

            for (byte b : data) {
                data[i] = (byte) (b ^ key);
                i++;
            }


            FileOutputStream fos = new FileOutputStream(str1);


            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"Decryption done Successfully","Data security using Cryptography",JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ep) {
            ep.printStackTrace();
            JOptionPane.showMessageDialog(null,"Enter a valid key or path","Data security using Cryptography",JOptionPane.INFORMATION_MESSAGE);
        }
    }


    JFrame f;
    JLabel l, l1;
    JFileChooser fc;
    JButton b1, b2,b3;
    JTextField t1, t2;

    imageD() {
        b3 = new JButton();
        b3.addActionListener(this);
        b3.setText("BACK");
        b3.setBackground(Color.GRAY);
        b3.setForeground(Color.BLACK);
        b3.setFocusable(false);
        b3.setBounds(650,20,100,50);

        l1 = new JLabel("SELECT AN IMAGE");
        l1.setBounds(280, 50, 600, 100);
        l1.setFont(new Font("abc", Font.ITALIC, 25));

        b2 = new JButton();
        b2.addActionListener(this);
        b2.setText("DERYPT");
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.BLACK);
        b2.setFocusable(false);
        b2.setBounds(400, 550, 150, 50);


        t2 = new JTextField();
        t2.setBounds(400, 300, 500, 150);
        t2.setPreferredSize(new Dimension(300, 80));
        t2.setEditable(true);
        t2.setFont(new Font("abc", Font.PLAIN, 20));


        l = new JLabel();
        l.setText("DECRYPTION KEY");
        l.setFont(new Font("abc", Font.ITALIC, 15));
        l.setBounds(200, 400, 600, 150);
        l.setLayout(new FlowLayout());

        l.add(t2);

        b1 = new JButton();
        b1.addActionListener(this);
        b1.setText("SELECT");
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.BLACK);
        b1.setFocusable(false);
        b1.setBounds(320, 250, 150, 50);


        t1 = new JTextField();
        t1.setBounds(100, 150, 600, 50);
        t1.setFont(new Font("abc", Font.PLAIN, 20));


        f = new JFrame("DATA SECURITY USING CRYPTOGRAPHY");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 800);


        f.setResizable(false);
        f.setLayout(null);

        f.add(t1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(l);
        f.add(l1);


        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        File file;
        if(e.getSource()==b3)
        {
            f.dispose();
        }
        if (e.getSource() == b1) {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            file = fileChooser.getSelectedFile();
            t1.setText(file.getAbsolutePath());
        }
        String str1;
        String str2;


        if (e.getSource() == b2) {
            str1=t1.getText();
            str2=t2.getText();

            key = Integer.parseInt(str2);

            decryption(key,str1,str2);

        }

    }
}





