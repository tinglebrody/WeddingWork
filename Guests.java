import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Guests implements ActionListener{
    JPanel panel, inputPanel, groomFamilyPanel, brideFamilyPanel, groomFriendsPanel, brideFriendsPanel, sharedFriendsPanel,
        otherPanel;
    JLabel guestNameLabel, groomFamilyLabel;
    JTextField guestNameInput, guestCountInput;
    JButton guestNameButton, guestCountButton;
    GridBagConstraints constraints;
    ArrayList<JLabel> groomFamilyList, brideFamilyList, groomFriendsList, brideFriendsList, sharedFriendsList,
        otherList;
    int guestCount = 55, count;

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
        inputPanel.setLayout(new GridLayout(3,2));
        inputPanel.setBackground(backgroundColor);

        groomFamilyPanel = new JPanel();
        groomFamilyPanel.setLayout(new GridLayout(56,1));
        groomFamilyPanel.setBackground(backgroundColor);

        groomFamilyList = new ArrayList<JLabel>();

        guestNameLabel = new JLabel("Guest Name: ");
        inputPanel.add(guestNameLabel);

        guestNameInput = new JTextField();
        inputPanel.add(guestNameInput);

        guestNameButton = new JButton("+");
        guestNameButton.setBackground(buttonColor);
        guestNameButton.addActionListener(this);
        inputPanel.add(guestNameButton);

        groomFamilyLabel = new JLabel("Groom Family");
        groomFamilyLabel.setBackground(backgroundColor);
        groomFamilyPanel.add(groomFamilyLabel);

        for (int i = 0; i < guestCount; i++)
        {
            groomfamilylist.add(new JLabel("|                         |"));
            groomFamilyPanel.add(groomFamilyList.get(i));
        }

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(inputPanel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(groomFamilyPanel, constraints);
    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == guestNameButton) {
            groomfamilylist.get(count).setText("| " + guestNameInput.getText() + " |");
            guestNameInput.setText("Testing Name");
            count++;
        }
    }
    public static void main(String[] args){}
}