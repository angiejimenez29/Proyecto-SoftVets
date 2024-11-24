package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente {

    private int idCliente;
    private int Usuario_idUsuario;
    private String email;
    private String fechaRegistro;
    private Connection conexion;

    public Cliente() {
        
    }

    // Método para registrar un nuevo cliente
    public boolean registrarCliente(int idUsuario, String email) {
        try {
            String sql = "INSERT INTO Cliente (Usuario_idUsuario, email) VALUES (?, ?)";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            pst.setString(2, email);

            int filasAfectadas = pst.executeUpdate();
            pst.close();
            return filasAfectadas > 0; // Retorna true si se insertó correctamente
        } catch (SQLException e) {
            System.err.println("Error al registrar el cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar datos del cliente
    public boolean actualizarCliente(int idCliente, String nuevoEmail) {
        try {
            String sql = "UPDATE Cliente SET email = ? WHERE idCliente = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, nuevoEmail);
            pst.setInt(2, idCliente);

            int filasAfectadas = pst.executeUpdate();
            pst.close();
            return filasAfectadas > 0; // Retorna true si se actualizó correctamente
        } catch (SQLException e) {
            System.err.println("Error al actualizar el cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un cliente
    public boolean eliminarCliente(int idCliente) {
        try {
            String sql = "DELETE FROM Cliente WHERE idCliente = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idCliente);

            int filasAfectadas = pst.executeUpdate();
            pst.close();
            return filasAfectadas > 0; // Retorna true si se eliminó correctamente
        } catch (SQLException e) {
            System.err.println("Error al eliminar el cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para cambiar la contraseña del cliente (después de iniciar sesión)
    public boolean cambiarContrasena(int idUsuario, String nuevaContrasena) {
        try {
            String sql = "UPDATE Usuario SET contrasena = ? WHERE idUsuario = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, nuevaContrasena);
            pst.setInt(2, idUsuario);

            int filasAfectadas = pst.executeUpdate();
            pst.close();
            return filasAfectadas > 0; // Retorna true si se actualizó la contraseña
        } catch (SQLException e) {
            System.err.println("Error al cambiar la contraseña: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener los datos del cliente
    public Cliente obtenerCliente(int idCliente) {
        Cliente cliente = null;
        try {
            String sql = "SELECT * FROM Cliente WHERE idCliente = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idCliente);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.idCliente = rs.getInt("idCliente");
                cliente.Usuario_idUsuario = rs.getInt("Usuario_idUsuario");
                cliente.email = rs.getString("email");
                cliente.fechaRegistro = rs.getString("fechaRegistro");
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener el cliente: " + e.getMessage());
        }
        return cliente; // Retorna el cliente encontrado o null si no existe
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getUsuario_idUsuario() {
        return Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(int Usuario_idUsuario) {
        this.Usuario_idUsuario = Usuario_idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
