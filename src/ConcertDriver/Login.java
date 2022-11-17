package ConcertDriver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);}

    private JTextField EmailField;
    private JTextField PasswordField;
    private JButton loginButton;
    private JButton signUpButton;
    private JLabel Password;
    private JLabel Email;
    private JLabel Title;
    private JLabel Icon;
    private JPanel panel1;

    public JPanel getPanel() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public Login() {
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {



            }


        });

    }

    }


