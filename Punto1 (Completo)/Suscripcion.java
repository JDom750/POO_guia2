package Punto1;

import static Punto1.TipoSuscripcion.*;

public class Suscripcion {

    private final TipoSuscripcion suscripcion;

    public Suscripcion(String suscripcion){
        if (suscripcion.equals("destacada")){
            this.suscripcion = DESTACADA;
        } else if (suscripcion.equals("intermedia")){
            this.suscripcion = TipoSuscripcion.INTERMEDIA;
        } else {
            this.suscripcion = TipoSuscripcion.BASICA;
        }

    }

    public void MostrarListadeActividades(){
        System.out.println("-----------------------------------------------------------------------------------------");
        if (this.suscripcion == DESTACADA) {
            System.out.println("Ingreso directo al Gym sin solicitud previa (SOCIO DESTACADO)");
            System.out.println("Uso de salones para Fiestas con buffet incluido (SOCIO DESTACADO)");
            System.out.println("Entrada abierta y gratuita a ver partidos,entrenamientos y todo tipo de actividades hechos en el club (SOCIO DESTACADO)");
            System.out.println("Descuentos en locales adheridos a nuestra inscripcion (SOCIO DESTACADO)");
            System.out.println("Sacarse una foto con Messi y pedirle un autografo (SOCIO DESTACADO)");
            System.out.println("Todas las actividades de suscripciones menores");
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        if ((this.suscripcion == DESTACADA)||(this.suscripcion == INTERMEDIA)){
            System.out.println("Muchas cosas que no se me ocurren en este momento :) (SOCIO INTERMEDIO)");
            System.out.println("Suscripcion gratuita a todos nuestros subclubes de deportes para entrenamiento profesional (bascket, handball, voley, hockey, ect.) (SOCIO INTERMEDIO)");
            System.out.println("Uso gratuito del sector piscinas con sector VIP y profesor de natacion (SOCIO INTERMEDIO)");
            System.out.println("Sacarse una foto con Messi (SOCIO INTERMEDIO)");
            System.out.println("Todas las actividades de suscripciones menores");
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        if ((this.suscripcion == DESTACADA)||(this.suscripcion == INTERMEDIA)||(this.suscripcion == BASICA)){
            System.out.println("Uso de salones para fiestas (SOCIO BÁSICO)");
            System.out.println("Uso gratuito del sector piscinas sin sector VIP (SOCIO BÁSICO)");
            System.out.println("Ingreso al Gym con solicitud previa (SOCIO BÁSICO)");
            System.out.println("Uso gratuito de nuestras canchas y sectores de deportes (SOCIO BÁSICO)");
            System.out.println("Uso gratuito de sectores de recreación para niños (SOCIO BÁSICO)");
        }
    }

    public TipoSuscripcion getSuscripcion() {
        return suscripcion;
    }

}
