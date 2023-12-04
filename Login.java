import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

// Login and Signup class
public class Login extends Page implements ActionListener, WindowListener{
    // declaring variables
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

    public Login() throws FileNotFoundException{
        // use the UIManager to set the look
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        // creating filer (writing) and scanner (reading)
        data = new File("data/loginData.txt");
        filer = new Filer("data/loginData.txt");
        scan = new Scanner(data);
        // create the "database" that will hold usernames and passwords
        database = new ArrayList<String>();
        // load the data into the database using the scanner
        loadData(database, scan);

        // JSplitPane to create a two sided panel
        pane = new JSplitPane();
        // main frame
        frame = new JFrame("Login");
        // window listener to detect closing
        frame.addWindowListener(this);

        // panels for login and join
        loginPanel = new JPanel();
        joinPanel = new JPanel();
        // implement the panel (method from Page)
        implementPanel(loginPanel);
        implementPanel(joinPanel);
        // configuring panel size
        loginPanel.setPreferredSize(new Dimension(200,200));
        joinPanel.setPreferredSize(new Dimension(200,200));
        // initialize the constraints
        constraints = new GridBagConstraints();

        // create the title for the login panel
        loginLabel = new JLabel("LOGIN");
        loginLabel.setFont(smallerFont);
        loginLabel.setBackground(backgroundColor);

        // create the panel where input boxes will be held
        loginInputPanel = new JPanel(new GridLayout(2,2));
        loginInputPanel.setBackground(backgroundColor);

        // create the button to attempt login
        loginButton = new JButton("Login");
        loginButton.setFont(smallerFont);
        loginButton.setBackground(buttonColor);
        loginButton.addActionListener(this);

        // username label
        loginUsernameLabel = new JLabel("Username");
        loginUsernameLabel.setFont(smallerFont);
        // username input text box
        loginUsernameInput = new JTextField("");
        loginUsernameInput.setFont(smallerFont);
        // password label
        loginPasswordLabel = new JLabel("Password");
        loginPasswordLabel.setFont(smallerFont);
        // password input text box
        loginPasswordInput = new JTextField("");
        loginPasswordInput.setFont(smallerFont);

        // message that shows "invalid login information"
        // on a failed login attempt
        loginMessage = new JLabel("");
        loginMessage.setFont(smallerFont);
        loginMessage.setBackground(backgroundColor);

        // add everything to the input panel
        loginInputPanel.add(loginUsernameLabel);
        loginInputPanel.add(loginUsernameInput);
        loginInputPanel.add(loginPasswordLabel);
        loginInputPanel.add(loginPasswordInput);

        // add everything to the main login panel
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

        // title for the join section of the frame
        joinLabel = new JLabel("JOIN");
        joinLabel.setFont(smallerFont);
        joinLabel.setBackground(backgroundColor);

        // input panel for the join section
        joinInputPanel = new JPanel(new GridLayout(2,2));
        joinInputPanel.setBackground(backgroundColor);

        // username label
        joinUsernameLabel = new JLabel("Username");
        joinUsernameLabel.setFont(smallerFont);
        // username input
        joinUsernameInput = new JTextField("");
        joinUsernameInput.setFont(smallerFont);
        // username label
        joinPasswordLabel = new JLabel("Password");
        joinPasswordLabel.setFont(smallerFont);
        // username input
        joinPasswordInput = new JTextField("");
        joinPasswordInput.setFont(smallerFont);

        // button to attempt to create an account
        joinButton = new JButton("Join");
        joinButton.setBackground(buttonColor);
        joinButton.setFont(smallerFont);
        joinButton.addActionListener(this);

        // button to delete an account
        deleteButton = new JButton("Delete Account");
        deleteButton.setFont(smallerFont);
        deleteButton.setBackground(darkButtonColor);
        deleteButton.setForeground(Color.white);
        deleteButton.addActionListener(this);

        // message that tells the user if their action
        // was suceessful/failed
        joinMessage = new JLabel("");
        joinMessage.setFont(smallerFont);
        joinMessage.setBackground(backgroundColor);
        joinMessage.setVisible(true);
        
        // add everything to the input panel
        joinInputPanel.add(joinUsernameLabel);
        joinInputPanel.add(joinUsernameInput);
        joinInputPanel.add(joinPasswordLabel);
        joinInputPanel.add(joinPasswordInput);

        // add everything to the main join panel
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

        // set the left and right components of the split pane
        pane.setLeftComponent(loginPanel);
        pane.setRightComponent(joinPanel);
        // add the split pane to the frame
        frame.add(pane);
        // configure the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // function to load lines of a text file into an arraylist
    private void loadData(ArrayList<String> list, Scanner scan){
        // infinite loop
        while (true){
            // add lines to the list
            try{
                list.add(scan.nextLine());
            }
            // if it every fails and throws an exception,
            // break the loop
            catch(NoSuchElementException e){
                break;
            }
        }
    }

    // function to write the login data to the database
    // entire array list is passed as
    private void writeData(ArrayList<String> list){
        // create a string that will be added to the file
        String addToFile = "";
        for (String element : list){
            // add every element to the file with a new line character
            // at the end of every line
            addToFile = addToFile + element + "\n";
        }
        try{
            // write the complete string to the file
            // toFile from the Filer class
            filer.toFile(addToFile);
        }
        catch(IOException e){}
    }

    // method to find a username
    private boolean exists(String username) throws FileNotFoundException{
        // loop through every element in the arraylist
        for (String element : database){
            // if the element matches the username
            if (element.compareTo(username) == 0){
                return true;
            }
        }
        return false;
    }

    // method to validate a username and password
    private boolean validate(String username, String password) throws FileNotFoundException{
        // loop through the database
        for (int i = 0; i < database.size(); i++){
            // if the element in the database matches the username
            if (database.get(i).compareTo(username) == 0){
                // if the next element in the database matches the password
                if (database.get(i+1).compareTo(password) == 0){
                    return true;
                }
            }
        }
        // if never found, return false
        return false;
    }

    // method to delete a user from the database
    private boolean deleteUser(String username, String password) throws FileNotFoundException{
        // if the username and password are validated
        if (validate(username, password)){
            // get the index of the username
            int index = database.indexOf(username);
            // remove the username
            database.remove(username);
            // remove the password
            database.remove(index);
            // indicate success
            return true;
        }
        return false;
    }

    // method to create a user's files in the local system
    // called when a user is created
    private void createFiles(String username){
        try{
            // create the user's folder
            new File("data" + slash + username + "Data").mkdir();
            // create a text file for each page that holds data
            new File("data" + slash + username + "Data" + slash + username + "BudgetData.txt").createNewFile();
            new File("data" + slash + username + "Data" + slash + username + "GuestsData.txt").createNewFile();
            new File("data" + slash + username + "Data" + slash + username + "ContactsData.txt").createNewFile();
            new File("data" + slash + username + "Data" + slash + username + "ChecklistData.txt").createNewFile();
            new File("data" + slash + username + "Data" + slash + username + "NotesData.txt").createNewFile();
        }
        catch(IOException e){System.out.println("Error when creating files!");}

        // declare a filer
        Filer filer;

        // string that will be added to the budget text file
        String budgetString = "0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n0";
        // add the string to the file
        filer = new Filer("data/"+username+"Data/"+username+"BudgetData.txt");
        try{filer.toFile(budgetString);}
        catch(IOException e){System.out.println("Error when adding Data!");}

        // string that will be added to the guests text file
        String guestsString = "Break\nBreak\nBreak\nBreak\nBreak\nBreak\n";
        // add the string to the file
        filer = new Filer("data/"+username+"Data/"+username+"GuestsData.txt");
        try{filer.toFile(guestsString);}
        catch(IOException e){System.out.println("Error!");}

        // string that will be added to the contacts text file
        String contactsString = "Break\n";
        filer = new Filer("data/"+username+"Data/"+username+"ContactsData.txt");
        // add the string to the file
        try{filer.toFile(contactsString);}
        catch(IOException e){System.out.println("Error!");}

        // string that will be added to the checklist text file
        String checklistString = "Break\n";
        // add the string to the file
        filer = new Filer("data/"+username+"Data/"+username+"ChecklistData.txt");
        try{filer.toFile(checklistString);}
        catch(IOException e){System.out.println("Error!");}

        // string that will be added to the notes text file
        String notesString = "";
        // add the string to the file
        filer = new Filer("data/"+username+"Data/"+username+"NotesData.txt");
        try{filer.toFile(notesString);}
        catch(IOException e){System.out.println("Error!");}
    }

    // method to delete a user's files
    // called when they delete their account
    private void deleteFiles(String username){
        // delete the individual files
        new File("data" + slash + username + "Data" + slash + username + "BudgetData.txt").delete();
        new File("data" + slash + username + "Data" + slash + username + "GuestsData.txt").delete();
        new File("data" + slash + username + "Data" + slash + username + "ContactsData.txt").delete();
        new File("data" + slash + username + "Data" + slash + username + "ChecklistData.txt").delete();
        new File("data" + slash + username + "Data" + slash + username + "NotesData.txt").delete();
        // a directory can only be deleted once it is empty
        // after every file has been deleted, delete the folder
        new File("data" + slash + username + "Data").delete();
    }

    // function called when the window is closed
    public void windowClosing(WindowEvent e) {
        // write the data to the loginData text file
        writeData(database);
    }
    public void windowClosed(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

    // function that detects button clicks
    public void actionPerformed(ActionEvent event){
        // if the event comes from the login button
        if (event.getSource() == loginButton){
            try{
                // validate the username and password that have inputted
                boolean checkInput = validate("Username " + loginUsernameInput.getText(), "Password " + loginPasswordInput.getText());
                // if the input is validated
                if (checkInput == true){
                    // set the username in the Page class to the inputted username
                    super.username = loginUsernameInput.getText();
                    // add login info to the loginData file
                    writeData(database);
                    // create a new MainGUI
                    // this holds all the pages
                    try{
                        main = new MainGUI();
                    }
                    catch(IOException e){System.out.println("Error from login line 208!");}
                    // set the MainGUI frame visible
                    main.frame.setVisible(true);
                    // set the login frame invisible
                    frame.setVisible(false);
                }
                else{
                    // if the inputs are invalid, display a message
                    loginMessage.setText("Invalid username/password");
                }
            }
            catch(FileNotFoundException e){}
        }

        // if the source of the event was the join button
        if (event.getSource() == joinButton){
            try{
                // if the username exists
                if (exists("Username " + joinUsernameInput.getText())){
                    // do not do anything, display an error message
                    joinMessage.setText("Username already exists!");
                }
                else{
                    // if the username does not exist,
                    // add the username and password to the database
                    database.add("Username " + joinUsernameInput.getText());
                    database.add("Password " + joinPasswordInput.getText());
                    // create the user's files where their data will be stores
                    createFiles(joinUsernameInput.getText());
                    // display success message
                    joinMessage.setText("User added!");
                    // clean up text inputs
                    joinUsernameInput.setText("");
                    joinPasswordInput.setText("");
                }
            }
            catch (IOException e){}
        }
        // if the source of the button was the delete button
        if (event.getSource() == deleteButton){
            boolean worked;
            try{
                // delete the user from the login info database
                // worked holds the success boolean
                worked = deleteUser("Username " + joinUsernameInput.getText(), "Password " + joinPasswordInput.getText());
                // if the delete was successful
                if (worked){
                    // display a success message
                    joinMessage.setText("Account Deleted");
                    // delete the user's files
                    deleteFiles(joinUsernameInput.getText());
                    // text input clean up
                    joinUsernameInput.setText("");
                    joinPasswordInput.setText("");
                }
                else{
                    // if the delete failed, display an error message
                    joinMessage.setText("Invalid username/password");
                }
            }
            catch(FileNotFoundException e){}
        }
    }

    // main method (starts the program)
    public static void main(String[] args){
        // create a login, go from there!
        try{Login login = new Login();}
        catch(FileNotFoundException e){}
    }
}