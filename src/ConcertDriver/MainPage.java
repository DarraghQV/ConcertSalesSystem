package ConcertDriver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MainPage extends JFrame implements ActionListener {

    private JLabel IconMain;
    private JPanel panelMain;

    JMenu fileMenu, performerMenu, concertMenu, salesMenu, adminMenu;
    JMenuItem item = null;

    Performers p1 = new Performers(1, "Foo Fighters", "Balogne Man", 10000);
    Concerts c1 = new Concerts(1, "husfduf", "Killarney");


    ArrayList<Performers> allPerformers = new ArrayList<>(Arrays.asList(p1));
    ArrayList<Concerts> allConcerts = new ArrayList<>(Arrays.asList(c1));


    public MainPage() {
        setTitle("Main Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 400);
        setContentPane(panelMain);
        setLocationRelativeTo(null);
        setResizable(false);

        createFileMenu();
        createPerformerMenu();
        createConcertMenu();
        createSalesMenu();
        createAdminMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(performerMenu);
        menuBar.add(concertMenu);
        menuBar.add(salesMenu);
        menuBar.add(adminMenu);

    }

    public static void main(String[] args) {
        new MainPage();

    }

    private void createFileMenu() {

        fileMenu = new JMenu("File");

        String FunctionNames[] = {"New", "Open", "Save", "Quit"};

        for (int i = 0; i < FunctionNames.length; i++) {
            item = new JMenuItem(FunctionNames[i]);
            item.addActionListener(this);

            if (i == 3)
                fileMenu.addSeparator();

            fileMenu.add(item);
        }
    }


    private void createPerformerMenu() {

        performerMenu = new JMenu("Performer");

        String FunctionNames[] = {"Add Performer", "Update Performer", "Remove Performer", "View Performer"};

        for (int i = 0; i < FunctionNames.length; i++) {

            item = new JMenuItem(FunctionNames[i]);
            item.addActionListener(this);
            performerMenu.add(item);
        }
    }

    private void createConcertMenu() {

        concertMenu = new JMenu("Concert");

        String FunctionNames[] = {"Schedule Concert", "Update Concert", "Cancel Concert", "View Concert"};

        for (int i = 0; i < FunctionNames.length; i++) {

            item = new JMenuItem(FunctionNames[i]);
            item.addActionListener(this);
            concertMenu.add(item);
        }
    }

    private void createSalesMenu() {

        salesMenu = new JMenu("Sales");

        String FunctionNames[] = {"Process Sale", "Refund Sale", "View Sale"};

        for (int i = 0; i < FunctionNames.length; i++) {

            item = new JMenuItem(FunctionNames[i]);
            item.addActionListener(this);
            salesMenu.add(item);
        }
    }

    private void createAdminMenu() {

        adminMenu = new JMenu("Admin");

        String FunctionNames[] = {"Generate Revenue Analysis", "Generate Commission Report", "x"};

        for (int i = 0; i < FunctionNames.length; i++) {

            item = new JMenuItem(FunctionNames[i]);
            item.addActionListener(this);
            adminMenu.add(item);
        }
    }

    public void addPerformers() {

        int PerformerID = Integer.parseInt(JOptionPane.showInputDialog("Please enter the PerformerID"));
        String PerformerName = JOptionPane.showInputDialog("Please enter the Performer name");
        String Agent = JOptionPane.showInputDialog("Please enter the Agent name");
        int Fee = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Performer's fee"));

        Performers p = new Performers(PerformerID, PerformerName, Agent, Fee);

        allPerformers.add(p);
        JOptionPane.showMessageDialog(null, "Performer now added to array list!",
                "Product Added", JOptionPane.INFORMATION_MESSAGE);


    }

    public void viewPerformers(ArrayList<Performers>allPerformers) {

        String allPerformerData = "";
        Performers performer;

        Iterator<Performers> iterator = allPerformers.iterator();

        while (iterator.hasNext()) {
            performer = iterator.next();
            if (performer != null)
                allPerformerData += performer + "\n";
        }
        JOptionPane.showMessageDialog(null, allPerformerData.toString());
    }

    public static void removePerformer(ArrayList<Performers> allPerformers) {

        ArrayList<Performers> foundPerformers = new ArrayList<Performers>();
        String searchKey = JOptionPane.showInputDialog("Please enter the name of the performer you wish to remove");

        for (Performers all : allPerformers)
            if (all.getPerformerName().toLowerCase().contains(searchKey.toLowerCase()))
                foundPerformers.add(all);

        String text = "";

        for (Performers all : foundPerformers)
            if (all != null) {
                text += all + "\n";
            }

        int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following performers matched your search\n\n" + text +
                "\n\nPlease enter the id of the one you want to remove"));

        Performers performerToRemove = null;

        for (Performers all : foundPerformers)
            if (all != null && all.getPerformerID() == searchID)
                performerToRemove = all;

        int removeChoice = JOptionPane.showConfirmDialog(null, "The details of the performer you wish to remove are:\n\n" +
                performerToRemove + "\n\nAre you sure you wish to remove this performer?", "Performer Removal Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

        if (removeChoice == JOptionPane.YES_OPTION) {
            allPerformers.remove(performerToRemove);
            JOptionPane.showMessageDialog(null, "Performer now removed from array list!",
                    "Performer Removed", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void scheduleConcert() {

        int ConcertID = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Concert ID"));
        String ArtistName = JOptionPane.showInputDialog("Please enter the Performer name");
        String Venue = JOptionPane.showInputDialog("Please enter the Venue name");

        Concerts c = new Concerts(ConcertID, ArtistName, Venue);

        allConcerts.add(c);
        JOptionPane.showMessageDialog(null, "Concert now added to array list!",
                "Concert Scheduled", JOptionPane.INFORMATION_MESSAGE);


    }

    public static void cancelConcert(ArrayList<Concerts> allConcerts) {

        ArrayList<Concerts> foundConcerts = new ArrayList<Concerts>();
        String searchKey = JOptionPane.showInputDialog("Please enter the venue of the Concert you would like to remove");

        for (Concerts all : allConcerts)
            if (all.getVenue().toLowerCase().contains(searchKey.toLowerCase()))
                foundConcerts.add(all);

        String text = "";

        for (Concerts all : foundConcerts)
            if (all != null) {
                text += all + "\n";
            }

        int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following concerts matched your search\n\n" + text +
                "\n\nPlease enter the ID of the one you want to remove"));

        Concerts concertsToRemove = null;

        for (Concerts all : foundConcerts)
            if (all != null && all.getConcertID() == searchID)
                concertsToRemove = all;

        int removeChoice = JOptionPane.showConfirmDialog(null, "The details of the concert you would like to cancel are are:\n\n" +
                concertsToRemove + "\n\nAre you sure you wish to cancel this concert?", "Concert Cancellation Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

        if (removeChoice == JOptionPane.YES_OPTION) {
            allConcerts.remove(concertsToRemove);
            JOptionPane.showMessageDialog(null, "Concert now removed from array list!",
                    "Concert Removed", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void viewConcerts(ArrayList<Concerts>allConcerts) {

        String allConcertData = "";
        Concerts concert;

        Iterator<Concerts> iterator = allConcerts.iterator();

        while (iterator.hasNext()) {
            concert = iterator.next();
            if (concert != null)
                allConcertData += concert + "\n\n";
        }
        JOptionPane.showMessageDialog(null, allConcertData);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        // Performers Functions

        if (e.getActionCommand().equals("Add Performer"))
            addPerformers();
        if (e.getActionCommand().equals("Update Performer"));

        if (e.getActionCommand().equals("Remove Performer"))
            removePerformer(allPerformers);

        if (e.getActionCommand().equals("View Performer"))
            viewPerformers(allPerformers);

        // Concert Functions

        if (e.getActionCommand().equals("Schedule Concert"))
            scheduleConcert();
        if (e.getActionCommand().equals("View Concert"))
            viewConcerts(allConcerts);
        if (e.getActionCommand().equals("Cancel Concert"))
            cancelConcert(allConcerts);



        // Sales Functions
        if (e.getActionCommand().equals("Process Sale"));

        if (e.getActionCommand().equals("View Sale"));

    }

}
