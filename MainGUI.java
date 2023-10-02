import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MainGUI implements ActionListener{

    static String page = "Home";
    JMenuBar menubar;
    JMenu homeMenu, budgetMenu, guestsMenu;
    JMenuItem home, budget, guests;
    static JFrame frame;
    static Budget budgetPage;
    static Home homePage;
    static Guests guestsPage;
    static JPanel homePanel;
    static CardLayout manager;
    JTabbedPane tabs;


    public MainGUI() throws IOException{
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        Color menuBarBackgroundColor = new Color(229,237,226);
        Color menuBackgroundColor = new Color(96,107,99);
        Color menuItemBackgroundColor = new Color(96,107,99);
        UIManager.put("MenuBar.background", menuBarBackgroundColor);
        UIManager.put("Menu.background", menuBackgroundColor);
        UIManager.put("MenuItem.background", menuItemBackgroundColor);

        // initializing variables
        frame = new JFrame("Wedding Work");
        homePage = new Home();
        budgetPage = new Budget();
        guestsPage = new Guests();
        homePanel = new JPanel(new CardLayout());


        // menu bar
        menubar = new JMenuBar();
        Color menuBarColor = new Color(190,215,209);
        menubar.setBackground(menuBarColor);
        menubar.setOpaque(false);

        // menus 
        homeMenu = new JMenu("Home");
        budgetMenu = new JMenu("Budget");
        guestsMenu = new JMenu("Guests");

        // items
        home = new JMenuItem("Home");
        budget = new JMenuItem("Budget");
        guests = new JMenuItem("Guests");
        homeMenu.add(home);
        budgetMenu.add(budget);
        guestsMenu.add(guests);

        // add menus to menubar
        menubar.add(homeMenu);
        menubar.add(budgetMenu);
        menubar.add(guestsMenu);

        budget.addActionListener(this);
        home.addActionListener(this);
        guests.addActionListener(this);

        homePanel.add(homePage.panel);
        homePanel.add(budgetPage.panel);
        homePanel.add(guestsPage.panel);
        frame.add(homePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("WeddingWork");
        frame.setJMenuBar(menubar);
        frame.pack();
        frame.setVisible(false);
    }

    public void actionPerformed(ActionEvent event){
        if (event.getSource() == home){
            homePage.panel.setVisible(true);
            budgetPage.panel.setVisible(false);
            guestsPage.panel.setVisible(false);
        }
        if (event.getSource() == budget){
            homePage.panel.setVisible(false);
            budgetPage.panel.setVisible(true);
            guestsPage.panel.setVisible(false);
        }
        if (event.getSource() == guests){
            homePage.panel.setVisible(false);
            budgetPage.panel.setVisible(false);
            guestsPage.panel.setVisible(true);
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException{
    }
}