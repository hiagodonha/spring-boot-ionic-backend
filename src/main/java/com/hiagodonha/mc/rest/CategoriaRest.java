package com.hiagodonha.mc.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodonha.mc.model.Categoria;

 @RestController
 @RequestMapping("categorias")
 public class CategoriaRest {
	 
	 @GetMapping
	 public List<Categoria> listar() {
		 
		 Categoria cat1 = new Categoria(1, "Informática");
		 Categoria cat2 = new Categoria(1, "Escritório");
		 
		 List<Categoria> list = new ArrayList<>();
		 list.add(cat1);
		 list.add(cat2);
		 
		 return list;
	 }
	 
}
