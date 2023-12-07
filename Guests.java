import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
Guests Page
Used to create wedding guest list
Broken into six groups:
Groom Family
Bride Family
Groom Friends
Bride Friends
Shared Friends
Other
*/
public class Guests extends Page implements ActionListener{
    // declare variables
    private JTextField guestNameInput, guestCountInput;
    private JButton groomFamilyButton, brideFamilyButton, groomFriendsButton, brideFriendsButton, sharedFriendsButton, 
        otherButton, removeButton;
    private GridBagConstraints constraints;
    private ArrayList<JLabel> groomFamilyList, brideFamilyList, groomFriendsList, brideFriendsList, sharedFriendsList,
        otherList;
    private int guestCount = 40, groomFamilyCount, brideFamilyCount, groomFriendsCount, brideFriendsCount, sharedFriendsCount, otherCount;

    // constructor
    public Guests() throws FileNotFoundException
    {
        // use the UI Manager to set the theme
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        // declaring panels and labels
        JPanel titlePanel, inputPanel, groomFamilyPanel, brideFamilyPanel, 
            groomFriendsPanel, brideFriendsPanel, sharedFriendsPanel,
            otherPanel, spacer1, spacer2, spacer3, spacer4, spacer5, spacer6;
        JLabel titleLabel, guestNameLabel, groomFamilyLabel, brideFamilyLabel, 
            groomFriendsLabel, brideFriendsLabel, sharedFriendsLabel, otherLabel;

        // create lists to maintain state
        groomFamilyList = new ArrayList<JLabel>();
        brideFamilyList = new ArrayList<JLabel>();
        groomFriendsList = new ArrayList<JLabel>();
        brideFriendsList = new ArrayList<JLabel>();
        sharedFriendsList = new ArrayList<JLabel>();
        otherList = new ArrayList<JLabel>();

        // file where guest list data will be loaded in
        File inputFile = new File("data" + slash + username + "Data" + slash + username + "GuestsData.txt");
        Scanner scan = new Scanner(inputFile);

        // load data into lists from text file
        groomFamilyCount = loadData(groomFamilyList, scan);
        brideFamilyCount = loadData(brideFamilyList, scan);
        groomFriendsCount = loadData(groomFriendsList, scan);
        brideFriendsCount = loadData(brideFriendsList, scan);
        sharedFriendsCount = loadData(sharedFriendsList, scan);
        otherCount = loadData(otherList, scan);

        // create the main panel
        panel = new JPanel();
        implementPanel(panel);
        constraints = new GridBagConstraints();

        // create the panel where input will be entered
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(11,2));
        inputPanel.setBackground(backgroundColor);

        // create the panel that holds the groom family list
        groomFamilyPanel = new JPanel();
        groomFamilyPanel.setLayout(new GridLayout(50,1));
        groomFamilyPanel.setBackground(backgroundColor);

        // create the panel that holds the bride family list
        brideFamilyPanel = new JPanel();
        brideFamilyPanel.setLayout(new GridLayout(50,1));
        brideFamilyPanel.setBackground(backgroundColor);

        // create the panel that holds the groom friends list
        groomFriendsPanel = new JPanel();
        groomFriendsPanel.setLayout(new GridLayout(50,1));
        groomFriendsPanel.setBackground(backgroundColor);

        // create the panel that holds the bride friends list
        brideFriendsPanel = new JPanel();
        brideFriendsPanel.setLayout(new GridLayout(50,1));
        brideFriendsPanel.setBackground(backgroundColor);

        // create the panel that holds the shared friends list
        sharedFriendsPanel = new JPanel();
        sharedFriendsPanel.setLayout(new GridLayout(50,1));
        sharedFriendsPanel.setBackground(backgroundColor);

        // create the panel that holds the other list
        otherPanel = new JPanel();
        otherPanel.setLayout(new GridLayout(50,1));
        otherPanel.setBackground(backgroundColor);

