import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Login extends Page implements ActionListener, WindowListener{

    private JFrame frame;
    private JPanel loginPanel, joinPanel, loginInputPanel, joinInputPanel;
    private JLabel loginLabel, joinLabel, loginUsernameLabel, loginPasswordLabel, joinUsernameLabel, joinPasswordLabel, loginMessage,
        joinMessage;
    private JTextField loginUsernameInput, loginPasswordInput, joinUsernameInput, joinPasswordInput;
    private JButton loginButton, joinButton, deleteButton;
    private String username, password;
    private MainGUI main;
    private File data;
    private Filer filer;
    private Scanner scan;
    private JSplitPane pane;
    private ArrayList<String> database;

    //https://www.baeldung.com/java-detect-os
    String os = System.getProperty("os.name");

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
        scan = new Scanner(data);
        database = new ArrayList<String>();
        loadData(database, scan);

        pane = new JSplitPane();
        frame = new JFrame("Login");
        frame.addWindowListener(this);

        loginPanel = new JPanel();
        joinPanel = new JPanel();
        implementPanel(loginPanel);
        implementPanel(joinPanel);
        loginPanel.setPreferredSize(new Dimension(200,200));
        joinPanel.setPreferredSize(new Dimension(200,200));
        constraints = new GridBagConstraints();

        loginLabel = new JLabel("LOGIN");
        loginLabel.setFont(smallerFont);
        loginLabel.setBackground(backgroundColor);

        loginInputPanel = new JPanel(new GridLayout(2,2));
        loginInputPanel.setBackground(backgroundColor);

        loginButton = new JButton("Login");
        loginButton.setFont(smallerFont);
        loginButton.setBackground(buttonColor);
        loginButton.addActionListener(this);

        loginUsernameLabel = new JLabel("Username");
        loginUsernameLabel.setFont(smallerFont);
        loginUsernameInput = new JTextField("");
        loginUsernameInput.setFont(smallerFont);
        loginPasswordLabel = new JLabel("Password");
        loginPasswordLabel.setFont(smallerFont);
        loginPasswordInput = new JTextField("");
        loginPasswordInput.setFont(smallerFont);

        loginMessage = new JLabel("");
        loginMessage.setFont(smallerFont);
        loginMessage.setBackground(backgroundColor);

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
        constraints.gridx = 0;
        constraints.gridy = 3;
        loginPanel.add(loginMessage, constraints);

        joinLabel = new JLabel("JOIN");
        joinLabel.setFont(smallerFont);
        joinLabel.setBackground(backgroundColor);

        joinInputPanel = new JPanel(new GridLayout(2,2));
        joinInputPanel.setBackground(backgroundColor);

        joinUsernameLabel = new JLabel("Username");
        joinUsernameLabel.setFont(smallerFont);
        joinUsernameInput = new JTextField("");
        joinUsernameInput.setFont(smallerFont);
        joinPasswordLabel = new JLabel("Password");
        joinPasswordLabel.setFont(smallerFont);
        joinPasswordInput = new JTextField("");
        joinPasswordInput.setFont(smallerFont);

        joinButton = new JButton("Join");
        joinButton.setBackground(buttonColor);
        joinButton.setFont(smallerFont);
        joinButton.addActionListener(this);

        deleteButton = new JButton("Delete Account");
        deleteButton.setFont(smallerFont);
        deleteButton.setBackground(darkButtonColor);
        deleteButton.setForeground(Color.white);
        deleteButton.addActionListener(this);

        joinMessage = new JLabel("");
        joinMessage.setFont(smallerFont);
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

    private void loadData(ArrayList<String> list, Scanner scan){
        while (true){
            try{
                list.add(scan.nextLine());
            }
            catch(NoSuchElementException e){
                break;
            }
        }
    }

    private void writeData(ArrayList<String> list){
        String addToFile = "";
        for (String element : list){
            addToFile = addToFile + element + "\n";
        }
        try{
            filer.toFile(addToFile);
        }
        catch(IOException e){}
    }
    private boolean exists(String username) throws FileNotFoundException{
        String testUsername;
        scan = new Scanner(data);
        for (String element : database){
            if (element.compareTo(username) == 0){
                return true;
            }
        }
        return false;
    }
    private boolean validate(String username, String password) throws FileNotFoundException{
        String testUsername;
        scan = new Scanner(data);
        for (int i = 0; i < database.size(); i++){
            if (database.get(i).compareTo(username) == 0){
                if (database.get(i+1).compareTo(password) == 0){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean deleteUser(String username, String password) throws FileNotFoundException{
        if (validate(username, password)){
            int index = database.indexOf(username);
            database.remove(username);
            database.remove(index);
            return true;
        }
        return false;
    }

    private void createFiles(String username){
        // https://www.digitalocean.com/community/tutorials/java-create-new-file
        String slash = System.getProperty("file.separator");
        try{
            new File("data" + slash + username + "Data").mkdir();
            new File("data" + slash + username + "Data" + slash + username + "BudgetData.txt").createNewFile();
            new File("data" + slash + username + "Data" + slash + username + "GuestsData.txt").createNewFile();
            new File("data" + slash + username + "Data" + slash + username + "ContactsData.txt").createNewFile();
            new File("data" + slash + username + "Data" + slash + username + "ChecklistData.txt").createNewFile();
            new File("data" + slash + username + "Data" + slash + username + "NotesData.txt").createNewFile();
        }
        catch(IOException e){System.out.println("Error when creating files!");}

        Filer filer;
        String budgetString = "0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0";
        filer = new Filer("data/"+username+"Data/"+username+"BudgetData.txt");
        try{filer.toFile(budgetString);}
        catch(IOException e){System.out.println("Error when adding Data!");}

        String guestsString = "Break\nBreak\nBreak\nBreak\nBreak\nBreak\n";
        filer = new Filer("data/"+username+"Data/"+username+"GuestsData.txt");
        try{filer.toFile(guestsString);}
        catch(IOException e){System.out.println("Error!");}

        String contactsString = "Break\n";
        filer = new Filer("data/"+username+"Data/"+username+"ContactsData.txt");
        try{filer.toFile(contactsString);}
        catch(IOException e){System.out.println("Error!");}

        String checklistString = "Break\n";
        filer = new Filer("data/"+username+"Data/"+username+"ChecklistData.txt");
        try{filer.toFile(checklistString);}
        catch(IOException e){System.out.println("Error!");}

        String notesString = "";
        filer = new Filer("data/"+username+"Data/"+username+"NotesData.txt");
        try{filer.toFile(notesString);}
        catch(IOException e){System.out.println("Error!");}
    }

    private void deleteFiles(String username){
        String slash = System.getProperty("file.separator");
        new File("data" + slash + username + "Data" + slash + username + "BudgetData.txt").delete();
        new File("data" + slash + username + "Data" + slash + username + "GuestsData.txt").delete();
        new File("data" + slash + username + "Data" + slash + username + "ContactsData.txt").delete();
        new File("data" + slash + username + "Data" + slash + username + "ChecklistData.txt").delete();
        new File("data" + slash + username + "Data" + slash + username + "NotesData.txt").delete();
        new File("data" + slash + username + "Data").delete();
    }

    public void windowClosing(WindowEvent e) {
            writeData(database);
    }
    public void windowClosed(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

    public void actionPerformed(ActionEvent event){
        if (event.getSource() == loginButton){
            try{
                boolean checkInput = validate("Username " + loginUsernameInput.getText(), "Password " + loginPasswordInput.getText());
                if (checkInput == true){
                    super.username = loginUsernameInput.getText();
                    writeData(database);
                    try{
                        main = new MainGUI();
                    }
                    catch(IOException e){System.out.println("Error from login line 208!");}
                    main.frame.setVisible(true);
                    frame.setVisible(false);
                }
                else{
                    loginMessage.setText("Invalid username/password");
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
                    database.add("Username " + joinUsernameInput.getText());
                    database.add("Password " + joinPasswordInput.getText());
                    createFiles(joinUsernameInput.getText());
                    joinMessage.setText("User added!");
                    joinUsernameInput.setText("");
                    joinPasswordInput.setText("");
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
                    joinMessage.setText("Invalid username/password");
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