package com.intercorp.modelo;

import java.util.Date;

public class RequestCliente {
	
	private  String nombre;
	private  String apellido;
	private  int edad;
	private  Date nacimiento;
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getEdad() {
		return edad;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	

}
