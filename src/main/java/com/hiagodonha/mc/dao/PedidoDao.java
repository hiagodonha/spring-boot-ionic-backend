package com.hiagodonha.mc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.Pedido;

@Repository
public interface PedidoDao extends CrudRepository<Pedido, Integer>{

}
