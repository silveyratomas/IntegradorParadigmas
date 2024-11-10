package TrabajoIntegrador;

import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Cabana cabana;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(Cliente cliente, Cabana cabana, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.cabana = cabana;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Cabana getCabana() {
        return cabana;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public double calcularCostoTotal() {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        return cabana.getPrecioBase() * dias;
    }
}
