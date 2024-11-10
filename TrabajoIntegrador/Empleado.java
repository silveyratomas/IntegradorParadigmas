package TrabajoIntegrador;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Empleado {
    private Complejo complejo;

    public Empleado(Complejo complejo) {
        this.complejo = complejo;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Registrar cliente");
            System.out.println("2. Crear reserva");
            System.out.println("3. Listar cabañas disponibles");
            System.out.println("4. Mostrar reservas de un cliente");
            System.out.println("5. Registrar cabaña");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerNumeroEntero(scanner);

            switch (opcion) {
                case 1:
                    registrarCliente(scanner);
                    break;
                case 2:
                    crearReserva(scanner);
                    break;
                case 3:
                    listarCabanasDisponibles();
                    break;
                case 4:
                    mostrarReservasDeCliente(scanner);
                    break;
                case 5:
                    registrarCabana(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private int leerNumeroEntero(Scanner scanner) {
        int numero = -1;
        while (true) {
            try {
                numero = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Error: Ingrese un número válido: ");
            }
        }
        return numero;
    }

    private void registrarCliente(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el email del cliente: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese el DNI del cliente: ");
        String dni = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, email, dni);
        complejo.registrarCliente(cliente);
        System.out.println("Cliente registrado: " + cliente.getNombre());
    }

    private void crearReserva(Scanner scanner) {
        System.out.print("Ingrese el DNI del cliente: ");
        String dniCliente = scanner.nextLine();
        Cliente cliente = complejo.buscarClientePorDni(dniCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese el ID de la cabaña: ");
        int idCabana = leerNumeroEntero(scanner);

        Cabana cabana = null;
        for (Cabana c : complejo.getCabanasDisponibles()) {
            if (c.getId() == idCabana) {
                cabana = c;
                break;
            }
        }

        if (cabana == null) {
            System.out.println("Cabaña no encontrada.");
            return;
        }

        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());

        System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
        LocalDate fechaFin = LocalDate.parse(scanner.nextLine());

        Reserva reserva = new Reserva(cliente, cabana, fechaInicio, fechaFin);
        complejo.registrarReserva(reserva);
        System.out.println("Reserva creada exitosamente. Costo total: " + reserva.calcularCostoTotal());
    }

    private void listarCabanasDisponibles() {
        System.out.println("Cabañas disponibles:");
        if (complejo.getCabanasDisponibles().isEmpty()) {
            System.out.println("No hay cabañas disponibles.");
        } else {
            for (Cabana cabana : complejo.getCabanasDisponibles()) {
                System.out.println("ID: " + cabana.getId() + ", Tipo: " + cabana.getTipo() + ", Precio Base: " + cabana.getPrecioBase());
            }
        }
    }

    private void mostrarReservasDeCliente(Scanner scanner) {
    System.out.print("Ingrese el DNI del cliente: ");
    String dni = scanner.nextLine();

    List<Reserva> reservasCliente = complejo.getReservasDeCliente(dni);
    
    if (reservasCliente.isEmpty()) {
        System.out.println("No se encontraron reservas para el cliente con DNI " + dni);
    } else {
        System.out.println("Reservas del cliente con DNI " + dni + ":");
        for (Reserva reserva : reservasCliente) {
            System.out.println("Cabaña: " + reserva.getCabana().getTipo() + ", ID: " + reserva.getCabana().getId());
            System.out.println("Fecha de Inicio: " + reserva.getFechaInicio());
            System.out.println("Fecha de Fin: " + reserva.getFechaFin());
        }
    }
}


    private void registrarCabana(Scanner scanner) {
        System.out.println("Seleccione el tipo de cabaña:");
        System.out.println("1. Premium");
        System.out.println("2. Estandar");
        int tipoSeleccionado = leerNumeroEntero(scanner);
    
        while (tipoSeleccionado != 1 && tipoSeleccionado != 2) {
            System.out.println("Opción inválida. Ingrese 1 para Premium o 2 para Estandar.");
            tipoSeleccionado = leerNumeroEntero(scanner);
        }
    
        System.out.print("Ingrese el ID de la cabaña: ");
        int id = leerNumeroEntero(scanner);
    
        Cabana nuevaCabana;
        if (tipoSeleccionado == 1) {
            nuevaCabana = new CabanaPremium(id, 40000);
            System.out.println("Cabaña Premium registrada con ID: " + id);
        } else {
            nuevaCabana = new CabanaEstandar(id, 20000);
            System.out.println("Cabaña Estandar registrada con ID: " + id);
        }
    
        complejo.registrarCabana(nuevaCabana);
    }
    
}
