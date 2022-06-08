package com.bolsadeideas.springboot.webflux.app.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDto {

	private String id;
	private String nombre;
	private String ubicacion;
	private Double precio;
	private String categoria;


	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public ProductDto() {
	}

	public ProductDto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
	}
        
	public ProductDto(String nombre, String ubicacion, Double precio,  String categoria ) {
		this.nombre = nombre;
		this.ubicacion=ubicacion;
		this.precio = precio;
		this.categoria=categoria;
	}
	
	
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", precio=" + precio
				+ ", categoria=" + categoria + "]";
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
