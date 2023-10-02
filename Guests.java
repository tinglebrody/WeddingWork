import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.ArrayList;

public class Guests extends Page implements ActionListener{
    JPanel inputPanel, groomFamilyPanel, brideFamilyPanel, groomFriendsPanel, brideFriendsPanel, sharedFriendsPanel,
        otherPanel, spacer1, spacer2, spacer3, spacer4, spacer5, spacer6;
    JLabel guestNameLabel, groomFamilyLabel, brideFamilyLabel, groomFriendsLabel, brideFriendsLabel, sharedFriendsLabel, otherLabel;
    JTextField guestNameInput, guestCountInput;
    JButton groomFamilyButton, brideFamilyButton, groomFriendsButton, brideFriendsButton, sharedFriendsButton, 
        otherButton, removeButton, save;
    GridBagConstraints constraints;
    ArrayList<JLabel> groomFamilyList, brideFamilyList, groomFriendsList, brideFriendsList, sharedFriendsList,
        otherList;
    int guestCount = 50, groomFamilyCount, brideFamilyCount, groomFriendsCount, brideFriendsCount, sharedFriendsCount, otherCount;

    public Guests() throws FileNotFoundException
    {
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        groomFamilyList = new ArrayList<JLabel>();
        brideFamilyList = new ArrayList<JLabel>();
        groomFriendsList = new ArrayList<JLabel>();
        brideFriendsList = new ArrayList<JLabel>();
        sharedFriendsList = new ArrayList<JLabel>();
        otherList = new ArrayList<JLabel>();

        File inputFile = new File("data/guestsData.txt");
        Scanner scan = new Scanner(inputFile);
        groomFamilyCount = loadData(groomFamilyList, scan);
        brideFamilyCount = loadData(brideFamilyList, scan);
        groomFriendsCount = loadData(groomFriendsList, scan);
        brideFriendsCount = loadData(brideFriendsList, scan);
        sharedFriendsCount = loadData(sharedFriendsList, scan);
        otherCount = loadData(otherList, scan);

        panel = new JPanel();
        implementPanel(panel);
        constraints = new GridBagConstraints();
        
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(10,2));
        inputPanel.setBackground(backgroundColor);

        groomFamilyPanel = new JPanel();
        groomFamilyPanel.setLayout(new GridLayout(56,1));
        groomFamilyPanel.setBackground(backgroundColor);

        brideFamilyPanel = new JPanel();
        brideFamilyPanel.setLayout(new GridLayout(56,1));
        brideFamilyPanel.setBackground(backgroundColor);

        groomFriendsPanel = new JPanel();
        groomFriendsPanel.setLayout(new GridLayout(56,1));
        groomFriendsPanel.setBackground(backgroundColor);

        brideFriendsPanel = new JPanel();
        brideFriendsPanel.setLayout(new GridLayout(56,1));
        brideFriendsPanel.setBackground(backgroundColor);

        sharedFriendsPanel = new JPanel();
        sharedFriendsPanel.setLayout(new GridLayout(56,1));
        sharedFriendsPanel.setBackground(backgroundColor);

        otherPanel = new JPanel();
        otherPanel.setLayout(new GridLayout(56,1));
        otherPanel.setBackground(backgroundColor);

        spacer1 = new JPanel();
        spacer1.setLayout(new GridLayout(56,1));
        spacer1.setBackground(backgroundColor);

        spacer2 = new JPanel();
        spacer2.setLayout(new GridLayout(56,1));
        spacer2.setBackground(backgroundColor);

        spacer3 = new JPanel();
        spacer3.setLayout(new GridLayout(56,1));
        spacer3.setBackground(backgroundColor);

        spacer4 = new JPanel();
        spacer4.setLayout(new GridLayout(56,1));
        spacer4.setBackground(backgroundColor);

        spacer5 = new JPanel();
        spacer5.setLayout(new GridLayout(56,1));
        spacer5.setBackground(backgroundColor);

        spacer6 = new JPanel();
        spacer6.setLayout(new GridLayout(56,1));
        spacer6.setBackground(backgroundColor);
        
        guestNameLabel = new JLabel("Guest Name: ");
        inputPanel.add(guestNameLabel);

        guestNameInput = new JTextField();
        inputPanel.add(guestNameInput);

        groomFamilyButton = new JButton("Groom Family");
        groomFamilyButton.setBackground(buttonColor);
        groomFamilyButton.addActionListener(this);
        inputPanel.add(groomFamilyButton);

        brideFamilyButton = new JButton("Bride Family");
        brideFamilyButton.setBackground(buttonColor);
        brideFamilyButton.addActionListener(this);
        inputPanel.add(brideFamilyButton);

        groomFriendsButton = new JButton("Groom Friends");
        groomFriendsButton.setBackground(buttonColor);
        groomFriendsButton.addActionListener(this);
        inputPanel.add(groomFriendsButton);

        brideFriendsButton = new JButton("Bride Friends");
        brideFriendsButton.setBackground(buttonColor);
        brideFriendsButton.addActionListener(this);
        inputPanel.add(brideFriendsButton);

        sharedFriendsButton = new JButton("Shared Friends");
        sharedFriendsButton.setBackground(buttonColor);
        sharedFriendsButton.addActionListener(this);
        inputPanel.add(sharedFriendsButton);

        otherButton = new JButton("Other");
        otherButton.setBackground(buttonColor);
        otherButton.addActionListener(this);
        inputPanel.add(otherButton);

        removeButton = new JButton("Remove");
        removeButton.setForeground(Color.white);
        removeButton.setBackground(darkButtonColor);
        removeButton.addActionListener(this);
        inputPanel.add(removeButton);

