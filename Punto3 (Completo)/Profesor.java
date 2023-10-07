package Punto3;

public class Profesor {
    private String DNI;
    private String nombre;
    private String telefono;

    public Profesor(String DNI,String nombre,String telefono){
        this.DNI = DNI;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void mostrarProfesor() {
        System.out.println(DNI + " | Nombre: " + nombre + " - Telefono: " + telefono);
    }
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean esMiDNI(String DNI){
        return this.DNI.equals(DNI);
    }

}
