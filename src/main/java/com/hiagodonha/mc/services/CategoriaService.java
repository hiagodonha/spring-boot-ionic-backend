package com.hiagodonha.mc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiagodonha.mc.dao.CategoriaDao;
import com.hiagodonha.mc.model.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaDao categoriaDao;
	
	public Categoria bucar(Integer id) {
		return categoriaDao.findById(id).get();
	}
}
