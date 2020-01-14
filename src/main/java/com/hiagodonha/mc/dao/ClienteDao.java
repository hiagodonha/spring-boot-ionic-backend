package com.hiagodonha.mc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.Cliente;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Integer>{

}
