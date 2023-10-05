import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.ArrayList;

public class Contacts extends Page implements ActionListener{
    JPanel titlePanel, inputPanel, listPanel;
    JLabel titleLabel, nameLabel, jobLabel, phoneLabel, emailLabel;
    JTextField nameInput, jobInput, phoneInput, emailInput;
    JButton addButton, removeButton;
    ArrayList<JLabel> contactsList;
    ArrayList<String> names;
    int count;
    Filer filer;
    File data;

    public Contacts(){
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        contactsList = new ArrayList<JLabel>();
        names = new ArrayList<String>();

        File inputFile = new File("data/"+super.username+"Data/"+super.username+"ContactsData.txt");
        
        try{
            Scanner scan = new Scanner(inputFile);
            count = loadData(contactsList, scan);
        }
        catch(FileNotFoundException e){}
        

        panel = new JPanel();
        implementPanel(panel);
        constraints = new GridBagConstraints();

        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.setBackground(backgroundColor);

        titleLabel = new JLabel("Contacts Page");
        titleLabel.setBackground(backgroundColor);
        titlePanel.add(titleLabel);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1,10));
        inputPanel.setBackground(backgroundColor);

        nameLabel = new JLabel("            Name:");
        nameLabel.setBackground(backgroundColor);
        inputPanel.add(nameLabel);

        nameInput = new JTextField("          ");
        inputPanel.add(nameInput);

        jobLabel = new JLabel("               Job:");
        jobLabel.setBackground(backgroundColor);
        inputPanel.add(jobLabel);

        jobInput = new JTextField("          ");
        inputPanel.add(jobInput);

        phoneLabel = new JLabel("           Phone:");
        inputPanel.add(phoneLabel);

        phoneInput = new JTextField("          ");
        inputPanel.add(phoneInput);

        emailLabel = new JLabel("            Email:");
        emailLabel.setBackground(backgroundColor);
        inputPanel.add(emailLabel);

        emailInput = new JTextField("          ");
        inputPanel.add(emailInput);

        addButton = new JButton("+");
        addButton.setBackground(buttonColor);
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        removeButton = new JButton("Remove");
        removeButton.setBackground(darkButtonColor);
        removeButton.addActionListener(this);
        inputPanel.add(removeButton);

        nameInput.setText("");
        jobInput.setText("");
        phoneInput.setText("");
        emailInput.setText("");

        listPanel = new JPanel();
        listPanel.setBackground(backgroundColor);
        listPanel.setLayout(new GridLayout(40,1));


        for (int i = 0; i < 40 - contactsList.size(); i++){
            contactsList.add(new JLabel(" "));
            listPanel.add(contactsList.get(i));
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
    }

    public int indexOf(String name, ArrayList<String> list){
        int index = 0;
        for (String element : list){
            if (element.compareTo(name) == 0){
                return index;
            }
            index++;
        }
        return index;
    }
    public void remove(String name, ArrayList<JLabel> list, int count){
        int index = indexOf(name, names);
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

    public String parseName(String label){
        String name = "";
        char[] characters = label.toCharArray();
        for (char c : characters){
            if (c == ' '){
                return name;
            }
            else{
                name = name + c;
            }
        }
        return name;
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
                names.add(parseName(input));
                numGuests++;
            }
        }
        return numGuests;
    }

    public void saveAction() throws IOException{
        Filer filer = new Filer("data/"+super.username+"Data/"+super.username+"ContactsData.txt");
        String addToFile = "";
        
        for (int i = 0; i < count; i++){
            addToFile = addToFile + contactsList.get(i).getText() + "\n";
        }
        addToFile = addToFile + "Break\n";
        filer.toFile(addToFile);
    }

    public void actionPerformed(ActionEvent event){
        if (event.getSource() == addButton){
            contactsList.get(count).setText(nameInput.getText() + "          " + jobInput.getText() + "          " + 
                phoneInput.getText() + "          " + emailInput.getText());
            names.add(nameInput.getText());
            nameInput.setText("");
            jobInput.setText("");
            phoneInput.setText("");
            emailInput.setText("");
            count++;
        }
        if (event.getSource() == removeButton){
            remove(nameInput.getText(), contactsList, count);
            nameInput.setText("");
            jobInput.setText("");
            phoneInput.setText("");
            emailInput.setText("");
            count--;
        }
    }
}

