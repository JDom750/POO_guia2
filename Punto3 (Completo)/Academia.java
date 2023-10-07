package Punto3;

import java.util.ArrayList;
import java.util.List;

public class Academia {
    private List<Diagramacion> diagramaciones;
    private List<Profesor> profesores;
    private List<Alumno> alumnos;

    public Academia(){
        this.diagramaciones = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    public void agregarDiagramacion(String disciplina,String salon,String dia,String hora,String nivel,String DNI,String nombre,String telefono){
        Profesor profesor = agregarProfesor(DNI, nombre, telefono);
        Diagramacion d = new Diagramacion(disciplina,salon,dia,hora,nivel,profesor);
        if (!diagramacionSuperpuesta(d)){
            this.diagramaciones.add(d);
            System.out.println("Agregada con éxito");
        }
    }
    public void agregarDiagramacion(String disciplina,String salon,String dia,String hora,String nivel,String DNI){
        Profesor profesor = buscarProfesor(DNI);
        Diagramacion d = new Diagramacion(disciplina,salon,dia,hora,nivel,profesor);
        if (!diagramacionSuperpuesta(d)){
            this.diagramaciones.add(d);
            System.out.println("Agregada con éxito");
        }
    }

    public boolean existeDiagramacion(String nro){
        for (Diagramacion d:this.diagramaciones) {
            if (d.esMiNro(nro)){
                return true;
            }
        }
        return false;
    }

    private Diagramacion buscarDiagramacion(String nro){
        for (Diagramacion d:this.diagramaciones) {
            if (d.esMiNro(nro)){
                return d;
            }
        }
        return null;
    }

    private Profesor buscarProfesor(String DNI){
        for (Profesor p: this.profesores) {
            if (p.esMiDNI(DNI)){
                return p;
            }
        }
        return null;
    }

    public Profesor agregarProfesor(String DNI,String nombre,String telefono){
        Profesor p = new Profesor(DNI,nombre,telefono);
        this.profesores.add(p);
        return p;
    }

    public boolean existeProfesor(String DNI){
        for (Profesor p: this.profesores) {
            if (p.esMiDNI(DNI)){
                return true;
            }
        }
        return false;
    }

    public Alumno agregarAlumno(String nombre, String telefono, String direccion){
        Alumno alumno = new Alumno(nombre,telefono,direccion);
        this.alumnos.add(alumno);
        return alumno;
    }

    public boolean existeAlumno(String credencial){
        for (Alumno a: this.alumnos){
            if (a.esMiCredencial(credencial)){
                return true;
            }
        }
        return false;
    }

    private Alumno buscarAlumno(String credencial){
        for (Alumno a: this.alumnos){
            if (a.esMiCredencial(credencial)){
                return a;
            }
        }
        return null;
    }

    private boolean diagramacionSuperpuesta(Diagramacion diagramacion){
        for (Diagramacion d: this.diagramaciones) {
            if (d.getDia() == diagramacion.getDia() && d.getHora().minusMinutes(1).isBefore(diagramacion.getHora()) && d.getHora().plusHours(1).isAfter(diagramacion.getHora())){
                if (d.getProfesor() == diagramacion.getProfesor()){
                    System.out.println("El profesor en ese horario esta ocupado");
                    return true;
                } else if (d.getSalon().equals(diagramacion.getSalon())){
                    System.out.println("El salon en ese horario esta ocupado");
                    return true;
                }
            }
        }
        return false;
    }

    public void calcularSalarioProfesor(String DNI){
        Profesor p = buscarProfesor(DNI);

        int salario = 0;
        for (Diagramacion d:this.diagramaciones) {
            if (d.getProfesor() == p) {
                salario += d.getCantAsistencias() * 10;
            }
        }

        System.out.println("El salario acumulado para el profesor " + p.getNombre() + " es: " + salario);
    }

    public void agregarAlumnoADiagramacion(String nombre,String telefono,String direccion,String nro) {
        Alumno alumno = agregarAlumno(nombre,telefono,direccion);
        Diagramacion diagramacion = buscarDiagramacion(nro);

        diagramacion.agregarAlumno(alumno);
    }

    public void agregarAlumnoADiagramacion(String credencial,String nro){
        Alumno alumno = buscarAlumno(credencial);
        Diagramacion diagramacion = buscarDiagramacion(nro);

        diagramacion.agregarAlumno(alumno);
    }

    public boolean pasarAsistencia(String credencial,String nroDiagramacion){
        Alumno alumno = buscarAlumno(credencial);
        Diagramacion diagramacion = buscarDiagramacion(nroDiagramacion);

        if (!diagramacion.esMiAlumno(alumno)){
            return false;
        }

        diagramacion.sumarAsistencia();
        return true;
    }

    public void listadoDeDisciplinasPorIngreso(){
        Disciplinas[] disciplinas = todasLasDisciplinas();
        int[] ingresoTotal = new int[disciplinas.length];

        //Calculo de todas las disciplinas
        int i = 0;
        for (Disciplinas d: disciplinas){
            int ingreso = 0;
            for (Diagramacion diagramacion: this.diagramaciones) {
                if (diagramacion.getDisciplina() == d){
                    ingreso += diagramacion.getCantAsistencias();
                }
            }
            ingresoTotal[i] = ingreso;
            i++;
        }



        //Acomodamiento por burbuja
        boolean intercambio = true;
        while (intercambio){
            intercambio = false;
            i = 1;
            while (i < disciplinas.length){
                int auxI;
                Disciplinas auxD;
                if (ingresoTotal[i-1] < ingresoTotal[i]){

                    //Ingresos
                    auxI = ingresoTotal[i-1];
                    ingresoTotal[i-1] = ingresoTotal[i];
                    ingresoTotal[i] = auxI;

                    //Disciplinas
                    auxD = disciplinas[i-1];
                    disciplinas[i-1] = disciplinas[i];
                    disciplinas[i] = auxD;

                    //Activo intercambio
                    intercambio = true;
                }
                i++;
            }
        }

        String nombreDisciplina = "";
        for (i = 0; i < disciplinas.length; i++) {
            switch (disciplinas[i]){
                case TANGO -> {nombreDisciplina = "Tango";}
                case SALSA -> {nombreDisciplina = "Salsa";}
                case BACHATA -> {nombreDisciplina = "Bachata";}
                case CLASICO -> {nombreDisciplina = "Clasico";}
                case STRETCHING -> {nombreDisciplina = "Stretching";}
                case CONTEMPORANEO -> {nombreDisciplina = "Contemporaneo";}
                case ARABE -> {nombreDisciplina = "Arabe";}
            }

            System.out.println("N°" + i + ": " + nombreDisciplina + " - cantidad de Asistencias: " + ingresoTotal[i]);
        }

    }

    private Disciplinas[] todasLasDisciplinas(){
        Disciplinas[] disciplinas = new Disciplinas[7];
        disciplinas[0] = Disciplinas.TANGO;
        disciplinas[1] = Disciplinas.SALSA;
        disciplinas[2] = Disciplinas.BACHATA;
        disciplinas[3] = Disciplinas.CLASICO;
        disciplinas[4] = Disciplinas.STRETCHING;
        disciplinas[5] = Disciplinas.CONTEMPORANEO;
        disciplinas[6] = Disciplinas.ARABE;
        return disciplinas;
    }


    public void mostrarTodo(){ //Hecho solo para el ejercicio, facilita la verificacion de datos

        System.out.println(" ");
        System.out.println("--------------------------DIAGRAMACIONES------------------------------");
        for (Diagramacion d: this.diagramaciones) {
            d.mostrarDiagramacion();
        }

        System.out.println(" ");
        System.out.println("--------------------------PROFESORES------------------------------");
        for (Profesor p: this.profesores){
            p.mostrarProfesor();
        }

        System.out.println(" ");
        System.out.println("--------------------------ALUMNOS------------------------------");
        for (Alumno a: this.alumnos) {
            a.mostrarAlumno();
        }

    }

}
