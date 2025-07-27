package hotelmanagementsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame 
{
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() 
    {
        setTitle("Login - Leftover Food Management System");
        setSize(500, 400);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font customFont = new Font("Georgia", Font.BOLD, 20);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(customFont);
        usernameLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 5, 10);
        add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        usernameField.setFont(customFont);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 5, 10);
        add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(customFont);
        passwordLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 10, 5, 10);
        add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        passwordField.setFont(customFont);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 10, 5, 10);
        add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(customFont);
        loginButton.setBackground(new Color(0, 102, 204));
        loginButton.setForeground(Color.WHITE);
        loginButton.setPreferredSize(new Dimension(200, 50));
        loginButton.addActionListener(e -> 
        {
            if (validateLogin(usernameField.getText(), new String(passwordField.getPassword()))) {
                new FoodManagement();  
                dispose(); 
            } else
            {
                JOptionPane.showMessageDialog(this, "Incorrect Username or Password!");
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 5, 10);
        add(loginButton, gbc);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setFont(customFont);
        signupButton.setBackground(new Color(0, 102, 204));
        signupButton.setForeground(Color.WHITE);
        signupButton.setPreferredSize(new Dimension(200, 50));
        signupButton.addActionListener(e -> {
            new Signup();  
            dispose(); 
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(5, 10, 10, 10);
        add(signupButton, gbc);

        JButton backButton = new JButton("Back to Home");
        backButton.setFont(customFont);
        backButton.setBackground(new Color(0, 102, 204));
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.addActionListener(e -> 
        {
            new Home();  
            dispose();  
        });
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(5, 10, 10, 10);
        add(backButton, gbc);

        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private boolean validateLogin(String username, String password) 
    {
        String query = "SELECT * FROM login WHERE username=? AND password=?";
        try (Connection con = DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(query)) 
            {
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
            return false;
        }
    }
}