package com.hiagodonha.mc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.Categoria;

@Repository
public interface CategoriaDao extends CrudRepository<Categoria, Integer>{

}
