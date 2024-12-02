package Controlador;

import Modelo.Cliente;
import Modelo.Mascota;
import Modelo.Mascota;
import Modelo.generarHistorialMedico;
import Vista.gestionMascotaAdmin;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.net.URL;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ControladorMascota {
    private gestionMascotaAdmin gestionMascota;

    
    public ControladorMascota(gestionMascotaAdmin gestionMascota) {
        this.gestionMascota = gestionMascota;
    }
    
    public void generarPDF(int idMascota) {
    Mascota mascota = Mascota.obtenerMascotaPorId(idMascota); 
    Cliente cliente = Cliente.obtenerClientePorId(mascota.getIdCliente());

    if (mascota != null && cliente != null) {
        generarHistorialMedico pdfGen = new generarHistorialMedico();
        String ruta = "C:/Users/ASUS/OneDrive/Escritorio/HISTORIALMEDICO/HM_" + mascota.getNombreMascota() + ".pdf";
        pdfGen.generarPDF(
            ruta,
            mascota.getNombreMascota(),
            mascota.getEspecie() == 0 ? "Canino" : 
            mascota.getEspecie() == 1 ? "Felino" : 
            "Roedor", 
            mascota.getRaza(),
            mascota.getEdad(),
            mascota.getSexo(),
            mascota.getColor(),
            mascota.getPeso(),
            mascota.isCastrada(),
            new SimpleDateFormat("dd/MM/yyyy").format(mascota.getFechaNacimiento()),
            cliente.getNombre() + " " + cliente.getApellido()
        );
        JOptionPane.showMessageDialog(null, "Historial Medico generado exitosamente");
    } else {
        JOptionPane.showMessageDialog(null, "No se pudieron obtener los datos de la mascota o cliente.");
    }
}


    public void mostrarMascotas(JTable tablaMascotas) {
        List<Mascota> mascotas = Mascota.obtenerMascotas();
        System.out.println("Número de mascotas obtenidas: " + mascotas.size());
        actualizarTablaMascotas(mascotas, tablaMascotas);
    }
    
    public void mostrarInfoMascota(int idMascota) {
        Mascota mascota = Mascota.obtenerMascotaPorId(idMascota);
        if (mascota != null) {
            gestionMascota.mostrarDatosMascota(mascota);
        } else {
            System.out.println("Mascota no encontrada");
        }
    }
    
    public void guardarCambios(Mascota mascota) {
        boolean exito = Mascota.actualizarMascota(mascota);
        if (exito) {
            System.out.println("La mascota se actualizó correctamente.");
        } else {
            System.out.println("Error al actualizar la mascota.");
        }
    }

    public void buscarMascotas(String nombreBuscar, JTable tablaMascotas) {
        List<Mascota> mascotasFiltradas = Mascota.obtenerMascotas().stream()
            .filter(mascota -> mascota.getNombreMascota().toLowerCase().contains(nombreBuscar.toLowerCase()))
            .collect(Collectors.toList());

        actualizarTablaMascotas(mascotasFiltradas, tablaMascotas);
    }

    private void actualizarTablaMascotas(List<Mascota> mascotas, JTable tablaMascotas) {
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][] {},
            new String[] {"IDM", "MASCOTA", "DUEÑO", "ESPECIE", "RAZA", "SEXO"}
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex ==7;
            }
        };
        for (Mascota mascota : mascotas) {
            String nombreEspecie = Mascota.obtenerNombreEspeciePorId(mascota.getEspecie());
            String dueño = Mascota.obtenerNombreDueño(mascota.getIdCliente());

            Object[] fila = new Object[] {
                mascota.getIdMascota(),
                mascota.getNombreMascota(),
                dueño,
                nombreEspecie,
                mascota.getRaza(),
                mascota.getSexo(),
                ""
            };
            modelo.addRow(fila);
        }

        tablaMascotas.setModel(modelo);
        ajustarColumnasTabla(tablaMascotas);
        
    }
    
    private void ajustarColumnasTabla(JTable tablaMascotas) {
        tablaMascotas.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaMascotas.getColumnModel().getColumn(1).setPreferredWidth(70);
        tablaMascotas.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaMascotas.getColumnModel().getColumn(3).setPreferredWidth(50);
        tablaMascotas.getColumnModel().getColumn(4).setPreferredWidth(50);
        tablaMascotas.getColumnModel().getColumn(5).setPreferredWidth(50);

        tablaMascotas.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaMascotas.getColumnModel().getColumn(0).setMinWidth(0);
        tablaMascotas.getColumnModel().getColumn(0).setPreferredWidth(0);

        DefaultTableCellRenderer centroRenderer = new DefaultTableCellRenderer();
        centroRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < tablaMascotas.getColumnCount(); i++) {
            tablaMascotas.getColumnModel().getColumn(i).setCellRenderer(centroRenderer);
        }
    }

    public void eliminarMascota(int idMascota) {
        Mascota mascota = new Mascota();
        boolean exito = mascota.eliminarMascota(idMascota);
        if (exito) {
            System.out.println("La mascota fue eliminada exitosamente.");
        } else {
            System.out.println("No se pudo eliminar la mascota.");
        }
    }
}
