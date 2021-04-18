package com.despegar.hoteles.models.entity;

public class Generales {

	private String idHotel;
	private String nombre;
	private String descripcion;
	private int categoria;
	private String imagenPrincipal;
	private String urlLogo;
	private long telefonoPrincipal;
	private long telefonoOpcional;
	private String email;
	private Localizacion localizacion;
	
	
	public String getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
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
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getImagenPrincipal() {
		return imagenPrincipal;
	}
	public void setImagenPrincipal(String imagenPrincipal) {
		this.imagenPrincipal = imagenPrincipal;
	}
	public String getUrlLogo() {
		return urlLogo;
	}
	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}
	public long getTelefonoPrincipal() {
		return telefonoPrincipal;
	}
	public void setTelefonoPrincipal(long telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
	}
	public long getTelefonoOpcional() {
		return telefonoOpcional;
	}
	public void setTelefonoOpcional(long telefonoOpcional) {
		this.telefonoOpcional = telefonoOpcional;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Localizacion getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(Localizacion localizacion) {
		this.localizacion = localizacion;
	}
}
