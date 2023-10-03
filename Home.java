import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
public class Home extends Page implements ActionListener{

JLabel welcomeLabel;

    public Home() throws IOException{
        panel = new JPanel();
        constraints = new GridBagConstraints();
        implementPanel(panel);

        welcomeLabel = new JLabel("Welcome " + super.username + "!");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(welcomeLabel, constraints);
    }

    public void actionPerformed(ActionEvent e){
        
    }
}