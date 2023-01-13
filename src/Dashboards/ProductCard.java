/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dashboards;

import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.awt.event.*;
import javax.swing.*;
import loginform.Connectionprovider;
import loginform.login;

public class ProductCard extends JPanel {
    int userid = login.user_id_global;
    private int id;
    private String name;
    private String description;
    private int price;

    public ProductCard(int id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        JButton orderButton = new JButton("Order");
//        setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));

        setBackground(Color.WHITE);

        setPreferredSize(new Dimension(150, 150));

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(nameLabel.getFont().deriveFont(16.0f));
        add(nameLabel, BorderLayout.WEST);
        nameLabel.setForeground(Color.BLUE);
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD));

        JLabel descriptionLabel = new JLabel(description);
        add(descriptionLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(orderButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String quantityString = JOptionPane.showInputDialog("Enter the quantity:");
                int quantity = Integer.parseInt(quantityString);
                String address = JOptionPane.showInputDialog("Enter the address:");
                String paymentMethod = JOptionPane.showInputDialog("Enter the payment method:");
                int productID = id;
                int customerID = userid;
                int priceInt = price;
                try (Connection conn = Connectionprovider.getCon()) {
                    // Execute a query
                    Statement stmt = conn.createStatement();

                    String sql2 = "INSERT INTO Orders (ProductID, CustomerID, Quantity, Price, Address, Payment_Method) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql2);
                    pstmt.setInt(1, productID);
                    pstmt.setInt(2, customerID);
                    pstmt.setInt(3, quantity);
                    pstmt.setDouble(4, priceInt);
                    pstmt.setString(5, address);
                    pstmt.setString(6, paymentMethod);
                    pstmt.executeUpdate();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        );

    }
}
