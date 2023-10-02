import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
public class Join implements ActionListener{

    JFrame frame;
    JPanel panel, inputPanel;
    JLabel loginLabel, joinLabel, usernameLabel, passwordOneLabel, passwordTwoLabel;
    JTextField usernameInput, passwordOneInput, passwordTwoInput;
    JButton joinButton, loginButton;
    String username, passwordOne, passwordTwo;
    File data;
    Filer filer;

    public Join() throws FileNotFoundException{
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        filer = new Filer("data/loginData.txt");

        frame = new JFrame("Login");
        panel = new JPanel();
        Color backgroundColor = new Color(255,255,243);
        Color buttonColor = new Color(229,237,226);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        panel.setBackground(backgroundColor);
        panel.setBorder(BorderFactory.createEmptyBorder(500,500,500,500));
        panel.setMinimumSize(new Dimension(600,600));
        panel.setPreferredSize(new Dimension(600,600));

        inputPanel = new JPanel(new GridLayout(4,2));
        inputPanel.setBackground(backgroundColor);

        usernameLabel = new JLabel("Username");
        usernameInput = new JTextField("");
        passwordOneLabel = new JLabel("Password");
        passwordOneInput = new JTextField("");
        passwordTwoLabel = new JLabel("Password");
        passwordTwoInput = new JTextField("");

        joinButton = new JButton("Join");
        joinButton.setBackground(buttonColor);
        joinButton.addActionListener(this);

        loginButton = new JButton("Back to Login");
        loginButton.setBackground(buttonColor);
        loginButton.addActionListener(this);

        inputPanel.add(usernameLabel);
        inputPanel.add(usernameInput);
        inputPanel.add(passwordOneLabel);
        inputPanel.add(passwordOneInput);
        inputPanel.add(passwordTwoLabel);
        inputPanel.add(passwordTwoInput);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(inputPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(joinButton, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(loginButton, constraints);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
    }


    public void actionPerformed(ActionEvent event){
        if (event.getSource() == joinButton){
            if (passwordOneInput.getText() == passwordTwoInput.getText()){
                String addToFile = usernameInput.getText() + "\n" + passwordOneInput.getText();
                try{filer.toFile(addToFile, true);}
                catch(IOException e){}
            }
        } 
    }
}