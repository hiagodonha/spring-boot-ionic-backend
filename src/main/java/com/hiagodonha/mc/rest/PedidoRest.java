package com.hiagodonha.mc.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodonha.mc.bo.PedidoBo;
import com.hiagodonha.mc.model.Pedido;

import javassist.tools.rmi.ObjectNotFoundException;

 @RestController
 @RequestMapping("/pedidos")
 public class PedidoRest {
	 
	 @Autowired
	 PedidoBo pedidoBo;
	 	 
	 
	 @GetMapping("/{id}")
	 public Pedido find(@PathVariable Integer id) throws ObjectNotFoundException { //O PathVariablel está anotation é responsavel por pegar o valor que vem na url e joga na variavel passada por parametro
		 return pedidoBo.find(id);
	 }
	 
	 @PostMapping
	 public Pedido insert(@Valid @RequestBody Pedido pedido) {
		 return pedidoBo.insert(pedido);
	 }
}
