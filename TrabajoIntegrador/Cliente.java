package TrabajoIntegrador;
public class Cliente {
    private String nombre;
    private String email;
    private String dni;

    public Cliente(String nombre, String email, String dni) {
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }
}
