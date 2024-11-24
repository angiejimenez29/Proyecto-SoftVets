package Vista;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.ImageIcon;

public class gestionPersonalAdmin extends javax.swing.JPanel {
    
    public gestionPersonalAdmin() {
        initComponents();
        init();
        ImageIcon img1 = new ImageIcon(getClass().getResource("/imagenlogo/User Account_1.png"));
        ImageIcon tamaño = new ImageIcon(img1.getImage().getScaledInstance(50, 45,1));
        PersonalPane.setIconAt(0, tamaño);
        ImageIcon img2 = new ImageIcon(getClass().getResource("/imagenlogo/Database Administrator.png"));
        ImageIcon tmn = new ImageIcon(img2.getImage().getScaledInstance(45, 45,1));
        PersonalPane.setIconAt(1, tmn);
    }
    
    private void init(){
        personalTabla.putClientProperty(FlatClientProperties.STYLE , ""
                + "arc:25;"
                + "background:$Table.background"
        );
        tablaPersonal.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:35;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");
        tablaPersonal.putClientProperty(FlatClientProperties.STYLE, ""
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
                personalTabla.putClientProperty(FlatClientProperties.STYLE , ""
                + "arc:25;"
                + "background:$Table.background"
        );               
        adminTabla.putClientProperty(FlatClientProperties.STYLE , ""
                + "arc:25;"
                + "background:$Table.background"
        );
        tablaAdmin.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");
        tablaAdmin.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");
        scroll2.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");
        txtBuscar2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar...");
        txtBuscar2.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "background:$Panel.background");
        registrarAdmin.putClientProperty(FlatClientProperties.STYLE , ""
                + "arc:25;"
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gestionPersonalAdmin = new javax.swing.JPanel();
        PersonalPane = new javax.swing.JTabbedPane();
        personalTabla = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tablaPersonal = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscar = new javax.swing.JTextField();
        Eliminar = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        adminTabla = new javax.swing.JPanel();
        scroll2 = new javax.swing.JScrollPane();
        tablaAdmin = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        txtBuscar2 = new javax.swing.JTextField();
        Eliminar2 = new javax.swing.JButton();
        Nuevo2 = new javax.swing.JButton();
        Editar2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        registrarAdmin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        salario = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(820, 720));

        gestionPersonalAdmin.setPreferredSize(new java.awt.Dimension(820, 720));

        PersonalPane.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N

        personalTabla.setLayout(null);

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tablaPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Nombre", "Especialidad", "Telefono", "Contrato", "Horario", "Salario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tablaPersonal);

        personalTabla.add(scroll);
        scroll.setBounds(0, 50, 790, 570);
        personalTabla.add(jSeparator1);
        jSeparator1.setBounds(0, 50, 760, 30);

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        personalTabla.add(txtBuscar);
        txtBuscar.setBounds(60, 10, 220, 30);

        Eliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        personalTabla.add(Eliminar);
        Eliminar.setBounds(620, 10, 110, 30);

        Nuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        personalTabla.add(Nuevo);
        Nuevo.setBounds(360, 10, 110, 30);

        Editar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Editar.setText("Editar");
        personalTabla.add(Editar);
        Editar.setBounds(490, 10, 110, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Search_1.png"))); // NOI18N
        personalTabla.add(jLabel2);
        jLabel2.setBounds(20, 15, 30, 30);

        PersonalPane.addTab("Personal", personalTabla);

        adminTabla.setLayout(null);

        scroll2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tablaAdmin.setModel(new javax.swing.table.DefaultTableModel(
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
                "", "Nombre", "Telefono", "Salario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll2.setViewportView(tablaAdmin);
        if (tablaAdmin.getColumnModel().getColumnCount() > 0) {
            tablaAdmin.getColumnModel().getColumn(0).setResizable(false);
            tablaAdmin.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        adminTabla.add(scroll2);
        scroll2.setBounds(20, 60, 740, 250);
        adminTabla.add(jSeparator3);
        jSeparator3.setBounds(0, 50, 760, 30);

        txtBuscar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar2ActionPerformed(evt);
            }
        });
        adminTabla.add(txtBuscar2);
        txtBuscar2.setBounds(52, 15, 220, 30);

        Eliminar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Eliminar2.setText("Eliminar");
        Eliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar2ActionPerformed(evt);
            }
        });
        adminTabla.add(Eliminar2);
        Eliminar2.setBounds(620, 10, 110, 30);

        Nuevo2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nuevo2.setText("Nuevo");
        Nuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nuevo2ActionPerformed(evt);
            }
        });
        adminTabla.add(Nuevo2);
        Nuevo2.setBounds(360, 10, 110, 30);

        Editar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Editar2.setText("Editar");
        adminTabla.add(Editar2);
        Editar2.setBounds(490, 10, 110, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Search_1.png"))); // NOI18N
        adminTabla.add(jLabel4);
        jLabel4.setBounds(20, 15, 30, 30);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Nombre");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Telefono");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Salario");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        salario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        salario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salarioActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Contraseña");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPasswordField1.setText("jPasswordField1");

        javax.swing.GroupLayout registrarAdminLayout = new javax.swing.GroupLayout(registrarAdmin);
        registrarAdmin.setLayout(registrarAdminLayout);
        registrarAdminLayout.setHorizontalGroup(
            registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarAdminLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrarAdminLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrarAdminLayout.createSequentialGroup()
                        .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(registrarAdminLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(registrarAdminLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62))))
        );
        registrarAdminLayout.setVerticalGroup(
            registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarAdminLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrarAdminLayout.createSequentialGroup()
                        .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrarAdminLayout.createSequentialGroup()
                        .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(38, 38, 38))))
        );

        adminTabla.add(registrarAdmin);
        registrarAdmin.setBounds(30, 350, 730, 200);

        PersonalPane.addTab("Administrador", adminTabla);

        javax.swing.GroupLayout gestionPersonalAdminLayout = new javax.swing.GroupLayout(gestionPersonalAdmin);
        gestionPersonalAdmin.setLayout(gestionPersonalAdminLayout);
        gestionPersonalAdminLayout.setHorizontalGroup(
            gestionPersonalAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PersonalPane, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        gestionPersonalAdminLayout.setVerticalGroup(
            gestionPersonalAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gestionPersonalAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PersonalPane, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gestionPersonalAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gestionPersonalAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        new RegistrarPersonal().setVisible(true);
    }//GEN-LAST:event_NuevoActionPerformed

    private void txtBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar2ActionPerformed

    private void Eliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Eliminar2ActionPerformed

    private void Nuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nuevo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nuevo2ActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void salarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Editar;
    private javax.swing.JButton Editar2;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Eliminar2;
    private javax.swing.JButton Nuevo;
    private javax.swing.JButton Nuevo2;
    private javax.swing.JTabbedPane PersonalPane;
    private javax.swing.JPanel adminTabla;
    private javax.swing.JPanel gestionPersonalAdmin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField nombre;
    private javax.swing.JPanel personalTabla;
    private javax.swing.JPanel registrarAdmin;
    private javax.swing.JFormattedTextField salario;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JTable tablaAdmin;
    private javax.swing.JTable tablaPersonal;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar2;
    // End of variables declaration//GEN-END:variables
}
