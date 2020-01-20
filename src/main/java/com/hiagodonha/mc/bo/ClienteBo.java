package com.hiagodonha.mc.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiagodonha.mc.dao.ClienteDao;
import com.hiagodonha.mc.model.Cliente;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteBo {

	@Autowired
	private ClienteDao categoriaDao;
	
	public Cliente find(Integer id) throws ObjectNotFoundException {
		 Optional<Cliente>obj = categoriaDao.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
