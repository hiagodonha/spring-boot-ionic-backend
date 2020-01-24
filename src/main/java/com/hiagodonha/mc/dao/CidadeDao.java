package com.hiagodonha.mc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.Cidade;

@Repository
public interface CidadeDao extends CrudRepository<Cidade, Integer>{
	
}
