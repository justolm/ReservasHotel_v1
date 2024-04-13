package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {
    SALIR("SALIR"),
    INSERTAR_HUESPED("INSERTAR HUESPED"),
    BUSCAR_HUESPED("BUSCAR HU�SPED"),
    BORRAR_HUESPED("BORRAR HU�SPED"),
    MOSTRAR_HUESPEDES("MOSTRAR HU�SPEDES"),
    INSERTAR_HABITACION("INSERTAR HABITACI�N"),
    BUSCAR_HABITACION("BUSCAR HABITACI�N"),
    BORRAR_HABITACION("BORRAR HABITACI�N"),
    MOSTRAR_HABITACIONES("MOSTRAR HABITACIONES"),
    INSERTAR_RESERVA("INSERTAR RESERVA"),
    LISTAR_RESERVA("LISTAR RESERVA"),
    ANULAR_RESERVA("ANULAR RESERVA"),
    MOSTRAR_RESERVAS("MOSTRAR RESERVAS"),
    CONSULTAR_DISPONIBILIDAD("CONSULTAR DISPONIBILIDAD"),
    REALIZAR_CHECKIN("REALIZAR CHECKIN"),
    REALIZAR_CHECKOUT("REALIZAR CHECKOUT");

    private final String mensajeAMostrar;
    Opcion(String mensajeAMostrar){
        this.mensajeAMostrar = mensajeAMostrar;
    }

    @Override
    public String toString() {
        return ordinal() + ".- " + mensajeAMostrar + '\n';
    }
}
