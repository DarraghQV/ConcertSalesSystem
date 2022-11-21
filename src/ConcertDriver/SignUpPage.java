package ConcertDriver;

import javax.swing.*;

public class SignUpPage extends JFrame {

    JPanel panelSign;
    JTextField txtfldName;
    JTextField txtfldPhone;
    JTextField txtfldEmail;
    JTextField txtfldPassword;
    JLabel lblIcon;
    JLabel lblHeader;
    JLabel lblName;
    JLabel lblPhone;
    JLabel lblEmail;
    JLabel lblPassword;

    public SignUpPage(){
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 400);
        setContentPane(panelSign);
        setLocationRelativeTo(null);
        setResizable(false);


    }

    public static void main(String[] args) {
        new SignUpPage();

    }

}




