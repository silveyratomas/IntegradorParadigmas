package TrabajoIntegrador;

public class Cabana {
    private int id;
    private String tipo;
    private double precioBase;

    public Cabana(int id, String tipo, double precioBase) {
        this.id = id;
        this.tipo = tipo;
        this.precioBase = precioBase;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}
