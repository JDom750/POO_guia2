package Punto9;

public class Paralelepipedo extends Figura3D{
    private final int arista3;
    private final int arista2;

    public Paralelepipedo(int arista1,int arista2,int arista3) {
        super(arista1);
        this.arista2 = arista2;
        this.arista3 = arista3;
        super.setArea(calcularArea());
        super.setVolumen(calcularVolumen());
    }

    private double calcularArea(){
        return 2 * (super.getLado() * arista2 + super.getLado() * arista3 + arista2 * arista3);
    }

    private double calcularVolumen(){
        return super.getLado() * arista2 * arista3;
    }

    public int getArista1() {
        return super.getLado();
    }
    public int getArista3() {
        return arista3;
    }

    public int getArista2() {
        return arista2;
    }
}