        save = new JButton("Save");
        save.addActionListener(this);
        save.setBackground(buttonColor);
        inputPanel.add(save);

        groomFamilyLabel = new JLabel("Groom Family");
        groomFamilyLabel.setBackground(backgroundColor);
        groomFamilyPanel.add(groomFamilyLabel);

        brideFamilyLabel = new JLabel("Bride Family");
        brideFamilyLabel.setBackground(backgroundColor);
        brideFamilyPanel.add(brideFamilyLabel);

        groomFriendsLabel = new JLabel("Groom Friends");
        groomFriendsLabel.setBackground(backgroundColor);
        groomFriendsPanel.add(groomFriendsLabel);

        brideFriendsLabel = new JLabel("Bride Friends");
        brideFriendsLabel.setBackground(backgroundColor);
        brideFriendsPanel.add(brideFriendsLabel);

        sharedFriendsLabel = new JLabel("Shared Friends");
        sharedFriendsLabel.setBackground(backgroundColor);
        sharedFriendsPanel.add(sharedFriendsLabel);

        otherLabel = new JLabel("Other");
        otherLabel.setBackground(backgroundColor);
        otherPanel.add(otherLabel);

        for (int i = 0; i < guestCount; i++)
        {
            groomFamilyList.add(new JLabel("                    "));
            groomFamilyPanel.add(groomFamilyList.get(i));

            brideFamilyList.add(new JLabel("                    "));
            brideFamilyPanel.add(brideFamilyList.get(i));

            groomFriendsList.add(new JLabel("                    "));
            groomFriendsPanel.add(groomFriendsList.get(i));

            brideFriendsList.add(new JLabel("                    "));
            brideFriendsPanel.add(brideFriendsList.get(i));

            sharedFriendsList.add(new JLabel("                    "));
            sharedFriendsPanel.add(sharedFriendsList.get(i));

            otherList.add(new JLabel("                    "));
            otherPanel.add(otherList.get(i));

            spacer1.add(new JLabel("          "));
            spacer2.add(new JLabel("          "));
            spacer3.add(new JLabel("          "));
            spacer4.add(new JLabel("          "));
            spacer5.add(new JLabel("          "));
            spacer6.add(new JLabel("          "));
        }

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

    void saveAction() throws IOException{
        Filer filer = new Filer("data/guestsData.txt");
        String addToFile = "";
        
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
        filer.toFile(addToFile);
    }

    int loadData(ArrayList<JLabel> list, Scanner scan){
        String input = "";
        int numGuests = 0;
        while (true){
            input = scan.nextLine();
            if (input.compareTo("Break") == 0){
                break;
            }
            else{
                list.add(new JLabel(input));
                numGuests++;
            }
        }
        return numGuests;
    }

    public boolean labelContains(String name, ArrayList<JLabel> list){
        for (JLabel element : list){
            if (element.getText().equals("| " + name + " |")){
                return true;
            }
        }
        return false;
    }
    public int indexOf(String name, ArrayList<JLabel> list){
        int index = 0;
        for (JLabel element: list){
            if (element.getText().equals("| " + name + " |")){
                return index;
            }
            index++;
        }
        return index;
    }

    public void removeFromList(String name, ArrayList<JLabel> list, int count){
        int index = indexOf(name, list);
            if (list.get(index+1) != null)
            {
                for (int i = index; i < count; i++)
                    list.get(i).setText(list.get(i+1).getText());
            }
            else
            {
                list.get(index).setText("");
            }
    }
    public String remove(String name){
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
        return "";
    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == groomFamilyButton) {
            try{
                groomFamilyList.get(groomFamilyCount).setText("| " + guestNameInput.getText() + " |");
            }
            catch(IndexOutOfBoundsException e){}
            guestNameInput.setText("");
            groomFamilyCount++;
        }
        if (event.getSource() == brideFamilyButton) {
            try{
                brideFamilyList.get(brideFamilyCount).setText("| " + guestNameInput.getText() + " |");
            }
            catch(IndexOutOfBoundsException e){}
            guestNameInput.setText("");
            brideFamilyCount++;
        }
        if (event.getSource() == groomFriendsButton) {
            try{
                groomFriendsList.get(groomFriendsCount).setText("| " + guestNameInput.getText() + " |");
            }
            catch(IndexOutOfBoundsException e){}
            guestNameInput.setText("");
            groomFriendsCount++;
        }
        if (event.getSource() == brideFriendsButton) {
            try{
                brideFriendsList.get(brideFriendsCount).setText("| " + guestNameInput.getText() + " |");
            }
            catch(IndexOutOfBoundsException e){}
            guestNameInput.setText("");
            brideFriendsCount++;
        }
        if (event.getSource() == sharedFriendsButton) {
            try{
                sharedFriendsList.get(sharedFriendsCount).setText("| " + guestNameInput.getText() + " |");
            }
            catch(IndexOutOfBoundsException e){}
            guestNameInput.setText("");
            sharedFriendsCount++;
        }
        if (event.getSource() == otherButton) {
            try{
                otherList.get(otherCount).setText("| " + guestNameInput.getText() + " |");
            }
            catch(IndexOutOfBoundsException e){}
            guestNameInput.setText("");
            otherCount++;
        }
        if (event.getSource() == removeButton) {
            String removedFrom = remove(guestNameInput.getText());
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
        }
        if (event.getSource() == save) {
            try{
                saveAction();
            }
            catch (IOException e){}
        }
    }
    public static void main(String[] args){}
}