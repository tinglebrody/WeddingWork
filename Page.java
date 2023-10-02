import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
public class Page{
    Color backgroundColor = new Color(255,255,243);
    Color buttonColor = new Color(229,237,226);
    Color darkButtonColor = new Color(34,68,34);
    GridBagConstraints constraints;
    JPanel panel;

    public void implementPanel(JPanel panel){
        panel.setLayout(new GridBagLayout());
        panel.setBackground(backgroundColor);
        panel.setBorder(BorderFactory.createEmptyBorder(500,500,500,500));
        panel.setMinimumSize(new Dimension(600,600));
        panel.setPreferredSize(new Dimension(600,600));
    }
}