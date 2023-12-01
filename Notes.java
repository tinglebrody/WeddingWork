import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Notes extends Page{
    JTextArea notesInput;
    public Notes(){
        try {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
        JPanel titlePanel, notesPanel, spacerPanel;
        JLabel titleLabel, spacerLabel;

        File inputFile = new File("data/"+super.username+"Data/"+super.username+"NotesData.txt");

        panel = new JPanel();
        implementPanel(panel);
        constraints = new GridBagConstraints();

        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.setBackground(backgroundColor);

        titleLabel = new JLabel(username + "'s Notes");
        titleLabel.setBackground(backgroundColor);
        titleLabel.setFont(bigFont);
        titlePanel.add(titleLabel);

        notesPanel = new JPanel();
        notesPanel.setLayout(new GridLayout(1,1));
        notesPanel.setBackground(backgroundColor);

        notesInput = new JTextArea(27,80);
        notesInput.setFont(font);
        notesInput.setBackground(buttonColor);
        notesInput.setOpaque(true);
        JScrollPane scroll = new JScrollPane(notesInput);
        notesPanel.add(scroll);

        try{
            Scanner scan = new Scanner(inputFile);
            notesInput.setText(loadData(scan));
        }
        catch(FileNotFoundException e){}

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(titlePanel, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(notesPanel, constraints);
    }

    public String loadData(Scanner scan){
        String data = "";
        String line = "";
        while (true){
            try{
                line = scan.nextLine();
                if (line.equals("")){
                    line = "\n";
                    data = data + line;
                }
                else{
                    data = data + line + "\n";
                }
            }
            catch (NoSuchElementException e){
                break;
            }
        }
        return data;
    }

    public void saveAction(){
        Filer filer = new Filer("data/"+super.username+"Data/"+super.username+"NotesData.txt");
        try{
            filer.toFile(notesInput.getText());
        }
        catch(IOException e){System.out.println("Error from notes save action");}
    }
}