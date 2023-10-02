import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
public class Home implements ActionListener{

JPanel panel;
JLabel homeLabel, welcomeLabel, photo;
JButton button;

    public Home() throws IOException{

        welcomeLabel = new JLabel("Welcome to WeddingWork!");
        homeLabel = new JLabel("Home");
        button = new JButton("Click to accomplish (almost) nothing");
        Color buttonColor = new Color(255,255,245);
        button.setBackground(buttonColor);
        panel = new JPanel();
        panel.setBackground(buttonColor);

        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(600,600,500,500));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(homeLabel);
        panel.add(welcomeLabel);
        panel.add(button);
        panel.setVisible(false);
    }

    public void actionPerformed(ActionEvent e){
        homeLabel.setText("Home Page");
    }
}