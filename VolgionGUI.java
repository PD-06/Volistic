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
        // Refer to line 24-26 && TODO: UPDATE THIS COMMENT
        textField.setBounds(50, 100, 200, 25);

        // Create an istance of of JButton
        JButton button = new JButton("I'm a button!");

        // Set respectively:
        // x axis in px from upper-right corner, y axis in px rom upper-right corner,
        // button's width, and button's height
        button.setBounds(100, 50, 100, 50);
        // Add an Action Listener (Trigger when the button is pressed)
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("You clicked the button! :O");
            }
        });

        // Semantics
        frame.add(button);
        frame.add(textField);

        // Widht, height: include window title bar (around 30px)
        frame.setSize(300, 180);
        frame.setLayout(null); // Use no layout manager
        frame.setVisible(true); // Make the frame visible; default is false, I think
    }

    public static void main(String[] args) {
        new VolgionGUI();
    }
}