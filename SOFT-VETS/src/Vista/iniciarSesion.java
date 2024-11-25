package Vista;

import com.formdev.flatlaf.FlatClientProperties;
import Modelo.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class iniciarSesion extends javax.swing.JFrame {    
    int xMouse, yMouse;
    private Usuario usuario;
    
    public iniciarSesion() {
        initComponents();
        init();
        setLocationRelativeTo(null); 
        rsscalelabel.RSScaleLabel.setScaleLabel(logo, "src/imagenlogo/logito.png");  
         usuario = new Usuario();
    }

    private void init() {
        fondo.putClientProperty(FlatClientProperties.STYLE, ""
            + "arc:20;");  
        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");        
        txtPass.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10;"
                + "showRevealButton:true;"
                + "showCapsLock:true;"
                + "borderColor:#F6F6F6;"
                + "focusedBorderColor:#00B2B2;");
        txtUser.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10;"
                + "borderColor:#F6F6F6;"
                + "focusedBorderColor:#00B2B2;");

        txtUser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Usuario");
        txtPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Contraseña");
        setIconImage(getIconImage());        }
        
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenlogo/icono.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sesion = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        fondo = new javax.swing.JPanel();
        usuariotxt = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        contraseñatxt = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        cmdLogin = new javax.swing.JButton();
        lbTitle = new javax.swing.JLabel();
        lbTitle1 = new javax.swing.JLabel();
        lbTitle2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Soft Vets");
        setLocationByPlatform(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        Sesion.setBackground(new java.awt.Color(246, 246, 246));
        Sesion.setForeground(new java.awt.Color(246, 246, 246));
        Sesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Sesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Sesion.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 200, 200));

        fondo.setBackground(new java.awt.Color(209, 209, 209));
        fondo.setPreferredSize(new java.awt.Dimension(232, 700));

        usuariotxt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        usuariotxt.setText("Usuario");

        txtUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUser.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtUser.setSelectionColor(new java.awt.Color(0, 204, 204));
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUserMousePressed(evt);
            }
        });
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        contraseñatxt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        contraseñatxt.setText("Contraseña");

        txtPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPassMousePressed(evt);
            }
        });
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        cmdLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmdLogin.setText("INICIAR SESION");
        cmdLogin.setBorderPainted(false);
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("INICIAR SESION");
        lbTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUser)
                    .addComponent(contraseñatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPass)
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usuariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(contraseñatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(cmdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        Sesion.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 360, 310));

        lbTitle1.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        lbTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle1.setText("VETS");
        lbTitle1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Sesion.add(lbTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 130, -1));

        lbTitle2.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        lbTitle2.setForeground(new java.awt.Color(73, 166, 166));
        lbTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle2.setText("SOFT");
        lbTitle2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Sesion.add(lbTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

       
    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void txtUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMousePressed

    }//GEN-LAST:event_txtUserMousePressed
    
    
    private void txtPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassMousePressed

    }//GEN-LAST:event_txtPassMousePressed

    public void iniciarSesion() {
        Usuario usuarioAutenticado = usuario.iniciarSesion(txtUser.getText(), String.valueOf(txtPass.getPassword()));
        
        if (usuarioAutenticado != null) {           
            if ("administrador".equals(usuarioAutenticado.getTipoUsuario())) {
                menuAdmin ventanaAdmin = new menuAdmin(usuarioAutenticado);
                ventanaAdmin.setIconImage(getIconImage());
                ventanaAdmin.setVisible(true);
                this.setVisible(false);
            } else if ("cliente".equals(usuarioAutenticado.getTipoUsuario())) {
                menuCliente ventanaCliente = new menuCliente();
                ventanaCliente.setIconImage(getIconImage());
                ventanaCliente.setVisible(true);
                this.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error de Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(evt.getXOnScreen() - xMouse, evt.getYOnScreen() - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_cmdLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Sesion;
    private javax.swing.JButton cmdLogin;
    private javax.swing.JLabel contraseñatxt;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTitle1;
    private javax.swing.JLabel lbTitle2;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    private javax.swing.JLabel usuariotxt;
    // End of variables declaration//GEN-END:variables
}
