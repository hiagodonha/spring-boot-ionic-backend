package com.hiagodonha.mc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiagodonha.mc.bo.ClienteBo;
import com.hiagodonha.mc.dto.ClienteDTO;
import com.hiagodonha.mc.model.Cliente;

import javassist.tools.rmi.ObjectNotFoundException;

 @RestController
 @RequestMapping("/clientes")
 public class ClienteRest {
	 
	 @Autowired
	 ClienteBo clienteBo;
	 
	 @GetMapping("/{id}")
	 public Cliente get(@PathVariable Integer id) throws ObjectNotFoundException { //O PathVariablel está anotation é responsavel por pegar o valor que vem na url e joga na variavel passada por parametro
		 return clienteBo.find(id);
	 }

//	 @PostMapping
//	 public Cliente insert(@Valid @RequestBody ClienteDTO clienteDto) {
//		 Cliente cliente = clienteBo.fromDTO(clienteDto);
//		 return clienteBo.insert(cliente);
//	 }
	 
//	 @PutMapping("{/id}")
//	 public Cliente update(@Valid @RequestBody ClienteDTO clienteDto, @PathVariable Integer id) {
//		 Cliente cliente = clienteBo.fromDTO(clienteDto);
//		 cliente = clienteBo.update(cliente.getId(), cliente);
//		 return cliente;
//	 }
	 
	 @DeleteMapping("{id}")
	 public void delete(@PathVariable Integer id) {
		 this.clienteBo.delete(id);
	 }
	 
	 @GetMapping("listar")
	 public List<ClienteDTO> findAll(){
		return clienteBo.findAll(); 
	 }
	 
}
