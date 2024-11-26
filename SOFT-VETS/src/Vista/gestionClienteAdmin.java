package Vista;

import com.formdev.flatlaf.FlatClientProperties;
import Controlador.ControladorCliente;
import Modelo.Administrador;
import Modelo.Cliente;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class gestionClienteAdmin extends javax.swing.JPanel {
    private ControladorCliente controlador;
    private Cliente cliente;
    private Integer idUsuarioSeleccionado;
    private String nombreOriginal, apellidoOriginal, telefonoOriginal, emailOriginal;
    
    public gestionClienteAdmin() {
        initComponents();
        init();
        controlador = new ControladorCliente(new Cliente());
        controlador.mostrarClientes(tablaClientes);      
    }

    private void init(){
        clienteTabla.putClientProperty(FlatClientProperties.STYLE , ""
                + "arc:25;"
                + "background:$Table.background"
        );
        tablaClientes.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:35;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");
        tablaClientes.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");
        txtBuscar.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar...");
        txtBuscar.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "background:$Panel.background");
        txtBuscar.setFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 14));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        gestionPersonalAdmin = new javax.swing.JPanel();
        clienteTabla = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscar = new javax.swing.JTextField();
        Eliminar = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        editarperfil = new javax.swing.JLabel();

        jPanel1.setPreferredSize(new java.awt.Dimension(820, 720));

        gestionPersonalAdmin.setPreferredSize(new java.awt.Dimension(820, 720));

        clienteTabla.setLayout(null);

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Telefono", "Email", "Fecha Registro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tablaClientes);

        clienteTabla.add(scroll);
        scroll.setBounds(0, 130, 780, 520);
        clienteTabla.add(jSeparator1);
        jSeparator1.setBounds(0, 120, 770, 30);

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        clienteTabla.add(txtBuscar);
        txtBuscar.setBounds(60, 80, 220, 30);

        Eliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        clienteTabla.add(Eliminar);
        Eliminar.setBounds(620, 80, 110, 30);

        Nuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        clienteTabla.add(Nuevo);
        Nuevo.setBounds(360, 80, 110, 30);

        Editar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Editar.setText("Editar");
        clienteTabla.add(Editar);
        Editar.setBounds(490, 80, 110, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Google Web Search_1.png"))); // NOI18N
        clienteTabla.add(jLabel2);
        jLabel2.setBounds(20, 80, 30, 30);

        editarperfil.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        editarperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Contact Us.png"))); // NOI18N
        editarperfil.setText(" CLIENTES");
        clienteTabla.add(editarperfil);
        editarperfil.setBounds(20, 10, 179, 59);

        javax.swing.GroupLayout gestionPersonalAdminLayout = new javax.swing.GroupLayout(gestionPersonalAdmin);
        gestionPersonalAdmin.setLayout(gestionPersonalAdminLayout);
        gestionPersonalAdminLayout.setHorizontalGroup(
            gestionPersonalAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gestionPersonalAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clienteTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                .addContainerGap())
        );
        gestionPersonalAdminLayout.setVerticalGroup(
            gestionPersonalAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gestionPersonalAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clienteTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gestionPersonalAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gestionPersonalAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 821, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        administrarCliente registrarCliente = new administrarCliente();
            registrarCliente.setVisible(true);
            registrarCliente.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    controlador.mostrarClientes(tablaClientes);
                }
            });
    }//GEN-LAST:event_NuevoActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Editar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Nuevo;
    private javax.swing.JPanel clienteTabla;
    private javax.swing.JLabel editarperfil;
    private javax.swing.JPanel gestionPersonalAdmin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
