package TrabajoIntegrador;

public class Main {
    public static void main(String[] args) {
        Complejo complejo = new Complejo();
        Empleado empleado = new Empleado(complejo);
        empleado.mostrarMenu();
    }
}
