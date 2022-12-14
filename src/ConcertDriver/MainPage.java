package ConcertDriver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.awt.*;

import static java.nio.file.Files.createFile;

public class MainPage extends JFrame implements ActionListener {

    private JPanel panelMain;
    private JLabel MainIcon;

    JMenu fileMenu, performerMenu, concertMenu, salesMenu;
    JMenuItem item = null;

    Performers p1 = new Performers(1, "Foo Fighters", "Musashi Miyamoto", 10000);

    Performers p2 = new Performers(2, "Aerosmith", "Neo", 5000);


    Sale s1 = new Sale(100, "Foo Fighters", "Billy Joe", "BillyJoe@gmail.com");

    Concerts c1 = new Concerts(1, "Foo Fighters", "Killarney");

    Concerts c2 = new Concerts(2, "Aerosmith", "Tralee");

    ArrayList<Concerts> allConcerts = new ArrayList<Concerts>(Arrays.asList(c1,c2));


    ArrayList<Performers> allPerformers = new ArrayList<>(Arrays.asList(p1,p2));

    ArrayList<Sale> allSales = new ArrayList<>(Arrays.asList(s1));

    private final File concertFile = new File("concertData.data");




    public MainPage() {
        setTitle("Main Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 700);
        setContentPane(panelMain);
        setLocationRelativeTo(null);
        setResizable(false);

        createFileMenu();
        createPerformerMenu();
        createConcertMenu();
        createSalesMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(performerMenu);
        menuBar.add(concertMenu);
        menuBar.add(salesMenu);
        menuBar.setBackground(Color.WHITE);

    }

    public static void main(String[] args) {
        new MainPage();

    }

    private void createFileMenu() {

        fileMenu = new JMenu("File");

        String FunctionNames[] = {"New File", "Open File", "Save File", "Quit"};

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

    public void makeFile() {

        if(concertFile.exists())
            try {
                final File concertFile = new File("concertData.data");
                FileOutputStream fileOutputStream = new FileOutputStream(concertFile);
                JOptionPane.showMessageDialog(null, "Created a new file to store concert details!",
                        "New File", JOptionPane.INFORMATION_MESSAGE);
                fileOutputStream.close();
            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be found!",
                        "Problem Finding File!", JOptionPane.ERROR_MESSAGE);
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be opened!",
                        "Problem Opening the File!", JOptionPane.ERROR_MESSAGE);
            }

        else
            JOptionPane.showMessageDialog(null, "File to store concert details already exists!",
                    "New File", JOptionPane.WARNING_MESSAGE);
    }

