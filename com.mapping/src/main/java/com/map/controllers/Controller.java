package com.map.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.map.entities.Address;
import com.map.entities.User;
import com.map.services.Service;

@RestController
public class Controller {
	
	@Autowired
	private Service service;
	
	@PostMapping("/saveuser")
	public User test1(@RequestBody User user)
	{
		return this.service.saveuser(user);
	}
	

	@PostMapping("/saveaddress")
	public Address test2(@RequestBody Address address)
	{
		return this.service.saveaddress(address);
	}

	@GetMapping("/getalluser")
	public List<User> test3()
	{
		List<User> l1 = this.service.getalluser();
		return l1;
	}
	
	@PostMapping("/addaddress/{id}")
	public User test4(@PathVariable("id") int id ,@RequestBody Address address )
	{
		return this.service.addaddress(id,address);
	}
	@PostMapping("/adduser/{id}")
	public Address test5(@PathVariable("id") int id ,@RequestBody User user)
	{
		return this.service.adduser(id,user);
	}
	@GetMapping("/user/{id}")
	public User test6(@PathVariable int id)
	{
		return this.service.getuserbyid(id);
	}
	
	@GetMapping("/address/{id}")
	public Address test7(@PathVariable int id)
	{
		return this.service.getaddressbyid(id);
	}
	
	@PutMapping("/user/{id}")
	public User test8(@PathVariable("id") int id ,@RequestBody User user)
	{
		return this.service.updateuser(id, user);
	}
	@PutMapping("/user/{id}")
	public Address test9(@PathVariable("id") int id ,@RequestBody Address address)
	{
		return this.service.updateaddr(id, address);
	}
	}
	

