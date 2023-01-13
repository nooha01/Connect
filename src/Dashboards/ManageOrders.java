 
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import loginform.Connectionprovider;

public class ManageOrders extends JPanel {
    // Declare constants for panel size

    private static final int PANEL_WIDTH = 568;
    private static final int PANEL_HEIGHT = 343;

    // Declare components
    private JList<String> productList;

    public ManageOrders() {
        // Set panel size and layout
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(new BorderLayout());

        // Initialize components
        productList = new JList<>();
        productList.setListData(new String[]{"Product 1", "Product 2", "Product 3", "Product 4", "Product 5"});

        // Add mouse listener to product list
        productList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Check if double-click
                jPanel1.removeAll();
                jPanel1.setLayout(new GridBagLayout());
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.weightx = 1;
                constraints.weighty = 1;
                /*String[] columnNames = {"Order ID", "Product Name", "Quantity", "Price", "Payment Method"};
                //sample data for the table
                Object[][] data = {
                    {"1001", "Product 1", "5", "$10", "Credit Card"},
                    {"1002", "Product 2", "3", "$20", "Cash"},
                    {"1003", "Product 3", "2", "$15", "Debit Card"}
                };*/
                try {
            Connection con = Connectionprovider.getCon(); // get the connection to the database
            Statement st = con.createStatement(); // create a statement
            ResultSet rs = st.executeQuery("SELECT OrderId,ProductId,CustomerId,Quantity,Price,Address,Payment_method FROM orders;"); 
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Order ID");
            model.addColumn("Product ID");
            model.addColumn("Customer ID");
            model.addColumn("Quantity");
            model.addColumn("Price");
            model.addColumn("Address");
            model.addColumn("Payment Method");

            // populate the table model with data from the ResultSet
            while (rs.next()) {
                Object[] row = new Object[7];
                row[0] = rs.getInt("OrderID");
                row[1] = rs.getInt("ProductID");
                row[2] = rs.getInt("CustomerID");
                row[3] = rs.getInt("Quantity");
                row[4] = rs.getDouble("Price");
                row[5] = rs.getString("Address");
                row[6] = rs.getString("Payment_Method");
                model.addRow(row);
            }

            // create the table and add it to the panel
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            jPanel1.add(scrollPane, constraints);
            scrollPane.setPreferredSize(jPanel1.getSize());
            jPanel1.add(scrollPane);
            jPanel1.revalidate();
            jPanel1.repaint();
           
            con.close(); // close the connection to the database
        } catch (Exception e) {
            e.printStackTrace();
        }
            }
        });

        // Add components to panel
        add(productList, BorderLayout.CENTER);
    }
}
