package Modelo;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Mascota {
    private Scanner scanner = new Scanner(System.in);
    private String nombreMascota;
    private int edad;
    private String especie;
    private String raza;
    private String sexo;
    private String color;
    private double peso;
    private String fechaNacimiento;
    private String fechaRegistro;
    private ArrayList<String> vacunas;
    private ArrayList<String> alergias;
    private ArrayList<String> enfermedades;
    private String observaciones;
    private boolean castrada;
    private boolean gestante;
    private Cliente cliente;
    private ArrayList<String> historialMedico;
    private static ArrayList<String> mascotasRegistradas = new ArrayList<>();
    private Map<String, Cliente> mascotaClienteMap = new HashMap<>();
    private ArrayList<Mascota> mascotas = new ArrayList<>();
    
    
    private static final String[] vacunasPerro = {"Sextuple (DHPPi+L)", "Quintuple (DHPPi)", "Triple (DHP)", "Antirrabica", "Tos de las Perreras"};
    private static final String[] vacunasGato = {"Cuadruple (V4)", "Triple (V3)", "Antirrabica", "Leucemia felina", "Clamidiosis"};
    private static final String[] vacunasConejo = {"Mixomatosis", "Enfermedad hemorrágica viral", "Pasteurelosis"};

    private static final String[] alergiasPerro = {"Polen de pasto", "Picaduras de pulgas", "Pollo", "Penicilina", "Frutos secos", "Lactosa"};
    private static final String[] alergiasGato = {"Polen de flores", "Picaduras de pulgas", "Pescado", "Lactosa"};
    private static final String[] alergiasConejo = {"Heno de alfalfa", "Polen de flores", "Frutos secos"};

    private static final String[] enfermedadesPerro = {"Moquillo", "Parvovirus", "Hepatitis infecciosa", "Leptospirosis", "Tos de las Perreras", "Coronavirus", "Rabia", "Dermatitis"};
    private static final String[] enfermedadesGato = {"Panleucopenia", "Rinotraqueitis", "Calicivirus", "Leucemia felina", "Clamidiosis", "Rabia", "Dermatitis"};
    private static final String[] enfermedadesConejo = {"Mixomatosis", "Enfermedad hemorragica viral", "Pasteurelosis", "Dermatitis"};

    public Mascota(String nombre, String especie, String raza, int edad, String sexo, String color, 
                   double peso, String fechaNacimiento, String fechaRegistro,
                   ArrayList<String> vacunas, ArrayList<String> alergias,
                   ArrayList<String> enfermedades, String observaciones, 
                   boolean castrada, boolean gestante, Cliente cliente){
        this.nombreMascota = nombre;
        this.edad = edad;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.color = color;
        this.peso = peso;
        this.observaciones = observaciones;
        this.castrada = castrada;
        this.gestante = gestante;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.vacunas = new ArrayList<>(vacunas);
        this.alergias = new ArrayList<>(alergias);
        this.enfermedades = new ArrayList<>(enfermedades); 
        this.historialMedico = new ArrayList<>();  
        this.mascotas = new ArrayList<>();
    }
    
    public Mascota(){
        this.mascotas = new ArrayList<>();
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getNombreMascota() {
        return nombreMascota;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getColor() {
        return color;
    }

    public double getPeso() {
        return peso;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public ArrayList<String> getVacunas() {
        return vacunas;
    }

    public ArrayList<String> getAlergias() {
        return alergias;
    }

    public ArrayList<String> getEnfermedades() {
        return enfermedades;
    }

    public boolean isCastrada() {
        return castrada;
    }

    public boolean isGestante() {
        return gestante;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setVacunas(ArrayList<String> vacunas) {
        this.vacunas = vacunas;
    }

    public void setAlergias(ArrayList<String> alergias) {
        this.alergias = alergias;
    }

    public void setEnfermedades(ArrayList<String> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public void setCastrada(boolean castrada) {
        this.castrada = castrada;
    }

    public void setGestante(boolean gestante) {
        this.gestante = gestante;
    }
    
}