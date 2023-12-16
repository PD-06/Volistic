import javax.swing.*;

public class VolgionGUI {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame(); // Create an instance of JFrame

        JButton jButton = new JButton("Hello, World!"); // Create an instance of JButton
        jButton.setBounds(100, 50, 100, 50); // x axis, y axis, width, height

        jFrame.add(jButton); // Adding a button to jFrame

        jFrame.setSize(300, 180); // Widht, height: include window title bar (around 30px)
        jFrame.setLayout(null); // Use no layout manager
        jFrame.setVisible(true); // Make the frame visible
    }
}