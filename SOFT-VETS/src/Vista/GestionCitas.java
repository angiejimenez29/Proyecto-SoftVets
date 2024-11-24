/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Czar
 */
public class GestionCitas extends javax.swing.JFrame {
    int xMouse,yMouse;
    /**
     * Creates new form GestionCitas
     */
    public GestionCitas() {
        initComponents();
        setLocationRelativeTo(null); 
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelSlogan, "src/imagenlogo/softvetsss.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(iconCliente, "src/imagenlogo/iconito.png");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CitasGestion = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        x = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        historial = new javax.swing.JButton();
        cerrarsesion = new javax.swing.JButton();
        citas = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jLabelNombre = new javax.swing.JLabel();
        jLabelSlogan = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        iconCliente = new javax.swing.JLabel();
        PERFIL = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(620, 520));
        setUndecorated(true);

        CitasGestion.setBackground(new java.awt.Color(255, 255, 255));
        CitasGestion.setMinimumSize(new java.awt.Dimension(620, 520));
        CitasGestion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(248, 245, 245));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        x.setBackground(new java.awt.Color(209, 209, 209));
        x.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        x.setText("X");
        x.setBorderPainted(false);
        x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                xMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                xMouseExited(evt);
            }
        });
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xActionPerformed(evt);
            }
        });
        jPanel1.add(x, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 30, 30));

        jPanel2.setBackground(new java.awt.Color(209, 209, 209));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel2.setLayout(null);

        historial.setBackground(new java.awt.Color(209, 209, 209));
        historial.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        historial.setForeground(new java.awt.Color(51, 51, 51));
        historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Treatment List.png"))); // NOI18N
        historial.setText("  Registro Medico");
        historial.setBorderPainted(false);
        historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialActionPerformed(evt);
            }
        });
        jPanel2.add(historial);
        historial.setBounds(13, 350, 202, 50);

        cerrarsesion.setBackground(new java.awt.Color(209, 209, 209));
        cerrarsesion.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        cerrarsesion.setForeground(new java.awt.Color(51, 51, 51));
        cerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Logout.png"))); // NOI18N
        cerrarsesion.setText("      Cerrar sesion");
        cerrarsesion.setBorderPainted(false);
        cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarsesionActionPerformed(evt);
            }
        });
        jPanel2.add(cerrarsesion);
        cerrarsesion.setBounds(13, 460, 202, 50);

        citas.setBackground(new java.awt.Color(209, 209, 209));
        citas.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        citas.setForeground(new java.awt.Color(51, 51, 51));
        citas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Today.png"))); // NOI18N
        citas.setText("  Gestion de Citas");
        citas.setBorderPainted(false);
        citas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citasActionPerformed(evt);
            }
        });
        jPanel2.add(citas);
        citas.setBounds(13, 400, 202, 50);

        Salir.setBackground(new java.awt.Color(93, 193, 185));
        Salir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("SALIR");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel2.add(Salir);
        Salir.setBounds(30, 540, 170, 50);

        jLabelNombre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabelNombre);
        jLabelNombre.setBounds(40, 220, 155, 40);
        jPanel2.add(jLabelSlogan);
        jLabelSlogan.setBounds(20, 20, 190, 40);

        inicio.setBackground(new java.awt.Color(209, 209, 209));
        inicio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        inicio.setForeground(new java.awt.Color(51, 51, 51));
        inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Home_10.png"))); // NOI18N
        inicio.setText("    Menú principal");
        inicio.setBorderPainted(false);
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        jPanel2.add(inicio);
        inicio.setBounds(13, 290, 202, 50);
        jPanel2.add(iconCliente);
        iconCliente.setBounds(60, 100, 110, 110);

        PERFIL.setBackground(new java.awt.Color(189, 189, 189));
        PERFIL.setBorderPainted(false);
        PERFIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PERFILActionPerformed(evt);
            }
        });
        jPanel2.add(PERFIL);
        PERFIL.setBounds(30, 80, 170, 190);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 610));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setText("Citas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 170, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Order History.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 50, 50));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mascota", "Cita", "Fecha"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 690, 70));

        CitasGestion.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CitasGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CitasGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Color selectedColor = new Color(189, 189, 189); // RGB (0, 153, 153), un tono de azul
    private Color defaultColor = new Color(209, 209, 209); // Color de fondo por defecto, blanco
    
    private void selectButton(javax.swing.JButton button) {

    inicio.setBackground(defaultColor);
    historial.setBackground(defaultColor);
    citas.setBackground(defaultColor);
    cerrarsesion.setBackground(defaultColor);
    button.setBackground(selectedColor);
    }
    
    private void xMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseEntered
        JButton boton = (JButton) evt.getSource();
        boton.setBackground(Color.GRAY);
        boton.setForeground(Color.WHITE);
    }//GEN-LAST:event_xMouseEntered

    private void xMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseExited
        JButton boton = (JButton) evt.getSource();
        boton.setBackground(new Color(209,209,209));
        boton.setForeground(Color.BLACK);
    }//GEN-LAST:event_xMouseExited

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed

        System.exit(0);
    }//GEN-LAST:event_xActionPerformed

    private void historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialActionPerformed
        selectButton(historial);
    }//GEN-LAST:event_historialActionPerformed

    private void cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsesionActionPerformed
        selectButton(cerrarsesion);
        iniciarSesion ventanaSesion = new iniciarSesion();

        ventanaSesion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cerrarsesionActionPerformed

    private void citasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citasActionPerformed
        selectButton(citas);
    }//GEN-LAST:event_citasActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void PERFILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PERFILActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PERFILActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        selectButton(inicio);
    }//GEN-LAST:event_inicioActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

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
            java.util.logging.Logger.getLogger(GestionCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionCitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CitasGestion;
    private javax.swing.JButton PERFIL;
    private javax.swing.JButton Salir;
    private javax.swing.JButton cerrarsesion;
    private javax.swing.JButton citas;
    private javax.swing.JButton historial;
    private javax.swing.JLabel iconCliente;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelSlogan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton x;
    // End of variables declaration//GEN-END:variables
}
