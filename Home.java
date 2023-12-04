import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Home extends Page{

    // constructor for Home
    public Home() throws IOException{
        // declare variables
        JLabel welcomeLabel, usernameLabel, descriptionLabel;

        // create the main panel
        panel = new JPanel();
        // initialize constraints
        constraints = new GridBagConstraints();
        // implement the panel (from Page)
        implementPanel(panel);

        // create welcome label
        welcomeLabel = new JLabel("W E D D I N G    W O R K");
        welcomeLabel.setFont(superFont);
        // create username label
        // using username from Page
        // username is added when the user logs in
        usernameLabel = new JLabel("Welcome " + super.username + "!");
        usernameLabel.setFont(bigFont);
        // label that describes how to use program
        descriptionLabel = new JLabel("Use Navigate to Explore Pages!");
        descriptionLabel.setFont(smallerFont);
        // add everything to the main panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(welcomeLabel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(usernameLabel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(descriptionLabel, constraints);
    }
}