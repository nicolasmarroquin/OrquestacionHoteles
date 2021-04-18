package com.despegar.hoteles.models.entity;

import java.util.List;

public class Hotel {
	
	private Generales generales;
	
	private List<TipoHabitacion> tipoHabitaciones;
	
	private List<Servicio> servicios;
	
	private List<Imagen> imagenes;

	public Generales getGenerales() {
		return generales;
	}

	public void setGenerales(Generales generales) {
		this.generales = generales;
	}

	public List<TipoHabitacion> getTipoHabitaciones() {
		return tipoHabitaciones;
	}

	public void setTipoHabitaciones(List<TipoHabitacion> tipoHabitaciones) {
		this.tipoHabitaciones = tipoHabitaciones;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

	
	
	
	

}
