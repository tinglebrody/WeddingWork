import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
public class Budget implements ActionListener{
    
int count = 0;
JLabel label;
JPanel panel;
JButton button;

    public Budget(){

        label = new JLabel("Dollars: $" + count);
        button = new JButton("Budget");

        button.addActionListener(this);
        Color buttonColor = new Color(248, 209, 224);
        button.setBackground(buttonColor);
        panel = new JPanel();
        panel.setBackground(buttonColor);
        panel.setBorder(BorderFactory.createEmptyBorder(150,150,150,150));
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