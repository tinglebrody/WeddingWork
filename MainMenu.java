import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainMenu implements ActionListener{
    
int count = 0;
JLabel label;
    public MainMenu(){

        label = new JLabel("How many times you clicked the shit: " + count);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Click This Shit");

        button.addActionListener(this);
        
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My GUI");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new MainMenu();
        System.out.println("Hello!");
    }


    public void actionPerformed(ActionEvent e){
        count++;
        label.setText("How many times you clicked the shit: " + count);
    }
}