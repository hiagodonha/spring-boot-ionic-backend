package com.hiagodonha.mc.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.Categoria;
import com.hiagodonha.mc.model.Produto;

@Repository
public interface ProdutoDao extends JpaRepository<Produto, Integer>{
	
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> search(@Param("nome") String nome, @Param("categorias")List<Categoria> categorias, PageRequest pageRequest);
}