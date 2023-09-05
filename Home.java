import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home implements ActionListener{

public static String page = "MainMenu";
JPanel panel;
JLabel label;
static JFrame frame;
JButton button;

    public Home(){
        label = new JLabel("Home");
        button = new JButton("Go to Budget");
        button.addActionListener(this);

        frame = new JFrame();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);
    }
    public static void main(String[] args){

    }

    public void actionPerformed(ActionEvent e){
        page = "Budget";
    }
}