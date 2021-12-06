import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Key;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.annotation.processing.Messager;
import javax.sound.sampled.SourceDataLine;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class GUI implements ActionListener {
   
    private int count;
    private int ykskord;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JTextField textField1;


    public GUI() {

        frame = new JFrame();

        JButton button = new JButton("Click me");
        button.addActionListener(this);
        label = new JLabel("Number of clicks: 0");
        textField1 = new JTextField("oi m8");
        textField = new JTextField("your name");
        textField.addKeyListener(new Keychecker());






        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        panel.add(textField);
        panel.add(textField1);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Password Manager");
        frame.pack(); 
        frame.setVisible(true);
        


    }

class Keychecker extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent event) {


        char ch = event.getKeyChar();
        String input = Character.toString(ch);
        if(input.isEmpty() == false && ykskord == 0){
            textField.setText(null);
            ykskord++;
        }
        if(input.equals("\n")){
        System.out.println(textField.getText());
            textField.setText(null);
        }

    }

    }



    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
    
        
    }
}
