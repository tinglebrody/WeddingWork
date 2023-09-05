import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainMenu implements ActionListener{
    
JLabel label;
JPanel panel;
static JFrame frame;
JButton button;

    public MainMenu(){
        label = new JLabel("Hello World");
        frame = new JFrame();
        panel = new JPanel();
        button = new JButton("Go to Budget");

        button.addActionListener(this);
        
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        frame.add(this.panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My GUI");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        MainMenu menu = new MainMenu();
        Budget budget = new Budget();
        JPanel budgetPanel = new JPanel();
        budgetPanel = budget.panel;
        frame.add(budgetPanel);
        menu.panel.setVisible(false);
        budget.panel.setVisible(true);
        System.out.println("Git test");
    }

    public void actionPerformed(ActionEvent e){
        label.setText("Hello New World!");
    }
}