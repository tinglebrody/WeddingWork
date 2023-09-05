import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Budget implements ActionListener{
    
int count = 0;
JLabel label;
JPanel panel;
JButton button;

    public Budget(){

        label = new JLabel("Dollars: $" + count);
        panel = new JPanel();
        button = new JButton("Budget");

        button.addActionListener(this);
        
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        panel.setVisible(false);
    }
    public static void main(String[] args){
        
    }

    public void actionPerformed(ActionEvent e){
        count++;
        label.setText("Dollars: $" + count);
    }
}