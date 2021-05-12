package com.despegar.hoteles.models.entity;

import java.util.List;

public class Reserva {
	
	private int idReserva;
	private EstadoReserva estadoReservas;
	private List<ReservaHabitacion> reservaHabitaciones;
	private String idHotel;
	private String fechaInicio;
	private String fechaFin;
	private int idTipoHabitacion;
	private int numeroPersonas;
	private List<Huesped> reservaHuespedes;
	private long valor;
	
	
	
	public long getValor() {
		return valor;
	}
	public void setValor(long valor) {
		this.valor = valor;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public EstadoReserva getEstadoReservas() {
		return estadoReservas;
	}
	public void setEstadoReservas(EstadoReserva estadoReservas) {
		this.estadoReservas = estadoReservas;
	}
	public List<ReservaHabitacion> getReservaHabitaciones() {
		return reservaHabitaciones;
	}
	public void setReservaHabitaciones(List<ReservaHabitacion> reservaHabitaciones) {
		this.reservaHabitaciones = reservaHabitaciones;
	}
	public String getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getIdTipoHabitacion() {
		return idTipoHabitacion;
	}
	public void setIdTipoHabitacion(int idTipoHabitacion) {
		this.idTipoHabitacion = idTipoHabitacion;
	}
	public int getNumeroPersonas() {
		return numeroPersonas;
	}
	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}
	public List<Huesped> getReservaHuespedes() {
		return reservaHuespedes;
	}
	public void setReservaHuespedes(List<Huesped> reservaHuespedes) {
		this.reservaHuespedes = reservaHuespedes;
	}
	
	

}
