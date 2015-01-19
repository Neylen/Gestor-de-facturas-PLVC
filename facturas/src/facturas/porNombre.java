/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class porNombre extends javax.swing.JInternalFrame {
DefaultTableModel modelo;
    /**
     * Creates new form porNombre
     */
    public porNombre() {
        initComponents();
        String cabecera[]={"# Factura","Fecha","SubTotal","Descuento","IVA","Total","Responsable","tipo","ice","propietario","Emisor"};
        String datos[][]={};
        modelo=new DefaultTableModel(datos,cabecera);
        jTable1.setModel(modelo);
        combo();
    }
    private void combo(){
conectar con=new  conectar();
Connection reg=con.conexion();
        try {
            Statement st=reg.createStatement();
            ResultSet rs=st.executeQuery("select nomComProveedor from proveedor ");
        while(rs.next()){
                
            String f=rs.getString("nomComProveedor");        
            //Object datos[]={d,f,a,b,c,e};
           jComboBox1.addItem(f);
           
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(aFactura.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    private void mostrar(){
     String nom=(String) jComboBox1.getSelectedItem();
for (int i = 0; i < modelo.getRowCount(); i++) {
           modelo.removeRow(i);
           i-=1;
       }
conectar con=new  conectar();
Connection reg=con.conexion();


        Statement st;
    try {
        st = reg.createStatement();
         ResultSet rs=st.executeQuery("select DISTINCT idFactura,fecFactura,subtFactura,descFactura,ivaFactura,"
                 + "totFactura,respFactura,tipFactura,iceFactura,Usuario_cedUsuario,Proveedor_rucProveedor "
                 + "from factura F INNER JOIN Proveedor P on F.Proveedor_rucProveedor=P.rucProveedor where nomComProveedor='"+nom+"'");
        while(rs.next()){
/*,,,,,,,,,*/  
            String num=rs.getString("idFactura");
            String a=rs.getString("fecFactura");
            String b=rs.getString("subtFactura");
            String c=rs.getString("descFactura");
            String d=rs.getString("ivaFactura");
            String e=rs.getString("totFactura");
            String f=rs.getString("respFactura");
            String g=rs.getString("tipFactura");  
            String h=rs.getString("iceFactura"); 
            String i=rs.getString("Usuario_cedUsuario");  
            String j=rs.getString("Proveedor_rucProveedor");  
            Object datos[]={num,a,b,c,d,e,f,g,h,i,j};
            modelo.addRow(datos);
            }
    } catch (SQLException ex) {
        Logger.getLogger(elProveedor.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Facturas Por Nombre Comercial Del Proveedor");
        setAutoscrolls(true);

        jLabel1.setText("Nombre Comercial ");

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 153, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
mostrar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
