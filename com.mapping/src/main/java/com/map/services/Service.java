package com.map.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.map.entities.Address;
import com.map.entities.User;
import com.map.repositories.AddressRepository;
import com.map.repositories.UserRepository;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private UserRepository ur;
	@Autowired
	private AddressRepository ar;

	public User saveuser(User user)
	{
		return this.ur.save(user);
	}
	
	public Address saveaddress(Address address)
	{
		return this.ar.save(address);
	}
	
	public List<User> getalluser()
	{
		return this.ur.findAll();
	}
	public List<Address> getalladdress()
	{
		return this.ar.findAll();
	}
	
	
	public User addaddress(int id ,  Address address)
	{
		User us= this.ur.findById(id).orElseThrow(() ->new RuntimeException());
		
		System.out.println(address.getAid());
		Address a= ar.findById(address.getAid()).get();
		us.getAdds().add(a);
	
		System.out.println(us.getAdds());
		ur.save(us);
		return us;
	}
	public Address adduser(int id ,User user )
	{
		Address addr= this.ar.findById(id).orElseThrow(() ->new RuntimeException());
		
		addr.getUsers().add(ur.findById(user.getId()).get());
			
		
		ar.save(addr);
		return addr;
	}
	
	public User updateuser(int id , User user)
	{
		User us= this.ur.findById(id).orElseThrow(() ->new RuntimeException());
		us.setName(user.getName());
		us.setId(user.getId());
		return us;
	}
	public Address updateaddr(int id , Address address)
	{
		Address addr= this.ar.findById(id).orElseThrow(() ->new RuntimeException());
		addr.setAid(address.getAid());
		addr.setAddress(address.getAddress());
		return addr;
	}
	
	public User getuserbyid(int id)
	{
		return this.ur.findById(id).get();
		
	}
	public Address getaddressbyid(int id)
	{
		return this.ar.findById(id).get();
	}
	
}
