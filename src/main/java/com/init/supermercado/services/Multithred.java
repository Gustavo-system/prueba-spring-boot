package com.init.supermercado.services;

import com.init.supermercado.dao.CarritoDao;
import com.init.supermercado.dao.CarritoDaoImplements;
import com.init.supermercado.models.Carrito;

public class Multithred extends Thread {
	
	private Carrito carrito;
	public Multithred(Carrito carrito) {
		
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(8000);
		}catch (InterruptedException e) {
		}
		
		CarritoDao dao = new CarritoDaoImplements();
		dao.addToCarrito(carrito);
		
		
		
	}
}
