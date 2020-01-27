package com.hiagodonha.mc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hiagodonha.mc.model.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Integer>{
	
		List<Cliente> findAll();
		
		@Transactional(readOnly = true)
		Cliente findByEmail (String email);
}
