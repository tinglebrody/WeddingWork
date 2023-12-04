import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

// page to hold tasks and remove them when completed
public class Checklist extends Page implements ActionListener{
    // declare global variables
    private JTextField taskInput;
    private JButton addButton, removeButton;
    private ArrayList<JLabel> taskList;
    private int count;

    public Checklist(){
        // use the UI Manager to set the theme
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        // declare panels and labels
        JPanel titlePanel, inputPanel, listPanel, spacerPanel;
        JLabel titleLabel, taskLabel, spacerLabel;

        // create the list of tasks
        taskList = new ArrayList<JLabel>();

        // create the file that holds the user's data
        File inputFile = new File("data" + slash + username + "Data" + slash + username + "ChecklistData.txt");
        
        try{
            // create a scanner and load the data into the tasklist
            Scanner scan = new Scanner(inputFile);
            // set the count to the return value of loadData
            count = loadData(taskList, scan);
        }
        catch(FileNotFoundException e){}
        
        // create and implement the main panel
        panel = new JPanel();
        implementPanel(panel);
        // initialize the constraints for the layout
        constraints = new GridBagConstraints();

        // create the title panel
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.setBackground(backgroundColor);

        // create the title label
        titleLabel = new JLabel(username + "'s Checklist");
        titleLabel.setBackground(backgroundColor);
        titleLabel.setFont(bigFont);
        titlePanel.add(titleLabel);

        // create the input panel (stores text input boxes and labels)
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1,4));
        inputPanel.setBackground(backgroundColor);

        // create and add the task label
        taskLabel = new JLabel("          Task: ");
        taskLabel.setFont(font);
        taskLabel.setBackground(backgroundColor);
        inputPanel.add(taskLabel);

        // create and add the task input text field
        taskInput = new JTextField();
        taskInput.setFont(smallerFont);
        inputPanel.add(taskInput);

        // create the add button
        addButton = new JButton("+");
        addButton.setBackground(buttonColor);
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        // create and add the remove button
        removeButton = new JButton("Remove");
        removeButton.setBackground(darkButtonColor);
        removeButton.addActionListener(this);
        inputPanel.add(removeButton);

        // create the spacer panel
        spacerPanel = new JPanel();
        spacerPanel.setBackground(backgroundColor);

        // create a giant line and add it to the spacer panel
        spacerLabel = new JLabel("--------------------------------------------" + 
            "------------------------------------------------------------------------------------");
        spacerLabel.setBackground(backgroundColor);
        spacerPanel.add(spacerLabel);

        // create the list panel
        // this panel will hold the tasks
        listPanel = new JPanel();
        listPanel.setBackground(backgroundColor);
        listPanel.setLayout(new GridLayout(30,1));

        // loop through and create labels
        for (int i = 0; i < 30; i++){
            // add a new label to the end of the list
            if (i >= count){
                taskList.add(new JLabel(" "));
            }
            // set the font of the label
            taskList.get(i).setFont(smallerFont);
            // add the label to the listPanel
            listPanel.add(taskList.get(i));
        }

        // add everything to the main panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(titlePanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(inputPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(spacerPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(listPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
    }

    // method to get the index of a task
    private int indexOf(String task, ArrayList<JLabel> list){
        int index = 0;
        // loop through every element in the list
        for (JLabel element: list){
            // if the element matches the task argument
            if (element.getText().compareTo(task) == 0){
                // return the index
                return index;
            }
            // increment the index
            index++;
        }
        // if it is never found, return -1
        return -1;
    }

    // method to remove a task from the list
    private boolean remove(String task, ArrayList<JLabel> list, int count){
        // get the index of the task
        int index = indexOf(task, list);
        // if the task is not found, return false
        if (index == -1){
            return false;
        }
        // if the next item in the list is not null
        if (list.get(index+1) != null){
            // loop through the list of tasks
            for (int i = index; i < count; i++){
                // set the current task to the text of the next one
                try {
                    list.get(i).setText(list.get(i+1).getText());
                }
                catch (IndexOutOfBoundsException e){
                    list.get(i).setText("");
                }
            }
        }
        // if the next item is null
        else{
            // set the text of the current item to an empty string
            list.get(index).setText("");
        }
        // return true indicating the item was removed
        return true;
    }

    // method to load data from the text file to our task list
    private int loadData(ArrayList<JLabel> list, Scanner scan){
        String input = "";
        int numTasks = 0;
        // infinite loop
        while (true){
            // get the line from the text file
            input = scan.nextLine();
            // if the line says "Break"
            if (input.compareTo("Break") == 0){
                // end the loop
                break;
            }
            // otherwise
            else{
                // add a new label to the list with the input as it's text
                list.add(new JLabel(input));
                // set the font of the label
                list.get(numTasks).setFont(font);
                // increment the number of tasks
                numTasks++;
            }
        }
        // return the number of tasks
        return numTasks;
    }

    // method to save list to the user's text file
    public void saveAction() throws IOException{
        // create a filer using the user's ChecklistData file
        Filer filer = new Filer("data" + slash + username + "Data" + slash + username + "ChecklistData.txt");
        // string that will be added to the file
        String addToFile = "";

        // loop through the list
        for (int i = 0; i < count; i++){
            // add the text from the current label to the addToFile string with
            // a newline character at the end
            addToFile = addToFile + taskList.get(i).getText() + "\n";
        }
        // add "Break" to the end of the string
        addToFile = addToFile + "Break\n";
        // add this string to the file
        filer.toFile(addToFile);
    }

    // method to handle button clicks
    public void actionPerformed(ActionEvent event){
        // if the source was the add button
        if (event.getSource() == addButton){
            try{
                // set the current label text to the text of the taskInput text field
                taskList.get(count).setText(taskInput.getText());
                // reset the task input box
                taskInput.setText("");
                // increment the count
                count++;
            }
            catch (IndexOutOfBoundsException e){
                taskInput.setText("");
            }
        }
        // if the source was the remove button
        if (event.getSource() == removeButton){
            // remove the task from the list
            // if this is successful
            if (remove(taskInput.getText(), taskList, count)){
                // reset the task input box
                taskInput.setText("");
                // decrement the count
                count--;
            }
            // if the remove failed
            else{
                // reset the task input box
                taskInput.setText("");
            }
        }
    }
}

