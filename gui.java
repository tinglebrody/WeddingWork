import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
public class gui{

    static String page = "Home";
    JMenuBar menubar;
    JMenu homeMenu, budget;
    JMenuItem home, budge;
    static JFrame frame;
    static Budget budgetPage;
    static Home homePage;
    static JPanel homePanel;
    static CardLayout manager;

    public gui() throws IOException{

        // menu bar
        menubar = new JMenuBar();
        Color menuBarColor = new Color(190,215,209);
        menubar.setBackground(menuBarColor);
        menubar.setOpaque(false);

        // menus 
        homeMenu = new JMenu("Home");
        budget = new JMenu("Budget");
        Color homeMenuColor = new Color(247, 235, 195);
        homeMenu.setBackground(homeMenuColor);
        homeMenu.setOpaque(true);
        Color budgetColor = new Color(248, 225, 231);
        budget.setBackground(budgetColor);
        budget.setOpaque(true);

        // items
        home = new JMenuItem("Home");
        budge = new JMenuItem("Budget Page");
        homeMenu.add(home);
        budget.add(budge);

        // add menus to menubar
        menubar.add(homeMenu);
        menubar.add(budget);

        // actions for buttons
        class homeAction implements ActionListener{
            public void actionPerformed(ActionEvent e){
                page = "Home";
            }
        }
        class budgetAction implements ActionListener{
            public void actionPerformed(ActionEvent e){
                page = "Budget";
            }
        }
        budge.addActionListener(new budgetAction());
        home.addActionListener(new homeAction());

        // initializing variables
        frame = new JFrame();
        homePage = new Home();
        budgetPage = new Budget();
        homePanel = new JPanel(new CardLayout());


        homePanel.add(homePage.panel);
        homePanel.add(budgetPage.panel);
        frame.add(homePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("WeddingWork");
        frame.setJMenuBar(menubar);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) throws InterruptedException, IOException{
        gui g = new gui();
        // control loop
        while (1 > 0){
            if (page == "Home"){
                homePage.panel.setVisible(true);
                budgetPage.panel.setVisible(false);
            }
            if (page == "Budget"){
                homePage.panel.setVisible(false);
                budgetPage.panel.setVisible(true);
            }
            Thread.sleep(500);
        }   
    }
}