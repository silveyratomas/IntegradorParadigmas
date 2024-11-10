package TrabajoIntegrador;

import java.util.ArrayList;
import java.util.List;

public class Complejo {
    private List<Cabana> cabanas = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public void registrarCabana(Cabana cabana) {
        cabanas.add(cabana);
    }

    public List<Cabana> getCabanasDisponibles() {
        return cabanas;
    }

    public void registrarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorDni(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Reserva> getReservasDeCliente(String dni) {
        List<Reserva> reservasCliente = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getDni().equals(dni)) {
                reservasCliente.add(reserva);
            }
        }
        return reservasCliente;
    }
    

    
    
}
