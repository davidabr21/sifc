package com.duopharma.graphObjects;

public class PieObjeto {
	
	private String Nombre;
	private int Valor;
	
	public PieObjeto(String nombre, int valor) {
		this.Nombre = nombre;
		this.Valor = valor;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getValor() {
		return Valor;
	}

	public void setValor(int valor) {
		Valor = valor;
	}
}
