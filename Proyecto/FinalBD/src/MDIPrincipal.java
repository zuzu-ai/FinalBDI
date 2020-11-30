/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//inserte sus comentarios aqui


import java.awt.Dimension;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author kievk
 */
public class MDIPrincipal extends javax.swing.JFrame {

    private static String c;
    private static String u;
    public static String BD = "jdbc:mysql://localhost/hotel_general";
    public static String Usuario = "root";
    public static String Contraseña = "6182";

    public void get_fecha() {
        //Obtenemos la fecha
        Calendar c1 = Calendar.getInstance();
        fecha.setCalendar(c1);
    }

    public void get_usuario() {
        try {
            Connection cn = DriverManager.getConnection(MDIPrincipal.BD, MDIPrincipal.Usuario, MDIPrincipal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from usuario_hoteleria where nombre_usuario = ?");
            pst.setString(1, labelusuario.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                lbusu.setText(rs.getString("id_usuario"));

            }
        } catch (Exception e) {

        }
    }

    public void bitacora_boton() {
        get_usuario();
        String boton = boton_press.getText();
        String descrip = "Ingresó a la seccion " + boton;
        //Desciframos la fecha
        java.util.Date fechaN = fecha.getDate();
        long fecha = fechaN.getTime();
        java.sql.Date dateN = new java.sql.Date(fecha);

        //Obtenemos la hora
        Calendar timec = Calendar.getInstance();

        int hora = timec.get(Calendar.HOUR_OF_DAY);
        int minutos = timec.get(Calendar.MINUTE);
        int segundos = timec.get(Calendar.SECOND);

        String datetime= dateN.toString()+ hora + ":" + minutos + ":" + segundos;

        try {

            Connection cn = DriverManager.getConnection(MDIPrincipal.BD, MDIPrincipal.Usuario, MDIPrincipal.Contraseña);
            //localhost es 127.0.0.1
            PreparedStatement pst = cn.prepareStatement("insert into bitacora values(?,?,?,?,?)");

            pst.setString(1, "0");
            pst.setString(2, lbusu.getText().trim());
            pst.setString(3, descrip);
            pst.setString(4, dateN.toString().trim());

            pst.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public static Connection getConeccion() {
        Connection cn = null;
        try {
            Class.forName(BD);
            cn = DriverManager.getConnection(MDIPrincipal.BD, MDIPrincipal.Usuario, MDIPrincipal.Contraseña);

        } catch (Exception e) {
            System.out.println(String.valueOf(e));
        }
        return cn;

    }

    public MDIPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(MDIPrincipal.MAXIMIZED_BOTH);
        this.setTitle("Hotel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        labelusuario.setBounds(10, 10, 160, 51);
        c = labelc.getText().trim();
        u = labelusuario.getText().trim();
        get_usuario();
        get_fecha();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelc = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        boton_press = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        desktopPane = new javax.swing.JDesktopPane();
        labelusuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        MenuSucursal = new javax.swing.JMenuItem();
        MenuBodega = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();

        labelc.setText("jLabel1");

        boton_press.setText("nombre_boton");

        lbusu.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(0, 0, 0));

        labelusuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelusuario.setText("zuzu");
        desktopPane.add(labelusuario);
        labelusuario.setBounds(900, 10, 80, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("HEYDI QUEME        9959-18-5335");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(20, 400, 420, 50);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Mantenimientos");

        MenuSucursal.setText("Mantenimiento Sucursal");
        MenuSucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuSucursalMousePressed(evt);
            }
        });
        MenuSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSucursalActionPerformed(evt);
            }
        });
        fileMenu.add(MenuSucursal);

        MenuBodega.setText("Mantenimiento Bodega");
        MenuBodega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuBodegaMousePressed(evt);
            }
        });
        MenuBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBodegaActionPerformed(evt);
            }
        });
        fileMenu.add(MenuBodega);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Exit");
        helpMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpMenuMouseClicked(evt);
            }
        });
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void helpMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMenuMouseClicked
        System.exit(0);
// TODO add your handling code here:
    }//GEN-LAST:event_helpMenuMouseClicked

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jMenuCotEncClientesActionPerformed(java.awt.event.ActionEvent evt) {
     

    }

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void jMenuCotDetClientesActionPerformed(java.awt.event.ActionEvent evt) {
      

        // TODO add your handling code here:
    }

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void jMenuCotEncProveedoresActionPerformed(java.awt.event.ActionEvent evt) {
      
        // TODO add your handling code here:
    }


    private void MenuBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBodegaActionPerformed
        inf_Mantenimiento_Bodega ventana1 = new inf_Mantenimiento_Bodega();
        desktopPane.add(ventana1);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = ventana1.getSize();
        ventana1.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        bitacora_boton();
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuBodegaActionPerformed

    private void MenuBodegaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBodegaMousePressed
        // TODO add your handling code here:
        String nombre = MenuBodega.getText();
        boton_press.setText(nombre);
    }//GEN-LAST:event_MenuBodegaMousePressed

    private void MenuSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSucursalActionPerformed
        // TODO add your handling code here:
        inf_Mantenimiento_Sucursal ventana1 = new inf_Mantenimiento_Sucursal();
        desktopPane.add(ventana1);
        Dimension desktopSize = desktopPane.getSize();
        Dimension FrameSize = ventana1.getSize();
        ventana1.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        bitacora_boton();
    }//GEN-LAST:event_MenuSucursalActionPerformed

    private void MenuSucursalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSucursalMousePressed
        // TODO add your handling code here:
        String nombre = MenuSucursal.getText();
        boton_press.setText(nombre);
    }//GEN-LAST:event_MenuSucursalMousePressed

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
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuBodega;
    private javax.swing.JMenuItem MenuSucursal;
    private javax.swing.JLabel boton_press;
    private javax.swing.JDesktopPane desktopPane;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel labelc;
    public static javax.swing.JLabel labelusuario;
    public static javax.swing.JLabel lbusu;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
