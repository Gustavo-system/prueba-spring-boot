package com.init.supermercado.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.init.supermercado.dao.CarritoDao;
import com.init.supermercado.dao.CarritoDaoImplements;
import com.init.supermercado.models.Carrito;

@Service
public class CarritoService {
		
	private List<Carrito> carritoList = new ArrayList<>(Arrays.asList(
			new Carrito(1, 1, 1, 1),
			new Carrito(2, 2, 6, 2)
	));
	
	public List<Carrito> getCarrito(int id_user){
		if(id_user != 0) {
			return carritoList.stream().filter(item -> item.getId_user() == id_user).toList();
		}
		return carritoList;
	}
	
	public void addToCarrito(Carrito carrito) {
		int lastIndex = carritoList.size() - 1;
		Carrito list = carritoList.get(lastIndex);
		carrito.setId(list.getId() + 1);
		if(carrito.getCantidad() <= 0) {
			System.out.println("La cantidad ingresada no puede ser menor o igual a 0");
		}else {
			carritoList.add(carrito);
			Multithred thered = new Multithred(carrito);
			thered.start();
		}
	}
	
	public void updateCarrito(Carrito carrito, int id) {
		if(carrito.getCantidad() <= 0) {
			System.out.println("la cantidad ingresada no puede ser 0");
		}else {
			int counter = 0;
			for(Carrito item:carritoList) {
				if(item.getId() == id) {
					int oldId = item.getId();
					int oldProduct = item.getId_product();
					int user = item.getId_user();
					
					carrito.setId(oldId);
					carrito.setId_product(oldProduct);
					carrito.setId_user(user);
					
					carritoList.set(counter, carrito);
				}
				counter++;
			}
		}
	}
	
	public void deleteCarrito(int id) {
		carritoList.removeIf(carrito -> carrito.getId() == id);
	}
	
}
