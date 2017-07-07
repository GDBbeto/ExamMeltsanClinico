package com.mts.clinic.vo;

public class PacientesVO {

	private String id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String telefono;
	private String curp;
	private String direcion;
	private String idDirecion;
	private String idCelula;
	
	
	public PacientesVO(){
		
	}


	
	
	public PacientesVO(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono,
			String curp, String direcion, String idDirecion, String idCelula) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.telefono = telefono;
		this.curp = curp;
		this.direcion = direcion;
		this.idDirecion = idDirecion;
		this.idCelula = idCelula;
	}




	public PacientesVO(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getCurp() {
		return curp;
	}



	public void setCurp(String curp) {
		this.curp = curp;
	}



	public String getDirecion() {
		return direcion;
	}



	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}



	public String getIdDirecion() {
		return idDirecion;
	}



	public void setIdDirecion(String idDirecion) {
		this.idDirecion = idDirecion;
	}



	public String getIdCelula() {
		return idCelula;
	}



	public void setIdCelula(String idCelula) {
		this.idCelula = idCelula;
	}
	
	
	
	
	
}
