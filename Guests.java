import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Guests implements ActionListener{
    JPanel panel, topPanel, bottomPanel;
    JLabel guestNameLabel, guestCountLabel;
    JTextField guestNameInput, guestCountInput;
    JButton guestNameButton, guestCountButton;
    GridBagConstraints constraints;
    ArrayList<JLabel> list;
    int guestCount = 300, count;

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
        Color backGroundColor = new Color(255,255,243);
        panel.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        panel.setBackground(backGroundColor);
        panel.setBorder(BorderFactory.createEmptyBorder(500,500,500,500));
        panel.setMinimumSize(new Dimension(600,600));
        panel.setPreferredSize(new Dimension(600,600));

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2,3));
        topPanel.setBackground(backGroundColor);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(30,30));
        bottomPanel.setBackground(backGroundColor);

        list = new ArrayList<JLabel>();

        guestNameLabel = new JLabel("Guest Name: ");
        guestNameLabel.setVisible(false);

        guestNameInput = new JTextField();
        guestNameInput.setVisible(false);

        guestNameButton = new JButton("+");
        Color buttonColor = new Color(229,237,226);
        guestNameButton.setBackground(buttonColor);
        guestNameButton.addActionListener(this);
        guestNameButton.setVisible(false);

        guestCountLabel = new JLabel("Guest Count: ");

        guestCountInput = new JTextField();

        guestCountButton = new JButton("+");
        guestCountButton.setBackground(buttonColor);
        guestCountButton.addActionListener(this);

        topPanel.add(guestCountLabel);
        topPanel.add(guestCountInput);
        topPanel.add(guestCountButton);
        topPanel.add(guestNameLabel);
        topPanel.add(guestNameInput);
        topPanel.add(guestNameButton);

        for (int i = 0; i < guestCount; i++)
        {
            list.add(new JLabel());
            bottomPanel.add(list.get(i));
        }

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(topPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(bottomPanel, constraints);
    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == guestNameButton) {
            list.get(count).setText("| " + guestNameInput.getText() + " |");
            guestNameInput.setText("Testing Name");
            count++;
        }
        if (event.getSource() == guestCountButton){
            try{
                guestCount = Integer.parseInt(guestCountInput.getText());
            }
            catch(NumberFormatException e){
                guestCount = 100;
                guestCountInput.setText("");
            }
            guestNameLabel.setVisible(true);
            guestNameInput.setVisible(true);
            guestNameButton.setVisible(true);
        }
    }
    public static void main(String[] args){}
}