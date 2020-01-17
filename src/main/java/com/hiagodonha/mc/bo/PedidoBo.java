package com.hiagodonha.mc.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiagodonha.mc.dao.PedidoDao;
import com.hiagodonha.mc.model.Pedido;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PedidoBo {

	@Autowired
	private PedidoDao pedidoDao;
	
	public Pedido bucar(Integer id) throws ObjectNotFoundException {
		 Optional<Pedido>obj = pedidoDao.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
