import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.ArrayList;

public class Vendors extends Page implements ActionListener{
    JPanel inputPanel, listPanel;
    JLabel nameLabel, jobLabel, phoneLabel, emailLabel;
    JTextField nameInput, jobInput, phoneInput, emailInput;
    JButton addButton;
    ArrayList<JPanel> vendorPanels;
    ArrayList<JLabel> vendorLabels;
    ArrayList<JButton> vendorButtons;
    GridBagConstraints constraints;
    int buttonIndex;

    public Vendors(){
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

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout());
        listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(10,2));


        vendorPanels = new ArrayList<JPanel>();
        vendorLabels = new ArrayList<JLabel>();
        vendorButtons = new ArrayList<JButton>();

        for (int i = 0; i < 10; i++){
            vendorPanels.add(new JPanel());
            vendorPanels.get(i).setBackground(backgroundColor);

            vendorLabels.add(new JLabel(String.valueOf(i)));
            vendorLabels.get(i).setBackground(backgroundColor);
            
            vendorButtons.add(new JButton(String.valueOf(i)));
            vendorButtons.get(i).setBackground(buttonColor);
            vendorButtons.get(i).addActionListener(this);

            vendorPanels.get(i).add(vendorLabels.get(i));
            vendorPanels.get(i).add(vendorButtons.get(i));

            listPanel.add(vendorPanels.get(i));
        }

        panel.add(inputPanel);
        panel.add(listPanel);
    }

    public void remove(int index){
        if (vendorLabels.get(index+1) != null){
            for (int i = index; i < vendorLabels.size(); i++)
                vendorLabels.get(i).setText(vendorLabels.get(i+1).getText());
        }
        else{
            vendorLabels.get(index).setText("");
        }
    }

    public void actionPerformed(ActionEvent event){
        buttonIndex = vendorButtons.indexOf(event.getSource());
        remove(buttonIndex);
    }
}

