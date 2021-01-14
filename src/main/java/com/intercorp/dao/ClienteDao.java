package com.intercorp.dao;


import org.springframework.data.repository.CrudRepository;

import com.intercorp.modelo.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {
	
	

}
