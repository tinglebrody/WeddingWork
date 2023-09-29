import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Guests implements ActionListener{
    JPanel panel, inputPanel, groomFamilyPanel, brideFamilyPanel, groomFriendsPanel, brideFriendsPanel, sharedFriendsPanel,
        otherPanel, spacer1, spacer2, spacer3, spacer4, spacer5, spacer6;
    JLabel guestNameLabel, groomFamilyLabel, brideFamilyLabel, groomFriendsLabel, brideFriendsLabel, sharedFriendsLabel, otherLabel;
    JTextField guestNameInput, guestCountInput;
    JButton groomFamilyButton, brideFamilyButton, groomFriendsButton, brideFriendsButton, sharedFriendsButton, 
        otherButton, removeButton;
    GridBagConstraints constraints;
    ArrayList<JLabel> groomFamilyList, brideFamilyList, groomFriendsList, brideFriendsList, sharedFriendsList,
        otherList;
    int guestCount = 50, groomFamilyCount, brideFamilyCount, groomFriendsCount, brideFriendsCount, sharedFriendsCount, otherCount;

    public Guests()
    {
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        panel = new JPanel();
        Color backgroundColor = new Color(255,255,243);
        Color buttonColor = new Color(229,237,226);
        panel.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        panel.setBackground(backgroundColor);
        panel.setBorder(BorderFactory.createEmptyBorder(500,500,500,500));
        panel.setMinimumSize(new Dimension(600,600));
        panel.setPreferredSize(new Dimension(600,600));

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(9,2));
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

        groomFamilyList = new ArrayList<JLabel>(50);
        brideFamilyList = new ArrayList<JLabel>();
        groomFriendsList = new ArrayList<JLabel>();
        brideFriendsList = new ArrayList<JLabel>();
        sharedFriendsList = new ArrayList<JLabel>();
        otherList = new ArrayList<JLabel>();
        
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
        removeButton.setBackground(new Color(229,237,226));
        removeButton.addActionListener(this);
        inputPanel.add(removeButton);

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

    public boolean labelContains(String name, ArrayList<JLabel> list){
        for (JLabel element : groomFamilyList){
            if (element.getText().equals("| " + name + " |")){
                return true;
            }
        }
        return false;
    }
    public int indexOf(String name, ArrayList<JLabel> list){
        int index = 0;
        for (JLabel element: groomFamilyList){
            if (element.getText().equals("| " + name + " |")){
                return index;
            }
            index++;
        }
        return index;
    }
    public String remove(String name){
        int index;
        if (labelContains(name, groomFamilyList)){
            index = indexOf(name, groomFamilyList);
            if (groomFamilyList.get(index+1) != null)
            {
                groomFamilyList.get(index).setText(groomFamilyList.get(index+1).getText());
                groomFamilyList.get(index+1).setText("");
                return "groomFamily";
            }
            else
            {
                groomFamilyList.get(index).setText("");
                return "groomFamily";
            }
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
        }
    }
    public static void main(String[] args){}
}