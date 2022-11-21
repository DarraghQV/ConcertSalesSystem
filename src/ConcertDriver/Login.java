package ConcertDriver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    public static void main(String[] args) {
        Login loginpage = new Login();
    }

    private JTextField NameField;
    private JTextField PasswordField;
    private JButton loginButton;
    private JButton signUpButton;
    private JLabel Password;
    private JLabel Name;
    private JLabel Title;
    private JLabel Icon;
    private JPanel loginPanel;

    public Login() {
        setContentPane(loginPanel);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        boolean Valid = false;

        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {


            MainPage main = new MainPage();
            setVisible(false);
            }

        });

        signUpButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                SignUpPage signup = new SignUpPage();
                setVisible(false);
            }

        });

    }


    }



