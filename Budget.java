import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
public class Budget implements ActionListener{
    
int count = 0;
int totalBudget;
JLabel totalBudgetLabel;
JPanel panel;
JTextField totalBudgetInput;
JButton button;

    public Budget(){

        totalBudgetLabel = new JLabel("Total Budget: $" + totalBudget);
        button = new JButton("Enter");
        totalBudgetInput = new JTextField();
        totalBudgetInput.setPreferredSize(new Dimension(80,40));

        button.addActionListener(this);
        Color buttonColor = new Color(248, 209, 224);
        button.setBackground(buttonColor);
        button.setPreferredSize(new Dimension(80,40));
        panel = new JPanel();
        panel.setBackground(buttonColor);
        panel.setBorder(BorderFactory.createEmptyBorder(300,300,300,300));
        panel.setLayout(new FlowLayout());
        panel.add(totalBudgetLabel);
        panel.add(totalBudgetInput);
        panel.add(button);
        panel.setVisible(false);
    }
    public static void main(String[] args){
    }

    public void actionPerformed(ActionEvent e){
        totalBudgetLabel.setText("Total Budget: " + totalBudgetInput.getText());
    }
}