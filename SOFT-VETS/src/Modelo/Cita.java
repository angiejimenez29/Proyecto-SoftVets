package Modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cita {
    private String nombreCliente;
    private String apellidoCliente;
    private String nombreMascota;
    private String tipoCita;
    private String turno;
    private String especialista;
    private String hora;

    private static ArrayList<Cita> citasList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Cita(String nombreCliente, String apellidoCliente, String nombreMascota, String tipoCita, String turno, String especialista, String hora) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.nombreMascota = nombreMascota;
        this.tipoCita = tipoCita;
        this.turno = turno;
        this.especialista = especialista;
        this.hora = hora;
    }



}