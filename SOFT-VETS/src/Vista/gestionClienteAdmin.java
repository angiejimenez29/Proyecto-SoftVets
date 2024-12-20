package Vista;

import com.formdev.flatlaf.FlatClientProperties;
import Controlador.ControladorCliente;
import Modelo.Administrador;
import Modelo.Cliente;
import Vista.administrarCliente;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class gestionClienteAdmin extends javax.swing.JPanel {
    private ControladorCliente controlador;
    private administrarCliente adminCliente;
    private Cliente cliente;
    private Integer idUsuarioSeleccionado;
    private String nombreOriginal, apellidoOriginal, telefonoOriginal, emailOriginal;
    private Integer idUsuario;
    private String nombreSeleccionado;
    private String apellidoSeleccionado;
    private String telefonoSeleccionado;
    private String emailSeleccionado;
    
    public gestionClienteAdmin() {
        initComponents();
        init();
        controlador = new ControladorCliente(new Cliente());
        controlador.mostrarClientes(tablaClientes);   
        adminCliente = new administrarCliente(idUsuario);
                
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
        txtBuscarCliente.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar...");
        txtBuscarCliente.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "background:$Panel.background");
        txtBuscarCliente.setFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 14));
        
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
        txtBuscarCliente = new javax.swing.JTextField();
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
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        scroll.setViewportView(tablaClientes);

        clienteTabla.add(scroll);
        scroll.setBounds(0, 130, 780, 520);
        clienteTabla.add(jSeparator1);
        jSeparator1.setBounds(0, 120, 780, 30);

        txtBuscarCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarClienteActionPerformed(evt);
            }
        });
        txtBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarClienteKeyReleased(evt);
            }
        });
        clienteTabla.add(txtBuscarCliente);
        txtBuscarCliente.setBounds(60, 80, 220, 30);

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
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
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
        adminCliente.mostrarPanel("registrarCliente");
        adminCliente.setVisible(true);
            adminCliente.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    controlador.mostrarClientes(tablaClientes);
                }
            });
    }//GEN-LAST:event_NuevoActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int confirmation = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este administrador?", 
                                                 "Confirmación de eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            controlador.eliminarCliente(idUsuarioSeleccionado);

            System.out.print("usuario" + idUsuarioSeleccionado);
            controlador.mostrarClientes(tablaClientes);
        }  
    }//GEN-LAST:event_EliminarActionPerformed

    private void txtBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarClienteActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
    if (idUsuario != null) {
        abrirVentanaAdministrarCliente(
            idUsuario,
            nombreSeleccionado,
            apellidoSeleccionado,
            telefonoSeleccionado,
            emailSeleccionado
        );
    } else {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente de la tabla para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_EditarActionPerformed

    
    private void abrirVentanaAdministrarCliente(Integer idCliente, String nombre, String apellido, String telefono, String email) {
        administrarCliente adminCliente = new administrarCliente(idCliente);
        adminCliente.setControlador(this.controlador);
        adminCliente.mostrarPanel("editarCliente");
        adminCliente.recibirDatos(idCliente, nombre, apellido, telefono, email);
        adminCliente.setVisible(true);
        adminCliente.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                controlador.mostrarClientes(tablaClientes);
            }
        });
    }
    
    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        int row = tablaClientes.getSelectedRow();
        if (row >= 0) {

            Integer idCliente = (Integer) tablaClientes.getValueAt(row, 0);  
            System.out.println("ID Cliente: " + idCliente);
            
            idUsuario = (Integer) tablaClientes.getValueAt(row, 1); 
            System.out.println("ID Usuario: " + idUsuario);
            String nombreCompleto = (String) tablaClientes.getValueAt(row, 2);
            String[] partesNombre = nombreCompleto.split(" ");
            nombreSeleccionado = partesNombre[0];
            apellidoSeleccionado = partesNombre.length > 1 ? partesNombre[1] : "";
            telefonoSeleccionado = (String) tablaClientes.getValueAt(row, 3);
            emailSeleccionado = (String) tablaClientes.getValueAt(row, 4);
            
            this.idUsuarioSeleccionado = idUsuario;
        }
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void txtBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteKeyReleased
        String nombreApellidoBuscar = txtBuscarCliente.getText().trim();      
        controlador.buscarCliente(nombreApellidoBuscar, tablaClientes);
    }//GEN-LAST:event_txtBuscarClienteKeyReleased


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
    private javax.swing.JTextField txtBuscarCliente;
    // End of variables declaration//GEN-END:variables
}
