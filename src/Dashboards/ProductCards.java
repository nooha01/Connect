package Dashboards;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import loginform.Connectionprovider;
public class ProductCards extends JPanel {

    public ProductCards() {
        setLayout(new GridLayout(3, 3));
        setPreferredSize(new Dimension(648, 407));
        
        try (Connection conn = Connectionprovider.getCon()) {
            // Execute a query
            Statement stmt = conn.createStatement();
            String sql = "SELECT ProductID, Name, Description, Price FROM Products";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                // Retrieve data by column name
                int id = rs.getInt("ProductID");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                int price = rs.getInt("Price");

                // Create a product card with the data
                
                ProductCard card = new ProductCard(id, name, description, price);

                // Add the card to the panel
                add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


