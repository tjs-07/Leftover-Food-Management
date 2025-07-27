package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class NGOFoodDetails extends JFrame {
    private JTable foodTable;
    private JButton backButton;

    public NGOFoodDetails() {
        setTitle("NGO - Collected Food Details");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create table model and define column headers
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Food Item");
        model.addColumn("Food Type");
        model.addColumn("Quantity");
        model.addColumn("MFG Date");
        model.addColumn("Expiration Date");
        model.addColumn("Storage Method");
        model.addColumn("Allergic Items");
        model.addColumn("Delivery Location");

        // Retrieve data from the database
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT Food_item, Food_type, Quantity, MFG_Date_time, Expiration_date, Storage_method, Allergic_Items, Delivery_Location FROM hotel")) {

            while (rs.next()) {
                Object[] row = new Object[8];
                row[0] = rs.getString("Food_item");
                row[1] = rs.getString("Food_type");
                row[2] = rs.getInt("Quantity");
                row[3] = rs.getString("MFG_Date_time");
                row[4] = rs.getString("Expiration_date");
                row[5] = rs.getString("Storage_method");
                row[6] = rs.getString("Allergic_Items");
                row[7] = rs.getString("Delivery_Location");
                model.addRow(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving data: " + ex.getMessage());
        }

        // Setup JTable with the model and add to a scroll pane
        foodTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(foodTable);
        add(scrollPane, BorderLayout.CENTER);

        // Back button to navigate to the Home page
        backButton = new JButton("Back to Home");
        backButton.setFont(new Font("Georgia", Font.BOLD, 18));
        backButton.setBackground(new Color(0, 102, 204));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            new Home();  // Navigate back to the Home page
            dispose();
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        new NGOFoodDetails();
    }
}