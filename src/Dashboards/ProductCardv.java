
package Dashboards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import loginform.Connectionprovider;

public class ProductCardv extends JPanel {

    private int id;
    private String name;
    private String description;
    private int price;

    public ProductCardv(int id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
       

        setBackground(Color.WHITE);

        setPreferredSize(new Dimension(150, 150));

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(nameLabel.getFont().deriveFont(16.0f));
        add(nameLabel, BorderLayout.WEST);
        nameLabel.setForeground(Color.BLUE);
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD));

        JLabel descriptionLabel = new JLabel(description);
        add(descriptionLabel, BorderLayout.CENTER);
      

        
     

       

        setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }
 private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
        try {
            Connection con = Connectionprovider.getCon(); // get the connection to the database
            Statement st = con.createStatement(); // create a statement
            st.executeUpdate("INSERT INTO Products (productID, name, description, price, quantity, vendorId, CategoryId) VALUES ('" + productID + "', '" + productName + "','" + productDesc + "','" + productPrice + "','" + productQty + "', '" + productVen + "','" + productCat + "')");
            // show a message that the user has been added and logged in
                    JOptionPane.showMessageDialog(null, "Product Added", "Success", JOptionPane.INFORMATION_MESSAGE);
            con.close(); // close the connection to the database
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
