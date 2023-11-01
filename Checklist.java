import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.ArrayList;

public class Checklist extends Page implements ActionListener{
    JPanel titlePanel, inputPanel, listPanel;
    JLabel titleLabel, taskLabel;
    JTextField taskInput;
    JButton addButton, removeButton;
    ArrayList<JLabel> taskList;
    int count;
    Filer filer;
    File data;

    public Checklist(){
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        taskList = new ArrayList<JLabel>();

        File inputFile = new File("data/"+super.username+"Data/"+super.username+"ChecklistData.txt");
        
        try{
            Scanner scan = new Scanner(inputFile);
            count = loadData(taskList, scan);
        }
        catch(FileNotFoundException e){}
        

        panel = new JPanel();
        implementPanel(panel);
        constraints = new GridBagConstraints();

        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.setBackground(backgroundColor);

        titleLabel = new JLabel("To-Do List");
        titleLabel.setBackground(backgroundColor);
        titlePanel.add(titleLabel);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1,4));
        inputPanel.setBackground(backgroundColor);

        taskLabel = new JLabel("          Task: ");
        taskLabel.setBackground(backgroundColor);
        inputPanel.add(taskLabel);

        taskInput = new JTextField();
        inputPanel.add(taskInput);

        addButton = new JButton("+");
        addButton.setBackground(buttonColor);
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        removeButton = new JButton("Remove");
        removeButton.setBackground(darkButtonColor);
        removeButton.addActionListener(this);
        inputPanel.add(removeButton);

        listPanel = new JPanel();
        listPanel.setBackground(backgroundColor);
        listPanel.setLayout(new GridLayout(40,2));

        for (int i = 0; i < 40 - taskList.size(); i++){
            taskList.add(new JLabel(" "));
            listPanel.add(taskList.get(i));
        }

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(titlePanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(inputPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(listPanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
    }

    public int indexOf(String name, ArrayList<JLabel> list){
        int index = 0;
        for (JLabel element: list){
            if (element.getText().compareTo(name) == 0){
                return index;
            }
            index++;
        }
        return index;
    }
    public void remove(String name, ArrayList<JLabel> list, int count){
        int index = indexOf(name, list);
        if (list.get(index+1) != null)
        {
            for (int i = index; i < count; i++)
                list.get(i).setText(list.get(i+1).getText());
        }
        else
        {
            list.get(index).setText("");
        }
    }

    public int loadData(ArrayList<JLabel> list, Scanner scan){
        String input = "";
        int numGuests = 0;
        while (true){
            input = scan.nextLine();
            if (input.compareTo("Break") == 0){
                break;
            }
            else{
                list.add(new JLabel(input));
                numGuests++;
            }
        }
        return numGuests;
    }

    public void saveAction() throws IOException{
        Filer filer = new Filer("data/"+super.username+"Data/"+super.username+"ChecklistData.txt");
        String addToFile = "";
        
        for (int i = 0; i < count; i++){
            addToFile = addToFile + taskList.get(i).getText() + "\n";
        }
        addToFile = addToFile + "Break\n";
        filer.toFile(addToFile);
    }

    public void actionPerformed(ActionEvent event){
        if (event.getSource() == addButton){
            taskList.get(count).setText(taskInput.getText());
            taskInput.setText("");
            count++;
        }
        if (event.getSource() == removeButton){
            remove(taskInput.getText(), taskList, count);
            taskInput.setText("");
            count--;
        }
    }
}

