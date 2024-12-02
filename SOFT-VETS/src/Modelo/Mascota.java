package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Mascota {
    private int idMascota;
    private String nombreMascota;
    private int especie; 
    private String raza;
    private int edad;
    private String sexo;
    private String color;
    private double peso;
    private Date fechaNacimiento;
    private String fechaRegistro;
    private boolean castrada;
    private int idCliente; 
    private String nombreCliente;  
    private String apellidoCliente; 



    // Constructor completo
    public Mascota(int idMascota, String nombreMascota, int especie, String raza, int edad, String sexo,
                   String color, double peso, Date fechaNacimiento,
                   boolean castrada, int idCliente) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.sexo = sexo;
        this.color = color;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
        this.castrada = castrada;
        this.idCliente = idCliente;
    }
  
    public Mascota() {
    }

    public boolean registrarMascota() {
        boolean exito = false;
        Connection conexion = Conexion.conectar();
        try {
            String fechaRegistro = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String sql = """
                         INSERT INTO Mascota (nombreMascota, especie, raza, edad, sexo, color, peso, 
                                              fechaNacimiento, fechaRegistro, castrada, idCliente) 
                         VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                         """;
            PreparedStatement pst = conexion.prepareStatement(sql);
            java.sql.Date sqlFechaNacimiento = new java.sql.Date(this.fechaNacimiento.getTime());
            pst.setString(1, this.nombreMascota);
            pst.setInt(2, this.especie);
            pst.setString(3, this.raza);
            pst.setInt(4, this.edad);
            pst.setString(5, this.sexo);
            pst.setString(6, this.color);
            pst.setDouble(7, this.peso);
            pst.setDate(8, sqlFechaNacimiento);
            pst.setString(9, fechaRegistro);
            pst.setBoolean(10, this.castrada);
            pst.setInt(11, this.idCliente);

            int filasAfectadas = pst.executeUpdate();
            exito = filasAfectadas > 0;

            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al registrar la mascota: " + e.getMessage());
        }
        return exito;
    }
    
    public static Mascota obtenerMascotaPorId(int idMascota) {
        Mascota mascota = null;
        Connection conexion = Conexion.conectar();
        try {
            String sql = "SELECT * FROM Mascota WHERE idMascota = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idMascota);
            ResultSet rs = pst.executeQuery();
                
            if (rs.next()) {
            int especieDb = rs.getInt("especie");
            int especieIndex = 0;

                switch (especieDb) {
                    case 1:
                        especieIndex = 1;  // Felino
                        break;
                    case 2:
                        especieIndex = 0;  // Canino
                        break;
                    case 3:
                        especieIndex = 2;  // Roedor
                        break;
                    default:
                        especieIndex = 0; 
                }
                mascota = new Mascota(
                    rs.getInt("idMascota"),
                    rs.getString("nombreMascota"),
                    especieIndex,
                    rs.getString("raza"),
                    rs.getInt("edad"),
                    rs.getString("sexo"),
                    rs.getString("color"),
                    rs.getDouble("peso"),
                    rs.getDate("fechaNacimiento"),
                    rs.getBoolean("castrada"),
                    rs.getInt("idCliente")
                );
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener la mascota: " + e.getMessage());
        }
        return mascota;
    }
    
    public static void cargarClienteDeMascota(Mascota mascota) {
        Connection conexion = Conexion.conectar();
        try {
            int idCliente = mascota.getIdCliente();
            String sqlCliente = "SELECT u.nombre, u.apellido FROM Usuario u " +
                                "JOIN Cliente c ON u.idUsuario = c.Usuario_idUsuario WHERE c.idCliente = ?";
            PreparedStatement pstCliente = conexion.prepareStatement(sqlCliente);
            pstCliente.setInt(1, idCliente);
            ResultSet rsCliente = pstCliente.executeQuery();

            if (rsCliente.next()) {

                String nombreCliente = rsCliente.getString("nombre");
                String apellidoCliente = rsCliente.getString("apellido");
                mascota.setNombreCliente(nombreCliente); 
                mascota.setApellidoCliente(apellidoCliente); 
            }
            rsCliente.close();
            pstCliente.close();
        } catch (SQLException e) {
            System.err.println("Error al cargar el cliente: " + e.getMessage());
        }
    }


    public static boolean actualizarMascota(Mascota mascota) {
        Connection conexion = Conexion.conectar(); // Conexión fuera del bloque try

        try {
            String query = "UPDATE Mascota SET nombreMascota = ?, especie = ?, raza = ?, edad = ?, sexo = ?, color = ?, peso = ?, fechaNacimiento = ?, castrada = ?, idCliente = ? WHERE idMascota = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, mascota.getNombreMascota());
            ps.setInt(2, mascota.getEspecie());
            ps.setString(3, mascota.getRaza());
            ps.setInt(4, mascota.getEdad());
            ps.setString(5, mascota.getSexo());
            ps.setString(6, mascota.getColor());
            ps.setDouble(7, mascota.getPeso());
            ps.setDate(8, new java.sql.Date(mascota.getFechaNacimiento().getTime()));
            ps.setBoolean(9, mascota.isCastrada());
            ps.setInt(10, mascota.getIdCliente());
            ps.setInt(11, mascota.getIdMascota());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar la mascota: " + e.getMessage());
        }
        return false;
    }
    
    public boolean eliminarMascota(int idMascota) {
        boolean eliminada = false;
        Connection conexion = Conexion.conectar(); 

        try {
            String sql = "DELETE FROM Mascota WHERE idMascota = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idMascota);

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                eliminada = true;
            }

            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al eliminar la mascota: " + e.getMessage());
        }

        return eliminada;
    }

    
    public static List<Mascota> obtenerMascotas() {
        List<Mascota> mascotas = new ArrayList<>();

        Connection conexion = Conexion.conectar();

        String sql = """
            SELECT 
                m.idMascota,
                m.nombreMascota,
                m.especie AS idEspecie,
                COALESCE(e.nombre, 'No especificada') AS Especie,
                m.raza,
                m.edad,
                m.sexo,
                m.color,
                m.peso,
                m.fechaNacimiento,
                m.castrada,
                m.idCliente,
                CONCAT(u.nombre, ' ', u.apellido) AS Dueño
            FROM Mascota m
            JOIN Cliente c ON m.idCliente = c.idCliente
            JOIN Usuario u ON c.Usuario_idUsuario = u.idUsuario
            LEFT JOIN Especie e ON m.especie = e.idEspecie;
        """;

        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Mascota mascota = new Mascota(
                    rs.getInt("idMascota"),
                    rs.getString("nombreMascota"),
                    rs.getInt("idEspecie"), // idEspecie para mantener consistencia
                    rs.getString("raza"),
                    rs.getInt("edad"),
                    rs.getString("sexo"),
                    rs.getString("color"),
                    rs.getDouble("peso"),
                    rs.getDate("fechaNacimiento"),
                    rs.getBoolean("castrada"),
                    rs.getInt("idCliente")
                );
                mascotas.add(mascota);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener mascotas: " + e.getMessage());
        }

        return mascotas;
    }
   
    public static int obtenerIdEspeciePorNombre(String especie) {
        int idEspecie = -1;
        Connection conexion = Conexion.conectar();
        try {
            String sql = "SELECT idEspecie FROM Especie WHERE nombre = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, especie);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idEspecie = rs.getInt("idEspecie");
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener el ID de la especie: " + e.getMessage());
        }
        return idEspecie;
    }
    
    public static String obtenerNombreEspeciePorId(int idEspecie) {
        String nombreEspecie = null;
        Connection conexion = Conexion.conectar();
        try {
            String sql = "SELECT nombre FROM Especie WHERE idEspecie = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idEspecie);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombreEspecie = rs.getString("nombre");
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener el nombre de la especie: " + e.getMessage());
        }
        return nombreEspecie;
    }
    
    public static String obtenerNombreDueño(int idCliente) {
        String nombreDueño = "Sin información"; 
        Connection conexion = Conexion.conectar();
        try {
            String sql = """
                SELECT CONCAT(u.nombre, ' ', u.apellido) AS nombreCompleto
                FROM Cliente c
                JOIN Usuario u ON c.Usuario_idUsuario = u.idUsuario
                WHERE c.idCliente = ?
            """;
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setInt(1, idCliente);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombreDueño = rs.getString("nombreCompleto");
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener el nombre del dueño: " + e.getMessage());
        }
        return nombreDueño;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getEspecie() {
        return especie;
    }

    public void setEspecie(int especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isCastrada() {
        return castrada;
    }

    public void setCastrada(boolean castrada) {
        this.castrada = castrada;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    private void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    private void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;    
    }
}
