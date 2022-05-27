package com.init.supermercado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.init.supermercado.models.Carrito;
import com.init.supermercado.models.Products;
import com.init.supermercado.models.Users;
import com.init.supermercado.services.CarritoService;
import com.init.supermercado.services.ProductService;
import com.init.supermercado.services.UserService;

@RestController
@RequestMapping("/miempresa/compras/")
public class endpoints {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private CarritoService carritoService;
	
	
	// PRODUCTS
	@RequestMapping(value="products", method=RequestMethod.GET)
	public List<Products> getProducts(){
		return productService.getAllProducts();
	}
	
	@RequestMapping(value="products/{id}", method=RequestMethod.GET)
	public Products getProduct(@PathVariable("id") int id){
		return productService.getOneProduct(id);
	}
	
	@RequestMapping(value="products/{id}", method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);
	}
	
	
	// USERS
	@RequestMapping(value="users", method=RequestMethod.GET)
	public List<Users> getUsers(){
		return userService.getAllUsers();
	}
	
	
	//CARRITO
	@RequestMapping(value="carrito", method=RequestMethod.GET)
	public List<Carrito> getCarrito(@RequestParam(required = false, defaultValue = "0") int id_user){
		return carritoService.getCarrito(id_user);
	}
	
	@RequestMapping(value="carrito", method=RequestMethod.POST)	
	public ResponseEntity<Carrito> addToCarrito(@RequestBody Carrito carrito) {
		carritoService.addToCarrito(carrito);
	    return new ResponseEntity<Carrito>(carrito,null,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="carrito/{id}", method=RequestMethod.PUT)
	public void updateCarrito(@RequestBody Carrito carrito, @PathVariable("id") int id) {
		carritoService.updateCarrito(carrito, id);
	}
	
	@RequestMapping(value="carrito/{id}", method=RequestMethod.DELETE)
	public void deleteCarrito(@PathVariable("id") int id) {
		carritoService.deleteCarrito(id);
	}
	
}
