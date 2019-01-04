package es.salesianos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pelicula {
	private int cod;
	private String titulo;
	private int codDirector; // is codOwner

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCodDirector() {
		return codDirector;
	}

	public void setCodDirector(int codDirector) {
		this.codDirector = codDirector;
	}

}
