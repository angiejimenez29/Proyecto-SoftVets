package Vista;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import Modelo.Usuario;

public class menuCliente extends javax.swing.JFrame {
    private Usuario usuarioAutenticado;
        
    public menuCliente() {
        this.usuarioAutenticado = Usuario.getInstance();
        initComponents();
        setSize(1094,758);
        setLocationRelativeTo(null);
        nombreApellido.setText(usuarioAutenticado.getNombre() + " " + usuarioAutenticado.getApellido());
        menu.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:40,4,4,4;"        
                + "arc:10");
        labelNombre.putClientProperty(FlatClientProperties.STYLE, "arc:10"); 
        labelApellido.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        labelContraseña.putClientProperty(FlatClientProperties.STYLE, "arc:10"); 
        labelEmail.putClientProperty(FlatClientProperties.STYLE, "arc:10"); 
        labelTelefono.putClientProperty(FlatClientProperties.STYLE, "arc:10"); 
        selectButton(inicio);
        inicioActionPerformed(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        nombreApellido = new javax.swing.JLabel();
        perfilEditar = new javax.swing.JButton();
        inicio = new javax.swing.JButton();
        historial = new javax.swing.JButton();
        cerrarsesion = new javax.swing.JButton();
        citas = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        SOFT = new javax.swing.JLabel();
        VETS = new javax.swing.JLabel();
        cambio = new javax.swing.JPanel();
        editarPerfil = new javax.swing.JPanel();
        labelNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelApellido = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        labelContraseña = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        menuPrincipal = new javax.swing.JPanel();
        registrarMascota = new javax.swing.JButton();
        txtCitas = new javax.swing.JLabel();
        iconCitas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMascotas = new javax.swing.JTable();
        iconMascotas = new javax.swing.JLabel();
        txtMascotas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Soft Vets");
        setLocationByPlatform(true);
        setResizable(false);

        fondo.setBackground(new java.awt.Color(248, 245, 245));
        fondo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fondo.setInheritsPopupMenu(true);
        fondo.setOpaque(false);
        fondo.setRequestFocusEnabled(false);
        fondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                fondoMouseDragged(evt);
            }
        });
        fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fondoMousePressed(evt);
            }
        });
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(209, 209, 209));
        menu.setLayout(null);

        nombreApellido.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        nombreApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreApellido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menu.add(nombreApellido);
        nombreApellido.setBounds(30, 230, 170, 40);

        perfilEditar.setBackground(new java.awt.Color(209, 209, 209));
        perfilEditar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        perfilEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/iconito.png"))); // NOI18N
        perfilEditar.setBorderPainted(false);
        perfilEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        perfilEditar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        perfilEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilEditarActionPerformed(evt);
            }
        });
        menu.add(perfilEditar);
        perfilEditar.setBounds(30, 90, 170, 190);

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
        menu.add(inicio);
        inicio.setBounds(14, 290, 202, 50);

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
        menu.add(historial);
        historial.setBounds(14, 350, 202, 50);
        historial.getAccessibleContext().setAccessibleName("");

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
        menu.add(cerrarsesion);
        cerrarsesion.setBounds(14, 470, 202, 50);
        cerrarsesion.getAccessibleContext().setAccessibleName("");

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
        menu.add(citas);
        citas.setBounds(14, 410, 202, 50);
        citas.getAccessibleContext().setAccessibleName("");

        Salir.setBackground(new java.awt.Color(93, 193, 185));
        Salir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("SALIR");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        menu.add(Salir);
        Salir.setBounds(30, 630, 170, 50);

        SOFT.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        SOFT.setForeground(new java.awt.Color(73, 166, 166));
        SOFT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SOFT.setText("SOFT");
        SOFT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.add(SOFT);
        SOFT.setBounds(30, 20, 90, 45);

        VETS.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        VETS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VETS.setText("VETS");
        VETS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.add(VETS);
        VETS.setBounds(120, 20, 80, 45);

        fondo.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, 230, 710));

        cambio.setBackground(new java.awt.Color(248, 245, 245));
        cambio.setLayout(new java.awt.CardLayout());

        editarPerfil.setLayout(null);

        labelNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editarPerfil.add(labelNombre);
        labelNombre.setBounds(210, 230, 170, 26);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nombre");
        editarPerfil.add(jLabel1);
        jLabel1.setBounds(210, 190, 83, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Apellido");
        editarPerfil.add(jLabel2);
        jLabel2.setBounds(420, 190, 121, 40);

        labelApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelApellidoActionPerformed(evt);
            }
        });
        editarPerfil.add(labelApellido);
        labelApellido.setBounds(420, 230, 170, 26);

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelTelefonoActionPerformed(evt);
            }
        });
        editarPerfil.add(labelTelefono);
        labelTelefono.setBounds(210, 400, 380, 26);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Contraseña");
        editarPerfil.add(jLabel3);
        jLabel3.setBounds(210, 450, 104, 34);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Email");
        editarPerfil.add(jLabel4);
        jLabel4.setBounds(210, 270, 63, 34);

        labelEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editarPerfil.add(labelEmail);
        labelEmail.setBounds(210, 320, 380, 26);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Telefono");
        editarPerfil.add(jLabel5);
        jLabel5.setBounds(210, 360, 105, 34);

        labelContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editarPerfil.add(labelContraseña);
        labelContraseña.setBounds(210, 490, 380, 26);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel6.setText("Editar Perfil");
        editarPerfil.add(jLabel6);
        jLabel6.setBounds(140, 60, 148, 41);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jButton1.setText("Cancelar");
        editarPerfil.add(jButton1);
        jButton1.setBounds(210, 610, 170, 34);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        editarPerfil.add(jButton2);
        jButton2.setBounds(430, 610, 160, 34);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Pen Squared.png"))); // NOI18N
        editarPerfil.add(jLabel7);
        jLabel7.setBounds(80, 60, 50, 41);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/iconito.png"))); // NOI18N
        editarPerfil.add(jLabel8);
        jLabel8.setBounds(630, 50, 140, 140);

        cambio.add(editarPerfil, "card2");

        menuPrincipal.setPreferredSize(new java.awt.Dimension(840, 720));
        menuPrincipal.setLayout(null);

        registrarMascota.setBackground(new java.awt.Color(209, 209, 209));
        registrarMascota.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        registrarMascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Add New.png"))); // NOI18N
        registrarMascota.setText("  Registrar mascota");
        registrarMascota.setBorderPainted(false);
        registrarMascota.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        registrarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarMascotaActionPerformed(evt);
            }
        });
        menuPrincipal.add(registrarMascota);
        registrarMascota.setBounds(310, 42, 190, 45);

        txtCitas.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtCitas.setText("Citas");
        menuPrincipal.add(txtCitas);
        txtCitas.setBounds(110, 386, 90, 32);

        iconCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Order History.png"))); // NOI18N
        menuPrincipal.add(iconCitas);
        iconCitas.setBounds(42, 377, 50, 50);

        tablaMascotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Especie", "Raza", "Edad"
            }
        ));
        tablaMascotas.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tablaMascotas);
        tablaMascotas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        menuPrincipal.add(jScrollPane1);
        jScrollPane1.setBounds(43, 121, 758, 209);

        iconMascotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Cat Footprint_2.png"))); // NOI18N
        menuPrincipal.add(iconMascotas);
        iconMascotas.setBounds(43, 37, 50, 50);

        txtMascotas.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtMascotas.setText("Tus mascotas");
        menuPrincipal.add(txtMascotas);
        txtMascotas.setBounds(111, 55, 180, 32);

        tablaCitas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaCitas);

        menuPrincipal.add(jScrollPane2);
        jScrollPane2.setBounds(42, 464, 763, 205);

        cambio.add(menuPrincipal, "card3");

        fondo.add(cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 840, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private Color selectedColor = new Color(189, 189, 189);
    private Color defaultColor = new Color(209, 209, 209);
    
    private void selectButton(javax.swing.JButton button) {
    inicio.setBackground(defaultColor);
    historial.setBackground(defaultColor);
    citas.setBackground(defaultColor);
    cerrarsesion.setBackground(defaultColor);
    perfilEditar.setBackground(defaultColor);
    button.setBackground(selectedColor);
    }


    private void fondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMousePressed

    }//GEN-LAST:event_fondoMousePressed

    private void fondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseDragged

    }//GEN-LAST:event_fondoMouseDragged

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void citasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citasActionPerformed
        selectButton(citas);

    }//GEN-LAST:event_citasActionPerformed

    private void cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsesionActionPerformed
        selectButton(cerrarsesion);
        iniciarSesion ventanaSesion = new iniciarSesion();
        ventanaSesion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cerrarsesionActionPerformed

    private void historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialActionPerformed
        selectButton(historial);
    }//GEN-LAST:event_historialActionPerformed

    private void perfilEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilEditarActionPerformed
        selectButton(perfilEditar);
        cambio.removeAll();
        cambio.add(editarPerfil);
        cambio.repaint();
        cambio.revalidate();
    }//GEN-LAST:event_perfilEditarActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        selectButton(inicio);
        cambio.removeAll();
        cambio.add(menuPrincipal);
        cambio.repaint();
        cambio.revalidate();
    }//GEN-LAST:event_inicioActionPerformed

    private void registrarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarMascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarMascotaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void labelApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelApellidoActionPerformed

    private void labelTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelTelefonoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SOFT;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel VETS;
    private javax.swing.JPanel cambio;
    private javax.swing.JButton cerrarsesion;
    private javax.swing.JButton citas;
    private javax.swing.JPanel editarPerfil;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton historial;
    private javax.swing.JLabel iconCitas;
    private javax.swing.JLabel iconMascotas;
    private javax.swing.JButton inicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField labelApellido;
    private javax.swing.JTextField labelContraseña;
    private javax.swing.JTextField labelEmail;
    private javax.swing.JTextField labelNombre;
    private javax.swing.JTextField labelTelefono;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuPrincipal;
    private javax.swing.JLabel nombreApellido;
    private javax.swing.JButton perfilEditar;
    private javax.swing.JButton registrarMascota;
    private javax.swing.JTable tablaCitas;
    private javax.swing.JTable tablaMascotas;
    private javax.swing.JLabel txtCitas;
    private javax.swing.JLabel txtMascotas;
    // End of variables declaration//GEN-END:variables
}
