import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class gui{

    static String page = "MainMenu";
    JMenuBar menubar;
    JMenu homeMenu, budget;
    JMenuItem home, budge;
    static JFrame frame;
    JPanel panel;

    public gui(){
        // menu bar
        menubar = new JMenuBar();
        menubar.setBackground(Color.RED);
        menubar.setOpaque(true);

        // menus 
        homeMenu = new JMenu("Home");
        budget = new JMenu("Budget");
        homeMenu.setBackground(Color.GREEN);
        homeMenu.setOpaque(true);
        budget.setBackground(Color.GREEN);
        budget.setOpaque(true);

        // items
        home = new JMenuItem("Home");
        budge = new JMenuItem("Budget Page");
        homeMenu.add(home);
        budget.add(budge);

        // add menus to menubar
        menubar.add(homeMenu);
        menubar.add(budget);

        class homeAction implements ActionListener{
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
        home.addActionListener(new homeAction());

        frame = new JFrame();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(this.panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("WeddingWork");
        frame.setJMenuBar(menubar);
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) throws InterruptedException{
        gui g = new gui();
        Home home = new Home();
        Budget budget = new Budget();
        JPanel main = new JPanel();
        main.add(home.panel);
        main.add(budget.panel);
        frame.add(main);
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
            Thread.sleep(500);
        }
    }
}