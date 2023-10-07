package Punto1;

import java.time.LocalDate;
import java.util.Random;

public class Socio {
    private String numCredencial = "";
    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final String email;
    private final LocalDate fechaInscripcion;
    private final Suscripcion suscripcion;

    public Socio(String nombre, String direccion, String telefono,String email,String fechaInscripcion, String suscripcion,boolean mostrar){
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaInscripcion = LocalDate.parse(fechaInscripcion);
        this.suscripcion = new Suscripcion(suscripcion);
        String num = "1234567890";
        Random r = new Random();
        for (int i = 0; i < 8 ; i++){
            this.numCredencial = this.numCredencial + num.charAt(r.nextInt(num.length()));
        }
        if (mostrar){
            System.out.println("Num credencial: " + this.numCredencial);
        }
    }

    public void mostrarActividades(){
        suscripcion.MostrarListadeActividades();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getSuscripcion() {
        switch (suscripcion.getSuscripcion()) {
            case BASICA -> {
                return "Basica";
            }
            case INTERMEDIA -> {
                return "Intermedia";
            }
            case DESTACADA -> {
                return "Destacada";
            }
            default -> {
                return "Error";
            }
        }
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public boolean esMiCredencial(String credencial){
        return this.numCredencial.equals(credencial);
    }
}
