package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistorialMedico{
    private List<Integer> alergias;
    private List<Integer> enfermedades;
    private List<Integer> vacunas;
    
    public HistorialMedico() {
        this.alergias = new ArrayList<>();
        this.enfermedades = new ArrayList<>();
        this.vacunas = new ArrayList<>();
    }

    public static void agregarAtributoAMascota(int idMascota, int idAtributo, String tipoAtributo) {
        Connection conexion = Conexion.conectar();
        PreparedStatement pst = null;

        try {
            String query = "";
            if (tipoAtributo.equals("alergia")) {
                query = "INSERT INTO MascotaAlergia (idMascota, idAlergia) VALUES (?, ?)";
            } else if (tipoAtributo.equals("enfermedad")) {
                query = "INSERT INTO MascotaEnfermedad (idMascota, idEnfermedad, fechaDiagnostico) VALUES (?, ?, CURRENT_TIMESTAMP)";
            } else if (tipoAtributo.equals("vacuna")) {
                query = "INSERT INTO MascotaVacuna (idMascota, idVacuna, fecha) VALUES (?, ?, CURRENT_TIMESTAMP)";
            }

            pst = conexion.prepareStatement(query);
            pst.setInt(1, idMascota);
            pst.setInt(2, idAtributo);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al agregar el atributo a la mascota: " + e.getMessage());
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
        }
    }

    public List<String> obtenerVacunasPorEspecie(String especie) {
        List<String> vacunas = new ArrayList<>();
        Connection conexion = Conexion.conectar(); 

        try {
            String query = "SELECT v.nombre FROM Vacuna v " +
                           "JOIN EspecieVacuna ev ON v.idVacuna = ev.idVacuna " +
                           "JOIN Especie e ON e.idEspecie = ev.idEspecie " +
                           "WHERE e.nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, especie);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                vacunas.add(rs.getString("nombre"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener las vacunas: " + e.getMessage());
        }
        return vacunas;
    }

    public List<String> obtenerAlergiasPorEspecie(String especie) {
        List<String> alergias = new ArrayList<>();
        Connection conexion = Conexion.conectar(); 

        try {
            String query = "SELECT a.nombre FROM Alergia a " +
                           "JOIN EspecieAlergia ea ON a.idAlergia = ea.idAlergia " +
                           "JOIN Especie e ON e.idEspecie = ea.idEspecie " +
                           "WHERE e.nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, especie);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                alergias.add(rs.getString("nombre"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener las alergias: " + e.getMessage());
        }
        return alergias;
    }

    public List<String> obtenerEnfermedadesPorEspecie(String especie) {
        List<String> enfermedades = new ArrayList<>();
        Connection conexion = Conexion.conectar();

        try {
            String query = "SELECT e.nombre FROM Enfermedad e " +
                           "JOIN EspecieEnfermedad ee ON e.idEnfermedad = ee.idEnfermedad " +
                           "JOIN Especie es ON es.idEspecie = ee.idEspecie " +
                           "WHERE es.nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, especie);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                enfermedades.add(rs.getString("nombre"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Error al obtener las enfermedades: " + e.getMessage());
        }
        return enfermedades;
    }
    
    public List<Integer> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<Integer> alergias) {
        this.alergias = alergias;
    }

    public List<Integer> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(List<Integer> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public List<Integer> getVacunas() {
        return vacunas;
    }

    public void setVacunas(List<Integer> vacunas) {
        this.vacunas = vacunas;
    }
    
    
}
