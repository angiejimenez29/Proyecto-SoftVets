package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;


public class Administrador extends Usuario {
    private int idAdministrador;
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
    
    public boolean registrarAdmin() {
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
            String sql = """
                            SELECT a.idAdministrador, u.idUsuario, u.nombre, u.apellido, 
                            u.telefono, a.email, a.salario
                            FROM Administrador a
                            JOIN Usuario u ON a.Usuario_idUsuario = u.idUsuario
                        """;
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
               Administrador admin = new Administrador();
               admin.setIdAdministrador(rs.getInt("idAdministrador"));
               admin.setIdUsuario(rs.getInt("idUsuario"));            
               admin.setNombre(rs.getString("nombre"));
               admin.setApellido(rs.getString("apellido"));
               admin.setTelefono(rs.getString("telefono"));
               admin.setEmail(rs.getString("email"));
               admin.setSalario(rs.getDouble("salario"));
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
            System.out.println("SQL: " + sql);
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
    
    public boolean actualizarAdmin(String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevoEmail, double nuevoSalario, int idUsuario) {
        boolean actualizado = false;
        Connection conexion = Conexion.conectar();

        try {
            conexion.setAutoCommit(false);
            String sqlUsuario = "UPDATE Usuario SET nombre = ?, apellido = ?, telefono = ? WHERE idUsuario = ?";
            PreparedStatement pstUsuario = conexion.prepareStatement(sqlUsuario);
            pstUsuario.setString(1, nuevoNombre);
            pstUsuario.setString(2, nuevoApellido);
            pstUsuario.setString(3, nuevoTelefono);
            pstUsuario.setInt(4, idUsuario);

            String sqlAdministrador = "UPDATE Administrador SET email = ?, salario = ? WHERE Usuario_idUsuario = ?";
            PreparedStatement pstAdministrador = conexion.prepareStatement(sqlAdministrador);
            pstAdministrador.setString(1, nuevoEmail);
            pstAdministrador.setDouble(2, nuevoSalario);
            pstAdministrador.setInt(3, idUsuario);

            int filasAfectadasUsuario = pstUsuario.executeUpdate();
            int filasAfectadasAdministrador = pstAdministrador.executeUpdate();

            if (filasAfectadasUsuario > 0 && filasAfectadasAdministrador > 0) {
                conexion.commit();
                actualizado = true;
            } else {
                conexion.rollback();
            }
            pstUsuario.close();
            pstAdministrador.close();
        } catch (SQLException e) {
            System.err.println("Error al actualizar los datos del administrador y usuario: " + e.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                System.err.println("Error al revertir los cambios: " + ex.getMessage());
            }
        } finally {
            try {
                conexion.setAutoCommit(true);
            } catch (SQLException e) {
                System.err.println("Error al restaurar el autocommit: " + e.getMessage());
            }
        }

        return actualizado;
    }
        
    public boolean eliminarAdmin(int idUsuario) {
        boolean eliminado = false;
        Connection conexion = Conexion.conectar();

        try {
            String sqlAdministrador = "DELETE FROM Administrador WHERE Usuario_idUsuario = ?";
            PreparedStatement pstAdministrador = conexion.prepareStatement(sqlAdministrador);
            pstAdministrador.setInt(1, idUsuario);

            int filasAfectadas = pstAdministrador.executeUpdate();
            if (filasAfectadas > 0) {
                String sqlUsuario = "DELETE FROM Usuario WHERE idUsuario = ?";
                PreparedStatement pstUsuario = conexion.prepareStatement(sqlUsuario);
                pstUsuario.setInt(1, idUsuario);
                pstUsuario.executeUpdate();

                eliminado = true;
            }
            pstAdministrador.close();
        } catch (SQLException e) {
            System.err.println("Error al eliminar el administrador: " + e.getMessage());
        }
        return eliminado;
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

    public int getIdAdministrador() {
        return idAdministrador;
    }
    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}
