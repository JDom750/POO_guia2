package Punto2;

public class Excursion {
    private String IDProveedor;
    private String guiaExcursion;
    private String excursion;

    public Excursion(String IDProveedor,String guiaExcursion,String excursion){
        this.IDProveedor = IDProveedor; // ID que deberia se autogenerado e irrepetible
        this.guiaExcursion = guiaExcursion;
        this.excursion = excursion;
    }

    public String mostrarDatos() {
        return IDProveedor + " |Guia: "+ guiaExcursion + " - Excursion: " + excursion;
    }

    public boolean esMiID(String ID){
        return this.IDProveedor.equals(ID);
    }
}
