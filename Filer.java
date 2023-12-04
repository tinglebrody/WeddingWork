// SOURCE https://www.homeandlearn.co.uk/java/write_to_textfile.html

import java.io.*;

// class used to write to files
public class Filer{
    // path of the file
    private String filePath;

    // constructor to create a filer with a file path
    public Filer(String filePath){
        this.filePath = filePath;
    }

    // method to write to a file
    // replaces all the text in the file
    public void toFile(String text) throws IOException{
        // create a FileWriter
        FileWriter writer = new FileWriter(filePath, false);
        // write the text to the file
        writer.write(text);
        writer.close();
    }

    // method to append text to the end of a file
    public void toFile(String text, boolean t) throws IOException{
        // create a FileWriter using the filepath and the append option
        FileWriter writer = new FileWriter(filePath, true);
        // add the text to the end of the file
        writer.write(text);
        writer.close();
    }
}