import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.ArrayList;

public class Page{
    Color backgroundColor = new Color(255,255,243);
    Color buttonColor = new Color(229,237,226);
    Color darkButtonColor = new Color(115,118,97);
    GridBagConstraints constraints;
    JPanel panel;
    static String username;

    public void implementPanel(JPanel panel){
        panel.setLayout(new GridBagLayout());
        panel.setBackground(backgroundColor);
    }
}