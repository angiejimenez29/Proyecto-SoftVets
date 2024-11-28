package Controlador;

import Modelo.Administrador;
import Modelo.Conexion;
import Vista.gestionPersonalAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ControladorAdministrador {
    private gestionPersonalAdmin gestionarPersonal;
    public Administrador administrador;
    
    public ControladorAdministrador(Administrador administrador) {
        this.administrador = administrador;
        this.gestionarPersonal = gestionarPersonal;
    }
    
    public void mostrarAdministradores(JTable tablaAdmin) {
        List<Administrador> administradores = Administrador.obtenerAdministradores();

        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][] {},
            new String[] {"IDA", "IDU", "NOMBRE", "TELEFONO", "EMAIL", "SALARIO"}
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        for (Administrador admin : administradores) {
            String telefono = admin.getTelefono() != null ? admin.getTelefono() : "Sin teléfono";
            Object[] fila = new Object[] {
                admin.getIdAdministrador(),
                admin.getIdUsuario(),
                admin.getNombre() + " " + admin.getApellido(),
                telefono,
                admin.getEmail(),
                admin.getSalario()
            };
            modelo.addRow(fila);
        }

        tablaAdmin.setModel(modelo);

        tablaAdmin.getColumnModel().getColumn(0).setPreferredWidth(50);  // IDA
        tablaAdmin.getColumnModel().getColumn(1).setPreferredWidth(50);  // IDU
        tablaAdmin.getColumnModel().getColumn(2).setPreferredWidth(150); // Nombre
        tablaAdmin.getColumnModel().getColumn(3).setPreferredWidth(100); // Teléfono
        tablaAdmin.getColumnModel().getColumn(4).setPreferredWidth(150); // Email
        tablaAdmin.getColumnModel().getColumn(5).setPreferredWidth(100); // Salario

        tablaAdmin.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaAdmin.getColumnModel().getColumn(0).setMinWidth(0);
        tablaAdmin.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablaAdmin.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaAdmin.getColumnModel().getColumn(1).setMinWidth(0);
        tablaAdmin.getColumnModel().getColumn(1).setPreferredWidth(0);

        DefaultTableCellRenderer centroRenderer = new DefaultTableCellRenderer();
        centroRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < tablaAdmin.getColumnCount(); i++) {
            tablaAdmin.getColumnModel().getColumn(i).setCellRenderer(centroRenderer);
        }
    }
    
    public void buscarAdmin(String nombreBuscar, JTable tablaAdmin) {
        List<Administrador> administradoresFiltrados = Administrador.obtenerAdministradores().stream()
        .filter(admin -> {
            String nombreCompleto = admin.getNombre() + " " + admin.getApellido();
            return nombreCompleto.toLowerCase().contains(nombreBuscar.toLowerCase());
        })
        .collect(Collectors.toList());

    DefaultTableModel modelo = new DefaultTableModel(
        new Object[][] {},
        new String[] {"IDA", "IDU", "NOMBRE", "TELEFONO", "EMAIL", "SALARIO"}
    ) {
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };

    for (Administrador admin : administradoresFiltrados) {
        String telefono = admin.getTelefono() != null ? admin.getTelefono() : "Sin teléfono";
        Object[] fila = new Object[] {
            admin.getIdAdministrador(),
            admin.getIdUsuario(),
            admin.getNombre() + " " + admin.getApellido(),
            admin.getTelefono(),
            admin.getEmail(),
            admin.getSalario()
        };
        modelo.addRow(fila);
    }

    tablaAdmin.setModel(modelo);

    tablaAdmin.getColumnModel().getColumn(0).setPreferredWidth(0); 
    tablaAdmin.getColumnModel().getColumn(1).setPreferredWidth(0);  
    tablaAdmin.getColumnModel().getColumn(2).setPreferredWidth(150);
    tablaAdmin.getColumnModel().getColumn(3).setPreferredWidth(100);
    tablaAdmin.getColumnModel().getColumn(4).setPreferredWidth(150); 
    tablaAdmin.getColumnModel().getColumn(5).setPreferredWidth(100);

    tablaAdmin.getColumnModel().getColumn(0).setMaxWidth(0);  // IDA
    tablaAdmin.getColumnModel().getColumn(0).setMinWidth(0);  // IDA
    tablaAdmin.getColumnModel().getColumn(1).setMaxWidth(0);  // IDU
    tablaAdmin.getColumnModel().getColumn(1).setMinWidth(0);  // IDU
    tablaAdmin.getColumnModel().getColumn(0).setResizable(false); 
    tablaAdmin.getColumnModel().getColumn(1).setResizable(false); 

    DefaultTableCellRenderer centroRenderer = new DefaultTableCellRenderer();
    centroRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
    for (int i = 0; i < tablaAdmin.getColumnCount(); i++) {
        tablaAdmin.getColumnModel().getColumn(i).setCellRenderer(centroRenderer);
    }
}

    public void eliminarAdministrador(int idUsuario) {
        boolean exito = administrador.eliminarAdmin(idUsuario);
        if (exito) {
            JOptionPane.showMessageDialog(null, "Administrador eliminado correctamente.");
            
        }else{
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar al administrador.");
        }
    }

    public void actualizarAdministrador(String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevoEmail, double nuevoSalario, int idUsuario) {

        boolean exito = administrador.actualizarAdmin(nuevoNombre, nuevoApellido, nuevoTelefono, nuevoEmail, nuevoSalario, idUsuario);
        if (exito) {
            JOptionPane.showMessageDialog(null,"Administrador actualizado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null,"Hubo un error al actualizar al administrador");
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
