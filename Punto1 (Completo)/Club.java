package Punto1;

import java.time.LocalDate;

public class Club {

    private final Socio[] sociosBasicos;
    private int cantBasicos;
    private final Socio[] sociosIntermedios;
    private int cantIntermedios;
    private final Socio[] sociosDestacados;
    private int cantDestacados;
    private final Socio[] listadoSocios;
    private int cantSocios;

    public Club(){
        this.sociosDestacados = new Socio[20];
        this.cantDestacados = 0;
        this.sociosIntermedios = new Socio[20];
        this.cantIntermedios = 0;
        this.sociosBasicos = new Socio[20];
        this.cantBasicos = 0;
        this.listadoSocios = new Socio[60];
        this.cantSocios = 0;
    }

    public void mostrarListadoActividades(){
        Socio s = new Socio(" "," "," "," ","1999-11-15","destacada",false);
        s.mostrarActividades();
    }

    public void agregarSocio(String nombre, String direccion, String telefono,String email,String fechaInscripcion, String suscripcion){
        Socio s = new Socio(nombre,direccion,telefono,email,fechaInscripcion,suscripcion,true);
        if (suscripcion.equals("destacada")){
            sociosDestacados[cantDestacados] = s;
            cantDestacados++;
        } else if (suscripcion.equals("intermedia")){
            sociosIntermedios[cantIntermedios] = s;
            cantIntermedios++;
        } else {
            sociosBasicos[cantBasicos] = s;
            cantBasicos++;
        }
        this.listadoSocios[cantSocios] = s;
        this.cantSocios++;
    }

    public void mostrarInscriptosPorSuscripcion(){
        System.out.println("SOCIOS DESTACADOS");
        for (Socio s: sociosDestacados){
            if (s != null){
                System.out.println("Socio: " + s.getNombre() + " - Email: " + s.getEmail());
            }
        }

        System.out.println("--------------------------");
        System.out.println("SOCIOS INTERMEDIOS");
        for (Socio s: sociosIntermedios){
            if (s != null){
                System.out.println("Socio: " + s.getNombre() + " - Email: " + s.getEmail());
            }
        }

        System.out.println("--------------------------");
        System.out.println("SOCIOS BASICOS");
        for (Socio s: sociosBasicos){
            if (s != null){
                System.out.println("Socio: " + s.getNombre() + " - Email: " + s.getEmail());
            }
        }
    }

    public void mostrarListadoMensualSocios(){
        LocalDate hoy = LocalDate.now();

        System.out.println("Listado del mes " + hoy.getMonth() + ": ");
        for (Socio s: listadoSocios){
            if (s != null){
                if (hoy.getMonthValue() == s.getFechaInscripcion().getMonthValue() && hoy.getYear() == s.getFechaInscripcion().getYear()) {
                    System.out.println("Socio: " + s.getNombre() + " - Email: " + s.getEmail() + " - Suscripción tipo: " + s.getSuscripcion() + " - Fecha: " + s.getFechaInscripcion());
                }
            }
        }
    }

    public void buscarPorCredencial(String credencial){
        boolean existe = false;
        for (Socio s: listadoSocios){
            if (s != null){
                if (s.esMiCredencial(credencial)){
                    System.out.println("Socio: " + s.getNombre() + " - Email: " + s.getEmail() + "Suscripcion tipo: " + s.getSuscripcion());
                    existe = true;
                }
            }
        }
        if (!existe){
            System.out.println("No se encuentra incluido como Socio");
        }
    }
}
