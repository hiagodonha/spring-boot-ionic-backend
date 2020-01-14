package com.hiagodonha.mc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.Endereco;

@Repository
public interface EnderecoDao extends CrudRepository<Endereco, Integer>{

}
