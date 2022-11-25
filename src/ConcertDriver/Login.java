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
    private JLabel LoginDetails;
    private JPanel loginPanel;
    private JButton exitButton;

    private String username = "Darragh";

	private char[] correctPassword = { 'T', '0', '0', '2', '2', '6', '2','6','0' };


	public Login() {
        setContentPane(loginPanel);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

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

        exitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                {
                    JOptionPane.showMessageDialog(null, "System shutting down...");
                    System.exit(0);

                }
            }
        });
    }
}







