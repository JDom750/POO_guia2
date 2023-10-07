package Punto2;

public class Cliente {
    private String DNI;
    private String nombre;
    private String telefono;
    private int compras;

    public Cliente(String DNI, String nombre, String telefono) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.telefono = telefono;
        this.compras = 1;
    }

    public String mostrarDatos(){
        return DNI + "| Nombre: " + nombre + " - Teléfono: " + telefono + " - Compras realizadas: " + compras;
    }

    public boolean esMiDNI(String DNI){
        return this.DNI.equals(DNI);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getCompras() {
        return compras;
    }

    public void sumarCompra() {
        this.compras +=  1;
    }
}
