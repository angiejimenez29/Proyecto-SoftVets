package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistorialMedico{

    public List<String> obtenerVacunasPorEspecie(String especie) throws SQLException {
        List<String> vacunas = new ArrayList<>();
        String query = "SELECT v.nombre FROM Vacuna v " +
                       "JOIN EspecieVacuna ev ON v.idVacuna = ev.idVacuna " +
                       "JOIN Especie e ON e.idEspecie = ev.idEspecie " +
                       "WHERE e.nombre = ?";
        
        try (Connection con = Conexion.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, especie);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vacunas.add(rs.getString("nombre"));
            }
        }
        return vacunas;
    }

    public List<String> obtenerAlergiasPorEspecie(String especie) throws SQLException {
        List<String> alergias = new ArrayList<>();
        String query = "SELECT a.nombre FROM Alergia a " +
                       "JOIN EspecieAlergia ea ON a.idAlergia = ea.idAlergia " +
                       "JOIN Especie e ON e.idEspecie = ea.idEspecie " +
                       "WHERE e.nombre = ?";
        
        try (Connection con = Conexion.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, especie);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alergias.add(rs.getString("nombre"));
            }
        }
        return alergias;
    }

    public List<String> obtenerEnfermedadesPorEspecie(String especie) throws SQLException {
        List<String> enfermedades = new ArrayList<>();
        String query = "SELECT e.nombre FROM Enfermedad e " +
                       "JOIN EspecieEnfermedad ee ON e.idEnfermedad = ee.idEnfermedad " +
                       "JOIN Especie es ON es.idEspecie = ee.idEspecie " +
                       "WHERE es.nombre = ?";
        
        try (Connection con = Conexion.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, especie);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                enfermedades.add(rs.getString("nombre"));
            }
        }
        return enfermedades;
    }
}
