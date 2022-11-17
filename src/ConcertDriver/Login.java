package ConcertDriver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JTextField EmailField;
    private JTextField PasswordField;
    private JButton loginButton;
    private JButton signUpButton;
    private JLabel Password;
    private JLabel Email;
    private JLabel Title;
    private JLabel Icon;
    private JPanel loginPanel;

    public Login() {
        setContentPane(loginPanel);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300, 200);


        loginButton.addActionListener(new ActionListener() {

            @Override
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

    public static void main(String[] args) {
        Login loginpage = new Login();
    }


    }



