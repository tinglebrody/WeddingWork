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
    floralsLabel, photographerLabel, videographerLabel, cosmeticsLabel, dressLabel, entertainmentLabel, decorationsLabel, spacerLine;
JPanel panel, topPanel, middlePanel, bottomPanel, spacerPanel;
JTextField totalBudgetInput, plannerPriceInput, venuePriceInput, cateringPriceInput, floralsPriceInput, photographerPriceInput,
    videographerPriceInput, cosmeticsPriceInput, dressPriceInput, entertainmentPriceInput, decorationsPriceInput;
JButton totalBudgetButton, plannerButton, venueButton, cateringButton, floralsButton, photographerButton,
    videographerButton, cosmeticsButton, dressButton, entertainmentButton, decorationsButton;

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
        bottomPanel.setLayout(new GridLayout(4,3));
        bottomPanel.setBackground(backGroundColor);

        spacerPanel = new JPanel();
        spacerPanel.setLayout(new GridLayout(1,1));
        spacerPanel.setBackground(backGroundColor);

        totalBudgetLabel = new JLabel("Total Budget: $" + totalBudget);
        topPanel.add(totalBudgetLabel);

        totalBudgetInput = new JTextField();
        topPanel.add(totalBudgetInput);

        totalBudgetButton = new JButton("+");
        Color buttonColor = new Color(229,237,226);
        totalBudgetButton.addActionListener(new totalBudgetButtonAction());
        totalBudgetButton.setBackground(buttonColor);
        topPanel.add(totalBudgetButton);

        totalExpensesLabel = new JLabel("Total Expenses: $" + totalExpenses);
        middlePanel.add(totalExpensesLabel);

        currentBudgetLabel = new JLabel("Current Budget: $" + currentBudget);
        middlePanel.add(currentBudgetLabel);

        spacerLine = new JLabel("--------------------------------------------------------");
        spacerPanel.add(spacerLine);

        plannerLabel = new JLabel("Planner: $" + plannerPrice);
        bottomPanel.add(plannerLabel);

        plannerPriceInput = new JTextField();
        bottomPanel.add(plannerPriceInput);

        plannerButton = new JButton("+");
        plannerButton.addActionListener(new plannerButtonAction());
        plannerButton.setBackground(buttonColor);
        bottomPanel.add(plannerButton);

        venueLabel = new JLabel("Venue: $" + venuePrice);
        bottomPanel.add(venueLabel);

        venuePriceInput = new JTextField();
        bottomPanel.add(venuePriceInput);

        venueButton = new JButton("+");
        venueButton.addActionListener(new venueButtonAction());
        venueButton.setBackground(buttonColor);
        bottomPanel.add(venueButton);

        cateringLabel = new JLabel("Catering: $" + cateringPrice);
        bottomPanel.add(cateringLabel);

        cateringPriceInput = new JTextField();
        bottomPanel.add(cateringPriceInput);

        cateringButton = new JButton("+");
        cateringButton.addActionListener(new cateringButtonAction());
        cateringButton.setBackground(buttonColor);
        bottomPanel.add(cateringButton);

        floralsLabel = new JLabel("Florals: $" + floralsPrice);
        bottomPanel.add(floralsLabel);

        floralsPriceInput = new JTextField();
        bottomPanel.add(floralsPriceInput);

        floralsButton = new JButton("+");
        floralsButton.addActionListener(new floralsButtonAction());
        floralsButton.setBackground(buttonColor);
        bottomPanel.add(floralsButton);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(topPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(spacerPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(middlePanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(spacerPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(bottomPanel, constraints);
        panel.setVisible(false);
    }

    class totalBudgetButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            totalBudget = Integer.parseInt(totalBudgetInput.getText());
            currentBudget = totalBudget - totalExpenses;
            totalBudgetLabel.setText("Total Budget: $" + totalBudget);
            currentBudgetLabel.setText("Current Budget : $" + currentBudget);
        }
    }

    class plannerButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            plannerPrice = Integer.parseInt(plannerPriceInput.getText());
            currentBudget = totalBudget - plannerPrice;
            plannerLabel.setText("Planner: $" + plannerPrice);
            totalExpenses = plannerPrice + venuePrice + cateringPrice + floralsPrice + photographerPrice + 
                videographerPrice + cosmeticsPrice + dressPrice + entertainmentPrice + decorationsPrice;
            totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
            currentBudget = totalBudget - totalExpenses;
            currentBudgetLabel.setText("Current Budget: $" + currentBudget);
        }
    }

    class venueButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            venuePrice = Integer.parseInt(venuePriceInput.getText());
            venueLabel.setText("Venue: $" + venuePrice);
            totalExpenses = plannerPrice + venuePrice + cateringPrice + floralsPrice + photographerPrice + 
                videographerPrice + cosmeticsPrice + dressPrice + entertainmentPrice + decorationsPrice;
            totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
            currentBudget = totalBudget - totalExpenses;
            currentBudgetLabel.setText("Current Budget: $" + currentBudget);
        }
    }

    class cateringButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            cateringPrice = Integer.parseInt(cateringPriceInput.getText());
            cateringLabel.setText("Catering: $" + cateringPrice);
            totalExpenses = plannerPrice + venuePrice + cateringPrice + floralsPrice + photographerPrice + 
                videographerPrice + cosmeticsPrice + dressPrice + entertainmentPrice + decorationsPrice;
            totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
            currentBudget = totalBudget - totalExpenses;
            currentBudgetLabel.setText("Current Budget: $" + currentBudget);
        }
    }

    class floralsButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            floralsPrice = Integer.parseInt(floralsPriceInput.getText());
            floralsLabel.setText("Florals: $" + floralsPrice);
            totalExpenses = plannerPrice + venuePrice + cateringPrice + floralsPrice + photographerPrice + 
                videographerPrice + cosmeticsPrice + dressPrice + entertainmentPrice + decorationsPrice;
            totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
            currentBudget = totalBudget - totalExpenses;
            currentBudgetLabel.setText("Current Budget: $" + currentBudget);
        }
    }
    public static void main(String[] args){
}
}