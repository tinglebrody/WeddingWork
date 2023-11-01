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
    Font superFont = new Font("serif", Font.PLAIN, 100);
    Font bigFont = new Font("serif", Font.PLAIN, 50);
    Font font = new Font("serif", Font.PLAIN, 20);
    Font smallerFont = new Font("serif", Font.PLAIN, 17);
    Font smallFont = new Font("serif", Font.PLAIN, 14);
    GridBagConstraints constraints;
    JPanel panel;
    static String username;

    public void implementPanel(JPanel panel){
        panel.setLayout(new GridBagLayout());
        panel.setBackground(backgroundColor);
    }
}