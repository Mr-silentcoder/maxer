/*
 * Main.java
 * 
 * Copyright 2019 justin Coder <chandhuchandran@email.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
package com.justin.car; // package Name


import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableModel;
import keeptoo.KGradientPanel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author justin Coder
 */
public final class Main extends javax.swing.JFrame {

    int screenX , screenY , screenXmouse , screenYmouse;
    Connection conn;
    ResultSet result;
    PreparedStatement pstatement;
    
    /**
     * Creates new form Main
     * @param panel
     */
        public void icon(){
      
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("maxer.png")));
    
    }
    /**
     * Panels
     * @param panel 
     */
    
    public void switchpanels(KGradientPanel panel){
        
        jLayeredPane1.removeAll();
        jLayeredPane1.add(panel);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
        
    }
    
    
    public void switchmainpanels(KGradientPanel panel){
        
        jLayeredPane2.removeAll();
        jLayeredPane2.add(panel);
        jLayeredPane2.repaint();
        jLayeredPane2.revalidate();
        
    }
    
    public void switchcarpanels(KGradientPanel panel){
        
        jLayeredPane3.removeAll();
        jLayeredPane3.add(panel);
        jLayeredPane3.repaint();
        jLayeredPane3.revalidate();
        
    }
    
// panel stop
    
    
    
    public Main() {
        initComponents();
        conn=connect.ConnectDb();
        icon();
        NumId();
                carTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD , 13));
                carTable.getTableHeader().setOpaque(false);
                carTable.getTableHeader().setForeground(Color.black);
                clientTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD , 13));
                clientTable.getTableHeader().setOpaque(false);
                clientTable.getTableHeader().setForeground(Color.black);
                returnTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD , 13));
                returnTable.getTableHeader().setOpaque(false);
                returnTable.getTableHeader().setForeground(Color.black);
                rentedTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD , 13));
                rentedTable.getTableHeader().setOpaque(false);
                rentedTable.getTableHeader().setForeground(Color.black);
      
        try{
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if("windows".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                break;
               } 
          }   
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex){
        ex.getMessage();
        }
  
    }
    
    /**
     * NumId - Randome Number generate 
     * 
     */
    
    public void NumId(){
        
        Random num = new Random();
        carid.setText(""+num.nextInt(1000+1));
        clientid.setText(""+num.nextInt(1000+1));
    
    }

   /**
    * 
    * carData - Car Details Table code
    * 
    */
    
    public void carData(){
    
    try{
            String sql="Select * from cars";
            pstatement = conn.prepareStatement(sql);
            result=pstatement.executeQuery();
            carTable.setModel(DbUtils.resultSetToTableModel(result));
            pstatement.close();
            result.close();
    
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e);
            
         }
    
    }
    
       /**
    * 
    * clientData - Client Details Table code
    * 
    */
     public void clientData(){
    
    try{
            String sql="Select * from client";
            pstatement = conn.prepareStatement(sql);
            result=pstatement.executeQuery();
            clientTable.setModel(DbUtils.resultSetToTableModel(result));
            pstatement.close();
            result.close();
      
        }catch(SQLException e){

            JOptionPane.showMessageDialog(null, e);
        }
    
    }
   /**
    * 
    * rentData - Rented car Details Table code
    * 
    */
    public void rentData(){
    
    try{
      String sql="Select ID , Car_ID,Car_Number,Client_ID,Name,Number,License,Advance,Time,Date from rented";
      pstatement = conn.prepareStatement(sql);
      result=pstatement.executeQuery();
      rentedTable.setModel(DbUtils.resultSetToTableModel(result));
      pstatement.close();
      result.close();
      
      }catch(SQLException e){
     JOptionPane.showMessageDialog(null, e);
    }
    
    /**
    * 
    * returnData - Return Car Details Table code
    * 
    */
    
    }
        public void returnData(){
    
    try{
        String sql="Select ID , Car_ID,Car_Number,Client_ID,Name,Number,Time,Date,Return_Time,Return_Date from return";
            pstatement = conn.prepareStatement(sql);
            result=pstatement.executeQuery();
            returnTable.setModel(DbUtils.resultSetToTableModel(result));
            pstatement.close();
            result.close();
      
        }catch(SQLException e){
         
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        welcomepanel = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Login = new keeptoo.KGradientPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel19 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        home = new keeptoo.KGradientPanel();
        RtcarBtn = new javax.swing.JButton();
        RcarBtn = new javax.swing.JButton();
        ClBtn = new javax.swing.JButton();
        CrBtn = new javax.swing.JButton();
        NcBtn = new javax.swing.JButton();
        NctBtn = new javax.swing.JButton();
        HomeBtn = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        RentedCars = new keeptoo.KGradientPanel();
        Pane4 = new javax.swing.JScrollPane();
        rentedTable = new javax.swing.JTable();
        ReturnCars = new keeptoo.KGradientPanel();
        Pane3 = new javax.swing.JScrollPane();
        returnTable = new javax.swing.JTable();
        Clients = new keeptoo.KGradientPanel();
        Pane2 = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();
        clientedit = new keeptoo.KGradientPanel();
        eadvance = new javax.swing.JTextField();
        elicense = new javax.swing.JTextField();
        enumber = new javax.swing.JTextField();
        eclientname = new javax.swing.JTextField();
        eclientid = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Cars = new keeptoo.KGradientPanel();
        Pane1 = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();
        caredit = new keeptoo.KGradientPanel();
        jButton3 = new javax.swing.JButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        ecarnumber = new javax.swing.JTextField();
        ecarname = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        ecarrent = new javax.swing.JTextField();
        ecarid = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        Newcars = new keeptoo.KGradientPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        carid = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        carname = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        carnumber = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        carrent = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Newclients = new keeptoo.KGradientPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        clientid = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        clientname = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        clientnumber = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        advance = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        licensenumber = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Hidepan = new keeptoo.KGradientPanel();
        CarRen = new javax.swing.JButton();
        CarRet = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        CarRented = new keeptoo.KGradientPanel();
        jPanel6 = new javax.swing.JPanel();
        Rcarid = new javax.swing.JTextField();
        Rcarnumber = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        Rcarname = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        Rfuel = new javax.swing.JTextField();
        Rcarrent = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Rclientid = new javax.swing.JTextField();
        Rclientnumber = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        Rclientname = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        Rclientadvance = new javax.swing.JTextField();
        Rclientlicense = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        Rdatepicker = new datechooser.beans.DateChooserCombo();
        Rtimepicker = new com.github.lgooddatepicker.components.TimePicker();
        jLabel14 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        CarReturn = new keeptoo.KGradientPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Return = new keeptoo.KGradientPanel();
        jPanel8 = new javax.swing.JPanel();
        Rcarid1 = new javax.swing.JTextField();
        Rcarnumber1 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        Rtime1 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        Rdate1 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        Rclientid1 = new javax.swing.JTextField();
        Rclientnumber1 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        Rclientname1 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        Rclientadvance1 = new javax.swing.JTextField();
        Rclientlicense1 = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        Rnid = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        Rdatepicker1 = new datechooser.beans.DateChooserCombo();
        Rtimepicker1 = new com.github.lgooddatepicker.components.TimePicker();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();

        jLabel17.setText("jLabel17");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(5, 5, 5));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(14, 14, 16), new java.awt.Color(14, 14, 16)));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 37));
        jPanel2.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/Group 9.png"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 1, 840, 38);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/Group 2.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2);
        jLabel2.setBounds(844, 3, 40, 30);

        jLabel3.setFont(new java.awt.Font("C059", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MAXER");
        jLabel3.setPreferredSize(new java.awt.Dimension(90, 18));
        jPanel2.add(jLabel3);
        jLabel3.setBounds(7, 8, 130, 30);

        jPanel3.setBackground(new java.awt.Color(5, 5, 5));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(890, 516));
        jLayeredPane1.setLayout(new java.awt.CardLayout());

        welcomepanel.setkEndColor(new java.awt.Color(254, 5, 0));
        welcomepanel.setkGradientFocus(-50);
        welcomepanel.setkStartColor(new java.awt.Color(252, 102, 0));
        welcomepanel.setLayout(null);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/button.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        welcomepanel.add(jLabel6);
        jLabel6.setBounds(150, 302, 111, 40);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/luxury.png"))); // NOI18N
        welcomepanel.add(jLabel4);
        jLabel4.setBounds(320, 80, 507, 336);

        jLabel5.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("<html> <body>  &nbsp;&nbsp;A&nbsp;CAR  FOR <br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EVERY<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NEED </body> </html>");
        welcomepanel.add(jLabel5);
        jLabel5.setBounds(20, 200, 240, 99);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/untitled.png"))); // NOI18N
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        welcomepanel.add(jLabel7);
        jLabel7.setBounds(262, 176, 10, 118);

        jLayeredPane1.add(welcomepanel, "card2");

        Login.setkEndColor(new java.awt.Color(23, 23, 25));
        Login.setkGradientFocus(2000);
        Login.setkStartColor(new java.awt.Color(0, 0, 0));
        Login.setLayout(null);

        kGradientPanel1.setkEndColor(new java.awt.Color(252, 102, 0));
        kGradientPanel1.setkGradientFocus(400);
        kGradientPanel1.setkStartColor(new java.awt.Color(254, 5, 0));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/branded2.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        Login.add(kGradientPanel1);
        kGradientPanel1.setBounds(0, 0, 445, 512);

        jLabel24.setFont(new java.awt.Font("Caladea", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("LOGIN");
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Login.add(jLabel24);
        jLabel24.setBounds(650, 196, 170, 40);

        jLabel25.setFont(new java.awt.Font("Caladea", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("MAXER");
        jLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Login.add(jLabel25);
        jLabel25.setBounds(510, 196, 140, 40);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/Group 11@2x.png"))); // NOI18N
        Login.add(jLabel18);
        jLabel18.setBounds(510, 190, 320, 60);

        password.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        password.setBackground(new java.awt.Color(17, 16, 16));
        password.setBorder(null);
        password.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        password.setForeground(new java.awt.Color(204, 204, 204));
        Login.add(password);
        password.setBounds(520, 340, 290, 40);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/Rectangle 8.png"))); // NOI18N
        Login.add(jLabel19);
        jLabel19.setBounds(490, 330, 350, 60);

        username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        username.setBackground(new java.awt.Color(17, 16, 16));
        username.setBorder(null);
        username.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(204, 204, 204));
        Login.add(username);
        username.setBounds(520, 271, 290, 40);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/Rectangle 8.png"))); // NOI18N
        Login.add(jLabel20);
        jLabel20.setBounds(490, 260, 350, 60);

        jLabel27.setFont(new java.awt.Font("C059", 1, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Sign In");
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        Login.add(jLabel27);
        jLabel27.setBounds(510, 411, 310, 40);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/Rectangle 10@2x.png"))); // NOI18N
        Login.add(jLabel21);
        jLabel21.setBounds(508, 400, 320, 60);

        jLabel22.setForeground(new java.awt.Color(80, 77, 77));
        jLabel22.setText("Password");
        Login.add(jLabel22);
        jLabel22.setBounds(510, 320, 90, 15);

        jLabel23.setForeground(new java.awt.Color(80, 77, 77));
        jLabel23.setText("Username");
        Login.add(jLabel23);
        jLabel23.setBounds(510, 250, 90, 15);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/Group 10@2x.png"))); // NOI18N
        Login.add(jLabel26);
        jLabel26.setBounds(600, 70, 130, 110);

        jLayeredPane1.add(Login, "card4");

        home.setkEndColor(new java.awt.Color(0, 0, 0));
        home.setkStartColor(new java.awt.Color(23, 23, 25));
        home.setLayout(null);

        RtcarBtn.setBackground(new java.awt.Color(252, 102, 0));
        RtcarBtn.setForeground(new java.awt.Color(255, 255, 255));
        RtcarBtn.setText("Rented Cars");
        RtcarBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        RtcarBtn.setBorderPainted(false);
        RtcarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RtcarBtn.setFocusPainted(false);
        RtcarBtn.setMargin(new java.awt.Insets(3, 14, 3, 14));
        RtcarBtn.setMaximumSize(new java.awt.Dimension(63, 20));
        RtcarBtn.setMinimumSize(new java.awt.Dimension(63, 20));
        RtcarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RtcarBtnMouseClicked(evt);
            }
        });
        RtcarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RtcarBtnActionPerformed(evt);
            }
        });
        home.add(RtcarBtn);
        RtcarBtn.setBounds(42, 0, 130, 30);

        RcarBtn.setBackground(new java.awt.Color(0, 0, 0));
        RcarBtn.setForeground(new java.awt.Color(255, 255, 255));
        RcarBtn.setText("Return Cars");
        RcarBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        RcarBtn.setBorderPainted(false);
        RcarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RcarBtn.setFocusable(false);
        RcarBtn.setMargin(new java.awt.Insets(3, 14, 3, 14));
        RcarBtn.setMaximumSize(new java.awt.Dimension(63, 20));
        RcarBtn.setMinimumSize(new java.awt.Dimension(63, 20));
        RcarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RcarBtnMouseClicked(evt);
            }
        });
        home.add(RcarBtn);
        RcarBtn.setBounds(173, 0, 140, 30);

        ClBtn.setBackground(new java.awt.Color(0, 0, 0));
        ClBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClBtn.setText("Clients");
        ClBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        ClBtn.setBorderPainted(false);
        ClBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClBtn.setFocusable(false);
        ClBtn.setMargin(new java.awt.Insets(3, 14, 3, 14));
        ClBtn.setMaximumSize(new java.awt.Dimension(63, 20));
        ClBtn.setMinimumSize(new java.awt.Dimension(63, 20));
        ClBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClBtnMouseClicked(evt);
            }
        });
        home.add(ClBtn);
        ClBtn.setBounds(314, 0, 140, 30);

        CrBtn.setBackground(new java.awt.Color(0, 0, 0));
        CrBtn.setForeground(new java.awt.Color(255, 255, 255));
        CrBtn.setText("Cars");
        CrBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        CrBtn.setBorderPainted(false);
        CrBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CrBtn.setFocusable(false);
        CrBtn.setMargin(new java.awt.Insets(3, 14, 3, 14));
        CrBtn.setMaximumSize(new java.awt.Dimension(63, 20));
        CrBtn.setMinimumSize(new java.awt.Dimension(63, 20));
        CrBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrBtnMouseClicked(evt);
            }
        });
        home.add(CrBtn);
        CrBtn.setBounds(456, 0, 140, 30);

        NcBtn.setBackground(new java.awt.Color(0, 0, 0));
        NcBtn.setForeground(new java.awt.Color(255, 255, 255));
        NcBtn.setText("New Cars");
        NcBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        NcBtn.setBorderPainted(false);
        NcBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NcBtn.setFocusable(false);
        NcBtn.setMargin(new java.awt.Insets(3, 14, 3, 14));
        NcBtn.setMaximumSize(new java.awt.Dimension(63, 20));
        NcBtn.setMinimumSize(new java.awt.Dimension(63, 20));
        NcBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NcBtnMouseClicked(evt);
            }
        });
        home.add(NcBtn);
        NcBtn.setBounds(598, 0, 140, 30);

        NctBtn.setBackground(new java.awt.Color(0, 0, 0));
        NctBtn.setForeground(new java.awt.Color(255, 255, 255));
        NctBtn.setText("New Clients");
        NctBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        NctBtn.setBorderPainted(false);
        NctBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NctBtn.setFocusable(false);
        NctBtn.setMargin(new java.awt.Insets(3, 14, 3, 14));
        NctBtn.setMaximumSize(new java.awt.Dimension(63, 20));
        NctBtn.setMinimumSize(new java.awt.Dimension(63, 20));
        NctBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NctBtnMouseClicked(evt);
            }
        });
        home.add(NctBtn);
        NctBtn.setBounds(740, 0, 140, 30);

        HomeBtn.setBackground(new java.awt.Color(0, 0, 0));
        HomeBtn.setForeground(new java.awt.Color(255, 255, 255));
        HomeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/cube-outline.png"))); // NOI18N
        HomeBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        HomeBtn.setBorderPainted(false);
        HomeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HomeBtn.setFocusable(false);
        HomeBtn.setMargin(new java.awt.Insets(3, 14, 3, 14));
        HomeBtn.setMaximumSize(new java.awt.Dimension(63, 20));
        HomeBtn.setMinimumSize(new java.awt.Dimension(63, 20));
        HomeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeBtnMouseClicked(evt);
            }
        });
        home.add(HomeBtn);
        HomeBtn.setBounds(-1, 0, 42, 30);

        jLayeredPane2.setLayout(new java.awt.CardLayout());

        RentedCars.setkEndColor(new java.awt.Color(0, 0, 0));
        RentedCars.setkGradientFocus(700);
        RentedCars.setkStartColor(new java.awt.Color(23, 23, 25));

        Pane4.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pane4.setBackground(new java.awt.Color(255, 102, 51));
        Pane4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(23, 23, 25), 0, true));
        Pane4.setFocusable(false);
        Pane4.setForeground(new java.awt.Color(255, 51, 51));
        Pane4.setOpaque(false);
        Pane4.setRequestFocusEnabled(false);

        rentedTable.setBackground(new java.awt.Color(23, 23, 25));
        rentedTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 25), 0));
        rentedTable.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rentedTable.setForeground(new java.awt.Color(255, 255, 255));
        rentedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Car ID", "Car Name", "Client ID", "Name", "Number", "License", "Advance", "Time", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rentedTable.setFocusable(false);
        rentedTable.setGridColor(new java.awt.Color(11, 11, 11));
        rentedTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        rentedTable.setRequestFocusEnabled(false);
        rentedTable.setRowHeight(25);
        rentedTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        rentedTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        rentedTable.setShowVerticalLines(false);
        rentedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rentedTableMouseClicked(evt);
            }
        });
        Pane4.setViewportView(rentedTable);
        if (rentedTable.getColumnModel().getColumnCount() > 0) {
            rentedTable.getColumnModel().getColumn(0).setResizable(false);
            rentedTable.getColumnModel().getColumn(2).setResizable(false);
            rentedTable.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout RentedCarsLayout = new javax.swing.GroupLayout(RentedCars);
        RentedCars.setLayout(RentedCarsLayout);
        RentedCarsLayout.setHorizontalGroup(
            RentedCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pane4, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        RentedCarsLayout.setVerticalGroup(
            RentedCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pane4, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLayeredPane2.add(RentedCars, "card2");

        ReturnCars.setkEndColor(new java.awt.Color(0, 0, 0));
        ReturnCars.setkGradientFocus(700);
        ReturnCars.setkStartColor(new java.awt.Color(23, 23, 25));

        Pane3.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pane3.setBackground(new java.awt.Color(255, 102, 51));
        Pane3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(23, 23, 25), 0, true));
        Pane3.setFocusable(false);
        Pane3.setForeground(new java.awt.Color(255, 51, 51));
        Pane3.setOpaque(false);
        Pane3.setRequestFocusEnabled(false);

        returnTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 25), 0));
        returnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Car ID", "Car Name", "Car Number", "Car Rent", "Fuel Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        returnTable.setBackground(new java.awt.Color(23, 23, 25));
        returnTable.setFocusable(false);
        returnTable.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        returnTable.setForeground(new java.awt.Color(255, 255, 255));
        returnTable.setGridColor(new java.awt.Color(11, 11, 11));
        returnTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        returnTable.setRequestFocusEnabled(false);
        returnTable.setRowHeight(25);
        returnTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        returnTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        returnTable.setShowVerticalLines(false);
        returnTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnTableMouseClicked(evt);
            }
        });
        Pane3.setViewportView(returnTable);

        javax.swing.GroupLayout ReturnCarsLayout = new javax.swing.GroupLayout(ReturnCars);
        ReturnCars.setLayout(ReturnCarsLayout);
        ReturnCarsLayout.setHorizontalGroup(
            ReturnCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pane3, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        ReturnCarsLayout.setVerticalGroup(
            ReturnCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pane3, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLayeredPane2.add(ReturnCars, "card3");

        Clients.setkEndColor(new java.awt.Color(0, 0, 0));
        Clients.setkGradientFocus(700);
        Clients.setkStartColor(new java.awt.Color(23, 23, 25));

        Pane2.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pane2.setBackground(new java.awt.Color(255, 102, 51));
        Pane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(23, 23, 25), 0, true));
        Pane2.setFocusable(false);
        Pane2.setForeground(new java.awt.Color(255, 51, 51));
        Pane2.setOpaque(false);
        Pane2.setRequestFocusEnabled(false);

        clientTable.setBackground(new java.awt.Color(23, 23, 25));
        clientTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 25), 0));
        clientTable.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        clientTable.setForeground(new java.awt.Color(255, 255, 255));
        clientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Client ID", "Client Name", "Client Number", "License Number", "Advance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        clientTable.setFocusable(false);
        clientTable.setGridColor(new java.awt.Color(11, 11, 11));
        clientTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        clientTable.setRequestFocusEnabled(false);
        clientTable.setRowHeight(25);
        clientTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        clientTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        clientTable.setShowVerticalLines(false);
        clientTable.getTableHeader().setReorderingAllowed(false);
        clientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientTableMouseClicked(evt);
            }
        });
        Pane2.setViewportView(clientTable);

        javax.swing.GroupLayout ClientsLayout = new javax.swing.GroupLayout(Clients);
        Clients.setLayout(ClientsLayout);
        ClientsLayout.setHorizontalGroup(
            ClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pane2, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        ClientsLayout.setVerticalGroup(
            ClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLayeredPane2.add(Clients, "card2");

        clientedit.setkEndColor(new java.awt.Color(0, 0, 0));
        clientedit.setkStartColor(new java.awt.Color(23, 23, 25));
        clientedit.setLayout(null);

        eadvance.setBackground(new java.awt.Color(23, 23, 25));
        eadvance.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        eadvance.setForeground(new java.awt.Color(255, 255, 255));
        eadvance.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        eadvance.setText("  ");
        eadvance.setBorder(null);
        clientedit.add(eadvance);
        eadvance.setBounds(360, 307, 225, 30);

        elicense.setBackground(new java.awt.Color(23, 23, 25));
        elicense.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        elicense.setForeground(new java.awt.Color(255, 255, 255));
        elicense.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        elicense.setText("  ");
        elicense.setBorder(null);
        clientedit.add(elicense);
        elicense.setBounds(360, 270, 225, 30);

        enumber.setBackground(new java.awt.Color(23, 23, 25));
        enumber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        enumber.setForeground(new java.awt.Color(255, 255, 255));
        enumber.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        enumber.setText("  ");
        enumber.setBorder(null);
        clientedit.add(enumber);
        enumber.setBounds(360, 233, 225, 30);

        eclientname.setBackground(new java.awt.Color(23, 23, 25));
        eclientname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        eclientname.setForeground(new java.awt.Color(255, 255, 255));
        eclientname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        eclientname.setText("  ");
        eclientname.setBorder(null);
        clientedit.add(eclientname);
        eclientname.setBounds(360, 196, 225, 30);

        eclientid.setEditable(false);
        eclientid.setBackground(new java.awt.Color(23, 23, 25));
        eclientid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        eclientid.setForeground(new java.awt.Color(255, 255, 255));
        eclientid.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        eclientid.setText("  ");
        eclientid.setBorder(null);
        clientedit.add(eclientid);
        eclientid.setBounds(360, 160, 225, 30);

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Client ID  :");
        clientedit.add(jLabel42);
        jLabel42.setBounds(240, 160, 110, 30);

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Client Name  :");
        clientedit.add(jLabel43);
        jLabel43.setBounds(210, 200, 140, 24);

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Client Number  :");
        clientedit.add(jLabel44);
        jLabel44.setBounds(190, 236, 160, 24);

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("License Number  :");
        clientedit.add(jLabel45);
        jLabel45.setBounds(180, 270, 170, 24);

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Client Advance  :");
        clientedit.add(jLabel46);
        jLabel46.setBounds(190, 310, 160, 24);

        jLabel47.setFont(new java.awt.Font("C059", 1, 20)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Edit Client");
        clientedit.add(jLabel47);
        jLabel47.setBounds(310, 120, 320, 30);

        jButton4.setBackground(new java.awt.Color(252, 102, 0));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Edit");
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusable(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        clientedit.add(jButton4);
        jButton4.setBounds(360, 345, 225, 37);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/dot-arrow.png"))); // NOI18N
        jLabel8.setText("Back");
        jLabel8.setAlignmentX(33.0F);
        jLabel8.setAlignmentY(50.0F);
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        clientedit.add(jLabel8);
        jLabel8.setBounds(0, 10, 90, 50);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/basket.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        clientedit.add(jLabel9);
        jLabel9.setBounds(790, 420, 40, 40);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/arating.png"))); // NOI18N
        clientedit.add(jLabel10);
        jLabel10.setBounds(430, 70, 80, 50);

        jLayeredPane2.add(clientedit, "card9");

        Cars.setkEndColor(new java.awt.Color(0, 0, 0));
        Cars.setkGradientFocus(700);
        Cars.setkStartColor(new java.awt.Color(23, 23, 25));

        Pane1.setBackground(new java.awt.Color(255, 102, 51));
        Pane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(23, 23, 25), 0, true));
        Pane1.setFocusable(false);
        Pane1.setForeground(new java.awt.Color(255, 51, 51));
        Pane1.setOpaque(false);
        Pane1.setRequestFocusEnabled(false);

        carTable.setBackground(new java.awt.Color(23, 23, 25));
        carTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 23, 25), 0));
        carTable.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        carTable.setForeground(new java.awt.Color(255, 255, 255));
        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Car ID", "Car Name", "Car Number", "Car Rent", "Fuel Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        carTable.setFocusable(false);
        carTable.setGridColor(new java.awt.Color(11, 11, 11));
        carTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        carTable.setRequestFocusEnabled(false);
        carTable.setRowHeight(25);
        carTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        carTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        carTable.setShowVerticalLines(false);
        carTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carTableMouseClicked(evt);
            }
        });
        Pane1.setViewportView(carTable);

        javax.swing.GroupLayout CarsLayout = new javax.swing.GroupLayout(Cars);
        Cars.setLayout(CarsLayout);
        CarsLayout.setHorizontalGroup(
            CarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        CarsLayout.setVerticalGroup(
            CarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLayeredPane2.add(Cars, "card2");

        caredit.setkEndColor(new java.awt.Color(0, 0, 0));
        caredit.setkStartColor(new java.awt.Color(23, 23, 25));
        caredit.setLayout(null);

        jButton3.setBackground(new java.awt.Color(252, 102, 0));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Edit");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusable(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        caredit.add(jButton3);
        jButton3.setBounds(360, 340, 225, 37);

        jRadioButton3.setBackground(new java.awt.Color(23, 23, 25));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Diesel");
        jRadioButton3.setFocusable(false);
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });
        caredit.add(jRadioButton3);
        jRadioButton3.setBounds(360, 306, 110, 28);

        jRadioButton4.setBackground(new java.awt.Color(23, 23, 25));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Petrol");
        jRadioButton4.setFocusable(false);
        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton4MouseClicked(evt);
            }
        });
        caredit.add(jRadioButton4);
        jRadioButton4.setBounds(476, 306, 109, 28);

        jLabel48.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Car Fuel Type  :");
        caredit.add(jLabel48);
        jLabel48.setBounds(180, 305, 170, 24);

        jLabel49.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Car Number  :");
        caredit.add(jLabel49);
        jLabel49.setBounds(190, 271, 160, 24);

        ecarnumber.setBackground(new java.awt.Color(23, 23, 25));
        ecarnumber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ecarnumber.setForeground(new java.awt.Color(255, 255, 255));
        ecarnumber.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ecarnumber.setText("  ");
        ecarnumber.setBorder(null);
        caredit.add(ecarnumber);
        ecarnumber.setBounds(360, 270, 225, 30);

        ecarname.setBackground(new java.awt.Color(23, 23, 25));
        ecarname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ecarname.setForeground(new java.awt.Color(255, 255, 255));
        ecarname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ecarname.setText("  ");
        ecarname.setBorder(null);
        caredit.add(ecarname);
        ecarname.setBounds(360, 234, 225, 30);

        jLabel50.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Car Name  :");
        caredit.add(jLabel50);
        jLabel50.setBounds(203, 238, 150, 24);

        jLabel51.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Car Rent  :");
        caredit.add(jLabel51);
        jLabel51.setBounds(215, 200, 140, 24);

        ecarrent.setBackground(new java.awt.Color(23, 23, 25));
        ecarrent.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ecarrent.setForeground(new java.awt.Color(255, 255, 255));
        ecarrent.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ecarrent.setText("  ");
        ecarrent.setBorder(null);
        caredit.add(ecarrent);
        ecarrent.setBounds(360, 197, 225, 30);

        ecarid.setEditable(false);
        ecarid.setBackground(new java.awt.Color(23, 23, 25));
        ecarid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ecarid.setForeground(new java.awt.Color(255, 255, 255));
        ecarid.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ecarid.setText("  ");
        ecarid.setBorder(null);
        caredit.add(ecarid);
        ecarid.setBounds(360, 160, 225, 30);

        jLabel52.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Car ID  :");
        caredit.add(jLabel52);
        jLabel52.setBounds(235, 160, 120, 30);

        jLabel53.setFont(new java.awt.Font("C059", 1, 20)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Edit Cars");
        caredit.add(jLabel53);
        jLabel53.setBounds(310, 110, 320, 40);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/dot-arrow.png"))); // NOI18N
        jLabel11.setText("Back");
        jLabel11.setAlignmentX(33.0F);
        jLabel11.setAlignmentY(50.0F);
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        caredit.add(jLabel11);
        jLabel11.setBounds(0, 10, 90, 50);

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/basket.png"))); // NOI18N
        jLabel54.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
        });
        caredit.add(jLabel54);
        jLabel54.setBounds(790, 420, 40, 40);

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/speed-meter.png"))); // NOI18N
        caredit.add(jLabel55);
        jLabel55.setBounds(440, 70, 60, 40);

        jLayeredPane2.add(caredit, "card10");

        Newcars.setkEndColor(new java.awt.Color(0, 0, 0));
        Newcars.setkGradientFocus(700);
        Newcars.setkStartColor(new java.awt.Color(23, 23, 25));
        Newcars.setLayout(null);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/branded2.png"))); // NOI18N
        Newcars.add(jLabel12);
        jLabel12.setBounds(10, 0, 420, 480);

        jPanel4.setBackground(new java.awt.Color(12, 12, 12));
        jPanel4.setLayout(null);

        jLabel28.setFont(new java.awt.Font("C059", 1, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Add New Cars");
        jPanel4.add(jLabel28);
        jLabel28.setBounds(110, 110, 320, 45);

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Car ID  :");
        jPanel4.add(jLabel30);
        jLabel30.setBounds(53, 163, 100, 30);

        carid.setEditable(false);
        carid.setBackground(new java.awt.Color(23, 23, 25));
        carid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        carid.setForeground(new java.awt.Color(255, 255, 255));
        carid.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        carid.setText("  ");
        carid.setBorder(null);
        jPanel4.add(carid);
        carid.setBounds(159, 164, 225, 30);

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Car Name  :");
        jPanel4.add(jLabel31);
        jLabel31.setBounds(23, 238, 130, 24);

        carname.setBackground(new java.awt.Color(23, 23, 25));
        carname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        carname.setForeground(new java.awt.Color(255, 255, 255));
        carname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        carname.setText("  ");
        carname.setBorder(null);
        jPanel4.add(carname);
        carname.setBounds(159, 236, 225, 30);

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Car Number  :");
        jPanel4.add(jLabel32);
        jLabel32.setBounds(3, 274, 150, 24);

        carnumber.setBackground(new java.awt.Color(23, 23, 25));
        carnumber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        carnumber.setForeground(new java.awt.Color(255, 255, 255));
        carnumber.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        carnumber.setText("  ");
        carnumber.setBorder(null);
        jPanel4.add(carnumber);
        carnumber.setBounds(159, 272, 225, 30);

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Car Rent  :");
        jPanel4.add(jLabel33);
        jLabel33.setBounds(33, 202, 120, 24);

        carrent.setBackground(new java.awt.Color(23, 23, 25));
        carrent.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        carrent.setForeground(new java.awt.Color(255, 255, 255));
        carrent.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        carrent.setText("  ");
        carrent.setBorder(null);
        jPanel4.add(carrent);
        carrent.setBounds(159, 200, 225, 30);

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Car Fuel Type  :");
        jPanel4.add(jLabel34);
        jLabel34.setBounds(-7, 310, 160, 24);

        jRadioButton1.setBackground(new java.awt.Color(23, 23, 25));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Diesel");
        jRadioButton1.setFocusable(false);
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jPanel4.add(jRadioButton1);
        jRadioButton1.setBounds(159, 308, 110, 28);

        jRadioButton2.setBackground(new java.awt.Color(23, 23, 25));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Petrol");
        jRadioButton2.setFocusable(false);
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        jPanel4.add(jRadioButton2);
        jRadioButton2.setBounds(275, 308, 109, 28);

        jButton1.setBackground(new java.awt.Color(252, 102, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setLabel("Submit");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(158, 342, 225, 37);

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/speed-meter.png"))); // NOI18N
        jPanel4.add(jLabel56);
        jLabel56.setBounds(230, 70, 80, 60);

        Newcars.add(jPanel4);
        jPanel4.setBounds(440, 0, 440, 480);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/banner.png"))); // NOI18N
        jLabel29.setBackground(new java.awt.Color(1, 1, 1));
        Newcars.add(jLabel29);
        jLabel29.setBounds(134, -14, 680, 510);

        jLayeredPane2.add(Newcars, "card2");

        Newclients.setkEndColor(new java.awt.Color(0, 0, 0));
        Newclients.setkGradientFocus(700);
        Newclients.setkStartColor(new java.awt.Color(23, 23, 25));
        Newclients.setLayout(null);

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/indexCTApeople.png"))); // NOI18N
        Newclients.add(jLabel35);
        jLabel35.setBounds(0, 0, 370, 480);

        jPanel5.setBackground(new java.awt.Color(12, 12, 12));
        jPanel5.setLayout(null);

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Client ID  :");
        jPanel5.add(jLabel36);
        jLabel36.setBounds(53, 163, 100, 30);

        clientid.setBackground(new java.awt.Color(23, 23, 25));
        clientid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        clientid.setForeground(new java.awt.Color(255, 255, 255));
        clientid.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        clientid.setText("  ");
        clientid.setBorder(null);
        jPanel5.add(clientid);
        clientid.setBounds(159, 164, 225, 30);

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Client Name  :");
        jPanel5.add(jLabel37);
        jLabel37.setBounds(23, 202, 130, 24);

        clientname.setBackground(new java.awt.Color(23, 23, 25));
        clientname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        clientname.setForeground(new java.awt.Color(255, 255, 255));
        clientname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        clientname.setText("  ");
        clientname.setBorder(null);
        jPanel5.add(clientname);
        clientname.setBounds(159, 200, 225, 30);

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Client Number  :");
        jPanel5.add(jLabel38);
        jLabel38.setBounds(3, 238, 150, 24);

        clientnumber.setBackground(new java.awt.Color(23, 23, 25));
        clientnumber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        clientnumber.setForeground(new java.awt.Color(255, 255, 255));
        clientnumber.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        clientnumber.setText("  ");
        clientnumber.setBorder(null);
        jPanel5.add(clientnumber);
        clientnumber.setBounds(159, 236, 225, 30);

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("License Number  :");
        jPanel5.add(jLabel39);
        jLabel39.setBounds(-7, 274, 160, 24);

        advance.setBackground(new java.awt.Color(23, 23, 25));
        advance.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        advance.setForeground(new java.awt.Color(255, 255, 255));
        advance.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        advance.setText("  ");
        advance.setBorder(null);
        jPanel5.add(advance);
        advance.setBounds(159, 308, 225, 30);

        jLabel40.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Client Advance  :");
        jPanel5.add(jLabel40);
        jLabel40.setBounds(3, 310, 150, 24);

        jButton2.setBackground(new java.awt.Color(252, 102, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.setLabel("Submit");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jPanel5.add(jButton2);
        jButton2.setBounds(159, 345, 225, 37);

        licensenumber.setBackground(new java.awt.Color(23, 23, 25));
        licensenumber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        licensenumber.setForeground(new java.awt.Color(255, 255, 255));
        licensenumber.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        licensenumber.setText("  ");
        licensenumber.setBorder(null);
        jPanel5.add(licensenumber);
        licensenumber.setBounds(159, 272, 225, 30);

        jLabel41.setFont(new java.awt.Font("C059", 1, 20)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Add New Clients");
        jPanel5.add(jLabel41);
        jLabel41.setBounds(110, 110, 320, 45);

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/arating.png"))); // NOI18N
        jPanel5.add(jLabel57);
        jLabel57.setBounds(230, 60, 70, 60);

        Newclients.add(jPanel5);
        jPanel5.setBounds(430, 0, 450, 480);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/banner.png"))); // NOI18N
        Newclients.add(jLabel13);
        jLabel13.setBounds(210, -10, 650, 500);

        jLayeredPane2.add(Newclients, "card2");

        Hidepan.setkEndColor(new java.awt.Color(0, 0, 0));
        Hidepan.setkGradientFocus(700);
        Hidepan.setkStartColor(new java.awt.Color(0, 0, 0));
        Hidepan.setLayout(null);

        CarRen.setBackground(new java.awt.Color(0, 0, 0));
        CarRen.setForeground(new java.awt.Color(255, 255, 255));
        CarRen.setText("Car Rented");
        CarRen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        CarRen.setBorderPainted(false);
        CarRen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CarRen.setFocusable(false);
        CarRen.setMargin(new java.awt.Insets(3, 14, 3, 14));
        CarRen.setMaximumSize(new java.awt.Dimension(63, 20));
        CarRen.setMinimumSize(new java.awt.Dimension(63, 20));
        CarRen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarRenMouseClicked(evt);
            }
        });
        CarRen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarRenActionPerformed(evt);
            }
        });
        Hidepan.add(CarRen);
        CarRen.setBounds(120, 449, 140, 30);

        CarRet.setBackground(new java.awt.Color(0, 0, 0));
        CarRet.setForeground(new java.awt.Color(255, 255, 255));
        CarRet.setText("Contact Us");
        CarRet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        CarRet.setBorderPainted(false);
        CarRet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CarRet.setFocusable(false);
        CarRet.setMargin(new java.awt.Insets(3, 14, 3, 14));
        CarRet.setMaximumSize(new java.awt.Dimension(63, 20));
        CarRet.setMinimumSize(new java.awt.Dimension(63, 20));
        CarRet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarRetMouseClicked(evt);
            }
        });
        CarRet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarRetActionPerformed(evt);
            }
        });
        Hidepan.add(CarRet);
        CarRet.setBounds(620, 449, 140, 30);

        jLayeredPane3.setLayout(new java.awt.CardLayout());

        CarRented.setkEndColor(new java.awt.Color(0, 0, 0));
        CarRented.setkStartColor(new java.awt.Color(23, 23, 25));
        CarRented.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(23, 23, 25));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Car Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setLayout(null);

        Rcarid.setBackground(new java.awt.Color(19, 19, 19));
        Rcarid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Rcarid.setForeground(new java.awt.Color(255, 255, 255));
        Rcarid.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Rcarid.setBorder(null);
        jPanel6.add(Rcarid);
        Rcarid.setBounds(170, 100, 123, 30);

        Rcarnumber.setEditable(false);
        Rcarnumber.setBackground(new java.awt.Color(19, 19, 19));
        Rcarnumber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Rcarnumber.setForeground(new java.awt.Color(153, 153, 153));
        Rcarnumber.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Rcarnumber.setText("  ");
        Rcarnumber.setBorder(null);
        jPanel6.add(Rcarnumber);
        Rcarnumber.setBounds(170, 215, 225, 30);

        jLabel66.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel66.setText("Car Rent  :");
        jPanel6.add(jLabel66);
        jLabel66.setBounds(77, 270, 80, 24);

        jLabel65.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel65.setText("Car Number  :");
        jPanel6.add(jLabel65);
        jLabel65.setBounds(53, 212, 110, 30);

        Rcarname.setEditable(false);
        Rcarname.setBackground(new java.awt.Color(19, 19, 19));
        Rcarname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Rcarname.setForeground(new java.awt.Color(153, 153, 153));
        Rcarname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Rcarname.setText("  ");
        Rcarname.setBorder(null);
        jPanel6.add(Rcarname);
        Rcarname.setBounds(170, 158, 225, 30);

        jLabel61.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel61.setText("Car Fuel Type  :");
        jPanel6.add(jLabel61);
        jLabel61.setBounds(40, 330, 120, 24);

        jButton5.setBackground(new java.awt.Color(252, 102, 0));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Search");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusable(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5);
        jButton5.setBounds(295, 100, 100, 28);

        Rfuel.setEditable(false);
        Rfuel.setBackground(new java.awt.Color(19, 19, 19));
        Rfuel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Rfuel.setForeground(new java.awt.Color(153, 153, 153));
        Rfuel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Rfuel.setText("  ");
        Rfuel.setBorder(null);
        jPanel6.add(Rfuel);
        Rfuel.setBounds(170, 327, 225, 30);

        Rcarrent.setEditable(false);
        Rcarrent.setBackground(new java.awt.Color(19, 19, 19));
        Rcarrent.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Rcarrent.setForeground(new java.awt.Color(153, 153, 153));
        Rcarrent.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Rcarrent.setText("  ");
        Rcarrent.setBorder(null);
        jPanel6.add(Rcarrent);
        Rcarrent.setBounds(170, 270, 225, 30);

        jLabel64.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("Car ID :");
        jPanel6.add(jLabel64);
        jLabel64.setBounds(100, 100, 70, 30);

        jLabel67.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel67.setText("Car Name  :");
        jPanel6.add(jLabel67);
        jLabel67.setBounds(70, 160, 90, 30);

        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/speed-meter.png"))); // NOI18N
        jPanel6.add(jLabel58);
        jLabel58.setBounds(50, 40, 360, 50);

        CarRented.add(jPanel6);
        jPanel6.setBounds(15, 20, 420, 380);

        jPanel7.setBackground(new java.awt.Color(23, 23, 25));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel7.setLayout(null);

        Rclientid.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Rclientid.setBackground(new java.awt.Color(19, 19, 19));
        Rclientid.setBorder(null);
        Rclientid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Rclientid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(Rclientid);
        Rclientid.setBounds(170, 100, 123, 30);

        Rclientnumber.setEditable(false);
        Rclientnumber.setBackground(new java.awt.Color(19, 19, 19));
        Rclientnumber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Rclientnumber.setForeground(new java.awt.Color(153, 153, 153));
        Rclientnumber.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Rclientnumber.setText("  ");
        Rclientnumber.setBorder(null);
        jPanel7.add(Rclientnumber);
        Rclientnumber.setBounds(170, 215, 225, 30);

        jLabel68.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel68.setText("Client License  :");
        jPanel7.add(jLabel68);
        jLabel68.setBounds(37, 270, 120, 24);

        jLabel69.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel69.setText("Client Number  :");
        jPanel7.add(jLabel69);
        jLabel69.setBounds(33, 212, 130, 30);

        Rclientname.setEditable(false);
        Rclientname.setBackground(new java.awt.Color(19, 19, 19));
        Rclientname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Rclientname.setForeground(new java.awt.Color(153, 153, 153));
        Rclientname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Rclientname.setText("  ");
        Rclientname.setBorder(null);
        jPanel7.add(Rclientname);
        Rclientname.setBounds(170, 158, 225, 30);

        jLabel62.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel62.setText("Client Advance  :");
        jPanel7.add(jLabel62);
        jLabel62.setBounds(30, 330, 130, 24);

        jButton6.setBackground(new java.awt.Color(252, 102, 0));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Search");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusable(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
        });
        jPanel7.add(jButton6);
        jButton6.setBounds(295, 100, 100, 28);

        Rclientadvance.setEditable(false);
        Rclientadvance.setBackground(new java.awt.Color(19, 19, 19));
        Rclientadvance.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Rclientadvance.setForeground(new java.awt.Color(153, 153, 153));
        Rclientadvance.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Rclientadvance.setText("  ");
        Rclientadvance.setBorder(null);
        jPanel7.add(Rclientadvance);
        Rclientadvance.setBounds(170, 327, 225, 30);

        Rclientlicense.setEditable(false);
        Rclientlicense.setBackground(new java.awt.Color(19, 19, 19));
        Rclientlicense.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Rclientlicense.setForeground(new java.awt.Color(153, 153, 153));
        Rclientlicense.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Rclientlicense.setText("  ");
        Rclientlicense.setBorder(null);
        jPanel7.add(Rclientlicense);
        Rclientlicense.setBounds(170, 270, 225, 30);

        jLabel70.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel70.setText("Client ID :");
        jPanel7.add(jLabel70);
        jLabel70.setBounds(80, 100, 90, 30);

        jLabel71.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("Client Name  :");
        jPanel7.add(jLabel71);
        jLabel71.setBounds(50, 160, 110, 30);

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/arating.png"))); // NOI18N
        jPanel7.add(jLabel59);
        jLabel59.setBounds(70, 40, 340, 50);

        CarRented.add(jPanel7);
        jPanel7.setBounds(440, 20, 420, 380);

        jButton7.setBackground(new java.awt.Color(252, 102, 0));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Submit");
        jButton7.setBorder(null);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusable(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
        });
        CarRented.add(jButton7);
        jButton7.setBounds(680, 406, 130, 35);

        Rdatepicker.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    Rdatepicker.setCalendarBackground(new java.awt.Color(0, 0, 0));
    Rdatepicker.setFormat(2);
    CarRented.add(Rdatepicker);
    Rdatepicker.setBounds(520, 412, 130, 25);

    Rtimepicker.setBackground(new java.awt.Color(0, 0, 0));
    CarRented.add(Rtimepicker);
    Rtimepicker.setBounds(300, 409, 105, 25);

    jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(255, 255, 255));
    jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel14.setText("Time :");
    CarRented.add(jLabel14);
    jLabel14.setBounds(220, 401, 80, 40);

    jLabel60.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jLabel60.setForeground(new java.awt.Color(255, 255, 255));
    jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel60.setText("Date :");
    CarRented.add(jLabel60);
    jLabel60.setBounds(443, 403, 80, 40);

    jLayeredPane3.add(CarRented, "card2");

    CarReturn.setkEndColor(new java.awt.Color(23, 23, 25));
    CarReturn.setkGradientFocus(2000);
    CarReturn.setkStartColor(new java.awt.Color(0, 0, 0));

    jLabel75.setText("<html>\n<body>\nMaxer Rent A car Application\n<br /><br />\nCreated By Justin\n<br/>\nContact  : chandhuchandran@gmail.com\n</body>\n</html>");
    jLabel75.setForeground(new java.awt.Color(255, 255, 255));

    jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/Group 10@2x.png"))); // NOI18N

    javax.swing.GroupLayout CarReturnLayout = new javax.swing.GroupLayout(CarReturn);
    CarReturn.setLayout(CarReturnLayout);
    CarReturnLayout.setHorizontalGroup(
        CarReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CarReturnLayout.createSequentialGroup()
            .addContainerGap(220, Short.MAX_VALUE)
            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(201, 201, 201))
    );
    CarReturnLayout.setVerticalGroup(
        CarReturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(CarReturnLayout.createSequentialGroup()
            .addContainerGap(30, Short.MAX_VALUE)
            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(59, 59, 59))
        .addGroup(CarReturnLayout.createSequentialGroup()
            .addGap(145, 145, 145)
            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jLayeredPane3.add(CarReturn, "card3");

    Hidepan.add(jLayeredPane3);
    jLayeredPane3.setBounds(0, 0, 875, 447);

    jLayeredPane2.add(Hidepan, "card2");

    Return.setkEndColor(new java.awt.Color(0, 0, 0));
    Return.setkStartColor(new java.awt.Color(23, 23, 25));
    Return.setLayout(null);

    jPanel8.setBackground(new java.awt.Color(23, 23, 25));
    jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Return", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
    jPanel8.setLayout(null);

    Rcarid1.setEditable(false);
    Rcarid1.setBackground(new java.awt.Color(19, 19, 19));
    Rcarid1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    Rcarid1.setForeground(new java.awt.Color(153, 153, 153));
    Rcarid1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    Rcarid1.setBorder(null);
    jPanel8.add(Rcarid1);
    Rcarid1.setBounds(170, 100, 225, 30);

    Rcarnumber1.setEditable(false);
    Rcarnumber1.setBackground(new java.awt.Color(19, 19, 19));
    Rcarnumber1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    Rcarnumber1.setForeground(new java.awt.Color(153, 153, 153));
    Rcarnumber1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    Rcarnumber1.setText("  ");
    Rcarnumber1.setBorder(null);
    jPanel8.add(Rcarnumber1);
    Rcarnumber1.setBounds(170, 160, 225, 30);

    jLabel73.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
    jLabel73.setForeground(new java.awt.Color(255, 255, 255));
    jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel73.setText("Car Number  :");
    jPanel8.add(jLabel73);
    jLabel73.setBounds(50, 159, 110, 30);

    jLabel74.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
    jLabel74.setForeground(new java.awt.Color(255, 255, 255));
    jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel74.setText("Car ID :");
    jPanel8.add(jLabel74);
    jLabel74.setBounds(100, 100, 70, 30);

    jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/speed-meter.png"))); // NOI18N
    jPanel8.add(jLabel76);
    jLabel76.setBounds(50, 40, 360, 50);

    jLabel85.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
    jLabel85.setForeground(new java.awt.Color(255, 255, 255));
    jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel85.setText("Time :");
    jPanel8.add(jLabel85);
    jLabel85.setBounds(107, 218, 50, 24);

    Rtime1.setEditable(false);
    Rtime1.setBackground(new java.awt.Color(19, 19, 19));
    Rtime1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    Rtime1.setForeground(new java.awt.Color(153, 153, 153));
    Rtime1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    Rtime1.setText("  ");
    Rtime1.setBorder(null);
    jPanel8.add(Rtime1);
    Rtime1.setBounds(170, 216, 225, 30);

    jLabel86.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
    jLabel86.setForeground(new java.awt.Color(255, 255, 255));
    jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel86.setText("Date  :");
    jPanel8.add(jLabel86);
    jLabel86.setBounds(103, 270, 60, 24);

    Rdate1.setEditable(false);
    Rdate1.setBackground(new java.awt.Color(19, 19, 19));
    Rdate1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    Rdate1.setForeground(new java.awt.Color(153, 153, 153));
    Rdate1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    Rdate1.setText("  ");
    Rdate1.setBorder(null);
    jPanel8.add(Rdate1);
    Rdate1.setBounds(170, 270, 225, 30);

    Return.add(jPanel8);
    jPanel8.setBounds(13, 45, 420, 390);

    jPanel9.setBackground(new java.awt.Color(23, 23, 25));
    jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "-", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
    jPanel9.setLayout(null);

    Rclientid1.setEditable(false);
    Rclientid1.setBackground(new java.awt.Color(19, 19, 19));
    Rclientid1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    Rclientid1.setForeground(new java.awt.Color(153, 153, 153));
    Rclientid1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    Rclientid1.setBorder(null);
    jPanel9.add(Rclientid1);
    Rclientid1.setBounds(170, 100, 225, 30);

    Rclientnumber1.setEditable(false);
    Rclientnumber1.setBackground(new java.awt.Color(19, 19, 19));
    Rclientnumber1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    Rclientnumber1.setForeground(new java.awt.Color(153, 153, 153));
    Rclientnumber1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    Rclientnumber1.setText("  ");
    Rclientnumber1.setBorder(null);
    jPanel9.add(Rclientnumber1);
    Rclientnumber1.setBounds(170, 215, 225, 30);

    jLabel77.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
    jLabel77.setForeground(new java.awt.Color(255, 255, 255));
    jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel77.setText("Client License  :");
    jPanel9.add(jLabel77);
    jLabel77.setBounds(37, 270, 120, 24);

    jLabel78.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
    jLabel78.setForeground(new java.awt.Color(255, 255, 255));
    jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel78.setText("Client Number  :");
    jPanel9.add(jLabel78);
    jLabel78.setBounds(33, 212, 130, 30);

    Rclientname1.setEditable(false);
    Rclientname1.setBackground(new java.awt.Color(19, 19, 19));
    Rclientname1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    Rclientname1.setForeground(new java.awt.Color(153, 153, 153));
    Rclientname1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    Rclientname1.setText("  ");
    Rclientname1.setBorder(null);
    jPanel9.add(Rclientname1);
    Rclientname1.setBounds(170, 158, 225, 30);

    jLabel79.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
    jLabel79.setForeground(new java.awt.Color(255, 255, 255));
    jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel79.setText("Client Advance  :");
    jPanel9.add(jLabel79);
    jLabel79.setBounds(30, 330, 130, 24);

    Rclientadvance1.setEditable(false);
    Rclientadvance1.setBackground(new java.awt.Color(19, 19, 19));
    Rclientadvance1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    Rclientadvance1.setForeground(new java.awt.Color(153, 153, 153));
    Rclientadvance1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    Rclientadvance1.setText("  ");
    Rclientadvance1.setBorder(null);
    jPanel9.add(Rclientadvance1);
    Rclientadvance1.setBounds(170, 327, 225, 30);

    Rclientlicense1.setEditable(false);
    Rclientlicense1.setBackground(new java.awt.Color(19, 19, 19));
    Rclientlicense1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    Rclientlicense1.setForeground(new java.awt.Color(153, 153, 153));
    Rclientlicense1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    Rclientlicense1.setText("  ");
    Rclientlicense1.setBorder(null);
    jPanel9.add(Rclientlicense1);
    Rclientlicense1.setBounds(170, 270, 225, 30);

    jLabel80.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
    jLabel80.setForeground(new java.awt.Color(255, 255, 255));
    jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel80.setText("Client ID :");
    jPanel9.add(jLabel80);
    jLabel80.setBounds(80, 100, 90, 30);

    jLabel81.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
    jLabel81.setForeground(new java.awt.Color(255, 255, 255));
    jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel81.setText("Client Name  :");
    jPanel9.add(jLabel81);
    jLabel81.setBounds(50, 160, 110, 30);

    Rnid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jPanel9.add(Rnid);
    Rnid.setBounds(240, 50, 60, 20);

    Return.add(jPanel9);
    jPanel9.setBounds(440, 45, 420, 390);

    jButton10.setText("Submit");
    jButton10.setBackground(new java.awt.Color(252, 102, 0));
    jButton10.setBorder(null);
    jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jButton10.setFocusable(false);
    jButton10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
    jButton10.setForeground(new java.awt.Color(255, 255, 255));
    jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jButton10MouseReleased(evt);
        }
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton10MouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButton10MouseEntered(evt);
        }
    });
    Return.add(jButton10);
    jButton10.setBounds(680, 454, 130, 35);

    Rdatepicker1.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
        new datechooser.view.appearance.ViewAppearance("custom",
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                new java.awt.Color(187, 187, 187),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                new java.awt.Color(187, 187, 187),
                new java.awt.Color(0, 0, 255),
                true,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                new java.awt.Color(0, 0, 255),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                new java.awt.Color(128, 128, 128),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                new java.awt.Color(187, 187, 187),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                new java.awt.Color(187, 187, 187),
                new java.awt.Color(255, 0, 0),
                false,
                false,
                new datechooser.view.appearance.swing.ButtonPainter()),
            (datechooser.view.BackRenderer)null,
            false,
            true)));
