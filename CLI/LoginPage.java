package CLI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage extends JFrame {
    //                     | Acc 1         | Anonymous |
    String[][] account = { {"admin"        , ""        },   // Username
                           {"4|)|\\/|!|\\|", ""        } }; // Password
    static boolean authenticationSuccessful = false;
    static String[] identity = {"", ""};

    LoginPage() {
        setLayout(new BorderLayout());
        /********************* North *********************/
        JLabel lWelcome = new JLabel("Welcome to Volistic! Please login to continue.");
        JPanel pWelcome = new JPanel();
        pWelcome.add(lWelcome);
        pWelcome.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lAnonInfo = new JLabel("Leave blank to login as guest.");
        JPanel pAnonInfo = new JPanel();
        pAnonInfo.add(lAnonInfo);
        pAnonInfo.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel pNorth = new JPanel();
        pNorth.add(pWelcome);
        pNorth.add(pAnonInfo);
        pNorth.setLayout(new GridLayout(2, 1));
        add(pNorth, BorderLayout.NORTH);

        /********************* West *********************/
        JPanel pWest = new JPanel();
        add(pWest, BorderLayout.WEST);
        
        /********************* Center *********************/
        JLabel lUsername = new JLabel("Username:");
        JTextField tfUsername = new JTextField("");
        JLabel lPassword = new JLabel("Password:");
        JTextField tfPassword = new JTextField("");
        JPanel pCenter = new JPanel();
        pCenter.add(lUsername);
        pCenter.add(tfUsername);
        pCenter.add(lPassword);
        pCenter.add(tfPassword);
        pCenter.setLayout(new GridLayout(4, 1));
        add(pCenter, BorderLayout.CENTER);

        /********************* East *********************/
        JPanel pEast = new JPanel();
        add(pEast, BorderLayout.EAST);

        /********************* South *********************/
        JLabel lStatus = new JLabel("");
        JPanel pStatus = new JPanel();
        pStatus.add(lStatus);
        pStatus.setLayout(new FlowLayout(1));
        JButton bLogin = new JButton("Login");
        bLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                authenticationSuccessful = false;
                for(int i = 0; i < account[0].length; i++) {if(account[0][i].equals(tfUsername.getText()) && account[1][i].equals(tfPassword.getText())) {
                    authenticationSuccessful = true;
                    identity[0] = tfUsername.getText();
                    if(identity[0].equals("")) {identity[0] = "Guest";}
                    identity[1] = tfPassword.getText();
                }}
                if(authenticationSuccessful) {lStatus.setText("Login successful!");}
                else {lStatus.setText("Login failed. Please try again.");}
            }
        });
        JPanel pSouth = new JPanel();
        pSouth.add(pStatus);
        pSouth.add(bLogin);
        pSouth.setLayout(new GridLayout(2, 1));
        add(pSouth, BorderLayout.SOUTH);

        /********************* Login Frame *********************/
        
        setTitle("Volistic Login Page");
        setSize(300, 250);
        setMaximumSize(new Dimension(300, 250));
        setMinimumSize(new Dimension(300, 250));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
    public static void main(String[] args) {
        new LoginPage();
    }
}
