package com.mts.clinic.vo;

public class CiudadMunicipioVO {
	private String idCiudadMun;
	private String nombreMun;
	
	public CiudadMunicipioVO()
	{
		
	}
	
	public CiudadMunicipioVO(String idCiudadMun, String nombreMun) {
		super();
		this.idCiudadMun = idCiudadMun;
		this.nombreMun = nombreMun;
	}
	public String getIdCiudadMun() {
		return idCiudadMun;
	}
	public void setIdCiudadMun(String idCiudadMun) {
		this.idCiudadMun = idCiudadMun;
	}
	public String getNombreMun() {
		return nombreMun;
	}
	public void setNombreMun(String nombreMun) {
		this.nombreMun = nombreMun;
	}
	
	

}
