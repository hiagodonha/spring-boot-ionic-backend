package com.hiagodonha.mc.bo;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiagodonha.mc.dao.ItemPedidoDao;
import com.hiagodonha.mc.dao.PagamentoDao;
import com.hiagodonha.mc.dao.PedidoDao;
import com.hiagodonha.mc.dao.ProdutoDao;
import com.hiagodonha.mc.model.ItemPedido;
import com.hiagodonha.mc.model.PagamentoComBoleto;
import com.hiagodonha.mc.model.Pedido;
import com.hiagodonha.mc.model.enums.EstadoPagamento;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PedidoBo {

	@Autowired
	private PedidoDao pedidoDao;
	@Autowired
	private BoletoService boletoService;
	@Autowired
	private PagamentoDao pagamentoDao;	
	@Autowired
	private ProdutoDao produtoDao;
	@Autowired
	private ItemPedidoDao itemPedidoDao;
	
	public Pedido find(Integer id) throws ObjectNotFoundException {
		 Optional<Pedido>obj = pedidoDao.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	public Pedido insert(Pedido pedido) {
		pedido.setInstante(new Date()); //salvando o instante do pagamento
		pedido.getPagamento().setEstado(EstadoPagamento.PENDENTE); //tipo
		pedido.getPagamento().setPedido(pedido);
		
		if(pedido.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto)pedido.getPagamento();
			boletoService.preencherPagamento(pagto, pedido.getInstante());	
		}
		pagamentoDao.save(pedido.getPagamento()); //salvando
		pedido = pedidoDao.save(pedido); //salvando
		for(ItemPedido ip : pedido.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoDao.findById(ip.getProduto().getId()).get().getPreco());
			ip.setPedido(pedido);
		}
		
		itemPedidoDao.saveAll(pedido.getItens());
		return pedido;
	}	
		
}
