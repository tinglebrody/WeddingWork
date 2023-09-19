import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Guests implements ActionListener{
    JPanel panel, topPanel, bottomPanel;
    JLabel guestNameLabel, testLabel, temp;
    JTextField guestNameInput;
    JButton guestNameButton;
    GridBagConstraints constraints;
    ArrayList<JLabel> list;

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
        panel.setBorder(BorderFactory.createEmptyBorder(300,300,300,300));
        panel.setMinimumSize(new Dimension(600,600));
        panel.setPreferredSize(new Dimension(600,600));

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,3));
        topPanel.setBackground(backGroundColor);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(10,1));
        bottomPanel.setBackground(backGroundColor);

        list = new ArrayList<JLabel>();

        guestNameLabel = new JLabel("Guest Name: ");

        guestNameInput = new JTextField();

        guestNameButton = new JButton("+");
        Color buttonColor = new Color(229,237,226);
        guestNameButton.setBackground(buttonColor);

        topPanel.add(guestNameLabel);
        topPanel.add(guestNameInput);
        topPanel.add(guestNameButton);

        testLabel = new JLabel("test label");

        bottomPanel.add(testLabel);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(topPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(bottomPanel, constraints);
    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == guestNameButton) {
            temp = new JLabel(guestNameInput.getText());
            list.add(temp);
            bottomPanel.add(temp);
            panel.add(bottomPanel, constraints);
        }
    }
    public static void main(String[] args){}
}