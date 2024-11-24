package Modelo;

import Vista.iniciarSesion;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import java.awt.Font;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        Conexion.conectar();

        FlatRobotoFont.install();
        FlatLightLaf.setup();
        UIManager.put("Button.arc", 15);
        UIManager.put("Label.font", new Font("Roboto", Font.PLAIN, 13));
        UIManager.put("defaultFont", new Font("Roboto", Font.PLAIN, 13));

        java.awt.EventQueue.invokeLater(() -> {
            iniciarSesion ventanaLogin2 = new iniciarSesion();
            ventanaLogin2.setVisible(true);
        });
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Conexion.desconectar();
        }));

}    
}
