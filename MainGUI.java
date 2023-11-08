import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MainGUI extends Page implements ActionListener, WindowListener{

    private static String page = "Home";
    private JMenuBar menubar;
    private JMenu navigate;
    private JMenuItem home, budget, guests, contacts, checklist;
    public static JFrame frame;
    private static Budget budgetPage;
    private static Home homePage;
    private static Guests guestsPage;
    private static Contacts contactsPage;
    private static Checklist checklistPage;
    private static JPanel homePanel;
    private static CardLayout manager;


    public MainGUI() throws IOException{
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

        // initializing variables
        frame = new JFrame("Wedding Work");
        homePage = new Home();
        budgetPage = new Budget();
        guestsPage = new Guests();
        contactsPage = new Contacts();
        checklistPage = new Checklist();
        homePanel = new JPanel(new CardLayout());

        frame.addWindowListener(this);

        // menu bar
        menubar = new JMenuBar();
        menubar.setBackground(buttonColor);
        menubar.setOpaque(true);

        // menus 
        navigate = new JMenu("Navigate");
        navigate.setFont(smallerFont);

        // items
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
        navigate.add(home);
        navigate.add(budget);
        navigate.add(guests);
        navigate.add(contacts);
        navigate.add(checklist);

        home.setBackground(buttonColor);
        home.setForeground(Color.black);
        home.setOpaque(true);
        budget.setBackground(buttonColor);
        budget.setOpaque(true);
        guests.setBackground(buttonColor);
        guests.setOpaque(true);
        contacts.setBackground(buttonColor);
        contacts.setOpaque(true);

        // add menus to menubar
        menubar.add(navigate);

        budget.addActionListener(this);
        home.addActionListener(this);
        guests.addActionListener(this);
        contacts.addActionListener(this);
        checklist.addActionListener(this);

        homePanel.add(homePage.panel);
        homePanel.add(budgetPage.panel);
        homePanel.add(guestsPage.panel);
        homePanel.add(contactsPage.panel);
        homePanel.add(checklistPage.panel);
        frame.add(homePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("WeddingWork");
        frame.setJMenuBar(menubar);
        frame.setSize(new Dimension(1300,1000));
        frame.setVisible(false);
    }

    public void windowClosing(WindowEvent event) {
        try{
            System.out.println("Autosaved!");
            budgetPage.saveAction();
            guestsPage.saveAction();
            contactsPage.saveAction();
            checklistPage.saveAction();
        }
        catch (IOException e){}
    }
    public void windowClosed(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == home){
            homePage.panel.setVisible(true);
            budgetPage.panel.setVisible(false);
            guestsPage.panel.setVisible(false);
            contactsPage.panel.setVisible(false);
            checklistPage.panel.setVisible(false);
        }
        if (event.getSource() == budget){
            homePage.panel.setVisible(false);
            budgetPage.panel.setVisible(true);
            guestsPage.panel.setVisible(false);
            contactsPage.panel.setVisible(false);
            checklistPage.panel.setVisible(false);
        }
        if (event.getSource() == guests){
            homePage.panel.setVisible(false);
            budgetPage.panel.setVisible(false);
            guestsPage.panel.setVisible(true);
            contactsPage.panel.setVisible(false);
            checklistPage.panel.setVisible(false);
        }
        if (event.getSource() == contacts){
            homePage.panel.setVisible(false);
            budgetPage.panel.setVisible(false);
            guestsPage.panel.setVisible(false);
            contactsPage.panel.setVisible(true);
            checklistPage.panel.setVisible(false);
        }
        if (event.getSource() == checklist){
            homePage.panel.setVisible(false);
            budgetPage.panel.setVisible(false);
            guestsPage.panel.setVisible(false);
            contactsPage.panel.setVisible(false);
            checklistPage.panel.setVisible(true);
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException{
    }
}