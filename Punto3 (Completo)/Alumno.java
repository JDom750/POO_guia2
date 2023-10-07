package Punto3;

import java.util.Random;

public class Alumno {
    private String numCredencial;
    private String nombre;
    private String telefono;
    private String direccion;

    public Alumno(String nombre, String telefono, String direccion) {
        Random r = new Random();
        String num = "0123456789";
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.numCredencial = "";
        for (int i = 0;i < 4;i++){
            this.numCredencial = this.numCredencial + num.charAt(r.nextInt(num.length()));
        }
    }

    public void mostrarAlumno(){
        System.out.println( numCredencial + " | Nombre: " + nombre + " - Direccion: " + direccion + " - Telefono: " + telefono);
    }

    public boolean esMiCredencial(String credencial) {
        return numCredencial.equals(credencial);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
}
