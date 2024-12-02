package Controlador;

import Modelo.Conexion;
import Modelo.Personal;
import Vista.gestionPersonalAdmin;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;
import java.sql.*;
import java.util.ArrayList;

public class ControladorPersonal {
    private gestionPersonalAdmin gestionPersonal;
    private Personal personal;
    
    public ControladorPersonal() {
        this.personal = personal;
        this.gestionPersonal = gestionPersonal;
    }
    
    public void mostrarPersonal(JTable tablaPersonal) {
        // Obtener la lista de personal desde la base de datos
        List<Personal> personalList = Personal.obtenerPersonal();

        // Crear el modelo de tabla con las columnas deseadas
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][] {}, // Inicialmente sin filas
            new String[] {"IDP", "NOMBRE", "ESPECIALIDAD", "TELEFONO", "CONTRATO", "SALARIO"}
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false; // No permitir la edición de celdas
            }
        };

        // Agregar los registros a la tabla
        for (Personal p : personalList) {
            Object[] fila = new Object[] {
                p.getIdPersonal(),
                p.getNombre(),
                p.getEspecialidad(),
                p.getTelefono(),
                p.getFechaInicio(),
                p.getSalario()
            };
            modelo.addRow(fila);
        }

        tablaPersonal.setModel(modelo);
        tablaPersonal.revalidate();
        tablaPersonal.repaint();


        tablaPersonal.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaPersonal.getColumnModel().getColumn(1).setPreferredWidth(150);
        tablaPersonal.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaPersonal.getColumnModel().getColumn(3).setPreferredWidth(100);
        tablaPersonal.getColumnModel().getColumn(4).setPreferredWidth(150);
        tablaPersonal.getColumnModel().getColumn(5).setPreferredWidth(100);

        DefaultTableCellRenderer centroRenderer = new DefaultTableCellRenderer();
        centroRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < tablaPersonal.getColumnCount(); i++) {
            tablaPersonal.getColumnModel().getColumn(i).setCellRenderer(centroRenderer);
        }
    }
    
    public void buscarPersonal(String nombreBuscar, JTable tablaPersonal) {
        List<Personal> personalFiltrado = Personal.obtenerPersonal().stream()
            .filter(p -> p.getNombre().toLowerCase().contains(nombreBuscar.toLowerCase()))
            .collect(Collectors.toList());

        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][] {},
            new String[] {"IDP", "NOMBRE", "ESPECIALIDAD", "TELEFONO", "CONTRATO", "SALARIO"}
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        for (Personal p : personalFiltrado) {
            Object[] fila = new Object[] {
                p.getIdPersonal(),
                p.getNombre(),
                p.getEspecialidad(),
                p.getTelefono(),
                p.getFechaInicio(),
                p.getSalario()
            };
            modelo.addRow(fila);
        }

        tablaPersonal.setModel(modelo);

        // Ocultar las columnas "IDP" y "Nombre"
        tablaPersonal.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaPersonal.getColumnModel().getColumn(0).setMinWidth(0);
        tablaPersonal.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaPersonal.getColumnModel().getColumn(1).setMinWidth(0);

        tablaPersonal.getColumnModel().getColumn(2).setPreferredWidth(150); // Especialidad
        tablaPersonal.getColumnModel().getColumn(3).setPreferredWidth(100); // Teléfono
        tablaPersonal.getColumnModel().getColumn(4).setPreferredWidth(100); // Contrato
        tablaPersonal.getColumnModel().getColumn(5).setPreferredWidth(100); // Salario

        DefaultTableCellRenderer centroRenderer = new DefaultTableCellRenderer();
        centroRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < tablaPersonal.getColumnCount(); i++) {
            tablaPersonal.getColumnModel().getColumn(i).setCellRenderer(centroRenderer);
        }
    }

    public void eliminarPersonal(int idPersonal) {
        boolean exito = personal.eliminarPersonal(idPersonal);
        if (exito) {
            JOptionPane.showMessageDialog(null, "Personal eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar al personal.");
        }
    }
    

    public boolean editarPersonal(int idPersonal, String nuevoNombre, String nuevoTelefono, String nuevaEspecialidad, 
            double nuevoSalario, Date nuevaFechaContratacion, Date nuevaFechaFinContrato, List<String[]> horariosSeleccionados) {
        boolean actualizado = false;
        Connection conexion = Conexion.conectar();
        PreparedStatement pstPersonal = null;
        PreparedStatement pstHorario = null;
        ResultSet rs = null;

        try {
            // Iniciar transacción
            conexion.setAutoCommit(false);

            // Convertir java.util.Date a java.sql.Date
            java.sql.Date sqlFechaContratacion = new java.sql.Date(nuevaFechaContratacion.getTime());
            java.sql.Date sqlFechaFinContrato = new java.sql.Date(nuevaFechaFinContrato.getTime());

            // 1. Actualizar datos en la tabla Personal
            String sqlPersonal = "UPDATE Personal SET nombrePersonal = ?, telefono = ?, especialidad = ?, salario = ?, fechaContratacion = ?, fechaFinContrato = ? WHERE idPersonal = ?";
            pstPersonal = conexion.prepareStatement(sqlPersonal);
            pstPersonal.setString(1, nuevoNombre);
            pstPersonal.setString(2, nuevoTelefono);
            pstPersonal.setString(3, nuevaEspecialidad);
            pstPersonal.setDouble(4, nuevoSalario);
            pstPersonal.setDate(5, sqlFechaContratacion);  // Utilizar sqlDate
            pstPersonal.setDate(6, sqlFechaFinContrato);   // Utilizar sqlDate
            pstPersonal.setInt(7, idPersonal);

            int filasAfectadasPersonal = pstPersonal.executeUpdate();

            // Si se actualizó el personal, actualizamos los horarios asociados
            if (filasAfectadasPersonal > 0) {
                // Eliminar horarios anteriores
                String sqlEliminarHorarios = "DELETE FROM HorarioPersonal WHERE Personal_idPersonal = ?";
                PreparedStatement pstEliminarHorarios = conexion.prepareStatement(sqlEliminarHorarios);
                pstEliminarHorarios.setInt(1, idPersonal);
                pstEliminarHorarios.executeUpdate();

                // Insertar nuevos horarios
                String sqlHorario = "INSERT INTO HorarioPersonal (Personal_idPersonal, diaSemana, turno, horaInicio, horaSalida) VALUES (?, ?, ?, ?, ?)";
                pstHorario = conexion.prepareStatement(sqlHorario);

                for (String[] horario : horariosSeleccionados) {
                    String diaSemana = horario[0];
                    String turno = horario[1];
                    String horaInicio;
                    String horaSalida;

                    // Asignar horas según el turno
                    if ("Mañana".equalsIgnoreCase(turno)) {
                        horaInicio = "07:00:00";
                        horaSalida = "13:00:00";
                    } else if ("Tarde".equalsIgnoreCase(turno)) {
                        horaInicio = "13:00:00";
                        horaSalida = "19:00:00";
                    } else {
                        throw new SQLException("Turno inválido: " + turno);
                    }

                    pstHorario.setInt(1, idPersonal);
                    pstHorario.setString(2, diaSemana);
                    pstHorario.setString(3, turno);
                    pstHorario.setString(4, horaInicio);
                    pstHorario.setString(5, horaSalida);
                    pstHorario.addBatch(); // Añadir al batch
                }

                // Ejecutar el batch de horarios
                pstHorario.executeBatch();
                actualizado = true;
            }

            // Confirmar la transacción
            conexion.commit();

        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback(); // Revertir la transacción en caso de error
                }
            } catch (SQLException rollbackEx) {
                System.err.println("Error al revertir la transacción: " + rollbackEx.getMessage());
            }
            System.err.println("Error al actualizar el personal: " + e.getMessage());
        } finally {
            // Cerrar recursos en orden inverso
            try {
                if (rs != null) rs.close();
                if (pstHorario != null) pstHorario.close();
                if (pstPersonal != null) pstPersonal.close();
                if (conexion != null) conexion.close();
            } catch (SQLException closeEx) {
                System.err.println("Error al cerrar recursos: " + closeEx.getMessage());
            }
        }

        return actualizado;
    }
    
    public static Personal obtenerPersonalPorId(int idPersonal) {
        Connection conexion = Conexion.conectar();
        PreparedStatement pstPersonal = null;
        PreparedStatement pstHorario = null;
        ResultSet rsPersonal = null;
        ResultSet rsHorario = null;
        Personal personal = null;

        try {
            // Obtener los datos del Personal
            String sqlPersonal = "SELECT * FROM Personal WHERE idPersonal = ?";
            pstPersonal = conexion.prepareStatement(sqlPersonal);
            pstPersonal.setInt(1, idPersonal);
            rsPersonal = pstPersonal.executeQuery();

            if (rsPersonal.next()) {
                personal = new Personal(
                    rsPersonal.getInt("idPersonal"),
                    rsPersonal.getString("nombre"),
                    rsPersonal.getString("especialidad"),
                    rsPersonal.getString("telefono"),
                    rsPersonal.getDate("fechaContratacion"),
                    rsPersonal.getDate("fechaFinContrato"),
                    rsPersonal.getDouble("salario"),
                    rsPersonal.getBoolean("disponible")
                );

                // Ahora obtenemos los horarios asociados
                String sqlHorario = "SELECT * FROM HorarioPersonal WHERE Personal_idPersonal = ?";
                pstHorario = conexion.prepareStatement(sqlHorario);
                pstHorario.setInt(1, idPersonal);
                rsHorario = pstHorario.executeQuery();

                // Llenar los horarios en el personal
                List<String[]> horarios = new ArrayList<>();
                while (rsHorario.next()) {
                    String diaSemana = rsHorario.getString("diaSemana");
                    String turno = rsHorario.getString("turno");
                    String horaInicio = rsHorario.getString("horaInicio");
                    String horaSalida = rsHorario.getString("horaSalida");

                    // Agregar los horarios al listado
                    horarios.add(new String[]{diaSemana, turno, horaInicio, horaSalida});
                }

                // Asignar los horarios al objeto personal
                // Aquí puedes usar un método de la clase Personal para guardar los horarios si es necesario

            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el personal con horarios por ID: " + e.getMessage());
        } finally {
            try {
                if (rsPersonal != null) rsPersonal.close();
                if (rsHorario != null) rsHorario.close();
                if (pstPersonal != null) pstPersonal.close();
                if (pstHorario != null) pstHorario.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return personal;
    }
}
