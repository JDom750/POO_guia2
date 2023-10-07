package Punto9;

public class Tetraedro extends Figura3D{

    public Tetraedro(int arista) {
        super(arista);
        super.setArea(calcularArea());
        super.setVolumen(calcularVolumen());
    }

    private double calcularArea(){
        return Math.pow(super.getLado(),2) * Math.sqrt(3);
    }

    private double calcularVolumen(){
        return  Math.pow(super.getLado(),3) * Math.sqrt(2) / 12;
    }

    public int getArista(){
        return super.getLado();
    }

}
