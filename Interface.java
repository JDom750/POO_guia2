import Punto1.Club;
import Punto2.Agencia;
import Punto3.Academia;
import Punto9.*;

import java.util.Scanner;

public class Interface {

    //Punto 1 Club de Fútbol
    public void interfaceFutbol(){
        Scanner sc = new Scanner(System.in);
        Club c = new Club();
        int eleccion = -1;


        //Agregado por defecto;
        c.agregarSocio("Lorenzo el Marciano", "Bomberos Voluntarios 39","01110203040","elsaltamontes@gmail.com","1999-09-12","basica");
        c.agregarSocio("La Vaca Lola", "Independencia 123","01112253741","Chuleta@gmail.com","2023-09-12","intermedia");
        c.agregarSocio("Juan Jose de San Martin", "Bernardo Yrigoyen 385","01172358901","JamonCrudo@gmail.com","2021-12-25","destacada");

        while (eleccion!=0) {

            System.out.println(" ");
            System.out.println("--- Prueba de punto 1 Club de Futbol ---");
            System.out.println("--- Agregado por defecto 3 socios (Lorenzo el marciano, La Vaca Lola, Juan Jose de San Martin)");
            System.out.println("1 - Agregar Socio");
            System.out.println("2 - Mostrar listado de Socios Mensual");
            System.out.println("3 - Mostrar listado de Socios por Suscripcion");
            System.out.println("4 - Mostrar listado de Actividades por Suscripcion");
            System.out.println("5 - Buscar Socio por Credencial");
            System.out.println("0 - Salir");
            System.out.println("Qué desea realizar con el Club?");
            eleccion = sc.nextInt();
            sc.nextLine();

            if (eleccion == 1) {

                System.out.println("Nombre Completo: ");
                String nombre = sc.nextLine();
                System.out.println("Dirección: ");
                String direccion = sc.nextLine();
                System.out.println("Teléfono: ");
                String telefono = sc.nextLine();
                System.out.println("Email: ");
                String email = sc.nextLine();
                System.out.println("Fecha de inscripción (respetar formato yyyy-mm-dd, ejemplo: 1999-02-01): ");
                String fecha = sc.nextLine();
                System.out.println("Tipo de Suscripción: ");
                String suscripcion = sc.nextLine();
                c.agregarSocio(nombre,direccion,telefono,email,fecha,suscripcion);

            } else if (eleccion == 2) {

                c.mostrarListadoMensualSocios();

            } else if (eleccion == 3) {

                c.mostrarInscriptosPorSuscripcion();

            } else if (eleccion == 4) {

                c.mostrarListadoActividades();

            } else if (eleccion == 5){

                System.out.println("Dime la credencial del Socio: ");
                String credencial = sc.nextLine();
                c.buscarPorCredencial(credencial);

            }

                System.out.println(" ");
            System.out.println("--------- Pausa (enter) ----------");
            Object pausa = sc.nextLine();
        }
    }

    //Punto 2 Agencia de Turismo
    public void interfaceTurismo(){
        Scanner sc = new Scanner(System.in);
        Agencia a = new Agencia();
        int eleccion = -1;

        //-----------------------Agregado por defecto-----------------------;
        //



    }



