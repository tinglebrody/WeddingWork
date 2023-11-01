import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
public class Home extends Page implements ActionListener{

JLabel welcomeLabel, usernameLabel;

    public Home() throws IOException{
        panel = new JPanel();
        constraints = new GridBagConstraints();
        implementPanel(panel);

        welcomeLabel = new JLabel("W E D D I N G    W O R K");
        welcomeLabel.setFont(superFont);
        usernameLabel = new JLabel("Welcome " + super.username + "!");
        usernameLabel.setFont(bigFont);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(welcomeLabel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(usernameLabel, constraints);
    }

    public void actionPerformed(ActionEvent e){
        
    }
}