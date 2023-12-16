// Comments glossary (Abbreviation):
/* example: define oop orang-orang proyek
 * define px pixel
 */

import java.awt.event.*;
import javax.swing.*;

public class VolgionGUI {
    JFrame frame; // Declare `frame`; here -> global

    VolgionGUI() {
        // Create an instance of JFrame
        frame = new JFrame("Welcome to VolgionGUI!");

        // Create an instance of JTextField (Where input usually goes)
        JTextField textField = new JTextField();
        // Create an instance of ImageIcon
        ImageIcon icon = new ImageIcon("GUIFiles/small_hello_silverwolf.png");
        // Create istances of JButton
        JButton button = new JButton("I'm a button!");
        JButton image = new JButton(icon);

        // Set respectively:
        // x axis in px from JFrame's left border,
        // y axis in px from JFrame's top border,
        // width, and height
        button.setBounds(300, 200, 200, 100);
        textField.setBounds(300, 300, 200, 50);
        // Set the dimensions based on the image size
        image.setBounds(350, 50, 100, 100);

        // Add an Action Listener (Trigger when the button is pressed)
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("You clicked the button! :O");
            }
        });

        // Semantics
        frame.add(button);
        frame.add(image);
        frame.add(textField);

        // Widht, height: include window title bar (around 30px)
        frame.setSize(800, 500);
        frame.setLayout(null); // Use no layout manager
        frame.setVisible(true); // Make the frame visible; default is false, I think
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new VolgionGUI();
    }
}