package Controlador;

import Modelo.Administrador;
import javax.swing.JOptionPane;

public class ControladorAdministrador {
    private Administrador administrador;
    
    public ControladorAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    public boolean actualizarEmail(String nuevoEmail) {
        boolean actualizado = administrador.actualizarEmail(nuevoEmail);

        if (actualizado) {
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el email.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return actualizado;
    }

    // Método para actualizar el salario del administrador
    public boolean actualizarSalario(double nuevoSalario) {
        boolean actualizado = administrador.actualizarSalario(nuevoSalario);

        if (actualizado) {
          
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el salario.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return actualizado;
    }
}
