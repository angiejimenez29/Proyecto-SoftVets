package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Administrador extends Usuario {
    private String email;
    private double salario;

    public Administrador(int idUsuario, String nombre, String apellido, String telefono, 
                         String tipoUsuario, String usuario, String contrasena, 
                         String email, double salario) {
        super(idUsuario, nombre, apellido, telefono, tipoUsuario, usuario, contrasena);
        this.email = email;
        this.salario = salario;
    }

    public boolean actualizarEmail(String nuevoEmail) {
        boolean actualizado = false;
        Connection conexion = Conexion.conectar();

        try {
            String sql = "UPDATE Administrador SET email = ? WHERE Usuario_idUsuario = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, nuevoEmail);
            pst.setInt(2, this.getIdUsuario());

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                this.email = nuevoEmail; 
                actualizado = true;
            }
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el email del administrador: " + e.getMessage());
        }

        return actualizado;
    }

    // Método para actualizar el salario
    public boolean actualizarSalario(double nuevoSalario) {
        boolean actualizado = false;
        Connection conexion = Conexion.conectar(); // Obtiene la conexión

        try {
            String sql = "UPDATE Administrador SET salario = ? WHERE Usuario_idUsuario = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setDouble(1, nuevoSalario);
            pst.setInt(2, this.getIdUsuario());

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                this.salario = nuevoSalario;  // Actualiza el salario en el objeto
                actualizado = true;
            }
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el salario del administrador: " + e.getMessage());
        }

        return actualizado;
    }

    // Métodos getter y setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
