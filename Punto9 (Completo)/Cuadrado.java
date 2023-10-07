package Punto9;

public class Cuadrado extends FiguraGeo {
    public Cuadrado(int lado) {
        super(lado);
        super.setArea(calcularArea());
    }

    private double calcularArea(){
        return super.getLado() * super.getLado();
    };

    public int getLado(){
        return super.getLado();
    };


}
