package com.hiagodonha.mc.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hiagodonha.mc.dao.ClienteDao;
import com.hiagodonha.mc.dto.ClienteDTO;
import com.hiagodonha.mc.exception.DataIntegrityException;
import com.hiagodonha.mc.exception.ObjectNotFoundException;
import com.hiagodonha.mc.model.Cliente;



@Service
public class ClienteBo {

	@Autowired
	private ClienteDao clienteDao;
	
	public Cliente find(Integer id) throws ObjectNotFoundException {
		 Optional<Cliente>obj = clienteDao.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public List<ClienteDTO> findAll(){
		List<Cliente> list = clienteDao.findAll();
		List<ClienteDTO> listDto = new ArrayList<>();
		list.forEach( cli -> {
			listDto.add(new ClienteDTO(cli));
		});
		return listDto;
	}
	
	public void delete(Integer id) {
		try {
			clienteDao.deleteById(id);
		}catch(ConstraintViolationException e) {
			throw new DataIntegrityException("Não é possível excluir cliente com telefone ou pedido");
		}
	}
	
	public Cliente update(Integer id, Cliente cliente) {
		Cliente newCliente = find(id);
		updateDate(newCliente, cliente);
		return clienteDao.save(newCliente);
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteDao.findAll(pageRequest);
	}
	
	
	public Cliente fromDTO(ClienteDTO clienteDto) {
		return new Cliente(clienteDto.getId(),clienteDto.getNome(), clienteDto.getEmail(), null, null);
	}
	
	private void updateDate(Cliente newCliente, Cliente cliente) {
		newCliente.setNome(cliente.getNome());
		newCliente.setEmail(cliente.getEmail());
	}
	
}
