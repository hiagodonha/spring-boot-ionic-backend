package com.hiagodonha.mc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.Categoria;

@Repository
public interface CategoriaDao extends JpaRepository<Categoria, Integer>{

}
