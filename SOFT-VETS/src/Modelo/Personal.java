package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class Personal {

    private int idPersonal;
    private String nombrePersonal;
    private String especialidad;
    private String telefono;
    private Date fechaInicio;
    private Date fechaFin;
    private double salario;
    private boolean disponible;

    public Personal(int idPersonal, String nombrePersonal, String especialidad, String telefono, Date fechaInicio, Date fechaFin, double salario, boolean disponible) {
        this.idPersonal = idPersonal;
        this.nombrePersonal = nombrePersonal;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.salario = salario;
        this.disponible = disponible;
    }

    public Personal(String nombrePersonal, String especialidad, String telefono, Date fechaInicio, Date fechaFin, double salario, boolean disponible) {
        this.nombrePersonal = nombrePersonal;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.salario = salario;
        this.disponible = disponible;
    }

    public boolean registrarPersonal(List<String[]> horariosSeleccionados) {
        boolean exito = false;
        Connection conexion = Conexion.conectar();
        PreparedStatement pstPersonal = null;
        PreparedStatement pstHorario = null;
        ResultSet rs = null;

        try {
            conexion.setAutoCommit(false);

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

                    String sqlHorario = "INSERT INTO HorarioPersonal (Personal_idPersonal, diaSemana, turno, horaInicio, horaSalida) VALUES (?, ?, ?, ?, ?)";
                    pstHorario = conexion.prepareStatement(sqlHorario);

                    for (String[] horario : horariosSeleccionados) {
                        String diaSemana = horario[0];
                        String turno = horario[1];
                        String horaInicio;
                        String horaSalida;

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
                        pstHorario.addBatch();
                    }

                    pstHorario.executeBatch();
                }
            }

            conexion.commit();
            exito = true;

        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException rollbackEx) {
                System.err.println("Error al revertir la transacción: " + rollbackEx.getMessage());
            }
            System.err.println("Error al registrar el personal: " + e.getMessage());
        } finally {
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
    
    public static List<Personal> obtenerPersonal() {
        List<Personal> listaPersonal = new ArrayList<>();
        Connection conexion = Conexion.conectar();
        String sql = "SELECT * FROM Personal";

        try (PreparedStatement pst = conexion.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idPersonal = rs.getInt("idPersonal");
                String nombrePersonal = rs.getString("nombrePersonal");
                String especialidad = rs.getString("especialidad");
                String telefono = rs.getString("telefono");
                Date fechaContratacion = rs.getDate("fechaContratacion");
                Date fechaFinContrato = rs.getDate("fechaFinContrato");
                double salario = rs.getDouble("salario");
                boolean disponible = rs.getBoolean("disponible");

                Personal personal = new Personal(
                    idPersonal, nombrePersonal, especialidad, telefono, 
                    fechaContratacion, fechaFinContrato, salario, disponible
                );
                listaPersonal.add(personal);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener la lista de personal: " + e.getMessage());
            e.printStackTrace();
        }

        return listaPersonal;
    }

    public static boolean eliminarPersonal(int idPersonal) {
        boolean eliminado = false;
        Connection conexion = Conexion.conectar();
        try {
            conexion.setAutoCommit(false); 

            String sqlEliminarHorarios = "DELETE FROM HorarioPersonal WHERE Personal_idPersonal = ?";
            PreparedStatement pstEliminarHorarios = conexion.prepareStatement(sqlEliminarHorarios);
            pstEliminarHorarios.setInt(1, idPersonal);
            int filasAfectadasHorarios = pstEliminarHorarios.executeUpdate();

            String sqlPersonal = "DELETE FROM Personal WHERE idPersonal = ?";
            PreparedStatement pstPersonal = conexion.prepareStatement(sqlPersonal);
            pstPersonal.setInt(1, idPersonal);
            int filasAfectadasPersonal = pstPersonal.executeUpdate();

            if (filasAfectadasHorarios > 0 && filasAfectadasPersonal > 0) {
                eliminado = true;
            }

            if (eliminado) {
                conexion.commit();
            } else {
                conexion.rollback();
            }

            pstEliminarHorarios.close();
            pstPersonal.close();
        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException rollbackEx) {
                System.err.println("Error al revertir la transacción: " + rollbackEx.getMessage());
            }
            System.err.println("Error al eliminar el personal: " + e.getMessage());
        } finally {
            try {
                if (conexion != null) conexion.close();
            } catch (SQLException closeEx) {
                System.err.println("Error al cerrar la conexión: " + closeEx.getMessage());
            }
        }
        return eliminado;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }
    
    public String getNombre() {
        return this.nombrePersonal;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public double getSalario() {
        return this.salario;
    }

    public Date getFechaContratacion() {
        return this.fechaInicio;
    }

    public Date getFechaFinContrato() {
        return this.fechaFin;
    }


    public void setNombre(String nombre) {
        this.nombrePersonal = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaInicio = fechaContratacion;
    }
    
    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFin = fechaFinContrato;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
