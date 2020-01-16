package com.hiagodonha.mc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.ItemPedido;
import com.hiagodonha.mc.model.ItemPedidoPk;

@Repository
public interface ItemPedidoDao extends CrudRepository<ItemPedido, ItemPedidoPk>{

}
