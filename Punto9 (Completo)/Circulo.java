package Punto9;


public class Circulo extends FiguraGeo {

    public Circulo(int radio) {
        super(radio);
        super.setArea(calcularArea());
    }

    private double calcularArea(){
        return (super.getLado() * super.getLado()) * Math.PI;
    };

    public int getRadio(){
        return super.getLado();
    };
}
