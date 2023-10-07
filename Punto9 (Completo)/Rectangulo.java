package Punto9;

public class Rectangulo extends Triangulo{
    public Rectangulo(int base,int altura) {
        super(base,altura);
        super.setArea(calcularArea(super.getBase(),super.getAltura()));
    }
    private double calcularArea(int base, int altura){
        return (double) (base * altura);
    }

}
