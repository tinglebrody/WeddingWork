import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Contacts extends Page implements ActionListener{
    // declare variables
    private JTextField nameInput, jobInput, phoneInput, emailInput;
    private JButton addButton, removeButton;
    private ArrayList<JLabel> contactsList;
    private ArrayList<String> names;
    private int count;

    public Contacts(){
        // set up UI Manager to set theme
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        // declare panels + labels
        JPanel titlePanel, inputPanel, spacerPanel, listPanel;
        JLabel titleLabel, nameLabel, jobLabel, phoneLabel, emailLabel, spacerLabel;

        // create the list that holds the contacts
        contactsList = new ArrayList<JLabel>();
        // create the list that holds just the names of the contacts
        names = new ArrayList<String>();

        // file that holds the current user's data
        File inputFile = new File("data" + slash + username + "Data" + slash + username + "ContactsData.txt");

        try{
            // create a scanner and load the data from the file
            // count stores the number of contacts
            Scanner scan = new Scanner(inputFile);
            count = loadData(contactsList, scan);
        }
        catch(FileNotFoundException e){}
        
        // implement the main panel
        panel = new JPanel();
        implementPanel(panel);
        // implement the contraints for the layout
        constraints = new GridBagConstraints();

        // create the title panel
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.setBackground(backgroundColor);

        // create the title label
        titleLabel = new JLabel(username + "'s Contacts");
        titleLabel.setFont(bigFont);
        titleLabel.setBackground(backgroundColor);
        titlePanel.add(titleLabel);

        // create the text input panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1,10));
        inputPanel.setBackground(backgroundColor);

        // create the name label
        nameLabel = new JLabel("         Name:");
        nameLabel.setBackground(backgroundColor);
        nameLabel.setFont(font);
        inputPanel.add(nameLabel);

        // create the name input text field
        nameInput = new JTextField("");
        nameInput.setFont(smallerFont);
        inputPanel.add(nameInput);

        // create the job label
        jobLabel = new JLabel("            Job:");
        jobLabel.setBackground(backgroundColor);
        jobLabel.setFont(font);
        inputPanel.add(jobLabel);

        // create the job input text field
        jobInput = new JTextField("");
        jobInput.setFont(smallerFont);
        inputPanel.add(jobInput);

        // create the phone label
        phoneLabel = new JLabel("        Phone:");
        phoneLabel.setBackground(backgroundColor);
        phoneLabel.setFont(font);
        inputPanel.add(phoneLabel);

        // create the phone input text field
        phoneInput = new JTextField("          ");
        phoneInput.setFont(smallerFont);
        inputPanel.add(phoneInput);

        // create the email label
        emailLabel = new JLabel("        Email:");
        emailLabel.setFont(font);
        emailLabel.setBackground(backgroundColor);
        inputPanel.add(emailLabel);

        // create the email input text field
        emailInput = new JTextField("          ");
        emailInput.setFont(smallerFont);
        inputPanel.add(emailInput);

        // create the add contact button
        addButton = new JButton("+");
        addButton.setBackground(buttonColor);
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        // create the remove contact button
        removeButton = new JButton("Remove");
        removeButton.setBackground(darkButtonColor);
        removeButton.setFont(font);
        removeButton.addActionListener(this);
        inputPanel.add(removeButton);

        // set all the input text boxes to empty strings
        nameInput.setText("");
        jobInput.setText("");
        phoneInput.setText("");
        emailInput.setText("");

        // create a spacer panel
        spacerPanel = new JPanel();
        spacerPanel.setBackground(backgroundColor);

        // add a long line to the spacer panel to separate the panels
        spacerLabel = new JLabel("-----------------------------------------------------" 
            + "--------------------------------------------------------------------------");
        spacerLabel.setBackground(backgroundColor);
        spacerPanel.add(spacerLabel);

        // list panel holds the list of contacts
        listPanel = new JPanel();
        listPanel.setBackground(backgroundColor);
        listPanel.setLayout(new GridLayout(30,1));

        // loop through the empty labels
        for (int i = 0; i < 30; i++){
            // add empty strings to each contact
            if (i >= count){
                contactsList.add(new JLabel(" "));
            }
            contactsList.get(i).setFont(smallerFont);
            // add the contacts to the list
            listPanel.add(contactsList.get(i));
        }

        // add everything to the main panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(titlePanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(inputPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(spacerPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(listPanel, constraints);
    }

    // method to get the index of a name
    // basic linear search
    private int indexOf(String name, ArrayList<String> list){
        int index = 0;
        // loop through every element in the list
        for (String element : list){
            // if the element is equal to the name
            if (element.compareTo(name) == 0){
                // return the index of the element
                return index;
            }
            // otherwise increment
            index++;
        }
        return -1;
    }

    // function to remove a contact from the list
    private boolean remove(String name, ArrayList<JLabel> list, int count){
        // get the index of the name from the list of names
        int index = indexOf(name, names);
        if (index == -1){
            return false;
        }
        // if the next item is not null
        if (list.get(index+1) != null)
        {
            // loop through the list of names
            for (int i = index; i < count; i++){
                try{
                    // set the current index to the next one
                    names.set(i, names.get(i+1));
                    // set the text of the current label to the text of the next label
                    list.get(i).setText(list.get(i+1).getText());
                }
                catch(IndexOutOfBoundsException e){
                    // when it goes too far, set the current index to an empty string
                    names.set(i, "");
                    list.get(i).setText("");
                }
            }
            // remove the name from the arraylist
            names.remove(names.size()-1);
        }
        // if the next item is null
        else
        {
            // set the text of the current label to an empty string
            list.get(index).setText("");
            // set the text of the name to an empty string
            names.set(index, "");
        }
        return true;
    }

    // method to get the name out of a contact
    private String parseName(String label){
        String name = "";
        // create an array of characters from the label
        char[] characters = label.toCharArray();
        // loop through the characters
        for (char c : characters){
            // if the character is a space
            if (c == ' '){
                // return the name
                return name;
            }
            else{
                // otherwise add the character to the string
                name = name + c;
            }
        }
        // return the name
        return name;
    }

    // method to load data from a text file to the array list
    private int loadData(ArrayList<JLabel> list, Scanner scan){
        String input = "";
        int numContacts = 0;
        // infinite loop
        while (true){
            // get the line
            input = scan.nextLine();
            // if the line says "Break"
            if (input.compareTo("Break") == 0){
                // end the loop
                break;
            }
            // otherwise
            else{
                // add a new JLabel to the list with the text as input
                list.add(new JLabel(input));
                // add a new name to the list, parsing the name from input
                names.add(parseName(input));
                // increment the number of guests
                numContacts++;
            }
        }
        // return an integer holding the number of guests that were in the file
        return numContacts;
    }

    // method to save data 
    public void saveAction() throws IOException{
        // create a filer using the current user's filepath
        Filer filer = new Filer("data" + slash + username + "Data" + slash + username + "ContactsData.txt");
        String addToFile = "";

        // loop through every item in the list
        for (int i = 0; i < count; i++){
            // append the text of every label to the end of a string
            addToFile = addToFile + contactsList.get(i).getText() + "\n";
        }
        // add "Break" to the end of the file
        addToFile = addToFile + "Break\n";
        // print this string to the file
        filer.toFile(addToFile);
    }

    // method to handle button clicks
    public void actionPerformed(ActionEvent event){
        // if the source of the event is the add button
        if (event.getSource() == addButton){
            try{
                if (count < 29){
                    // get the label at the current count and set it's text to a string made up
                    // of the four inputs
                    contactsList.get(count).setText(nameInput.getText() + "          " + jobInput.getText() + "          " + 
                        phoneInput.getText() + "          " + emailInput.getText());
                    // add just the name to the list of names
                    names.add(nameInput.getText());
                    // reset all the text inputs
                    nameInput.setText("");
                    jobInput.setText("");
                    phoneInput.setText("");
                    emailInput.setText("");
                    // increment the count
                    count++;
                }
            }
            catch (IndexOutOfBoundsException e){
                nameInput.setText("");
                jobInput.setText("");
                phoneInput.setText("");
                emailInput.setText("");
            }
        }
        // if the source of the event is the remove button
        if (event.getSource() == removeButton){
            // remove the contact from the list
            // if the remove is successful
            if (remove(nameInput.getText(), contactsList, count)){
                // clear the text inputs
                nameInput.setText("");
                jobInput.setText("");
                phoneInput.setText("");
                emailInput.setText("");
                // decrement the count
                count--;
            }
            // if the remove fails
            else{
                // reset the text inputs
                nameInput.setText("");
                jobInput.setText("");
                phoneInput.setText("");
                emailInput.setText("");
            }
        }
    }
}

