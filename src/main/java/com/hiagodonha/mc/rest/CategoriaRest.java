package com.hiagodonha.mc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodonha.mc.bo.CategoriaService;
import com.hiagodonha.mc.dao.CategoriaDao;
import com.hiagodonha.mc.model.Categoria;

import javassist.tools.rmi.ObjectNotFoundException;

 @RestController
 @RequestMapping("/categorias")
 public class CategoriaRest {
	 
	 @Autowired
	 CategoriaService categoriaService;
	 
	 @Autowired
	 CategoriaDao categoriaDao;
	 
	 @GetMapping("/{id}")
	 public Categoria buscar(@PathVariable Integer id) throws ObjectNotFoundException { //O PathVariablel está anotation é responsavel por pegar o valor que vem na url e joga na variavel passada por parametro
		 return categoriaService.bucar(id);
	 }
	 
	 @PostMapping
	 public Categoria insert(@RequestBody Categoria obj) {
		 return obj = categoriaService.insert(obj);
	 }
	 
}
