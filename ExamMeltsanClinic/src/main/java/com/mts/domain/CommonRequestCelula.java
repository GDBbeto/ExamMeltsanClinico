package com.mts.domain;

public class CommonRequestCelula {

	private String idCelula;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String curp;
	private String fechaN;
	
	
	public CommonRequestCelula(){
		
	}
	
	public CommonRequestCelula(String idCelula, String nombre, String apellidoPaterno, String apellidoMaterno,
			String curp, String fechaN) {
		super();
		this.idCelula = idCelula;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.curp = curp;
		this.fechaN = fechaN;
	}
	public String getIdCelula() {
		return idCelula;
	}
	public void setIdCelula(String idCelula) {
		this.idCelula = idCelula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getFechaN() {
		return fechaN;
	}
	public void setFechaN(String fechaN) {
		this.fechaN = fechaN;
	}
	
	
	
	
}
