import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

/**
Budget page
used to hold budget data for the user's wedding
common wedding expenses are coded in 
*/
public class Budget extends Page implements ActionListener{
    // declare variables
    private int totalBudget, totalExpenses, currentBudget, plannerPrice, venuePrice, cateringPrice, floralsPrice, photographerPrice,
        videographerPrice, cosmeticsPrice, dressPrice, entertainmentPrice, decorationsPrice;
    private JLabel title, totalBudgetLabel, totalExpensesLabel, currentBudgetLabel, plannerLabel, venueLabel, cateringLabel, 
        floralsLabel, photographerLabel, videographerLabel, cosmeticsLabel, dressLabel, entertainmentLabel, decorationsLabel;
    private JTextField totalBudgetInput, plannerPriceInput, venuePriceInput, cateringPriceInput, floralsPriceInput, photographerPriceInput,
        videographerPriceInput, cosmeticsPriceInput, dressPriceInput, entertainmentPriceInput, decorationsPriceInput;
    private JButton totalBudgetButton, plannerButton, venueButton, cateringButton, floralsButton, photographerButton,
            videographerButton, cosmeticsButton, dressButton, entertainmentButton, decorationsButton;
    // Budget constructor
    public Budget() throws IOException{
        // use the UI Manager to set the theme
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

        // create labels and panels that don't need to be global
        JLabel spacerLine;
        JPanel titlePanel, topPanel, middlePanel, bottomPanel, spacerPanel;

        // create the file and scanner that will read data from the user's text file
        File inputFile = new File("data" + slash + username + "Data" + slash + username + "BudgetData.txt");
        Scanner scan = new Scanner(inputFile);

        // load the data into declared variables
        // each line holds a number in the correct order
        totalBudget = Integer.parseInt(scan.nextLine());
        totalExpenses = Integer.parseInt(scan.nextLine());
        currentBudget = Integer.parseInt(scan.nextLine());
        plannerPrice = Integer.parseInt(scan.nextLine());
        venuePrice = Integer.parseInt(scan.nextLine());
        cateringPrice = Integer.parseInt(scan.nextLine());
        floralsPrice = Integer.parseInt(scan.nextLine());
        photographerPrice = Integer.parseInt(scan.nextLine());
        videographerPrice = Integer.parseInt(scan.nextLine());
        cosmeticsPrice = Integer.parseInt(scan.nextLine());
        dressPrice = Integer.parseInt(scan.nextLine());
        entertainmentPrice = Integer.parseInt(scan.nextLine());
        decorationsPrice = Integer.parseInt(scan.nextLine());

        // create and implement the main panel
        panel = new JPanel();
        implementPanel(panel);
        // constraints for layout
        constraints = new GridBagConstraints();

        // create the title panel
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.setBackground(backgroundColor);

        // splitting the page into three panels
        // create the top panel
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,4));
        topPanel.setBackground(backgroundColor);

        // create the middle panel
        middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(2,1));
        middlePanel.setBackground(backgroundColor);

        // create the bottom panel
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(10,3));
        bottomPanel.setBackground(backgroundColor);

        // spacer panel for nice formatting
        spacerPanel = new JPanel();
        spacerPanel.setLayout(new GridLayout(1,1));
        spacerPanel.setBackground(backgroundColor);

        // create the title label
        title = new JLabel(username + "'s Budget");
        title.setFont(bigFont);
        title.setBackground(backgroundColor);
        titlePanel.add(title);

        // create the total budget label, add to top panel
        totalBudgetLabel = new JLabel("Total Budget: $" + totalBudget);
        totalBudgetLabel.setFont(font);
        topPanel.add(totalBudgetLabel);

        // create the total budget input, add to top panel
        totalBudgetInput = new JTextField();
        totalBudgetInput.setFont(smallerFont);
        topPanel.add(totalBudgetInput);

        // create the total budget button, add to top panel
        totalBudgetButton = new JButton("+");
        totalBudgetButton.addActionListener(this);
        totalBudgetButton.setBackground(buttonColor);
        topPanel.add(totalBudgetButton);

        // create the total expenses label, add to middle panel
        totalExpensesLabel = new JLabel("Total Expenses: $" + totalExpenses);
        totalExpensesLabel.setFont(font);
        middlePanel.add(totalExpensesLabel);

        // create the current budget label, add to middle panel
        currentBudgetLabel = new JLabel("Current Budget: $" + currentBudget);
        currentBudgetLabel.setFont(font);
        middlePanel.add(currentBudgetLabel);

        // create a spacer line, add it to the spacer panel
        spacerLine = new JLabel("--------------------------------------------------------");
        spacerPanel.add(spacerLine);

        /**
        For each expense (planner, venue, photographer, etc...):
        create a label that displays the name of the expense
        create a price input text box
        create an add button
        add all three to the bottom panel 
        */
        plannerLabel = new JLabel("Planner: $" + plannerPrice);
        plannerLabel.setFont(font);
        bottomPanel.add(plannerLabel);

        plannerPriceInput = new JTextField();
        plannerPriceInput.setFont(smallerFont);
        bottomPanel.add(plannerPriceInput);

        plannerButton = new JButton("+");
        plannerButton.addActionListener(this);
        plannerButton.setBackground(buttonColor);
        bottomPanel.add(plannerButton);

        venueLabel = new JLabel("Venue: $" + venuePrice);
        venueLabel.setFont(font);
        bottomPanel.add(venueLabel);

        venuePriceInput = new JTextField();
        venuePriceInput.setFont(smallerFont);
        bottomPanel.add(venuePriceInput);

        venueButton = new JButton("+");
        venueButton.addActionListener(this);
        venueButton.setBackground(buttonColor);
        bottomPanel.add(venueButton);

        cateringLabel = new JLabel("Catering: $" + cateringPrice);
        cateringLabel.setFont(font);
        bottomPanel.add(cateringLabel);

        cateringPriceInput = new JTextField();
        cateringPriceInput.setFont(smallerFont);
        bottomPanel.add(cateringPriceInput);

        cateringButton = new JButton("+");
        cateringButton.addActionListener(this);
        cateringButton.setBackground(buttonColor);
        bottomPanel.add(cateringButton);

        floralsLabel = new JLabel("Florals: $" + floralsPrice);
        floralsLabel.setFont(font);
        bottomPanel.add(floralsLabel);

        floralsPriceInput = new JTextField();
        floralsPriceInput.setFont(smallerFont);
        bottomPanel.add(floralsPriceInput);

        floralsButton = new JButton("+");
        floralsButton.addActionListener(this);
        floralsButton.setBackground(buttonColor);
        bottomPanel.add(floralsButton);

        photographerLabel = new JLabel("Photographer: $" + photographerPrice);
        photographerLabel.setFont(font);
        bottomPanel.add(photographerLabel);

        photographerPriceInput = new JTextField();
        photographerPriceInput.setFont(smallerFont);
        bottomPanel.add(photographerPriceInput);

        photographerButton = new JButton("+");
        photographerButton.addActionListener(this);
        photographerButton.setBackground(buttonColor);
        bottomPanel.add(photographerButton);

        videographerLabel = new JLabel("Videographer: $" + videographerPrice);
        videographerLabel.setFont(font);
        bottomPanel.add(videographerLabel);

        videographerPriceInput = new JTextField();
        videographerPriceInput.setFont(smallerFont);
        bottomPanel.add(videographerPriceInput);

        videographerButton = new JButton("+");
        videographerButton.addActionListener(this);
        videographerButton.setBackground(buttonColor);
        bottomPanel.add(videographerButton);

        cosmeticsLabel = new JLabel("Cosmetics: $" + cosmeticsPrice);
        cosmeticsLabel.setFont(font);
        bottomPanel.add(cosmeticsLabel);

        cosmeticsPriceInput = new JTextField();
        cosmeticsPriceInput.setFont(smallerFont);
        bottomPanel.add(cosmeticsPriceInput);

        cosmeticsButton = new JButton("+");
        cosmeticsButton.addActionListener(this);
        cosmeticsButton.setBackground(buttonColor);
        bottomPanel.add(cosmeticsButton);

        dressLabel = new JLabel("Dress: $" + dressPrice);
        dressLabel.setFont(font);
        bottomPanel.add(dressLabel);

        dressPriceInput = new JTextField();
        dressPriceInput.setFont(smallerFont);
        bottomPanel.add(dressPriceInput);

        dressButton = new JButton("+");
        dressButton.addActionListener(this);
        dressButton.setBackground(buttonColor);
        bottomPanel.add(dressButton);

        entertainmentLabel = new JLabel("Entertainment: $" + entertainmentPrice);
        entertainmentLabel.setFont(font);
        bottomPanel.add(entertainmentLabel);

        entertainmentPriceInput = new JTextField();
        entertainmentPriceInput.setFont(smallerFont);
        bottomPanel.add(entertainmentPriceInput);

        entertainmentButton = new JButton("+");
        entertainmentButton.addActionListener(this);
        entertainmentButton.setBackground(buttonColor);
        bottomPanel.add(entertainmentButton);

        decorationsLabel = new JLabel("Decorations: $" + decorationsPrice);
        decorationsLabel.setFont(font);
        bottomPanel.add(decorationsLabel);

        decorationsPriceInput = new JTextField();
        decorationsPriceInput.setFont(smallerFont);
        bottomPanel.add(decorationsPriceInput);

        decorationsButton = new JButton("+");
        decorationsButton.addActionListener(this);
        decorationsButton.setBackground(buttonColor);
        bottomPanel.add(decorationsButton);

        // add all the panels to the main panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(titlePanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(topPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(spacerPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(middlePanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(spacerPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(bottomPanel, constraints);
        panel.setVisible(false);
    }

    // method to update the budget
    private void updateBudget()
    {
        // update the totalExpenses variable
        totalExpenses = plannerPrice + venuePrice + cateringPrice + floralsPrice + photographerPrice + 
            videographerPrice + cosmeticsPrice + dressPrice + entertainmentPrice + decorationsPrice;
        // set the text of the totalExpenses label
        totalExpensesLabel.setText("Total Expenses: $" + totalExpenses);
        // update the currentBudget label
        currentBudget = totalBudget - totalExpenses;
        // set the text of the currentBudget label
        currentBudgetLabel.setText("Current Budget: $" + currentBudget);
    }

    // action for the total budget button
    private void totalBudgetButtonAction(){
        try {
            // create an integer from the text input
            totalBudget = Integer.parseInt(totalBudgetInput.getText());
        }
        catch (NumberFormatException e) {
            // if this fails, set the total budget to 0
            totalBudget = 0;
            totalBudgetInput.setText("");
        }
        // update the current budget variable
        currentBudget = totalBudget - totalExpenses;
        // reset the text input
        totalBudgetInput.setText("");
        // update the total budget label text
        totalBudgetLabel.setText("Total Budget: $" + totalBudget);
        // update the current budget label text
        currentBudgetLabel.setText("Current Budget : $" + currentBudget);
    }

    /**
    Button actions for every expense (planner, venue, photographer, etc...)
    for each expense:

    get the integer input from the text box
    if that fails, set the expense to 0 and reset the text box
    update the variable that holds the expense's price
    update the current budget variable, subtracting the inputted expense from the total budget
    update the text of the expense's label
    reset the text input
    call the updateBudget() method to update the total budget
    */
    private void plannerButtonAction(){
        try {
            plannerPrice = Integer.parseInt(plannerPriceInput.getText());
        }
        catch (NumberFormatException e) {
            plannerPrice = 0;
            plannerPriceInput.setText("");
        }
        currentBudget = totalBudget - plannerPrice;
        plannerLabel.setText("Planner: $" + plannerPrice);
        plannerPriceInput.setText("");
        updateBudget();
    }
    private void venueButtonAction()
    {
        try {
            venuePrice = Integer.parseInt(venuePriceInput.getText());
        }
        catch (NumberFormatException e) {
            venuePrice = 0;
            venuePriceInput.setText("");
        }
        venueLabel.setText("Venue: $" + venuePrice);
        venuePriceInput.setText("");
        updateBudget();
    }
    private void cateringButtonAction(){
        try {
            cateringPrice = Integer.parseInt(cateringPriceInput.getText());
        }
        catch (NumberFormatException e) {
            cateringPrice = 0;
            cateringPriceInput.setText("");
        }
        cateringLabel.setText("Catering: $" + cateringPrice);
        cateringPriceInput.setText("");
        updateBudget();
    }
    private void floralsButtonAction(){
        try {
            floralsPrice = Integer.parseInt(floralsPriceInput.getText());
        }
        catch (NumberFormatException e) {
            floralsPrice = 0;
            floralsPriceInput.setText("");
        }
        floralsLabel.setText("Florals: $" + floralsPrice);
        floralsPriceInput.setText("");
        updateBudget();
    }
    private void photographerButtonAction(){
        try {
            photographerPrice = Integer.parseInt(photographerPriceInput.getText());
        }
        catch (NumberFormatException e) {
            photographerPrice = 0;
            photographerPriceInput.setText("");
        }
        photographerLabel.setText("Photographer: $" + photographerPrice);
        photographerPriceInput.setText("");
        updateBudget();
    }
    private void videographerButtonAction(){
        try {
            videographerPrice = Integer.parseInt(videographerPriceInput.getText());
        }
        catch (NumberFormatException e) {
            videographerPrice = 0;
            videographerPriceInput.setText("");
        }
        videographerLabel.setText("Videographer: $" + videographerPrice);
        videographerPriceInput.setText("");
        updateBudget();
    }
    private void cosmeticsButtonAction(){
        try {
            cosmeticsPrice = Integer.parseInt(cosmeticsPriceInput.getText());
        }
        catch (NumberFormatException e) {
            cosmeticsPrice = 0;
            cosmeticsPriceInput.setText("");
        }
        cosmeticsLabel.setText("Cosmetics: $" + cosmeticsPrice);
        cosmeticsPriceInput.setText("");
        updateBudget();
    }
    private void dressButtonAction(){
        try {
            dressPrice = Integer.parseInt(dressPriceInput.getText());
        }
        catch (NumberFormatException e) {
            dressPrice = 0;
            dressPriceInput.setText("");
        }
        dressLabel.setText("Dress: $" + dressPrice);
        dressPriceInput.setText("");
        updateBudget();
    }

    private void entertainmentButtonAction(){
        try {
            entertainmentPrice = Integer.parseInt(entertainmentPriceInput.getText());
        }
        catch (NumberFormatException e) {
            entertainmentPrice = 0;
            entertainmentPriceInput.setText("");
        }
        entertainmentLabel.setText("Entertainment: $" + entertainmentPrice);
        entertainmentPriceInput.setText("");
        updateBudget();
    }

    private void decorationsButtonAction(){
        try {
            decorationsPrice = Integer.parseInt(decorationsPriceInput.getText());
        }
        catch (NumberFormatException e) {
            decorationsPrice = 0;
            decorationsPriceInput.setText("");
        }
        decorationsLabel.setText("Decorations: $" + decorationsPrice);
        decorationsPriceInput.setText("");
        updateBudget();
    }

    // method to save the user's data to their text file
    public void saveAction() throws IOException{
        // create a filer with the path to this user's data
        Filer filer = new Filer("data" + slash + username + "Data" + slash + username + "BudgetData.txt");
        // write their budget + expenses to the file in a consistent order
        // add newline characters after every entry to create line separation
        filer.toFile(String.valueOf(totalBudget) + "\n" + String.valueOf(totalExpenses) + "\n" + String.valueOf(currentBudget)
         + "\n" + String.valueOf(plannerPrice) + "\n" + String.valueOf(venuePrice) + "\n" + String.valueOf(cateringPrice)
          + "\n" + String.valueOf(floralsPrice) + "\n" + String.valueOf(photographerPrice) + "\n" + String.valueOf(videographerPrice)
           + "\n" + String.valueOf(cosmeticsPrice)+ "\n" + String.valueOf(dressPrice) + "\n" + String.valueOf(entertainmentPrice)
            + "\n" + String.valueOf(decorationsPrice));
    }

    // method to handle button clicks
    public void actionPerformed(ActionEvent event) {
        // get the source of the button click
        // for each source, run the respectice ...ButtonAction() method
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
}