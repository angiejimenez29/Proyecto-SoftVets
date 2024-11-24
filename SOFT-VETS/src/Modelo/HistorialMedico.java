package Modelo;

import java.util.Scanner;
import java.util.ArrayList;

public class HistorialMedico {
    private Scanner scanner;
    private Mascota mascota;
    private Cliente cliente;

    public HistorialMedico(Mascota mascota, Cliente cliente) {
        this.mascota = mascota;
        this.cliente = cliente;
        this.scanner = scanner;
    }

    public void mostrarHistorial() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n--Historial de " + mascota.getNombreMascota() + "--");
    System.out.println("Nombre de la mascota: " + mascota.getNombreMascota());
    System.out.println("Especie: " + mascota.getEspecie());
    System.out.println("Raza: " + mascota.getRaza());
    System.out.println("Edad: " + mascota.getEdad());
    System.out.println("Sexo: " + mascota.getSexo());
    System.out.println("Castrado: " + (mascota.isCastrada() ? "Si" : "No"));
    if (!mascota.isCastrada() && mascota.getSexo().equals("Hembra")) {
        System.out.println("Gestante: " + (mascota.isGestante() ? "Si" : "No"));
    }
    System.out.println("Color: " + mascota.getColor());
    System.out.println("Peso: " + mascota.getPeso() + " kg");
    System.out.println("Fecha de nacimiento: " + mascota.getFechaNacimiento());
    System.out.println("Fecha de registro: " + mascota.getFechaRegistro());

    System.out.println("\nVacunas:");
    if (mascota.getVacunas().isEmpty()) {
        System.out.println("No hay vacunas registradas.");
    } else {
        for (String vacuna : mascota.getVacunas()) {
            System.out.println("- " + vacuna);
        }
    }

    System.out.println("\nAlergias:");
    if (mascota.getAlergias().isEmpty()) {
        System.out.println("No hay alergias registradas.");
    } else {
        for (String alergia : mascota.getAlergias()) {
            System.out.println("- " + alergia);
        }
    }

    System.out.println("\nEnfermedades:");
    if (mascota.getEnfermedades().isEmpty()) {
        System.out.println("No hay enfermedades registradas.");
    } else {
        for (String enfermedad : mascota.getEnfermedades()) {
            System.out.println("- " + enfermedad);
        }
    }
    }
}
    