    public void openFile() {

        ObjectInputStream objectInputStream=null;

        if(!concertFile.exists());
        else {
            try {
                FileInputStream fileInputStream = new FileInputStream(concertFile);

                if(concertFile.length()!= 0){
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    JOptionPane.showMessageDialog(null, "Opened the file that stores concert details",
                            "Opened File", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "Can't read file as it is empty!",
                            "Empty File", JOptionPane.ERROR_MESSAGE);
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be opened!",
                        "Problem Opening the File!", JOptionPane.ERROR_MESSAGE);
            }

            if(objectInputStream==null)
                return;

            try{
                ArrayList<Concerts> allConcerts = null;

                allConcerts = (ArrayList<Concerts>) objectInputStream.readObject();

                System.out.println(allConcerts);

                String concertData="";

                if(allConcerts!=null)
                    for(Concerts concert: allConcerts)
                        concertData+=concert + "\n";

                objectInputStream.close();

                JOptionPane.showMessageDialog(null, "Details of concerts read from the file are:\n\n" + concertData,
                        "Opened File", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be read!",
                        "Problem Reading From File!", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Could not find the appropriate class!",
                        "Problem Finding the Class!", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public void saveFile() {
        if (!concertFile.exists());

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(concertFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(allConcerts);
            objectOutputStream.close();
            JOptionPane.showMessageDialog(null, "Saved the file that stores concert details",
                    "Saved File", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getStackTrace());
            JOptionPane.showMessageDialog(null, "File could not be found!",
                    "Problem Finding File!", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            System.out.println(ioe.getStackTrace());
            JOptionPane.showMessageDialog(null, "File could not be written!",
                    "Problem Writing to File!", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static boolean isDigit(String searchIDasString){

        boolean isValid = false;

        for (int i = 0; i < searchIDasString.length(); i++) {

            if(!Character.isDigit(searchIDasString.charAt(i))){
                isValid = false;
                break;
            }
            else isValid = true;
        }


        return isValid;

    }

    public void addPerformers() {

        String PerformerIDAsString = JOptionPane.showInputDialog("Please enter the PerformerID");
        if (PerformerIDAsString != null) {
            while (PerformerIDAsString.isEmpty() || !isDigit(PerformerIDAsString)) {
                JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");
                PerformerIDAsString = JOptionPane.showInputDialog(null, "Please enter the PerformerID");
            }
        }
        int PerformerID = Integer.parseInt(PerformerIDAsString);

        String PerformerName = JOptionPane.showInputDialog("Please enter the Performer name");
        if (PerformerName != null) {
            while (PerformerName.isEmpty() || isDigit(PerformerName)) {
                JOptionPane.showMessageDialog(null, "Please enter field again.");
                PerformerName = JOptionPane.showInputDialog(null, "Please enter the Performer name");
            }
        }


        String Agent = JOptionPane.showInputDialog("Please enter the Agent name");
        if (Agent != null) {
            while (Agent.isEmpty() || isDigit(Agent)) {
                JOptionPane.showMessageDialog(null, "Please enter field again.");
                Agent = JOptionPane.showInputDialog(null, "Please enter the Agent name");
            }
        }

        String FeeAsString = JOptionPane.showInputDialog("Please enter the Performer's fee");

        if (FeeAsString != null) {
            while (FeeAsString.isEmpty() || !isDigit(FeeAsString)) {
                JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");

                FeeAsString = JOptionPane.showInputDialog(null, "Please enter the Performer's fee");
            }
            int Fee = Integer.parseInt(FeeAsString);
            Performers p = new Performers(PerformerID, PerformerName, Agent, Fee);

            allPerformers.add(p);
            JOptionPane.showMessageDialog(null, "Performer now added to array list!",
                    "Product Added", JOptionPane.INFORMATION_MESSAGE);


        }
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

    public void updatePerformer(ArrayList<Performers> allPerformers) {

        ArrayList<Performers> foundPerformers = new ArrayList<Performers>();
        String searchKey = JOptionPane.showInputDialog("Please enter the name of the performer you wish to update");
        if (searchKey != null) {
            while (searchKey.isEmpty() || isDigit(searchKey)) {
                JOptionPane.showMessageDialog(null, "Please enter field again.");
                searchKey = JOptionPane.showInputDialog(null, "Please enter the name of the performer you wish to update");
            }
        }

        for (Performers all : allPerformers)
            if (all.getPerformerName().toLowerCase().contains(searchKey.toLowerCase()))
                foundPerformers.add(all);

        String text = "";

        for (Performers all : foundPerformers)
            if (all != null) {
                text += all + "\n";
            }


        String searchIDasString = JOptionPane.showInputDialog("The following performers matched your search\n\n" + text +
                "\n\nPlease enter the id of the one you want to remove");

        if(searchIDasString != null) {
            while (searchIDasString.isEmpty() || !isDigit(searchIDasString)) {
                JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");
                searchIDasString = JOptionPane.showInputDialog("The following performers matched your search\n\n" + text +
                        "\n\nPlease enter the id of the one you want to remove");
            }
        }
        int searchID = Integer.parseInt(searchIDasString);

        Performers performerToRemove = null;

        for (Performers all : foundPerformers)
            if (all != null && all.getPerformerID() == searchID)
                performerToRemove = all;

        int removeChoice = JOptionPane.showConfirmDialog(null, "The details of the performer you wish to remove are:\n\n" +
                performerToRemove + "\n\nAre you sure you wish to update this performer?", "Performer Update Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

        if (removeChoice == JOptionPane.YES_OPTION) {
            allPerformers.remove(performerToRemove);


            String PerformerIDAsString = JOptionPane.showInputDialog("Please enter the PerformerID");
            if (PerformerIDAsString != null) {
                while (PerformerIDAsString.isEmpty() || !isDigit(PerformerIDAsString)) {
                    JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");
                    PerformerIDAsString = JOptionPane.showInputDialog(null, "Please enter the PerformerID");
                }
            }
                int PerformerID = Integer.parseInt(PerformerIDAsString);

                String PerformerName = JOptionPane.showInputDialog("Please enter the Performer name");
                if (PerformerName != null) {
                    while (PerformerName.isEmpty() || isDigit(PerformerName)) {
                        JOptionPane.showMessageDialog(null, "Please enter field again.");
                        PerformerName = JOptionPane.showInputDialog(null, "Please enter the Performer name");
                    }
                }


                String Agent = JOptionPane.showInputDialog("Please enter the Agent name");
            if (Agent!= null) {
                while (Agent.isEmpty() || isDigit(Agent)) {
                    JOptionPane.showMessageDialog(null, "Please enter field again.");
                    Agent = JOptionPane.showInputDialog(null, "Please enter the Agent name");
                }
            }

                String FeeAsString = JOptionPane.showInputDialog("Please enter the Performer's fee");

                if (FeeAsString != null) {
                    while (FeeAsString.isEmpty() || !isDigit(FeeAsString)) {
                        JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");

                        FeeAsString = JOptionPane.showInputDialog(null, "Please enter the Performer's fee");
                    }
                    int Fee = Integer.parseInt(FeeAsString);

                    Performers p = new Performers(PerformerID, PerformerName, Agent, Fee);

                    allPerformers.add(p);
                    JOptionPane.showMessageDialog(null, "Performer now added to array list!",
                            "Product Added", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }


    public void removePerformer(ArrayList<Performers> allPerformers) {

        ArrayList<Performers> foundPerformers = new ArrayList<Performers>();
        String searchKey = JOptionPane.showInputDialog("Please enter the name of the Performer you wish to remove:");
        if (searchKey != null) {
            while (searchKey.isEmpty() || isDigit(searchKey)) {
                JOptionPane.showMessageDialog(null, "Please enter field again.");
                searchKey = JOptionPane.showInputDialog(null, "Please enter the name of the performer you wish to update");
            }
        }


        for (Performers all : allPerformers)
            if (all.getPerformerName().toLowerCase().contains(searchKey.toLowerCase()))
                foundPerformers.add(all);

        String text = "";

        for (Performers all : foundPerformers)
            if (all != null) {
                text += all + "\n";
            }


        String searchIDasString = JOptionPane.showInputDialog("The following performers matched your search\n\n" + text +
                "\n\nPlease enter the id of the one you want to remove");

        if (searchIDasString != null) {
            while (searchIDasString.isEmpty() || !isDigit(searchIDasString)) {
                JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");
                searchIDasString = JOptionPane.showInputDialog("The following performers matched your search\n\n" + text +
                        "\n\nPlease enter the id of the one you want to remove");
            }
        }
        int searchID = Integer.parseInt(searchIDasString);

        Performers performerToRemove = null;

        for (Performers all : foundPerformers)
            if (all != null && all.getPerformerID() == searchID)
                performerToRemove = all;

        int removeChoice = JOptionPane.showConfirmDialog(null, "The details of the performer you wish to remove are:\n\n" +
                performerToRemove + "\nAre you sure you wish to remove this performer?", "Performer Removal Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

        if (removeChoice == JOptionPane.YES_OPTION) {
            allPerformers.remove(performerToRemove);
            JOptionPane.showMessageDialog(null, "Performer now removed from array list!",
                    "Performer Removed", JOptionPane.INFORMATION_MESSAGE);
        }
        if (removeChoice == JOptionPane.NO_OPTION) {
            removeChoice = JOptionPane.showConfirmDialog(null, "The details of the performer you wish to remove are:\n\n" +
                    performerToRemove + "\nAre you sure you wish to remove this performer?", "Performer Removal Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
        }
        if (removeChoice == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Returning to Main Page.");
            System.exit(0);
            new MainPage();

        }
    }


    public void scheduleConcert() {

        String ConcertIDasString = JOptionPane.showInputDialog("Please enter the Concert ID");
        if(ConcertIDasString != null) {
            while (ConcertIDasString.isEmpty() || !isDigit(ConcertIDasString)) {
                JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");
                ConcertIDasString = JOptionPane.showInputDialog("Please enter the Concert ID");
            }
        }
            int ConcertID = Integer.parseInt(ConcertIDasString);

        String ArtistName = JOptionPane.showInputDialog("Please enter the Performer name");
        if (ArtistName != null) {
            while (ArtistName.isEmpty() || isDigit(ArtistName)) {
                JOptionPane.showMessageDialog(null, "Please enter field again.");
                ArtistName = JOptionPane.showInputDialog(null, "Please enter the Performer name");
            }
        }

        String Venue = JOptionPane.showInputDialog("Please enter the Venue name");
        if (Venue != null) {
            while (Venue.isEmpty() || isDigit(Venue)) {
                JOptionPane.showMessageDialog(null, "Please enter field again.");
                Venue = JOptionPane.showInputDialog(null, "Please enter the Venue name");
            }
        }

        Concerts c = new Concerts(ConcertID, ArtistName, Venue);

        allConcerts.add(c);
        JOptionPane.showMessageDialog(null, "Concert now added to array list!",
                "Concert Scheduled", JOptionPane.INFORMATION_MESSAGE);


    }

    public static void updateConcert(ArrayList<Concerts> allConcerts) {

        ArrayList<Concerts> foundConcerts = new ArrayList<Concerts>();
        String searchKey = JOptionPane.showInputDialog("Please enter the venue of the Concert you would like to remove");

        if (searchKey != null) {
            while (searchKey.isEmpty() || !isDigit(searchKey)) {
                JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");
                searchKey = JOptionPane.showInputDialog("Please enter the venue of the Concert you would like to remove");
            }
        }

        for (Concerts all : allConcerts)
            if (all.getVenue().toLowerCase().contains(searchKey.toLowerCase()))
                foundConcerts.add(all);

        String text = "";

        for (Concerts all : foundConcerts)
            if (all != null) {
                text += all + "\n";
            }

        String searchIDasString = JOptionPane.showInputDialog("The following concerts matched your search\n\n" + text +
                "\n\nPlease enter the id of the one you want to update");

        if (searchIDasString != null) {
            while (searchIDasString.isEmpty() || !isDigit(searchIDasString)) {
                JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");
                searchIDasString = JOptionPane.showInputDialog("The concerts performers matched your search\n\n" + text +
                        "\n\nPlease enter the id of the one you want to update");
            }
        }
        int searchID = Integer.parseInt(searchIDasString);

        Concerts concertsToRemove = null;

        for (Concerts all : foundConcerts)
            if (all != null && all.getConcertID() == searchID)
                concertsToRemove = all;

        int removeChoice = JOptionPane.showConfirmDialog(null, "The details of the concert you would like to update are are:\n\n" +
                concertsToRemove + "\n\nAre you sure you wish to update this concert?", "Concert Update Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

        if (removeChoice == JOptionPane.YES_OPTION) {
            allConcerts.remove(concertsToRemove);

            String ConcertIDasString = JOptionPane.showInputDialog("Please enter the Concert ID");
            if(ConcertIDasString != null) {
                while (ConcertIDasString.isEmpty() || !isDigit(ConcertIDasString)) {
                    JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");
                    ConcertIDasString = JOptionPane.showInputDialog("Please enter the Concert ID");
                }
            }
            int ConcertID = Integer.parseInt(ConcertIDasString);

            String ArtistName = JOptionPane.showInputDialog("Please enter the Performer name");
            if (ArtistName != null) {
                while (ArtistName.isEmpty() || isDigit(ArtistName)) {
                    JOptionPane.showMessageDialog(null, "Please enter field again.");
                    ArtistName = JOptionPane.showInputDialog(null, "Please enter the Performer name");
                }
            }

            String Venue = JOptionPane.showInputDialog("Please enter the Venue name");
            if (Venue != null) {
                while (Venue.isEmpty() || isDigit(Venue)) {
                    JOptionPane.showMessageDialog(null, "Please enter field again.");
                    Venue = JOptionPane.showInputDialog(null, "Please enter the Venue name");
                }
            }

            Concerts c = new Concerts(ConcertID, ArtistName, Venue);

            allConcerts.add(c);
            JOptionPane.showMessageDialog(null, "Concert now added to array list!",
                    "Concert Scheduled", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void cancelConcert(ArrayList<Concerts> allConcerts) {

        ArrayList<Concerts> foundConcerts = new ArrayList<Concerts>();
        String searchKey = JOptionPane.showInputDialog("Please enter the venue of the Concert you would like to remove");
        if (searchKey != null) {
            while (searchKey.isEmpty() || !isDigit(searchKey)) {
                JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");
                searchKey = JOptionPane.showInputDialog("Please enter the venue of the Concert you would like to remove");
            }
        }

        for (Concerts all : allConcerts)
            if (all.getVenue().toLowerCase().contains(searchKey.toLowerCase()))
                foundConcerts.add(all);

        String text = "";

        for (Concerts all : foundConcerts)
            if (all != null) {
                text += all + "\n";
            }

        String searchIDasString = JOptionPane.showInputDialog("The following concerts matched your search\n\n" + text +
                "\n\nPlease enter the id of the one you want to update");

        if (searchIDasString != null) {
            while (searchIDasString.isEmpty() || !isDigit(searchIDasString)) {
                JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");
                searchIDasString = JOptionPane.showInputDialog("The concerts performers matched your search\n\n" + text +
                        "\n\nPlease enter the id of the one you want to update");
            }
        }
        int searchID = Integer.parseInt(searchIDasString);

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

    public void processSale() {

        String SaleAmountAsString = JOptionPane.showInputDialog("Please enter the Sale Amount");
        if (SaleAmountAsString != null) {
            while (SaleAmountAsString.isEmpty() || !isDigit(SaleAmountAsString)) {
                JOptionPane.showMessageDialog(null, "Not a digit. Please enter field again.");
                SaleAmountAsString = JOptionPane.showInputDialog("Please enter the Sale Amount");
            }
        }
        int SaleAmount = Integer.parseInt(SaleAmountAsString);


        String TicketType = JOptionPane.showInputDialog("Please enter what concert the Ticket is for");
        if (TicketType != null) {
            while (TicketType.isEmpty() || isDigit(TicketType)) {
                JOptionPane.showMessageDialog(null, "Please enter field again.");
                TicketType = JOptionPane.showInputDialog(null, "Please enter what concert the Ticket is for");
            }
        }

        String CustomerName = JOptionPane.showInputDialog("Please enter the Customer name");
        if (CustomerName != null) {
            while (CustomerName.isEmpty() || isDigit(CustomerName)) {
                JOptionPane.showMessageDialog(null, "Please enter field again.");
                CustomerName = JOptionPane.showInputDialog(null, "Please enter the Customer name");
            }
        }

        String CustomerEmail = JOptionPane.showInputDialog("Please enter the Customer email");
        if (CustomerEmail != null) {
            while (CustomerEmail.isEmpty() || isDigit(CustomerEmail)) {
                JOptionPane.showMessageDialog(null, "Please enter field again.");
                CustomerEmail = JOptionPane.showInputDialog(null, "Please enter the Customer email");
            }
        }

        Sale s = new Sale(SaleAmount, TicketType, CustomerName, CustomerEmail);

        allSales.add(s);
        JOptionPane.showMessageDialog(null, "Sale now added to array list!",
                "Product Added", JOptionPane.INFORMATION_MESSAGE);


    }

    public void viewSale(ArrayList<Sale>allSales) {

        String allSaleData = "";
        Sale sale;

        Iterator<Sale> iterator = allSales.iterator();

        while (iterator.hasNext()) {
            sale = iterator.next();
            if (sale != null)
                allSaleData += sale + "\n\n";
        }
        JOptionPane.showMessageDialog(null, allSaleData);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("New File"))
            makeFile();
        if (e.getActionCommand().equals("Open File"))
            openFile();
        if (e.getActionCommand().equals("Save File"))
            saveFile();
        if (e.getActionCommand().equals("Quit")){
            JOptionPane.showMessageDialog(null, "Session ending. Thank you!");
                    System.exit(0);}

        // Performers Functions

        if (e.getActionCommand().equals("Add Performer"))
            addPerformers();
        if (e.getActionCommand().equals("Update Performer"))
            updatePerformer(allPerformers);
        if (e.getActionCommand().equals("Remove Performer"))
            removePerformer(allPerformers);
        if (e.getActionCommand().equals("View Performer"))
            viewPerformers(allPerformers);

        // Concert Functions
        if (e.getActionCommand().equals("Schedule Concert"))
            scheduleConcert();
        if (e.getActionCommand().equals("Update Concert"))
            updateConcert(allConcerts);
        if (e.getActionCommand().equals("View Concert"))
            viewConcerts(allConcerts);
        if (e.getActionCommand().equals("Cancel Concert"))
            cancelConcert(allConcerts);



        // Sales Functions
        if (e.getActionCommand().equals("Process Sale"))
            processSale();
        if (e.getActionCommand().equals("Refund Sale"))
            JOptionPane.showMessageDialog(null, "Our refund policy: there is no refunds.");
        // Marks for comedy?
        if (e.getActionCommand().equals("View Sale"))
            viewSale(allSales);

    }


}
