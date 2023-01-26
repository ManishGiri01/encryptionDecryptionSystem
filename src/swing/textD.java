package swing;



import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class textD implements ActionListener {
    private static SecretKeySpec secretKey;
    private static byte[] key;
    public static void setKey(String myKey)
    {
        MessageDigest md = null;
        try {
            key = myKey.getBytes("UTF-8");
            md = MessageDigest.getInstance("SHA-1");
            key = md.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    private void decryptActionPerformed(ActionEvent e)
    {
        String secret;
        String strToDecrypt;
        try
        {
            secret=t2.getText();
            strToDecrypt=t1.getText();
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            t3.setText(new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt))));

            JOptionPane.showMessageDialog(null,"Decryption done Successfully","Data Security using cryptography",JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ep)
        {
            JOptionPane.showMessageDialog(null,"Please fill a right key","Data Security using cryptography",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    JFrame f;
    JTextField t1,t2,t3;
    JButton b1;
    JButton b2;
    JLabel l,l1,l2;

    textD()
    {
        l1=new JLabel("ENTER CIPHER TEXT");
        l1.setBounds(350,50,300,40);
        l1.setFont(new Font("abc",Font.ITALIC,20));

        l2=new JLabel("PLAIN TEXT");
        l2.setBounds(350,500,300,40);
        l2.setFont(new Font("abc",Font.ITALIC,20));





        t2=new JTextField();
        t2.setBounds(400,300,500,150);
        t2.setPreferredSize(new Dimension(300,80));
        t2.setEditable(true);
        t2.setFont(new Font("abc",Font.PLAIN,20));



        l=new JLabel();
        l.setText("DECRYPTION KEY");
        l.setFont(new Font("abc",Font.ITALIC,15));
        l.setBounds(200,300,600,150);
        l.setLayout(new FlowLayout());

        l.add(t2);

        t1=new JTextField();

        t1.setBounds(200,100,400,150);
        t1.setEditable(true);
        t1.setFont(new Font("abc",Font.PLAIN,20));

        t3=new JTextField();
        t3.setBounds(200,550,400,150);
        t3.setEditable(true);
        t3.setFont(new Font("abc",Font.PLAIN,20));

        b1 = new JButton();
        b1.addActionListener(this);
        b1.setText("DECRYPT");
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.BLACK);
        b1.setFocusable(false);
        b1.setBounds(400,400,150,50);

        b2 = new JButton();
        b2.addActionListener(this);
        b2.setText("BACK");
        b2.setBackground(Color.GRAY);
        b2.setForeground(Color.BLACK);
        b2.setFocusable(false);
        b2.setBounds(650,20,100,50);



        f=new JFrame();
        f.setTitle("DATA SECURITY USING CRYPTOGRAPHY");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 800);
        f.setLayout(null);

        f.add(t1);
        f.add(t3);
        f.add(b1);
        f.add(b2);
        f.add(l);
        f.add(l1);
        f.add(l2);

        f.setResizable(false);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            decryptActionPerformed(e);

        }
        if(e.getSource()==b2)
        {
            f.dispose();
        }
    }
}
