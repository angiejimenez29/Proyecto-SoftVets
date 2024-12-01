package Vista;

import com.formdev.flatlaf.FlatClientProperties;
import raven.datetime.component.date.DatePicker;
import Modelo.Personal;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class RegistrarPersonal extends javax.swing.JFrame {

    public RegistrarPersonal() {
        initComponents();
        configurarTablaHorario();
        setLocationRelativeTo(null);
        configureHorarioLogic();
        //horarios del personal
        fecha.setCloseAfterSelected(true);
        fecha.setEditor(inicioContrato); 
        DatePicker fechaFin = new DatePicker();
        fechaFin.setCloseAfterSelected(true);
        fechaFin.setEditor(finContrato);
        

        tablaHorario.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");
        tablaHorario.putClientProperty(FlatClientProperties.STYLE, ""
                + "showHorizontalLines:true;"
                + "showHorizontalLines:false;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");
    }
    
    // Método para configurar el modelo de la tabla
    private void configurarTablaHorario() {
        tablaHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {
                {"Lunes", false, false},
                {"Martes", false, false},
                {"Miércoles", false, false},
                {"Jueves", false, false},
                {"Viernes", false, false},
                {"Sábado", false, false},
                {"Domingo", false, false}
            },
            new String[] {
                "Día", "Mañana", "Tarde"
            }
        ) {
            Class[] types = new Class[] {
                String.class, Boolean.class, Boolean.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Solo permite editar las columnas de "Mañana" y "Tarde"
                return column == 1 || column == 2;
            }
        });
    }
    
    private void configureHorarioLogic() {
        tablaHorario.getModel().addTableModelListener(e -> {
            int row = e.getFirstRow(); // Obtiene la fila afectada
            int column = e.getColumn(); // Obtiene la columna afectada

            if (column == 1 || column == 2) { // Columnas "Mañana" o "Tarde"
                Boolean isSelected = (Boolean) tablaHorario.getModel().getValueAt(row, column);

                if (isSelected != null && isSelected) {
                    // Deseleccionar la otra columna dentro de la misma fila
                    int otraColumna = (column == 1) ? 2 : 1;
                    tablaHorario.getModel().setValueAt(false, row, otraColumna);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fecha = new raven.datetime.component.date.DatePicker();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        especialidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        panelTabla = new javax.swing.JPanel();
        tablaHorario = new javax.swing.JTable();
        salario = new javax.swing.JFormattedTextField();
        inicioContrato = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        finContrato = new javax.swing.JFormattedTextField();
        guardarRegistro = new javax.swing.JButton();
        cancelarRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Nombre");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Especialidad");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        especialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medico Veterinario", "Estilista" }));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Desde");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Telefono");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Horario");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Salario");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tablaHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Lunes", null, null},
                {"Martes", null, null},
                {"Miercoles", null, null},
                {"Jueves", null, null},
                {"Viernes", null, null},
                {"Sabado", null, null},
                {"Domingo", null, null}
            },
            new String [] {
                "Día", "Mañana", "Tarde"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        if (tablaHorario.getColumnModel().getColumnCount() > 0) {
            tablaHorario.getColumnModel().getColumn(0).setResizable(false);
            tablaHorario.getColumnModel().getColumn(0).setPreferredWidth(80);
            tablaHorario.getColumnModel().getColumn(1).setResizable(false);
            tablaHorario.getColumnModel().getColumn(2).setResizable(false);
        }

        salario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Hasta");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);


        guardarRegistro.setText("Guardar");
        guardarRegistro.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarRegistroActionPerformed(evt);
            }
        });

        cancelarRegistro.setText("Cancelar");
        cancelarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inicioContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(guardarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inicioContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(finContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))

        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoActionPerformed

    private void guardarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarRegistroActionPerformed
       String nombrePersonal = nombre.getText().trim();
        String especialidadSeleccionada = especialidad.getSelectedItem().toString();
        String telefonoPersonal = telefono.getText().trim();
        String salarioTexto = salario.getText().replace(",", "").trim();
        double salario = 0;

        if (!salarioTexto.isEmpty()) {
            try {
                salario = Double.parseDouble(salarioTexto);
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "El salario debe ser un número válido.");
                return;
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "El salario no puede estar vacío.");
            return;
        }

        String fechaInicioStr = inicioContrato.getText().trim().replace("/", "-");
        String fechaFinStr = finContrato.getText().trim().replace("/", "-");

        java.sql.Date sqlFechaInicio = null;
        java.sql.Date sqlFechaFin = null;

        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
            inputFormat.setLenient(false);

            if (fechaInicioStr.isEmpty() || fechaFinStr.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ambas fechas deben estar llenas.");
                return;
            }

            Date fechaInicio = inputFormat.parse(fechaInicioStr);
            Date fechaFin = inputFormat.parse(fechaFinStr);

            if (fechaInicio.after(fechaFin)) {
                javax.swing.JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser posterior a la fecha de fin.");
                return;
            }

            sqlFechaInicio = new java.sql.Date(fechaInicio.getTime());
            sqlFechaFin = new java.sql.Date(fechaFin.getTime());


        } catch (ParseException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Las fechas deben tener el formato correcto (dd-MM-yyyy).");
            return;
        }

        List<String[]> horariosSeleccionados = new ArrayList<>();
            for (int i = 0; i < tablaHorario.getRowCount(); i++) {
                String diaSemana = (String) tablaHorario.getValueAt(i, 0);
                Boolean manana = (Boolean) tablaHorario.getValueAt(i, 1);
                Boolean tarde = (Boolean) tablaHorario.getValueAt(i, 2);

                if (manana != null && manana) {
                    horariosSeleccionados.add(new String[]{diaSemana, "Mañana"});
                }
                if (tarde != null && tarde) {
                    horariosSeleccionados.add(new String[]{diaSemana, "Tarde"});
                }
            }

            if (horariosSeleccionados.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Debes seleccionar al menos un turno para un día.");
                return;
            }
     
        Personal personal = new Personal(nombrePersonal, especialidadSeleccionada, telefonoPersonal, sqlFechaInicio, sqlFechaFin, salario);

        // Guardar el personal en la base de datos
        boolean exito = personal.registrarPersonal(horariosSeleccionados);
        if (exito) {
            javax.swing.JOptionPane.showMessageDialog(this, "El personal ha sido registrado exitosamente.");
            this.dispose();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Hubo un error al registrar el personal.");
        }
    }//GEN-LAST:event_guardarRegistroActionPerformed


    private void cancelarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarRegistroActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarRegistroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarRegistro;
    private javax.swing.JComboBox<String> especialidad;
    private raven.datetime.component.date.DatePicker fecha;
    private javax.swing.JFormattedTextField finContrato;
    private javax.swing.JButton guardarRegistro;
    private javax.swing.JFormattedTextField inicioContrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombre;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JFormattedTextField salario;
    private javax.swing.JTable tablaHorario;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
