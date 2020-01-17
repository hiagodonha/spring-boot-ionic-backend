package com.hiagodonha.mc.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hiagodonha.mc.dao.CategoriaDao;
import com.hiagodonha.mc.model.Categoria;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaDao categoriaDao;
	
	public Categoria bucar(Integer id) throws ObjectNotFoundException {
		 Optional<Categoria>obj = categoriaDao.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria categoria) {
		return categoriaDao.save(categoria);
	}
	
}
