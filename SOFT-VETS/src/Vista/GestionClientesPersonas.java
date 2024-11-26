/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author Czar
 */
public class GestionClientesPersonas extends javax.swing.JFrame {
    int xMouse, yMouse;
    /**
     * Creates new form GestionClientesPersonas
     */
    public GestionClientesPersonas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FondoGestionCP = new javax.swing.JPanel();
        Agregar = new javax.swing.JToggleButton();
        Regresar = new javax.swing.JToggleButton();
        Modificar = new javax.swing.JToggleButton();
        softvets = new javax.swing.JLabel();
        Eliminar = new javax.swing.JToggleButton();
        header = new javax.swing.JPanel();
        exitxt = new javax.swing.JPanel();
        salirtxt = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(620, 520));
        setUndecorated(true);

        FondoGestionCP.setBackground(new java.awt.Color(255, 255, 255));
        FondoGestionCP.setMinimumSize(new java.awt.Dimension(620, 520));
        FondoGestionCP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Agregar.setBackground(new java.awt.Color(0, 204, 204));
        Agregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Agregar.setForeground(new java.awt.Color(255, 255, 255));
        Agregar.setText("Agregar ");
        FondoGestionCP.add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 170, 40));

        Regresar.setBackground(new java.awt.Color(0, 204, 204));
        Regresar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Regresar.setForeground(new java.awt.Color(255, 255, 255));
        Regresar.setText("Volver");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        FondoGestionCP.add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 50));

        Modificar.setBackground(new java.awt.Color(0, 204, 204));
        Modificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Modificar.setForeground(new java.awt.Color(255, 255, 255));
        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        FondoGestionCP.add(Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 170, 40));

        softvets.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        softvets.setForeground(new java.awt.Color(153, 153, 153));
        softvets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenlogo/2222CIRCULOS.png"))); // NOI18N
        softvets.setText("SOFTVETS");
        FondoGestionCP.add(softvets, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 190, 60));

        Eliminar.setBackground(new java.awt.Color(0, 204, 204));
        Eliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        FondoGestionCP.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 170, 40));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        exitxt.setBackground(new java.awt.Color(255, 255, 255));

        salirtxt.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        salirtxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salirtxt.setText("X");
        salirtxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salirtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirtxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salirtxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salirtxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitxtLayout = new javax.swing.GroupLayout(exitxt);
        exitxt.setLayout(exitxtLayout);
        exitxtLayout.setHorizontalGroup(
            exitxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salirtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );
        exitxtLayout.setVerticalGroup(
            exitxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salirtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 927, Short.MAX_VALUE)
                .addComponent(exitxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        FondoGestionCP.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 980, 40));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de Clientes y Mascotas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        FondoGestionCP.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 350, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FondoGestionCP, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoGestionCP, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModificarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarActionPerformed

    private void salirtxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirtxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_salirtxtMouseClicked

    private void salirtxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirtxtMouseEntered
        
    }//GEN-LAST:event_salirtxtMouseEntered

    private void salirtxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirtxtMouseExited
        
    }//GEN-LAST:event_salirtxtMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

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
            java.util.logging.Logger.getLogger(GestionClientesPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionClientesPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionClientesPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionClientesPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionClientesPersonas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Agregar;
    private javax.swing.JToggleButton Eliminar;
    private javax.swing.JPanel FondoGestionCP;
    private javax.swing.JToggleButton Modificar;
    private javax.swing.JToggleButton Regresar;
    private javax.swing.JPanel exitxt;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel salirtxt;
    private javax.swing.JLabel softvets;
    // End of variables declaration//GEN-END:variables
}
