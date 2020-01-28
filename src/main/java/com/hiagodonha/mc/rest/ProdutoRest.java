package com.hiagodonha.mc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodonha.mc.bo.ProdutoBo;
import com.hiagodonha.mc.dao.ProdutoDao;

 @RestController
 @RequestMapping("/Produtos")
 public class ProdutoRest {
	 
	 @Autowired
	 ProdutoBo produtoBo;
	 
	 @Autowired
	 ProdutoDao ProdutoDao;
	 
//	 
//	 @GetMapping("/{id}")
//	 public Produto get(@PathVariable Integer id) throws ObjectNotFoundException { //O PathVariablel está anotation é responsavel por pegar o valor que vem na url e joga na variavel passada por parametro
//		 return produtoBo.search();
//	 }
//	 
}
