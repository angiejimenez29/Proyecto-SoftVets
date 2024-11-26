/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import java.awt.Image;

public class registraradmin extends javax.swing.JFrame {
    private JPanel fondo;
    /**
     * Creates new form registraradmin
     */
    public registraradmin() {
        initComponents();
        this.setLocationRelativeTo(this);
        
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabel4, "Ventana/imagenlogo/ICONCLIENTEF.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabel5, "Ventana/imagenlogo/Green Modern Veterinary Clinic Logo.png");
    }
    public JPanel getFondo() {
        return Fondo;
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
        jLabel2 = new javax.swing.JLabel();
        Fondo = new javax.swing.JPanel();
        RegistrarB = new javax.swing.JButton();
        CorreoE = new javax.swing.JLabel();
        ContraseñaE = new javax.swing.JLabel();
        UsuarioPedir = new javax.swing.JTextField();
        Titulo = new javax.swing.JPanel();
        TituloRegistro = new javax.swing.JLabel();
        softvets = new javax.swing.JLabel();
        ContraseñaPedir = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 520));

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setPreferredSize(new java.awt.Dimension(620, 520));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RegistrarB.setBackground(new java.awt.Color(0, 204, 204));
        RegistrarB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RegistrarB.setForeground(new java.awt.Color(255, 255, 255));
        RegistrarB.setText("Registrar");
        Fondo.add(RegistrarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 200, 50));

        CorreoE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CorreoE.setText("CORREO NUEVO USUARIO");
        Fondo.add(CorreoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        ContraseñaE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContraseñaE.setText("CONTRASEÑA");
        Fondo.add(ContraseñaE, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        UsuarioPedir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UsuarioPedir.setForeground(new java.awt.Color(204, 204, 204));
        UsuarioPedir.setText("Usuario nuevo");
        UsuarioPedir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UsuarioPedirMousePressed(evt);
            }
        });
        UsuarioPedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioPedirActionPerformed(evt);
            }
        });
        Fondo.add(UsuarioPedir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 520, -1));

        Titulo.setBackground(new java.awt.Color(0, 204, 204));
        Titulo.setForeground(new java.awt.Color(255, 255, 255));

        TituloRegistro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TituloRegistro.setForeground(new java.awt.Color(255, 255, 255));
        TituloRegistro.setText("REGISTRO DE NUEVO USUARIO");

        javax.swing.GroupLayout TituloLayout = new javax.swing.GroupLayout(Titulo);
        Titulo.setLayout(TituloLayout);
        TituloLayout.setHorizontalGroup(
            TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloRegistro)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        TituloLayout.setVerticalGroup(
            TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TituloLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(TituloRegistro)
                .addContainerGap())
        );

        Fondo.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 270, 40));

        softvets.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        softvets.setForeground(new java.awt.Color(153, 153, 153));
        softvets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenlogo/2222CIRCULOS.png"))); // NOI18N
        softvets.setText("SOFTVETS");
        Fondo.add(softvets, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 170, 40));

        ContraseñaPedir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContraseñaPedir.setForeground(new java.awt.Color(204, 204, 204));
        ContraseñaPedir.setText("**********");
        ContraseñaPedir.setToolTipText("");
        ContraseñaPedir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ContraseñaPedirMousePressed(evt);
            }
        });
        ContraseñaPedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaPedirActionPerformed(evt);
            }
        });
        Fondo.add(ContraseñaPedir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 520, -1));
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 90, 120));
        Fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));
        Fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 190, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsuarioPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioPedirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioPedirActionPerformed

    private void UsuarioPedirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsuarioPedirMousePressed
        if (UsuarioPedir.getText().equals("Usuario nuevo")){
        UsuarioPedir.setText("");
        UsuarioPedir.setForeground(Color.black);
        }
        if (String.valueOf(ContraseñaPedir.getPassword()).isEmpty()) {
    } else {
            ContraseñaPedir.setText("**********");
            ContraseñaPedir.setForeground(Color.gray);
    }                                  
        
    }//GEN-LAST:event_UsuarioPedirMousePressed

    private void ContraseñaPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaPedirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaPedirActionPerformed

    private void ContraseñaPedirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContraseñaPedirMousePressed
        if (String.valueOf(ContraseñaPedir.getPassword()).equals("**********")){
            ContraseñaPedir.setText("");
            ContraseñaPedir.setForeground(Color.black);
        }
        if(UsuarioPedir.getText().isEmpty()){
        UsuarioPedir.setText("Usuario nuevo");
        UsuarioPedir.setForeground(Color.gray);
        }
        ContraseñaPedir.setText("");
        ContraseñaPedir.setForeground(Color.black);
    }//GEN-LAST:event_ContraseñaPedirMousePressed

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
            java.util.logging.Logger.getLogger(registraradmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registraradmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registraradmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registraradmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registraradmin().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ContraseñaE;
    private javax.swing.JPasswordField ContraseñaPedir;
    private javax.swing.JLabel CorreoE;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton RegistrarB;
    private javax.swing.JPanel Titulo;
    private javax.swing.JLabel TituloRegistro;
    private javax.swing.JTextField UsuarioPedir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel softvets;
    // End of variables declaration//GEN-END:variables
}
