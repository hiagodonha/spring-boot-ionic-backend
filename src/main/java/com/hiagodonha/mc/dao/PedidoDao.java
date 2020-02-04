package com.hiagodonha.mc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiagodonha.mc.model.Pedido;

@Repository
public interface PedidoDao extends JpaRepository<Pedido, Integer>{

}
