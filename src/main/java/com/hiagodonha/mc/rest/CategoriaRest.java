package com.hiagodonha.mc.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodonha.mc.model.Categoria;
import com.hiagodonha.mc.services.CategoriaService;

 @RestController
 @RequestMapping("categorias")
 public class CategoriaRest {
	 
	 @Autowired
	 CategoriaService categoriaService;
	 
	 @GetMapping
	 public List<Categoria> listar() {
		 
		 Categoria cat1 = new Categoria(1, "Informática");
		 Categoria cat2 = new Categoria(1, "Escritório");
		 
		 List<Categoria> list = new ArrayList<>();
		 list.add(cat1);
		 list.add(cat2);
		 
		 return list;
	 }
	 
	 @GetMapping("/{id}")
	 public Integer get(@PathVariable Integer id) { //O PathVariablel está anotation é responsavel por pegar o valor que vem na url e joga na variavel passada por parametro
		 return categoriaService.bucar(id).getId();
	 }
	 
}
