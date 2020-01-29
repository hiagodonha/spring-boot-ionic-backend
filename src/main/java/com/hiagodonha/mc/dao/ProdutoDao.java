package com.hiagodonha.mc.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hiagodonha.mc.model.Categoria;
import com.hiagodonha.mc.model.Produto;

@Repository
public interface ProdutoDao extends JpaRepository<Produto, Integer>{
	
	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN produto.categorias cat WHERE produto.nome LIKE %:nome% AND cat IN :categorias")
	@Transactional(readOnly = true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(@Param("nome") String nome, @Param("categorias")List<Categoria> categorias, Pageable pageRequest);
}


