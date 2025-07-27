package hotelmanagementsystem;

import java.sql.*;

public class DatabaseConnection 
{
    private static final String URL = "jdbc:mysql://localhost:3306/food";
    private static final String USER = "root";
    private static final String PASSWORD = "12211521";

    public static Connection getConnection() throws SQLException 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) 
        {
            throw new SQLException("MySQL Driver not found. Ensure mysql-connector-j-9.2.0.jar is in classpath.");
        }
    }
}
