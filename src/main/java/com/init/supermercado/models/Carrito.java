package com.init.supermercado.models;

public class Carrito {
	private int id;
	private int id_user;
	private int id_product;
	private int cantidad;
	
	public Carrito() {
		
	}
	
	public Carrito(int id, int id_user, int id_product, int cantidad) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.id_product = id_product;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_user() {
		return id_user;
	}
	
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	public int getId_product() {
		return id_product;
	}
	
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
