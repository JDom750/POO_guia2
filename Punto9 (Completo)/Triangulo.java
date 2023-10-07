package Punto9;

public class Triangulo extends FiguraGeo{
    private final int altura;
    public Triangulo(int base,int altura) {
        super(base);
        this.altura = altura;
        super.setArea(calcularArea(super.getLado(),this.altura));
    }

    private double calcularArea(int base, int altura){
        return (double) (base * altura) / 2;
    }

    public int getAltura() {
        return altura;
    }

    public int getBase(){
        return super.getLado();
    }
}
