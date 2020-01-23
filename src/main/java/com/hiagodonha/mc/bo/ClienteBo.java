package com.hiagodonha.mc.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiagodonha.mc.dao.ClienteDao;
import com.hiagodonha.mc.dto.ClienteDTO;
import com.hiagodonha.mc.model.Cliente;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteBo {

	@Autowired
	private ClienteDao clienteDao;
	
	public Cliente find(Integer id) throws ObjectNotFoundException {
		 Optional<Cliente>obj = clienteDao.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public void delete(Integer id) {
		clienteDao.deleteById(id);
	}
	
	public List<ClienteDTO> findAll(){
		List<Cliente> list = clienteDao.findAll();
		List<ClienteDTO> listDto = new ArrayList<>();
		list.forEach( cli -> {
			listDto.add(new ClienteDTO(cli));
		});
		return listDto;
	}
	
}
