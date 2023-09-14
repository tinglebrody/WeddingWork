import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
public class Budget{
    
int count = 0;
int totalBudget, totalExpenses, currentBudget, plannerPrice, venuePrice, cateringPrice, floralsPrice, photographerPrice,
    videographerPrice, cosmeticsPrice, dressPrice, entertainmentPrice, decorationsPrice;
JLabel totalBudgetLabel, totalExpensesLabel, currentBudgetLabel, plannerLabel, venueLabel, cateringLabel, 
    floralsLabel, photographerLabel, videographerLabel, cosmeticsLabel, dressLabel, entertainmentLabel, decorationsLabel;
JPanel panel, topPanel, middlePanel, bottomPanel;
JTextField totalBudgetInput, plannerPriceInput, venuePriceInput;
JButton totalBudgetButton, plannerButton, venueButton;

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
        bottomPanel.setLayout(new GridLayout(2,3));
        bottomPanel.setBackground(backGroundColor);

        totalBudgetLabel = new JLabel("Total Budget: $" + totalBudget);
        totalBudgetLabel.setPreferredSize(new Dimension(160,40));
        topPanel.add(totalBudgetLabel);

        totalBudgetInput = new JTextField();
        totalBudgetInput.setPreferredSize(new Dimension(160,40));
        topPanel.add(totalBudgetInput);

        totalBudgetButton = new JButton("+");
        Color buttonColor = new Color(229,237,226);
        totalBudgetButton.addActionListener(new totalBudgetButtonAction());
        totalBudgetButton.setBackground(buttonColor);
        totalBudgetButton.setPreferredSize(new Dimension(80,40));
        topPanel.add(totalBudgetButton);

        totalExpensesLabel = new JLabel("Total Expenses: $" + totalExpenses);
        totalExpensesLabel.setPreferredSize(new Dimension(160,40));
        middlePanel.add(totalExpensesLabel);

        currentBudgetLabel = new JLabel("Current Budget: $" + currentBudget);
        currentBudgetLabel.setPreferredSize(new Dimension(160,40));
        middlePanel.add(currentBudgetLabel);

        plannerLabel = new JLabel("Planner: $" + plannerPrice);
        plannerLabel.setPreferredSize(new Dimension(160,40));
        bottomPanel.add(plannerLabel);

        plannerPriceInput = new JTextField();
        plannerPriceInput.setPreferredSize(new Dimension(80,40));
        bottomPanel.add(plannerPriceInput);

        plannerButton = new JButton("+");
        plannerButton.addActionListener(new plannerButtonAction());
        plannerButton.setBackground(buttonColor);
        plannerButton.setMaximumSize(new Dimension(40,40));
        bottomPanel.add(plannerButton);

        venueLabel = new JLabel("Venue: $" + venuePrice);
        venueLabel.setPreferredSize(new Dimension(160,40));
        bottomPanel.add(venueLabel);

        venuePriceInput = new JTextField();
        venuePriceInput.setPreferredSize(new Dimension(80,40));
        bottomPanel.add(venuePriceInput);

        venueButton = new JButton("+");
        venueButton.addActionListener(new venueButtonAction());
        venueButton.setBackground(buttonColor);
        venueButton.setPreferredSize(new Dimension(20,20));
        bottomPanel.add(venueButton);

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

    class totalBudgetButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            totalBudget = Integer.parseInt(totalBudgetInput.getText());
            totalBudgetLabel.setText("Total Budget: $" + totalBudget);
        }
    }

    class plannerButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            plannerPrice = Integer.parseInt(plannerPriceInput.getText());
            plannerLabel.setText("Planner: $" + plannerPrice);
            totalBudget = totalBudget - plannerPrice;
            totalBudgetLabel.setText("Total Budget: $" + totalBudget);
        }
    }

    class venueButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            venuePrice = Integer.parseInt(venuePriceInput.getText());
            venueLabel.setText("Venue: $" + venuePrice);
            totalBudget = totalBudget - venuePrice;
            totalBudgetLabel.setText("Total Budget: $" + totalBudget);
        }
    }
    public static void main(String[] args){
}
}