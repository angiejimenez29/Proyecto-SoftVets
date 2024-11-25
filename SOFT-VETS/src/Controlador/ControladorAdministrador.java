package Controlador;

import Modelo.Administrador;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ControladorAdministrador {
    private Administrador administrador;
    
    public ControladorAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    public void mostrarAdministradores(JTable tablaAdmin) {
        List<Administrador> administradores = Administrador.obtenerAdministradores();
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Nombre", "Telefono", "Email", "Salario" }
        ){
            @Override
            public Class getColumnClass(int columnIndex) {
                return String.class;
            }
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }            
        };

        for (Administrador admin : administradores) {
            Object[] fila = new Object[] {
                admin.getNombre() + " " + admin.getApellido(),
                admin.getTelefono(),
                admin.getEmail(),
                admin.getSalario()
            };
            modelo.addRow(fila);
        }
        tablaAdmin.setModel(modelo);
        tablaAdmin.getColumnModel().getColumn(0).setPreferredWidth(200);
        tablaAdmin.getColumnModel().getColumn(1).setPreferredWidth(100); 
        tablaAdmin.getColumnModel().getColumn(2).setPreferredWidth(200);
        tablaAdmin.getColumnModel().getColumn(3).setPreferredWidth(100);
        DefaultTableCellRenderer centroRenderer = new DefaultTableCellRenderer();
        centroRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < tablaAdmin.getColumnCount(); i++) {
             tablaAdmin.getColumnModel().getColumn(i).setCellRenderer(centroRenderer);
         }
    }
    
    public boolean actualizarEmail(String nuevoEmail) {
        boolean actualizado = administrador.actualizarEmail(nuevoEmail);

        if (actualizado) {
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el email.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return actualizado;
    }

    public boolean actualizarSalario(double nuevoSalario) {
        boolean actualizado = administrador.actualizarSalario(nuevoSalario);

        if (actualizado) {
          
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el salario.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return actualizado;
    }
}
