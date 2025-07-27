package hotelmanagementsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Signup extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public Signup() {
        setTitle("Sign Up - Leftover Food Management");
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

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(customFont);
        confirmPasswordLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 10, 5, 10);
        add(confirmPasswordLabel, gbc);

        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setFont(customFont);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 10, 5, 10);
        add(confirmPasswordField, gbc);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setFont(customFont);
        signupButton.setBackground(new Color(0, 102, 204));
        signupButton.setForeground(Color.WHITE);
        signupButton.setPreferredSize(new Dimension(200, 50));
        signupButton.addActionListener(e -> {
            if (new String(passwordField.getPassword()).equals(new String(confirmPasswordField.getPassword()))) {
                registerUser(usernameField.getText(), new String(passwordField.getPassword()));
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match!");
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(signupButton, gbc);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registerUser(String username, String password) {
        String query = "INSERT INTO login (username, password) VALUES (?, ?)";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, username);
            pst.setString(2, password);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration Successful!");
            new Login();
            dispose();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error during registration.");
        }
    }
}
