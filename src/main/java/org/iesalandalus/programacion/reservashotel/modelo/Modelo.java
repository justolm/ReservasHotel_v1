package org.iesalandalus.programacion.reservashotel.modelo;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Reservas;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDateTime;

public class Modelo {
    private static final int CAPACIDAD = 5;
    private static Habitaciones habitaciones;
    private static Reservas reservas;
    private static Huespedes huespedes;

    public Modelo(){}

    public void comenzar() throws IllegalArgumentException, NullPointerException {
        habitaciones = new Habitaciones(CAPACIDAD);
        reservas = new Reservas(CAPACIDAD);
        huespedes = new Huespedes(CAPACIDAD);
    }

    public void terminar(){
        System.out.println("El modelo ha finalizado.");
    }

    public void insertar (Huesped huesped) throws OperationNotSupportedException, NullPointerException {
        huespedes.insertar(huesped);
    }

    public Huesped buscar (Huesped huesped) throws IllegalArgumentException, NullPointerException {
        return huespedes.buscar(huesped);
    }

    public void borrar (Huesped huesped) throws OperationNotSupportedException, NullPointerException {
        huespedes.borrar(huesped);
    }

    public Huesped[] getHuespedes(){
        return huespedes.get();
    }

    public void insertar (Habitacion habitacion) throws OperationNotSupportedException, NullPointerException {
        habitaciones.insertar(habitacion);
    }

    public Habitacion buscar (Habitacion habitacion) throws NullPointerException {
        return habitaciones.buscar(habitacion);
    }

    public void borrar (Habitacion habitacion) throws OperationNotSupportedException, NullPointerException {
        habitaciones.borrar(habitacion);
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones.get();
    }

    public Habitacion[] getHabitaciones(TipoHabitacion tipoHabitacion) throws NullPointerException {
        return habitaciones.get(tipoHabitacion);
    }

    public void insertar (Reserva reserva) throws OperationNotSupportedException, NullPointerException {
        reservas.insertar(reserva);
    }

    public Reserva buscar (Reserva reserva) throws NullPointerException {
        return reservas.buscar(reserva);
    }

    public void borrar (Reserva reserva) throws OperationNotSupportedException, NullPointerException {
        reservas.borrar(reserva);
    }

    public Reserva[] getReservas() {
        return reservas.get();
    }

    public Reserva[] getReservas(Huesped huesped) throws NullPointerException {
        return reservas.getReservas(huesped);
    }

    public Reserva[] getReservas(TipoHabitacion tipoHabitacion) throws NullPointerException {
        return reservas.getReservas(tipoHabitacion);
    }

    public Reserva[] getReservasFuturas(Habitacion habitacion) throws NullPointerException {
        return reservas.getReservasFuturas(habitacion);
    }

    public void realizarCheckin (Reserva reserva, LocalDateTime fecha) throws IllegalArgumentException, NullPointerException {
        reservas.realizarCheckin(reserva, fecha);
    }

    public void realizarCheckout (Reserva reserva, LocalDateTime fecha) throws IllegalArgumentException, NullPointerException {
        reservas.realizarCheckout(reserva, fecha);
    }

}
