package com.hiagodonha.mc.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodonha.mc.bo.CategoriaBo;
import com.hiagodonha.mc.dto.CategoriaDTO;
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
	 public Categoria insert(@Valid @RequestBody CategoriaDTO objDto) {
		 Categoria categoria = categoriaBo.fromDTO(objDto);
		 return categoriaBo.insert(categoria);
	 }
	 
	 @PutMapping("/{id}") //mudando para postmapping da certo
	 public Categoria update(@Valid @RequestBody CategoriaDTO categoriaDto, @PathVariable Integer id) {
		 Categoria categoria = categoriaBo.fromDTO(categoriaDto);
		 categoria = categoriaBo.update(categoria.getId(), categoria);
		 return categoria;
	 }
	 
	 @DeleteMapping("/{id}")
	 public void delete(@PathVariable Integer id) {
		 this.categoriaBo.delete(id);
	 }
	 
	 @GetMapping("/listar")
	 public List<CategoriaDTO> findAll(){
		List<Categoria> list = categoriaBo.findAll();
		List<CategoriaDTO> listDto = new ArrayList<>();
		list.forEach(cat ->
			listDto.add(new CategoriaDTO(cat))
		);
		return listDto;
 	 }
	 
	 @GetMapping("/page") //PARA ESSE END POINT FUNCIONAR TIVER QUE TROCA <CRUDREPOSITORY> POR <JPAREPOSITORY>
	 public Page<CategoriaDTO> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, //O @REQUESTPARAM DIZ QUE NÃO É UM PARAMETRO OBRIGATÓRIO, MAS QUE SE ELE NÃO COLOCAR OS PARAMETRO ELE COMEÇARAM COM OS VALUEDEFAULT QUE SAO OS VALORES PADROES
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		 
		Page<Categoria> pag = categoriaBo.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> pageDto = pag.map(pg -> new CategoriaDTO(pg));
		return pageDto;
	
	 }
	 
	 @GetMapping("/teste")
	 public String teste(@PathVariable String string1) {
		string1 = "string1";
		return string1;
	 }
	 
}
