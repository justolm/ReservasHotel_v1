package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;

public class Reservas {
    private int capacidad;
    private int tamano;
    private Reserva[] coleccionReservas;
    public Reservas (int capacidad) throws IllegalArgumentException{
        if (capacidad<1)
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        coleccionReservas=new Reserva[capacidad];
    }
    public Reserva[] get(){
        coleccionReservas=copiaProfundaReservas();
        return coleccionReservas;
    }
    private Reserva[] copiaProfundaReservas(){
        tamano=getTamano();
        Reserva[] copiaProfundaReservas=new Reserva[getCapacidad()];
        for (int i=0 ; i<tamano ; i++){
            copiaProfundaReservas[i]=new Reserva(coleccionReservas[i]);
        }
        return copiaProfundaReservas;
    }

    public int getTamano() {
        for(int t=0 ; t < getCapacidad() ; t++){
            if (coleccionReservas[t]==null){
                return t;
            }
        }
        return getCapacidad();
    }

    public int getCapacidad() {
        capacidad=coleccionReservas.length;
        return capacidad;
    }
    public void insertar (Reserva reserva) throws OperationNotSupportedException, NullPointerException {
        if (reserva==null){
            throw new NullPointerException("ERROR: No se puede insertar una reserva nula.");
        }
        if (buscarIndice(reserva)<getCapacidad()){
            throw new OperationNotSupportedException("ERROR: Ya existe una reserva igual.");
        }
        if (getTamano()<getCapacidad()){
            coleccionReservas[getTamano()]=new Reserva(reserva);
        }
        else {
            throw new OperationNotSupportedException("ERROR: No se aceptan m�s reservas.");
        }
    }

    private int buscarIndice (Reserva reserva) throws NullPointerException {
        if (reserva==null){
            throw new NullPointerException("ERROR: No se puede buscar sin indicar una reserva.");
        }
        for (int i=0 ; i < getTamano() ; i++){
            if (coleccionReservas[i]==null){
                return getCapacidad()+1;
            }
            else if (coleccionReservas[i].equals(reserva)) {
                return i;
            }
        }
        return getCapacidad()+1;
    }
    private Boolean tamanoSuperado (int indice) throws IllegalArgumentException{
        if (indice<0){
            throw new IllegalArgumentException("ERROR: Indice tama�o incorrecto");
        }
        else if (indice >0 && indice<getTamano()){
            return false;
        }
        return true;
    }
    private Boolean capacidadSuperada (int indice) throws IllegalArgumentException{
        if (indice<0){
            throw new IllegalArgumentException("ERROR: Indice capacidad incorrecto");
        }
        else if (indice >0 && indice<getCapacidad()){
            return false;
        }
        return true;
    }
    public Reserva buscar (Reserva reserva) throws NullPointerException {
        if (reserva==null){
            throw new NullPointerException("ERROR: No se puede buscar sin indicar una reserva.");
        }
        for (int i=0 ; i < getTamano() ; i++){
            if (coleccionReservas[i].equals(reserva)){
                return new Reserva(reserva);
            }
        }
        return null;
    }
    public void borrar (Reserva reserva) throws OperationNotSupportedException, NullPointerException {
        if (reserva==null){
            throw new NullPointerException("ERROR: No se puede borrar una reserva nula.");
        }
        int indice = buscarIndice(reserva);
        if (indice<=getCapacidad()){
            coleccionReservas[indice]=null;
            desplazarUnaPosicionHaciaIzquierda(indice);
        }
        else throw new OperationNotSupportedException("ERROR: No existe ninguna reserva como la indicada.");
    }
    private void desplazarUnaPosicionHaciaIzquierda (int indice){
        for (int i=indice ; i<getCapacidad()-1 ; i++){
            if (coleccionReservas[i+1]!=null){
                coleccionReservas[i]=new Reserva(coleccionReservas[i+1]);
                coleccionReservas[i+1]=null;
            }
        }
    }
    public Reserva[] getReservas (Huesped huesped) throws NullPointerException{
        int j=0;
        tamano=getTamano();
        capacidad=getCapacidad();
        Reserva[] copiaProfundaHabitacionesHuesped = new Reserva[capacidad];
        for (int i=0 ; i < tamano ; i++){
            if (huesped==null){
                throw new NullPointerException("ERROR: No se pueden buscar reservas de un huesped nulo.");
            }
            if (coleccionReservas[i].getHuesped().equals(huesped)){
                copiaProfundaHabitacionesHuesped[j] = new Reserva(coleccionReservas[i]);
                j++;
            }
        }
        if (j==0){
            return null;
        }
        return copiaProfundaHabitacionesHuesped;
    }
    public Reserva[] getReservas (TipoHabitacion tipoHabitacion) throws NullPointerException{
        int j=0;
        tamano=getTamano();
        capacidad=getCapacidad();
        Reserva[] copiaProfundaHabitacionesHabitacion = new Reserva[capacidad];
        for (int i=0 ; i < tamano ; i++){
            if (tipoHabitacion==null){
                throw new NullPointerException("ERROR: No se pueden buscar reservas de un tipo de habitaci�n nula.");
            }
            if (coleccionReservas[i].getHabitacion().getTipoHabitacion().equals(tipoHabitacion)){
                copiaProfundaHabitacionesHabitacion[j]=new Reserva(coleccionReservas[i]);
                j++;
            }
        }
        if (j==0){
            return null;
        }
        return copiaProfundaHabitacionesHabitacion;
    }
    public Reserva[] getReservasFuturas (Habitacion habitacion) throws NullPointerException {
        int j=0;
        tamano=getTamano();
        capacidad=getCapacidad();
        Reserva[] copiaProfundaHabitacionesReservasFuturas = new Reserva[capacidad];
        for (int i=0 ; i < tamano ; i++){
            if (habitacion==null){
                throw new NullPointerException("ERROR: No se pueden buscar reservas de una habitaci�n nula.");
            }
            if (coleccionReservas[i].getHabitacion().equals(habitacion)){
                if (coleccionReservas[i].getFechaFinReserva().isAfter(LocalDate.now())){
                    copiaProfundaHabitacionesReservasFuturas[j]=new Reserva(coleccionReservas[i]);
                    j++;
                }
            }
        }
        return copiaProfundaHabitacionesReservasFuturas;
    }
}
