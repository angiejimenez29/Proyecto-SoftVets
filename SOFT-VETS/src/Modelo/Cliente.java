package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Cliente extends Usuario{
    private int idCliente;;
    private String email;
    private String fechaRegistro;

    public Cliente(int idUsuario, String nombre, String apellido, String telefono, String tipoUsuario, String usuario, String contrasena, String email, String fechaRegistro) {
        super(idUsuario, nombre, apellido, telefono, tipoUsuario, usuario, contrasena);
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }
    
    public Cliente() {
        super();
    }

    public boolean registrarCliente() {
        boolean exito = false;
        Connection conexion = Conexion.conectar();
        try {
            String fechaRegistro = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            
            String sqlUsuario = "INSERT INTO Usuario (nombre, apellido, telefono, tipoUsuario, contrasena) " +
                                "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstUsuario = conexion.prepareStatement(sqlUsuario, PreparedStatement.RETURN_GENERATED_KEYS);
            pstUsuario.setString(1, getNombre());
            pstUsuario.setString(2, getApellido());
            pstUsuario.setString(3, getTelefono());
            pstUsuario.setString(4, "cliente");
            pstUsuario.setString(5, getTelefono());

            int filasUsuario = pstUsuario.executeUpdate();
            if (filasUsuario > 0) {
                ResultSet rs = pstUsuario.getGeneratedKeys();
                if (rs.next()) {
                    int idUsuarioGenerado = rs.getInt(1);
                    setIdUsuario(idUsuarioGenerado);

                    String sqlCliente = "INSERT INTO Cliente (Usuario_idUsuario, email, fechaRegistro) VALUES (?, ?, ?)";
                    PreparedStatement pstCliente = conexion.prepareStatement(sqlCliente);
                    pstCliente.setInt(1, idUsuarioGenerado);
                    pstCliente.setString(2, email);
                    pstCliente.setString(3, fechaRegistro);

                    int filasCliente = pstCliente.executeUpdate();
                    exito = filasCliente > 0;
                    pstCliente.close();
                }
                rs.close();
            }
            pstUsuario.close();
        } catch (SQLException e) {
            System.err.println("Error al registrar el cliente: " + e.getMessage());
        }
        return exito;
    }
    
    @Override
    public String toString() {
        return super.toString()+
            ", email='" + email;
    }

    public static List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        Connection conexion = Conexion.conectar();
        try {
            String sql = """
                            SELECT c.idCliente, u.idUsuario, u.nombre, u.apellido, u.telefono, 
                                   c.email, c.fechaRegistro 
                            FROM Cliente c 
                            JOIN Usuario u ON c.Usuario_idUsuario = u.idUsuario
                        """;
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setIdUsuario(rs.getInt("idUsuario"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setFechaRegistro(rs.getString("fechaRegistro"));
                clientes.add(cliente);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener clientes: " + e.getMessage());
        }

        return clientes;
    }

    public boolean actualizarEmail(String nuevoEmail) {
        boolean actualizado = false;
        Connection conexion = Conexion.conectar();
        try {
            String sql = "UPDATE Cliente SET email = ? WHERE Usuario_idUsuario = ?";
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
            System.err.println("Error al actualizar el email del cliente: " + e.getMessage());
        }
        return actualizado;
    }
    public boolean actualizarCliente(String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevoEmail, int idUsuario) {
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

            int filasAfectadasUsuario = pstUsuario.executeUpdate();


            String sqlCliente = "UPDATE Cliente SET email = ? WHERE Usuario_idUsuario = ?";
            PreparedStatement pstCliente = conexion.prepareStatement(sqlCliente);
            pstCliente.setString(1, nuevoEmail); 
            pstCliente.setInt(2, idUsuario); 

            int filasAfectadasCliente = pstCliente.executeUpdate();


            if (filasAfectadasUsuario > 0 && filasAfectadasCliente > 0) {
                conexion.commit();
                actualizado = true;
            } else {
                conexion.rollback();
            }

            pstUsuario.close();
            pstCliente.close();

        } catch (SQLException e) {
            System.err.println("Error al actualizar los datos del cliente y usuario: " + e.getMessage());
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

    public boolean eliminarCliente(int idUsuario) {
        boolean eliminado = false;
        Connection conexion = Conexion.conectar();
        try {
            String sqlCliente = "DELETE FROM Cliente WHERE Usuario_idUsuario = ?";
            PreparedStatement pstCliente = conexion.prepareStatement(sqlCliente);
            pstCliente.setInt(1, idUsuario);

            int filasAfectadas = pstCliente.executeUpdate();
            if (filasAfectadas > 0) {
                String sqlUsuario = "DELETE FROM Usuario WHERE idUsuario = ?";
                PreparedStatement pstUsuario = conexion.prepareStatement(sqlUsuario);
                pstUsuario.setInt(1, idUsuario);
                pstUsuario.executeUpdate();

                eliminado = true;
            }
            pstCliente.close();
        } catch (SQLException e) {
            System.err.println("Error al eliminar el cliente: " + e.getMessage());
        }
        return eliminado;
    }
    
    public static int obtenerIdClientePorNombreApellido(String nombre, String apellido) {
        int idCliente = -1;
        Connection conexion = Conexion.conectar();
        try {
            String sql = """
                         SELECT c.idCliente 
                         FROM Cliente c 
                         JOIN Usuario u ON c.Usuario_idUsuario = u.idUsuario 
                         WHERE u.nombre = ? AND u.apellido = ?
                         """;
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener el ID del cliente: " + e.getMessage());
        }
        return idCliente;
    }
    
    public static Cliente obtenerClientePorId(int idCliente) {
        Cliente cliente = null;
        Connection conexion = Conexion.conectar();
        try {
            String sql = """
                         SELECT u.idUsuario, u.nombre, u.apellido, u.telefono, 
                                c.email, c.fechaRegistro
                         FROM Cliente c
                         JOIN Usuario u ON c.Usuario_idUsuario = u.idUsuario
                         WHERE c.idCliente = ?
                         """;
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idCliente);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(idCliente);
                cliente.setIdUsuario(rs.getInt("idUsuario"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setFechaRegistro(rs.getString("fechaRegistro"));
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener el cliente por ID: " + e.getMessage());
        }
        return cliente;
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

    public Object getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
