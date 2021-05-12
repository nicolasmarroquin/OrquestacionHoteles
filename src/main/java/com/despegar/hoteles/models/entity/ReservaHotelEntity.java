package com.despegar.hoteles.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reserva_hotel")
public class ReservaHotelEntity {
	
	
	
	@ManyToOne
	@JoinColumn (name = "idHotel")
	private HotelEntity hotel;
	
	@ManyToOne
	@JoinColumn (name = "idusuarios")
	private UsuariosEntity usuario;
	
	@Id
	@Column(name = "idReserva")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idReserva;
	
	@Column(name="fecha_inicio")
	@Temporal(TemporalType.DATE)
	private Date fecha_inicio; 
	
	@Column(name="fecha_fin")
	@Temporal(TemporalType.DATE)
	private Date fecha_fin; 
	
	@Column(name="numeroPersonas")
	private int numeroPersonas;
	
	@Column(name="valor")
	private long valor;
	
	@Column(name = "idReservaHotel")
	private long idReservaHotel;
	
	@Column(name = "estadoReserva")
	private String estadoReserva;
	
	

	public String getEstadoReserva() {
		return estadoReserva;
	}

	public void setEstadoReserva(String estadoReserva) {
		this.estadoReserva = estadoReserva;
	}

	public HotelEntity getHotel() {
		return hotel;
	}

	public void setHotel(HotelEntity hotel) {
		this.hotel = hotel;
	}

	public UsuariosEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuariosEntity usuario) {
		this.usuario = usuario;
	}

	public long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public long getIdReservaHotel() {
		return idReservaHotel;
	}

	public void setIdReservaHotel(long idReservaHotel) {
		this.idReservaHotel = idReservaHotel;
	}
	
	
	
	
	
	

}
