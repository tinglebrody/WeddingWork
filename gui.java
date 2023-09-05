import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class gui{

    static String page = "MainMenu";
    JMenuBar menubar;
    JMenu mainMenu, budget;
    JMenuItem main, budge;
    static JFrame frame;
    JPanel panel;

    public gui(){
        // menu bar
        menubar = new JMenuBar();
        menubar.setBackground(Color.RED);
        menubar.setOpaque(true);

        // menus 
        mainMenu = new JMenu("Home");
        budget = new JMenu("Budget");
        mainMenu.setBackground(Color.GREEN);
        mainMenu.setOpaque(true);
        budget.setBackground(Color.GREEN);
        budget.setOpaque(true);

        // items
        main = new JMenuItem("Main Menu");
        budge = new JMenuItem("Budget Page");
        mainMenu.add(main);
        budget.add(budge);

        // add menus to menubar
        menubar.add(mainMenu);
        menubar.add(budget);

        class mainMenuAction implements ActionListener{
            public void actionPerformed(ActionEvent e){
                page = "MainMenu";
            }
        }

        class budgetAction implements ActionListener{
            public void actionPerformed(ActionEvent e){
                page = "Budget";
            }
        }

        budge.addActionListener(new budgetAction());
        main.addActionListener(new mainMenuAction());

        frame = new JFrame();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(this.panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My GUI");
        frame.setJMenuBar(menubar);
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) throws InterruptedException{
        gui g = new gui();
        Home home = new Home();
        Budget budget = new Budget();
        frame.add(home.panel);
        frame.add(budget.panel);
        // control loop
        while (1 > 0){
            if (page == "MainMenu"){
                home.panel.setVisible(true);
                budget.panel.setVisible(false);
            }
            if (page == "Budget"){
                home.panel.setVisible(false);
                budget.panel.setVisible(true);
            }
            Thread.sleep(1000);
        }
    }
}