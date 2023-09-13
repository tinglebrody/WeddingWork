import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
public class Budget implements ActionListener{
    
int count = 0;
int totalBudget, totalExpenses, currentBudget, plannerPrice, venuePrice, cateringPrice, floralsPrice, photographerPrice,
    videographerPrice, cosmeticsPrice, dressPrice, entertainmentPrice, decorationsPrice;
JLabel totalBudgetLabel, totalExpensesLabel, currentBudgetLabel, plannerLabel, venueLabel, cateringLabel, 
    floralsLabel, photographerLabel, videographerLabel, cosmeticsLabel, dressLabel, entertainmentLabel, decorationsLabel;
JPanel panel, topPanel, middlePanel, bottomPanel;
JTextField totalBudgetInput;
JButton button;

    public Budget(){
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
        GridBagConstraints constraints = new GridBagConstraints();
        panel.setBackground(backGroundColor);
        panel.setBorder(BorderFactory.createEmptyBorder(300,300,300,300));
        panel.setMinimumSize(new Dimension(600,600));
        panel.setPreferredSize(new Dimension(600,600));

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,3));
        topPanel.setBackground(backGroundColor);

        middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(2,1));
        middlePanel.setBackground(backGroundColor);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(10,3));
        bottomPanel.setBackground(backGroundColor);

        totalBudgetLabel = new JLabel("Total Budget: $" + totalBudget);
        totalBudgetLabel.setPreferredSize(new Dimension(160,40));
        topPanel.add(totalBudgetLabel);

        totalBudgetInput = new JTextField();
        totalBudgetInput.setPreferredSize(new Dimension(80,40));
        topPanel.add(totalBudgetInput);

        button = new JButton("Enter");
        Color buttonColor = new Color(229,237,226);
        button.addActionListener(this);
        button.setBackground(buttonColor);
        button.setPreferredSize(new Dimension(80,40));
        topPanel.add(button, constraints);

        totalExpensesLabel = new JLabel("Total Expenses: $" + totalExpenses);
        totalExpensesLabel.setPreferredSize(new Dimension(160,40));
        middlePanel.add(totalExpensesLabel);

        currentBudgetLabel = new JLabel("Current Budget: $" + currentBudget);
        currentBudgetLabel.setPreferredSize(new Dimension(160,40));
        middlePanel.add(currentBudgetLabel);

        plannerLabel = new JLabel("Planner price: $" + plannerPrice);
        plannerLabel.setPreferredSize(new Dimension(160,40));
        bottomPanel.add(plannerLabel, constraints);

        venueLabel = new JLabel("venue price: $" + venuePrice);
        venueLabel.setPreferredSize(new Dimension(160,40));
        bottomPanel.add(venueLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(topPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(middlePanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(bottomPanel, constraints);
        panel.setVisible(false);
    }
    public static void main(String[] args){
    }

    public void actionPerformed(ActionEvent e){
        topPanel.remove(totalBudgetInput);
        topPanel.remove(button);
        totalBudgetLabel.setText("Total Budget: " + totalBudgetInput.getText());
        totalBudgetInput.setVisible(false);
        button.setVisible(false);
    }
}