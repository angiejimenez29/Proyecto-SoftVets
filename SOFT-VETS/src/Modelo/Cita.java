package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Cita {
    private int idCita;
    private LocalDate fecha;
    private int idMascota;
    private int idPersonal;
    private String tipoCita;
    private String observaciones;
    private String estado;
    private int idCliente;

    private static Scanner scanner = new Scanner(System.in);

    // Constructor
    public Cita(int idCita, LocalDate fecha, int idMascota, int idPersonal, 
                String tipoCita, String observaciones, String estado, int idCliente) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.idMascota = idMascota;
        this.idPersonal = idPersonal;
        this.tipoCita = tipoCita;
        this.observaciones = observaciones;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    // Método para agendar una nueva cita
    public static void agendarCita() {
        System.out.print("Ingrese su ID (Cliente): ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        System.out.print("Ingrese el ID de la mascota: ");
        int idMascota = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        System.out.print("Ingrese el ID del especialista (Personal): ");
        int idPersonal = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        System.out.print("Ingrese la fecha de la cita (yyyy-MM-dd): ");
        String fechaStr = scanner.nextLine();
        LocalDate fechaCita = LocalDate.parse(fechaStr);

        System.out.print("Ingrese el tipo de cita (consulta, estética, etc.): ");
        String tipoCita = scanner.nextLine();

        System.out.print("Ingrese las observaciones de la cita: ");
        String observaciones = scanner.nextLine();

        System.out.print("Ingrese el estado de la cita (pendiente, realizada, cancelada): ");
        String estado = scanner.nextLine();

        // Crear una nueva instancia de Cita
        Cita cita = new Cita(0, fechaCita, idMascota, idPersonal, tipoCita, observaciones, estado, idCliente);

        // Guardar la cita en la base de datos
        cita.guardarCita();
    }

    // Método para guardar la cita en la base de datos
    public void guardarCita() {
        Connection conexion = Conexion.conectar();
        PreparedStatement pst = null;

        try {
            String sql = "INSERT INTO Cita (fecha, idMascota, idPersonal, tipoCita, observaciones, estado, idCliente) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";
            pst = conexion.prepareStatement(sql);
            pst.setDate(1, java.sql.Date.valueOf(this.fecha));  // Convertir LocalDate a java.sql.Date
            pst.setInt(2, this.idMascota);
            pst.setInt(3, this.idPersonal);
            pst.setString(4, this.tipoCita);
            pst.setString(5, this.observaciones);
            pst.setString(6, this.estado);
            pst.setInt(7, this.idCliente);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Cita generada exitosamente.");
            } else {
                System.out.println("Error al generar la cita.");
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar la cita: " + e.getMessage());
        }
    }

    // Método para modificar una cita existente
    public static void modificarCita() {
        System.out.print("Ingrese el ID de la cita a modificar: ");
        int idCita = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Obtener la cita existente de la base de datos
        Cita cita = obtenerCitaPorId(idCita);
        if (cita == null) {
            System.out.println("No se encontró una cita con ese ID.");
            return;
        }

        System.out.println("Cita encontrada: " + cita);

        System.out.print("Ingrese nueva fecha de la cita (yyyy-MM-dd) o presione Enter para no cambiarla: ");
        String nuevaFechaStr = scanner.nextLine();
        if (!nuevaFechaStr.isEmpty()) {
            cita.setFecha(LocalDate.parse(nuevaFechaStr));
        }

        System.out.print("Ingrese nuevo tipo de cita o presione Enter para no cambiarlo: ");
        String nuevoTipoCita = scanner.nextLine();
        if (!nuevoTipoCita.isEmpty()) {
            cita.setTipoCita(nuevoTipoCita);
        }

        System.out.print("Ingrese nuevas observaciones o presione Enter para no cambiarlas: ");
        String nuevasObservaciones = scanner.nextLine();
        if (!nuevasObservaciones.isEmpty()) {
            cita.setObservaciones(nuevasObservaciones);
        }

        System.out.print("Ingrese el nuevo estado de la cita (pendiente, realizada, cancelada): ");
        String nuevoEstado = scanner.nextLine();
        cita.setEstado(nuevoEstado);

        // Guardar los cambios en la base de datos
        cita.actualizarCita();
    }

    // Método para obtener una cita por ID desde la base de datos
    public static Cita obtenerCitaPorId(int idCita) {
        Connection conexion = Conexion.conectar();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Cita WHERE idCita = ?";
            pst = conexion.prepareStatement(sql);
            pst.setInt(1, idCita);
            rs = pst.executeQuery();

            if (rs.next()) {
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                int idMascota = rs.getInt("idMascota");
                int idPersonal = rs.getInt("idPersonal");
                String tipoCita = rs.getString("tipoCita");
                String observaciones = rs.getString("observaciones");
                String estado = rs.getString("estado");
                int idCliente = rs.getInt("idCliente");

                return new Cita(idCita, fecha, idMascota, idPersonal, tipoCita, observaciones, estado, idCliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la cita: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return null;
    }

    // Método para actualizar la cita en la base de datos
    public void actualizarCita() {
        Connection conexion = Conexion.conectar();
        PreparedStatement pst = null;

        try {
            String sql = "UPDATE Cita SET fecha = ?, tipoCita = ?, observaciones = ?, estado = ? WHERE idCita = ?";
            pst = conexion.prepareStatement(sql);
            pst.setDate(1, java.sql.Date.valueOf(this.fecha));
            pst.setString(2, this.tipoCita);
            pst.setString(3, this.observaciones);
            pst.setString(4, this.estado);
            pst.setInt(5, this.idCita);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Cita modificada exitosamente.");
            } else {
                System.out.println("Error al modificar la cita.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar la cita: " + e.getMessage());
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    // Método para cancelar una cita
    public static void cancelarCita() {
        System.out.print("Ingrese el ID de la cita a cancelar: ");
        int idCita = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Obtener la cita existente de la base de datos
        Cita cita = obtenerCitaPorId(idCita);
        if (cita == null) {
            System.out.println("No se encontró una cita con ese ID.");
            return;
        }

        System.out.println("Cita encontrada: " + cita);
        cita.setEstado("cancelada");

        // Guardar los cambios en la base de datos
        cita.actualizarCita();
    }

    @Override
    public String toString() {
        return "Cita{idCita=" + idCita + ", fecha=" + fecha + ", tipoCita='" + tipoCita + "', estado='" + estado + "'}";
    }

    // Métodos getter y setter
    // ... (Los mismos métodos getter y setter que antes)

    private void setFecha(LocalDate parse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setObservaciones(String nuevasObservaciones) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setEstado(String nuevoEstado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setTipoCita(String nuevoTipoCita) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