        // create spacer panels for organization
        spacer1 = new JPanel();
        spacer1.setLayout(new GridLayout(50,1));
        spacer1.setBackground(backgroundColor);

        spacer2 = new JPanel();
        spacer2.setLayout(new GridLayout(50,1));
        spacer2.setBackground(backgroundColor);

        spacer3 = new JPanel();
        spacer3.setLayout(new GridLayout(50,1));
        spacer3.setBackground(backgroundColor);

        spacer4 = new JPanel();
        spacer4.setLayout(new GridLayout(50,1));
        spacer4.setBackground(backgroundColor);

        spacer5 = new JPanel();
        spacer5.setLayout(new GridLayout(50,1));
        spacer5.setBackground(backgroundColor);

        spacer6 = new JPanel();
        spacer6.setLayout(new GridLayout(50,1));
        spacer6.setBackground(backgroundColor);

        // create main title label
        titleLabel = new JLabel(username + "'s Guests");
        titleLabel.setBackground(backgroundColor);
        titleLabel.setFont(bigFont);
        inputPanel.add(titleLabel);

        // create guest name button label
        guestNameLabel = new JLabel("Guest Name: ");
        guestNameLabel.setFont(smallerFont);
        inputPanel.add(guestNameLabel);

        // guest name text input
        guestNameInput = new JTextField();
        guestNameInput.setFont(smallerFont);
        inputPanel.add(guestNameInput);

        // button to add to groom family
        groomFamilyButton = new JButton("Groom Family");
        groomFamilyButton.setBackground(buttonColor);
        groomFamilyButton.setFont(smallerFont);
        groomFamilyButton.addActionListener(this);
        inputPanel.add(groomFamilyButton);

        // button to add to bride family
        brideFamilyButton = new JButton("Bride Family");
        brideFamilyButton.setBackground(buttonColor);
        brideFamilyButton.setFont(smallerFont);
        brideFamilyButton.addActionListener(this);
        inputPanel.add(brideFamilyButton);

        // button to add to groom friends
        groomFriendsButton = new JButton("Groom Friends");
        groomFriendsButton.setBackground(buttonColor);
        groomFriendsButton.setFont(smallerFont);
        groomFriendsButton.addActionListener(this);
        inputPanel.add(groomFriendsButton);

        // button to add to bride friends
        brideFriendsButton = new JButton("Bride Friends");
        brideFriendsButton.setBackground(buttonColor);
        brideFriendsButton.setFont(smallerFont);
        brideFriendsButton.addActionListener(this);
        inputPanel.add(brideFriendsButton);

        // button to add to shared friends
        sharedFriendsButton = new JButton("Shared Friends");
        sharedFriendsButton.setBackground(buttonColor);
        sharedFriendsButton.setFont(smallerFont);
        sharedFriendsButton.addActionListener(this);
        inputPanel.add(sharedFriendsButton);

        // button to add to other
        otherButton = new JButton("Other");
        otherButton.setBackground(buttonColor);
        otherButton.setFont(smallerFont);
        otherButton.addActionListener(this);
        inputPanel.add(otherButton);

        // button to remove a name
        removeButton = new JButton("Remove");
        removeButton.setForeground(Color.white);
        removeButton.setFont(smallerFont);
        removeButton.setBackground(darkButtonColor);
        removeButton.addActionListener(this);
        inputPanel.add(removeButton);

        // label for groom family list
        groomFamilyLabel = new JLabel("Groom Family");
        groomFamilyLabel.setBackground(backgroundColor);
        groomFamilyLabel.setFont(smallerFont);
        groomFamilyPanel.add(groomFamilyLabel);
        
        // label for bride family list
        brideFamilyLabel = new JLabel("Bride Family");
        brideFamilyLabel.setBackground(backgroundColor);
        brideFamilyLabel.setFont(smallerFont);
        brideFamilyPanel.add(brideFamilyLabel);

