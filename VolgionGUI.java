// Comments glossary (Abbreviation):
/* example: define oop orang-orang proyek
 * define px pixel
 */

import javax.swing.*;

public class VolgionGUI {
    JFrame frame; // Declare `frame`

    VolgionGUI() {
        frame = new JFrame(); // Create an instance of JFrame; initialize `frame`

        JButton button = new JButton("I'm a button!"); // Create an istance of of JButton; declare & initialize
                                                       // `button`
        button.setBounds(100, 50, 100, 50); // Set respectively: x axis in px from upper-right corner, y axis in px
                                            // from upper-right corner, button's width, and button's height

        frame.add(button); // Add `button` (a JButton) to `frame` (a JFrame)

        frame.setSize(300, 180); // Widht, height: include window title bar (around 30px)
        frame.setLayout(null); // Use no layout manager
        frame.setVisible(true); // Make the frame visible; default is false, I think
    }

    public static void main(String[] args) {
        new VolgionGUI();
    }
}