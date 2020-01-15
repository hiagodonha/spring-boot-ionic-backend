package com.hiagodonha.mc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.Pagamento;

@Repository
public interface PagamentoDao extends CrudRepository<Pagamento, Integer>{

}
