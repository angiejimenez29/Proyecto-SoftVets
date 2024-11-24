package Vista;

import Controlador.ControladorAdministrador;
import Controlador.ControladorUsuario;
import Modelo.Administrador;
import Modelo.Usuario;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JOptionPane;

public class editarPerfilAdmin extends javax.swing.JPanel {
    private ControladorUsuario usuarioControlador;
    private ControladorAdministrador administradorControlador;
    private Usuario usuarioAutenticado;


    public editarPerfilAdmin(Usuario usuario) {
        this.usuarioAutenticado = usuario;
        initComponents();

        txtNombre.putClientProperty(FlatClientProperties.STYLE, "arc:10"); 
        txtApellido.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        txtContraseña.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10;"
                + "showRevealButton:true;"
                + "showCapsLock:true;"); 
        txtEmail.putClientProperty(FlatClientProperties.STYLE, "arc:10"); 
        txtTelefono.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        panelPerfil.putClientProperty(FlatClientProperties.STYLE , ""
                + "arc:25;"
        );

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editarPerfil = new javax.swing.JPanel();
        icono = new javax.swing.JLabel();
        panelPerfil = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        icon = new javax.swing.JLabel();
        editarperfil = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(820, 720));

        editarPerfil.setLayout(null);

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/iconito.png"))); // NOI18N
        editarPerfil.add(icono);
        icono.setBounds(650, 30, 140, 140);

        panelPerfil.setBackground(new java.awt.Color(255, 255, 255));
        panelPerfil.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nombre");
        panelPerfil.add(jLabel1);
        jLabel1.setBounds(70, 40, 83, 40);

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelPerfil.add(txtNombre);
        txtNombre.setBounds(70, 90, 170, 26);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Apellido");
        panelPerfil.add(jLabel2);
        jLabel2.setBounds(280, 40, 121, 40);

        txtApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        panelPerfil.add(txtApellido);
        txtApellido.setBounds(280, 90, 170, 26);

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        panelPerfil.add(txtTelefono);
        txtTelefono.setBounds(70, 260, 380, 26);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Contraseña");
        panelPerfil.add(jLabel3);
        jLabel3.setBounds(70, 300, 104, 34);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Email");
        panelPerfil.add(jLabel4);
        jLabel4.setBounds(70, 130, 63, 34);

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelPerfil.add(txtEmail);
        txtEmail.setBounds(70, 170, 380, 26);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Telefono");
        panelPerfil.add(jLabel5);
        jLabel5.setBounds(70, 210, 105, 34);

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelPerfil.add(btnCancelar);
        btnCancelar.setBounds(70, 410, 170, 34);

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelPerfil.add(btnGuardar);
        btnGuardar.setBounds(290, 410, 160, 34);

        txtContraseña.setText("jPasswordField1");
        panelPerfil.add(txtContraseña);
        txtContraseña.setBounds(70, 350, 380, 30);

        editarPerfil.add(panelPerfil);
        panelPerfil.setBounds(140, 170, 510, 490);

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Pen Squared.png"))); // NOI18N
        editarPerfil.add(icon);
        icon.setBounds(60, 60, 50, 41);

        editarperfil.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        editarperfil.setText("Editar Perfil");
        editarPerfil.add(editarperfil);
        editarperfil.setBounds(120, 60, 148, 41);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(editarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(editarPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String contrasena = new String(txtContraseña.getPassword());
        String email = txtEmail.getText();
        
        if (usuarioAutenticado instanceof Usuario) {  
            ControladorUsuario controladorUsuario = new ControladorUsuario((Usuario) usuarioAutenticado);
            controladorUsuario.actualizarUsuario(nombre, apellido, telefono, contrasena);
        }

        if (usuarioAutenticado instanceof Administrador) {              
            ControladorAdministrador controladorAdministrador = new ControladorAdministrador((Administrador) usuarioAutenticado);
            controladorAdministrador.actualizarEmail(email);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    public void usuarioInfo(){
        if (usuarioAutenticado != null) {
            txtNombre.setText(usuarioAutenticado.getNombre());
            txtApellido.setText(usuarioAutenticado.getApellido());
            txtTelefono.setText(usuarioAutenticado.getTelefono());
            txtContraseña.setText(usuarioAutenticado.getContrasena());

            if (usuarioAutenticado instanceof Administrador) {
                Administrador admin = (Administrador) usuarioAutenticado;
                txtEmail.setText(admin.getEmail());  // Mostrar el emailtxtEmail.setText(((Administrador) usuarioAutenticado).getEmail());
            } else {
                txtEmail.setEnabled(false); // Deshabilita el campo si no es un administrador
            }
        }
    }      
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel editarPerfil;
    private javax.swing.JLabel editarperfil;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelPerfil;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
