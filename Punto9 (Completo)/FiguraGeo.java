package Punto9;

public class FiguraGeo {
    private final int lado;

    private double area;

    protected FiguraGeo(int lado) {
        this.lado = lado;
    }

    public double getArea(){
        return area;
    };

    protected int getLado() {
        return lado;
    }

    protected void setArea(double area) {
        this.area = area;
    }
}
