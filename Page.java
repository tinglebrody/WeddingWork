import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// class that holds information every page will use
public class Page{
    // https://www.digitalocean.com/community/tutorials/java-create-new-file
    // windows and mac have different slashes, need to make a slash variable
    String slash = System.getProperty("file.separator");
    // different colors
    // used to keep a simple and consistent color scheme
    Color backgroundColor = new Color(255,255,243);
    Color buttonColor = new Color(229,237,226);
    Color darkButtonColor = new Color(115,118,97);
    // different size fonts
    Font superFont = new Font("serif", Font.PLAIN, 100);
    Font bigFont = new Font("serif", Font.PLAIN, 50);
    Font font = new Font("serif", Font.PLAIN, 20);
    Font smallerFont = new Font("serif", Font.PLAIN, 17);
    Font smallFont = new Font("serif", Font.PLAIN, 14);
    // every page needs a main panel and constraints for the layout
    GridBagConstraints constraints;
    JPanel panel;
    // string that holds the logged in user's username
    static String username;

    // method to set up the main panel of every page
    public void implementPanel(JPanel panel){
        // set the layout and background color
        panel.setLayout(new GridBagLayout());
        panel.setBackground(backgroundColor);
    }
}