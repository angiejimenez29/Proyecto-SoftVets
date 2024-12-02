package Vista;

import Controlador.ControladorAdministrador;
import Modelo.Administrador;
import Modelo.Cliente;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class gestionPersonalAdmin extends javax.swing.JPanel {
    private ControladorAdministrador controlador;
    private Administrador administrador;
    private Integer idUsuarioSeleccionado;
    private String nombreOriginal, apellidoOriginal, telefonoOriginal, emailOriginal;
    private double salarioOriginal;
    
    public gestionPersonalAdmin() {
        initComponents();
        init();

        controlador = new ControladorAdministrador(new Administrador());
        controlador.mostrarAdministradores(tablaAdmin);
        cambio.add(editarAdmin, "EDITAR");
        cambio.add(registrarAdmin, "REGISTRAR");       
    }
    
    private void init(){
        
        ImageIcon img1 = new ImageIcon(getClass().getResource("/imagenlogo/User Account_1.png"));
        ImageIcon tamaño = new ImageIcon(img1.getImage().getScaledInstance(50, 45,1));
        PersonalPane.setIconAt(0, tamaño);
        
        ImageIcon img2 = new ImageIcon(getClass().getResource("/imagenlogo/Database Administrator.png"));
        ImageIcon tmn = new ImageIcon(img2.getImage().getScaledInstance(45, 45,1));
        PersonalPane.setIconAt(1, tmn);
        
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
        txtBuscarPersonal.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar...");
        txtBuscarPersonal.putClientProperty(FlatClientProperties.STYLE, ""
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
        txtBuscarAdmin.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar...");
        txtBuscarAdmin.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "background:$Panel.background");
        registrarAdmin.putClientProperty(FlatClientProperties.STYLE , ""
                + "arc:25;");
        editarAdmin.putClientProperty(FlatClientProperties.STYLE , ""
                + "arc:25;");
        txtBuscarAdmin.setFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 14));
        txtBuscarPersonal.setFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 14));


    JTextField[] campos = {txtContraseña, txtnombre, txtApellido, txtSalario, txtTelefono, txtEmail, 
                        txtNombre1, txtApellido1, txtSalario1, txtTelefono1, txtEmail1};

    String propiedades = ""
        + "arc:10;"
        + "borderColor:#F6F6F6;"
        + "focusedBorderColor:#00B2B2;";
    for (JTextField campo : campos) {
        campo.putClientProperty(FlatClientProperties.STYLE, propiedades);
    }
    txtContraseña.putClientProperty(FlatClientProperties.STYLE, propiedades + "showRevealButton:true;showCapsLock:true;");   
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
        txtBuscarPersonal = new javax.swing.JTextField();
        Eliminar = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        adminTabla = new javax.swing.JPanel();
        scroll2 = new javax.swing.JScrollPane();
        tablaAdmin = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        txtBuscarAdmin = new javax.swing.JTextField();
        EliminarAdmin = new javax.swing.JButton();
        RegistrarAdmin = new javax.swing.JButton();
        EditarAdmin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cambio = new javax.swing.JPanel();
        editarAdmin = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSalario1 = new javax.swing.JFormattedTextField();
        guardarEdicion = new javax.swing.JButton();
        cancelarEdicion = new javax.swing.JButton();
        txtEmail1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtApellido1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        registrarAdmin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JFormattedTextField();
        Registrar = new javax.swing.JButton();
        cancelarRegistro = new javax.swing.JButton();
        jLabelContraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

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

        txtBuscarPersonal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPersonalPersonalActionPerformed(evt);
            }
        });
        personalTabla.add(txtBuscarPersonal);
        txtBuscarPersonal.setBounds(60, 10, 220, 30);

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
                "Nombre", "Telefono", "Email", "Salario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAdminMouseClicked(evt);
            }
        });
        scroll2.setViewportView(tablaAdmin);

        adminTabla.add(scroll2);
        scroll2.setBounds(20, 60, 740, 250);
        adminTabla.add(jSeparator3);
        jSeparator3.setBounds(0, 50, 760, 30);

        txtBuscarAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarAdminActionPerformed(evt);
            }
        });
        txtBuscarAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarAdminKeyReleased(evt);
            }
        });
        adminTabla.add(txtBuscarAdmin);
        txtBuscarAdmin.setBounds(52, 15, 220, 30);

        EliminarAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EliminarAdmin.setText("Eliminar");
        EliminarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarAdminActionPerformed(evt);
            }
        });
        adminTabla.add(EliminarAdmin);
        EliminarAdmin.setBounds(620, 10, 110, 30);

        RegistrarAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RegistrarAdmin.setText("Nuevo");
        RegistrarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarAdminActionPerformed(evt);
            }
        });
        adminTabla.add(RegistrarAdmin);
        RegistrarAdmin.setBounds(360, 10, 110, 30);

        EditarAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EditarAdmin.setText("Editar");
        EditarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarAdminActionPerformed(evt);
            }
        });
        adminTabla.add(EditarAdmin);
        EditarAdmin.setBounds(490, 10, 110, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Search_1.png"))); // NOI18N
        adminTabla.add(jLabel4);
        jLabel4.setBounds(20, 15, 30, 30);

        cambio.setLayout(new java.awt.CardLayout());

        editarAdmin.setBackground(new java.awt.Color(209, 209, 209));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Nombre");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Telefono");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Email");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtSalario1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));

        guardarEdicion.setText("Guardar");
        guardarEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarEdicionActionPerformed(evt);
            }
        });

        cancelarEdicion.setText("Cancelar");
        cancelarEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEdicionActionPerformed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Salario");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Apellido");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout editarAdminLayout = new javax.swing.GroupLayout(editarAdmin);
        editarAdmin.setLayout(editarAdminLayout);
        editarAdminLayout.setHorizontalGroup(
            editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarAdminLayout.createSequentialGroup()
                .addGroup(editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarAdminLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel14))
                        .addGap(33, 33, 33)
                        .addGroup(editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarAdminLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(cancelarEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarAdminLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSalario1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(52, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarAdminLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(guardarEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207))))
        );
        editarAdminLayout.setVerticalGroup(
            editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarAdminLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtSalario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(21, 21, 21)
                .addGroup(editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(40, 40, 40)
                .addGroup(editarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardarEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        cambio.add(editarAdmin, "card3");

        registrarAdmin.setBackground(new java.awt.Color(209, 209, 209));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Nombre");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Telefono");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Email");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));

        Registrar.setText("Guardar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        cancelarRegistro.setText("Cancelar");
        cancelarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarRegistroActionPerformed(evt);
            }
        });

        jLabelContraseña.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelContraseña.setText("Contraseña");
        jLabelContraseña.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Salario");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Apellido");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout registrarAdminLayout = new javax.swing.GroupLayout(registrarAdmin);
        registrarAdmin.setLayout(registrarAdminLayout);
        registrarAdminLayout.setHorizontalGroup(
            registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarAdminLayout.createSequentialGroup()
                .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registrarAdminLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrarAdminLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(cancelarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registrarAdminLayout.createSequentialGroup()
                        .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        registrarAdminLayout.setVerticalGroup(
            registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarAdminLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(21, 21, 21)
                .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelContraseña))
                .addGap(40, 40, 40)
                .addGroup(registrarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cambio.add(registrarAdmin, "card2");

        adminTabla.add(cambio);
        cambio.setBounds(30, 340, 720, 260);

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
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(gestionPersonalAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarPanel(String panelName) {
        CardLayout cl = (CardLayout) cambio.getLayout();
        cl.show(cambio, panelName);
    }
       
    private void iniciarEdicion(int idUsuario) {
        nombreOriginal = txtNombre1.getText();
        apellidoOriginal = txtApellido1.getText();
        telefonoOriginal = txtTelefono1.getText();
        emailOriginal = txtEmail1.getText();
        salarioOriginal = Double.parseDouble(txtSalario1.getText().replace(",", ""));  // Limpiar comas y convertir
    }
    
    private void txtBuscarPersonalPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPersonalPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPersonalPersonalActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        new RegistrarPersonal().setVisible(true);
    }//GEN-LAST:event_NuevoActionPerformed

    private void txtBuscarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarAdminActionPerformed

    private void EliminarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarAdminActionPerformed
        mostrarPanel("EDITAR");
        int confirmation = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este administrador?", 
                                                 "Confirmación de eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            controlador.eliminarAdministrador(idUsuarioSeleccionado);
            controlador.mostrarAdministradores(tablaAdmin);
        }        
    }//GEN-LAST:event_EliminarAdminActionPerformed

    private void RegistrarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarAdminActionPerformed
        mostrarPanel("REGISTRAR");
        
        txtContraseña.setVisible(true);
        jLabelContraseña.setVisible(true);
        txtnombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEmail.setEnabled(true);
        txtSalario.setEnabled(true);
        
        txtnombre.setText("");
        txtApellido.setText("");
        txtContraseña.setText("");
        txtSalario.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        
    }//GEN-LAST:event_RegistrarAdminActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        String nombre = txtnombre.getText();
        String apellido = txtApellido.getText();
        String contrasena = new String(txtContraseña.getPassword());
        String salarioStr = txtSalario.getText().replace(",", "");
            double salario = 0;
            try {
                salario = Double.parseDouble(salarioStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error: El salario ingresado no es válido.");
                return;
            }
        String email = txtEmail.getText();
        String telefono = txtTelefono.getText();
        
        if(nombre.isEmpty() || apellido.isEmpty() ||contrasena.isEmpty() || telefono.isEmpty() || email.isEmpty() || salarioStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        }else{
            Administrador admin = new Administrador(0, nombre, apellido, telefono, "administrador", null, contrasena, email, salario);
            if (admin.registrarAdmin()) {
                JOptionPane.showMessageDialog(this, "Administrador registrado exitosamente.");
                controlador.mostrarAdministradores(tablaAdmin);
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el administrador.");
            }
        }  
    }//GEN-LAST:event_RegistrarActionPerformed

    private void guardarEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarEdicionActionPerformed
        guardarDatosAdministrador(idUsuarioSeleccionado);
        controlador.mostrarAdministradores(tablaAdmin);
    }//GEN-LAST:event_guardarEdicionActionPerformed

    private void EditarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarAdminActionPerformed
        mostrarPanel("EDITAR");
        txtNombre1.setEnabled(true);
        txtApellido1.setEnabled(true);
        txtTelefono1.setEnabled(true);
        txtEmail1.setEnabled(true);
        txtSalario1.setEnabled(true);
        cancelarEdicion.setEnabled(true);
        guardarEdicion.setEnabled(true);
    }//GEN-LAST:event_EditarAdminActionPerformed

    private void tablaAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAdminMouseClicked
        int row = tablaAdmin.getSelectedRow();
        if (row >= 0) {
            Integer idAdministrador = (Integer) tablaAdmin.getValueAt(row, 0); 
            System.out.println("ID Administrador: " + idAdministrador);

            // Resto de datos
            Integer idUsuario = (Integer) tablaAdmin.getValueAt(row, 1);  
            System.out.println("ID Usuario: " + idUsuario);

            String nombreCompleto = (String) tablaAdmin.getValueAt(row, 2); 
            String[] partesNombre = nombreCompleto.split(" ");

            String nombre = partesNombre[0];
            String apellido = partesNombre.length > 1 ? partesNombre[1] : "";

            String telefono = (String) tablaAdmin.getValueAt(row, 3); 
            String email = (String) tablaAdmin.getValueAt(row, 4);  
            Double salario = (Double) tablaAdmin.getValueAt(row, 5);  

            txtNombre1.setText(nombre);
            txtApellido1.setText(apellido);
            txtTelefono1.setText(telefono);
            txtEmail1.setText(email);
            txtSalario1.setText(String.valueOf(salario));

            txtNombre1.setEnabled(false);
            txtApellido1.setEnabled(false);
            txtTelefono1.setEnabled(false);
            txtEmail1.setEnabled(false);
            txtSalario1.setEnabled(false);

            cancelarEdicion.setEnabled(false);
            guardarEdicion.setEnabled(false);

            txtnombre.setText(nombre);
            txtApellido.setText(apellido);
            txtTelefono.setText(telefono);
            txtEmail.setText(email);
            txtSalario.setText(String.valueOf(salario));

            txtnombre.setEnabled(false);
            txtApellido.setEnabled(false);
            txtTelefono.setEnabled(false);
            txtEmail.setEnabled(false);
            txtSalario.setEnabled(false);

            txtContraseña.setVisible(false);
            jLabelContraseña.setVisible(false);

            this.idUsuarioSeleccionado = idUsuario;

            iniciarEdicion(idUsuario);
            }
    }//GEN-LAST:event_tablaAdminMouseClicked

    private void txtBuscarAdminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAdminKeyReleased
        String nombreBuscar = txtBuscarAdmin.getText().trim();      
        controlador.buscarAdmin(nombreBuscar, tablaAdmin);
    }//GEN-LAST:event_txtBuscarAdminKeyReleased

    private void cancelarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarRegistroActionPerformed

            txtnombre.setText("");
            txtApellido.setText("");
            txtContraseña.setText("");
            txtSalario.setText("");
            txtEmail.setText("");
            txtTelefono.setText("");

    }//GEN-LAST:event_cancelarRegistroActionPerformed

    private void cancelarEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEdicionActionPerformed
        txtNombre1.setText(nombreOriginal);
        txtApellido1.setText(apellidoOriginal);
        txtTelefono1.setText(telefonoOriginal);
        txtEmail1.setText(emailOriginal);
        txtSalario1.setText(String.valueOf(salarioOriginal));
    }//GEN-LAST:event_cancelarEdicionActionPerformed
  
    private void guardarDatosAdministrador(int idUsuario) {
        String nombre = txtNombre1.getText();
        String apellido = txtApellido1.getText();
        String telefono = txtTelefono1.getText();
        String email = txtEmail1.getText();
        String salarioText = txtSalario1.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || email.isEmpty() || salarioText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return;
        }

        double salario = 0;
        try {
            salario = Double.parseDouble(salarioText.replace(",", ""));  // Limpiar comas y convertir
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El salario debe ser un número válido.");
            return;
        }

        controlador.actualizarAdministrador(nombre, apellido, telefono, email, salario, idUsuario);
        nombreOriginal = nombre;
        apellidoOriginal = apellido;
        telefonoOriginal = telefono;
        emailOriginal = email;
        salarioOriginal = salario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Editar;
    private javax.swing.JButton EditarAdmin;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton EliminarAdmin;
    private javax.swing.JButton Nuevo;
    private javax.swing.JTabbedPane PersonalPane;
    private javax.swing.JButton Registrar;
    private javax.swing.JButton RegistrarAdmin;
    private javax.swing.JPanel adminTabla;
    private javax.swing.JPanel cambio;
    private javax.swing.JButton cancelarEdicion;
    private javax.swing.JButton cancelarRegistro;
    private javax.swing.JPanel editarAdmin;
    private javax.swing.JPanel gestionPersonalAdmin;
    private javax.swing.JButton guardarEdicion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel personalTabla;
    private javax.swing.JPanel registrarAdmin;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JTable tablaAdmin;
    private javax.swing.JTable tablaPersonal;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtBuscarAdmin;
    private javax.swing.JTextField txtBuscarPersonal;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JFormattedTextField txtSalario;
    private javax.swing.JFormattedTextField txtSalario1;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefono1;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
