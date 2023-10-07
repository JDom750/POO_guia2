package Punto9;

public class Figura3D extends FiguraGeo{
    private double volumen;

    protected Figura3D(int lado) {
        super(lado);
    }

    public double getVolumen() {
        return volumen;
    }

    protected void setVolumen(double volumen) {
        this.volumen = volumen;
    }
}
