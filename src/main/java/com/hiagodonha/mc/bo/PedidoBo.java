package com.hiagodonha.mc.bo;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiagodonha.mc.dao.ItemPedidoDao;
import com.hiagodonha.mc.dao.PagamentoDao;
import com.hiagodonha.mc.dao.PedidoDao;
import com.hiagodonha.mc.exception.ObjectNotFoundException;
import com.hiagodonha.mc.model.ItemPedido;
import com.hiagodonha.mc.model.PagamentoComBoleto;
import com.hiagodonha.mc.model.Pedido;
import com.hiagodonha.mc.model.enums.EstadoPagamento;


@Service
public class PedidoBo {

	@Autowired
	private PedidoDao pedidoDao;
	@Autowired
	private BoletoService boletoService;
	@Autowired
	private PagamentoDao pagamentoDao;	
	@Autowired
	private ProdutoBo produtoBo;
	@Autowired
	private ItemPedidoDao itemPedidoDao;
	@Autowired
	private ClienteBo clienteBo;
	
	public Pedido find(Integer id) throws ObjectNotFoundException{
		 Optional<Pedido>obj = pedidoDao.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido pedido) {
		pedido.setId(null);
		pedido.setInstante(new Date()); //salvando o instante do pagamento
		pedido.setCliente(clienteBo.find(pedido.getCliente().getId()));
		pedido.getPagamento().setEstado(EstadoPagamento.PENDENTE); //tipo
		pedido.getPagamento().setPedido(pedido);
		
		if(pedido.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto)pedido.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, pedido.getInstante());	
		}
		pedido = pedidoDao.save(pedido); //salvando
		pagamentoDao.save(pedido.getPagamento()); //salvando
	
		for(ItemPedido ip : pedido.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoBo.find(ip.getProduto().getId()));
			ip.setPreco(produtoBo.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(pedido);
		}
		
		itemPedidoDao.saveAll(pedido.getItens());
		System.out.println(pedido);
		return pedido;
	}	
		
}
