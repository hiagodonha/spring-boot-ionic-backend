package com.hiagodonha.mc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodonha.mc.bo.ProdutoBo;
import com.hiagodonha.mc.dao.ProdutoDao;
import com.hiagodonha.mc.dto.ProdutoDTO;
import com.hiagodonha.mc.model.Produto;
import com.hiagodonha.mc.rest.utils.URL;

import javassist.tools.rmi.ObjectNotFoundException;

 @RestController
 @RequestMapping("/Produtos")
 public class ProdutoRest {
	 
	 @Autowired
	 ProdutoBo produtoBo;
	 
	 @Autowired
	 ProdutoDao ProdutoDao;
	 
	 
	 @GetMapping("/{id}")
	 public Produto find(@PathVariable Integer id) throws ObjectNotFoundException { //O PathVariablel está anotation é responsavel por pegar o valor que vem na url e joga na variavel passada por parametro
		 return produtoBo.find(id);
	 }

	 @GetMapping() //PARA ESSE END POINT FUNCIONAR TIVER QUE TROCA <CRUDREPOSITORY> POR <JPAREPOSITORY>
	 public Page<ProdutoDTO> findPage(
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "categorias", defaultValue = "") String categorias,
			@RequestParam(value = "page", defaultValue = "0") Integer page, //O @REQUESTPARAM DIZ QUE NÃO É UM PARAMETRO OBRIGATÓRIO, MAS QUE SE ELE NÃO COLOCAR OS PARAMETRO ELE COMEÇARAM COM OS VALUEDEFAULT QUE SAO OS VALORES PADROES
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		String nomeDecoded = URL.decodeParams(nome);
		List<Integer> ids = URL.decodeListInt(categorias);
		Page<Produto> pag = produtoBo.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<ProdutoDTO> pageDto = pag.map(pg -> new ProdutoDTO(pg));
		return pageDto;

	 }
	 
}
