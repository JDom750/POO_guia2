package Punto2;

public class Transporte {
    private String IDProveedor;
    private String nombre;
    private TipoTransporte transporte;


    public Transporte(String IDProveedor, String nombre, String transporte) {
        this.IDProveedor = IDProveedor;
        this.nombre = nombre;
        this.transporte = convertirTransporte(transporte);
    }

    private TipoTransporte convertirTransporte(String transporte){
        return switch (transporte){
            case "aerea","aérea","Aerea","Aérea" -> TipoTransporte.AEREA;
            case "maritima","marítima","Maritima","Marítima" -> TipoTransporte.MARITIMA;
            default -> TipoTransporte.TERRESTRE;
        };
    }

    public String mostrarDatos(){
        String transporte;
        switch (this.transporte){
            case AEREA -> {transporte = "Aérea";}
            case MARITIMA -> {transporte = "Marítima";}
            default -> {transporte = "Terrestre";}
        }
        return IDProveedor + " |Companía " + this.nombre + " de transporte tipo: " + transporte;
    }

    public boolean esMiID(String ID){
        return this.IDProveedor.equals(ID);
    }
}