Rdatepicker1.setCalendarBackground(new java.awt.Color(0, 0, 0));
Return.add(Rdatepicker1);
Rdatepicker1.setBounds(520, 460, 130, 25);

Rtimepicker1.setBackground(new java.awt.Color(0, 0, 0));
Return.add(Rtimepicker1);
Rtimepicker1.setBounds(270, 460, 105, 25);

jLabel83.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
jLabel83.setForeground(new java.awt.Color(255, 255, 255));
jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
jLabel83.setText("Time :");
Return.add(jLabel83);
jLabel83.setBounds(190, 452, 80, 40);

jLabel84.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
jLabel84.setForeground(new java.awt.Color(255, 255, 255));
jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
jLabel84.setText("Return Date :");
Return.add(jLabel84);
jLabel84.setBounds(400, 453, 120, 40);

jLabel63.setForeground(new java.awt.Color(255, 255, 255));
jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/justin/car/Resources/dot-arrow.png"))); // NOI18N
jLabel63.setText("Back");
jLabel63.setAlignmentX(33.0F);
jLabel63.setAlignmentY(50.0F);
jLabel63.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel63MouseClicked(evt);
    }
    });
    Return.add(jLabel63);
    jLabel63.setBounds(20, 440, 70, 60);

    jLayeredPane2.add(Return, "card2");

    home.add(jLayeredPane2);
    jLayeredPane2.setBounds(5, 32, 875, 480);

    jLayeredPane1.add(home, "card3");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
            .addGap(0, 0, 0)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    setSize(new java.awt.Dimension(884, 560));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        screenXmouse = evt.getX();
        screenYmouse = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        screenX = evt.getXOnScreen();
        screenY = evt.getYOnScreen();
        this.setLocation(screenX - screenXmouse, screenY - screenYmouse);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        switchpanels(Login);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void RtcarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RtcarBtnMouseClicked
        switchmainpanels(RentedCars);
        rentData();
        RtcarBtn.setBackground(new java.awt.Color(252, 102, 0));
        RcarBtn.setBackground(new java.awt.Color(0, 0, 0));
        ClBtn.setBackground(new java.awt.Color(0, 0, 0));
        CrBtn.setBackground(new java.awt.Color(0, 0, 0));
        NcBtn.setBackground(new java.awt.Color(0, 0, 0));
        NctBtn.setBackground(new java.awt.Color(0, 0, 0));
        HomeBtn.setBackground(new java.awt.Color(0, 0, 0));

    }//GEN-LAST:event_RtcarBtnMouseClicked

    private void RcarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RcarBtnMouseClicked
       switchmainpanels(ReturnCars);
       returnData();
       RcarBtn.setBackground(new java.awt.Color(252, 102, 0));
       RtcarBtn.setBackground(new java.awt.Color(0, 0, 0));
       ClBtn.setBackground(new java.awt.Color(0, 0, 0));
       CrBtn.setBackground(new java.awt.Color(0, 0, 0));
       NcBtn.setBackground(new java.awt.Color(0, 0, 0));
       NctBtn.setBackground(new java.awt.Color(0, 0, 0));
        HomeBtn.setBackground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_RcarBtnMouseClicked

    private void ClBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClBtnMouseClicked
        switchmainpanels(Clients);
        clientData();
       ClBtn.setBackground(new java.awt.Color(252, 102, 0));
       RtcarBtn.setBackground(new java.awt.Color(0, 0, 0));
       RcarBtn.setBackground(new java.awt.Color(0, 0, 0));
       CrBtn.setBackground(new java.awt.Color(0, 0, 0));
       NcBtn.setBackground(new java.awt.Color(0, 0, 0));
       NctBtn.setBackground(new java.awt.Color(0, 0, 0));
        HomeBtn.setBackground(new java.awt.Color(0, 0, 0));
        
    }//GEN-LAST:event_ClBtnMouseClicked

    private void CrBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrBtnMouseClicked
       switchmainpanels(Cars);
       carData();
       CrBtn.setBackground(new java.awt.Color(252, 102, 0));
       RtcarBtn.setBackground(new java.awt.Color(0, 0, 0));
       ClBtn.setBackground(new java.awt.Color(0, 0, 0));
       RcarBtn.setBackground(new java.awt.Color(0, 0, 0));
       NcBtn.setBackground(new java.awt.Color(0, 0, 0));
       NctBtn.setBackground(new java.awt.Color(0, 0, 0));
        HomeBtn.setBackground(new java.awt.Color(0, 0, 0));
        
    }//GEN-LAST:event_CrBtnMouseClicked

    private void NcBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NcBtnMouseClicked
        switchmainpanels(Newcars);
       NcBtn.setBackground(new java.awt.Color(252, 102, 0));
       RtcarBtn.setBackground(new java.awt.Color(0, 0, 0));
       ClBtn.setBackground(new java.awt.Color(0, 0, 0));
       CrBtn.setBackground(new java.awt.Color(0, 0, 0));
       RcarBtn.setBackground(new java.awt.Color(0, 0, 0));
       NctBtn.setBackground(new java.awt.Color(0, 0, 0));
        HomeBtn.setBackground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_NcBtnMouseClicked

    private void NctBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NctBtnMouseClicked
        switchmainpanels(Newclients);
       NctBtn.setBackground(new java.awt.Color(252, 102, 0));
       RtcarBtn.setBackground(new java.awt.Color(0, 0, 0));
       ClBtn.setBackground(new java.awt.Color(0, 0, 0));
       CrBtn.setBackground(new java.awt.Color(0, 0, 0));
       NcBtn.setBackground(new java.awt.Color(0, 0, 0));
       RcarBtn.setBackground(new java.awt.Color(0, 0, 0));
       HomeBtn.setBackground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_NctBtnMouseClicked

    private void HomeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBtnMouseClicked
       switchmainpanels(Hidepan);
       HomeBtn.setBackground(new java.awt.Color(252, 102, 0));
       RtcarBtn.setBackground(new java.awt.Color(0, 0, 0));
       ClBtn.setBackground(new java.awt.Color(0, 0, 0));
       CrBtn.setBackground(new java.awt.Color(0, 0, 0));
       NcBtn.setBackground(new java.awt.Color(0, 0, 0));
       RcarBtn.setBackground(new java.awt.Color(0, 0, 0));
       NctBtn.setBackground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_HomeBtnMouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
       String sql = "Select * from user where username=? and passwd=?";
       
        try{
            
           
        pstatement = conn.prepareStatement(sql);
        pstatement.setString(1, username.getText());
        pstatement.setString(2, password.getText());
        result = pstatement.executeQuery();
            
        if(result.next()){
           result.close();
           pstatement.close();
           rentData();
           switchpanels(home);
        
        }
        else if(username.getText().equals("")){
        
         JOptionPane.showMessageDialog(null,  "Please Add Your Username..!");
        
        }  
        
        else if(password.getText().equals("")){
        
         JOptionPane.showMessageDialog(null,  "Please Add Your Password..!");
        
        }
          else{
                 JOptionPane.showMessageDialog(null,  "Incorrect Data...!");
         }
        
        
        }catch(HeadlessException | SQLException e){      
        JOptionPane.showMessageDialog(null, e);
        }  
        
        finally{
        
            try{
            result.close();
            pstatement.close();
            }catch(SQLException e){}
        
        }
       
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered

    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
       
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String fuel = "Diesel";
        String sql="Insert into cars(ID,Rent,Name,Number,Fuel) values(?,?,?,?,?)";
        if(jRadioButton2.isSelected()){
                fuel = "Petrol";       
            }
        try{
            pstatement = conn.prepareStatement(sql);
            pstatement.setString(1,carid.getText());
            pstatement.setString(2,carrent.getText());
            pstatement.setString(3,carname.getText());
            pstatement.setString(4,carnumber.getText());
            pstatement.setString(5, fuel);
            pstatement.execute();
            JOptionPane.showMessageDialog(null, "Car Added..!");
            carid.setText(" ");
            carrent.setText(" ");
            carname.setText(" ");
            carnumber.setText(" ");
            NumId();
            pstatement.close();
            
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked

    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked

    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        String sql="Insert into client(ID,Name,Number,License,Advance) values(?,?,?,?,?)";
        
        try{
        
        pstatement =conn.prepareStatement(sql);
        pstatement.setString(1, clientid.getText());
        pstatement.setString(2, clientname.getText());
        pstatement.setString(3, clientnumber.getText());
        pstatement.setString(4, licensenumber.getText());
        pstatement.setString(5, advance.getText());
        pstatement.execute();
        JOptionPane.showMessageDialog(null, "Client Added..!");
        clientid.setText(" ");
        clientname.setText(" ");
        clientnumber.setText(" ");
        licensenumber.setText(" ");
        advance.setText(" ");
        NumId();
        pstatement.close();
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void clientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientTableMouseClicked
       switchmainpanels(clientedit);
        int index = clientTable.getSelectedRow();
       TableModel model = clientTable.getModel();
       eclientid.setText(model.getValueAt(index, 0).toString());
       eclientname.setText(model.getValueAt(index, 1).toString());
       enumber.setText(model.getValueAt(index, 2).toString());
       elicense.setText(model.getValueAt(index, 3).toString());
       eadvance.setText(model.getValueAt(index, 4).toString());
        
       
    }//GEN-LAST:event_clientTableMouseClicked

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseReleased

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
       String sql="update client set Name=? , Number=?, License=?, Advance=?  where ID=?";
        
        try{
        
        pstatement =conn.prepareStatement(sql);
        pstatement.setString(5, eclientid.getText());
        pstatement.setString(1, eclientname.getText());
        pstatement.setString(2, enumber.getText());
        pstatement.setString(3, elicense.getText());
        pstatement.setString(4, eadvance.getText());
        pstatement.execute();
        clientData();
        JOptionPane.showMessageDialog(null, "Data Edited..!");
        pstatement.close();
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseEntered

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
       switchmainpanels(Clients);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        
        String sql="update cars set Rent=?, Name=? , Number=?, Fuel=?  where ID=?";
        String fuel = "Diesel";
        if(jRadioButton4.isSelected()){
                fuel = "Petrol";       
            }
        try{
        
        pstatement =conn.prepareStatement(sql);
        pstatement.setString(5, ecarid.getText());
        pstatement.setString(1, ecarrent.getText());
        pstatement.setString(2, ecarname.getText());
        pstatement.setString(3, ecarnumber.getText());
        pstatement.setString(4, fuel);
        pstatement.execute();
        carData();
        JOptionPane.showMessageDialog(null, "Data Edited..!");
        pstatement.close();
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
           
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseEntered

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jRadioButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4MouseClicked

    private void RtcarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RtcarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RtcarBtnActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
       switchmainpanels(Cars);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void carTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carTableMouseClicked
       switchmainpanels(caredit);
       int index = carTable.getSelectedRow();
       TableModel model = carTable.getModel();
       ecarid.setText(model.getValueAt(index, 0).toString());
       ecarrent.setText(model.getValueAt(index, 1).toString());
       ecarname.setText(model.getValueAt(index, 2).toString());
       ecarnumber.setText(model.getValueAt(index, 3).toString());
       
    }//GEN-LAST:event_carTableMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        
        String sql="delete from client where ID=?";
        try{
        
        pstatement =conn.prepareStatement(sql);
        pstatement.setString(1, eclientid.getText());
        int Del = JOptionPane.showConfirmDialog(null, "Delete This Data...?");
        if(Del==0){
        pstatement.execute();
        clientData();
        JOptionPane.showMessageDialog(null, "Data Deleted");
        pstatement.close();
        switchmainpanels(Clients);
        }else{clientData();}
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
        String sql="delete from cars where ID=?";
        try{
        
        pstatement =conn.prepareStatement(sql);
        pstatement.setString(1, ecarid.getText());
        int Del = JOptionPane.showConfirmDialog(null, "Delete This Data...?");
        if(Del==0){
        pstatement.execute();
        carData();
        JOptionPane.showMessageDialog(null, "Data Deleted");
        pstatement.close();
        switchmainpanels(Cars);
        }else{carData();}
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jLabel54MouseClicked

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
         String sql="Select * from cars where ID=?";
        try{
        
        pstatement =conn.prepareStatement(sql);
        pstatement.setString(1, Rcarid.getText());
        result= pstatement.executeQuery();
        
        if(result.next()){
        String carnamer = result.getString("Name");
        Rcarname.setText(carnamer);
        String carnumberr = result.getString("Number");
        Rcarnumber.setText(carnumberr);
        String carrentr = result.getString("Rent");
        Rcarrent.setText(carrentr);
        String carfuel = result.getString("Fuel");
        Rfuel.setText(carfuel);
        
        result.close();
        pstatement.close();
        }else{
        
            JOptionPane.showMessageDialog(null, "Data Not Found...!");
        }
        
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
        finally{
        
            try{
            result.close();
            pstatement.close();
            }catch(SQLException e){}
        
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseReleased

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        
        
         String sql="Select * from client where ID=?";
        try{
        
        pstatement =conn.prepareStatement(sql);
        pstatement.setString(1, Rclientid.getText());
        result= pstatement.executeQuery();
        
        if(result.next()){
        String clientnamer = result.getString("Name");
        Rclientname.setText(clientnamer);
        String clientnumberr = result.getString("Number");
        Rclientnumber.setText(clientnumberr);
        String clientlicenser = result.getString("License");
        Rclientlicense.setText(clientlicenser);
        String clientadvance = result.getString("Advance");
        Rclientadvance.setText(clientadvance);
        
        result.close();
        pstatement.close();
        }else{
        
            JOptionPane.showMessageDialog(null, "Data Not Found...!");
        }
        
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
        finally{
        
            try{
            result.close();
            pstatement.close();
            }catch(SQLException e){}
        
        }
        
        
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseReleased

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        
        String sql="Insert into rented(Car_ID,carname,Car_Number,carrent,carfuel,Client_ID,Name,Number,License,Advance,Time,Date) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
        
        pstatement =conn.prepareStatement(sql);
        pstatement.setString(1, Rcarid.getText());
        pstatement.setString(2, Rcarname.getText());
        pstatement.setString(3, Rcarnumber.getText());
        pstatement.setString(4, Rcarrent.getText());
        pstatement.setString(5, Rfuel.getText());
        pstatement.setString(6, Rclientid.getText());
        pstatement.setString(7, Rclientname.getText());
        pstatement.setString(8, Rclientnumber.getText());
        pstatement.setString(9, Rclientlicense.getText());
        pstatement.setString(10, Rclientadvance.getText());
        pstatement.setString(11, Rtimepicker.getText());
        pstatement.setString(12, Rdatepicker.getText());
        pstatement.execute();
        JOptionPane.showMessageDialog(null, "Data Added..!");
        rentData();
        pstatement.close();
        Rcarid.setText("");
        Rcarname.setText("");
        Rcarnumber.setText("");
        Rcarrent.setText("");
        Rfuel.setText("");
        Rclientid.setText("");
        Rclientname.setText("");
        Rclientnumber.setText("");
        Rclientlicense.setText("");
        Rclientadvance.setText("");
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        } 
        
        
        
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseReleased

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
       
         String sql="Insert into return(Car_ID,Car_Number,Client_ID,Name,Number,License,Advance,Time,Date,Return_Time,Return_Date) values(?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
        
        pstatement =conn.prepareStatement(sql);
        pstatement.setString(1, Rcarid1.getText());
        pstatement.setString(2, Rcarnumber1.getText());
        pstatement.setString(3, Rclientid1.getText());
        pstatement.setString(4, Rclientname1.getText());
        pstatement.setString(5, Rclientnumber1.getText());
        pstatement.setString(6, Rclientlicense1.getText());
        pstatement.setString(7, Rclientadvance1.getText());
        pstatement.setString(8, Rtime1.getText());
        pstatement.setString(9, Rdate1.getText());
        pstatement.setString(10, Rtimepicker1.getText());
        pstatement.setString(11, Rdatepicker1.getText());
        pstatement.execute();
        JOptionPane.showMessageDialog(null, "Data Added..!");
        
        String rsql="delete from rented where ID=?";
        try{
        
        pstatement =conn.prepareStatement(rsql);
        pstatement.setString(1, Rnid.getText());
        pstatement.execute();
        rentData();
        pstatement.close();
        switchpanels(home);
                                 }catch(SQLException e){
                                        JOptionPane.showMessageDialog(null, e);
                                    }
        
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        } 
        
        
        
        
        
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseEntered

    private void rentedTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rentedTableMouseClicked
        switchpanels(Return);
        int index = rentedTable.getSelectedRow();
       TableModel model = rentedTable.getModel();
       Rnid.setText(model.getValueAt(index, 0).toString());
       Rcarid1.setText(model.getValueAt(index, 1).toString());
       Rcarnumber1.setText(model.getValueAt(index, 2).toString());
       Rclientid1.setText(model.getValueAt(index, 3).toString());
       Rclientname1.setText(model.getValueAt(index, 4).toString());
       Rclientnumber1.setText(model.getValueAt(index, 5).toString());
       Rclientlicense1.setText(model.getValueAt(index, 6).toString());
       Rclientadvance1.setText(model.getValueAt(index, 7).toString());
       Rtime1.setText(model.getValueAt(index, 8).toString());
       Rdate1.setText(model.getValueAt(index, 9).toString());
       Rnid.setVisible(false);
    }//GEN-LAST:event_rentedTableMouseClicked

    private void CarRetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarRetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CarRetActionPerformed

    private void CarRetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarRetMouseClicked
        switchcarpanels(CarReturn);
        CarRet.setBackground(new java.awt.Color(252, 102, 0));
        CarRen.setBackground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_CarRetMouseClicked

    private void CarRenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarRenMouseClicked
        switchcarpanels(CarRented);
        CarRen.setBackground(new java.awt.Color(252, 102, 0));
        CarRet.setBackground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_CarRenMouseClicked

    private void CarRenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarRenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CarRenActionPerformed

    private void returnTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnTableMouseClicked
        String sql="delete from return where ID=?";
        try{
        int index = returnTable.getSelectedRow();
        TableModel model = returnTable.getModel();
        pstatement =conn.prepareStatement(sql);
        pstatement.setString(1, model.getValueAt(index, 0).toString());
        int Del = JOptionPane.showConfirmDialog(null, "Delete This Data...?");
        if(Del == 0){
        pstatement.execute();
        returnData();
        pstatement.close();
        switchmainpanels(ReturnCars);
        
        }else{returnData();}
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null, e);
                               }
        
        
        
        
        
    }//GEN-LAST:event_returnTableMouseClicked

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
        switchpanels(home);
    }//GEN-LAST:event_jLabel63MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CarRen;
    private keeptoo.KGradientPanel CarRented;
    private javax.swing.JButton CarRet;
    private keeptoo.KGradientPanel CarReturn;
    private keeptoo.KGradientPanel Cars;
    private javax.swing.JButton ClBtn;
    private keeptoo.KGradientPanel Clients;
    private javax.swing.JButton CrBtn;
    private keeptoo.KGradientPanel Hidepan;
    private javax.swing.JButton HomeBtn;
    private keeptoo.KGradientPanel Login;
    private javax.swing.JButton NcBtn;
    private javax.swing.JButton NctBtn;
    private keeptoo.KGradientPanel Newcars;
    private keeptoo.KGradientPanel Newclients;
    private javax.swing.JScrollPane Pane1;
    private javax.swing.JScrollPane Pane2;
    private javax.swing.JScrollPane Pane3;
    private javax.swing.JScrollPane Pane4;
    private javax.swing.JButton RcarBtn;
    private javax.swing.JTextField Rcarid;
    private javax.swing.JTextField Rcarid1;
    private javax.swing.JTextField Rcarname;
    private javax.swing.JTextField Rcarnumber;
    private javax.swing.JTextField Rcarnumber1;
    private javax.swing.JTextField Rcarrent;
    private javax.swing.JTextField Rclientadvance;
    private javax.swing.JTextField Rclientadvance1;
    private javax.swing.JTextField Rclientid;
    private javax.swing.JTextField Rclientid1;
    private javax.swing.JTextField Rclientlicense;
    private javax.swing.JTextField Rclientlicense1;
    private javax.swing.JTextField Rclientname;
    private javax.swing.JTextField Rclientname1;
    private javax.swing.JTextField Rclientnumber;
    private javax.swing.JTextField Rclientnumber1;
    private javax.swing.JTextField Rdate1;
    private datechooser.beans.DateChooserCombo Rdatepicker;
    private datechooser.beans.DateChooserCombo Rdatepicker1;
    private keeptoo.KGradientPanel RentedCars;
    private keeptoo.KGradientPanel Return;
    private keeptoo.KGradientPanel ReturnCars;
    private javax.swing.JTextField Rfuel;
    private javax.swing.JLabel Rnid;
    private javax.swing.JButton RtcarBtn;
    private javax.swing.JTextField Rtime1;
    private com.github.lgooddatepicker.components.TimePicker Rtimepicker;
    private com.github.lgooddatepicker.components.TimePicker Rtimepicker1;
    private javax.swing.JTextField advance;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable carTable;
    private keeptoo.KGradientPanel caredit;
    private javax.swing.JTextField carid;
    private javax.swing.JTextField carname;
    private javax.swing.JTextField carnumber;
    private javax.swing.JTextField carrent;
    private javax.swing.JTable clientTable;
    private keeptoo.KGradientPanel clientedit;
    private javax.swing.JTextField clientid;
    private javax.swing.JTextField clientname;
    private javax.swing.JTextField clientnumber;
    private javax.swing.JTextField eadvance;
    private javax.swing.JTextField ecarid;
    private javax.swing.JTextField ecarname;
    private javax.swing.JTextField ecarnumber;
    private javax.swing.JTextField ecarrent;
    private javax.swing.JTextField eclientid;
    private javax.swing.JTextField eclientname;
    private javax.swing.JTextField elicense;
    private javax.swing.JTextField enumber;
    private keeptoo.KGradientPanel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField licensenumber;
    private javax.swing.JPasswordField password;
    private javax.swing.JTable rentedTable;
    private javax.swing.JTable returnTable;
    private javax.swing.JTextField username;
    private keeptoo.KGradientPanel welcomepanel;
    // End of variables declaration//GEN-END:variables
}
