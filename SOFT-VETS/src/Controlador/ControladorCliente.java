package Controlador;

import Modelo.Cliente;
import Vista.gestionClienteAdmin;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorCliente {
    private gestionClienteAdmin gestionCliente;
    private Cliente cliente;
    
    public ControladorCliente(Cliente cliente) {
        this.cliente = cliente;
        this.gestionCliente = gestionCliente;
    }
    
    public void mostrarClientes(JTable tablaClientes) {
        List<Cliente> clientes = Cliente.obtenerClientes();

        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][] {},
            new String[] {"IDC", "IDU", "NOMBRE", "TELEFONO", "EMAIL", "FECHA DE REGISTRO"}
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        for (Cliente cli : clientes) {
            Object[] fila = new Object[] {
                cli.getIdCliente(),
                cli.getIdUsuario(),
                cli.getNombre() + " " + cli.getApellido(),
                cli.getTelefono(),
                cli.getEmail(),
                cli.getFechaRegistro()
            };
            modelo.addRow(fila);
        }

        tablaClientes.setModel(modelo);

        tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID Cliente
        tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(50);  // ID Usuario
        tablaClientes.getColumnModel().getColumn(2).setPreferredWidth(150); // Nombre
        tablaClientes.getColumnModel().getColumn(3).setPreferredWidth(100); // Teléfono
        tablaClientes.getColumnModel().getColumn(4).setPreferredWidth(150); // Email
        tablaClientes.getColumnModel().getColumn(5).setPreferredWidth(100); // Fecha de Registro
        
        tablaClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaClientes.getColumnModel().getColumn(0).setMinWidth(0);
        tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablaClientes.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaClientes.getColumnModel().getColumn(1).setMinWidth(0);
        tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        DefaultTableCellRenderer centroRenderer = new DefaultTableCellRenderer();
        centroRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < tablaClientes.getColumnCount(); i++) {
            tablaClientes.getColumnModel().getColumn(i).setCellRenderer(centroRenderer);
        }
    }
    
    public void buscarCliente(String nombreBuscar, JTable tablaClientes) {
        List<Cliente> clientesFiltrados = Cliente.obtenerClientes().stream()
            .filter(cli -> cli.getNombre().toLowerCase().contains(nombreBuscar.toLowerCase()))
            .collect(Collectors.toList());

        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][] {},
            new String[] {"IDC", "IDU", "NOMBRE", "TELEFONO", "EMAIL", "FECHA DE REGISTRO"}
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        for (Cliente cli : clientesFiltrados) {
            String telefono = cli.getTelefono() != null ? cli.getTelefono() : "Sin teléfono";
            Object[] fila = new Object[] {
                cli.getIdCliente(),
                cli.getIdUsuario(),
                cli.getNombre(),
                telefono,
                cli.getEmail(),
                cli.getFechaRegistro()
            };
            modelo.addRow(fila);
        }

        tablaClientes.setModel(modelo);
    }

    public void eliminarCliente(int idCliente) {
        boolean exito = cliente.eliminarCliente(idCliente);
        if (exito) {
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar al cliente.");
        }
    }

    public void actualizarCliente(String nuevoNombre, String nuevoEmail,  String nuevoApellido, String nuevoTelefono, int idCliente) {
        boolean exito = cliente.actualizarCliente(nuevoNombre, nuevoApellido, nuevoEmail, nuevoTelefono, idCliente);
        if (exito) {
            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar al cliente");
        }
    }
    
    public boolean actualizarEmail(String nuevoEmail) {
        boolean actualizado = cliente.actualizarEmail(nuevoEmail);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Email actualizado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el email.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return actualizado;
    }
    
     
    
}
