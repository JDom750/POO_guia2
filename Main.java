import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int eleccion = -1;
        while (eleccion != 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("1 - Para punto 1 Club de Futbol");
            System.out.println("2 - Para punto 2 Agencia Turismo");
            System.out.println("3 - Para punto 3 Academia de Danzas");
            System.out.println("4 - Para punto 4,5 Billeteras virtuales");
            System.out.println("5 - Para punto 6,7 Estacion de Servicio");
            System.out.println("6 - Para punto 8 Libros");
            System.out.println("7 - Para punto 9 Figuras geometricas 2D y 3D");
            System.out.println("8 - Para punto 10 Sueldos de empleados");
            System.out.println("9 - Para punto 11 Renta de automoviles");
            System.out.println("10- Para punto 12 Billeteras Virtuales con herencia");
            System.out.println("11- Para punto 13 Sistema de vuelo");
            System.out.println("12- Para punto 14 Agencia de turismo con herencia");
            System.out.println("0 - Para Salir ");
            System.out.println("Que punto desea probar?");
            eleccion = sc.nextInt();
            Interface I = new Interface();

            if (eleccion == 1){
                I.interfaceFutbol();
            } else if (eleccion == 2){
                I.interfaceTurismo();
            } else if (eleccion == 3){
                I.interfaceDanzas();
            } else if (eleccion == 4){

            } else if (eleccion == 5){

            } else if (eleccion == 6){

            } else if (eleccion == 7){
                I.interfaceFiguras();
            } else if (eleccion == 8){

            } else if (eleccion == 9){

            } else if (eleccion == 10){

            }

        }
    }
}