        // label for groom friends list
        groomFriendsLabel = new JLabel("Groom Friends");
        groomFriendsLabel.setBackground(backgroundColor);
        groomFriendsLabel.setFont(smallerFont);
        groomFriendsPanel.add(groomFriendsLabel);

        // label for bride friends list
        brideFriendsLabel = new JLabel("Bride Friends");
        brideFriendsLabel.setBackground(backgroundColor);
        brideFriendsLabel.setFont(smallerFont);
        brideFriendsPanel.add(brideFriendsLabel);

        // label for shared friends list
        sharedFriendsLabel = new JLabel("Shared Friends");
        sharedFriendsLabel.setBackground(backgroundColor);
        sharedFriendsLabel.setFont(smallerFont);
        sharedFriendsPanel.add(sharedFriendsLabel);

        // label for other list
        otherLabel = new JLabel("Other");
        otherLabel.setBackground(backgroundColor);
        otherLabel.setFont(smallerFont);
        otherPanel.add(otherLabel);

        // loop from 0 to 40
        for (int i = 0; i < guestCount; i++)
        {
            // for every list:
            // create new JLabel's and add them to the panel

            groomFamilyList.add(new JLabel("                    "));
            groomFamilyList.get(i).setFont(smallFont);
            groomFamilyPanel.add(groomFamilyList.get(i));

            brideFamilyList.add(new JLabel("                    "));
            brideFamilyList.get(i).setFont(smallFont);
            brideFamilyPanel.add(brideFamilyList.get(i));

            groomFriendsList.add(new JLabel("                    "));
            groomFriendsList.get(i).setFont(smallFont);
            groomFriendsPanel.add(groomFriendsList.get(i));

            brideFriendsList.add(new JLabel("                    "));
            brideFriendsList.get(i).setFont(smallFont);
            brideFriendsPanel.add(brideFriendsList.get(i));

            sharedFriendsList.add(new JLabel("                    "));
            sharedFriendsList.get(i).setFont(smallFont);
            sharedFriendsPanel.add(sharedFriendsList.get(i));

            otherList.add(new JLabel("                    "));
            otherList.get(i).setFont(smallFont);
            otherPanel.add(otherList.get(i));

            // spacer's to maintain a good look
            spacer1.add(new JLabel("          "));
            spacer2.add(new JLabel("          "));
            spacer3.add(new JLabel("          "));
            spacer4.add(new JLabel("          "));
            spacer5.add(new JLabel("          "));
            spacer6.add(new JLabel("          "));
        }

        // add everything to the panel in a grid format
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(inputPanel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(spacer1, constraints);
        constraints.gridx = 2;
        constraints.gridy = 0;
        panel.add(groomFamilyPanel, constraints);
        constraints.gridx = 3;
        constraints.gridy = 0;
        panel.add(spacer2, constraints);
        constraints.gridx = 4;
        constraints.gridy = 0;
        panel.add(brideFamilyPanel, constraints);
        constraints.gridx = 5;
        constraints.gridy = 0;
        panel.add(spacer3, constraints);
        constraints.gridx = 6;
        constraints.gridy = 0;
        panel.add(groomFriendsPanel, constraints);
        constraints.gridx = 7;
        constraints.gridy = 0;
        panel.add(spacer4, constraints);
        constraints.gridx = 8;
        constraints.gridy = 0;
        panel.add(brideFriendsPanel, constraints);
        constraints.gridx = 9;
        constraints.gridy = 0;
        panel.add(spacer5, constraints);
        constraints.gridx = 10;
        constraints.gridy = 0;
        panel.add(sharedFriendsPanel, constraints);
        constraints.gridx = 11;
        constraints.gridy = 0;
        panel.add(spacer6, constraints);
        constraints.gridx = 12;
        constraints.gridy = 0;
        panel.add(otherPanel, constraints);
    }

