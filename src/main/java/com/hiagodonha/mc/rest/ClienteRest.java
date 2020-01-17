package com.hiagodonha.mc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodonha.mc.bo.ClienteBo;
import com.hiagodonha.mc.model.Cliente;

import javassist.tools.rmi.ObjectNotFoundException;

 @RestController
 @RequestMapping("/clientes")
 public class ClienteRest {
	 
	 @Autowired
	 ClienteBo categoriaService;
	 
	 @GetMapping("/{id}")
	 public Cliente get(@PathVariable Integer id) throws ObjectNotFoundException { //O PathVariablel está anotation é responsavel por pegar o valor que vem na url e joga na variavel passada por parametro
		 return categoriaService.bucar(id);
	 }
	 
}
