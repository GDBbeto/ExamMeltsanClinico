package com.mts.clinic.vo;

public class DoctorVO {

	private String id_doctor;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String telefono;
	private String nomEsp;
	private String curp;
	private String direccion;
	
	public DoctorVO(){}
	
	
	public DoctorVO(String id_doctor, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono,
			String nomEsp, String curp, String direccion) {
		super();
		this.id_doctor = id_doctor;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.telefono = telefono;
		this.nomEsp = nomEsp;
		this.curp = curp;
		this.direccion = direccion;
	}
	public String getId_doctor() {
		return id_doctor;
	}
	public void setId_doctor(String id_doctor) {
		this.id_doctor = id_doctor;
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
	public String getNomEsp() {
		return nomEsp;
	}
	public void setNomEsp(String nomEsp) {
		this.nomEsp = nomEsp;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
