package hotelmanagementsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class FoodManagement extends JFrame {
    private JTextField foodNameField, foodTypeField, quantityField, mfgDateField, expDateField, storageField, allergyField, locationField;
    private JButton submitButton, backButton;

    public FoodManagement() {
        // Frame setup
        setTitle("Food Management");
        setSize(600, 600);  // Increased size for better layout
        setLayout(new GridBagLayout());  // Using GridBagLayout for better control over positioning
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create GridBagConstraints for component alignment
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding to all sides of each component
        gbc.anchor = GridBagConstraints.WEST;  // Align components to the left

        Font customFont = new Font("Georgia", Font.BOLD, 16);
        Color buttonColor = new Color(0, 102, 204);  // Button color

        // Food Name
        JLabel foodNameLabel = new JLabel("Food Name :");
        foodNameLabel.setFont(customFont);
        add(foodNameLabel, gbc);
        foodNameField = new JTextField(20);
        foodNameField.setFont(customFont);
        gbc.gridx = 1;
        add(foodNameField, gbc);

        // Food Type
        JLabel foodTypeLabel = new JLabel("Food Type :");
        foodTypeLabel.setFont(customFont);
        gbc.gridx = 0;
        add(foodTypeLabel, gbc);
        foodTypeField = new JTextField(20);
        foodTypeField.setFont(customFont);
        gbc.gridx = 1;
        add(foodTypeField, gbc);

        // Quantity
        JLabel quantityLabel = new JLabel("Quantity :");
        quantityLabel.setFont(customFont);
        gbc.gridx = 0;
        add(quantityLabel, gbc);
        quantityField = new JTextField(20);
        quantityField.setFont(customFont);
        gbc.gridx = 1;
        add(quantityField, gbc);

        // Manufacturing Date
        JLabel mfgDateLabel = new JLabel("Manufacturing Date (YYYY-MM-DD) :");
        mfgDateLabel.setFont(customFont);
        gbc.gridx = 0;
        add(mfgDateLabel, gbc);
        mfgDateField = new JTextField(20);
        mfgDateField.setFont(customFont);
        gbc.gridx = 1;
        add(mfgDateField, gbc);

        // Expiration Date
        JLabel expDateLabel = new JLabel("Expiration Date (YYYY-MM-DD) :");
        expDateLabel.setFont(customFont);
        gbc.gridx = 0;
        add(expDateLabel, gbc);
        expDateField = new JTextField(20);
        expDateField.setFont(customFont);
        gbc.gridx = 1;
        add(expDateField, gbc);

        // Storage Method
        JLabel storageLabel = new JLabel("Storage Method :");
        storageLabel.setFont(customFont);
        gbc.gridx = 0;
        add(storageLabel, gbc);
        storageField = new JTextField(20);
        storageField.setFont(customFont);
        gbc.gridx = 1;
        add(storageField, gbc);

        // Allergic Items
        JLabel allergyLabel = new JLabel("Allergic Items :");
        allergyLabel.setFont(customFont);
        gbc.gridx = 0;
        add(allergyLabel, gbc);
        allergyField = new JTextField(20);
        allergyField.setFont(customFont);
        gbc.gridx = 1;
        add(allergyField, gbc);

        // Delivery Location
        JLabel locationLabel = new JLabel("Delivery Location :");
        locationLabel.setFont(customFont);
        gbc.gridx = 0;
        add(locationLabel, gbc);
        locationField = new JTextField(20);
        locationField.setFont(customFont);
        gbc.gridx = 1;
        add(locationField, gbc);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Georgia", Font.BOLD, 18));
        submitButton.setBackground(buttonColor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setPreferredSize(new Dimension(150, 40));  // Increased button size
        submitButton.addActionListener(e -> insertFoodData());
        gbc.gridx = 0;
        gbc.gridwidth = 2;  // Span across both columns
        gbc.gridy = 9;  // Place it after all fields
        add(submitButton, gbc);

        // Back Button
        backButton = new JButton("Back to Home");
        backButton.setFont(new Font("Georgia", Font.BOLD, 18));
        backButton.setBackground(buttonColor);
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(150, 40));  // Increased button size
        backButton.addActionListener(e -> {
            new Home();  // Navigate to Home page
            dispose();  // Close FoodManagement page
        });
        gbc.gridy = 10;
        add(backButton, gbc);

        setLocationRelativeTo(null);  // Center the window
        setVisible(true);
    }

    private void insertFoodData() {
        String foodName = foodNameField.getText();
        String foodType = foodTypeField.getText();
        String quantity = quantityField.getText();
        String mfgDate = mfgDateField.getText();
        String expDate = expDateField.getText();
        String storageMethod = storageField.getText();
        String allergicItems = allergyField.getText();
        String deliveryLocation = locationField.getText();

        // Validate fields
        if (foodName.isEmpty() || foodType.isEmpty() || quantity.isEmpty() || mfgDate.isEmpty() || expDate.isEmpty() || storageMethod.isEmpty() || allergicItems.isEmpty() || deliveryLocation.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        String query = "INSERT INTO hotel (Food_item, Food_type, Quantity, MFG_Date_time, Expiration_date, " +
                        "Storage_method, Allergic_Items, Delivery_Location) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            // Set values from form fields
            pst.setString(1, foodName);
            pst.setString(2, foodType);
            pst.setInt(3, Integer.parseInt(quantity));  // Assuming Quantity is an integer
            pst.setString(4, mfgDate);
            pst.setString(5, expDate);
            pst.setString(6, storageMethod);
            pst.setString(7, allergicItems);
            pst.setString(8, deliveryLocation);

            // Execute the query
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Food Data Added Successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Add Food Data.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new FoodManagement();
    }
}