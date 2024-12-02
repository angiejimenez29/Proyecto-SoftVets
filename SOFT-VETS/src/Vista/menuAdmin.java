package Vista;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import Modelo.Usuario;
import javax.swing.JFrame;
import java.awt.CardLayout;


public class menuAdmin extends javax.swing.JFrame {
    private Usuario usuarioAutenticado;
    
    public menuAdmin(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
        initComponents();
        setSize(1094,758);
        setLocationRelativeTo(null);
        nombreApellido.setText(usuarioAutenticado.getNombre() + " " + usuarioAutenticado.getApellido());
        menu.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:40,4,4,4;"        
                + "arc:10");
        
        editarPerfilAdmin editarPerfilPanel = new editarPerfilAdmin(usuarioAutenticado,this);   
        cambio.add(editarPerfilPanel, "EDITAR PERFIL");
        editarPerfilPanel.usuarioInfo();
        
        cambio.add(new gestionPersonalAdmin(), "GESTION PERSONAL");
        cambio.add(menuPrincipal, "Menu Principal");
        cambio.add(new gestionClienteAdmin(), "GESTION CLIENTE");
        cambio.add(new gestionMascotaAdmin(), "GESTION MASCOTAS");
        selectButton(clientes);
        clientesActionPerformed(null);
        
    }
    public void actualizarNombreApellido(String nombre, String apellido) {
        nombreApellido.setText(nombre + " " + apellido);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        nombreApellido = new javax.swing.JLabel();
        perfilEditar = new javax.swing.JButton();
        mascotas = new javax.swing.JButton();
        cerrarsesion = new javax.swing.JButton();
        citas = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        VETS = new javax.swing.JLabel();
        SOFT = new javax.swing.JLabel();
        clientes = new javax.swing.JButton();
        personal = new javax.swing.JButton();
        cambio = new javax.swing.JPanel();
        menuPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Soft Vets");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1094, 758));

        fondo.setBackground(new java.awt.Color(248, 245, 245));
        fondo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fondo.setInheritsPopupMenu(true);
        fondo.setOpaque(false);
        fondo.setPreferredSize(new java.awt.Dimension(1080, 720));
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
        nombreApellido.setBounds(50, 230, 170, 40);

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
        perfilEditar.setBounds(50, 80, 170, 190);

        mascotas.setBackground(new java.awt.Color(209, 209, 209));
        mascotas.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        mascotas.setForeground(new java.awt.Color(51, 51, 51));
        mascotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Cat Cage.png"))); // NOI18N
        mascotas.setText("  Gestion de Mascotas");
        mascotas.setBorderPainted(false);
        mascotas.setHideActionText(true);
        mascotas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        mascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mascotasActionPerformed(evt);
            }
        });
        menu.add(mascotas);
        mascotas.setBounds(15, 340, 230, 50);

        cerrarsesion.setBackground(new java.awt.Color(209, 209, 209));
        cerrarsesion.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        cerrarsesion.setForeground(new java.awt.Color(51, 51, 51));
        cerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Logout.png"))); // NOI18N
        cerrarsesion.setText("              Cerrar sesion");
        cerrarsesion.setBorderPainted(false);
        cerrarsesion.setHideActionText(true);
        cerrarsesion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarsesionActionPerformed(evt);
            }
        });
        menu.add(cerrarsesion);
        cerrarsesion.setBounds(15, 490, 230, 50);

        citas.setBackground(new java.awt.Color(209, 209, 209));
        citas.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        citas.setForeground(new java.awt.Color(51, 51, 51));
        citas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Today.png"))); // NOI18N
        citas.setText("         Gestion de Citas");
        citas.setBorderPainted(false);
        citas.setHideActionText(true);
        citas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        citas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citasActionPerformed(evt);
            }
        });
        menu.add(citas);
        citas.setBounds(15, 440, 230, 50);

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
        Salir.setBounds(30, 630, 200, 50);

        VETS.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        VETS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VETS.setText("VETS");
        VETS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.add(VETS);
        VETS.setBounds(130, 20, 80, 45);

        SOFT.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        SOFT.setForeground(new java.awt.Color(73, 166, 166));
        SOFT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SOFT.setText("SOFT");
        SOFT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.add(SOFT);
        SOFT.setBounds(50, 20, 90, 45);

        clientes.setBackground(new java.awt.Color(209, 209, 209));
        clientes.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        clientes.setForeground(new java.awt.Color(51, 51, 51));
        clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Customer_1.png"))); // NOI18N
        clientes.setText("    Gestion de Clientes");
        clientes.setBorderPainted(false);
        clientes.setHideActionText(true);
        clientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });
        menu.add(clientes);
        clientes.setBounds(15, 290, 230, 50);

        personal.setBackground(new java.awt.Color(209, 209, 209));
        personal.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        personal.setForeground(new java.awt.Color(51, 51, 51));
        personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Name Tag.png"))); // NOI18N
        personal.setText("   Gestion de Personal");
        personal.setBorderPainted(false);
        personal.setHideActionText(true);
        personal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalActionPerformed(evt);
            }
        });
        menu.add(personal);
        personal.setBounds(15, 390, 230, 50);

        fondo.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, 260, 710));

        cambio.setBackground(new java.awt.Color(248, 245, 245));
        cambio.setLayout(new java.awt.CardLayout());

        menuPrincipal.setPreferredSize(new java.awt.Dimension(840, 720));

        javax.swing.GroupLayout menuPrincipalLayout = new javax.swing.GroupLayout(menuPrincipal);
        menuPrincipal.setLayout(menuPrincipalLayout);
        menuPrincipalLayout.setHorizontalGroup(
            menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        menuPrincipalLayout.setVerticalGroup(
            menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        cambio.add(menuPrincipal, "card3");

        fondo.add(cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 820, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
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
    mascotas.setBackground(defaultColor);
    citas.setBackground(defaultColor);
    cerrarsesion.setBackground(defaultColor);
    perfilEditar.setBackground(defaultColor);
    mascotas.setBackground(defaultColor);
    clientes.setBackground(defaultColor);
    personal.setBackground(defaultColor);   
    button.setBackground(selectedColor);
    }    
    
    public static void transition(JFrame from, JFrame to) {
        from.setVisible(false);
        to.setLocation(from.getLocation());
        to.setVisible(true);
        from.dispose();
    }   
    
    private void mostrarPanel(String panelName) {
        CardLayout cl = (CardLayout) cambio.getLayout();
        cl.show(cambio, panelName);
    }
    
    private void perfilEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilEditarActionPerformed
        selectButton(perfilEditar);
        mostrarPanel("EDITAR PERFIL");
    }//GEN-LAST:event_perfilEditarActionPerformed

    private void mascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mascotasActionPerformed
        selectButton(mascotas);
        mostrarPanel("GESTION MASCOTAS");
        
    }//GEN-LAST:event_mascotasActionPerformed

    private void cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarsesionActionPerformed
        selectButton(cerrarsesion);
        iniciarSesion ventanaSesion = new iniciarSesion();
        ventanaSesion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cerrarsesionActionPerformed

    private void citasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citasActionPerformed
        selectButton(citas);
        RegistrarCita newframe= new RegistrarCita ();   
        newframe.setVisible(true);
    }//GEN-LAST:event_citasActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void fondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseDragged

    }//GEN-LAST:event_fondoMouseDragged

    private void fondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMousePressed

    }//GEN-LAST:event_fondoMousePressed

    private void personalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalActionPerformed
        selectButton(personal);
        mostrarPanel("GESTION PERSONAL");

    }//GEN-LAST:event_personalActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        selectButton(clientes);
        mostrarPanel("GESTION CLIENTE");
    }//GEN-LAST:event_clientesActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SOFT;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel VETS;
    private javax.swing.JPanel cambio;
    private javax.swing.JButton cerrarsesion;
    private javax.swing.JButton citas;
    private javax.swing.JButton clientes;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton mascotas;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuPrincipal;
    private javax.swing.JLabel nombreApellido;
    private javax.swing.JButton perfilEditar;
    private javax.swing.JButton personal;
    // End of variables declaration//GEN-END:variables
}

