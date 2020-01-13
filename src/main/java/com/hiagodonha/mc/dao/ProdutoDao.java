package com.hiagodonha.mc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.Produto;

@Repository
public interface ProdutoDao extends CrudRepository<Produto, Integer>{

}
