package com.hiagodonha.mc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodonha.mc.bo.ProdutoBo;
import com.hiagodonha.mc.dto.CategoriaDTO;
import com.hiagodonha.mc.model.Produto;

import javassist.tools.rmi.ObjectNotFoundException;

 @RestController
 @RequestMapping("/Produtos")
 public class ProdutoRest {
	 
	 @Autowired
	 ProdutoBo produtoBo;
	 
	 @GetMapping("/{id}")
	 public Produto find(@PathVariable Integer id) throws ObjectNotFoundException { //O PathVariablel está anotation é responsavel por pegar o valor que vem na url e joga na variavel passada por parametro
		 return produtoBo.find(id);
	 }
	 
	 @GetMapping() //PARA ESSE END POINT FUNCIONAR TIVER QUE TROCA <CRUDREPOSITORY> POR <JPAREPOSITORY>
	 public Page<CategoriaDTO> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, //O @REQUESTPARAM DIZ QUE NÃO É UM PARAMETRO OBRIGATÓRIO, MAS QUE SE ELE NÃO COLOCAR OS PARAMETRO ELE COMEÇARAM COM OS VALUEDEFAULT QUE SAO OS VALORES PADROES
			@RequestParam(value = "nome", defaultValue = "") Integer nome,
			@RequestParam(value = "categorias", defaultValue = "") Integer categorias,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		 
		Page<Produto> pag = produtoBo.search(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> pageDto = pag.map(pg -> new CategoriaDTO(pg));
		return pageDto;
	
	 }
	 
}
