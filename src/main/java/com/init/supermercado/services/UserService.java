package com.init.supermercado.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.init.supermercado.models.Users;

@Service
public class UserService {
	private List<Users> usersList = new ArrayList<>(Arrays.asList(
			new Users(1, "Gustavo Solar Gaona"),
			new Users(2, "Invitado Prueba")
	));
	
	public List<Users> getAllUsers(){
		return usersList;
	}
}
