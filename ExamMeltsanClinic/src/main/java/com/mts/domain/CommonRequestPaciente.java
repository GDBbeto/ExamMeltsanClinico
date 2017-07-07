package com.mts.domain;

public class CommonRequestPaciente {
	
	private String id_paciente;
	private String  nombre;
	private int   telefono;
	private String   activo;
	private int   id_celula_identificacion;
	private int   id_direccion;
	
	public CommonRequestPaciente()
	{
		
	}
	
	
	
	public CommonRequestPaciente(String id_paciente, String nombre, int telefono, String activo,
			int id_celula_identificacion, int id_direccion) {
		super();
		this.id_paciente = id_paciente;
		this.nombre = nombre;
		this.telefono = telefono;
		this.activo = activo;
		this.id_celula_identificacion = id_celula_identificacion;
		this.id_direccion = id_direccion;
	}
	public String getId_paciente() {
		return id_paciente;
	}
	public void setId_paciente(String id_paciente) {
		this.id_paciente = id_paciente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



	public int getId_celula_identificacion() {
		return id_celula_identificacion;
	}



	public void setId_celula_identificacion(int id_celula_identificacion) {
		this.id_celula_identificacion = id_celula_identificacion;
	}



	public int getId_direccion() {
		return id_direccion;
	}



	public void setId_direccion(int id_direccion) {
		this.id_direccion = id_direccion;
	}
	
	
			

	
}
