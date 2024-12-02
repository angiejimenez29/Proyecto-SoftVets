package Vista;

import Controlador.ControladorMascota;
import Modelo.Cliente;
import Modelo.Mascota;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class gestionMascotaAdmin extends javax.swing.JPanel {
    private ControladorMascota controlador;
    private administrarMascota adminMascota;
    private Integer idMascotaSeleccionada, edadSeleccionado;
    private Integer idMascota, edadOriginal;
    private String nombreMascotaOriginal, nombreOriginal, apellidoOriginal, especieOriginal, razaOriginal, sexoOriginal;
    private String nombreMascotaSeleccionado, nombreSeleccionado, apellidoSeleccionado, especieSeleccionado, razaSeleccionado, sexoSeleccionado;

    
    public gestionMascotaAdmin() {
        initComponents();
        init();
        controlador = new ControladorMascota(this);
        controlador.mostrarMascotas(tablaMascotas);   
        adminMascota = new administrarMascota();
        cambio.add(mascotaTabla, "MASCOTAS");
        cambio.add(historialMedico, "HISTORIALMEDICO");
        fecha.setCloseAfterSelected(true);
        fecha.setEditor(txtNacimiento); 
    }
    
    private void init(){
        mascotaTabla.putClientProperty(FlatClientProperties.STYLE , ""
                + "arc:25;"
                + "background:$Table.background"
        );
        tablaMascotas.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");
        tablaMascotas.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:50;"
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
        txtBuscarMascota.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar...");
        txtBuscarMascota.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "background:$Panel.background");
        txtBuscarMascota.setFont(new java.awt.Font("Roboto", java.awt.Font.PLAIN, 14));        
    }
    
    public void mostrarDatosMascota(Mascota mascota) {
        txtNombre.setText(mascota.getNombreMascota());
        BoxEspecie.setSelectedIndex(mascota.getEspecie());
        txtRaza.setText(mascota.getRaza());
        txtEdad.setText(String.valueOf(mascota.getEdad()));
        BoxSexo.setSelectedItem(mascota.getSexo());
        txtColor.setText(mascota.getColor());
        txtPeso.setText(String.valueOf(mascota.getPeso()));
        RadioCastrado.setSelected(mascota.isCastrada());
        
        java.util.Date utilDate = mascota.getFechaNacimiento();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(utilDate);
        txtNacimiento.setText(formattedDate);

        Cliente cliente = Cliente.obtenerClientePorId(mascota.getIdCliente());
        if (cliente != null) {      
        txtCliente.setText(cliente.getNombre() + " " + cliente.getApellido());
        } else {
        txtCliente.setText("Cliente no encontrado");
    }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fecha = new raven.datetime.component.date.DatePicker();
        cambio = new javax.swing.JPanel();
        historialMedico = new javax.swing.JPanel();
        editarperfil1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historial = new javax.swing.JPanel();
        infoMascota = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BoxEspecie = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtRaza = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        BoxSexo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNacimiento = new javax.swing.JFormattedTextField();
        RadioCastrado = new javax.swing.JRadioButton();
        checkBox = new javax.swing.JPanel();
        Guardar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        mascotaTabla = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tablaMascotas = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscarMascota = new javax.swing.JTextField();
        Eliminar = new javax.swing.JButton();
        HistorialMedico = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        editarperfil = new javax.swing.JLabel();
        Nuevo = new javax.swing.JButton();

        cambio.setLayout(new java.awt.CardLayout());

        editarperfil1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        editarperfil1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Medical History_3.png"))); // NOI18N
        editarperfil1.setText("  HISTORIAL MEDICO");

        historial.setPreferredSize(new java.awt.Dimension(770, 659));

        infoMascota.setBackground(new java.awt.Color(204, 204, 204));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("Cliente");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Nombre");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Especie");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        BoxEspecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Canino", "Felino", "Roedor" }));
        BoxEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxEspecieActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Raza");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Edad");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        BoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macho", "Hembra" }));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Sexo");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Color");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Peso");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Fecha de Nacimiento ");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setVerifyInputWhenFocusTarget(false);

        RadioCastrado.setText("Castrado");
        RadioCastrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioCastradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoMascotaLayout = new javax.swing.GroupLayout(infoMascota);
        infoMascota.setLayout(infoMascotaLayout);
        infoMascotaLayout.setHorizontalGroup(
            infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoMascotaLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoMascotaLayout.createSequentialGroup()
                        .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoMascotaLayout.createSequentialGroup()
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(infoMascotaLayout.createSequentialGroup()
                                .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)))
                        .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RadioCastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(infoMascotaLayout.createSequentialGroup()
                        .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoxEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
        );
        infoMascotaLayout.setVerticalGroup(
            infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoMascotaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(infoMascotaLayout.createSequentialGroup()
                        .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(BoxEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(infoMascotaLayout.createSequentialGroup()
                        .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(BoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(infoMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioCastrado)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        checkBox.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout checkBoxLayout = new javax.swing.GroupLayout(checkBox);
        checkBox.setLayout(checkBoxLayout);
        checkBoxLayout.setHorizontalGroup(
            checkBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        checkBoxLayout.setVerticalGroup(
            checkBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout historialLayout = new javax.swing.GroupLayout(historial);
        historial.setLayout(historialLayout);
        historialLayout.setHorizontalGroup(
            historialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(historialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        historialLayout.setVerticalGroup(
            historialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(historial);

        Guardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Cancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout historialMedicoLayout = new javax.swing.GroupLayout(historialMedico);
        historialMedico.setLayout(historialMedicoLayout);
        historialMedicoLayout.setHorizontalGroup(
            historialMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historialMedicoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(editarperfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(historialMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historialMedicoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)))
        );
        historialMedicoLayout.setVerticalGroup(
            historialMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historialMedicoLayout.createSequentialGroup()
                .addGroup(historialMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarperfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(680, Short.MAX_VALUE))
            .addGroup(historialMedicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historialMedicoLayout.createSequentialGroup()
                    .addContainerGap(63, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        cambio.add(historialMedico, "card3");

        mascotaTabla.setLayout(null);

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tablaMascotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Especie", "Raza", "Edad", "Sexo", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMascotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMascotasMouseClicked(evt);
            }
        });
        scroll.setViewportView(tablaMascotas);

        mascotaTabla.add(scroll);
        scroll.setBounds(0, 130, 790, 480);
        mascotaTabla.add(jSeparator1);
        jSeparator1.setBounds(0, 130, 790, 30);

        txtBuscarMascota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarMascotaActionPerformed(evt);
            }
        });
        txtBuscarMascota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarMascotaKeyReleased(evt);
            }
        });
        mascotaTabla.add(txtBuscarMascota);
        txtBuscarMascota.setBounds(70, 90, 220, 30);

        Eliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        mascotaTabla.add(Eliminar);
        Eliminar.setBounds(650, 90, 110, 30);

        HistorialMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HistorialMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Medical History_1.png"))); // NOI18N
        HistorialMedico.setText("Historial Medico");
        HistorialMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HistorialMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistorialMedicoActionPerformed(evt);
            }
        });
        mascotaTabla.add(HistorialMedico);
        HistorialMedico.setBounds(600, 620, 170, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Google Web Search_1.png"))); // NOI18N
        mascotaTabla.add(jLabel2);
        jLabel2.setBounds(30, 90, 30, 30);

        editarperfil.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        editarperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenlogo/Animal Shelter.png"))); // NOI18N
        editarperfil.setText("   MASCOTAS");
        mascotaTabla.add(editarperfil);
        editarperfil.setBounds(20, 20, 270, 60);

        Nuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        mascotaTabla.add(Nuevo);
        Nuevo.setBounds(520, 90, 110, 30);

        cambio.add(mascotaTabla, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMascotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMascotasMouseClicked
    int row = tablaMascotas.getSelectedRow();
    if (row >= 0) {
        idMascotaSeleccionada = (Integer) tablaMascotas.getValueAt(row, 0);
        System.out.println("ID Mascota: " + idMascotaSeleccionada);
        controlador.mostrarInfoMascota(idMascotaSeleccionada);
    }
    }//GEN-LAST:event_tablaMascotasMouseClicked

    private void txtBuscarMascotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarMascotaKeyReleased
        String nombreMascota = txtBuscarMascota.getText().trim();
        controlador.buscarMascotas(nombreMascota, tablaMascotas);
    }//GEN-LAST:event_txtBuscarMascotaKeyReleased

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int confirmation = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar esta mascota?", 
                                                 "Confirmación de eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            controlador.eliminarMascota(idMascotaSeleccionada);
            controlador.mostrarMascotas(tablaMascotas);
        }  
    }//GEN-LAST:event_EliminarActionPerformed

    private void HistorialMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialMedicoActionPerformed
        if (idMascotaSeleccionada != null) {
            CardLayout cardLayout = (CardLayout) cambio.getLayout();
            cardLayout.show(cambio, "HISTORIALMEDICO");
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una mascota primero.");
        }
    }//GEN-LAST:event_HistorialMedicoActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        adminMascota.setVisible(true);
        adminMascota.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                controlador.mostrarMascotas(tablaMascotas);
            }
        });
    }//GEN-LAST:event_NuevoActionPerformed

    private void txtBuscarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarMascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarMascotaActionPerformed

    private void BoxEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxEspecieActionPerformed
        
    }//GEN-LAST:event_BoxEspecieActionPerformed

    private void RadioCastradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioCastradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioCastradoActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
