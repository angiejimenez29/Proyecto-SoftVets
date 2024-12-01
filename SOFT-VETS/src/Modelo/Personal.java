package Modelo;

import java.sql.*;
import java.sql.Connection;
import java.util.List;


public class Personal {

    private int idPersonal;
    private String nombre;
    private String especialidad;
    private String telefono;
    private Date fechaInicio;
    private Date fechaFin;
    private double salario;

    // Constructor
    public Personal(String nombre, String especialidad, String telefono, Date fechaInicio, Date fechaFin, double salario) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.salario = salario;
    }

    // Método para registrar personal con horarios
    public boolean registrarPersonal(List<String[]> horariosSeleccionados) {
        boolean exito = false;
        Connection conexion = Conexion.conectar();
        PreparedStatement pstPersonal = null;
        PreparedStatement pstHorario = null;
        ResultSet rs = null;

        try {
            conexion.setAutoCommit(false);

            // Insertar en la tabla Personal
            String sqlPersonal = "INSERT INTO Personal (nombrePersonal, telefono, especialidad, salario, fechaContratacion, fechaFinContrato, disponible) " +
                                 "VALUES (?, ?, ?, ?, ?, ?, 1)";
            pstPersonal = conexion.prepareStatement(sqlPersonal, PreparedStatement.RETURN_GENERATED_KEYS);
            pstPersonal.setString(1, getNombre());
            pstPersonal.setString(2, getTelefono());
            pstPersonal.setString(3, getEspecialidad());
            pstPersonal.setDouble(4, getSalario());
            pstPersonal.setDate(5, getFechaContratacion());
            pstPersonal.setDate(6, getFechaFinContrato());

            int filasPersonal = pstPersonal.executeUpdate();
            if (filasPersonal > 0) {
                rs = pstPersonal.getGeneratedKeys();
                if (rs.next()) {
                    int idPersonalGenerado = rs.getInt(1);

                    // Insertar horarios asociados al personal
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

                        pstHorario.setInt(1, idPersonalGenerado);
                        pstHorario.setString(2, diaSemana);
                        pstHorario.setString(3, turno);
                        pstHorario.setString(4, horaInicio);
                        pstHorario.setString(5, horaSalida);
                        pstHorario.addBatch(); // Añadir al batch
                    }

                    // Ejecutar el batch de horarios
                    pstHorario.executeBatch();
                }
            }

            // Confirmar la transacción
            conexion.commit();
            exito = true;

        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback(); // Revertir la transacción en caso de error
                }
            } catch (SQLException rollbackEx) {
                System.err.println("Error al revertir la transacción: " + rollbackEx.getMessage());
            }
            System.err.println("Error al registrar el personal: " + e.getMessage());
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

        return exito;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Date getFechaContratacion() {
        return fechaInicio;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaInicio = fechaContratacion;
    }

    public Date getFechaFinContrato() {
        return fechaFin;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFin = fechaFinContrato;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
