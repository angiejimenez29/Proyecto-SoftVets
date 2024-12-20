package Vista;

import Controlador.ControladorAdministrador;
import Controlador.ControladorUsuario;
import Modelo.Administrador;
import Modelo.Usuario;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class editarPerfilAdmin extends javax.swing.JPanel {
    private ControladorUsuario usuarioControlador;
    private ControladorAdministrador administradorControlador;
    private Usuario usuarioAutenticado;
    private menuAdmin menuAdmin;
    private String originalNombre;
    private String originalApellido;
    private String originalTelefono;
    private String originalEmail;
    private String originalContrasena;

    
    public editarPerfilAdmin(Usuario usuario, menuAdmin menuAdmin) {
        this.usuarioAutenticado = usuario;
        this.menuAdmin = menuAdmin; 
        initComponents();
        
        JTextField[] campos = {txtNombre, txtApellido, txtTelefono, txtEmail};
        for (JTextField campo : campos) {
            campo.putClientProperty(FlatClientProperties.STYLE, " "
                + "arc:10;"
                + "borderColor:#F6F6F6;"
                + "focusedBorderColor:#00B2B2;"
                + "font:Roboto,plain,14;"   
            );
        }
        txtContraseña.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10;"
                + "showRevealButton:true;"
                + "borderColor:#F6F6F6;"
                + "focusedBorderColor:#00B2B2;"
                + "showCapsLock:true;"
                + "font:Roboto,plain,14;"); 
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

        panelPerfil.setBackground(new java.awt.Color(209, 209, 209));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Apellido");

        txtApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Contraseña");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Telefono");

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPerfilLayout = new javax.swing.GroupLayout(panelPerfil);
        panelPerfil.setLayout(panelPerfilLayout);
        panelPerfilLayout.setHorizontalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPerfilLayout.createSequentialGroup()
                        .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPerfilLayout.createSequentialGroup()
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtContraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        panelPerfilLayout.setVerticalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPerfilLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(88, 88, 88))
        );

        editarPerfil.add(panelPerfil);
        panelPerfil.setBounds(190, 170, 440, 450);

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
        
        menuAdmin.actualizarNombreApellido(nombre, apellido);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtNombre.setText(originalNombre);
        txtApellido.setText(originalApellido);
        txtTelefono.setText(originalTelefono);
        txtContraseña.setText(originalContrasena);

        if (usuarioAutenticado instanceof Administrador) {
            txtEmail.setText(originalEmail);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    public void usuarioInfo(){
        if (usuarioAutenticado != null) {
        originalNombre = usuarioAutenticado.getNombre();
        originalApellido = usuarioAutenticado.getApellido();
        originalTelefono = usuarioAutenticado.getTelefono();
        originalContrasena = usuarioAutenticado.getContrasena();

        if (usuarioAutenticado instanceof Administrador) {
            Administrador admin = (Administrador) usuarioAutenticado;
            originalEmail = admin.getEmail();
            txtEmail.setText(originalEmail);
        } else {
            txtEmail.setEnabled(false);
        }

        txtNombre.setText(originalNombre);
        txtApellido.setText(originalApellido);
        txtTelefono.setText(originalTelefono);
        txtContraseña.setText(originalContrasena);
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
