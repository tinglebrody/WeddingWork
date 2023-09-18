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
        homePanel = new JPanel(new CardLayout());

        // menu bar
        menubar = new JMenuBar();
        Color menuBarColor = new Color(190,215,209);
        menubar.setBackground(menuBarColor);
        menubar.setOpaque(false);

        // menus 
        homeMenu = new JMenu("Home");
        budget = new JMenu("Budget");

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
                homePage.panel.setVisible(true);
                budgetPage.panel.setVisible(false);
            }
        }
        class budgetAction implements ActionListener{
            public void actionPerformed(ActionEvent e){
                homePage.panel.setVisible(false);
                budgetPage.panel.setVisible(true);
            }
        }
        budge.addActionListener(new budgetAction());
        home.addActionListener(new homeAction());


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
    }
}