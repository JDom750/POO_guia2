package Punto2;

import java.util.List;

public class PackTurismo {
    private final String nroPack;
    private final String destino;
    private final Hospedaje hospedaje;
    private final Transporte transporte;
    private final List<Excursion> excursiones;
    private int valor ;

    public PackTurismo(String nroPack,String destino,Hospedaje hospedaje,Transporte transporte,List<Excursion> excursiones,int valor){
        this.nroPack = nroPack; //Deberia ser autogenerado como ID
        this.destino = destino;
        this.hospedaje = hospedaje;
        this.transporte = transporte;
        this.excursiones = excursiones;
        this.valor = valor;
    }

    public void mostrarPack(){
        System.out.println("                 ----°----                    ");
        System.out.println(nroPack + ": Destino " + destino);
        System.out.println("Transporte :" + transporte.mostrarDatos());
        System.out.println("Hospedaje: " + hospedaje.mostrarDatos());
        System.out.println("Valor: " + valor + " Dolares ");
        System.out.println("Excursiones: ");
        int i = 1;
        for (Excursion e:this.excursiones) {
            System.out.println(i + " --- " + e.mostrarDatos());
        }
        System.out.println("                 ----°----                    ");
    }

    public boolean esMiNro(String Nro){
        return this.nroPack.equals(Nro);
    }

    public int getValor() {
        return valor;
    }

    public String getNroPack() {
        return nroPack;
    }

    public String getDestino() {
        return destino;
    }
}
