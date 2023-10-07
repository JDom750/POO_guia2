package Punto3;

import java.time.LocalTime;
import java.util.Random;

public class Diagramacion {
    private String nroDiagramacion;
    private Disciplinas disciplina;
    private String salon;
    private Dias dia;
    private LocalTime hora;
    private String nivel;
    private Profesor profesor;
    private int cantAsistencias;
    private Alumno[] alumnos;
    private int cantAlumnos;

    public Diagramacion(String disciplina, String salon, String dia, String hora, String nivel,Profesor profesor) {
        this.disciplina = convertirDisciplina(disciplina);
        this.salon = salon;
        this.dia = convertirDia(dia);
        this.hora = LocalTime.parse(hora);
        this.nivel = nivel;
        this.profesor = profesor;
        this.cantAsistencias = 0;
        this.alumnos = new Alumno[50];
        this.cantAlumnos = 0;

        this.nroDiagramacion = "";
        Random r = new Random();
        String num = "0123456789";
        for (int i = 0; i < 3; i++) {
            this.nroDiagramacion = this.nroDiagramacion + num.charAt(r.nextInt(num.length()));
        }
    }

    private Dias convertirDia(String dia){
        return switch (dia) {
            case "lunes", "Lunes" -> Dias.LUNES;
            case "martes", "Martes" -> Dias.MARTES;
            case "miercoles", "Miercoles" -> Dias.MIERCOLES;
            case "jueves", "Jueves" -> Dias.JUEVES;
            case "viernes", "Viernes" -> Dias.VIERNES;
            case "sabado", "Sabado" -> Dias.SABADOS;
            default -> Dias.DOMINGOS;
        };
    }

    private Disciplinas convertirDisciplina(String disciplina){
        return switch (disciplina) {
            case "tango", "Tango" -> Disciplinas.TANGO;
            case "salsa", "Salsa" -> Disciplinas.SALSA;
            case "bachata", "Bachata" -> Disciplinas.BACHATA;
            case "clasico", "Clasico" -> Disciplinas.CLASICO;
            case "Stretching", "stretching" -> Disciplinas.STRETCHING;
            case "Contemporaneo", "contemporaneo" -> Disciplinas.CONTEMPORANEO;
            default -> Disciplinas.ARABE;
        };
    };

    public void agregarAlumno(Alumno alumno){
        this.alumnos[cantAlumnos] = alumno;
        cantAlumnos++;
    }

    public void mostrarDiagramacion(){
        String disciplina = "";
        String dia = "";

        switch (this.dia){
            case LUNES -> {dia = "lunes";}
            case MARTES -> {dia = "martes";}
            case MIERCOLES -> {dia = "miercoles";}
            case JUEVES -> {dia = "jueves";}
            case VIERNES -> {dia = "viernes";}
            case SABADOS -> {dia = "sabados";}
            case DOMINGOS -> {dia = "domingos";}
        }

        switch (this.disciplina){
            case TANGO -> {disciplina = "Tango";}
            case SALSA -> {disciplina = "Salsa";}
            case BACHATA -> {disciplina = "Bachata";}
            case CLASICO -> {disciplina = "Clasico";}
            case STRETCHING -> {disciplina = "Stretching";}
            case CONTEMPORANEO -> {disciplina = "Contemporaneo";}
            case ARABE -> {disciplina = "Arabe";}
        }
        System.out.println("Nro " + this.nroDiagramacion + ": la disciplina "
                + disciplina + ", se dicta los dias " + dia +
                ", su horario comienza a las " + this.hora + ", en el salon " +
                this.salon + " a cargo del profesor: " + profesor.getNombre() +
                " y se comprende en el nivel: " + this.nivel);
    }

    public boolean esMiAlumno(Alumno alumno){
        for (Alumno a:this.alumnos){
            if (a == alumno){
                return true;
            }
        }
        return false;
    }

    public boolean esMiNro(String nro){
        return this.nroDiagramacion.equals(nro);
    }

    public Profesor getProfesor() {
        return profesor;
    }
    public void sumarAsistencia() {
        cantAsistencias++;
    }
    public int getCantAsistencias() {
        return cantAsistencias;
    }
    public String getSalon() {
        return salon;
    }
    public Dias getDia() {
        return dia;
    }
    public LocalTime getHora() {
        return hora;
    }
    public Disciplinas getDisciplina() {
        return disciplina;
    }
}
