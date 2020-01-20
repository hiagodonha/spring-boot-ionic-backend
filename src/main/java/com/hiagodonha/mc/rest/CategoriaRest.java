package com.hiagodonha.mc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodonha.mc.bo.CategoriaBo;
import com.hiagodonha.mc.model.Categoria;

 @RestController
 @RequestMapping("/categorias")
 public class CategoriaRest {
	 
	 @Autowired
	 CategoriaBo categoriaBo;
	 
	 @GetMapping("/{id}")
	 public Categoria findById(@PathVariable Integer id) { //O PathVariablel está anotation é responsavel por pegar o valor que vem na url e joga na variavel passada por parametro
		 return categoriaBo.find(id);
	 }
	 
	 @PostMapping
	 public Categoria insert(@RequestBody Categoria obj) {
		 return categoriaBo.insert(obj);
	 }
	 
	 @PutMapping("{/id}")
	 public Categoria update(@PathVariable Integer id, @RequestBody Categoria categoria) {
		 categoria = categoriaBo.update(id,categoria);
		 return categoria;
	 }
	 
	 @DeleteMapping("{id}")
	 public void delete(@PathVariable Integer id) {
		 this.categoriaBo.delete(id);
	 }
	 
	 @GetMapping("teste")
	 public String teste(@PathVariable String string1) {
		string1 = "string1";
		return string1;
	 }
	 
}
