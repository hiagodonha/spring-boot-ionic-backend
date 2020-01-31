package com.hiagodonha.mc.bo;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.hiagodonha.mc.model.PagamentoComBoleto;

@Service
public class BoletoService {

	public BoletoService() {
		
	}
	
	public void preencherPagamento (PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}

}
