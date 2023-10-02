import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.*;
public class Login extends Page implements ActionListener{

    JFrame frame;
    JPanel loginPanel, joinPanel, loginInputPanel, joinInputPanel;
    JLabel loginLabel, joinLabel, loginUsernameLabel, loginPasswordLabel, joinUsernameLabel, joinPasswordLabel, passwordMessage,
        joinMessage;
    JTextField loginUsernameInput, loginPasswordInput, joinUsernameInput, joinPasswordInput;
    JButton loginButton, joinButton, deleteButton;
    String username, password;
    MainGUI main;
    File data;
    Filer filer;
    Scanner scan;
    JSplitPane pane;
    ArrayList<String> fileContents;

    public Login() throws FileNotFoundException{
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        data = new File("data/loginData.txt");
        filer = new Filer("data/loginData.txt");

        pane = new JSplitPane();
        frame = new JFrame("Login");

        loginPanel = new JPanel();
        joinPanel = new JPanel();
        implementPanel(loginPanel);
        implementPanel(joinPanel);
        constraints = new GridBagConstraints();

        loginLabel = new JLabel("LOGIN");
        loginLabel.setBackground(backgroundColor);

        loginInputPanel = new JPanel(new GridLayout(2,2));
        loginInputPanel.setBackground(backgroundColor);

        loginButton = new JButton("Login");
        loginButton.setBackground(buttonColor);
        loginButton.addActionListener(this);

        loginUsernameLabel = new JLabel("Username");
        loginUsernameInput = new JTextField("");
        loginPasswordLabel = new JLabel("Password");
        loginPasswordInput = new JTextField("");

        loginInputPanel.add(loginUsernameLabel);
        loginInputPanel.add(loginUsernameInput);
        loginInputPanel.add(loginPasswordLabel);
        loginInputPanel.add(loginPasswordInput);

        constraints.gridx = 0;
        constraints.gridy = 0;
        loginPanel.add(loginLabel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        loginPanel.add(loginInputPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        loginPanel.add(loginButton, constraints);

        joinLabel = new JLabel("JOIN");
        joinLabel.setBackground(backgroundColor);

        joinInputPanel = new JPanel(new GridLayout(2,2));
        joinInputPanel.setBackground(backgroundColor);

        joinUsernameLabel = new JLabel("Username");
        joinUsernameInput = new JTextField("");
        joinPasswordLabel = new JLabel("Password");
        joinPasswordInput = new JTextField("");

        joinButton = new JButton("Join");
        joinButton.setBackground(buttonColor);
        joinButton.addActionListener(this);

        deleteButton = new JButton("Delete Account");
        deleteButton.setBackground(darkButtonColor);
        deleteButton.setForeground(Color.white);
        deleteButton.addActionListener(this);

        joinMessage = new JLabel("");
        joinMessage.setBackground(backgroundColor);
        joinMessage.setVisible(true);

        joinInputPanel.add(joinUsernameLabel);
        joinInputPanel.add(joinUsernameInput);
        joinInputPanel.add(joinPasswordLabel);
        joinInputPanel.add(joinPasswordInput);

        constraints.gridx = 0;
        constraints.gridy = 0;
        joinPanel.add(joinLabel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        joinPanel.add(joinInputPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        joinPanel.add(joinButton, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        joinPanel.add(deleteButton, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        joinPanel.add(joinMessage, constraints);

        pane.setLeftComponent(loginPanel);
        pane.setRightComponent(joinPanel);
        frame.add(pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public boolean exists(String username) throws FileNotFoundException{
        String testUsername;
        scan = new Scanner(data);
        while (true)
            try{
                testUsername = scan.nextLine();
                if (username.compareTo(testUsername) == 0){
                    return true;
                }
            }
            catch(NoSuchElementException e){
                break;
            }
        return false;
    }
    public boolean validate(String username, String password) throws FileNotFoundException{
        String testUsername;
        scan = new Scanner(data);
        while (true)
            try{
                testUsername = scan.nextLine();
                if (username.compareTo(testUsername) == 0){
                    if (password.compareTo(scan.nextLine()) == 0){
                        return true;
                    }
                }
            }
            catch(NoSuchElementException e){
                break;
            }
        return false;
    }


    public boolean deleteUser(String username, String password) throws FileNotFoundException{
        String fileContents = "", test;
        int count = 0;
        scan = new Scanner(data);
        if (validate("Username " + joinUsernameInput.getText(), "Password " + joinPasswordInput.getText())){
            while (true){
                try{
                    test = scan.nextLine();
                    if (test.compareTo(username) != 0 && test.compareTo(password) != 0){
                        fileContents = fileContents + test + "\n";
                    }
                }
                catch(NoSuchElementException e){
                    break;
                }
            }
            try{filer.toFile(fileContents);}
            catch(IOException e){}
            return true;
        }
        else{
            return false;
        }
    }

    public void createFiles(String username){
        String command = "";
        try{
            command = "mkdir data/" + username + "Data";
            Runtime.getRuntime().exec(command);
            command = "touch data/" + username + "Data/" + username + "BudgetData.txt";
            Runtime.getRuntime().exec(command);
            command = "touch data/" + username + "Data/" + username + "GuestsData.txt";
            Runtime.getRuntime().exec(command);
        }
        catch(IOException e){System.out.println("Error!");}
        Filer filer;
        String budgetString = "0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0";
        filer = new Filer("data/"+username+"Data/"+username+"BudgetData.txt");
        try{filer.toFile(budgetString);}
        catch(IOException e){System.out.println("Error!");}

        String guestsString = "Break\nBreak\nBreak\nBreak\nBreak\nBreak\n";
        filer = new Filer("data/"+username+"Data/"+username+"GuestsData.txt");
        try{filer.toFile(guestsString);}
        catch(IOException e){System.out.println("Error!");}
    }

    public void deleteFiles(String username){
        String command = "rm -r data/"+username+"Data";
        try{
            Runtime.getRuntime().exec(command);
        }
        catch(IOException e){System.out.println("Error!");}
    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == loginButton){
            try{
                boolean checkInput = validate("Username " + loginUsernameInput.getText(), "Password " + loginPasswordInput.getText());
                if (checkInput == true){
                    super.username = loginUsernameInput.getText();
                    try{
                        main = new MainGUI();
                    }
                    catch(IOException e){System.out.println("Error from login line 208!");}
                    main.frame.setVisible(true);
                    frame.setVisible(false);
                }
            }
            catch(FileNotFoundException e){}
        }
        if (event.getSource() == joinButton){
            try{
                if (exists("Username " + joinUsernameInput.getText())){
                    joinMessage.setText("Username already exists!");
                }
                else{
                    filer.toFile("\nUsername " + joinUsernameInput.getText() + "\nPassword " + joinPasswordInput.getText(), true);
                    createFiles(joinUsernameInput.getText());
                    joinMessage.setText("User added!");
                }
            }
            catch (IOException e){}
        }
        if (event.getSource() == deleteButton){
            boolean worked;
            try{
                worked = deleteUser("Username " + joinUsernameInput.getText(), "Password " + joinPasswordInput.getText());
                if (worked){
                    joinMessage.setText("Account Deleted");
                    deleteFiles(joinUsernameInput.getText());
                }
                else{
                    joinMessage.setText("Incorrect username/password");
                }
            }
            catch(FileNotFoundException e){}
        }
    }

    public static void main(String[] args){
        try{Login login = new Login();}
        catch(FileNotFoundException e){}
    }
}