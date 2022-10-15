package com.map.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.map.entities.Address;


public interface AddressRepository extends JpaRepository<Address, Integer>{

}
