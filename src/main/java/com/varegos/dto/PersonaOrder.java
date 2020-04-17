package com.varegos.dto;

public class PersonaOrder {

	private String dni;
	private int size;
	private double amount;
	private String apellido;
	
	public PersonaOrder(String dni, int size, double amount, String apellido) {
		this.dni = dni;
		this.size = size;
		this.amount = amount;
		this.apellido = apellido;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	

}
