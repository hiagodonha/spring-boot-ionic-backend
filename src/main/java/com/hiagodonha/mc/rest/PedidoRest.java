package com.hiagodonha.mc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodonha.mc.bo.PedidoService;
import com.hiagodonha.mc.dao.PedidoDao;
import com.hiagodonha.mc.model.Pedido;

import javassist.tools.rmi.ObjectNotFoundException;

 @RestController
 @RequestMapping("/pedidos")
 public class PedidoRest {
	 
	 @Autowired
	 PedidoService pedidoService;
	 
	 @Autowired
	 PedidoDao pedidoDao;
	 
	 
	 @GetMapping("/{id}")
	 public Pedido get(@PathVariable Integer id) throws ObjectNotFoundException { //O PathVariablel está anotation é responsavel por pegar o valor que vem na url e joga na variavel passada por parametro
		 return pedidoService.bucar(id);
	 }
	 
}
