package com.hiagodonha.mc.model;

public class ItemPedido {
	
	private ItemPedidoPk itemPedidoPk;
	
	private Double desconto;
	
	private Integer quantidade;
	
	private Double preco;

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}  
}
