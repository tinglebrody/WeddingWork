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
        Color buttonColor = new Color(248, 209, 224);
        button.setBackground(buttonColor);
        panel = new JPanel();
        panel.setBackground(buttonColor);

        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(150,150,150,150));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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