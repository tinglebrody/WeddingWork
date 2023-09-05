import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
public class Home implements ActionListener{

JPanel panel;
JLabel homeLabel, welcomeLabel, photo;
JButton button;

    public Home() throws IOException{

        BufferedImage buff = ImageIO.read(new File("images/RandomWeddingPhoto.jpeg"));
        Image image = buff.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        photo = new JLabel(icon);
        welcomeLabel = new JLabel("Welcome to WeddingWork!");
        homeLabel = new JLabel("Home");
        button = new JButton("Click to accomplish (almost) nothing");
        panel = new JPanel();

        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(150,150,150,150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(photo);
        panel.add(homeLabel);
        panel.add(welcomeLabel);
        panel.add(button);
        panel.setVisible(false);
    }
    public static void main(String[] args){

    }

    public void actionPerformed(ActionEvent e){
        homeLabel.setText("Home Page");
    }
}