package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
    
    public Administrador(){
        super();
    }
    
    public boolean registrar() {
        boolean exito = false;
        Connection conexion = Conexion.conectar(); 
        try {
            String sqlUsuario = "INSERT INTO Usuario (nombre, apellido, telefono, tipoUsuario, contrasena) " +
                                "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstUsuario = conexion.prepareStatement(sqlUsuario, PreparedStatement.RETURN_GENERATED_KEYS);
            pstUsuario.setString(1, getNombre());
            pstUsuario.setString(2, getApellido());
            pstUsuario.setString(3, getTelefono());
            pstUsuario.setString(4, "administrador");
            pstUsuario.setString(5, getContrasena());

            int filasUsuario = pstUsuario.executeUpdate();
            if (filasUsuario > 0) {
                ResultSet rs = pstUsuario.getGeneratedKeys();
                if (rs.next()) {
                    int idUsuarioGenerado = rs.getInt(1);
                    setIdUsuario(idUsuarioGenerado);

                    String sqlAdmin = "INSERT INTO Administrador (Usuario_idUsuario, email, salario) VALUES (?, ?, ?)";
                    PreparedStatement pstAdmin = conexion.prepareStatement(sqlAdmin);
                    pstAdmin.setInt(1, idUsuarioGenerado);
                    pstAdmin.setString(2, email);
                    pstAdmin.setDouble(3, salario);

                    int filasAdmin = pstAdmin.executeUpdate();
                    exito = filasAdmin > 0;
                    pstAdmin.close();
                }
                rs.close();
            }
            pstUsuario.close();
        } catch (SQLException e) {
            System.err.println("Error al registrar el administrador: " + e.getMessage());
        }

        return exito;
    }

    @Override
    public String toString() {
        return super.toString()+
            ", email='" + email + '\'' +
            ", salario=" + salario;
    }
    
    public static List<Administrador> obtenerAdministradores() {
        List<Administrador> administradores = new ArrayList<>();
        Connection conexion = Conexion.conectar();

        try {
            String sql = "SELECT u.nombre, u.apellido, u.telefono, a.email, a.salario " +
                         "FROM Usuario u " +
                         "JOIN Administrador a ON u.idUsuario = a.Usuario_idUsuario";
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // Recorrer los resultados y agregar a la lista
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                double salario = rs.getDouble("salario");

                Administrador admin = new Administrador();
                admin.setNombre(nombre);
                admin.setApellido(apellido);
                admin.setTelefono(telefono);
                admin.setEmail(email);
                admin.setSalario(salario);

                administradores.add(admin);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener administradores: " + e.getMessage());
        }

        return administradores;
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

    public boolean actualizarSalario(double nuevoSalario) {
        boolean actualizado = false;
        Connection conexion = Conexion.conectar();

        try {
            String sql = "UPDATE Administrador SET salario = ? WHERE Usuario_idUsuario = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setDouble(1, nuevoSalario);
            pst.setInt(2, this.getIdUsuario());

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                this.salario = nuevoSalario;
                actualizado = true;
            }
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el salario del administrador: " + e.getMessage());
        }

        return actualizado;
    }

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
