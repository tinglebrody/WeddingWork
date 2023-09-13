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
JPanel panel;
JTextField totalBudgetInput;
JButton button;

    public Budget(){
        panel = new JPanel();
        Color backGroundColor = new Color(255,255,245);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        panel.setBackground(backGroundColor);
        panel.setBorder(BorderFactory.createEmptyBorder(300,300,300,300));
        panel.setPreferredSize(new Dimension(600,600));

        totalBudgetLabel = new JLabel("Total Budget: $" + totalBudget);
        totalBudgetLabel.setPreferredSize(new Dimension(160,40));
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(totalBudgetLabel, constraints);

        totalBudgetInput = new JTextField();
        totalBudgetInput.setPreferredSize(new Dimension(80,40));
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(totalBudgetInput, constraints);

        button = new JButton("Enter");
        Color buttonColor = new Color(229,237,226);
        button.addActionListener(this);
        button.setBackground(buttonColor);
        button.setPreferredSize(new Dimension(80,40));
        constraints.gridx = 2;
        constraints.gridy = 0;
        panel.add(button, constraints);

        totalExpensesLabel = new JLabel("Total Expenses: $" + totalExpenses);
        totalExpensesLabel.setPreferredSize(new Dimension(160,40));
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(totalExpensesLabel, constraints);

        currentBudgetLabel = new JLabel("Current Budget: $" + currentBudget);
        currentBudgetLabel.setPreferredSize(new Dimension(160,40));
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(currentBudgetLabel, constraints);

        plannerLabel = new JLabel("Planner price: $" + plannerPrice);
        plannerLabel.setPreferredSize(new Dimension(160,40));
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(plannerLabel, constraints);

        venueLabel = new JLabel("venue price: $" + venuePrice);
        venueLabel.setPreferredSize(new Dimension(160,40));
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(venueLabel, constraints);

        panel.setVisible(false);
    }
    public static void main(String[] args){
    }

    public void actionPerformed(ActionEvent e){
        totalBudgetLabel.setText("Total Budget: " + totalBudgetInput.getText());
    }
}