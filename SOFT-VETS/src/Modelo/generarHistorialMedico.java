package Modelo;

import static Modelo.Mascota.obtenerMascotaPorId;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.io.InputStream;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;


public class generarHistorialMedico {
    
    public void generarPDF(
        String ruta,
        String nombreMascota,
        String especie,
        String raza,
        int edad,
        String sexo,
        String color,
        double peso,
        boolean castrado,
        String fechaNacimiento,
        String propietario
    ) {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();

            InputStream logoStream = getClass().getResourceAsStream("/imagenlogo/icono.png");
            Image logo = Image.getInstance(logoStream.readAllBytes());
            logo.scaleToFit(50, 50);
            logo.setAlignment(Image.ALIGN_LEFT);
            document.add(logo);

            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph titulo = new Paragraph("HISTORIAL MEDICO", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            
            Font subtituloFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Paragraph subtitulo = new Paragraph("Ficha de la Mascota", subtituloFont);
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitulo);

            document.add(new Paragraph(" "));
            
            // Contenido
            Font contenidoFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            document.add(new Paragraph("Propietario: " + propietario, contenidoFont));
            document.add(new Paragraph("Nombre de la Mascota: " + nombreMascota, contenidoFont));
            document.add(new Paragraph("Especie: " + especie, contenidoFont));
            document.add(new Paragraph("Raza: " + raza, contenidoFont));
            document.add(new Paragraph("Edad: " + edad + " años", contenidoFont));
            document.add(new Paragraph("Sexo: " + sexo, contenidoFont));
            document.add(new Paragraph("Color: " + color, contenidoFont));
            document.add(new Paragraph("Peso: " + peso + " kg", contenidoFont));
            document.add(new Paragraph("Castrado: " + (castrado ? "Sí" : "No"), contenidoFont));
            document.add(new Paragraph("Fecha de Nacimiento: " + fechaNacimiento, contenidoFont));
            
            agregarMarcaDeAgua(writer, "/imagenlogo/icono.png");
            
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void agregarMarcaDeAgua(PdfWriter writer, String rutaMarca) {
        try {
            InputStream marcaStream = getClass().getResourceAsStream(rutaMarca);
            Image marcaDeAgua = Image.getInstance(marcaStream.readAllBytes());
            marcaDeAgua.setAbsolutePosition(200, 300); 
            marcaDeAgua.scaleToFit(300, 300);

            PdfContentByte canvas = writer.getDirectContentUnder();
            canvas.saveState();
            PdfGState transparencia = new PdfGState();
            transparencia.setFillOpacity(0.2f); 
            canvas.setGState(transparencia);
            canvas.addImage(marcaDeAgua);
            canvas.restoreState();
        } catch (Exception e) {
            System.err.println("Error al agregar marca de agua: " + e.getMessage());
        }
    }
}
