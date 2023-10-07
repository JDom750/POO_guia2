package Punto2;

public class Hospedaje {
        private String IDProveedor;
        private String nombre;
        private TipoHospedaje hospedaje;

        public Hospedaje(String IDProveedor, String nombre, String hospedaje) {
                this.IDProveedor = IDProveedor;
                this.nombre = nombre;
                this.hospedaje = convertirHospedaje(hospedaje);
        }

        private TipoHospedaje convertirHospedaje(String hospedaje){
                return switch (hospedaje){
                        case "Hotel","hotel" -> TipoHospedaje.HOTEL;
                        case "Hosteria","Hostería","hosteria","hostería" -> TipoHospedaje.HOSTERIA;
                        default -> TipoHospedaje.BUNGALO;
                };
        }

        public String mostrarDatos(){
                String hospedaje;
                switch (this.hospedaje){
                        case HOTEL -> {hospedaje = "Hotel";}
                        case HOSTERIA -> {hospedaje = "Hostería";}
                        default -> {hospedaje = "Búngalo";}
                }
                return IDProveedor + " |Companía " + this.nombre + " de hospedaje tipo: " + hospedaje;
        }

        public boolean esMiID(String ID){
                return this.IDProveedor.equals(ID);
        }
}
