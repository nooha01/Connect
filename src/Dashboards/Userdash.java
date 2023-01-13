package Dashboards;

import home1.userTypeInterface;
import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import loginform.Connectionprovider;
import loginform.login;

public class Userdash extends javax.swing.JFrame {

    String username = login.username_global;
    int userid = login.user_id_global;

    public Userdash() {
        initComponents();

// Add the back button to the top left corner of the panel
        jLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPanel1.removeAll();
                jPanel1.add(new ProductCards());
                jPanel1.revalidate();
                jPanel1.repaint();
            }
        });

        jLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                    ResultSet rs = st.executeQuery("SELECT OrderId,ProductId,CustomerId,Quantity,Price,Address,Payment_method FROM orders WHERE customerId='" + userid + "';");
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
                    table.setAutoResizeMode(380);
                    JScrollPane scrollPane = new JScrollPane(table);
                    jPanel1.add(scrollPane, constraints);
                    scrollPane.setPreferredSize(jPanel1.getSize());
                    jPanel1.add(scrollPane);
                    jPanel1.revalidate();
                    jPanel1.repaint();

                    con.close(); // close the connection to the database
                } catch (Exception evt) {
                    evt.printStackTrace();
                }
            }
        });

        jLabel6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                jPanel1.removeAll();
                jPanel1.add(new Review(/* any necessary arguments for the panel */));
                jPanel1.revalidate();
                jPanel1.repaint();
            }
        });

        jLabel8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
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
                    ResultSet rs = st.executeQuery("SELECT OrderId,ProductId,CustomerId,Price,Address FROM orders WHERE customerId='" + userid + "';");
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("Order ID");
                    model.addColumn("Product ID");
                    model.addColumn("Customer ID");
//            model.addColumn("Quantity");
                    model.addColumn("Price");
                    model.addColumn("Address");
                    //model.addColumn("Payment Method");

                    // populate the table model with data from the ResultSet
                    while (rs.next()) {
                        Object[] row = new Object[5];
                        row[0] = rs.getInt("OrderID");
                        row[1] = rs.getInt("ProductID");
                        row[2] = rs.getInt("CustomerID");
//                row[3] = rs.getInt("Quantity");
                        row[3] = rs.getDouble("Price");
                        row[4] = rs.getString("Address");
//                row[6] = rs.getString("Payment_Method");
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

        jLabel10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                jPanel1.removeAll();
                Addbus addbusPanel = new Addbus(/* any necessary arguments for the panel */);
                JScrollPane scrollPane = new JScrollPane(addbusPanel);
                jPanel1.add(scrollPane);
                jPanel1.revalidate();
                jPanel1.repaint();
            }
        });
        
        viewBus.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                jPanel1.removeAll();
        jPanel1.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        
        try {
            Connection con = Connectionprovider.getCon(); // get the connection to the database
            Statement st = con.createStatement(); // create a statement

            ResultSet rs = st.executeQuery("SELECT bID,Name,Description,Price,Quantity,vendorid,categoryid FROM business WHERE vendorid='" + userid + "';");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Business ID");
            model.addColumn("Name");
            model.addColumn("Description");
            model.addColumn("Price");
            model.addColumn("Quantity");
            model.addColumn("vendor id");
            model.addColumn("category id");
            // populate the table model with data from the ResultSet
            while (rs.next()) {
                Object[] row = new Object[7];
                row[0] = rs.getInt("bID");
                row[1] = rs.getString("Name");
                row[2] = rs.getString("Description");
                row[3] = rs.getInt("Price");
                row[4] = rs.getDouble("Quantity");
                row[5] = rs.getString("vendorid");
                row[6] = rs.getString("categoryid");
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
        } catch (Exception evt) {
            evt.printStackTrace();
        }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        viewBus = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        userN = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Dashboard");

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Browse items");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Manage order");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 170, -1));

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, -1));

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Add Review");

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Order History");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(4, 4, 4))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 170, -1));

        jPanel7.setBackground(new java.awt.Color(0, 102, 204));

        jLabel10.setBackground(new java.awt.Color(0, 153, 204));
        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Support Business");

        viewBus.setBackground(new java.awt.Color(0, 153, 204));
        viewBus.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        viewBus.setForeground(new java.awt.Color(255, 255, 255));
        viewBus.setText("View Your Business");
        viewBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewBusMouseClicked(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(0, 153, 204));
        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Logout");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel10))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(viewBus, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(viewBus)
                .addGap(13, 13, 13)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 170, -1));

        jPanel8.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 170, -1));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("C O N N E C T");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 240, -1));

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setName(""); // NOI18N

        backButton.setBackground(new java.awt.Color(0, 102, 51));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.setPreferredSize(new java.awt.Dimension(50, 30));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        userN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        userN.setForeground(new java.awt.Color(255, 255, 255));
        userN.setText(username);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(435, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(userN, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        JFrame home1 = new userTypeInterface();
        home1.setVisible(true);
        Userdash.this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        Userdash.this.dispose();
        new login().setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void viewBusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewBusMouseClicked
//        jPanel1.removeAll();
//                jPanel1.setLayout(new GridBagLayout());
//                GridBagConstraints constraints = new GridBagConstraints();
//                constraints.weightx = 1;
//                constraints.weighty = 1;
//                /*String[] columnNames = {"Order ID", "Product Name", "Quantity", "Price", "Payment Method"};
//                //sample data for the table
//                Object[][] data = {
//                    {"1001", "Product 1", "5", "$10", "Credit Card"},
//                    {"1002", "Product 2", "3", "$20", "Cash"},
//                    {"1003", "Product 3", "2", "$15", "Debit Card"}
//                };*/
//                try {
//            Connection con = Connectionprovider.getCon(); // get the connection to the database
//            Statement st = con.createStatement(); // create a statement
//            ResultSet rs = st.executeQuery("SELECT bID,Name,Description,Price,Quantity,vendorid,categoryid FROM business WHERE customerId='" + userid + "';"); 
//            DefaultTableModel model = new DefaultTableModel();
//            model.addColumn("Business ID");
//            model.addColumn("Name");
//            model.addColumn("Description");
//            model.addColumn("Price");
//            model.addColumn("Quantity");
//            model.addColumn("vendor id");
//            model.addColumn("category id");
//
//            // populate the table model with data from the ResultSet
//            while (rs.next()) {
//                Object[] row = new Object[7];
//                row[0] = rs.getInt("bID");
//                row[1] = rs.getInt("Name");
//                row[2] = rs.getInt("Description");
//                row[3] = rs.getInt("Price");
//                row[4] = rs.getDouble("Quantity");
//                row[5] = rs.getString("Address");
//                row[6] = rs.getString("Payment_Method");
//                model.addRow(row);
//            }
//
//            // create the table and add it to the panel
//            JTable table = new JTable(model);
//            table.setAutoResizeMode(380);
//            JScrollPane scrollPane = new JScrollPane(table);
//            jPanel1.add(scrollPane, constraints);
//            scrollPane.setPreferredSize(jPanel1.getSize());
//            jPanel1.add(scrollPane);
//            jPanel1.revalidate();
//            jPanel1.repaint();
//           
//            con.close(); // close the connection to the database
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//            }

        
//        });
    }//GEN-LAST:event_viewBusMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Userdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Userdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Userdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Userdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Userdash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel userN;
    private javax.swing.JLabel viewBus;
    // End of variables declaration//GEN-END:variables
}
