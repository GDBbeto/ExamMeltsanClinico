package com.mts.domain;

public class CommonRequestDireccion {
	private String id_direcion;
	private String calle;
	private String colonia;
	private int id_ciudad;
	
	public CommonRequestDireccion(){
		
	}
	
	public CommonRequestDireccion(String id_direcion, String calle, String colonia, int id_ciudad) {
		super();
		this.id_direcion = id_direcion;
		this.calle = calle;
		this.colonia = colonia;
		this.id_ciudad = id_ciudad;
	}
	public String getId_direcion() {
		return id_direcion;
	}
	public void setId_direcion(String id_direcion) {
		this.id_direcion = id_direcion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public int getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(int id_ciudad) {
		this.id_ciudad = id_ciudad;
	}
	
	
}
