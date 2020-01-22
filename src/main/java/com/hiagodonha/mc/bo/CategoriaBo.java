package com.hiagodonha.mc.bo;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hiagodonha.mc.dao.CategoriaDao;
import com.hiagodonha.mc.dto.CategoriaDTO;
import com.hiagodonha.mc.exception.DataIntegrityException;
import com.hiagodonha.mc.exception.ObjectNotFoundException;
import com.hiagodonha.mc.model.Categoria;


@Service
public class CategoriaBo {

	@Autowired
	private CategoriaDao categoriaDao;
	
	public Categoria find(Integer id) {
		 Optional<Categoria>obj = categoriaDao.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria categoria) {
		return categoriaDao.save(categoria);
	}
	
	public Categoria update(Integer id, Categoria categoria) {
		find(id);
		return categoriaDao.save(categoria);
	}
	
	public List<Categoria> findAll(){
		return  categoriaDao.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoriaDao.findAll(pageRequest);
	}
	
	public void delete(Integer id) {
	try {
		 this.categoriaDao.deleteById(id);
		
		} catch (ConstraintViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}
	
	}
	
	public Categoria fromDTO(CategoriaDTO categoriaDto) {
		return new Categoria(categoriaDto.getId(), categoriaDto.getNome());
	}
}
