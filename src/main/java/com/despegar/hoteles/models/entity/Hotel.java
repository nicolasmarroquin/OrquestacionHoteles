package com.despegar.hoteles.models.entity;

public class Hotel {
	
	private String Id_hotel;
	
	private String nombre;
	
	private String descripcion;

	public String getId_hotel() {
		return Id_hotel;
	}

	public void setId_hotel(String id_hotel) {
		Id_hotel = id_hotel;
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
	
	
	

}
