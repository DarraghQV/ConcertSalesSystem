package ConcertDriver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Login extends JFrame {

    public static void main(String[] args) {
        Login loginPage = new Login();
    }

    private JTextField NameField;
    private JPasswordField passwordField;
    private JButton loginButton;
	private JLabel Password;
    private JLabel Name;
    private JLabel Title;
    private JLabel Icon;
    private JPanel loginPanel;
	private JLabel validationLabel;

	private String username = "Billy";

	private char[] correctPassword = { '1', '2', '3', '4', '5', '6', '7' };


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
				String user = NameField.getText();
					  char[] input = passwordField.getPassword();

							  if (user.equals(username)) {
						    if (Arrays.equals(input, correctPassword)) {
									JOptionPane.showMessageDialog(null, "Successfully logged in!");
						MainPage main = new MainPage();
						setVisible(false);

						    }
						    else {
							       JOptionPane.showMessageDialog(null, "Password is incorrect!");
							    }
					 	  }
					  else {
						    JOptionPane.showMessageDialog(null, "Username does not exist.");
						  }
				    }
   });

        }

    }





