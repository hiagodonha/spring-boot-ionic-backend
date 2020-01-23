package com.hiagodonha.mc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Integer>{
	
		List<Cliente> findAll();
}
