import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MainGUI extends Page implements ActionListener, WindowListener{

    // variable declarations
    private static String page = "Home";
    private JMenuBar menubar;
    private JMenu navigate;
    private JMenuItem home, budget, guests, contacts, checklist, notes;
    public static JFrame frame;
    private static Budget budgetPage;
    private static Home homePage;
    private static Guests guestsPage;
    private static Contacts contactsPage;
    private static Checklist checklistPage;
    private static Notes notesPage;
    private static JPanel homePanel;
    private static CardLayout manager;


    public MainGUI() throws IOException{
        // use the UIManager to set the look
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        UIManager.put("MenuItem.selectionBackground", darkButtonColor);
        UIManager.put("MenuItem.selectionForeground", Color.WHITE);
        UIManager.put("Menu.selectionBackground", darkButtonColor);
        UIManager.put("Menu.selectionForeground", Color.WHITE);
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        // initialize the frame that will hold everything
        frame = new JFrame("Wedding Work");
        // create an object for every page
        homePage = new Home();
        budgetPage = new Budget();
        guestsPage = new Guests();
        contactsPage = new Contacts();
        checklistPage = new Checklist();
        notesPage = new Notes();
        // create the panel that will hold the other panels
        // cardlayout makes it easy to switch between panels
        homePanel = new JPanel(new CardLayout());
        // add a window listener to detect window closing
        frame.addWindowListener(this);

        // create the menu bar
        menubar = new JMenuBar();
        menubar.setBackground(buttonColor);
        menubar.setOpaque(true);

        // create the navigate dropdown
        navigate = new JMenu("Navigate");
        navigate.setFont(smallerFont);

        // create the items that will be held in the navigate dropdown
        home = new JMenuItem("Home");
        home.setFont(smallerFont);
        budget = new JMenuItem("Budget");
        budget.setFont(smallerFont);
        guests = new JMenuItem("Guests");
        guests.setFont(smallerFont);
        contacts = new JMenuItem("Contacts");
        contacts.setFont(smallerFont);
        checklist = new JMenuItem("Checklist");
        checklist.setFont(smallerFont);
        notes = new JMenuItem("Notes");
        notes.setFont(smallerFont);
        // add the items to the navigate dropdown
        navigate.add(home);
        navigate.add(budget);
        navigate.add(guests);
        navigate.add(contacts);
        navigate.add(checklist);
        navigate.add(notes);

        // set the color scheme for the menu items
        home.setBackground(buttonColor);
        home.setForeground(Color.black);
        home.setOpaque(true);
        budget.setBackground(buttonColor);
        budget.setOpaque(true);
        guests.setBackground(buttonColor);
        guests.setOpaque(true);
        contacts.setBackground(buttonColor);
        contacts.setOpaque(true);
        checklist.setBackground(buttonColor);
        checklist.setOpaque(true);
        notes.setBackground(buttonColor);
        notes.setOpaque(true);

        // add the naviagate dropdown to the menubar
        menubar.add(navigate);

        // add action listeners to each menu item
        budget.addActionListener(this);
        home.addActionListener(this);
        guests.addActionListener(this);
        contacts.addActionListener(this);
        checklist.addActionListener(this);
        notes.addActionListener(this);

        // add each page's panel to the homepanel (cardlayout)
        homePanel.add(homePage.panel);
        homePanel.add(budgetPage.panel);
        homePanel.add(guestsPage.panel);
        homePanel.add(contactsPage.panel);
        homePanel.add(checklistPage.panel);
        homePanel.add(notesPage.panel);
        // add the homepanel to the main frame
        frame.add(homePanel);
        // configure frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("WeddingWork");
        frame.setJMenuBar(menubar);
        frame.setSize(new Dimension(1300,1000));
        // set the frame to invisible
        // will be set visible if login is successful
        frame.setVisible(false);
    }

    // function that is ran when the window closes
    public void windowClosing(WindowEvent event) {
        // when the window closes...
        try{
            // call the saveAction methods from each page object
            budgetPage.saveAction();
            guestsPage.saveAction();
            contactsPage.saveAction();
            checklistPage.saveAction();
            notesPage.saveAction();
        }
        catch (IOException e){}
    }
    // other methods from the WindowListener interface
    public void windowClosed(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    
    // listener for button clicks
    public void actionPerformed(ActionEvent event){
        // all of these are the menu items
        // when a menu item is clicked, it sends an event
        // this event contains a source (the name of the menu item)
        // whichever menu item is clicked, set every other panel to invisible
        // only the clicked menu item's panel will remain visible
        if (event.getSource() == home){
            homePage.panel.setVisible(true);
            budgetPage.panel.setVisible(false);
            guestsPage.panel.setVisible(false);
            contactsPage.panel.setVisible(false);
            checklistPage.panel.setVisible(false);
            notesPage.panel.setVisible(false);
        }
        if (event.getSource() == budget){
            homePage.panel.setVisible(false);
            budgetPage.panel.setVisible(true);
            guestsPage.panel.setVisible(false);
            contactsPage.panel.setVisible(false);
            checklistPage.panel.setVisible(false);
            notesPage.panel.setVisible(false);
        }
        if (event.getSource() == guests){
            homePage.panel.setVisible(false);
            budgetPage.panel.setVisible(false);
            guestsPage.panel.setVisible(true);
            contactsPage.panel.setVisible(false);
            checklistPage.panel.setVisible(false);
            notesPage.panel.setVisible(false);
        }
        if (event.getSource() == contacts){
            homePage.panel.setVisible(false);
            budgetPage.panel.setVisible(false);
            guestsPage.panel.setVisible(false);
            contactsPage.panel.setVisible(true);
            checklistPage.panel.setVisible(false);
            notesPage.panel.setVisible(false);
        }
        if (event.getSource() == checklist){
            homePage.panel.setVisible(false);
            budgetPage.panel.setVisible(false);
            guestsPage.panel.setVisible(false);
            contactsPage.panel.setVisible(false);
            checklistPage.panel.setVisible(true);
            notesPage.panel.setVisible(false);
        }
        if (event.getSource() == notes){
            homePage.panel.setVisible(false);
            budgetPage.panel.setVisible(false);
            guestsPage.panel.setVisible(false);
            contactsPage.panel.setVisible(false);
            checklistPage.panel.setVisible(false);
            notesPage.panel.setVisible(true);
        }
    }
}