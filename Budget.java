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
        bottomPanel.setLayout(new GridLayout(6,3));
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
        totalBudgetButton.addActionListener(this);
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
        plannerButton.addActionListener(this);
        plannerButton.setBackground(buttonColor);
        bottomPanel.add(plannerButton);

        venueLabel = new JLabel("Venue: $" + venuePrice);
        bottomPanel.add(venueLabel);

        venuePriceInput = new JTextField();
        bottomPanel.add(venuePriceInput);

        venueButton = new JButton("+");
        venueButton.addActionListener(this);
        venueButton.setBackground(buttonColor);
        bottomPanel.add(venueButton);

        cateringLabel = new JLabel("Catering: $" + cateringPrice);
        bottomPanel.add(cateringLabel);

        cateringPriceInput = new JTextField();
        bottomPanel.add(cateringPriceInput);

        cateringButton = new JButton("+");
        cateringButton.addActionListener(this);
        cateringButton.setBackground(buttonColor);
        bottomPanel.add(cateringButton);

        floralsLabel = new JLabel("Florals: $" + floralsPrice);
        bottomPanel.add(floralsLabel);

        floralsPriceInput = new JTextField();
        bottomPanel.add(floralsPriceInput);

        floralsButton = new JButton("+");
        floralsButton.addActionListener(this);
        floralsButton.setBackground(buttonColor);
        bottomPanel.add(floralsButton);

        photographerLabel = new JLabel("Photographer: $" + photographerPrice);
        bottomPanel.add(photographerLabel);

        photographerPriceInput = new JTextField();
        bottomPanel.add(photographerPriceInput);

        photographerButton = new JButton("+");
        photographerButton.addActionListener(this);
        photographerButton.setBackground(buttonColor);
        bottomPanel.add(photographerButton);

        videographerLabel = new JLabel("Videographer: $" + videographerPrice);
        bottomPanel.add(videographerLabel);

        videographerPriceInput = new JTextField();
        bottomPanel.add(videographerPriceInput);

        videographerButton = new JButton("+");
        videographerButton.addActionListener(this);
        videographerButton.setBackground(buttonColor);
        bottomPanel.add(videographerButton);

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

    void totalBudgetButtonAction(){
        totalBudget = Integer.parseInt(totalBudgetInput.getText());
        currentBudget = totalBudget - totalExpenses;
        totalBudgetLabel.setText("Total Budget: $" + totalBudget);
        currentBudgetLabel.setText("Current Budget : $" + currentBudget);
    }
    void plannerButtonAction(){
        plannerPrice = Integer.parseInt(plannerPriceInput.getText());
        currentBudget = totalBudget - plannerPrice;
        plannerLabel.setText("Planner: $" + plannerPrice);
        totalExpenses = plannerPrice + venuePrice + cateringPrice + floralsPrice + photographerPrice + 
            videographerPrice + cosmeticsPrice + dressPrice + entertainmentPrice + decorationsPrice;
        totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
        currentBudget = totalBudget - totalExpenses;
        currentBudgetLabel.setText("Current Budget: $" + currentBudget);
    }
    void venueButtonAction()
    {
        venuePrice = Integer.parseInt(venuePriceInput.getText());
        venueLabel.setText("Venue: $" + venuePrice);
        totalExpenses = plannerPrice + venuePrice + cateringPrice + floralsPrice + photographerPrice + 
            videographerPrice + cosmeticsPrice + dressPrice + entertainmentPrice + decorationsPrice;
        totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
        currentBudget = totalBudget - totalExpenses;
        currentBudgetLabel.setText("Current Budget: $" + currentBudget);
    }
    void cateringButtonAction(){
        cateringPrice = Integer.parseInt(cateringPriceInput.getText());
        cateringLabel.setText("Catering: $" + cateringPrice);
        totalExpenses = plannerPrice + venuePrice + cateringPrice + floralsPrice + photographerPrice + 
            videographerPrice + cosmeticsPrice + dressPrice + entertainmentPrice + decorationsPrice;
        totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
        currentBudget = totalBudget - totalExpenses;
        currentBudgetLabel.setText("Current Budget: $" + currentBudget);
    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == totalBudgetButton) {
            totalBudgetButtonAction();
        }
        else if (event.getSource() == plannerButton) {
            plannerButtonAction();
        }
        else if (event.getSource() == venueButton) {
            venueButtonAction();
        }
        else if (event.getSource() == cateringButton) {
            cateringButtonAction();
        }
        else if (event.getSource() == floralsButton)
        {
            floralsPrice = Integer.parseInt(floralsPriceInput.getText());
            floralsLabel.setText("Florals: $" + floralsPrice);
            totalExpenses = plannerPrice + venuePrice + cateringPrice + floralsPrice + photographerPrice + 
                videographerPrice + cosmeticsPrice + dressPrice + entertainmentPrice + decorationsPrice;
            totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
            currentBudget = totalBudget - totalExpenses;
            currentBudgetLabel.setText("Current Budget: $" + currentBudget);
        }
        else if (event.getSource() == photographerButton){
            photographerPrice = Integer.parseInt(photographerPriceInput.getText());
            photographerLabel.setText("Photographer: $" + photographerPrice);
            totalExpenses = plannerPrice + venuePrice + cateringPrice + floralsPrice + photographerPrice + 
                videographerPrice + cosmeticsPrice + dressPrice + entertainmentPrice + decorationsPrice;
            totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
            currentBudget = totalBudget - totalExpenses;
            currentBudgetLabel.setText("Current Budget: $" + currentBudget);
        }
        else if (event.getSource() == videographerButton){
            videographerPrice = Integer.parseInt(videographerPriceInput.getText());
            videographerLabel.setText("Videographer: $" + videographerPrice);
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