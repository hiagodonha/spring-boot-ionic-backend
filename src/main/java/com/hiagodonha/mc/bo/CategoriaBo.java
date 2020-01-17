package com.hiagodonha.mc.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiagodonha.mc.dao.CategoriaDao;
import com.hiagodonha.mc.exception.ObjectNotFoundException;
import com.hiagodonha.mc.model.Categoria;

@Service
public class CategoriaBo {

	@Autowired
	private CategoriaDao categoriaDao;
	
	public Categoria find(Integer id) {
		 Optional<Categoria>obj = categoriaDao.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria categoria) {
		return categoriaDao.save(categoria);
	}
	
	public Categoria update(Categoria categoria) {
		find(categoria.getId());
		return categoriaDao.save(categoria);
	}
	
}
