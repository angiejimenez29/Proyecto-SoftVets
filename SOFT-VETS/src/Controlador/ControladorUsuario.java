package Controlador;

import Modelo.Usuario;
import javax.swing.JOptionPane;

public class ControladorUsuario {
    private Usuario usuario;
    
    public ControladorUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public boolean actualizarUsuario(String nombre, String apellido, String telefono, String contrasena) {
        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben ser completados.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        boolean actualizado = usuario.actualizarInformacion(nombre, apellido, telefono, contrasena);
        
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Información actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar la información.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return actualizado;
    }                                               
}