    //Punto 3 Academia de danzas
    public void interfaceDanzas(){
        Scanner sc = new Scanner(System.in);
        Academia a = new Academia();
        int eleccion = -1;


        //-----------------------Agregado por defecto-----------------------;
        //Profesores
        a.agregarProfesor("38678932","Fernando Alonso","01114325678");
        a.agregarProfesor("34511562","Malena Oriva","01114325678");
        a.agregarProfesor("40734691","Hernan Piquin","01178921001");

        //Diagramas (1 por cada Disciplina)
        a.agregarDiagramacion("tango","20","lunes","10:30","inicial","38678932");
        a.agregarDiagramacion("salsa","12","martes","20:00","intermedio","34511562");
        a.agregarDiagramacion("bachata","10","miercoles","15:00","avanzado","40734691");
        a.agregarDiagramacion("clasico","30","jueves","08:30","avanzado","40734691");
        a.agregarDiagramacion("stretching","15","viernes","16:30","incial","40734691");
        a.agregarDiagramacion("contemporaneo","25","sabado","18:00","inicial","38678932");
        a.agregarDiagramacion("arabe","28","domingo","17:30","intermedio","40734691");

        //Alumnos
        a.agregarAlumno("Florencia Esposito","01127839180","Avenida Siempreviva 345");
        a.agregarAlumno("Facundo Schwab","01187534210","Caballito 240");
        a.agregarAlumno("Libertad Gimenez","01193684782","Alfonsin 901");
        a.agregarAlumno("Nahuel Benni","01178956721","Licor 301");
        a.agregarAlumno("Marco Polo","01156328913","Avenida España 234");
        a.agregarAlumno("Chapulin Colorado","01158923401","Chanfle 703");
        a.agregarAlumno("Steven Universe","01196789090","Garnet 580");
        a.agregarAlumno("Perla Amatista","01186223156","El Sol 764");

        System.out.println(" ");
        System.out.println("--- Agregado por defecto 3 Profesores (DNIs: '38678932' - '34511562' - '40734691')----");
        System.out.println("--- Agregado por defecto 7 Diagramas (1 por cada disciplina) ------");
        System.out.println("--- Agregado por defecto 8 Alumnos (NO estan incluidos en ningun diagrama) ----");
        System.out.println("--- Utilizar mostrar todos los datos para facilitar el uso y ver Nro de diagrama / credenciales de Alumnos ----");
        System.out.println("------------------------------------------------------------------------------");


        while (eleccion!=0) {

            System.out.println(" ");
            System.out.println("--- Prueba de punto 3 Academia de Danzas ---");
            System.out.println("1 - Agregar Diagramacion");
            System.out.println("2 - Agregar Profesor");
            System.out.println("3 - Agregar un Alumno a una Diagramacion");
            System.out.println("4 - Sumar asistencia a una diagramacion");
            System.out.println("5 - Calcular salario a un profesor");
            System.out.println("6 - Mostrar listado de ingresos por disciplina");
            System.out.println("7 - Mostrar todos los datos (Solo hecho para verificacion en este ejercicio)");
            System.out.println("0 - Salir");
            System.out.println("Qué desea realizar con la Academia de Danza?");
            eleccion = sc.nextInt();
            sc.nextLine();

            if (eleccion == 1) {

                System.out.println("Dime la disciplina que quieres dictar: ");
                String disciplina = sc.nextLine();
                System.out.println("Dime el salon en el que van a dar clases: ");
                String salon = sc.nextLine();
                System.out.println("Dia en que van a dar clases: ");
                String dia = sc.nextLine();
                System.out.println("Horario (formato hh:mm): ");
                String hora = sc.nextLine();
                System.out.println("Nivel de la disciplina: ");
                String nivel = sc.nextLine();
                System.out.println("DNI del profesor a cargo: ");
                String DNI = sc.nextLine();

                if (a.existeProfesor(DNI)){
                    a.agregarDiagramacion(disciplina,salon,dia,hora,nivel,DNI);
                } else {
                    System.out.println("Profesor no encontrado dime sus datos: ");
                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Telefono: ");
                    String telefono = sc.nextLine();
                    a.agregarDiagramacion(disciplina,salon,dia,hora,nivel,DNI,nombre,telefono);
                }


            } else if (eleccion == 2) {

                System.out.println("DNI del profesor: ");
                String DNI = sc.nextLine();
                if (!a.existeProfesor(DNI)){
                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Telefono: ");
                    String telefono = sc.nextLine();
                    a.agregarProfesor(DNI,nombre,telefono);
                } else {
                    System.out.println("El profesor ya esta incluido en el Listado de profesores");
                }

            } else if (eleccion == 3) {

                System.out.println("Nro de diagrama para agregar Alumno: ");
                String nroD = sc.nextLine();
                if (a.existeDiagramacion(nroD)) {
                    System.out.println("Es un alumno nuevo? (S/N)");
                    String nuevo = sc.nextLine();
                    if (nuevo.equals("s") || nuevo.equals("S")) {

                        System.out.println("Nombre del alumno nuevo: ");
                        String nombre = sc.nextLine();
                        System.out.println("Teléfono: ");
                        String telefono = sc.nextLine();
                        System.out.println("Dirección: ");
                        String direccion = sc.nextLine();

                        a.agregarAlumnoADiagramacion(nombre, telefono, direccion,nroD);
                    } else {

                        System.out.println("Credencial del alumno: ");
                        String credencial = sc.nextLine();
                        if(a.existeAlumno(credencial)) {
                            a.agregarAlumnoADiagramacion(credencial, nroD);
                        } else {
                            System.out.println("El alumno no existe");
                        }
                    }
                } else {
                    System.out.println("La diagramacion no existe");
                }


            } else if (eleccion == 4) {

                System.out.println("Dime la diagramacion: ");
                String nroD = sc.nextLine();
                if (a.existeDiagramacion(nroD)) {
                    System.out.println("Dime la credencial del alumno: ");
                    String credencial = sc.nextLine();
                    if (a.existeAlumno(credencial)){
                        if (a.pasarAsistencia(credencial,nroD)){
                            System.out.println("Sumada la asistencia correctamente");
                        } else {
                            System.out.println("El alumno no esta incluido en la diagramación");
                        }

                    } else {
                        System.out.println("El alumno no existe");
                    }
                } else {
                    System.out.println("La diagramacion no existe");
                }

            } else if (eleccion == 5){

                System.out.println("Dime el DNI del profesor para calcular el salario: ");
                String DNI = sc.nextLine();
                if (a.existeProfesor(DNI)){
                    a.calcularSalarioProfesor(DNI);
                } else {
                    System.out.println("El profesor no existe");
                }

            } else if (eleccion == 6){

                a.listadoDeDisciplinasPorIngreso();

            } else if (eleccion == 7){

                a.mostrarTodo();

            }

            System.out.println(" ");
            System.out.println("--------- Pausa (enter) ----------");
            Object pausa = sc.nextLine();
        }
    }



