package com.map.entities;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {

	@Id
	private int id;
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ids", joinColumns = {@JoinColumn(name="user_id")},inverseJoinColumns = {@JoinColumn(name="a_id")})
	@JsonManagedReference
	@JsonIgnore
	private Set<Address> adds=new HashSet<>() ;
	
	
	public Set<Address> getAdds() {
		return adds;
	}
	public void setAdds(Set<Address> adds) {
		this.adds = adds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, Set<Address> adds) {
		super();
		this.id = id;
		this.name = name;
		this.adds = adds;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name +  "]";
	}
	
	
	
}
