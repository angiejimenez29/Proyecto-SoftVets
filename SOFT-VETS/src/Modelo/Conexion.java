package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection cx; 
    private static final String usuario = "upqzp62esxzralwp";
    private static final String contrasena = "mOVSX56rSYoCM8OA9ijU";
    private static final String db = "bqsw3lczrwzt3abas1po";
    private static final String ip = "bqsw3lczrwzt3abas1po-mysql.services.clever-cloud.com";
    private static final String puerto = "3306";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + db + "?connectTimeout=180000";

    private Conexion() {}

    public static Connection conectar() {
        if (cx == null) {
            try {
                Class.forName(driver);

                cx = DriverManager.getConnection(cadena, usuario, contrasena);
                System.out.println("Conexión establecida con la base de datos.");
            } catch (Exception e) {
                System.err.println("Error al conectar con la base de datos: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return cx;
    }

    public static void desconectar() {
        try {
            if (cx != null && !cx.isClosed()) {
                cx.close();
                cx = null;
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