    //Punto 9 Figuras geométricas 2D y 3D
    public void interfaceFiguras(){
        Scanner sc = new Scanner(System.in);
        //Prueba automatica

        //Figuras 2D -----------------
        System.out.println("---------------------------------------");
        System.out.println(" ");
        System.out.println("Demostración de Figuras 2D");
        System.out.println(" ");

        //Cuadrado
        Cuadrado cuadrado = new Cuadrado(4);
        System.out.println("Cuardrado de lados valor: " + cuadrado.getLado());
        System.out.println("Área = " + cuadrado.getArea());
        System.out.println(" ");

        //Círculo
        System.out.println("---------------------------------------");
        Circulo circulo = new Circulo(4);
        System.out.println("Círculo de radio valor: " + circulo.getRadio());
        System.out.println("Área = " + circulo.getArea());
        System.out.println(" ");

        //Triangulo
        System.out.println("---------------------------------------");
        Triangulo triangulo = new Triangulo(4,2);
        System.out.println("Triángulo de altura: " + triangulo.getAltura() + " y base: " + triangulo.getBase());
        System.out.println("Área = " + triangulo.getArea());
        System.out.println(" ");

        //Rectangulo
        System.out.println("---------------------------------------");
        Rectangulo rectangulo = new Rectangulo(4,2);
        System.out.println("Rectángulo de base: " + rectangulo.getBase() + " y altura: " + rectangulo.getAltura());
        System.out.println("Área = " + rectangulo.getArea());
        System.out.println(" ");


        //Figuras 3D --------------------------------------
        System.out.println("---------------------------------------");
        System.out.println("Demostración de Figuras 3D");
        System.out.println(" ");

        //Cubo
        Cubo cubo = new Cubo(4);
        System.out.println("Cubo de aristas: " + cubo.getArista());
        System.out.println("Área = " + cubo.getArea());
        System.out.println("Volumen = " + cubo.getVolumen());
        System.out.println(" ");

        //Esfera
        System.out.println("---------------------------------------");
        Esfera esfera = new Esfera(4);
        System.out.println("Esfera de radio: " + esfera.getRadio());
        System.out.println("Área = " + esfera.getArea());
        System.out.println("Volumen = " + esfera.getVolumen());
        System.out.println(" ");

        //Parlelepipedo
        System.out.println("---------------------------------------");
        Paralelepipedo paralelepipedo = new Paralelepipedo(4,2,3);
        System.out.println("Paralelepipedo de aristas: " + paralelepipedo.getArista1() + ", "
                + paralelepipedo.getArista2() + ", " + paralelepipedo.getArista3());
        System.out.println("Área = " + paralelepipedo.getArea());
        System.out.println("Volumen = " + paralelepipedo.getVolumen());
        System.out.println(" ");

        //Tetraedro
        System.out.println("---------------------------------------");
        Tetraedro tetraedro = new Tetraedro(4);
        System.out.println("Tetraedro de aristas: " + tetraedro.getArista());
        System.out.println("Área = " + tetraedro.getArea());
        System.out.println("Volumen = " + tetraedro.getVolumen());
        System.out.println(" ");


        System.out.println("--------- Pausa (enter) ----------");
        Object pausa = sc.nextLine();
    }
}
