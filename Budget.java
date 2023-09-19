import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
public class Budget implements ActionListener{

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
        panel.setBorder(BorderFactory.createEmptyBorder(500,500,500,500));
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

        cosmeticsLabel = new JLabel("Cosmetics: $" + cosmeticsPrice);
        bottomPanel.add(cosmeticsLabel);

        cosmeticsPriceInput = new JTextField();
        bottomPanel.add(cosmeticsPriceInput);

        cosmeticsButton = new JButton("+");
        cosmeticsButton.addActionListener(this);
        cosmeticsButton.setBackground(buttonColor);
        bottomPanel.add(cosmeticsButton);

        dressLabel = new JLabel("Dress: $" + dressPrice);
        bottomPanel.add(dressLabel);

        dressPriceInput = new JTextField();
        bottomPanel.add(dressPriceInput);

        dressButton = new JButton("+");
        dressButton.addActionListener(this);
        dressButton.setBackground(buttonColor);
        bottomPanel.add(dressButton);

        entertainmentLabel = new JLabel("Entertainment: $" + entertainmentPrice);
        bottomPanel.add(entertainmentLabel);

        entertainmentPriceInput = new JTextField();
        bottomPanel.add(entertainmentPriceInput);

        entertainmentButton = new JButton("+");
        entertainmentButton.addActionListener(this);
        entertainmentButton.setBackground(buttonColor);
        bottomPanel.add(entertainmentButton);

        decorationsLabel = new JLabel("Decorations: $" + decorationsPrice);
        bottomPanel.add(decorationsLabel);

        decorationsPriceInput = new JTextField();
        bottomPanel.add(decorationsPriceInput);

        decorationsButton = new JButton("+");
        decorationsButton.addActionListener(this);
        decorationsButton.setBackground(buttonColor);
        bottomPanel.add(decorationsButton);

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

    void updateBudget()
    {
        totalExpenses = plannerPrice + venuePrice + cateringPrice + floralsPrice + photographerPrice + 
            videographerPrice + cosmeticsPrice + dressPrice + entertainmentPrice + decorationsPrice;
        totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
        currentBudget = totalBudget - totalExpenses;
        currentBudgetLabel.setText("Current Budget: $" + currentBudget);
    }
    void totalBudgetButtonAction(){
        try {
            totalBudget = Integer.parseInt(totalBudgetInput.getText());
        }
        catch (NumberFormatException e) {
            totalBudget = 0;
            totalBudgetInput.setText("");
        }
        currentBudget = totalBudget - totalExpenses;
        totalBudgetInput.setText("");
        totalBudgetLabel.setText("Total Budget: $" + totalBudget);
        currentBudgetLabel.setText("Current Budget : $" + currentBudget);
    }
    void plannerButtonAction(){
        try {
            plannerPrice = Integer.parseInt(plannerPriceInput.getText());
        }
        catch (NumberFormatException e) {
            plannerPrice = 0;
            plannerPriceInput.setText("");
        }
        currentBudget = totalBudget - plannerPrice;
        plannerLabel.setText("Planner: $" + plannerPrice);
        updateBudget();
    }
    void venueButtonAction()
    {
        try {
            venuePrice = Integer.parseInt(venuePriceInput.getText());
        }
        catch (NumberFormatException e) {
            venuePrice = 0;
            venuePriceInput.setText("");
        }
        venueLabel.setText("Venue: $" + venuePrice);
        updateBudget();
    }
    void cateringButtonAction(){
        try {
            cateringPrice = Integer.parseInt(cateringPriceInput.getText());
        }
        catch (NumberFormatException e) {
            cateringPrice = 0;
            cateringPriceInput.setText("");
        }
        cateringLabel.setText("Catering: $" + cateringPrice);
        updateBudget();
    }
    void floralsButtonAction(){
        try {
            floralsPrice = Integer.parseInt(floralsPriceInput.getText());
        }
        catch (NumberFormatException e) {
            floralsPrice = 0;
            floralsPriceInput.setText("");
        }
        floralsLabel.setText("Florals: $" + floralsPrice);
        updateBudget();
    }
    void photographerButtonAction(){
        try {
            photographerPrice = Integer.parseInt(photographerPriceInput.getText());
        }
        catch (NumberFormatException e) {
            photographerPrice = 0;
            photographerPriceInput.setText("");
        }
        photographerLabel.setText("Photographer: $" + photographerPrice);
        updateBudget();
    }
    void videographerButtonAction(){
        try {
            videographerPrice = Integer.parseInt(videographerPriceInput.getText());
        }
        catch (NumberFormatException e) {
            videographerPrice = 0;
            videographerPriceInput.setText("");
        }
        videographerLabel.setText("Videographer: $" + videographerPrice);
        updateBudget();
    }
    void cosmeticsButtonAction(){
        try {
            cosmeticsPrice = Integer.parseInt(cosmeticsPriceInput.getText());
        }
        catch (NumberFormatException e) {
            cosmeticsPrice = 0;
            cosmeticsPriceInput.setText("");
        }
        cosmeticsLabel.setText("Cosmetics: $" + cosmeticsPrice);
        updateBudget();
    }
    void dressButtonAction(){
        try {
            dressPrice = Integer.parseInt(dressPriceInput.getText());
        }
        catch (NumberFormatException e) {
            dressPrice = 0;
            dressPriceInput.setText("");
        }
        dressLabel.setText("Dress: $" + dressPrice);
        updateBudget();
    }

    void entertainmentButtonAction(){
        try {
            entertainmentPrice = Integer.parseInt(entertainmentPriceInput.getText());
        }
        catch (NumberFormatException e) {
            entertainmentPrice = 0;
            entertainmentPriceInput.setText("");
        }
        entertainmentLabel.setText("Entertainment: $" + entertainmentPrice);
        updateBudget();
    }

    void decorationsButtonAction(){
        try {
            decorationsPrice = Integer.parseInt(decorationsPriceInput.getText());
        }
        catch (NumberFormatException e) {
            decorationsPrice = 0;
            decorationsPriceInput.setText("");
        }
        decorationsLabel.setText("Decorations: $" + decorationsPrice);
        updateBudget();
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
        else if (event.getSource() == floralsButton){
            floralsButtonAction();
        }
        else if (event.getSource() == photographerButton){
            photographerButtonAction();
        }
        else if (event.getSource() == videographerButton){
            videographerButtonAction();
        }
        else if (event.getSource() == cosmeticsButton){
            cosmeticsButtonAction();
        }
        else if (event.getSource() == dressButton){
            dressButtonAction();
        }
        else if (event.getSource() == entertainmentButton){
            entertainmentButtonAction();
        }
        else if (event.getSource() == decorationsButton){
            decorationsButtonAction();
        }
    }

    public static void main(String[] args){}
}