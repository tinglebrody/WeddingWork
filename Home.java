import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home implements ActionListener{

JPanel panel;
JLabel label;
JButton button;

    public Home(){
        label = new JLabel("Home");
        button = new JButton("Click to accomplish (almost) nothing");
        panel = new JPanel();

        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);
        panel.setVisible(false);
    }
    public static void main(String[] args){

    }

    public void actionPerformed(ActionEvent e){
        label.setText("Home Page");
    }
}