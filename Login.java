import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
public class Login implements ActionListener{

    JFrame loginFrame;
    JPanel panel, inputPanel;
    JLabel loginLabel, joinLabel, usernameLabel, passwordLabel;
    JTextField usernameInput, passwordInput;
    JButton loginButton, joinButton;
    String username, password;
    MainGUI main;
    Join join;
    File data;
    Scanner scan;

    public Login() throws FileNotFoundException{
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        try{
            main = new MainGUI();
        }
        catch(IOException e){System.out.println("Error!");}

        data = new File("data/loginData.txt");

        loginFrame = new JFrame("Login");
        panel = new JPanel();
        Color backgroundColor = new Color(255,255,243);
        Color buttonColor = new Color(229,237,226);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        panel.setBackground(backgroundColor);
        panel.setBorder(BorderFactory.createEmptyBorder(500,500,500,500));
        panel.setMinimumSize(new Dimension(600,600));
        panel.setPreferredSize(new Dimension(600,600));

        inputPanel = new JPanel(new GridLayout(2,2));
        inputPanel.setBackground(backgroundColor);

        loginButton = new JButton("Login");
        loginButton.setBackground(buttonColor);
        loginButton.addActionListener(this);

        joinButton = new JButton("Join");
        joinButton.setBackground(buttonColor);
        joinButton.addActionListener(this);

        usernameLabel = new JLabel("Username");
        usernameInput = new JTextField("");
        passwordLabel = new JLabel("Password");
        passwordInput = new JTextField("");

        inputPanel.add(usernameLabel);
        inputPanel.add(usernameInput);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordInput);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(inputPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(loginButton, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(joinButton, constraints);

        loginFrame.add(panel);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.pack();
        loginFrame.setVisible(true);
    }

    public boolean validate(String username, String password) throws FileNotFoundException{
        String testUsername, testPassword;
        scan = new Scanner(data);
        while (true){
            testUsername = scan.nextLine();
            if (testUsername.compareTo("Break") == 0){
                break;
            }
            if (username.compareTo(testUsername) == 0){
                if (password.compareTo(scan.nextLine()) == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public void actionPerformed(ActionEvent event){
        if (event.getSource() == loginButton){
            try{
                boolean checkInput = validate("Username " + usernameInput.getText(), "Password " + passwordInput.getText());
                if (checkInput == true){
                    main.frame.setVisible(true);
                    loginFrame.setVisible(false);
                }
            }
            catch(FileNotFoundException e){}
        }
        if (event.getSource() == joinButton){
            try{join = new Join();}
            catch(FileNotFoundException e){}

            join.frame.setVisible(true);
            loginFrame.setVisible(false);
        }
    }

    public static void main(String[] args){
        try{Login login = new Login();}
        catch(FileNotFoundException e){}
    }
}