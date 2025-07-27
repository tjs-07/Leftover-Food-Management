package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;

public class Home extends JFrame 
{
    public Home() 
    {
        setTitle("Leftover Food Management System");
        setSize(800, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon homeIcon = new ImageIcon("D:/All Projects/SY IT Module-III/DBMS/Leftover Food Management System/image/home.jpg");
        Image img = homeIcon.getImage();
        Image scaledImg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledImg));
        setContentPane(background);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); 

        Font customFont = new Font("Georgia", Font.BOLD, 20);

        JLabel welcomeLabel = new JLabel("Welcome to Leftover Food Management System");
        welcomeLabel.setFont(customFont);
        welcomeLabel.setForeground(Color.WHITE);
        add(welcomeLabel);

        // Restaurant Login Button
        JButton restaurantLoginButton = new JButton("Restaurant Login");
        restaurantLoginButton.setFont(customFont);
        restaurantLoginButton.setBackground(new Color(0, 102, 204));
        restaurantLoginButton.setForeground(Color.WHITE);
        restaurantLoginButton.setPreferredSize(new Dimension(300, 60));  // Increased button size
        restaurantLoginButton.addActionListener(e -> 
        {
            new Login();  // Open Login Page
            dispose();  // Close Home Window
        });

        add(restaurantLoginButton);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        new Home();
    }
}
