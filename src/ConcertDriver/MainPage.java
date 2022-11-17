package ConcertDriver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame implements ActionListener {

    private JLabel IconMain;
    private JPanel panelMain;

    JMenu fileMenu, performerMenu, concertMenu, salesMenu, adminMenu;
    JMenuItem item=null;

    public MainPage(){
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 400);
        setContentPane(panelMain);

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
        menuBar.add(salesMenu);

    }

    public static void main(String[] args) {
        new MainPage();

    }

    private void createFileMenu(){

        fileMenu = new JMenu("File");

        String FunctionNames[] = {"New","Open","Save","Quit"};

        for(int i=0;i<FunctionNames.length;i++){
            item = new JMenuItem(FunctionNames[i]);
            item.addActionListener(this);

            if(i==3)
                fileMenu.addSeparator();

            fileMenu.add(item);
        }
    }


    private void createPerformerMenu(){

        performerMenu = new JMenu("Performer");

        String FunctionNames[] = {"Add","Update","Remove","View"};

        for(int i=0;i<FunctionNames.length;i++) {

            item = new JMenuItem(FunctionNames[i]);
            item.addActionListener(this);
            performerMenu.add(item);
        }
    }

    private void createConcertMenu(){

        concertMenu = new JMenu("Concert");

        String FunctionNames[] = {"Schedule","Update","Cancel","View"};

        for(int i=0;i<FunctionNames.length;i++) {

            item = new JMenuItem(FunctionNames[i]);
            item.addActionListener(this);
            concertMenu.add(item);
        }
    }

    private void createSalesMenu(){

        salesMenu = new JMenu("Sales");

        String FunctionNames[] = {"Process Sale","Refund Sale","View Sale"};

        for(int i=0;i<FunctionNames.length;i++) {

            item = new JMenuItem(FunctionNames[i]);
            item.addActionListener(this);
            salesMenu.add(item);
        }
    }

    private void createAdminMenu(){

        adminMenu = new JMenu("Admin");

        String FunctionNames[] = {"Generate Revenue Analysis","Generate Commission Report", "x"};

        for(int i=0;i<FunctionNames.length;i++) {

            item = new JMenuItem(FunctionNames[i]);
            item.addActionListener(this);
            adminMenu.add(item);
        }
    }

    @Override
    public void actionPerformed(ActionEvent add) {

        System.out.println("Hello!");



    }
}
