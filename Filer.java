// SOURCE https://www.homeandlearn.co.uk/java/write_to_textfile.html

import java.io.*;

public class Filer{
    String filePath;

public Filer(String filePath){
    this.filePath = filePath;
}

public void toFile(String text) throws IOException{
        FileWriter writer = new FileWriter(filePath, false);
        writer.write(text);
        writer.close();
    }
}