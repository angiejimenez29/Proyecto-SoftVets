package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipoUsuario;
    private String usuario;
    private String contrasena;

    private static Usuario usuarioInstancia;

    public Usuario(int idUsuario, String nombre, String apellido, String telefono, 
                   String tipoUsuario, String usuario, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Usuario() {}

    public static Usuario getInstance() {
        if (usuarioInstancia == null) {
            usuarioInstancia = new Usuario();
        }
        return usuarioInstancia;
    }

    private boolean verificarConexion() {
        try {
            Connection conexion = Conexion.conectar();  // Obtener conexión desde la clase Conexion
            if (conexion == null || conexion.isClosed()) {
                System.out.println("No se pudo restablecer la conexión a la base de datos.");
                return false;
            }
            return true;  // La conexión está activa
        } catch (SQLException e) {
            System.out.println("Error al verificar la conexión: " + e.getMessage());
            return false;
        }
    }

    public Usuario iniciarSesion(String usuarioInput, String contrasenaInput) {
        Usuario usuarioAutenticado = null;
        Connection conexion = Conexion.conectar();  // Conexión compartida
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            if (!verificarConexion()) {
                return null;  // No se pudo establecer la conexión
            }

            String sql = "SELECT * FROM Usuario WHERE usuario = ? AND contrasena = ?";
            pst = conexion.prepareStatement(sql);
            pst.setString(1, usuarioInput);
            pst.setString(2, contrasenaInput);
            rs = pst.executeQuery();

            if (rs.next()) {
                String tipoUsuario = rs.getString("tipoUsuario");

                switch (tipoUsuario) {
                    case "administrador":
                        usuarioAutenticado = obtenerAdministrador(rs.getInt("idUsuario"), rs, conexion);
                        break;
                    case "cliente":
                        usuarioAutenticado = obtenerCliente(rs.getInt("idUsuario"), rs, conexion);
                        break;
                    default:
                        System.out.println("Tipo de usuario no reconocido: " + tipoUsuario);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al iniciar sesión: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return usuarioAutenticado;
    }

    private Usuario obtenerAdministrador(int idUsuario, ResultSet rs, Connection conexion) throws SQLException {
        String sqlAdmin = "SELECT * FROM Administrador WHERE Usuario_idUsuario = ?";
        try (PreparedStatement pstAdmin = conexion.prepareStatement(sqlAdmin)) {
            pstAdmin.setInt(1, idUsuario);
            try (ResultSet rsAdmin = pstAdmin.executeQuery()) {
                if (rsAdmin.next()) {
                    return new Administrador(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("tipoUsuario"),
                        rs.getString("usuario"),
                        rs.getString("contrasena"),
                        rsAdmin.getString("email"),
                        rsAdmin.getDouble("salario")
                    );
                }
            }
        }
        return null;
    }

    private Usuario obtenerCliente(int idUsuario, ResultSet rs, Connection conexion) throws SQLException {
        String sqlCliente = "SELECT * FROM Cliente WHERE Usuario_idUsuario = ?";
        try (PreparedStatement pstCliente = conexion.prepareStatement(sqlCliente)) {
            pstCliente.setInt(1, idUsuario);
            try (ResultSet rsCliente = pstCliente.executeQuery()) {
                if (rsCliente.next()) {
                    LocalDate fechaRegistro = rsCliente.getDate("fechaRegistro").toLocalDate();
                    String fechaRegistroTexto = fechaRegistro.format(DateTimeFormatter.ISO_LOCAL_DATE);

                    return new Cliente(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("tipoUsuario"),
                        rs.getString("usuario"),
                        rs.getString("contrasena"),
                        rsCliente.getString("email"),
                        fechaRegistroTexto
                    );
                }
            }
        }
        return null;
    }

    public boolean actualizarInformacion(String nombre, String apellido, String telefono, String contrasena) {
        boolean actualizado = false;
        Connection conexion = Conexion.conectar();  // Obtener la conexión compartida
        try {
            if (!verificarConexion()) {
                return false;  // No se pudo establecer la conexión
            }

            String sql = "UPDATE Usuario SET nombre = ?, apellido = ?, telefono = ?, contrasena = ? WHERE idUsuario = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, telefono);
            pst.setString(4, contrasena);
            pst.setInt(5, this.idUsuario);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                this.nombre = nombre;
                this.apellido = apellido;
                this.telefono = telefono;
                this.contrasena = contrasena;
                actualizado = true;
            }

            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al actualizar la información del usuario: " + e.getMessage());
            e.printStackTrace();
        }

        return actualizado;
    }

    // Métodos getter y setter
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
