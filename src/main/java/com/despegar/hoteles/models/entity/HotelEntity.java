package com.despegar.hoteles.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="hoteles")
public class HotelEntity {
	
	@Id
	@Column(name = "idHotel")
	private String idHotel;
	
	@Column(name = "nombreHotel")
	private String nombreHotel;
	
	@Column(name = "estado")
	private boolean estado;

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}
