package com.varegos.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Personas")
public class Persona {
	
	@Column(name="APELLIDO")
	private String apellido;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Id
	@Column(name="DNI")
	private String dni;

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	

}