try {
        // Captura los datos de la mascota
        String nombreMascota = txtNombre.getText();
        String raza = txtRaza.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String sexo = (String) BoxSexo.getSelectedItem();
        String color = txtColor.getText();
        double peso = Double.parseDouble(txtPeso.getText());

    
        String fechaNacimientoTexto = txtNacimiento.getText();
        java.sql.Date fechaNacimiento = null;
        
        if (!fechaNacimientoTexto.isEmpty()) {
            SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date parsedDate = originalFormat.parse(fechaNacimientoTexto);
            fechaNacimiento = new java.sql.Date(parsedDate.getTime());
        }

        if (nombreMascota.isEmpty() || raza.isEmpty() || txtEdad.getText().isEmpty() || txtPeso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        // Obtener el ID del cliente a partir del nombre y apellido
        String nombreCliente = txtCliente.getText();
        String[] nombreApellido = nombreCliente.split(" ", 2);  // Separar nombre y apellido

        if (nombreApellido.length < 2) {
            JOptionPane.showMessageDialog(this, "Debe ingresar nombre y apellido del cliente.");
            return;
        }

        String nombre = nombreApellido[0]; 
        String apellido = nombreApellido[1];  
        int idCliente = Cliente.obtenerIdClientePorNombreApellido(nombre, apellido);
        
        if (idCliente == -1) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado. Verifique los datos.");
            return;
        }

        // Obtener el ID de la especie
        String especieSeleccionada = (String) BoxEspecie.getSelectedItem();
        int especie = Mascota.obtenerIdEspeciePorNombre(especieSeleccionada);
        
        if (especie == -1) {
            JOptionPane.showMessageDialog(this, "Especie no válida seleccionada.");
            return;
        }

        Mascota mascota = new Mascota(
            idMascotaSeleccionada,
            nombreMascota, 
            especie, 
            raza, 
            edad, 
            sexo, 
            color, 
            peso, 
            fechaNacimiento,  
            RadioCastrado.isSelected(),  
            idCliente
        );

        controlador.guardarCambios(mascota);
        JOptionPane.showMessageDialog(this, "Cambios guardados con éxito");
        CardLayout cardLayout = (CardLayout) cambio.getLayout();
        cardLayout.show(cambio, "MASCOTAS");
        controlador.mostrarMascotas(tablaMascotas);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar los cambios.");
        }

    }//GEN-LAST:event_GuardarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        CardLayout cardLayout = (CardLayout) cambio.getLayout();
        cardLayout.show(cambio, "MASCOTAS");
    }//GEN-LAST:event_CancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxEspecie;
    private javax.swing.JComboBox<String> BoxSexo;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton HistorialMedico;
    private javax.swing.JButton Nuevo;
    private javax.swing.JRadioButton RadioCastrado;
    private javax.swing.JPanel cambio;
    private javax.swing.JPanel checkBox;
    private javax.swing.JLabel editarperfil;
    private javax.swing.JLabel editarperfil1;
    private raven.datetime.component.date.DatePicker fecha;
    private javax.swing.JPanel historial;
    private javax.swing.JPanel historialMedico;
    private javax.swing.JPanel infoMascota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mascotaTabla;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tablaMascotas;
    private javax.swing.JTextField txtBuscarMascota;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JFormattedTextField txtNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtRaza;
    // End of variables declaration//GEN-END:variables
}
