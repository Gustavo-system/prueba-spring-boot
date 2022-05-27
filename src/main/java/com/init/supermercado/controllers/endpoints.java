package com.init.supermercado.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

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
	public ResponseEntity<List<Products>> getProducts(){
		List<Products> producs = productService.getAllProducts();
		if(producs.size() <= 0) {
			return ResponseEntity.status(HttpStatus.OK).build(); 
		}
		
		return ResponseEntity.of(Optional.of(producs));
	}
	
	@RequestMapping(value="products/{id}", method=RequestMethod.GET)
	public ResponseEntity<Products> getProduct(@PathVariable("id") int id){
		Products product = productService.getOneProduct(id);
		if(product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(product));
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
	public ResponseEntity<List<Carrito>> getMyCarrito(@RequestHeader(name = "x-id-usuario", required = false, defaultValue = "0") int id_user){
		List<Carrito> carrito = carritoService.getCarrito(id_user);
		if(carrito.size() <= 0) {
			return ResponseEntity.status(HttpStatus.OK).build(); 
		}
		
		return ResponseEntity.of(Optional.of(carrito));
	}
	
	@RequestMapping(
		value="carrito", 
		consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
		method=RequestMethod.POST
	)	
	public ResponseEntity<Carrito> addToCarrito(@RequestBody Carrito carrito) {
		carritoService.addToCarrito(carrito);
	    return new ResponseEntity<Carrito>(carrito,null,HttpStatus.CREATED);
	}
	
	@PutMapping(
		value="carrito/{id}",
		consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	public void updateCarrito(@RequestBody Carrito carrito, @PathVariable("id") int id) {
		carritoService.updateCarrito(carrito, id);
	}
	
	@RequestMapping(value="carrito/{id}", method=RequestMethod.DELETE)
	@ResponseBody public void deleteCarrito(@PathVariable("id") int id) {
		carritoService.deleteCarrito(id);
	}
	
	@GetMapping(path = "hola")
	public String hello() {
		return "{'menssage':'Hola mundo'}";
	}
	
}
