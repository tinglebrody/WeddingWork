import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.ArrayList;

public class Contacts extends Page implements ActionListener{
    JPanel titlePanel, inputPanel, listPanel;
    JLabel titleLabel, nameLabel, jobLabel, phoneLabel, emailLabel;
    JTextField nameInput, jobInput, phoneInput, emailInput;
    JButton addButton, removeButton;
    ArrayList<JLabel> vendorLabels;
    int count;

    public Contacts(){
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        panel = new JPanel();
        implementPanel(panel);
        constraints = new GridBagConstraints();

        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.setBackground(backgroundColor);

        titleLabel = new JLabel("Contacts Page");
        titleLabel.setBackground(backgroundColor);
        titlePanel.add(titleLabel);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1,10));
        inputPanel.setBackground(backgroundColor);

        nameLabel = new JLabel("Name:");
        nameLabel.setBackground(backgroundColor);
        inputPanel.add(nameLabel);

        nameInput = new JTextField("          ");
        nameInput.setBackground(backgroundColor);
        inputPanel.add(nameInput);

        jobLabel = new JLabel("Job:");
        jobLabel.setBackground(backgroundColor);
        inputPanel.add(jobLabel);

        jobInput = new JTextField("          ");
        jobInput.setBackground(backgroundColor);
        inputPanel.add(jobInput);

        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBackground(backgroundColor);
        inputPanel.add(phoneLabel);

        phoneInput = new JTextField("          ");
        phoneInput.setBackground(backgroundColor);
        inputPanel.add(phoneInput);

        emailLabel = new JLabel("Email:");
        emailLabel.setBackground(backgroundColor);
        inputPanel.add(emailLabel);

        emailInput = new JTextField("          ");
        emailInput.setBackground(backgroundColor);
        inputPanel.add(emailInput);

        addButton = new JButton("+");
        addButton.setBackground(buttonColor);
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        nameInput.setText("");
        jobInput.setText("");
        phoneInput.setText("");
        emailInput.setText("");

        listPanel = new JPanel();
        listPanel.setBackground(backgroundColor);
        listPanel.setLayout(new GridLayout(40,1));

        vendorLabels = new ArrayList<JLabel>();


        for (int i = 0; i < 40; i++){
            vendorLabels.add(new JLabel(" "));
            listPanel.add(vendorLabels.get(i));
        }

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(titlePanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(inputPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(listPanel, constraints);
    }


    public void actionPerformed(ActionEvent event){
        if (event.getSource() == addButton){
            vendorLabels.get(count).setText(nameInput.getText() + "             " + jobInput.getText() + "              " + 
                phoneInput.getText() + "            " + emailInput.getText());
            count++;
        }
    }
}

