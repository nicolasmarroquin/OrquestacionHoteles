package com.despegar.hoteles.models.entity;

import java.util.List;

public class Alojamiento {
	
	private int id;
	private Hotel hotel;
	private String nombre;
	private String descripcion;
	private int capacidadMax;
	private int valorNoche;
	private List<Imagen> imagenes;
	private List<Servicio> servicios;
	
	
	
	public Hotel getIdHotel() {
		return hotel;
	}
	public void setIdHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCapacidadMax() {
		return capacidadMax;
	}
	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}
	public int getValorNoche() {
		return valorNoche;
	}
	public void setValorNoche(int valorNoche) {
		this.valorNoche = valorNoche;
	}
	public List<Imagen> getImagenes() {
		return imagenes;
	}
	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	

}
