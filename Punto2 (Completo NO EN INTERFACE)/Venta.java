package Punto2;

import java.time.LocalDate;

public class Venta {
    private PackTurismo packComprado;
    private Cliente cliente;
    private LocalDate fecha;
    private int monto;

    public Venta(PackTurismo packComprado, Cliente cliente, String fecha, int monto) {
        this.packComprado = packComprado;
        this.cliente = cliente;
        this.fecha = LocalDate.parse(fecha);
        this.monto = monto;
    }

    public String mostrarDatos(){
        return "Nro pack vendido: " + packComprado.getNroPack() + " con destino a " + packComprado.getDestino() + "\n" +
                "Fecha: " + fecha + " - Monto: " + monto + "\n" +
                "Cliente: " + cliente.getNombre() + " (Nombre) - " + cliente.getTelefono() + "(Télefono)";
    }

    public PackTurismo getPackComprado() {
        return packComprado;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
