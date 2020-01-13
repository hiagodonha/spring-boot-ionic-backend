package com.hiagodonha.mc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.Estado;

@Repository
public interface EstadoDao extends CrudRepository<Estado, Integer>{

}
