package Vista;

import Modelo.Cita;
import Modelo.Conexion;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class AgendarCita extends JFrame {

    private JTextField txtNombre;
    private JTextField txtNombreMascota;
    private JTextField txtFechaCita;
    private JComboBox<String> comboTipoCita;
    private JComboBox<String> comboTurno; 
    private JComboBox<String> comboPersonal; 
    private JTextField txtObservaciones;
        

public int obtenerIdCliente(String nombre) {
    int idCliente = -1;
    try {
        Connection conn = Conexion.conectar();
        String query = "SELECT idCliente FROM Cliente WHERE Usuario_idUsuario IN (SELECT idUsuario FROM Usuario WHERE CONCAT(nombre, ' ', apellido) = ?)";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, nombre);
        
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            idCliente = rs.getInt("idCliente");
        } else {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al obtener el ID del cliente: " + e.getMessage());
    }
    return idCliente;
}

public int obtenerIdMascota(String nombreMascota, int idCliente) {
    int idMascota = -1; 
    try {

        Connection conn = Conexion.conectar();

        System.out.println("Nombre de la mascota: " + nombreMascota);

        String query = "SELECT idMascota FROM Mascota WHERE nombreMascota = ? AND idCliente = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, nombreMascota);
        pst.setInt(2, idCliente);
        
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            idMascota = rs.getInt("idMascota");
        } else {
            JOptionPane.showMessageDialog(this, "Mascota no encontrada.");
        }
        
    } catch (SQLException e) {

        JOptionPane.showMessageDialog(this, "Error al obtener el ID de la mascota: " + e.getMessage());
        e.printStackTrace();
    }
    return idMascota;
}

    public AgendarCita() {
        setTitle("Agendar Cita");
        setSize(700, 650);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNombre = new JLabel("NOMBRE DEL CLIENTE");
        txtNombre = new JTextField(15);

        JLabel lblNombreMascota = new JLabel("NOMBRE DE LA MASCOTA");
        txtNombreMascota = new JTextField(15);

        JLabel lblFechaCita = new JLabel("FECHA DE CITA");
        txtFechaCita = new JTextField(15); 

        JLabel lblTipoCita = new JLabel("TIPO DE CITA");
        comboTipoCita = new JComboBox<>(new String[] {"Consulta", "Vacunación", "Chequeo", "Grooming"});
        
        JLabel lblTurno = new JLabel("TURNO");
        comboTurno = new JComboBox<>(new String[] {"Mañana", "Tarde"});
        comboTurno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarPersonalDisponible();
            }
        });

        JLabel lblPersonal = new JLabel("PERSONAL DISPONIBLE");
        comboPersonal = new JComboBox<>();

        JLabel lblObservaciones = new JLabel("OBSERVACIONES");
        txtObservaciones = new JTextField(15);

        JButton btnAgendar = new JButton("Agendar Cita");

        btnAgendar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agendarCita();
            }
        });

        setLayout(new java.awt.GridLayout(9, 2));
        add(lblNombre);
        add(txtNombre);
        add(lblNombreMascota);
        add(txtNombreMascota);
        add(lblFechaCita);
        add(txtFechaCita);
        add(lblTipoCita);
        add(comboTipoCita);
        add(lblTurno); 
        add(comboTurno);
        add(lblPersonal); 
        add(comboPersonal);
        add(lblObservaciones);
        add(txtObservaciones);
        add(new JLabel());
        add(btnAgendar);
    }

     public void agendarCita() {
        try {
  
            String nombre = txtNombre.getText();
            String nombreMascota = txtNombreMascota.getText();
            String fechaStr = txtFechaCita.getText();
            LocalDate fechaCita = LocalDate.parse(fechaStr);
            String tipoCita = (String) comboTipoCita.getSelectedItem();
            String observaciones = txtObservaciones.getText();

            int idCliente = obtenerIdCliente(nombre);
            int idMascota = obtenerIdMascota(nombreMascota, idCliente);

            if (idCliente == -1 || idMascota == -1) {
                JOptionPane.showMessageDialog(this, "No se encontró el cliente o la mascota en la base de datos.");
                return;
            }

            int idPersonal = obtenerIdPersonal((String) comboPersonal.getSelectedItem());
            if (idPersonal == -1) {
                JOptionPane.showMessageDialog(this, "No se encontró el personal seleccionado.");
                return;
            }
            String estado = "Reservada";

            Cita cita = new Cita(0, fechaCita, idMascota, idPersonal, tipoCita, observaciones, estado, idCliente);

            cita.guardarCita();
            
            JOptionPane.showMessageDialog(this, "La cita fue agendada exitosamente.");
            actualizarDisponibilidadPersonal(idPersonal, false);
            this.dispose(); 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agendar la cita: " + e.getMessage());
        }
    }
     
    private void cargarPersonalDisponible() {
        String turnoSeleccionado = (String) comboTurno.getSelectedItem();
        
        try (Connection conn = Conexion.conectar()) {
            String query = "SELECT idPersonal, nombrePersonal FROM Personal WHERE disponible=1 "
                    + "AND idPersonal IN (SELECT Personal_idPersonal FROM HorarioPersonal WHERE turno=?)";
            
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, turnoSeleccionado);
            
            ResultSet rs = pst.executeQuery();
            
            comboPersonal.removeAllItems();
            
            while (rs.next()) {
                int idPersonal = rs.getInt("idPersonal");
                String nombrePersonal = rs.getString("nombrePersonal");
                comboPersonal.addItem(idPersonal + " - " + nombrePersonal);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el personal disponible: " + e.getMessage());
        }
    }
    
    private int obtenerIdPersonal(String seleccionado){
       if(seleccionado==null||seleccionado.isEmpty()){
          return -1;
       }
       return Integer.parseInt(seleccionado.split(" - ")[0]);
   }

   private void actualizarDisponibilidadPersonal(int idPersonal ,boolean disponible){
      try(Connection conn=Conexion.conectar()){
         String query="UPDATE Personal SET disponible=? WHERE idPersonal=?";
         PreparedStatement pst=conn.prepareStatement(query);
         pst.setBoolean(1 ,disponible);
         pst.setInt(2 ,idPersonal);
         pst.executeUpdate();
      }catch(SQLException e){
         JOptionPane.showMessageDialog(this ,"Error al actualizar disponibilidad del personal: "+e.getMessage());
      }
   }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NOMBRE DEL CLIENTE");

        jLabel2.setText("FECHA DE CITA ");

        jLabel4.setText("TIPO DE CITA ");

        jLabel5.setText("NOMBRE DE LA MASCOTA");

        jLabel6.setText("OBSERVACIONES ");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jTextField4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear y mostrar la ventana de Agendar Cita
        AgendarCita ventana = new AgendarCita();
        ventana.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

    public void ssetLayout(GridLayout gridLayout) {
    super.setLayout(gridLayout);  // Llama al setLayout de la clase base (por ejemplo, JFrame o JPanel)
} // Esto aplica un GridLayout de 2x2 a tu JFrame

}
