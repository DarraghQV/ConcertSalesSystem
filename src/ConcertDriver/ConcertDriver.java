package ConcertDriver;

import javax.swing.*;
import java.util.Arrays;
import java.util.ArrayList;


public class ConcertDriver extends JFrame {
    public static void main(String[] args) {

        Performers p1 = new Performers(1, "Front Row", 10000);

        ArrayList<Performers> allPerformers = new ArrayList<Performers>(Arrays.asList(p1));
    }

    public static void addPerformers(ArrayList<Performers> allPerformers) {

        int PerformerID = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Ticket ID"));
        String Agent = JOptionPane.showInputDialog("Please enter the Ticket Type");
        int Fee = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Concert the Ticket is for"));

        Performers p = new Performers(PerformerID, Agent, Fee);

        allPerformers.add(p);
        JOptionPane.showMessageDialog(null, "Product now created and added to array list!",
                "Product Added", JOptionPane.INFORMATION_MESSAGE);


    }
}
