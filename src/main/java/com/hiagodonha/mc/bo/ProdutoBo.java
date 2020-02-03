package com.hiagodonha.mc.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hiagodonha.mc.dao.CategoriaDao;
import com.hiagodonha.mc.dao.ProdutoDao;
import com.hiagodonha.mc.exception.ObjectNotFoundException;
import com.hiagodonha.mc.model.Categoria;
import com.hiagodonha.mc.model.Produto;



@Service
public class ProdutoBo {

	@Autowired
	private ProdutoDao produtoDao;
	
	@Autowired
	private CategoriaDao categoriaDao;
	
	public Produto find(Integer id) throws ObjectNotFoundException {
		 Optional<Produto>obj = produtoDao.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 		"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome, List<Integer> ids , Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaDao.findAllById(ids);
		return produtoDao.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
		
	}
}
