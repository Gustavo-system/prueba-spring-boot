package com.init.supermercado.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.init.supermercado.models.Carrito;

@Service
public class CarritoService {
	private List<Carrito> carritoList = new ArrayList<>(Arrays.asList(
			new Carrito(1, 1, 1, 1),
			new Carrito(2, 1, 6, 2)
	));
	
	public List<Carrito> getCarrito(){
		return carritoList;
	}
	
	public void addToCarrito(Carrito carrito) {
		carritoList.add(carrito);
	}
	
	public void updateCarrito(Carrito carrito, int id) {
		int counter = 0;
		for(Carrito item:carritoList) {
			if(item.getId() == id) {
				carritoList.set(counter, carrito);
			}
			counter++;
		}
	}
	
	public void deleteCarrito(int id) {
		carritoList.removeIf(carrito -> carrito.getId() == id);
	}
	
}
