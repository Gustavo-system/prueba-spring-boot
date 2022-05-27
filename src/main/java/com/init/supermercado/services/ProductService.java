package com.init.supermercado.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.init.supermercado.models.Products;

@Service
public class ProductService {
	private List<Products> productList = new ArrayList<>(Arrays.asList(
			new Products(1, "Commputadora Escritorio", "Computadora color blanca", 8500),
			new Products(2, "Celular", "Marca Apple, Modelo 11, rojo", 2500),
			new Products(3, "Impresora", "Impresora Lenovo", 1800),
			new Products(4, "Escritorio", "Escritorio de 100 cm x 50 cm ", 4000),
			new Products(5, "Laptop", "Laptop marca DELL 18 gb de ram", 15000),
			new Products(6, "Teclado Gamer", "Teclado con luces RGB", 1000)
    ));
	
	public List<Products> getAllProducts(){
		return productList;
	}
	
	public Products getOneProduct(int id) {
		Products product = null;
		product = productList.stream().filter(item -> item.getId() == id).findFirst().get();
		return product;
	}
	
	public void deleteProduct(int id) {
		productList.removeIf(product -> product.getId() == id);
	}
}