    // method to save the user's data
    public void saveAction() throws IOException{
        // create a filer using the current user's path
        Filer filer = new Filer("data" + slash + username + "Data" + slash + username + "GuestsData.txt");
        // create a master string that will be pushed to the file
        String addToFile = "";
        
        // loop through every list, for every list:
        // add the text from every label to the master string with a newline character at the end
        // add "Break" between each list so that the scanner knows how to separate the lists

        for (int i = 0; i < groomFamilyCount; i++){
            addToFile = addToFile + groomFamilyList.get(i).getText() + "\n";
        }
        addToFile = addToFile + "Break\n";
        for (int i = 0; i < brideFamilyCount; i++){
            addToFile = addToFile + brideFamilyList.get(i).getText() + "\n";
        }
        addToFile = addToFile + "Break\n";
        for (int i = 0; i < groomFriendsCount; i++){
            addToFile = addToFile + groomFriendsList.get(i).getText() + "\n";
        }
        addToFile = addToFile + "Break\n";
        for (int i = 0; i < brideFriendsCount; i++){
            addToFile = addToFile + brideFriendsList.get(i).getText() + "\n";
        }
        addToFile = addToFile + "Break\n";
        for (int i = 0; i < sharedFriendsCount; i++){
            addToFile = addToFile + sharedFriendsList.get(i).getText() + "\n";
        }
        addToFile = addToFile + "Break\n";
        for (int i = 0; i < otherCount; i++){
            addToFile = addToFile + otherList.get(i).getText() + "\n";
        }
        addToFile = addToFile + "Break\n";
        // write the full string to the text file
        filer.toFile(addToFile);
    }

    // method to load data from the text file
    private int loadData(ArrayList<JLabel> list, Scanner scan){
        String input = "";
        int numGuests = 0;
        // infinite loop
        while (true){
            // get the line from the text file
            input = scan.nextLine();
            // if the line is break...
            if (input.compareTo("Break") == 0){
                // end the loop
                break;
            }
            // otherwise
            else{
                // add the line to a label
                list.add(new JLabel(input));
                // increment the count
                numGuests++;
            }
        }
        return numGuests;
    }

    // method to check if a label contains a name
    private boolean labelContains(String name, ArrayList<JLabel> list){
        // loop through every element in the list
        for (JLabel element : list){
            // if the text of the element (JLabel) is equal to the formatted name
            if (element.getText().equals("| " + name + " |")){
                return true;
            }
        }
        // if never found, return false
        return false;
    }

    // method to get the index of a name
    private int indexOf(String name, ArrayList<JLabel> list){
        int index = 0;
        // loop through every element in the list
        for (JLabel element: list){
            // if the JLabel element's text matches the formatted name
            // return the index
            if (element.getText().equals("| " + name + " |")){
                return index;
            }
            index++;
        }
        // return -1 if never found
        return -1;
    }

    // method to remove a name from a list
    private void removeFromList(String name, ArrayList<JLabel> list, int count){
        // get the index of the name
        int index = indexOf(name, list);
        // if the next item in the list is not null
        if (list.get(index+1) != null)
        {
            // loop through every element
            // set the text of the current element to the text of the next element
            for (int i = index; i < count; i++)
                list.get(i).setText(list.get(i+1).getText());
        }
        // if the next item is null
        else
        {
            // set the text of the name to an empty string
            list.get(index).setText("");
        }
    }

    // method to remove a name
    // returns a string holding the list that the name was removed from
    // this is used later to maintain accurate counts
    private String remove(String name){
        // for every list:
        // check if the name is in the list
        // if the name is found, remove it, return the list it was removed from

        if (labelContains(name, groomFamilyList)){
            removeFromList(name, groomFamilyList, groomFamilyCount);
            return "groomFamily";
        }
        if (labelContains(name, brideFamilyList)){
            removeFromList(name, brideFamilyList, brideFamilyCount);
            return "brideFamily";
        }
        if (labelContains(name, groomFriendsList)){
            removeFromList(name, groomFriendsList, groomFriendsCount);
            return "groomFriends";
        }
        if (labelContains(name, brideFriendsList)){
            removeFromList(name, brideFriendsList, brideFriendsCount);
            return "brideFriends";
        }
        if (labelContains(name, sharedFriendsList)){
            removeFromList(name, sharedFriendsList, sharedFriendsCount);
            return "sharedFriends";
        }
        if (labelContains(name, otherList)){
            removeFromList(name, otherList, otherCount);
            return "other";
        }
        // if the name is never found, return an empty string
        return "";
    }

