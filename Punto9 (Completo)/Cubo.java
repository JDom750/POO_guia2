package Punto9;

public class Cubo extends Figura3D {
    public Cubo(int arista) {
        super(arista);
        super.setArea(calcularArea());
        super.setVolumen(calcularVolumen());
    }

    private double calcularArea(){
        return 6 * super.getLado() * super.getLado();
    }

    private double calcularVolumen(){
        return Math.pow(super.getLado(),3);
    }

    public int getArista(){
        return super.getLado();
    }
}
