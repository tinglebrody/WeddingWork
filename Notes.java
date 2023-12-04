import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

// notes page
public class Notes extends Page{
    // text area to write notes
    JTextArea notesInput;
    public Notes(){
        // set up UI Manager to set theme
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        // declare variables
        JPanel titlePanel, notesPanel;
        JLabel titleLabel, spacerLabel;

        // create the file that holds the current user's notes data
        File inputFile = new File("data" + slash + username + "Data" + slash + username + "NotesData.txt");

        // create and implement the main panel
        panel = new JPanel();
        implementPanel(panel);
        // constraints for the layout
        constraints = new GridBagConstraints();

        // create the title panel
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.setBackground(backgroundColor);

        // create the title label
        titleLabel = new JLabel(username + "'s Notes");
        titleLabel.setBackground(backgroundColor);
        titleLabel.setFont(bigFont);
        titlePanel.add(titleLabel);

        // create the panel that holds the notes text box
        notesPanel = new JPanel();
        notesPanel.setLayout(new GridLayout(1,1));
        notesPanel.setBackground(backgroundColor);

        // create the text area where notes can be written
        notesInput = new JTextArea(27,80);
        notesInput.setFont(font);
        notesInput.setBackground(buttonColor);
        notesInput.setOpaque(true);

        // create a scroll pane so notes are limitless (scroll bars are added)
        JScrollPane scroll = new JScrollPane(notesInput);
        // add the notes panel to the scroll pane
        notesPanel.add(scroll);

        // create a file scanner using the input file
        // load the data from the user's text file
        try{
            Scanner scan = new Scanner(inputFile);
            notesInput.setText(loadData(scan));
        }
        catch(FileNotFoundException e){}

        // add everything to the main panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(titlePanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(notesPanel, constraints);
    }

    // function to load data into the text area
    public String loadData(Scanner scan){
        // data holds the entire string
        String data = "";
        // line holds a line from the text file
        String line = "";
        // infinite loop
        while (true){
            try{
                // get the line
                line = scan.nextLine();
                // if the line is empty
                if (line.equals("")){
                    // just add a newline character to the file
                    line = "\n";
                    data = data + line;
                }
                // if the line contains text
                else{
                    // add the text to the main string with a newline character
                    data = data + line + "\n";
                }
            }
            // when an error is thrown, break the loop
            catch (NoSuchElementException e){
                break;
            }
        }
        // return the main string
        return data;
    }

    // function to save text area to user's text file
    public void saveAction(){
        // create a filer using their specific file
        Filer filer = new Filer("data" + slash + username + "Data" + slash + username + "NotesData.txt");
        try{
            // write the data from the text area into the file
            filer.toFile(notesInput.getText());
        }
        catch(IOException e){System.out.println("Error from notes save action");}
    }
}