    // method to handle button clicks
    public void actionPerformed(ActionEvent event){
        // the functionality for the groomFamilyButton, brideFamilyButton, etc. is the same

        // if the source is one of these "add" buttons:
        // make sure the count is less than the maximum capacity
        // get the label that is available to be changed (using the count)
        // set the text of this label to the value of the guestNameInput text field
        // reset the guestNameInput text field
        // increment the count of the list that was chosen

        if (event.getSource() == groomFamilyButton) {
            try{
                if (groomFamilyCount < guestCount-1){
                    groomFamilyList.get(groomFamilyCount).setText("| " + guestNameInput.getText() + " |");
                    guestNameInput.setText("");
                    groomFamilyCount++;
                    System.out.println(groomFamilyCount);
                }
            }
            catch(IndexOutOfBoundsException e){}
        }
        if (event.getSource() == brideFamilyButton) {
            try{
                if (brideFamilyCount < guestCount-1){
                    brideFamilyList.get(brideFamilyCount).setText("| " + guestNameInput.getText() + " |");
                    guestNameInput.setText("");
                    brideFamilyCount++;
                }
            }
            catch(IndexOutOfBoundsException e){}
        }
        if (event.getSource() == groomFriendsButton) {
            try{
                if (groomFriendsCount < guestCount-1){
                    groomFriendsList.get(groomFriendsCount).setText("| " + guestNameInput.getText() + " |");
                    guestNameInput.setText("");
                    groomFriendsCount++;
                }
            }
            catch(IndexOutOfBoundsException e){}
        }
        if (event.getSource() == brideFriendsButton) {
            try{
                if (brideFriendsCount < guestCount-1){
                    brideFriendsList.get(brideFriendsCount).setText("| " + guestNameInput.getText() + " |");
                    guestNameInput.setText("");
                    brideFriendsCount++;
                }
            }
            catch(IndexOutOfBoundsException e){}
        }
        if (event.getSource() == sharedFriendsButton) {
            try{
                if (sharedFriendsCount < guestCount-1){
                    sharedFriendsList.get(sharedFriendsCount).setText("| " + guestNameInput.getText() + " |");
                    guestNameInput.setText("");
                    sharedFriendsCount++;
                }
            }
            catch(IndexOutOfBoundsException e){}
        }
        if (event.getSource() == otherButton) {
            try{
                if (otherCount < guestCount-1){
                    otherList.get(otherCount).setText("| " + guestNameInput.getText() + " |");
                    guestNameInput.setText("");
                    otherCount++;
                }
            }
            catch(IndexOutOfBoundsException e){}
        }
        
        // if the source was the remove button:
        if (event.getSource() == removeButton) {
            // remove the name, create a string that stores the list where the name was removed
            String removedFrom = remove(guestNameInput.getText());
            // check where the list was removed from
            // whichever list matches, decrement that list's guest count
            if (removedFrom == "groomFamily"){
                groomFamilyCount--;
            }
            if (removedFrom == "brideFamily"){
                brideFamilyCount--;
            }
            if (removedFrom == "groomFriends"){
                groomFriendsCount--;
            }
            if (removedFrom == "brideFriends"){
                brideFriendsCount--;
            }
            if (removedFrom == "sharedFriends"){
                sharedFriendsCount--;
            }
            if (removedFrom == "other"){
                otherCount--;
            }
            // reset the guest name input text field
            guestNameInput.setText("");
        }
    }
}