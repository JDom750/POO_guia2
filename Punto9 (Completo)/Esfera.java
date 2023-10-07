package Punto9;


public class Esfera extends Figura3D {
    public Esfera(int radio) {
        super(radio);
        super.setVolumen(calcularVolumen());
        super.setArea(calcularArea());
    }

    private double calcularArea(){
        return 4 * Math.PI * super.getLado() * super.getLado();
    }

    private double calcularVolumen(){
        return ((double) 4/3) * Math.PI * Math.pow(super.getLado(),3);
    }

    public int getRadio(){
        return super.getLado();
    }
}
